package com.example.model;

public class University {
      int id;
      String name;
      String location;
     int rank;

    public University(int id, String name, int Rank, String location){
        this.id=id;
        this.name=name;
        this.rank=Rank;
        this.location=location;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
