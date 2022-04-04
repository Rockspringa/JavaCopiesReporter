package edu.mooncoder.rml;

import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.osrn.services.OsrnFactory;
import edu.mooncoder.rml.controllers.analyzer.lexic.HtmlLexer;
import edu.mooncoder.rml.controllers.analyzer.syntax.HtmlParser;
import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.controllers.builders.SymbolsTable;

import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C:/Users/dylan/Desktop/Everything,+but+Nothing" +
                "/Programacion+Eliminar/RML/Prueba.def");

        HtmlLexer lexer = new HtmlLexer(reader);
        HtmlParser parser = new HtmlParser(lexer);

        Osrn osrn = OsrnFactory.getOsrnByFilename("C:/Users/dylan/Desktop/Everything,+but+Nothing" +
                "/Programacion+Eliminar/OSRN/Prueba.json");

        SymbolsTable.addGlobal(osrn);
        parser.parse();
        System.out.println(Arrays.toString(ErrorsReportBuilder.close()));
        System.out.println(parser.getHtml().getHtmlString());
    }
}
