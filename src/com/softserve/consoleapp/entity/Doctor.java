package com.softserve.consoleapp.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Serg on 14.04.2018.
 */
public class Doctor {
    private int id;
    private int idDoctorType;
    private String doctorName;
    private final static String FILE_DOCTOR="./DataBase/Doctor.dat";

    public int getId() {
        return id;
    }


    public Doctor(int id, int idDoctorType, String doctorName) {

        this.id = id;
        this.idDoctorType = idDoctorType;
        this.doctorName = doctorName;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getIdDoctorType() {
        return idDoctorType;
    }

    public void setIdDoctorType(int idDoctorType) {
        this.idDoctorType = idDoctorType;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public static Map<Integer,String> getDoctorsByType(int idType){
        Map<Integer,String>mapDoctorByType=new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_DOCTOR))) {
            String doctor="";
            while((doctor=reader.readLine())!=null){
                if(Integer.parseInt(doctor.split(";")[1])==idType) {
                    mapDoctorByType.put(Integer.parseInt(doctor.split(";")[0]), doctor.split(";")[2]);
                    //System.out.println(Integer.parseInt(typeDoctor.split(";")[0])+":" + typeDoctor.split(";")[1]);}
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapDoctorByType;
    }

    public static String getNameDoctorById(int idDoctor){
        String doctor="";
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_DOCTOR))) {
            while((doctor=reader.readLine())!=null){
                if(Integer.parseInt(doctor.split(";")[0])==idDoctor) {
                    return doctor.split(";")[2];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (id != doctor.id) return false;
        if (idDoctorType != doctor.idDoctorType) return false;
        return doctorName.equals(doctor.doctorName);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idDoctorType;
        result = 31 * result + doctorName.hashCode();
        return result;
    }

}
