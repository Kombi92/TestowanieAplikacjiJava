import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManager {

    public static Building build = new Building();

    private static IMyList list;

    public BuildingManager(IMyList list) { this.list = list;}

  //  static List<Building> lista = new ArrayList<Building>();

    public static boolean add(int ilosc, String nazwa, double wysokosc){
        build = new Building(ilosc,nazwa,wysokosc);
        list.add(build);
        return true;
    }

    public static boolean add(Building b){
        list.add(b);
        return true;
    }

    public static boolean delete(Building del_build){
        list.remove(del_build);
        return true;
    }

    public static boolean getAll(){
        list.getAll();
        return true;
    }

    public static int getIlosc(Building build){
        return build.ilosc_mieszkan;
    }



}
