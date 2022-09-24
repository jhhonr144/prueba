package com.example.prueba;

public class music {
    private String name,id,disambiguation;

    public music() {
    }

    public music(String name, String id, String disambiguation) {
        this.name = name;
        this.id = id;
        this.disambiguation = disambiguation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }
}
