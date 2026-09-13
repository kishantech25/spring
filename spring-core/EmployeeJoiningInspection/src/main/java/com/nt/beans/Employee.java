package com.nt.beans;

public class Employee {

    private int id;
    private String name;
    private boolean documentsVerified;
    private boolean backgroundVerified;
    private boolean medicalCleared;

    public Employee() {
        System.out.println("Employee Object Created");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocumentsVerified(boolean documentsVerified) {
        this.documentsVerified = documentsVerified;
    }

    public void setBackgroundVerified(boolean backgroundVerified) {
        this.backgroundVerified = backgroundVerified;
    }

    public void setMedicalCleared(boolean medicalCleared) {
        this.medicalCleared = medicalCleared;
    }

    public boolean isDocumentsVerified() {
        //can write the logic
        return documentsVerified;
    }

    public boolean isBackgroundVerified() {
        //can write the logic
        return backgroundVerified;
    }

    public boolean isMedicalCleared() {
        //can write the logic
        return medicalCleared;
    }

    @Override
    public String toString() {
        return "Employee Joined Successfully";
    }
}