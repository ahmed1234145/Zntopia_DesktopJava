/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
 *
 * @author MSI
 */
public class LoginClientController {

    @FXML
    private ImageView btnBack;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnReduce;
    @FXML
    private Pane paneLogin;
    @FXML
    private AnchorPane MentorPane;
    @FXML
    private JFXTextField username;
    
    @FXML
    private JFXButton SignIn;
    @FXML
    private JFXTextField Matricule;

    @FXML
    private void handleMouseButton(MouseEvent event) {
    }

    @FXML
    private void SignIN(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null ;
        ResultSet rs=null;   
 
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/First","root","");
            stmt=conn.createStatement();
        
                if ( username.getText().isEmpty() || Matricule.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "champ vide");
                else{
                String SQL= "Select * from Client where username='"+username.getText()+"'and Matricule='"+Matricule.getText()+"' ";
                rs= stmt.executeQuery(SQL);
                if(rs.next()){ 
                    JOptionPane.showMessageDialog(null, "succes");
                    
     Stage stage = (Stage) MentorPane.getScene().getWindow();   
            Stage stage2 = new Stage();
                stage.close();
            try { 
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("GUI/EvenementReservation.fxml"));
                Parent root1 = (Parent) loader.load();
                ReservationController setController = loader.getController();
                setController.initData(Matricule.getText());
                stage2.setScene(new Scene(root1));
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.show();

            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
}
