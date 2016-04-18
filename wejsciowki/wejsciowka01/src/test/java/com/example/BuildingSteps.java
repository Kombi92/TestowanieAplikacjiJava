package com.example;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.Building;
import com.example.BuildingManager;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import java.util.ArrayList;
import java.util.List;

public class BuildingSteps extends Steps{

    private Building build;
    //private List<Building> list = new ArrayList<Building>();
    private IMyList list;
    private BuildingManager bm;
    private double wys;
    private String nazw;
    private int ilo;

    final int IloscMieszkan = 15;
    final String NazwaBudynku = "Sloneczny";
    final double WysokoscBudynku = 15.5;

    Building b = new Building(IloscMieszkan,NazwaBudynku,WysokoscBudynku);
    Building temp;


    @Given("a building")
    public void BuildingSetup(){
        build = new Building();
    }

    @Given("a list")
    public void ListSetup(){
        bm = new BuildingManager(list);
    }

    @When("add to list $n $w $i")
    public void getByWysokosc(String n,double w,int i){
        temp = new Building(i,n,w);
        bm.add(temp);
    }

    @Then("should return $w")
    public void shouldReturnAmount(double w){

        assertEquals(w, bm.findByAmount());
    }

    @When("get by nazwa $s")
    public void getByWysokosc(String s){
        list.add(b);
        temp = bm.findByName(s);

    }

    @Then("should return $w")
    public void shouldReturnWys(double w){

        assertEquals(w, temp.getWysokosc(), 0.000001);
    }

    @When("set wysokosc $w")
    public void setWysokosc(double w){
        build.setWysokosc(w);
    }
    @Then("wysokosc should be $w")
    public void shouldchange(double w){

        assertEquals(w, build.getWysokosc(),0.00001);
    }

//    @When("given server $s and message $m")
//    public void givenValues(String a,String m){
//        server = a;
//        message = m;
//    }
//
//    @Then("sending should return $r or $re")
//    public void shouldSend(int r,int re){
//        int result = mess.sendMessage(server,message);
//        assertTrue(result == r ||  result == re);
//    }
//    @Then("sending should return $result")
//    public void shouldSend(int result){
//        assertEquals(result, mess.sendMessage(server,message));
//    }

}