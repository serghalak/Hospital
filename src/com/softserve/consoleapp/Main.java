package com.softserve.consoleapp;

import com.softserve.consoleapp.controller.MainController;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MainController mainController = new MainController();
        mainController.getMainMenu();
    }
}
