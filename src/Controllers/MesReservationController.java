/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Evenement;
import Entities.Reservation;
import Services.EvenementServices;
import Services.ReservationService;
import Utils.ConnectionDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class MesReservationController implements Initializable{

    @FXML
    private Button ListeEvents;
    @FXML
    private Button MesResrvations;
    @FXML
    private Button Logout;
    @FXML
    private ImageView btnReduce;
    @FXML
    private ImageView btnClose;
    @FXML
    private Pane pnlStatus;
    @FXML
    private Label lbltitle;
    @FXML
    private ImageView btnDelete;
    @FXML
    private TableView<Reservation> TableReservation;
    @FXML
    private TableColumn<?, ?> IdReservation;
    @FXML
    private TableColumn<?, ?> NomEveResr;
    @FXML
    private TableColumn<?, ?> TyprEveRes;
    @FXML
    private JFXTextField Mat;
    @FXML
    private JFXButton valid;
    @FXML
    private JFXButton Supp;
    @FXML
    private JFXButton Relod;
    @FXML
    private AnchorPane ReservationDash;

    @FXML
    private void handleClick(ActionEvent event) {
    }

    @FXML
    private void handleMouseButton(MouseEvent event) {
    }
    private final Connection con = ConnectionDB.getInstance().getCnx();
   
    public void showEvents(){
        ObservableList<Reservation> Reservationlist = FXCollections.observableArrayList(); 
        ReservationService rs = new ReservationService();
        ObservableList<Reservation> list = rs.getReservationList();
        IdReservation.setCellValueFactory(new PropertyValueFactory<>("IdRes"));
        NomEveResr.setCellValueFactory(new PropertyValueFactory<>("NomEvRes"));
        TyprEveRes.setCellValueFactory(new PropertyValueFactory<>("TypeEvRes"));
        TableReservation.setItems(list);
    }
    
    void valider(ActionEvent event) {
    }
        
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
          showEvents();    
                  
    }

    public void initData(String Matricule3) {
        Mat.setText(Matricule3);
        }  

    @FXML
    private void Suprim(ActionEvent event) {
        Connection conn = null;
        Statement stmt = null ;
        ResultSet rs=null;
        Reservation resv = TableReservation.getSelectionModel().getSelectedItem();
        String SQL= "DELETE FROM Reservation WHERE IdRes = "+resv.getIdRes() +"";
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
    private void Reloded(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/MesReservation.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage4 = (Stage) ReservationDash.getScene().getWindow();
        stage4.getScene().setRoot(root);
    }

    
}
