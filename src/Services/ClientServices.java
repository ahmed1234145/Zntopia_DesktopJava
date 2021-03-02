/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Client;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ClientServices {
    private Connection con;
    private Statement ste;

    public ClientServices() {
        con = ConnectionDB.getInstance().getCnx();

    }
    
     public void ajouter(Client c) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `zentopia`.`client` (`id_client`, `username`, `email`, `password`, `nom`, `prenom`, `dateNai`, `tel`, `adresse`) VALUES (NULL, '"+ c.getUsername() + "', '" + c.getEmail() + "', '" + c.getPassword() + "', '" + c.getNom() + "', '" + c.getPrenom() + "', '" + c.getDateNai() + "', '" + c.getTel() + "', '" + c.getAdresse() + "');";
        
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Client c) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `zentopia`.`client` (`username`, `email`, `password`, `nom`, `prenom`, `dateNai`, `tel`, `adresse`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
    pre.setString(1, c.getUsername());
    pre.setString(2, c.getEmail());
    pre.setString(3, c.getPassword());
    pre.setString(4, c.getNom());
    pre.setString(5, c.getPrenom());
    pre.setDate(6, (java.sql.Date) c.getDateNai());
    pre.setString(7, c.getTel());
    pre.setString(8, c.getAdresse());
    pre.executeUpdate();
    }
    
   public ObservableList<Client> getClientList() {
        ObservableList<Client> ClientList = FXCollections.observableArrayList();
        
      
        try {
            ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from client");
             while (rs.next()) {
            int id = rs.getInt("id_client");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Date dateNai = rs.getDate("dateNai");
           String tel = rs.getString("tel");
           String adresse = rs.getString("adresse");
           
           Client c=new Client(id, username, email, password, nom, prenom, dateNai, tel, adresse);
           ClientList.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
return ClientList;
    
}
}
