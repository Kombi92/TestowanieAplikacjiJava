/**
 * Created by Konrad on 29.02.2016.
 */
public class Building {

    public int ilosc_mieszkan;
    public String nazwa_budynku;
    public double wysokosc;

    public Building() {
    }

    public Building(int ilosc_mieszkan, String nazwaBudynku, double wysokosc) {
        this.ilosc_mieszkan = ilosc_mieszkan;
        this.nazwa_budynku = nazwaBudynku;
        this.wysokosc = wysokosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public int getIloscMieszkan() {
        return ilosc_mieszkan;
    }

    public void setIloscMieszkan(int ilosc_mieszkan) {
        this.ilosc_mieszkan = ilosc_mieszkan;
    }

    public String getNazwaBudynku() {
        return nazwa_budynku;
    }

    public void setNazwaBudynku(String nazwaBudynku) {
        this.nazwa_budynku = nazwaBudynku;
    }
}