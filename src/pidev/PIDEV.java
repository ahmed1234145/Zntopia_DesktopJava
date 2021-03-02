/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author leila
 */
public class PIDEV extends Application {
    public static Stage primaryStage = null;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/LoginClient.fxml"));
      Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AdminDashBoard.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
  



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

   
    
}

