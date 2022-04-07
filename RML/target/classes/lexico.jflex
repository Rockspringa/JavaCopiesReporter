package edu.mooncoder.rml.controllers.analyzer.lexic;

import java_cup.runtime.Symbol;

import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.exceptions.AnalysisException;
import edu.mooncoder.rml.exceptions.lexical.NotRecognizedCharactersException;
import edu.mooncoder.rml.controllers.analyzer.syntax.Tokens;

%%

%class HtmlLexer
%unicode
%cupsym Tokens
%cup
%public
%line
%column
%caseless
%ignorecase

%{
  private int stateToReturn = YYINITIAL;
  private final StringBuffer string = new StringBuffer();
  private final StringBuffer error = new StringBuffer();

  private Symbol symbol(int type) {
    addError();
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private void addError() {
    if (error.length() != 0) {
      AnalysisException exception = new NotRecognizedCharactersException(error.toString(), yyline + 1, yycolumn - error.length());
      ErrorsReportBuilder.add(exception);
      error.setLength(0);
    }
  }

  private Symbol symbol(int type, Object value) {
    addError();
    if (type == Tokens.LITERAL)
      return new Symbol(type, yyline + 1, yycolumn - string.length(), value);
    else
      return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }
%}

// To ignore in syntax
BreakLine = \n | \r | \r\n
Spaces = {BreakLine} | [ \t\f]
Comments = "</"

// To token
Int = [0-9]+
Id = [ña-zA-Z$_] [ña-zA-Z_$0-9]+ | [ña-zA-Z$] [ña-zA-Z_$0-9]*

%state COMMENT
%state COMMENT_OUT
%state LITERAL
%state TAGS
%state VARIABLE
%state FOR

%%

// Ignores
<YYINITIAL> {
  {Comments}                     { addError(); stateToReturn = YYINITIAL; yybegin(COMMENT); }
  {Spaces}                       { addError(); }
}

// KeyWords
<YYINITIAL> {
    "String" {Spaces}            { return symbol(Tokens.STRING); }
    "Integer" {Spaces}           { return symbol(Tokens.INTEGER); }
    "RESULT"                     { return symbol(Tokens.RESULT); }
    "<html>"                     { string.setLength(0); yybegin(TAGS); return symbol(Tokens.HTML_B); }
}

// Variables
<YYINITIAL> {
  \"                             { addError(); string.setLength(0); yybegin(LITERAL); }
  {Int}                          { return symbol(Tokens.INT, Integer.parseInt(yytext())); }
  {Id}                           { return symbol(Tokens.ID, yytext()); }
}

// Symbols
<YYINITIAL> {
    ";"                          { return symbol(Tokens.SEPARADOR); }
    "["                          { return symbol(Tokens.COR_IZQ); }
    "]"                          { return symbol(Tokens.COR_DER); }
    "("                          { return symbol(Tokens.PAR_IZQ); }
    ")"                          { return symbol(Tokens.PAR_DER); }
    "."                          { return symbol(Tokens.PUNTO); }
    ","                          { return symbol(Tokens.COMA); }
}

// Operadores
<YYINITIAL> {
    "*"                          { return symbol(Tokens.POR); }
    "/"                          { return symbol(Tokens.DIV); }
    "+"                          { return symbol(Tokens.MAS); }
    "-"                          { return symbol(Tokens.MENOS); }
    "="                          { return symbol(Tokens.IGUAL); }
}

<COMMENT> {
  [^/]                           { /* skip */ }
  "/"                            { yybegin(COMMENT_OUT); }
}

<COMMENT_OUT> {
  [^/>]                          { yybegin(COMMENT); }
  "/"                            { /* skip */ }
  ">"                            { yybegin(stateToReturn); }
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

// Tags keywords
<TAGS> {
  "<table>"                      { return symbol(Tokens.TABLE_B); }
  "</table>"                     { return symbol(Tokens.TABLE_E); }
  "</html>"                      { return symbol(Tokens.HTML_E); }
  "<h1>"                         { return symbol(Tokens.H1_B); }
  "</h1>"                        { return symbol(Tokens.H1_E); }
  "<h2>"                         { return symbol(Tokens.H2_B); }
  "</h2>"                        { return symbol(Tokens.H2_E); }
  "<tr>"                         { return symbol(Tokens.TR_B); }
  "</tr>"                        { return symbol(Tokens.TR_E); }
  "<th>"                         { return symbol(Tokens.TH_B); }
  "</th>"                        { return symbol(Tokens.TH_E); }
  "<td>"                         { return symbol(Tokens.TD_B); }
  "</td>"                        { return symbol(Tokens.TD_E); }
  "<for" {Spaces}+               { yybegin(FOR); return symbol(Tokens.FOR_B); }
  "</for>"                       { return symbol(Tokens.FOR_E); }
  "<br>"                         { return symbol(Tokens.BR); }
}

<TAGS> {
  {Spaces}+                      { addError(); }
  {Comments}                     { addError(); stateToReturn = TAGS; yybegin(COMMENT); }
  "$$" {Spaces}* "("             { addError(); yybegin(VARIABLE); }
  [^\n\r<$] [^\n\r</$]+          { return symbol(Tokens.TEXT, yytext()); }
}

<VARIABLE> {
  {Comments}                     { addError(); stateToReturn = VARIABLE; yybegin(COMMENT); }
  {Spaces}                       { addError(); }
  ")" {Spaces}* "$$"             { addError(); yybegin(TAGS); }
  "RESULT"                       { return symbol(Tokens.RESULT); }
  {Id}                           { return symbol(Tokens.ID, yytext()); }
  "."                            { return symbol(Tokens.PUNTO); }
  {Int}                          { return symbol(Tokens.INT, Integer.parseInt(yytext())); }
  "["                            { return symbol(Tokens.COR_IZQ); }
  "]"                            { return symbol(Tokens.COR_DER); }
}

<FOR> {
  {Comments}                     { addError(); stateToReturn = FOR; yybegin(COMMENT); }
  {Spaces}                       { addError(); }

  "RESULT"                       { return symbol(Tokens.RESULT); }
  {Id}                           { return symbol(Tokens.ID, yytext()); }
  {Int}                          { return symbol(Tokens.INT, Integer.parseInt(yytext())); }

  "."                            { return symbol(Tokens.PUNTO); }
  ";"                            { return symbol(Tokens.SEPARADOR); }
  "["                            { return symbol(Tokens.COR_IZQ); }
  "]"                            { return symbol(Tokens.COR_DER); }

  "iterador" {Spaces}* ":"       { return symbol(Tokens.ITERADOR); }
  "hasta" {Spaces}* ":"          { return symbol(Tokens.HASTA); }
  ">"                            { yybegin(TAGS); return symbol(Tokens.TAG_FOR); }
}

[^] { error.append(yytext()); }
