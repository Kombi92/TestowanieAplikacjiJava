import java.util.List;

/**
 * Created by Konrad on 14.03.2016.
 */
public class Run {

    public static void main(){

        BuildingManager man = new BuildingManager(new IMyList(){
            @Override
            public boolean add(Building b) {
                if(b.ilosc_mieszkan == 15) return true;
                return true;
            }
            @Override
            public List remove(Building b) {
                return null;
            }
            @Override
            public List getAll() {
                return null;
            }


        });
    }
}
