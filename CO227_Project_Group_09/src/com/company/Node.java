package com.company;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 12/1/2016.
 * this class used to catch one node in graph
 * parsing the JSON using jackson library this is the node class with setters and getters
 */
public class Node {

    private String type;
    private String name;
    private String [] func;
    private String [] con_true;
    private String [] con_false;
    private boolean system;

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public String[] getCon_true() {
        return con_true;
    }

    public void setCon_true(String[] con_true) {
        this.con_true = con_true;
    }

    public String[] getCon_false() {
        return con_false;
    }

    public void setCon_false(String[] con_false) {
        this.con_false = con_false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFunc() {
        return func;
    }

    public void setFunc(String[] func) {
        this.func = func;
    }



    @Override
    public String toString() {
        return "Node{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", func=" + Arrays.toString(func) +
                ", con_true=" + Arrays.toString(con_true) +
                ", con_false=" + Arrays.toString(con_false) +
                '}';
    }
}
