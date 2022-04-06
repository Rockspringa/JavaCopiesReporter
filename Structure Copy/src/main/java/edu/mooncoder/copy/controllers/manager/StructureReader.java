package edu.mooncoder.copy.controllers.manager;

import edu.mooncoder.copy.controllers.analyzer.lexic.CopyLexer;
import edu.mooncoder.copy.controllers.analyzer.syntax.CopyParser;
import edu.mooncoder.copy.controllers.containers.StructureHolder;
import edu.mooncoder.copy.model.PathFile;

import java.io.FileReader;

public class StructureReader {
    public PathFile[] getFiles(String path) throws Exception {
        FileReader reader = new FileReader(path);

        CopyLexer lexer = new CopyLexer(reader);
        CopyParser parser = new CopyParser(lexer);

        parser.parse();

        return StructureHolder.close();
    }
}
