package edu.mooncoder.model.analyzer.lexic;

import java_cup.runtime.Symbol;
import edu.mooncoder.model.analyzer.syntax.Tokens;

%%

%class JsonLexer
%unicode
%cupsym Tokens
%cup
%public
%line
%column

%{
  private StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }
%}

// To ignore in syntax
BreakLine = \n | \r | \r\n
Spaces = {BreakLine} | [ \t\f]

LineComments = "//" [^\r\n]* {BreakLine}?
BlockComments = "/*" .* ~"*/"

// To token
Visibility = ("private" | "public" | "protected") {Spaces}
UnaryOperators = "++" | "--"
LogicOperators = "&&" | "||" | "&" | "^" | "|"
RelationalOperators = "==" | "!=" | "<" | ">" | "<=" | ">="

Type = ("int" | "boolean" | "String" | "char" | "double") {Spaces}

Int = [0-9]+
Double =  {Int}? "." {Int}
Id = [a-zA-Z$_] [a-zA-Z_$0-9]+ | [a-zA-Z$] [a-zA-Z_$0-9]*

%state LITERAL

%%

// Ignores
<YYINITIAL> {
  {BlockComments} |
  {LineComments}                 { /* ignore */ }
  {Spaces}                       { /* ignore */ }
}

// KeyWords
<YYINITIAL> {
    {Visibility}                 { return symbol(Tokens.VISIBILITY); }
    {Type}                       { return symbol(Tokens.TYPE); }
    "new" {Spaces}               { return symbol(Tokens.NEW); }
    "final" {Spaces}             { return symbol(Tokens.FINAL); }
    "import" {Spaces}            { return symbol(Tokens.IMPORT); }
    "package" {Spaces}           { return symbol(Tokens.PACKAGE); }
    "class" {Spaces}             { return symbol(Tokens.CLASS); }
    "void" {Spaces}              { return symbol(Tokens.VOID); }
    "if"                         { return symbol(Tokens.IF); }
    "else"                       { return symbol(Tokens.ELSE); }
    "for"                        { return symbol(Tokens.FOR); }
    "while"                      { return symbol(Tokens.WHILE); }
    "do"                         { return symbol(Tokens.DO); }
    "switch"                     { return symbol(Tokens.SWITCH); }
    "case"                      { return symbol(Tokens.BREAK); }
    "default"                     { return symbol(Tokens.RETURN); }
    "break"                      { return symbol(Tokens.BREAK); }
    "return"                     { return symbol(Tokens.RETURN); }
    "true" | "false"             { return symbol(Tokens.BOOL); }
}

// Variables
<YYINITIAL> {
  \"                             { string.setLength(0); yybegin(LITERAL); }

  "'" \\t "'"                    { return symbol(Tokens.CHAR, '\t'); }
  "'" \\n "'"                    { return symbol(Tokens.CHAR, '\n'); }
  "'" \\r "'"                    { return symbol(Tokens.CHAR, '\r'); }
  "'" \\\" "'"                   { return symbol(Tokens.CHAR, '\"'); }
  "'" \\ "'"                     { return symbol(Tokens.CHAR, '\\'); }
  "'" [^\n\r\"\\] "'"            { return symbol(Tokens.CHAR, yytext().charAt(1)); }

  {Int}                          { return symbol(Tokens.ENTERO); }
  {Double}                       { return symbol(Tokens.DECIMAL); }
  {Id}                           { return symbol(Tokens.ID); }
}

// Symbols
<YYINITIAL> {
    "."                          { return symbol(Tokens.PUNTO); }
    "{"                          { return symbol(Tokens.LLA_IZQ); }
    "}"                          { return symbol(Tokens.LLA_DER); }
    "("                          { return symbol(Tokens.PAR_IZQ); }
    ")"                          { return symbol(Tokens.PAR_DER); }
    ";"                          { return symbol(Tokens.SEPARADOR); }
    ":"                          { return symbol(Tokens.COLON); }
    ","                          { return symbol(Tokens.COMA); }
}

// Operadores
<YYINITIAL> {
    {UnaryOperators}             { return symbol(Tokens.UNARY); }
    {LogicOperators}             { return symbol(Tokens.LOGIC); }
    {RelationalOperators}        { return symbol(Tokens.RELATIONAL); }
    "!"                          { return symbol(Tokens.NEGAR); }
    "*"                          { return symbol(Tokens.POR); }
    "/"                          { return symbol(Tokens.DIV); }
    "%"                          { return symbol(Tokens.MOD); }
    "-"                          { return symbol(Tokens.MENOS); }
    "+"                          { return symbol(Tokens.MAS); }
    "="                          { return symbol(Tokens.IGUAL); }
}

<LITERAL> {
  \"                             { yybegin(YYINITIAL); return symbol(Tokens.LITERAL, string.toString()); }

  [^\n\r\"\\]+                   { string.append(yytext()); }

  \\t                            { string.append('\t'); }

  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }

  \\\"                           { string.append('\"'); }

  \\                             { string.append('\\'); }
}

[^] { System.out.println("error: " + (yyline + 1) + ", " + (yycolumn + 1)); }