/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rs.ac.fink.racunarska_oprema.data.Korisnik;
import rs.ac.fink.racunarska_oprema.data.Kupovina;
import rs.ac.fink.racunarska_oprema.data.Proizvod;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;


public class KupovinaDao {
    
    private static final KupovinaDao instance = new KupovinaDao();

    private KupovinaDao() {
    }

    public static KupovinaDao getInstance() {
        return instance;
    }
    
    
    public Kupovina find(int id, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Kupovina kupovina = null;
        try {
            ps = con.prepareStatement("SELECT * FROM kupovina where kupovina_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Korisnik korisnik = KorisnikDao.getInstance().findById(rs.getInt("korisnik_id"), con);
                Proizvod proizvod = ProizvodDao.getInstance().findById(rs.getInt("proizvod_id"), con);
                kupovina = new Kupovina(korisnik, proizvod);
            }
        } finally {
            ResourceManager.closeResources(rs, ps);
        }
        return kupovina;
    }
    
    public int insert(Kupovina kupovina, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        try {
            ps = con.prepareStatement("INSERT INTO kupovina(korisnik_id, proizvod_id) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, kupovina.getKorisnik().getKorisnik_id());
            ps.setInt(2, kupovina.getProizvod().getProizvod_id());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } finally {
            ResourceManager.closeResources(rs, ps);
        }
        return id;
    }
    
}
