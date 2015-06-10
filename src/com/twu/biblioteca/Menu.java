package com.twu.biblioteca;

import java.util.HashMap;

public class Menu {
    private Library library;
    private HashMap<Integer, String> optionList;
    private HashMap<Integer, MenuAction> actionList;

    public Menu(Library library) {
        this.library = library;
        optionList = new HashMap<>();
        actionList = new HashMap<>();
        optionList.put(1, "List Books");
        actionList.put(1, new ListBooksAction(library));
        optionList.put(2, "Quit");
        actionList.put(2, new QuitAction());
    }

    @Override
    public String toString() {
        String menuText = "";
        for (Integer option : optionList.keySet())
            menuText += option + ") " + optionList.get(option) + "\n";
        return menuText;
    }

    public MenuAction chooseOption(int userChoice) {
        return actionList.get(userChoice);
    }
}
