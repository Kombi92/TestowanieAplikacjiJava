import java.util.List;

/**
 * Created by Konrad on 14.03.2016.
 */
public class MyApp {

    private IMyList buildMan;

    public MyApp(IMyList buildMan){
        this.buildMan = buildMan;
    }

    public boolean add(Building b){
        return buildMan.add(b);
    }

    public boolean remove(Building b){
        return buildMan.remove(b);
    }
    public List<Building> getAll()
    {
        return buildMan.getAll();
    }
    public boolean findByNazwa(String nazwa) {
        return buildMan.findByNazwa(nazwa);
    }
    public boolean findByIlosc(int ilosc_mieszkan) {
        return buildMan.findByIlosc(ilosc_mieszkan);
    }

}
