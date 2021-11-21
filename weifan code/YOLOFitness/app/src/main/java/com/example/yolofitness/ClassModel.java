package com.example.yolofitness;

public class ClassModel {
    private int id;
    private String name;
    private String description;
    private String instructor;
    private String date;
    private String hours;
    private String difficulty;
    private String capacity;


    public ClassModel(int id, String name, String description,String instructor, String difficulty,String date,String hours,String capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.difficulty=difficulty;
        this.date=date;
        this.hours=hours;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return
                "Class = " + name  +
                ", description = '" + description  +
                ", instructor = '" + instructor +
                ", difficulty = '" + difficulty  +
                ", date = '" + date +
                ", hours = '" + hours +
                ", capacity = '" + capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
