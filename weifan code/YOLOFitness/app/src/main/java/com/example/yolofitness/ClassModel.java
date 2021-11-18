package com.example.yolofitness;

public class ClassModel {
    private int id;
    private String name;
    private String description;
    private String firstname;
    private String time;
    private int difficulty;


    public ClassModel(int id, String name, String description,int difficulty,String time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty=difficulty;
        this.time=time;
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

    public int getDifficulty(){return difficulty;}

    public void setDifficulty(int difficulty){this.difficulty=difficulty;}

    public String getTime(){return time;}

    public void setTime(String time){this.time=time;}

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
