package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.IOModule;

public class PrintCheckOutHistoryAction implements MenuAction {
    private Section bookSection;
    private Section movieSection;
    private IOModule ioModule;

    public PrintCheckOutHistoryAction(Section bookSection, Section movieSection, IOModule ioModule) {
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.ioModule = ioModule;
    }

    @Override
    public void execute() {
        ioModule.println("\n------------------------------------------------------------------------------------------------------------------");
        ioModule.print(bookSection.displayCheckedOutItemDetails()+movieSection.displayCheckedOutItemDetails());
        ioModule.print("------------------------------------------------------------------------------------------------------------------\n\n");
    }
}
