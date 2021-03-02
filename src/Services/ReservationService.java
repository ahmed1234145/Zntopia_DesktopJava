/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Evenement;
import Entities.Reservation;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MSI
 */
public class ReservationService {
    
    private Connection con;
    private Statement ste;

    public ReservationService() {
        con = ConnectionDB.getInstance().getCnx();

    }
    
     
    
   public ObservableList<Reservation> getReservationList() {
        ObservableList<Reservation> ReservationList = FXCollections.observableArrayList();
        
      
        try {
            ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from Reservation");
             while (rs.next()) {
            String IdRes = rs.getString("IdRes");
            String NomEvRes = rs.getString("NomEvRes");
            String TypeEvRes = rs.getString("TypeEvRes");
            
            String MatriculeClient = rs.getString("MatriculeClient");
            
         
           
           Reservation r =new Reservation(IdRes, NomEvRes, TypeEvRes, MatriculeClient);
           ReservationList.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
return ReservationList;
    
}
    
    
}
