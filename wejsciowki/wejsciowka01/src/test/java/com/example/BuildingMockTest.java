package com.example;

import com.example.Building;
import com.example.IMyList;
import com.example.Run;
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

    private BuildingManager myMan;
    private IMyList mock;

    @Before
    public void setUp(){
        mock = createMock(IMyList.class);
        myMan = new BuildingManager(mock);
    }

    @Test
    public void listCheck(){

        final int IloscMieszkan = 15;
        final String NazwaBudynku = "Sloneczny";
        final double WysokoscBudynku = 15.5;

        Building b = new Building(IloscMieszkan,NazwaBudynku,WysokoscBudynku);
        List<Building> buildings = new ArrayList<Building>();
        buildings.add(b);

        expect(mock.add(b)).andReturn(true).atLeastOnce();
        expect(mock.remove(b)).andReturn(true).atLeastOnce();
        expect(mock.getAll()).andReturn(buildings).atLeastOnce();
        expect(mock.findByName(NazwaBudynku)).andReturn(b).atLeastOnce();
        expect(mock.findByAmount(IloscMieszkan)).andReturn(b).atLeastOnce();
        replay(mock);
        assertEquals(true, myMan.add(b));
        assertEquals(NazwaBudynku, myMan.getAll().get(0).getNazwaBudynku());
        assertEquals(true, myMan.remove(b));
        assertEquals(b, myMan.findByName(NazwaBudynku));
        assertEquals(b, myMan.findByAmount(IloscMieszkan));

        verify(mock);
    }
}
