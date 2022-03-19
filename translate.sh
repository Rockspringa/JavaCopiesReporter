rm ./src/main/java/edu/mooncoder/controllers/analyzer/lexic/JavaLexer.java
rm -r ./src/main/java/edu/mooncoder/controllers/analyzer/syntax/*

java -jar C:/Cup/java-cup-11b.jar -parser JavaParser -symbols Tokens ./src/main/resources/sintaxis.cup
java -jar C:/JFlex/lib/jflex-full-1.8.2.jar -d ./src/main/java/edu/mooncoder/controllers/analyzer/lexic ./src/main/resources/lexico.jflex

mv ./*.java ./src/main/java/edu/mooncoder/controllers/analyzer/syntax/