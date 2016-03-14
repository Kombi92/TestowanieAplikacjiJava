import java.util.List;

/**
 * Created by Konrad on 14.03.2016.
 */
public interface IMyList {

    boolean add(Building b);
    List remove(Building b);
    List getAll();
}
