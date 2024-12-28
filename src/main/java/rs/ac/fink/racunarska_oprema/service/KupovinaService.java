/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.service;

import java.sql.Connection;
import java.sql.SQLException;
import rs.ac.fink.racunarska_oprema.dao.KorisnikDao;
import rs.ac.fink.racunarska_oprema.dao.KupovinaDao;
import rs.ac.fink.racunarska_oprema.dao.ProizvodDao;
import rs.ac.fink.racunarska_oprema.dao.ResourceManager;
import rs.ac.fink.racunarska_oprema.data.Korisnik;
import rs.ac.fink.racunarska_oprema.data.Kupovina;
import rs.ac.fink.racunarska_oprema.data.Proizvod;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;


public class KupovinaService {
    
    private static final KupovinaService instance = new KupovinaService();

    private KupovinaService() {
    }

    public static KupovinaService getInstance() {
        return instance;
    }
    
    public Kupovina findKupovina(int id) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();

            return KupovinaDao.getInstance().find(id, con);
            
        } catch (SQLException ex) {
            throw new OpremaException("Failed to find purcahse with id " + id, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    }
    
    public void addKupovina(Korisnik korisnik, Proizvod proizvod) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();
            con.setAutoCommit(false);
            
            if (proizvod.getStanje_na_lageru() == 0) {
                throw new OpremaException("There are no more products " + proizvod.getNaziv() + " in the store.");
            }

            if (korisnik.getStanje_racuna() < proizvod.getCena()) {
                throw new OpremaException("Customer doesn't have enough money to make a purchase.");
            }


            
            int novoStanje = korisnik.getStanje_racuna() - proizvod.getCena();
            korisnik.setStanje_racuna(novoStanje);
            KorisnikDao.getInstance().updateStanje(korisnik, con);
            
            int novoPotroseno = korisnik.getKolicina_potrosenog_novca() + proizvod.getCena();
            korisnik.setKolicina_potrosenog_novca(novoPotroseno);
            KorisnikDao.getInstance().updateKolicinaPotrosenog(korisnik, con);

            proizvod.setStanje_na_lageru(proizvod.getStanje_na_lageru() - 1);
            ProizvodDao.getInstance().update(proizvod, con);
            
            
            
            Kupovina kupovina = new Kupovina(korisnik, proizvod);
            KupovinaDao.getInstance().insert(kupovina, con);

            con.commit();
            
        } catch (SQLException ex) {
            ResourceManager.rollbackTransactions(con);
            throw new OpremaException("Failed to add new kupovina. Korisnik id is " + korisnik + "\n" + proizvod, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    } 
}
