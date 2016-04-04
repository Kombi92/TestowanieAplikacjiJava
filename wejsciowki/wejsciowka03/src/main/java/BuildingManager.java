import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManager {

    public  Building build = new Building();

    List<Building> lista = new ArrayList<Building>();

    public  boolean add(int ilosc, String nazwa, double wysokosc){
        build = new Building(ilosc,nazwa,wysokosc);
        lista.add(build);
        return true;
    }

    public void add(Building b){
        lista.add(b);
    }

    public void delete(Building del_build){
        lista.remove(del_build);
    }

    public List<Building>  getAll(){
        return lista;
    }

    public boolean findbyNazwa(String nazwa) {
        for(Building b: lista) {
            if(b.getNazwa_budynku().equals(nazwa)) {
                return true;
            }
        }
        return false;
    }

    public boolean findbyIlosc(int ilosc) {
        for(Building b: lista) {
            if(b.getIlosc_mieszkan()==ilosc) {
                return true;
            }
        }
        return false;
    }

}
