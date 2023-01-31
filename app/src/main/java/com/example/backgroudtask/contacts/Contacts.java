package com.example.backgroudtask.contacts;

public class Contacts {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int id;
    public String name;
    public String number;

    public Contacts() {
    }
    public Contacts(int id, String name, String number) { //you don't need to create some constructor setting 'id', cuz it'll be automatically incremental as it's the primary key
        this.id= id;
        this.name=name;
        this.number= number;
    }
    public Contacts(String name, String number) {
        this.name=name;
        this.number=number;
    }
}
