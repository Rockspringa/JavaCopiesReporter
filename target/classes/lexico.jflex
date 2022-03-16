package edu.mooncoder.model.analyzer.lexic;

import java_cup.runtime.Symbol;

import edu.mooncoder.model.analyzer.syntax.Tokens;

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
  private StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private Symbol symbol(int type, Object value) {
    if (type == Tokens.LITERAL)
      return new Symbol(type, yyline + 1, yycolumn - string.length(), value);
    else
      return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }
%}

// To ignore in syntax
BreakLine = \n | \r | \r\n
Spaces = {BreakLine} | [ \t\f]

Comments = "</" .* ~"/>"

// To token
Int = [0-9]+
Id = [ña-zA-Z$_] [ña-zA-Z_$0-9]+ | [ña-zA-Z$] [ña-zA-Z_$0-9]*

%state LITERAL
%state TAGS
%state VARIABLE
%state FOR

%%

// Ignores
<YYINITIAL> {
  {Comments} |
  {Spaces}                       { /* ignore */ }
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
  \"                             { string.setLength(0); yybegin(LITERAL); }
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
  ({BreakLine} | [\t ])+ |
  {Comments}                     { /* ignore */ }
  "$$" {Spaces}* "("             { yybegin(VARIABLE); }
  [^ \n\r\t<>$] [^<>$]+          { return symbol(Tokens.TEXT, yytext()); }
}

<VARIABLE> {
  {Comments} |
  {Spaces}                       { /* ignore */ }
  ")" {Spaces}* "$$"             { yybegin(TAGS); }
  "RESULT"                       { return symbol(Tokens.RESULT); }
  {Id}                           { return symbol(Tokens.ID, yytext()); }
  "."                            { return symbol(Tokens.PUNTO); }
  {Int}                          { return symbol(Tokens.INT, Integer.parseInt(yytext())); }
  "["                            { return symbol(Tokens.COR_IZQ); }
  "]"                            { return symbol(Tokens.COR_DER); }
}

<FOR> {
  {Comments} |
  {Spaces}                       { /* ignore */ }

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

[^] { System.out.println("error: " + (yyline + 1) + ", " + (yycolumn + 1)); }
