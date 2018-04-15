package com.softserve.consoleapp.controller;

import com.softserve.consoleapp.entity.Doctor;
import com.softserve.consoleapp.entity.Patient;
import com.softserve.consoleapp.entity.Talon;
import com.softserve.consoleapp.entity.TypeDoctor;
import com.softserve.consoleapp.view.MenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Serg on 15.04.2018.
 */
public class TalonController {
    public static void getTalonMenu(int idDoctor){
        boolean krit=false;
        BufferedReader reader=new BufferedReader(
                new InputStreamReader(System.in));

        String choiceFIOPatient="";
        int choiceAgePatient=0;
        String choicePhone="";
        String choiceTime="";

        do {
            try {
                System.out.println(MenuView.getPatientMenu(1));
                choiceFIOPatient=reader.readLine();
                if(choiceFIOPatient=="0"){
                    MainController.getMainMenu();
                }else{
                    krit=true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!krit);

        krit=false;
        do {
            try {
                System.out.println(MenuView.getPatientMenu(2));
                choiceAgePatient=Integer.parseInt(reader.readLine());
                if(choiceAgePatient==0){
                    MainController.getMainMenu();
                }else{
                    krit=true;
                }
              } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!krit);

        krit=false;
        do {
            try {
                System.out.println(MenuView.getPatientMenu(3));
                choicePhone=reader.readLine();
                if(choicePhone=="0"){
                    MainController.getMainMenu();
                }else{
                    krit=true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!krit);

        Patient newPatient = new Patient(Patient.maxIdPatient()+1,choiceFIOPatient,choiceAgePatient,choicePhone);
        newPatient.toSavePatient();

        krit=false;
        do {
            try {
                System.out.println(MenuView.getPatientMenu(4));
                choiceTime=reader.readLine();
                if(choiceTime=="0"){
                    MainController.getMainMenu();
                }else{
                    krit=true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!krit);
        Talon newTalon=new Talon(Talon.maxIdTalon()+1,idDoctor,newPatient.getId(),choiceTime);
        newTalon.toSave();
        
        MainController.getMainMenu();
    }

}
