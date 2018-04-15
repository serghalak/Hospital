package com.softserve.consoleapp.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * entity different types of doctor's specializations
 */
public class TypeDoctor {
    private int id;
    private String typeDoctorName;
    private final static String FILE_TYPE_DOCTOR="./DataBase/TypeDoctor.dat";

    public TypeDoctor(int id, String typeDoctorName){
        this.id=id;
        this.typeDoctorName=typeDoctorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeDoctorName() {
        return typeDoctorName;
    }

    public void setTypeDoctorName(String typeDoctorName) {
        this.typeDoctorName = typeDoctorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeDoctor that = (TypeDoctor) o;

        if (id != that.id) return false;
        return typeDoctorName.equals(that.typeDoctorName);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + typeDoctorName.hashCode();
        return result;
    }


    public boolean saveTypeDoctor(){
        return false;
    }

    public static Map<Integer,String> getListTypeDoctors(){
        Map<Integer,String>mapDoctorType=new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_TYPE_DOCTOR))) {
            String typeDoctor="";
            while((typeDoctor=reader.readLine())!=null){
                mapDoctorType.put(Integer.parseInt(typeDoctor.split(";")[0]),typeDoctor.split(";")[1]);
                //System.out.println(Integer.parseInt(typeDoctor.split(";")[0])+":" + typeDoctor.split(";")[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapDoctorType;
    }

    public static String getNameTypeDoctor(int idTypeDoctor){
        for (Map.Entry<Integer,String>typeDoctor:getListTypeDoctors().entrySet()){
           if(typeDoctor.getKey() == idTypeDoctor)
               return typeDoctor.getValue();
        }
        return null;
    }
}
