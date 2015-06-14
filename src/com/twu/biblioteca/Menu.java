package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.MenuAction;

import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.INVALID_OPTION;

// This class will take care of Menu of our Application and it has methods to chooseOption from Menu & addOption to Menu.
public class Menu {
    private HashMap<Integer, String> optionList;
    private HashMap<Integer, MenuAction> actionList;

    public Menu(HashMap<Integer, String> optionList, HashMap<Integer, MenuAction> actionList) {
        this.optionList = optionList;
        this.actionList = actionList;
    }

    @Override
    public String toString() {
        String menuText = "";
        for (Integer option : optionList.keySet())
            if (option != INVALID_OPTION)
                menuText += option + ") " + optionList.get(option) + "\n";
        return menuText;
    }

    public MenuAction chooseOption(int userChoice) {
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
