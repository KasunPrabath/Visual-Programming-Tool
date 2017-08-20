package com.company;

import java.util.ArrayList;

/**
 * Created by Kasun Prabath on 11/19/2016.JSON representations parsing into this type of object
 */
public class Structure {

    private String type;
    private ArrayList<String> func;
    private String name;
    private ArrayList<Structure> truepath;
    private ArrayList<Structure> falsepath;
    private ArrayList<Structure> previousnode;


    public Structure() {
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getFunc() {
        return func;
    }

    public String getName() {
        return name;
    }

    public Structure getTruepath() {
        return truepath.get(0);
    }

    public Structure getFalsepath() {
        return falsepath.get(0);
    }

    public void setFalsepath(ArrayList<Structure> falsepath) {
        this.falsepath = falsepath;
    }

    public Structure getPreviousnode() {
        return previousnode.get(0);
    }

    public void setPreviousnode(ArrayList<Structure> previousnode) {
        this.previousnode = previousnode;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "\ntype='" + type + '\'' +
                ",\n func=" + func +
                ",\n name='" + name + '\'' +
                ",\n truepath=" + truepath +
                ",\n falsepath=" + falsepath +
                ",\n previousnode=" + previousnode +
                '}';
    }
}
