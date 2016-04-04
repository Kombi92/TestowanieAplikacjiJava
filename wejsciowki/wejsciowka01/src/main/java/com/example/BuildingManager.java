package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManager {

    public  Building build = new Building();

   // private  IMyList list;
    public IMyList lista;

    public BuildingManager(IMyList lista) { this.lista = lista;}

    //List<Building> lista = new ArrayList<Building>();

    public  boolean add(int ilosc, String nazwa, double wysokosc){
        build = new Building(ilosc,nazwa,wysokosc);
        lista.add(build);
        return true;
    }

    public  boolean add(Building b){
        lista.add(b);
        return true;
    }

    public  boolean remove(Building del_build){
        lista.remove(del_build);
        return true;
    }

    public List<Building> getAll(){
        return lista.getAll();
        //return true;
    }

    public Building findByName(String name){
//        for(Building b: lista.getAll()){
//            if(b.getNazwaBudynku().equals(name)){
//                return true;
//            }
//        }
//        return false;
        return lista.findByName(name);

    }

    public Building findByAmount(int ilosc){
//        for(Building b: lista.getAll()){
//            if(b.getIloscMieszkan() == ilosc){
//                return true;
//            }
//        }
//        return false;
        return lista.findByAmount(ilosc);
    }

    public int getIlosc(Building build){
        return build.ilosc_mieszkan;
    }



}
