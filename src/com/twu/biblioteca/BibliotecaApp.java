package com.twu.biblioteca;

import java.io.PrintWriter;
import java.util.Scanner;

public class BibliotecaApp {
    private Library library;
    private IOModule ioModule;
    private Menu menu;

    public BibliotecaApp(Library library, IOModule ioModule, Menu menu) {
        this.library = library;
        this.ioModule = ioModule;
        this.menu = menu;
    }

    public void start() {
        ioModule.print(BibliotecaAppConstants.WELCOME_MESSAGE);
        while (true) {
            ioModule.print(menu.toString());
            int userChoice = Integer.parseInt(ioModule.readInput());
            MenuAction actionToBePerformed = menu.chooseOption(userChoice);
            actionToBePerformed.execute();
        }
    }

    public static void main(String args[]) {
        Scanner inputReader = new Scanner(System.in);
        PrintWriter outputRenderer = new PrintWriter(System.out, true);
        Library library = new Library();
        Menu menu = new Menu(library);
        IOModule ioModule = new IOModule(inputReader, outputRenderer);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(library, ioModule, menu);
        bibliotecaApp.start();
    }
}
