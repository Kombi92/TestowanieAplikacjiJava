import java.util.List;

/**
 * Created by Konrad on 14.03.2016.
 */
public class Run {

    private IMyList buildMan;

    public Run(IMyList buildMan){
        this.buildMan = buildMan;
    }
    public boolean add(Building b) {
        return buildMan.add(b);
    }
    public boolean remove(Building b) {
        return buildMan.remove(b);
    }
    public List<Building> getAll() {
        return buildMan.getAll();
    }
    public boolean findByName(String name){
        return buildMan.findByName(name);
    }
    public boolean findByIlosc(int  ilosc){
        return buildMan.findByIlosc(ilosc);
    }
}
