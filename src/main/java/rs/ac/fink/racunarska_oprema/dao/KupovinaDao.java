/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rs.ac.fink.racunarska_oprema.data.Korisnik;
import rs.ac.fink.racunarska_oprema.data.Kupovina;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;


public class KupovinaDao {
    
    private static final KupovinaDao instance = new KupovinaDao();

    private KupovinaDao() {
    }

    public static KupovinaDao getInstance() {
        return instance;
    }
    
    public void insert(Kupovina kupovina, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = con.prepareStatement("INSERT INTO kupovina(korisnik_id, proizvod_id) VALUES(?,?)");
            ps.setInt(1, kupovina.getKorisnik().getKorisnik_id());
            ps.setInt(2, kupovina.getProizvod().getProizvod_id());
            ps.executeUpdate();

        } finally {
            ResourceManager.closeResources(rs, ps);
        }
    }
    
}
