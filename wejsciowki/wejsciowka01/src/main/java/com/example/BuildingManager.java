package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManager {

    public  Building build = new Building();

   // private  IMyList list;

    //public BuildingManager(IMyList list) { this.lista = lista;}

    List<Building> lista = new ArrayList<Building>();

    public  boolean add(int ilosc, String nazwa, double wysokosc){
        build = new Building(ilosc,nazwa,wysokosc);
        lista.add(build);
        return true;
    }

    public  boolean add(Building b){
        lista.add(b);
        return true;
    }

    public  boolean delete(Building del_build){
        lista.remove(del_build);
        return true;
    }

    public List<Building> getAll(){
        return lista;
        //return true;
    }

    public boolean findByName(String name){
        for(Building b: lista){
            if(b.getNazwaBudynku().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean findByAmount(int ilosc){
        for(Building b: lista){
            if(b.getIloscMieszkan() == ilosc){
                return true;
            }
        }
        return false;
    }

    public int getIlosc(Building build){
        return build.ilosc_mieszkan;
    }



}
