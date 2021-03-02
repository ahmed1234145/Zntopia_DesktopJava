/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author leila
 */

public class LoginMentorController implements Initializable {
    @FXML
    private JFXComboBox<String> role;
    @FXML
    private AnchorPane MentorPane;
    @FXML
    private Pane paneLogin;
    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXTextField txtpassword;
    @FXML
    private JFXButton BTNSignIn;
    @FXML
    private ImageView btnBack;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnReduce;
    /**
     * Initializes the controller class.
     */
    
    @FXML
         private void handleMouseButton(MouseEvent event) {
         Stage stage = (Stage) MentorPane.getScene().getWindow();
        Stage stage2 = new Stage();
        if (event.getSource().equals(btnBack)){
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
     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        role.getItems().add("CHEF");
        role.getItems().add("COACH");
    }    
    
}
