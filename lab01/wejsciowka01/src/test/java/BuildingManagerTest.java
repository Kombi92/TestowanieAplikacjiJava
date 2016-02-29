import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManagerTest {

    private Building build= new Building(6, "duzy",17.5 );


    @Test
    public void addcheck(){

        BuildingManager.add(6,"duzy",17.5);

        assertEquals(BuildingManager.lista.get(0) , build);

    }

    @Test
    public void deletecheck(){

    }
}
