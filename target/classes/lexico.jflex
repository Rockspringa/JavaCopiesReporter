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

// To token
Int = [0-9]+
Number =  "-"? {Int} ("." {Int})?
Boolean =  "true" | "false"
Null = "null"
Id = [a-zA-Z$_] [a-zA-Z_$0-9]+ | [a-zA-Z$] [a-zA-Z_$0-9]*

%state LITERAL

%%

// Ignores
<YYINITIAL> {
  {Spaces}                       { /* ignore */ }
}

// Variables
<YYINITIAL> {
  \"                             { string.setLength(0); yybegin(LITERAL); }
  {Number}                       { return symbol(Tokens.NUMBER, Double.parseDouble(yytext())); }
  {Boolean}                      { return symbol(Tokens.BOOLEAN, Boolean.parseBoolean(yytext())); }
  {Null}                         { return symbol(Tokens.NULL, null); }
  {Id}                           { return symbol(Tokens.ID, yytext()); }
}

// Symbols
<YYINITIAL> {
    "["                          { return symbol(Tokens.BRA_IZQ); }
    "]"                          { return symbol(Tokens.BRA_DER); }
    "{"                          { return symbol(Tokens.CUR_IZQ); }
    "}"                          { return symbol(Tokens.CUR_DER); }
    ":"                          { return symbol(Tokens.COLON); }
    ","                          { return symbol(Tokens.COMMA); }
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
