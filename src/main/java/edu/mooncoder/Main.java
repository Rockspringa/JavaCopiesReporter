package edu.mooncoder;

import edu.mooncoder.model.analyzer.lexic.HtmlLexer;
import edu.mooncoder.model.analyzer.syntax.HtmlParser;
import edu.mooncoder.model.analyzer.syntax.Tokens;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C:/Users/dylan/Desktop/Everything,+but+Nothing" +
                "/Programacion+Eliminar/RML/Prueba.rml");

        HtmlLexer lexer = new HtmlLexer(reader);
        HtmlParser parser = new HtmlParser(lexer);

        parser.parse();
    }
}
