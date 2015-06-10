package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Library library;

    public BibliotecaApp(Library library) {
        this.library = library;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    public static void main(String args[]) {
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(library);
        Menu menu = new Menu(library);
        bibliotecaApp.printWelcomeMessage();
        while (true) {
            System.out.println(menu);
            Scanner inp = new Scanner(System.in);
            int userChoice = inp.nextInt();
            MenuAction actionToBePerformed = menu.chooseOption(userChoice);
            actionToBePerformed.execute();
        }
    }
}
