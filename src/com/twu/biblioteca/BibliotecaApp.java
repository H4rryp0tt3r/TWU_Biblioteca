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
        System.out.println(menu);
    }
}
