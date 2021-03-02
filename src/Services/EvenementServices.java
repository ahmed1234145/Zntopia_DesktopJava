/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Evenement;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class EvenementServices {
    private Connection con;
    private Statement ste;

    public EvenementServices() {
        con = ConnectionDB.getInstance().getCnx();

    }
    
     public void ajouter(Evenement e) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `First`.`Evenement` (`Id`, `Nom`, `Organisateur`, `Date_Debut`, `Date_Fin`, `Type`) VALUES (NULL, '"+ e.getId() + "', '" + e.getNom() + "', '" + e.getOrganisateur() + "', '" + e.getDate_Debut() + "', '" + e.getDate_Fin() + "', '" + e.getType()  + "');";
        
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Evenement e) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `First`.`Evenement` (`Id`, `Nom`, `Organisateur`, `Date_Debut`, `Date_Fin`, `Type`) VALUES (?, ?, ?, ?, ?, ?);");
    pre.setString(1, e.getId());
    pre.setString(2, e.getNom());
    pre.setString(3, e.getOrganisateur());
    pre.setDate(4, (java.sql.Date) e.getDate_Debut());
    pre.setDate(5, (java.sql.Date) e.getDate_Fin());
    pre.setString(6,  e.getType());
    
    pre.executeUpdate();
    }
    
   public ObservableList<Evenement> getEvenementList() {
        ObservableList<Evenement> EvenementList = FXCollections.observableArrayList();
        
      
        try {
            ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from Evenement");
             while (rs.next()) {
            String id = rs.getString("Id");
            String Nom = rs.getString("Nom");
            String Organisateur = rs.getString("Organisateur");
            Date Date_Debut = rs.getDate("Date_Debut");
            Date Date_Fin = rs.getDate("Date_Fin");
            String Type = rs.getString("Type");
            
          
           
           Evenement e=new Evenement(id, Nom, Type, Organisateur, Date_Debut, Date_Fin);
           EvenementList.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
return EvenementList;
    
}
    
}
