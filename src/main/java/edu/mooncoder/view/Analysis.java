package edu.mooncoder.view;

import edu.mooncoder.controller.ProjectManager;
import edu.mooncoder.osrn.exceptions.AnalysisException;
import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.osrn.services.OsrnFactory;
import edu.mooncoder.rml.exceptions.BadWrittenRmlException;
import edu.mooncoder.rml.model.tags.Error;
import edu.mooncoder.rml.services.ReadRml;
import edu.mooncoder.view.components.TextPaneWithListeners;
import edu.mooncoder.view.contracts.LookTheme;
import edu.mooncoder.view.contracts.ProjectViewManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Analysis extends JFrame implements LookTheme, ProjectViewManager {
    private static final Object[] titles = {"Lexema", "Linea", "Columna", "Tipo", "Descripcion"};
    private static final String errorTitle = "Analisis con errores";

    private final JMenuBar menuBar;

    private TextPaneWithListeners rmlPanel;
    private TextPaneWithListeners osrnPanel;
    private JTextPane createdReports;

    private JTabbedPane tabbedAnalysis;
    private JButton analyzeBtn;
    private JPanel contentPane;
    private JPanel caretPanel;
    private JTable logTable;

    private ProjectManager projectManager;
    private boolean alreadyConstructed;

    public Analysis() {
        super("Java Copies Reporter");
        setLayout(new BorderLayout(3, 3));
        add(contentPane);

        logTable.setModel(new DefaultTableModel(new Object[0][], titles) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tabbedAnalysis.setUI(new BasicTabbedPaneUI());

        menuBar = new JMenuBar();
        setJMenuBar(this.menuBar);

        addFileMenus();
        menuBar.add(new JToolBar(JToolBar.VERTICAL));

        analyzeBtn.addActionListener(this::analyzeByTab);

        setBounds(0, 0, 550, 550);
        setMinimumSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void showErrors(OsrnFactory factory, ReadRml readRml, String message) {
        List<Object[]> rows = new ArrayList<>();
        DefaultTableModel model;

        for (AnalysisException error : factory.getErrors()) {
            rows.add(error.getDataRow());
        }
        for (Error error : readRml.getErrors()) {
            rows.add(error.getDataRow());
        }
        model = new DefaultTableModel(rows.toArray(new Object[0][]), titles) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        logTable.setModel(model);

        if (message != null) {
            tabbedAnalysis.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, message, errorTitle, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void analyzeByTab(ActionEvent event) {
        OsrnFactory factory = new OsrnFactory();
        ReadRml readRml = null;
        String message = null;

        try {
            Osrn osrn = factory.getOsrnByString(osrnPanel.getText());
            readRml = new ReadRml(rmlPanel.getText(), osrn, false);
            createdReports.setText(readRml.getRmlResult().getHtmlString());

            if (factory.getErrors().length != 0) {
                throw new Exception();
            }
            if (tabbedAnalysis.getSelectedIndex() != 2) {
                tabbedAnalysis.setSelectedIndex(2);
            }
        } catch (BadWrittenRmlException ignore) {
            if (rmlPanel.getText().isBlank()) {
                message = "El entrada para el reporte esta en blanco.";
            } else {
                message = "El reporte presenta errores, para mas informacion acuda a 'Problemas'";
            }
        } catch (Exception ignore) {
            if (osrnPanel.getText().isBlank()) {
                message = "El entrada para el json esta en blanco.";
            } else {
                message = "El JSON presenta errores, para mas informacion acuda a 'Problemas'";
            }
        }
        showErrors(factory, readRml, message);
    }

    private void addTabs() {
        rmlPanel = new TextPaneWithListeners();
        tabbedAnalysis.add(projectManager.getReportName(), rmlPanel);

        osrnPanel = new TextPaneWithListeners();
        tabbedAnalysis.add(projectManager.getResultName(), osrnPanel);

        JPanel noWrapPanel = new JPanel(new BorderLayout());

        createdReports = new JTextPane();
        createdReports.setContentType("text/html");
        createdReports.setForeground(FG_INPUT);
        noWrapPanel.add(createdReports);

        JScrollPane inputPanel = new JScrollPane(noWrapPanel);
        inputPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        inputPanel.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
        tabbedAnalysis.add("Reportes", inputPanel);

        caretPanel.add(rmlPanel.getCaretInfo());
        tabbedAnalysis.addChangeListener(e -> {
            caretPanel.removeAll();

            switch (tabbedAnalysis.getSelectedIndex()) {
                case 0 -> caretPanel.add(rmlPanel.getCaretInfo());
                case 1 -> caretPanel.add(osrnPanel.getCaretInfo());
                case 2 -> analyzeBtn.doClick();
            }

            caretPanel.revalidate();
            caretPanel.repaint();
        });
    }

    private void addFileMenus() {
        JMenu fileMenu = new JMenu("Archivo");
        menuBar.add(fileMenu);

        JMenuItem newFileBtn = new JMenuItem("Nuevo...");
        newFileBtn.addActionListener(e -> principal.runUI());
        fileMenu.add(newFileBtn);

        JMenuItem openFileBtn = new JMenuItem("Abrir...");
        openFileBtn.addActionListener(this::openProject);
        fileMenu.add(openFileBtn);

        fileMenu.addSeparator();

        JMenuItem saveFileBtn = new JMenuItem("Guardar");
        saveFileBtn.addActionListener(e -> {
            try {
                projectManager.saveProgress(rmlPanel.getText(), osrnPanel.getText());
            } catch (IOException ex) {
                String title = "Error al guardar";
                String message = "No se pudo guardar el progreso, verifique la existencia de los archivos.";
                JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
            }
        });
        fileMenu.add(saveFileBtn);

        JMenuItem saveFileLikeBtn = new JMenuItem("Guardar Como...");
        saveFileLikeBtn.addActionListener(e -> saveReport(osrnPanel.getText(), rmlPanel.getText()));
        fileMenu.add(saveFileLikeBtn);
    }

    private void addEditMenus() {
        JMenu editMenu = new JMenu("Editar");
        menuBar.add(editMenu);

        JMenuItem undoBtn = new JMenuItem("Deshacer...");
        undoBtn.addActionListener(rmlPanel.getUndoAction());
        undoBtn.addActionListener(osrnPanel.getUndoAction());
        editMenu.add(undoBtn);

        JMenuItem redoBtn = new JMenuItem("Rehacer...");
        redoBtn.addActionListener(rmlPanel.getRedoAction());
        redoBtn.addActionListener(osrnPanel.getRedoAction());
        editMenu.add(redoBtn);

        editMenu.addSeparator();

        JMenuItem cutBtn = new JMenuItem("Cortar");
        cutBtn.addActionListener(rmlPanel.getCutAction());
        cutBtn.addActionListener(osrnPanel.getCutAction());
        editMenu.add(cutBtn);

        JMenuItem copyBtn = new JMenuItem("Copiar");
        copyBtn.addActionListener(rmlPanel.getCopyAction());
        copyBtn.addActionListener(osrnPanel.getCopyAction());
        editMenu.add(copyBtn);

        JMenuItem pasteBtn = new JMenuItem("Pegar");
        pasteBtn.addActionListener(rmlPanel.getPasteAction());
        pasteBtn.addActionListener(osrnPanel.getPasteAction());
        editMenu.add(pasteBtn);
    }

    public void runUi(ProjectManager project) throws IOException {
        projectManager = project;

        tabbedAnalysis.removeAll();
        addTabs();
        if (!alreadyConstructed) {
            addEditMenus();
            alreadyConstructed = true;
        }

        osrnPanel.setText(projectManager.getResult());
        rmlPanel.setText(projectManager.getReport());

        setVisible(true);
        setLocationRelativeTo(null);

        principal.dispose();
    }

    public boolean saveAndContinue() {
        if (wantToSave()) {
            try {
                projectManager.saveProgress(rmlPanel.getText(), osrnPanel.getText());
            } catch (IOException e) {
                if (!wantToContinue("No se pudo guardar el progreso.\n")) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void dispose() {
        if (wantToClose()) {
            if (saveAndContinue()) {
                super.dispose();
                if (!principal.isVisible()) {
                    System.exit(0);
                }
            }
        }
    }
}
