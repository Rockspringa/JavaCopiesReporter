package edu.mooncoder.controllers.managers;

import edu.mooncoder.controllers.analyzer.lexic.JavaLexer;
import edu.mooncoder.controllers.analyzer.syntax.JavaParser;
import edu.mooncoder.exceptions.JavaFilesHasErrorsException;
import edu.mooncoder.model.containers.ErrorsHolder;

import java.io.Reader;
import java.util.List;
import java.util.Map;

public class ProjectsComparer {
    private final ComparedReportBuilder reportBuilder;
    private boolean closedOne;

    public ProjectsComparer() {
        this.reportBuilder = new ComparedReportBuilder();
    }

    public void closeProject() {
        if (closedOne)
            reportBuilder.closeSecondProject();
        else
            reportBuilder.closeFirstProject();

        if (!closedOne)
            closedOne = true;
    }

    public void addReader(Reader reader, String filename) {
        try {
            ErrorsHolder.setFilename(filename);
            JavaLexer lexer = new JavaLexer(reader);
            JavaParser parser = new JavaParser(lexer);

            parser.parse();
        } catch (Exception e) {
            System.out.println("Ocurrio un error mientras se realizaba el analisis.");
            System.out.println(e.getMessage());
        }
    }

    public Map<String, Object> compare() throws JavaFilesHasErrorsException {
        if (isAnalysisWithoutErrors())
            return reportBuilder.getReportTable();
        throw new JavaFilesHasErrorsException();
    }

    public List<Map<String, Object>> getBugs() {
        if (isAnalysisWithoutErrors())
            return null;
        return reportBuilder.getErrorsArray();
    }

    public boolean isAnalysisWithoutErrors() {
        return !reportBuilder.hasErrors();
    }
}
