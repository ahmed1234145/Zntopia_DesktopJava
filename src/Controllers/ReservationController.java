/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Evenement;
import Services.EvenementServices;
import Utils.ConnectionDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class ReservationController implements Initializable{
   @FXML
    private AnchorPane AdminDashBoardP;

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
    private TableView<Evenement> tableEvenements;

    @FXML
    private TableColumn<?, ?> c_id;

    @FXML
    private TableColumn<?, ?> c_nom;

    @FXML
    private TableColumn<?, ?> c_Organisateur;

    @FXML
    private TableColumn<?, ?> c_Date_Deb;

    @FXML
    private TableColumn<?, ?> c_Date_Fin;

    @FXML
    private TableColumn<?, ?> c_type;

    @FXML
    private ImageView btnDelete;


    private JFXTextField ResID;

    private JFXTextField IdRes;
    private JFXTextField TypersEv;
    private JFXTextField NomEvRes;
    @FXML
    private JFXTextField Matricule;
    @FXML
    private JFXButton res;
    @FXML
    private JFXTextField IdReservation;
    @FXML
    private JFXTextField TypeResEv;
    @FXML
    private JFXTextField NomEvReservation;


    @FXML
    void MouseAction(MouseEvent event) {
        Evenement evnt = tableEvenements.getSelectionModel().getSelectedItem();
        TypeResEv.setText(evnt.getType());
        NomEvReservation.setText(evnt.getNom());
    }


    public void initData(String Matricule2) {
        Matricule.setText(Matricule2);
    }  

    @FXML
    void handleClick(ActionEvent event) {
        
    }
    
    
   
     @FXML
    void Mreserv(ActionEvent event) throws Exception{
            Stage stage = (Stage) AdminDashBoardP.getScene().getWindow();   
            Stage stage1 = new Stage();
                stage.close();
            try { 
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("GUI/MesReservation.fxml"));
                Parent root1 = (Parent) loader.load();
                MesReservationController setController = loader.getController();
                setController.initData(Matricule.getText());
                stage1.setScene(new Scene(root1));
                stage1.initStyle(StageStyle.UNDECORATED);
                stage1.show();
            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
     
       }             
                    
    @FXML
    void handleMouseButton(MouseEvent event) {
    }
    
    private final Connection con = ConnectionDB.getInstance().getCnx();
   
    public void ShowEvents(){     
    ObservableList<Evenement> Evenementlist1 = FXCollections.observableArrayList();
    EvenementServices es1 = new EvenementServices();
    ObservableList<Evenement> list1 = es1.getEvenementList();
        c_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        c_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        c_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        c_Organisateur.setCellValueFactory(new PropertyValueFactory<>("Organisateur"));
        c_Date_Deb.setCellValueFactory(new PropertyValueFactory<>("Date_Debut"));
        c_Date_Fin.setCellValueFactory(new PropertyValueFactory<>("Date_Fin"));
         tableEvenements.setItems(list1);
     }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ShowEvents();
    }

    
    @FXML
    void reserver(ActionEvent event) {
        Connection conn = null;
        Statement stmt = null ;
        String SQL= "INSERT INTO Reservation values ('"+IdReservation.getText()+"','"+NomEvReservation.getText()+"','"+TypeResEv.getText()+"','"+Matricule.getText()+"')";
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/First","root","");
            stmt=conn.createStatement();                    
            try{
                 if (IdReservation.getText().isEmpty() || NomEvReservation.getText().isEmpty() || TypeResEv.getText().isEmpty() || Matricule.getText().isEmpty() )
                               JOptionPane.showMessageDialog(null, "champ vide ");                              
                            else {
                                stmt.executeUpdate(SQL);
                                JOptionPane.showMessageDialog(null, "succes");
                                }
                       } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Email Existant");}                     
            
        }catch (SQLException e) {
                e.printStackTrace();}
            catch (ClassNotFoundException e) {
                e.printStackTrace();            }
    }
}
