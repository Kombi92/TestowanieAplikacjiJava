import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManager {

    public static Building build = new Building();

    private IMyList list;

    public BuildingManager(IMyList list) { this.list = list;}

    static List<Building> lista = new ArrayList<Building>();

    public static void add(int ilosc, String nazwa, double wysokosc){
        build = new Building(ilosc,nazwa,wysokosc);
        lista.add(build);
    }

    public static void delete(Building del_build){
        lista.remove(del_build);
    }

    public static int getIlosc(Building build){
        return build.ilosc_mieszkan;
    }


}
