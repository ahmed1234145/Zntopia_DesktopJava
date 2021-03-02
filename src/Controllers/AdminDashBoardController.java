/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.AjoutEvenementController;
import Controllers.IndexController;
import Entities.Client;
import Entities.Evenement;
import Services.ClientServices;
import Services.EvenementServices;
import Utils.ConnectionDB;
import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 
 */
public class AdminDashBoardController implements Initializable {

    
    @FXML
    private AnchorPane ClientPane;
    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnReduce;
    @FXML
    private AnchorPane AdminDashBoardPane;
    @FXML
    private Button btnClients;
    @FXML
    private Button btnMentors;
    @FXML
    private Button btnRecettes;
    @FXML
    private Button btnExercices;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnLogout;
    @FXML
    private JFXButton btnAddClient;
    @FXML
    private Label lbltitle;
    @FXML
    private Button btnArticles;
    @FXML
    private Pane pnlStatus;
    @FXML
    private JFXButton btnSearchClient1;
    
    @FXML
    private TableView<Evenement> tableEvenement;
    
    @FXML
    private TableColumn<Evenement, String> cd_id;
    @FXML
    private TableColumn<Evenement, String> cd_nom;
    @FXML
    private TableColumn<Evenement, String> cd_Organisateur;
    @FXML
    private TableColumn<Evenement, Date> cd_Date_Deb;
    @FXML
    private TableColumn<Evenement, Date> cd_Date_Fin;
    @FXML
    private TableColumn<Client, String> cd_type;
    @FXML
    private TableColumn<Client, String> Action;
    @FXML
    private ImageView btnBack;
   
    @FXML
    private ImageView btnModify;
   
    @FXML
    private ImageView btnDelete;
    
    private final Connection con = ConnectionDB.getInstance().getCnx();
    ObservableList<Evenement> Evenementlist = FXCollections.observableArrayList(); 
    EvenementServices es = new EvenementServices();
    ObservableList<Evenement> list = es.getEvenementList();
    
     public void ShowEvents(){   
        cd_id.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Id"));
        cd_nom.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Nom"));
        cd_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        cd_Organisateur.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Organisateur"));
        cd_Date_Deb.setCellValueFactory(new PropertyValueFactory<Evenement, Date>("Date_Debut"));
        cd_Date_Fin.setCellValueFactory(new PropertyValueFactory<Evenement, Date>("Date_Fin"));
        tableEvenement.setItems(list); 
     }
   
     @FXML
    private JFXButton Update;

    @FXML
    private JFXButton Delete;

    @FXML
    void Delete(ActionEvent event) {
        Connection conn = null;
        Statement stmt = null ;
        ResultSet rs=null;
        Evenement ev = tableEvenement.getSelectionModel().getSelectedItem();
        String SQL= "DELETE FROM Evenement WHERE Id = "+ev.getId() +"";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/First","root","");
            stmt=conn.createStatement();                       
            try{
                                stmt.executeUpdate(SQL);
                                JOptionPane.showMessageDialog(null, "succes"); 
                       } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Probleme");}                     
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }

    @FXML
    void Update(ActionEvent event) {
        Connection conn = null;
        Statement stmt = null ;
        ResultSet rs=null;
        LocalDate dtdeb = DateDebutField.getValue();
        LocalDate dtfin = DateFinField.getValue();
        String SQL1= "UPDATE Evenement SET Id ='"+Identifiant.getText() +"',Nom='"+NomField.getText()+"',Organisateur='"+OrganisateurField.getText()+"',Type='"+TypeField.getText()+"',Date_Debut='"+dtdeb+"',Date_Fin='"+dtfin+"' WHERE Id = '"+Identifiant.getText()+"' ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/First","root","");
            stmt=conn.createStatement();                  
            try{
                                stmt.executeUpdate(SQL1);
                                initialize(null, null);
                                JOptionPane.showMessageDialog(null, "Mise à jour avec succes");
                                tableEvenement.setItems(list);
                       } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "non effectue");}                     
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private JFXTextField OrganisateurField;

    @FXML
    private JFXDatePicker DateFinField;

    @FXML
    private JFXTextField TypeField;

    @FXML
    private JFXTextField NomField;

    @FXML
    private JFXDatePicker DateDebutField;

    @FXML
    private JFXTextField Identifiant;
 
    
    @FXML
    void MouseAction(MouseEvent event) {
        Evenement evnt = tableEvenement.getSelectionModel().getSelectedItem();
        Identifiant.setText(evnt.getId());
        NomField.setText(evnt.getNom());
        OrganisateurField.setText(evnt.getOrganisateur());
        TypeField.setText(evnt.getType());

    } 
     /* Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ShowEvents();   
    }    
    
    @FXML
    private JFXButton AjoutEvenement;

    @FXML
    void Ajout_Evenement(ActionEvent event) {
        Stage stage = (Stage) AdminDashBoardPane.getScene().getWindow();
        Stage stage2 = new Stage();            
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AjoutEvenement.fxml")); 
                    Scene scene = new Scene(root);
                    stage2.setScene(scene); 
                    stage2.initStyle(StageStyle.UTILITY);
                    stage2.show();
                } catch (IOException ex) {
                    Logger.getLogger(AjoutEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        
 @FXML
    void Reload(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/AdminDashBoard.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) AdminDashBoardPane.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    
   

    
   
    
    @FXML
    private void handleClick (ActionEvent event){
        Stage stage = (Stage) AdminDashBoardPane.getScene().getWindow();
   
        if (event.getSource() == btnClients){
            new FadeIn(pnlStatus).play();
            
            lbltitle.setText("Gestion des Clients");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(138, 215, 138),CornerRadii.EMPTY, Insets.EMPTY)));
          
             }
        
        else if (event.getSource() == btnMentors){
            new FadeIn(pnlStatus).play();
            lbltitle.setText("Gestion des Mentors");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(138, 215, 138),CornerRadii.EMPTY, Insets.EMPTY)));
          
             }
         
        else if (event.getSource() == btnRecettes){
            new FadeIn(pnlStatus).play();
            lbltitle.setText("Gestion des Recettes");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(138, 215, 138),CornerRadii.EMPTY, Insets.EMPTY)));
             }
          
          
        else if (event.getSource() == btnExercices){
            new FadeIn(pnlStatus).play();
            lbltitle.setText("Gestion des Exercices");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(138, 215, 138),CornerRadii.EMPTY, Insets.EMPTY)));
             }
           
        else if (event.getSource() == btnEvent){
            new FadeIn(pnlStatus).play();
            lbltitle.setText("Gestion des Event");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(138, 215, 138),CornerRadii.EMPTY, Insets.EMPTY)));
             }
        
         else if (event.getSource() == btnArticles){
             new FadeIn(pnlStatus).play();
            lbltitle.setText("Gestion des Articles");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(138, 215, 138),CornerRadii.EMPTY, Insets.EMPTY)));
             }
         
        else if (event.getSource() == btnLogout){
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
        
       
        
        }
    
    
    
        

    @FXML
    private void handleMouseButton(MouseEvent event) {
        
        if (event.getSource().equals(btnReduce)){
          Stage stage = (Stage) AdminDashBoardPane.getScene().getWindow();
      
          stage.setIconified(true);
        }
        
        if (event.getSource().equals(btnClose)) 
        {
            System.exit(0);           
        }
    
    }
    
}
