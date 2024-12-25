/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.racunarska_oprema.service;

import java.sql.Connection;
import java.sql.SQLException;
import rs.ac.fink.racunarska_oprema.dao.KupovinaDao;
import rs.ac.fink.racunarska_oprema.dao.ResourceManager;
import rs.ac.fink.racunarska_oprema.data.Kupovina;
import rs.ac.fink.racunarska_oprema.exception.OpremaException;


public class KupovinaService {
    
    
    
    public void addKupovina(Kupovina kupovina) throws OpremaException {
        Connection con = null;
        try {
            con = ResourceManager.getConnection();

            //more than one SQL statement to execute, needs to be a single transaction
            con.setAutoCommit(false);

            KupovinaDao.getInstance().insert(kupovina, con);

            con.commit();
        } catch (SQLException ex) {
            ResourceManager.rollbackTransactions(con);
            throw new OpremaException("Failed to add new kupovina" + kupovina, ex);
        } finally {
            ResourceManager.closeConnection(con);
        }
    } 
}
