package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class zamowienia {
    private final IntegerProperty id_zamowienia;
    private final IntegerProperty id_czytelnika;
    private final IntegerProperty id_ksiazki;
    private final StringProperty ilosc;
    private final StringProperty suma;
    private final StringProperty data_odbioru;
    private final StringProperty czy_aktywne;


    public int getId_zamowienia() {
        return id_zamowienia.get();
    }

    public IntegerProperty id_zamowieniaProperty() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia.set(id_zamowienia);
    }

    public int getId_czytelnika() {
        return id_czytelnika.get();
    }

    public IntegerProperty id_czytelnikaProperty() {
        return id_czytelnika;
    }

    public void setId_czytelnika(int id_czytelnika) {
        this.id_czytelnika.set(id_czytelnika);
    }

    public int getId_ksiazki() {
        return id_ksiazki.get();
    }

    public IntegerProperty id_ksiazkiProperty() {
        return id_ksiazki;
    }

    public void setId_ksiazki(int id_ksiazki) {
        this.id_ksiazki.set(id_ksiazki);
    }

    public String getIlosc() {
        return ilosc.get();
    }

    public StringProperty iloscProperty() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc.set(ilosc);
    }

    public String getSuma() {
        return suma.get();
    }

    public StringProperty sumaProperty() {
        return suma;
    }

    public void setSuma(String suma) {
        this.suma.set(suma);
    }

    public String getData_odbioru() {
        return data_odbioru.get();
    }

    public StringProperty data_odbioruProperty() {
        return data_odbioru;
    }

    public void setData_odbioru(String data_odbioru) {
        this.data_odbioru.set(data_odbioru);
    }

    public String getCzy_aktywne() {
        return czy_aktywne.get();
    }

    public StringProperty czy_aktywneProperty() {
        return czy_aktywne;
    }

    public void setCzy_aktywne(String czy_aktywne) {
        this.czy_aktywne.set(czy_aktywne);
    }

    public zamowienia() {
        id_zamowienia = new SimpleIntegerProperty(this, "id_zamowienia");
        id_czytelnika = new SimpleIntegerProperty(this, "id_czytelnika");
        id_ksiazki = new SimpleIntegerProperty(this, "id_ksiazki");
       ilosc = new SimpleStringProperty(this, "ilosc");
       suma = new SimpleStringProperty(this, "suma");
       data_odbioru = new SimpleStringProperty(this, "data_odbioru");
       czy_aktywne = new SimpleStringProperty(this, "czy_aktywne");


    }
}
