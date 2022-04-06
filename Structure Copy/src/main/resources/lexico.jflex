package edu.mooncoder.copy.controllers.analyzer.lexic;

import java_cup.runtime.Symbol;

import edu.mooncoder.copy.controllers.analyzer.syntax.Tokens;

%%

%class CopyLexer
%unicode
%cupsym Tokens
%cup
%public
%line
%column

%{
  private StringBuffer string = new StringBuffer();
  private StringBuffer error = new StringBuffer();

  private Symbol symbol(int type) {
    addError();
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private void addError() {
    if (error.length() != 0) {
      //ErrorsHolder.addLexicalError(yyline + 1, yycolumn - error.length(), error.toString());
      error.setLength(0);
    }
  }

  private Symbol symbol(int type, Object value) {
    addError();
    if (type == Tokens.PATH)
      return new Symbol(type, yyline + 1, yycolumn - string.length(), value);
    else
      return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }
%}

Breakline = \n | \r | \r\n
Spaces = [ \t\f]

Id = [a-zA-Z$_] [a-zA-Z_$0-9]+ | [a-zA-Z$] [a-zA-Z_$0-9]*

%state PATH

%%

<YYINITIAL> {
  {Spaces}                       { addError(); }
}

<YYINITIAL> {
  ":"                            { return symbol(Tokens.SEMICOLON); }
  {Breakline}                    { return symbol(Tokens.SEPARATOR); }
}

<YYINITIAL> {
  {Id}                           { return symbol(Tokens.ID, yytext()); }
  \"                             { addError(); string.setLength(0); yybegin(PATH); }
}

<PATH> {
  \"                             { yybegin(YYINITIAL); return symbol(Tokens.PATH, string.toString()); }

  [^\n\r\"\\]+                   { string.append(yytext()); }

  \\                             { string.append('\\'); }
}

[^] { error.append(yytext()); }
