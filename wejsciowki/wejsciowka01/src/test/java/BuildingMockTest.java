import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

/**
 * Created by Konrad on 14.03.2016.
 */
public class BuildingMockTest {

    private BuildingManager building;
    private IMyList mock;

    @Before
    public void setUp(){
        mock = createMock(IMyList.class);
        building = new BuildingManager(mock);
    }

    @Test
    public void listCheck(){

        Building b = new Building(15,"tak",15.5);

        expect(mock.add(b)).andReturn(1);
        replay(mock);
        verify(mock);
    }
}
