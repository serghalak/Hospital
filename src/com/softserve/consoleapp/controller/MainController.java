package com.softserve.consoleapp.controller;

import com.softserve.consoleapp.entity.TypeDoctor;
import com.softserve.consoleapp.view.MenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Serg on 14.04.2018.
 */
public class MainController {
    public static void getMainMenu(){
        boolean krit=false;
        BufferedReader reader=new BufferedReader(
                new InputStreamReader(System.in));
        String choiceMainMenu="";

        do {
            try {
                System.out.print(MenuView.getMainMenu());
                choiceMainMenu=reader.readLine();
                int choiceNumber=Integer.parseInt(choiceMainMenu);

                switch (choiceNumber){
                    case 0:
                        System.out.println("Bye!!!");
                        System.exit(0);
                    case 1:
                        System.out.println("Sorry!!! It's doesn't work");
                        //krit=true;
                        break;
                    case 2:
                        System.out.println("Sorry!!! It's doesn't work");
                        //krit=true;
                        break;
                    case 3:
                        //System.out.println("you choice 3");
                        //MainController
                        DoctorTypeController.getDoctorTypeMenu();
                        krit=true;
                        break;
                    default:
                        System.out.println("you have to choose from 0 to 3");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (NumberFormatException e){
                System.err.println("Choice will be a number from 0 to 3. Your variant is " + choiceMainMenu);
            }

        }while(!krit);
    }
}
