package com.twu.biblioteca;

import java.util.HashMap;

public class Menu {
    private Library library;
    private HashMap<Integer, String> optionList;

    public Menu(Library library) {
        this.library = library;
        optionList = new HashMap<>();
        optionList.put(1, "List Books");
        optionList.put(2, "Quit");
    }

    @Override
    public String toString() {
        String menuText = "";
        for (Integer option : optionList.keySet())
            menuText += option + ") " + optionList.get(option) + "\n";
        return menuText;
    }
}
