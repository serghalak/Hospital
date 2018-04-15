package com.softserve.consoleapp.view;

import com.softserve.consoleapp.entity.TypeDoctor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Serg on 14.04.2018.
 */
public class MenuView {

    public static StringBuilder getMainMenu(){
        StringBuilder mainMenu=new StringBuilder();

        mainMenu.append("Choose your variant:\n\r");
        mainMenu.append("1. Administrator\n\r");
        mainMenu.append("2. Doctor.dat\n\r");
        mainMenu.append("3. Patient\n\r");
        mainMenu.append("0. Exit\n\r");

        return mainMenu;
    }

    public static StringBuilder getTypeDoctorMenu(Map<Integer,String> typeDoctorMap){
        StringBuilder typeDoctorMenu=new StringBuilder();
        typeDoctorMenu.append("Choose a doctor type\n\r");
        for (Map.Entry<Integer,String>typeDoctor:typeDoctorMap.entrySet()){
            //typeDoctorMenu.append()
            //System.out.println(typeDoctor.getKey()+":"+typeDoctor.getValue());
            typeDoctorMenu.append(typeDoctor.getKey()+":"+typeDoctor.getValue()+"\n\r");
        }
        typeDoctorMenu.append(0+":"+"Previous menu");
        return typeDoctorMenu;
    }

    public static StringBuilder getDoctorMenu(Map<Integer,String> doctorMap){
        StringBuilder doctorMenu=new StringBuilder();
        doctorMenu.append("Choose a doctor\n\r");
        for (Map.Entry<Integer,String>doctor:doctorMap.entrySet()){
            doctorMenu.append(doctor.getKey()+":"+doctor.getValue()+"\n\r");
        }
        doctorMenu.append(0+":"+"Previous menu");
        return doctorMenu;
    }

    public static String getPatientMenu(int choiceMenu){
        switch (choiceMenu){
            case 1:return "Enter your FIO: (0 for exit)";
            case 2:return "Enter your age: (0 for exit)";
            case 3:return "Enter your phone number: (0 for exit)";
            case 4:return "Enter your time visit: (0 for exit)";
            default:return null;
        }
    }

}
