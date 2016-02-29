import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManager {

    public Building build = new Building();

    List<Building> lista = new ArrayList<Building>();

    public void add(int ilosc, String nazwa, double wysokosc){
        build = new Building(ilosc,nazwa,wysokosc);
        lista.add(build);
    }

    public void delete(Building del_build){
        lista.remove(del_build);
    }

}
