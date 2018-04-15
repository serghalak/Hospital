package com.softserve.consoleapp.controller;

import com.softserve.consoleapp.entity.Doctor;
import com.softserve.consoleapp.entity.TypeDoctor;
import com.softserve.consoleapp.view.MenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Serg on 15.04.2018.
 */
public class DoctorController {
    public static int getDoctorMenu(int idDoctorType){
        boolean krit=false;
        BufferedReader reader=new BufferedReader(
                new InputStreamReader(System.in));
        String choiceDoctorMenu="";
        int choiceNumber=0;
        do {
            try {
                //System.out.println(MenuView.getTypeDoctorMenu(TypeDoctor.getListTypeDoctors()));
                System.out.println(MenuView.getDoctorMenu(Doctor.getDoctorsByType(idDoctorType)));
                choiceDoctorMenu=reader.readLine();
                choiceNumber=Integer.parseInt(choiceDoctorMenu);
                //krit=false;
                if(choiceNumber==0){
                    MainController.getMainMenu();
                }else{
                    //System.out.println(MenuView.getDoctorMenu(Doctor.getDoctorsByType(choiceNumber)));

                    TalonController.getTalonMenu(choiceNumber);
                    krit=true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (NumberFormatException e){
                System.err.println("Choice will be a number. Your variant is " + choiceDoctorMenu);
            }

        }while(!krit);
        return choiceNumber;
    }
}
