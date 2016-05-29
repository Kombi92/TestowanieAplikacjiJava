package com.example.restproject.domain;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by Konrad on 29.05.2016.
 */
@XmlRootElement
public class Building {

    private long id;
    private String Name;
    private int FloorArea;
    private long idOwner;

    public Building(String Name, int FloorArea) {

        this.Name = Name;
        this.FloorArea = FloorArea;
    }


    public Building() {
    }

    public Building(long id, String Name, int FloorArea) {
        super();
        this.id = id;
        this.Name = Name;
        this.FloorArea = FloorArea;
    }
    public Building(long id, String Name, int FloorArea,long idOwner) {
        this.id = id;
        this.Name = Name;
        this.FloorArea = FloorArea;
        this.idOwner = idOwner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public int getFloorArea() {
        return FloorArea;
    }
    public void setFloorArea(int FloorArea) {
        this.FloorArea = FloorArea;
    }

    public long getIdOwner(){
        return idOwner;
    }

    public void setIdOwner (long idOwner){
        this.idOwner = idOwner;
    }

}
