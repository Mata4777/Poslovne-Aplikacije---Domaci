package rs.ac.fink.racunarska_oprema.service;

import java.sql.Connection;
import java.sql.SQLException;
import rs.ac.fink.racunarska_oprema.dao.ResourceManager;
import rs.ac.fink.racunarska_oprema.dao.KorisnikDao;
import rs.ac.fink.racunarska_oprema.data.Korisnik;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;

public class KorisnikService {
    
    private static final KorisnikService instance = new KorisnikService();

    private KorisnikService() {
    }

    public static KorisnikService getInstance() {
        return instance;
    }
    
    public Korisnik findKorisnik(String username) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();

            return KorisnikDao.getInstance().find(username, con);
            

        } catch (SQLException ex) {
            throw new OpremaException("Failed to find customer with username " + username, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    }
    
    public void addNewKorisnik(Korisnik korisnik) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();

            
            con.setAutoCommit(false);

            KorisnikDao.getInstance().insert(korisnik, con);

            con.commit();
        } catch (SQLException ex) {
            ResourceManager.rollbackTransactions(con);
            throw new OpremaException("Failed to add new customer " + korisnik, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    }
    
    public void updateStanje(Korisnik korisnik) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();
            con.setAutoCommit(false);

            KorisnikDao.getInstance().updateStanje(korisnik, con);

            con.commit();
        } catch (SQLException ex) {
            ResourceManager.rollbackTransactions(con);
            throw new OpremaException("Failed to update product " + korisnik, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    }
    
    
    public boolean login(String username, String password) throws OpremaException {
        Connection con = null;

        try {
            con = ResourceManager.getConnection();
            return KorisnikDao.getInstance().Login(username, password, con);
        } catch (SQLException ex) {
         throw new OpremaException("Failed to validate login for user " + username, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    }
}
