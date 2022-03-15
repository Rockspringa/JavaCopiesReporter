package edu.mooncoder;

import edu.mooncoder.model.analyzer.lexic.JsonLexer;
import edu.mooncoder.model.analyzer.syntax.JsonParser;
import edu.mooncoder.model.containers.Osrn;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C:/Users/dylan/Desktop/Everything,"
                + "+but+Nothing/Programacion+Eliminar/OSRN/Prueba.json");

        JsonLexer lexer = new JsonLexer(reader);
        JsonParser parser = new JsonParser(lexer);

        parser.parse();
        System.out.println(parser.getOsrn());
    }
}