package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Konrad on 29.02.2016.
 */
public class BuildingManager {

    public  Building build = new Building();
    public  Building del_build;

    //public IMyList lista;

    public BuildingManager() {lista = new ArrayList<Building>();}

   // public BuildingManager(IMyList lista) { this.lista = lista;}

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

    public  boolean remove(Building del_build){
        lista.remove(del_build);
        return true;
    }

    public  boolean remove(int ilosc, String nazwa, double wysokosc){
        del_build = new Building(ilosc,nazwa,wysokosc);

        lista.remove(del_build);
        lista.

        return true;
    }

    public int getAmount(){
        return lista.size();
        }

//    public List<Building> getAll(){
//        return lista.getAll();
//        //return true;
//    }
//
//    public Building findByName(String name){
////        for(Building b: lista.getAll()){
////            if(b.getNazwaBudynku().equals(name)){
////                return true;
////            }
////        }
////        return false;
//        return lista.findByName(name);
//
//    }
//
//    public Building findByAmount(int ilosc){
////        for(Building b: lista.getAll()){
////            if(b.getIloscMieszkan() == ilosc){
////                return true;
////            }
////        }
////        return false;
//        return lista.findByAmount(ilosc);
//    }
//
//    public int getIlosc(Building build){
//        return build.ilosc_mieszkan;
//    }
//
//

}
