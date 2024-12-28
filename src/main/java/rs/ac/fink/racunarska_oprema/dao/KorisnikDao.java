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

public class KorisnikDao {
    
    private static final KorisnikDao instance = new KorisnikDao();

    private KorisnikDao() {
    }

    public static KorisnikDao getInstance() {
        return instance;
    }
    
     public Korisnik findById(int id, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Korisnik korisnik = null;
        try {
            ps = con.prepareStatement("SELECT * FROM korisnik where korisnik_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                korisnik = new Korisnik(id ,rs.getString("ime_i_prezime"), rs.getString("username"), rs.getString("e_mail"), rs.getString("datum_rodjenja"), rs.getInt("stanje_racuna"),rs.getInt("kolicina_potrosenog_novca"), rs.getString("password"));
            }
        } finally {
            ResourceManager.closeResources(rs, ps);
        }
        return korisnik;
    }
    
     public Korisnik find(String username, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Korisnik korisnik = null;
        try {
            ps = con.prepareStatement("SELECT * FROM korisnik where username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                korisnik = new Korisnik(rs.getInt("korisnik_id") ,rs.getString("ime_i_prezime"), rs.getString("username"), rs.getString("e_mail"), rs.getString("datum_rodjenja"), rs.getInt("stanje_racuna"),rs.getInt("kolicina_potrosenog_novca"),rs.getString("password"));
                
            }
        } finally {
            ResourceManager.closeResources(rs, ps);
        }
        return korisnik;
    }
    
    public void insert(Korisnik korisnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = con.prepareStatement("INSERT INTO korisnik(ime_i_prezime, username, e_mail, datum_rodjenja, stanje_racuna, kolicina_potrosenog_novca, password) VALUES(?,?,?,?,?,?,?)");
            ps.setString(2, korisnik.getUsername());
            ps.setString(1, korisnik.getIme_i_prezime());
            ps.setString(3, korisnik.getE_mail());
            ps.setString(4, korisnik.getDatum_rodjenja());
            ps.setInt(5, korisnik.getStanje_racuna());
            ps.setInt(6, korisnik.getKolicina_potrosenog_novca());
            ps.setString(7, korisnik.getPassword());
            ps.executeUpdate();

        } finally {
            ResourceManager.closeResources(rs, ps);
        }
    }
    
    public void updateStanje(Korisnik korisnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement("UPDATE korisnik SET stanje_racuna=? WHERE korisnik_id=?");
            ps.setInt(1, korisnik.getStanje_racuna());
            ps.setInt(2, korisnik.getKorisnik_id());
            ps.executeUpdate();
        } finally {
            ResourceManager.closeResources(null, ps);
        }
    }
    
    public void updateKolicinaPotrosenog(Korisnik korisnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement("UPDATE korisnik SET kolicina_potrosenog_novca=? WHERE korisnik_id=?");
            ps.setInt(1, korisnik.getKolicina_potrosenog_novca());
            ps.setInt(2, korisnik.getKorisnik_id());
            ps.executeUpdate();
        } finally {
            ResourceManager.closeResources(null, ps);
        }
    }
    
    public boolean Login(String username, String password, Connection con) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement("SELECT password FROM korisnik WHERE username = ?");
        ps.setString(1, username);
        rs = ps.executeQuery();

        if (rs.next()) {
            String originalPassword = rs.getString("password");
            return originalPassword.equals(password);
        }
    } finally {
        ResourceManager.closeResources(rs, ps);
    }
    return false;
    }
    
    
    
}
