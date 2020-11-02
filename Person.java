package com.company;

import java.lang.*;
public class Person {

    //data members
    String name;
    String uid;


    //constructors
    //empty constructor
    public Person()
    {
        this.name = "\0";
        this.uid = "\0";
    }

    //2arg constructor
    public Person(String name, String id)
    {
        this.name = name;
        this.uid = id;
    }

    //print out details of person object if necessary.
    public String toString()
    {
        String output;
        output = "Person: " + name +" UID: " + uid + "\n";
        return output;

    }

//end class
}
