package edu.mooncoder.controllers.analyzer.lexic;

import java_cup.runtime.Symbol;

import edu.mooncoder.controllers.wrapper.ErrorWrapper;
import edu.mooncoder.controllers.analyzer.syntax.Tokens;

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
  private StringBuffer error = new StringBuffer();

  private Symbol symbol(int type) {
    chargeError();
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private void chargeError() {
    if (error.length() != 0) {
      ErrorWrapper.addLexicalError(yyline + 1, yycolumn + 1 - error.length(), error.toString());
      error.setLength(0);
    }
  }

  private Symbol symbol(int type, Object value) {
    chargeError();
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
  {Spaces}                       { chargeError(); }
}

// Variables
<YYINITIAL> {
  \"                             { chargeError(); string.setLength(0); yybegin(LITERAL); }
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

  [^\n\r\"\\]+                   { chargeError(); string.append(yytext()); }

  \\t                            { chargeError(); string.append('\t'); }

  \\n                            { chargeError(); string.append('\n'); }

  \\r                            { chargeError(); string.append('\r'); }

  \\\"                           { chargeError(); string.append('\"'); }

  \\                             { chargeError(); string.append('\\'); }
}

[^] { error.append(yytext()); }
