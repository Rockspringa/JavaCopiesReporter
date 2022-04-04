package edu.mooncoder.rml.services;

import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.rml.controllers.analyzer.lexic.HtmlLexer;
import edu.mooncoder.rml.controllers.analyzer.syntax.HtmlParser;
import edu.mooncoder.rml.controllers.builders.*;
import edu.mooncoder.rml.exceptions.BadWrittenRmlException;
import edu.mooncoder.rml.exceptions.syntactical.IrreparableException;
import edu.mooncoder.rml.model.tags.Document;
import edu.mooncoder.rml.model.tags.Error;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadRml {
    private static ReadRml inst;

    private final File file;
    private Error[] errors;

    public ReadRml(String path, Osrn osrn) {
        inst = this;
        file = new File(path);

        SymbolsTable.addGlobal(osrn);
        HtmlBuilder.initAnalysis();
        TableBuilder.initAnalysis();
        ResultBuilder.initAnalysis();
    }

    public Document getRmlResult() throws FileNotFoundException, BadWrittenRmlException {
        if (this != inst) return null;

        FileReader reader = new FileReader(file);
        HtmlLexer lexer = new HtmlLexer(reader);
        HtmlParser parser = new HtmlParser(lexer);

        try {
            parser.parse();
        } catch (Exception e) {
            ErrorsReportBuilder.add(new IrreparableException(-1, -1));
        }
        errors = ErrorsReportBuilder.close();
        inst = null;

        if (errors.length == 0) {
            return parser.getHtml();
        }
        throw new BadWrittenRmlException();
    }

    public Error[] getErrors() {
        return errors;
    }
}
