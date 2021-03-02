/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Evenement;
import Services.EvenementServices;
import Utils.ConnectionDB;
import animatefx.animation.FadeIn;
import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *

 */
public class AjoutEvenementController implements Initializable {

    @FXML
    private JFXButton btnSignUp;
    @FXML
    private Pane paneLogin;
    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXTextField txtpassword;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private Pane paneSignUp;
    @FXML
    private JFXButton BTNSignIn;
    @FXML
    private AnchorPane ClientPane;
    @FXML
    private JFXButton btnReset;
    @FXML
    private ImageView btnBack;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnReduce;
 
    @FXML
    private JFXButton BTNSignIn1;
    @FXML
    private Hyperlink ForgotPass;
    @FXML
    private Pane paneForgotPass;
    @FXML
    private JFXButton btnSignIn1;
    
    @FXML
    private JFXTextField Id_evenement;

    @FXML
    private JFXTextField Nom_Evenement;

    @FXML
    private JFXTextField Organisateur;

    @FXML
    private JFXTextField Type_Evenement;

    @FXML
    private JFXDatePicker DateDeb_Evenement;

    @FXML
    private JFXDatePicker DateFin_Evenement;

private boolean update;
    @FXML
    private Pane AjoutEvenement;
    @FXML
    private JFXButton Ajouter;
        
    @FXML
     private void handleButtonAction(ActionEvent event) {         
        if (event.getSource()== btnSignUp)
        {
            new FadeIn(paneSignUp).play();
            paneSignUp.toFront();
        }
        if (event.getSource() == btnSignIn1) 
        {
            new FadeIn(paneLogin).play();
            paneLogin.toFront();
        }
         if (event.getSource() == btnSignIn) 
        {
            new FadeIn(paneLogin).play();
            paneLogin.toFront();
        }
         
          if (event.getSource() == ForgotPass) 
        {
            new FadeIn(paneForgotPass).play();
            paneForgotPass.toFront();
        }
           
         
    }
     
    @FXML
     private void handleMouseButton(MouseEvent event) {
         Stage stage = (Stage) ClientPane.getScene().getWindow();
        
        if (event.getSource().equals(btnBack)){
            Stage stage2 = new Stage();
            stage.close();
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/Index.fxml")); 
                    Scene scene = new Scene(root);
                    stage2.setScene(scene); 
                    stage2.initStyle(StageStyle.UNDECORATED);
                    stage2.show();
                    
                } catch (IOException ex) {
                    Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        if (event.getSource().equals(btnReduce)){
          
      
          stage.setIconified(true);
        }
        
        if (event.getSource().equals(btnClose)) 
        {
            System.exit(0);           
        }
     }
     
     
     
     @FXML
    void Ajouter(ActionEvent event) throws SQLException {
        Connection conn = null;
        Statement stmt = null ;
        ResultSet rs=null;
        LocalDate Datedeb = DateDeb_Evenement.getValue();
        LocalDate Datefin = DateFin_Evenement.getValue();
        String SQL= "insert INTO Evenement ( Id, Nom, Organisateur, Date_Debut, Date_Fin, Type ) values ('"+Id_evenement.getText()+"','"+Nom_Evenement.getText()+"','"+Organisateur.getText()+"','"+Datedeb+"','"+Datefin+"','"+Type_Evenement.getText()+"')";  
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/First","root","");
            stmt=conn.createStatement();
                               
            try{
                 if (Id_evenement.getText().isEmpty() || Nom_Evenement.getText().isEmpty() || Organisateur.getText().isEmpty() || Type_Evenement.getText().isEmpty() )
                               JOptionPane.showMessageDialog(null, "champ vide ");                              
                            else {
                                stmt.executeUpdate(SQL);
                                JOptionPane.showMessageDialog(null, "succes");
                                Id_evenement.setText("");
                                Nom_Evenement.setText("");
                                Organisateur.setText("");
                                Type_Evenement.setText("");}
                       } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Email Existant");}                     
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
            
    

    
     
     
    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    
}
