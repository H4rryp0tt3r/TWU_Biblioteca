package com.twu.biblioteca;

import java.io.PrintWriter;
import java.util.Scanner;

public class IOModule {
    private Scanner inputReader;
    private PrintWriter outputRenderer;

    public IOModule(Scanner inputReader, PrintWriter outputRenderer) {
        this.inputReader = inputReader;
        this.outputRenderer = outputRenderer;
    }

    public void print(String dataToBeViewed) {
        outputRenderer.println(dataToBeViewed);
    }

    public String readInput() {
        return inputReader.nextLine();
    }

    public boolean hasNextInput() {
        return inputReader.hasNext();
    }
}
