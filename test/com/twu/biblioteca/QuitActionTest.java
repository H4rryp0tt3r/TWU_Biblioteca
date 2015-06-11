package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.QuitAction;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitActionTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldBeAbleToPerformQuitOperationUponUserChoice() {
        QuitAction quitActionOperation = new QuitAction();
        exit.expectSystemExitWithStatus(0);
        quitActionOperation.execute();
    }
}