package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.NAME_PROMPT_MESSAGE;

public class Controller {
    private IOModule ioModule;

    public Controller(IOModule ioModule) {
        this.ioModule = ioModule;
    }

    public void listAvailableItems(Section sectionOfItems) {
        sectionOfItems.displayAvailableItemsWithAllDetails();
    }

    public void checkOutAnItem(Section sectionOfItems, String successStatusMessage, String failedStatusMessage) {
        ioModule.print(NAME_PROMPT_MESSAGE);
        String itemName = ioModule.readInput();
        if (sectionOfItems.checkOut(itemName))
            ioModule.println(successStatusMessage);
        else
            ioModule.println(failedStatusMessage);
    }

    public void returnAnItem(Section sectionOfItems, String successStatusMessage, String failedStatusMessage) {
        ioModule.print(NAME_PROMPT_MESSAGE);
        String itemName = ioModule.readInput();
        if (sectionOfItems.returnItem(itemName))
            ioModule.println(successStatusMessage);
        else
            ioModule.println(failedStatusMessage);
    }
}
