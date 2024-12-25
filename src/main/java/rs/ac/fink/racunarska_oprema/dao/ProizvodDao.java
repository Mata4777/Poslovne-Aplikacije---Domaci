/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rs.ac.fink.racunarska_oprema.data.Proizvod;

public class ProizvodDao {
    
    private static final ProizvodDao instance = new ProizvodDao();

    private ProizvodDao() {
    }

    public static ProizvodDao getInstance() {
        return instance;
    }
    
    
    public Proizvod findByName(String naziv, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Proizvod proizvod = null;
        try {
            ps = con.prepareStatement("SELECT * FROM proizvod where naziv=?");
            ps.setString(1, naziv);
            rs = ps.executeQuery();
            if (rs.next()) {
                proizvod = new Proizvod(rs.getInt("proizvod_id"), naziv, rs.getInt("cena"), rs.getString("vrsta_opreme"), rs.getInt("stanje_na_lageru"));
            }
        } finally {
            ResourceManager.closeResources(rs, ps);
        }
        return proizvod;
    }
    
    public Proizvod findByVrsta(String vrsta, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Proizvod proizvod = null;
        try {
            ps = con.prepareStatement("SELECT * FROM proizvod where vrsta_opreme=?");
            ps.setString(1, vrsta);
            rs = ps.executeQuery();
            if (rs.next()) {
                proizvod = new Proizvod(rs.getInt("proizvod_id"), rs.getString("naziv"), rs.getInt("cena"), vrsta, rs.getInt("stanje_na_lageru"));
            }
        } finally {
            ResourceManager.closeResources(rs, ps);
        }
        return proizvod;
    }
    
    public void insert(Proizvod proizvod, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = con.prepareStatement("INSERT INTO proizvod(naziv, cena, vrsta_opreme, stanje_na_lageru) VALUES(?,?,?,?)");
            ps.setString(1, proizvod.getNaziv());
            ps.setInt(2, proizvod.getCena());
            ps.setString(3, proizvod.getVrsta_opreme());
            ps.setInt(4, proizvod.getStanje_na_lageru());
            ps.executeUpdate();

        } finally {
            ResourceManager.closeResources(rs, ps);
        }
    }
}
