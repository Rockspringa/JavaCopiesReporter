rm ./src/main/java/edu/mooncoder/rml/controllers/analyzer/lexic/HtmlLexer.java
rm -r ./src/main/java/edu/mooncoder/rml/controllers/analyzer/syntax/*

java -jar C:/Cup/java-cup-11b.jar -parser HtmlParser -symbols Tokens ./src/main/resources/sintaxis.cup
java -jar C:/JFlex/lib/jflex-full-1.8.2.jar -d ./src/main/java/edu/mooncoder/rml/controllers/analyzer/lexic ./src/main/resources/lexico.jflex

mv ./*.java ./src/main/java/edu/mooncoder/rml/controllers/analyzer/syntax/