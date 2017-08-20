package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kasun Prabath on 11/19/2016.
 */
public class Structure_ifelse {

    private String type;
    //Map<String,String> func;
    private ArrayList<String> func;
    private String name;
    //private Structure connected_to;
    private ArrayList<Structure> connected_to;
    //List funcl;

    public Structure_ifelse() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList< String> getFunc() {
        return func;
    }

    public void setFunc(ArrayList<String> func) {
        this.func = func;
    }
    /*public void setFunc(List func) {
        this.funcl = func;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Structure> getConnected_to() {
        return connected_to;
    }

    public void setConnected_to(ArrayList<Structure> connected_to) {
        this.connected_to = connected_to;
    }

    @Override
    public String toString() {
        return "Structure{" +
                " \n type='" + type + '\'' +
                ", \n func=" + func +
                ", \n name='" + name + '\'' +
                ", \n connected_to=" + connected_to +
                '}';
    }
}
