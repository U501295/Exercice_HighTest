package org.exercice.actions.hightest;

import org.exercice.object_repository.hightest.ToolBoxRepository;
import org.exercice.utils.AutomTools;
import org.exercice.utils.ProjectRepository;

import static org.exercice.object_repository.hightest.ToolBoxRepository.loadToolBoxContextObjects;

public class ToolBoxPageActions {

    public void clickISTQBFoundationFrenchButton() {
        ToolBoxRepository localContext = loadToolBoxContextObjects();
        AutomTools.customClick(ProjectRepository.getWebElementFromProjectRepo(localContext.getISTQBFoundationFrenchButton()));
    }
}
