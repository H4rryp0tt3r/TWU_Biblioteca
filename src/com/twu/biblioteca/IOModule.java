package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

// This class takes care of IO operations like read from console & print to console
public class IOModule {
    private Scanner inputReader;
    private PrintStream outputRenderer;

    public IOModule(Scanner inputReader, PrintStream outputRenderer) {
        this.inputReader = inputReader;
        this.outputRenderer = outputRenderer;
    }

    public void print(String dataToBeViewed) {
        outputRenderer.print(dataToBeViewed);
    }

    public void println(String dataToBeViewed) {
        outputRenderer.println(dataToBeViewed);
    }

    public String readInput() {
        return inputReader.nextLine();
    }
}
