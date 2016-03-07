/**
 * Created by Konrad on 29.02.2016.
 */
public class Building {

    public int ilosc_mieszkan;
    public String nazwa_budynku;
    public double wysokosc;

    public Building() {
    }

    public Building(int ilosc_mieszkan, String nazwa_budynku, double wysokosc) {
        this.ilosc_mieszkan = ilosc_mieszkan;
        this.nazwa_budynku = nazwa_budynku;
        this.wysokosc = wysokosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public int getIlosc_mieszkan() {
        return ilosc_mieszkan;
    }

    public void setIlosc_mieszkan(int ilosc_mieszkan) {
        this.ilosc_mieszkan = ilosc_mieszkan;
    }

    public String getNazwa_budynku() {
        return nazwa_budynku;
    }

    public void setNazwa_budynku(String nazwa_budynku) {
        this.nazwa_budynku = nazwa_budynku;
    }
}