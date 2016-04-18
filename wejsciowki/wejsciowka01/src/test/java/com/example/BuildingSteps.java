package com.example;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        bm = new BuildingManager();
    }

    @When("add to list Nazwa: $n Wysokosc: $w Ilosc: $i")
    public void getByWysokosc(String n,double w,int i){
        bm.add(i,n,w);
    }

    @Then("should return $w")
    public void shouldReturnAmount(int w){
        assertEquals(w, bm.lista.size());
    }

    @When("get by nazwa $s")
    public void getByWysokosc(String s){
        list.add(b);
    }

    @When("remove from Nazwa: $n Wysokosc: $w Ilosc: $i")
    public void removeByWysokosc(String n,double w,int i){
        bm.remove(i,n,w);
    }

    @Then("after delete should return $w")
    public void shouldReturnAmountAfterdelete(int w){
        assertEquals(w, bm.getAmount());
    }


}