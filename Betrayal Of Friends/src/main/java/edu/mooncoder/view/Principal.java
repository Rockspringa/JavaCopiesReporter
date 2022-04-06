package edu.mooncoder.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.mooncoder.controller.ProjectsProcessor;
import edu.mooncoder.exceptions.AnalysisFailedException;
import edu.mooncoder.view.contracts.LookTheme;
import edu.mooncoder.view.contracts.ProjectViewManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class Principal extends JFrame implements LookTheme, ProjectViewManager {
    private static final String errorMessage = "Los projectos tienen %s errores.\nContacte al servidor para mas informacion.";
    private static final String errorTitle = "Analisis fallido";
    private final JMenuBar menuBar;

    private JButton project1Btn;
    private JLabel selected1Lbl;
    private JButton project2Btn;
    private JLabel selected2Lbl;
    private JPanel contentPane;

    private File firstProject;
    private File secondProject;

    private void analyzeProjects() {
        try (var processor = new ProjectsProcessor("127.0.0.1", 4200)) {
            processor.sendProject(firstProject);
            processor.sendProject(secondProject);

            saveReport(processor.getReport());
        } catch (AnalysisFailedException e) {
            String errorMessageFormatted = String.format(errorMessage, e.getErrors().length);
            JOptionPane.showMessageDialog(this, errorMessageFormatted, errorTitle, JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException | IOException e) {
            String errorMessageFormatted = "Ocurrio un error durante el analisis con respecto a los archivos enviados.";
            JOptionPane.showMessageDialog(this, errorMessageFormatted, errorTitle, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addFileMenus() {
        JMenu fileMenu = new JMenu("Archivo");
        menuBar.add(fileMenu);

        JMenuItem openFileBtn = new JMenuItem("Abrir...");
        openFileBtn.addActionListener(this::openProject);
        fileMenu.add(openFileBtn);
    }

    private void addListeners() {
        project1Btn.addActionListener(e -> {
            File dir = getDirectory("Cargar Projecto 1", false);
            if (dir != null) {
                firstProject = dir;
                selected1Lbl.setText(dir.getName());
            }
        });

        project2Btn.addActionListener(e -> {
            File dir = getDirectory("Cargar Projecto 2", false);
            if (dir != null) {
                secondProject = dir;
                selected2Lbl.setText(dir.getName());
            }
        });
    }

    private void analyzeProjects(ActionEvent event) {
        if (firstProject != null && secondProject != null) {
            analyzeProjects();
        } else {
            String errorMessageFormatted = "La comparacion se realiza entre dos projectos java, que debe de cargar.";
            JOptionPane.showMessageDialog(this, errorMessageFormatted, errorTitle, JOptionPane.ERROR_MESSAGE);
        }
    }

    public Principal() {
        super("Java Copies Reporter");
        setLayout(new BorderLayout(3, 3));
        setBackground(BG_PANEL);
        runUIManager();

        JLabel title = new JLabel("Java Projects Comparer");
        title.setFont(FONT_BOLDER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        add(title, BorderLayout.PAGE_START);

        add(contentPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        add(btnPanel, BorderLayout.PAGE_END);

        JButton toAnalysisInterface = new JButton("Analizar");
        btnPanel.add(toAnalysisInterface);

        toAnalysisInterface.addActionListener(this::analyzeProjects);

        menuBar = new JMenuBar();
        setJMenuBar(this.menuBar);

        addFileMenus();
        addListeners();

        setBounds(0, 0, 350, 250);
        setMinimumSize(new Dimension(350, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void runUI() {
        setVisible(true);
        setLocationRelativeTo(null);

        if (analysis.isVisible()) analysis.dispose();
        if (analysis.isVisible()) dispose();
    }
}
