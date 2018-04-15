package com.softserve.consoleapp.entity;

import com.softserve.service.TimeVisit;

import java.io.*;
import java.util.Date;

/**
 * Created by Serg on 14.04.2018.
 */
public class Talon {
    private int id;
    //private int idTypeDoctor;
    private int idDoctor;
    private int idPatient;
    //private TimeVisit timeVisit;
    //private Date dateVisit;
    private String timeVisit;

    private final static String FILE_TALON="./DataBase/Talon.dat";


    public Talon(int id,
                 //int idTypeDoctor,
                 int idDoctor, int idPatient,
                 //TimeVisit timeVisit, Date dateVisit)
                String timeVisit)
                 {

        this.id = id;
        //this.idTypeDoctor = idTypeDoctor;
        this.idDoctor = idDoctor;
        this.idPatient = idPatient;
        //this.timeVisit = timeVisit;
        this.timeVisit = timeVisit;
    }

    public static int maxIdTalon(){
        int maxId =0;
        String talon="";
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_TALON))) {
            while((talon=reader.readLine())!=null){
                if(maxId<Integer.parseInt(talon.split(";")[0]))
                    maxId=(Integer.parseInt(talon.split(";")[0]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maxId;
    }

    @Override
    public String toString() {
        return "Talon{" +
                "id=" + id +
                //", Type Doctor=" + TypeDoctor.getNameTypeDoctor(idTypeDoctor) +
                ", idDoctor=" + Doctor.getNameDoctorById(idDoctor) +
                //", order patient=" + idPatient +
                ", time visit=" + timeVisit.toString() +
                //", date visit=" + dateVisit +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getIdTypeDoctor() {
//        return idTypeDoctor;
//    }
//
//    public void setIdTypeDoctor(int idTypeDoctor) {
//        this.idTypeDoctor = idTypeDoctor;
//    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getTimeVisit() {
        return timeVisit;
    }

    public void setTimeVisit(String timeVisit) {
        this.timeVisit = timeVisit;
    }

//    public Date getDateVisit() {
//        return dateVisit;
//    }
//
//    public void setDateVisit(Date dateVisit) {
//        this.dateVisit = dateVisit;
//    }


    public void toSave(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_TALON,true))) {
            writer.write("\n" +id+";"+idDoctor+";"+idPatient+";"+timeVisit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talon talon = (Talon) o;

        return id == talon.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
