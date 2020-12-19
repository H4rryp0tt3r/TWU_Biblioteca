package com.twu.biblioteca.models;

import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.views.IOModule;

import java.util.HashMap;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.INVALID_OPTION;
import static com.twu.biblioteca.constants.BibliotecaAppConstants.MENU_PROMPT;

// This class will take care of Menu of our Application and it has methods to chooseOption from Menu & addOption to Menu.
public class Menu {
    private final HashMap<Integer, String> optionList;
    private final HashMap<Integer, MenuAction> actionList;
    private final IOModule ioModule;

    public Menu(HashMap<Integer, String> optionList, HashMap<Integer, MenuAction> actionList, IOModule ioModule) {
        this.optionList = optionList;
        this.actionList = actionList;
        this.ioModule = ioModule;
    }

    @Override
    public String toString() {
        StringBuilder menuText = new StringBuilder();
        for (Integer option : optionList.keySet())
            if (option != INVALID_OPTION)
                menuText.append(option).append(") ").append(optionList.get(option)).append("\n");
        return menuText.toString();
    }

    public MenuAction chooseOption() {
        ioModule.println(this.toString());
        ioModule.print(MENU_PROMPT);
        int userChoice;
        try {
            userChoice = Integer.parseInt(ioModule.readInput());
        } catch (Exception exception) {
            return actionList.get(INVALID_OPTION);
        }
        if (isListedInOptions(userChoice))
            return actionList.get(userChoice);
        else
            return actionList.get(INVALID_OPTION);
    }

    public void addOption(int menuItemNumber, String menuItemDescription, MenuAction menuAction) {
        optionList.put(menuItemNumber, menuItemDescription);
        actionList.put(menuItemNumber, menuAction);
    }

    private boolean isListedInOptions(int userChoice) {
        return actionList.containsKey(userChoice);
    }
}
