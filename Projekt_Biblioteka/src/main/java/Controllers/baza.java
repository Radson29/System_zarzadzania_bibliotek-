package Controllers;

import connect.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.czytelnicy;
import models.ksiazki;
import models.wypozyczenia;
import models.zamowienia;
import oracle.jdbc.OracleTypes;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class baza implements Initializable {
    @FXML
    private ImageView backIcon;

    @FXML
    private TableColumn<zamowienia, String> czy_aktywne;

    @FXML
    private TableColumn<zamowienia, String> czy_aktywne2;

    @FXML
    private TableColumn<wypozyczenia, String> czy_oddane;

    @FXML
    private TableColumn<wypozyczenia, String> czy_oddane2;

    @FXML
    private TableColumn<zamowienia, String> data_odbioru;

    @FXML
    private TableColumn<zamowienia, String> data_odbioru2;

    @FXML
    private TableColumn<wypozyczenia, String> data_wypozyczenia;

    @FXML
    private TableColumn<wypozyczenia, String> data_wypozyczenia2;

    @FXML
    private TableColumn<wypozyczenia, String> data_zwrotu;

    @FXML
    private TableColumn<wypozyczenia, String> data_zwrotu2;

    @FXML
    private TableColumn<wypozyczenia, Number> id_czytelnika;

    @FXML
    private TableColumn<wypozyczenia, Number> id_czytelnika2;

    @FXML
    private TableColumn<zamowienia, Number> id_czytelnikaZ;

    @FXML
    private TableColumn<zamowienia, Number> id_czytelnikaZ2;

    @FXML
    private TableColumn<wypozyczenia, Number> id_egzemplarza;

    @FXML
    private TableColumn<wypozyczenia, Number> id_egzemplarza2;
    @FXML
    private TableColumn<zamowienia, Number> id_ksiazki;

    @FXML
    private TableColumn<zamowienia, Number> id_ksiazki2;

    @FXML
    private TableColumn<wypozyczenia, Number> id_wypozyczenia;

    @FXML
    private TableColumn<wypozyczenia, Number> id_wypozyczenia2;

    @FXML
    private TableColumn<zamowienia, Number> id_zamowienia;

    @FXML
    private TableColumn<zamowienia, Number> id_zamowienia2;

    @FXML
    private TableColumn<zamowienia, String> ilosc;

    @FXML
    private TableColumn<zamowienia, String> ilosc2;

    @FXML
    private TableColumn<zamowienia, String> suma;

    @FXML
    private TableColumn<zamowienia, String> suma2;

    @FXML
    private TableView<wypozyczenia> wypozyczeniaTable;

    @FXML
    private TableView<wypozyczenia> wypozyczeniaTable2;

    @FXML
    private TableView<zamowienia> zamowieniaTable;

    @FXML
    private TableView<zamowienia> zamowieniaTable2;

    @FXML
    void BackAction(MouseEvent event) throws IOException {
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        stage.setX(1);
        stage.setY(1);
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    public void tableWypozyczenia2() throws SQLException {
        ObservableList<wypozyczenia> wypozyczenia = FXCollections.observableArrayList();
        try {
            Connection con = ConnectionDB.getConnection();
//            PreparedStatement pst = con.prepareStatement("select * from wypozyczenia_historia");
//            ResultSet rs = pst.executeQuery();
            CallableStatement cstmt = con.prepareCall("{ call SELECTISSUEHISTORY(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            {
                while (rs.next()) {
                   wypozyczenia wypozyczenia2 = new wypozyczenia();
                    wypozyczenia2.setId_wypozyczenia(rs.getInt("id_wypozyczenia"));
                    wypozyczenia2.setId_egzemplarza(rs.getInt("id_egzemplarza"));
                    wypozyczenia2.setId_czytelnika(rs.getInt("id_czytelnika"));
                    wypozyczenia2.setData_wypozyczenia(rs.getString("data_wypozyczenia"));
                    wypozyczenia2.setData_zwrotu(rs.getString("data_zwrotu"));
                    wypozyczenia2.setCzy_oddane(rs.getString("czy_oddane"));

                   wypozyczenia.add(wypozyczenia2);
                }
            }
           wypozyczeniaTable2.setItems(wypozyczenia);
           id_wypozyczenia2.setCellValueFactory(f -> f.getValue().id_wypozyczeniaProperty());
           id_egzemplarza2.setCellValueFactory(f -> f.getValue().id_egzemplarzaProperty());
            id_czytelnika2.setCellValueFactory(f -> f.getValue().id_czytelnikaProperty());
            data_wypozyczenia2.setCellValueFactory(f -> f.getValue().data_wypozyczeniaProperty());
           data_zwrotu2.setCellValueFactory(f -> f.getValue().data_zwrotuProperty());
            czy_oddane2.setCellValueFactory(f -> f.getValue().czy_oddaneProperty());

        } catch (SQLException throwables) {
            Logger.getLogger(ZarzadzanieCzytelnikami.class.getName()).log(Level.SEVERE, null, throwables);
        }
    }

    public void tableWypozyczenia() throws SQLException {
        ObservableList<wypozyczenia> wypozyczenia = FXCollections.observableArrayList();
        try {
            Connection con = ConnectionDB.getConnection();
//            PreparedStatement pst = con.prepareStatement("select * from wypozyczenia");
//            ResultSet rs = pst.executeQuery();
            CallableStatement cstmt = con.prepareCall("{ call SELECTISSUE(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            {
                while (rs.next()) {
                    wypozyczenia wypozyczenia2 = new wypozyczenia();
                    wypozyczenia2.setId_wypozyczenia(rs.getInt("id_wypozyczenia"));
                    wypozyczenia2.setId_egzemplarza(rs.getInt("id_egzemplarza"));
                    wypozyczenia2.setId_czytelnika(rs.getInt("id_czytelnika"));
                    wypozyczenia2.setData_wypozyczenia(rs.getString("data_wypozyczenia"));
                    wypozyczenia2.setData_zwrotu(rs.getString("data_zwrotu"));
                    wypozyczenia2.setCzy_oddane(rs.getString("czy_oddane"));

                    wypozyczenia.add(wypozyczenia2);
                }
            }
            wypozyczeniaTable.setItems(wypozyczenia);
            id_wypozyczenia.setCellValueFactory(f -> f.getValue().id_wypozyczeniaProperty());
            id_egzemplarza.setCellValueFactory(f -> f.getValue().id_egzemplarzaProperty());
            id_czytelnika.setCellValueFactory(f -> f.getValue().id_czytelnikaProperty());
            data_wypozyczenia.setCellValueFactory(f -> f.getValue().data_wypozyczeniaProperty());
            data_zwrotu.setCellValueFactory(f -> f.getValue().data_zwrotuProperty());
            czy_oddane.setCellValueFactory(f -> f.getValue().czy_oddaneProperty());

        } catch (SQLException throwables) {
            Logger.getLogger(ZarzadzanieCzytelnikami.class.getName()).log(Level.SEVERE, null, throwables);
        }
    }

    public void tableZamowienia() throws SQLException {
        ObservableList<zamowienia> zamowienia = FXCollections.observableArrayList();
        try {
            Connection con = ConnectionDB.getConnection();
//            PreparedStatement pst = con.prepareStatement("select * from zamowienia");
//            ResultSet rs = pst.executeQuery();
            CallableStatement cstmt = con.prepareCall("{ call SELECTORDERS(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            {
                while (rs.next()) {
                    zamowienia zamowienia2 = new zamowienia();
                    zamowienia2.setId_zamowienia(rs.getInt("id_zamowienia"));
                    zamowienia2.setId_czytelnika(rs.getInt("id_czytelnika"));
                   zamowienia2.setId_ksiazki(rs.getInt("id_ksiazki"));
                    zamowienia2.setIlosc(rs.getString("ilosc"));
                   zamowienia2.setSuma(rs.getString("suma"));
                    zamowienia2.setData_odbioru(rs.getString("data_odbioru"));
                    zamowienia2.setCzy_aktywne(rs.getString("czy_aktywne"));

                    zamowienia.add(zamowienia2);
                }
            }
           zamowieniaTable.setItems(zamowienia);
          id_zamowienia.setCellValueFactory(f -> f.getValue().id_zamowieniaProperty());
         id_czytelnikaZ.setCellValueFactory(f -> f.getValue().id_czytelnikaProperty());
            id_ksiazki.setCellValueFactory(f -> f.getValue().id_ksiazkiProperty());
          ilosc.setCellValueFactory(f -> f.getValue().iloscProperty());
            suma.setCellValueFactory(f -> f.getValue().sumaProperty());
            data_odbioru.setCellValueFactory(f -> f.getValue().data_odbioruProperty());
            czy_aktywne.setCellValueFactory(f -> f.getValue().czy_aktywneProperty());

        } catch (SQLException throwables) {
            Logger.getLogger(ZarzadzanieCzytelnikami.class.getName()).log(Level.SEVERE, null, throwables);
        }
    }
    public void tableZamowienia2() throws SQLException {
        ObservableList<zamowienia> zamowienia = FXCollections.observableArrayList();
        try {
            Connection con = ConnectionDB.getConnection();
//
            CallableStatement cstmt = con.prepareCall("{ call SELECTORDERSHISTORY(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            ResultSet rs = (ResultSet) cstmt.getObject(1);
            {
                while (rs.next()) {
                    zamowienia zamowienia2 = new zamowienia();
                    zamowienia2.setId_zamowienia(rs.getInt("id_zamowienia"));
                    zamowienia2.setId_czytelnika(rs.getInt("id_czytelnika"));
                    zamowienia2.setId_ksiazki(rs.getInt("id_ksiazki"));
                    zamowienia2.setIlosc(rs.getString("ilosc"));
                    zamowienia2.setSuma(rs.getString("suma"));
                    zamowienia2.setData_odbioru(rs.getString("data_odbioru"));
                    zamowienia2.setCzy_aktywne(rs.getString("czy_aktywne"));

                    zamowienia.add(zamowienia2);
                }
            }
            zamowieniaTable2.setItems(zamowienia);
            id_zamowienia2.setCellValueFactory(f -> f.getValue().id_zamowieniaProperty());
            id_czytelnikaZ2.setCellValueFactory(f -> f.getValue().id_czytelnikaProperty());
            id_ksiazki2.setCellValueFactory(f -> f.getValue().id_ksiazkiProperty());
            ilosc2.setCellValueFactory(f -> f.getValue().iloscProperty());
            suma2.setCellValueFactory(f -> f.getValue().sumaProperty());
            data_odbioru2.setCellValueFactory(f -> f.getValue().data_odbioruProperty());
            czy_aktywne2.setCellValueFactory(f -> f.getValue().czy_aktywneProperty());

        } catch (SQLException throwables) {
            Logger.getLogger(ZarzadzanieCzytelnikami.class.getName()).log(Level.SEVERE, null, throwables);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            tableWypozyczenia();
            tableWypozyczenia2();
            tableZamowienia();
            tableZamowienia2();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
