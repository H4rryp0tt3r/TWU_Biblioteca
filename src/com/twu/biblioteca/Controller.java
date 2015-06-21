package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.NAME_PROMPT_MESSAGE;

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
