package edu.mooncoder;

import edu.mooncoder.view.contracts.ProjectViewManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProjectViewManager.principal::runUI);
    }
}
