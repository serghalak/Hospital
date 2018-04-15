package com.softserve.consoleapp.entity;

import java.io.*;
import java.util.List;

/**
 * Created by Serg on 14.04.2018.
 */
public class Patient {
    private int id;
    private String fio;
    private int age;
    private String phone;

    private final static String FILE_PATIENT="./DataBase/PATIENT.dat";

    public Patient(int id, String fio, int age, String phone) {
        this.id = id;
        this.fio = fio;
        this.age = age;
        this.phone = phone;
    }

    public static int maxIdPatient(){
        int maxId =0;
        String patient="";
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATIENT))) {
            while((patient=reader.readLine())!=null){
                if(maxId<Integer.parseInt(patient.split(";")[0]))
                    maxId=(Integer.parseInt(patient.split(";")[0]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId;
    }

    public void toSavePatient(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATIENT,true))) {
            writer.write("\n" + id+";"+fio+";"+age+";"+phone);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fio='" + fio +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }

}
