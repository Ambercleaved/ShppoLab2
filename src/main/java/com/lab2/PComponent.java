package com.lab2;

public class PComponent {

    protected int id;
    protected String type;
    protected String manufacturer;
    protected String name;

    PComponent(){
        super();
    }
    public PComponent(int id, String type , String manufacturer, String name) {
        super();
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
