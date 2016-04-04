import java.util.List;

/**
 * Created by Konrad on 14.03.2016.
 */
public interface IMyList {

    boolean add(Building b);
    boolean remove(Building b);
    List<Building> getAll();
    boolean findByNazwa(String Nazwa);
    boolean findByIlosc(int ilosc_mieszkan);
}
