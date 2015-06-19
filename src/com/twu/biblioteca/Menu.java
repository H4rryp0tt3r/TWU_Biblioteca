package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.MenuAction;

import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.INVALID_OPTION;
import static com.twu.biblioteca.BibliotecaAppConstants.MENU_PROMPT;

// This class will take care of Menu of our Application and it has methods to chooseOption from Menu & addOption to Menu.
public class Menu {
    private HashMap<Integer, String> optionList;
    private HashMap<Integer, MenuAction> actionList;
    private IOModule ioModule;

    public Menu(HashMap<Integer, String> optionList, HashMap<Integer, MenuAction> actionList, IOModule ioModule) {
        this.optionList = optionList;
        this.actionList = actionList;
        this.ioModule = ioModule;
    }

    @Override
    public String toString() {
        String menuText = "";
        for (Integer option : optionList.keySet())
            if (option != INVALID_OPTION)
                menuText += option + ") " + optionList.get(option) + "\n";
        return menuText;
    }

    public MenuAction chooseOption() {
        ioModule.println(this.toString());
        ioModule.print(MENU_PROMPT);
        int userChoice = Integer.parseInt(ioModule.readInput());
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
