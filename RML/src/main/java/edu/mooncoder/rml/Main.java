package edu.mooncoder.rml;

import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.osrn.services.OsrnFactory;
import edu.mooncoder.rml.controllers.analyzer.lexic.HtmlLexer;
import edu.mooncoder.rml.controllers.analyzer.syntax.HtmlParser;
import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.controllers.builders.SymbolsTable;
import edu.mooncoder.rml.services.ReadRml;

import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadRml readRml = new ReadRml("C:/Users/dylan/Desktop/Everything,+but+Nothing" +
                "/Programacion+Eliminar/RML/Prueba.def", null, true);
        System.out.println(readRml.getRmlResult());
        System.out.println(Arrays.toString(ErrorsReportBuilder.close()));
    }
}
