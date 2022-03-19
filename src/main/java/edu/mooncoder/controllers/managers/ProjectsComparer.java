package edu.mooncoder.controllers.managers;

import edu.mooncoder.controllers.analyzer.lexic.JavaLexer;
import edu.mooncoder.controllers.analyzer.syntax.JavaParser;

import java.io.Reader;
import java.util.List;
import java.util.Map;

public class ProjectsComparer {
    private final ComparedReportBuilder reportBuilder;
    private boolean closedOne;

    public ProjectsComparer() {
        this.reportBuilder = new ComparedReportBuilder();
    }

    public void close() {
        if (closedOne)
            reportBuilder.closeSecondProject();
        else
            reportBuilder.closeFirstProject();

        if (!closedOne)
            closedOne = true;
    }

    public void addReader(Reader reader) {
        try {
            JavaLexer lexer = new JavaLexer(reader);
            JavaParser parser = new JavaParser(lexer);

            parser.parse();
        } catch (Exception e) {
            System.out.println("Ocurrio un error mientras se realizaba el analisis.");
            System.out.println(e.getMessage());
        }
    }

    public Map<String, Object> compare() {
        return reportBuilder.getReportTable();
    }
}
