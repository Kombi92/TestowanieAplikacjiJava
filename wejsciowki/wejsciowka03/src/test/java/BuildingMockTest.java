import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

/**
 * Created by Konrad on 14.03.2016.
 */
public class BuildingMockTest {

    private MyApp myApp;
    private IMyList mock;

    @Before
    public void setUp(){
        mock = createMock(IMyList.class);
        myApp = new MyApp(mock);
    }

    //2-3 metody findbyname(string name)

    @Test
    public void listCheck(){

        Building b = new Building(15,"tak",15.5);

        List<Building> buildings = new ArrayList<Building>();

        buildings.add(b);

        expect(mock.add(b)).andReturn(true).atLeastOnce();
        expect(mock.remove(b)).andReturn(true).atLeastOnce();
        expect(mock.getAll()).andReturn(buildings).atLeastOnce();
        expect(mock.findByNazwa("tak")).andReturn(true).atLeastOnce();
        expect(mock.findByIlosc(15)).andReturn(true).atLeastOnce();
        replay(mock);

        assertEquals(true, myApp.add(b));
        assertEquals("tak", myApp.getAll().get(0).getNazwa_budynku());
        assertEquals(true, myApp.remove(b));
        assertEquals(true, myApp.findByNazwa("tak"));
        assertEquals(true, myApp.findByIlosc(15));
        verify(mock);
    }
}
