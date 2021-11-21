package com.example.yolofitness;

public class ClassModel {
    private int id;
    private String name;
    private String description;

    public ClassModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public ClassModel(){
    }

    @Override
    public String toString() {
        return "ClassID" +
                "=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}