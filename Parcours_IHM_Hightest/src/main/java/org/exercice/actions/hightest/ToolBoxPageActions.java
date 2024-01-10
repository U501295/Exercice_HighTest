package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.ToolBoxRepository;
import org.exercice.utils.AutomTools;

public class ToolBoxPageActions {

    ToolBoxRepository toolBoxRepository;

    public void clickISTQBFoundationFrenchButton() {
        toolBoxRepository = new ToolBoxRepository();
        AutomTools.customClick(toolBoxRepository.iSTQBFoundationFrenchButton);
    }
}
