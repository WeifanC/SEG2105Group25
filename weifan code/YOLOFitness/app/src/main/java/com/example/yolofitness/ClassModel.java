package com.example.yolofitness;

public class ClassModel {
    private int id;
    private String name;
    private String description;
    private String firstname;
    private String date;
    private String hours;
    private String difficulty;


    public ClassModel(int id, String name, String description,String difficulty,String date,String hours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty=difficulty;
        this.date=date;
        this.hours=hours;
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

    public String getDifficulty(){return difficulty;}

    public void setDifficulty(String difficulty){this.difficulty=difficulty;}

    public String getDate(){return date;}

    public void setDate(String date){this.date=date;}

    public String getHours(){return hours;}

    public void setHours(String hours){this.hours=hours;}

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
