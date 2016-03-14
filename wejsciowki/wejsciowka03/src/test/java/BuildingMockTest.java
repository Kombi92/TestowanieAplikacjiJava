import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    private BuildingManager myMan;
    private IMyList mock;

    @Before
    public void setUp(){
        mock = createMock(IMyList.class);
        myMan = new BuildingManager(mock);
    }

    @Test
    public void listCheck(){

        Building b = new Building(15,"tak",15.5);

        expect(mock.add(b)).andReturn(true).atLeastOnce();
        expect(mock.remove(b)).andReturn(null).atLeastOnce();
        expect(mock.getAll()).andReturn(null).atLeastOnce();
        replay(mock);
        assertEquals(myMan.add(b), true );
        assertEquals(myMan.delete(b),true);
        assertEquals(myMan.getAll(), true);
        verify(mock);
    }
}
