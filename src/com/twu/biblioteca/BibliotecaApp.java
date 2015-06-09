package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Library library;

    public BibliotecaApp(Library library){
        this.library = library;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    public void displayMainMenu() {
        System.out.println("==== Main Menu ====");
        System.out.println("1) List Books");
        Scanner sin = new Scanner(System.in);
        System.out.println("Enter your Choice:");
        int userChoice = sin.nextInt();
        if(userChoice == 1)
            library.displayBookListWithAllDetails();
    }

    public static void main(String args[]) {
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(library);
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.displayMainMenu();
    }
}
