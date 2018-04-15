package com.softserve.consoleapp.controller;

import com.softserve.consoleapp.entity.Doctor;
import com.softserve.consoleapp.entity.Talon;
import com.softserve.consoleapp.entity.TypeDoctor;
import com.softserve.consoleapp.view.MenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.softserve.consoleapp.controller.DoctorController.getDoctorMenu;

/**
 * Created by Serg on 14.04.2018.
 */
public class DoctorTypeController {

    public static void getDoctorTypeMenu(){
        boolean krit=false;
        BufferedReader reader=new BufferedReader(
                new InputStreamReader(System.in));
        String choiceDoctorTypeMenu="";

        do {
            try {
                System.out.println(MenuView.getTypeDoctorMenu(TypeDoctor.getListTypeDoctors()));
                choiceDoctorTypeMenu=reader.readLine();
                int choiceNumber=Integer.parseInt(choiceDoctorTypeMenu);
                if(choiceNumber==0){
                    MainController.getMainMenu();
                }else{
                    int idDoctor=DoctorController.getDoctorMenu(choiceNumber);
                    TalonController.getTalonMenu(idDoctor);
                    krit=true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (NumberFormatException e){
                System.err.println("Choice will be a number. Your variant is " + choiceDoctorTypeMenu);
            }

        }while(!krit);
    }
}
