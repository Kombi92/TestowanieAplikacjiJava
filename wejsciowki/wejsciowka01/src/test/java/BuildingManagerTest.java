import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManagerTest {

    private Building build= new Building(6, "duzy",17.5 );

    @Before
    @Test
    public void addToList(){
        BuildingManager.add(6,"duzy",17.5);
    }


    @After
    @Test
    public void removefromList() { BuildingManager.delete(BuildingManager.lista.get(0));}

    @Test
    public void addCheck(){

        assertEquals(BuildingManager.lista.get(0).ilosc_mieszkan , build.ilosc_mieszkan);
        assertEquals(BuildingManager.lista.get(0).wysokosc , build.wysokosc , 0.0001);
        assertEquals(BuildingManager.lista.get(0).nazwa_budynku , build.nazwa_budynku);

        assertEquals(BuildingManager.lista.get(0).getIlosc_mieszkan() , build.ilosc_mieszkan);
    }

    @Test
    public void deleteCheck(){

        BuildingManager.delete((BuildingManager.lista.get(0)));

        assertEquals(BuildingManager.lista.size() , 0);

        BuildingManager.add(6,"duzy",17.5);
    }
}
