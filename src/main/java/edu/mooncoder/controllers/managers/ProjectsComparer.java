package edu.mooncoder.controllers.managers;

import edu.mooncoder.controllers.analyzer.lexic.JavaLexer;
import edu.mooncoder.controllers.analyzer.syntax.JavaParser;
import edu.mooncoder.exceptions.JavaFilesHasErrorsException;
import edu.mooncoder.model.containers.ErrorsHolder;
import edu.mooncoder.model.wrappers.Error;
import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.osrn.services.OsrnFactory;

import java.io.Reader;
import java.util.List;

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

    public Osrn compare() throws JavaFilesHasErrorsException {
        if (isAnalysisWithoutErrors())
            return OsrnFactory.getOsrnByMap(reportBuilder.getReportTable());
        throw new JavaFilesHasErrorsException();
    }

    public List<Error> getBugs() {
        if (isAnalysisWithoutErrors())
            return null;
        return reportBuilder.getErrorsArray();
    }

    public boolean isAnalysisWithoutErrors() {
        return !reportBuilder.hasErrors();
    }
}
