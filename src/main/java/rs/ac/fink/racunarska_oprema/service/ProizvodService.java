/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.service;

import java.sql.Connection;
import java.sql.SQLException;
import rs.ac.fink.racunarska_oprema.dao.ProizvodDao;
import rs.ac.fink.racunarska_oprema.dao.ResourceManager;
import rs.ac.fink.racunarska_oprema.data.Proizvod;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;

public class ProizvodService {
    
    private static final ProizvodService instance = new ProizvodService();

    private ProizvodService() {
    }

    public static ProizvodService getInstance() {
        return instance;
    }
    
    public Proizvod findProizvodByName(String name) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();

            return ProizvodDao.getInstance().findByName(name, con);
            
        } catch (SQLException ex) {
            throw new OpremaException("Failed to find product with name " + name, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    }
    
    public Proizvod findProizvodByVrsta(String vrsta) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();

            return ProizvodDao.getInstance().findByVrsta(vrsta, con);
            
            
        } catch (SQLException ex) {
            throw new OpremaException("Failed to find product with vrsta " + vrsta, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    }
}
