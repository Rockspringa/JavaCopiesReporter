package edu.mooncoder;

import edu.mooncoder.model.analyzer.lexic.JavaLexer;
import edu.mooncoder.model.analyzer.syntax.JavaParser;
import edu.mooncoder.model.containers.ClassesHolder;
import edu.mooncoder.model.containers.CommentsHolder;
import edu.mooncoder.model.containers.MethodsHolder;
import edu.mooncoder.model.containers.VariablesHolder;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C:/Users/dylan/Desktop/Everything,+but+Nothing" +
                "/Programacion+Eliminar/ObjectScript/Prueba.jav");

        JavaLexer lexer = new JavaLexer(reader);
        JavaParser parser = new JavaParser(lexer);

        parser.parse();

        System.out.println(CommentsHolder.clean());
        System.out.println(VariablesHolder.clean());
        System.out.println(MethodsHolder.clean());
        System.out.println(ClassesHolder.clean());
    }
}