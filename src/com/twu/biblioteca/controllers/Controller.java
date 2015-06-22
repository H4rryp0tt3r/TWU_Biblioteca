package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.NAME_PROMPT_MESSAGE;

public class Controller {
    private IOModule ioModule;

    public Controller(IOModule ioModule) {
        this.ioModule = ioModule;
    }

    public void listAvailableItems(Section sectionOfItems) {
        ioModule.println(sectionOfItems.displayAvailableItemsWithAllDetails());
    }

    public void checkOutAnItem(Section sectionOfItems, String successStatusMessage, String failedStatusMessage, User user) {
        ioModule.print(NAME_PROMPT_MESSAGE);
        String itemName = ioModule.readInput();
        if (sectionOfItems.checkOut(itemName, user))
            ioModule.println(successStatusMessage);
        else
            ioModule.println(failedStatusMessage);
    }

    public void returnAnItem(Section sectionOfItems, String successStatusMessage, String failedStatusMessage, User user) {
        ioModule.print(NAME_PROMPT_MESSAGE);
        String itemName = ioModule.readInput();
        if (sectionOfItems.returnItem(itemName, user))
            ioModule.println(successStatusMessage);
        else
            ioModule.println(failedStatusMessage);
    }
}
