package edu.mooncoder;

import edu.mooncoder.controllers.managers.ComparedReportBuilder;
import edu.mooncoder.controllers.analyzer.lexic.JavaLexer;
import edu.mooncoder.controllers.analyzer.syntax.JavaParser;
import edu.mooncoder.services.ComparerService;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        ComparerService.runServer(4200);
    }
}