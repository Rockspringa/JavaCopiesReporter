// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/main/resources/lexico.jflex

package edu.mooncoder.rml.controllers.analyzer.lexic;

import java_cup.runtime.Symbol;

import edu.mooncoder.rml.controllers.builders.ErrorsReportBuilder;
import edu.mooncoder.rml.exceptions.AnalysisException;
import edu.mooncoder.rml.exceptions.lexical.NotRecognizedCharactersException;
import edu.mooncoder.rml.controllers.analyzer.syntax.Tokens;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class HtmlLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int LITERAL = 2;
  public static final int TAGS = 4;
  public static final int VARIABLE = 6;
  public static final int FOR = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\267\u0200\10\u0400\u1020\u0200";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\4\1\5\22\0\1\1"+
    "\1\0\1\6\1\0\1\7\3\0\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\7\20\1\23\1\24\1\25\1\26\1\27\2\0\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\2\32\1\41\1\42\1\43\1\44\2\32\1\45\1\46"+
    "\1\47\1\50\5\32\1\51\1\52\1\53\1\0\1\54"+
    "\1\0\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\2\32\1\41\1\42\1\43\1\44\2\32"+
    "\1\45\1\46\1\47\1\50\5\32\12\0\1\3\53\0"+
    "\1\32\21\0\1\32\154\0\2\55\115\0\1\56\u01a8\0"+
    "\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1280];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\1"+
    "\1\17\3\4\1\20\1\21\3\1\1\22\1\23\1\24"+
    "\1\1\1\2\4\1\1\25\2\4\1\1\2\0\3\4"+
    "\2\0\1\26\1\27\1\30\1\31\1\32\10\0\2\4"+
    "\3\0\2\4\1\0\1\4\2\0\1\33\13\0\1\34"+
    "\1\4\1\0\1\4\1\0\1\2\1\0\2\4\1\0"+
    "\1\4\12\0\1\35\1\0\1\36\1\37\1\0\1\40"+
    "\1\41\1\42\1\4\1\0\1\4\2\0\2\4\1\0"+
    "\1\4\3\0\1\43\1\44\2\0\1\45\1\46\1\47"+
    "\1\50\1\0\1\4\1\0\1\4\1\0\1\51\1\4"+
    "\2\52\1\4\2\0\1\53\3\0\1\54\1\4\1\0"+
    "\1\4\2\55\1\0\1\56\1\0\1\57\1\4\1\0"+
    "\2\60\1\61\1\4\1\0\1\62";

  private static int [] zzUnpackAction() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\353\0\353\0\u011a"+
    "\0\353\0\u0149\0\353\0\353\0\353\0\353\0\353\0\353"+
    "\0\353\0\353\0\u0178\0\353\0\u01a7\0\353\0\u01d6\0\u0205"+
    "\0\u0234\0\353\0\353\0\u0149\0\u0263\0\u0292\0\u02c1\0\353"+
    "\0\u02f0\0\u031f\0\u034e\0\u037d\0\u03ac\0\u03db\0\u040a\0\353"+
    "\0\u0439\0\u0468\0\u0497\0\u04c6\0\u04f5\0\u0524\0\u0553\0\u0582"+
    "\0\u05b1\0\u05e0\0\353\0\353\0\353\0\353\0\u031f\0\u060f"+
    "\0\u063e\0\u066d\0\u069c\0\u06cb\0\u06fa\0\u03db\0\u0729\0\u0758"+
    "\0\u0787\0\u07b6\0\u07e5\0\u0814\0\u0843\0\u0872\0\u08a1\0\u08d0"+
    "\0\u08ff\0\u092e\0\353\0\u095d\0\u098c\0\u09bb\0\u09ea\0\u0a19"+
    "\0\u0a48\0\u0a77\0\u0aa6\0\u0ad5\0\u0b04\0\u0b33\0\353\0\u0b62"+
    "\0\u0b91\0\u0bc0\0\u0bef\0\u04c6\0\u0c1e\0\u0c4d\0\u0c7c\0\u0cab"+
    "\0\u0cda\0\u0d09\0\u0d38\0\u0d67\0\u0d96\0\u0dc5\0\u0df4\0\u0e23"+
    "\0\u0e52\0\u0e81\0\u0eb0\0\353\0\u0edf\0\353\0\353\0\u0f0e"+
    "\0\353\0\353\0\353\0\u0f3d\0\u0f6c\0\u0f9b\0\u0fca\0\u0ff9"+
    "\0\u1028\0\u1057\0\u1086\0\u10b5\0\u10e4\0\u1113\0\u1142\0\u04c6"+
    "\0\u04c6\0\u1171\0\u11a0\0\u04c6\0\u04c6\0\u04c6\0\u0edf\0\u11cf"+
    "\0\u11fe\0\u122d\0\u125c\0\u128b\0\353\0\u12ba\0\u0149\0\353"+
    "\0\u12e9\0\u1318\0\u1347\0\u04c6\0\u1376\0\u13a5\0\u13d4\0\353"+
    "\0\u1403\0\u1432\0\u1461\0\353\0\u1490\0\u14bf\0\u04c6\0\u14ee"+
    "\0\353\0\u151d\0\u154c\0\353\0\u157b\0\u04c6\0\u15aa\0\u15d9"+
    "\0\353";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\2\7\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\3\23"+
    "\1\6\1\24\1\25\1\26\1\6\10\12\1\27\4\12"+
    "\1\30\1\31\2\12\1\32\1\6\1\33\1\34\1\35"+
    "\1\36\2\37\1\6\2\37\1\6\1\40\43\37\1\41"+
    "\4\37\1\42\2\43\2\42\1\43\1\42\1\44\7\42"+
    "\1\6\5\42\1\45\1\42\1\6\27\42\1\6\2\7"+
    "\1\6\1\7\1\10\1\6\1\12\1\6\1\46\4\6"+
    "\1\21\1\6\3\23\2\6\1\47\2\6\15\12\1\30"+
    "\3\12\1\32\1\6\1\33\1\34\3\6\2\7\1\6"+
    "\1\7\1\10\1\6\1\12\6\6\1\21\1\6\3\23"+
    "\1\6\1\24\1\47\1\6\1\50\7\12\1\51\1\52"+
    "\4\12\1\30\3\12\1\32\1\6\1\33\1\34\1\53"+
    "\1\6\61\0\1\7\63\0\1\12\10\0\3\12\5\0"+
    "\21\12\3\0\1\12\22\0\3\23\53\0\1\54\17\0"+
    "\1\55\26\0\1\12\10\0\3\12\5\0\13\12\1\56"+
    "\5\12\3\0\1\12\11\0\1\12\10\0\3\12\5\0"+
    "\4\12\1\57\14\12\3\0\1\12\11\0\1\12\10\0"+
    "\3\12\5\0\17\12\1\60\1\12\3\0\1\12\45\0"+
    "\1\61\62\0\1\62\7\0\2\37\1\0\2\37\2\0"+
    "\43\37\1\0\4\37\6\0\1\63\34\0\1\64\1\0"+
    "\1\65\1\0\1\66\7\0\7\67\1\0\7\67\1\0"+
    "\5\67\1\0\1\67\1\0\27\67\1\0\2\43\2\0"+
    "\1\43\60\0\1\70\66\0\1\71\11\0\1\72\3\0"+
    "\1\73\1\0\1\74\7\0\1\75\10\0\2\76\1\0"+
    "\2\76\1\0\1\77\66\0\1\54\46\0\1\12\10\0"+
    "\3\12\5\0\1\100\20\12\3\0\1\12\11\0\1\12"+
    "\10\0\3\12\5\0\17\12\1\101\1\12\3\0\1\12"+
    "\51\0\1\102\7\0\2\54\4\0\11\54\1\103\37\54"+
    "\47\0\1\104\16\0\1\12\10\0\3\12\5\0\17\12"+
    "\1\105\1\12\3\0\1\12\11\0\1\12\10\0\3\12"+
    "\5\0\16\12\1\106\2\12\3\0\1\12\1\0\1\107"+
    "\7\0\1\12\10\0\3\12\5\0\15\12\1\110\3\12"+
    "\3\0\1\12\51\0\1\111\54\0\1\112\12\0\2\70"+
    "\1\0\2\70\2\0\1\113\46\0\2\54\4\0\11\54"+
    "\1\103\15\54\1\114\1\54\1\115\7\54\1\116\7\54"+
    "\45\0\1\117\55\0\1\120\33\0\1\121\1\122\64\0"+
    "\1\123\2\0\1\124\3\0\1\125\5\0\1\126\20\0"+
    "\1\127\56\0\1\12\10\0\3\12\5\0\16\12\1\130"+
    "\2\12\3\0\1\12\1\0\1\131\7\0\1\12\10\0"+
    "\3\12\5\0\4\12\1\132\14\12\3\0\1\12\36\0"+
    "\1\133\22\0\2\54\4\0\11\54\1\103\7\54\1\134"+
    "\27\54\42\0\1\135\23\0\1\12\10\0\3\12\5\0"+
    "\4\12\1\136\14\12\3\0\1\12\11\0\1\12\10\0"+
    "\3\12\5\0\20\12\1\137\3\0\1\12\52\0\1\140"+
    "\15\0\1\12\10\0\3\12\5\0\10\12\1\141\10\12"+
    "\3\0\1\12\1\142\35\0\1\143\62\0\1\142\14\0"+
    "\1\142\1\0\2\54\4\0\11\54\1\103\24\54\1\144"+
    "\14\54\4\0\11\54\1\103\1\54\1\145\1\146\24\54"+
    "\1\147\11\54\4\0\11\54\1\103\10\54\1\150\2\54"+
    "\1\151\3\54\1\152\5\54\1\153\11\54\27\0\1\154"+
    "\74\0\1\155\40\0\1\156\56\0\1\157\60\0\1\160"+
    "\54\0\1\161\56\0\1\162\56\0\1\163\36\0\1\12"+
    "\10\0\3\12\5\0\17\12\1\164\1\12\3\0\1\12"+
    "\51\0\1\165\16\0\1\12\10\0\3\12\5\0\15\12"+
    "\1\166\3\12\3\0\1\12\47\0\1\167\52\0\1\170"+
    "\24\0\1\12\10\0\3\12\5\0\6\12\1\171\12\12"+
    "\3\0\1\12\11\0\1\12\10\0\3\12\5\0\11\12"+
    "\1\172\7\12\3\0\1\12\43\0\1\173\24\0\1\12"+
    "\10\0\3\12\5\0\13\12\1\174\5\12\3\0\1\12"+
    "\45\0\1\175\51\0\1\176\20\0\2\54\4\0\11\54"+
    "\1\103\25\54\1\177\13\54\4\0\11\54\1\103\7\54"+
    "\1\200\31\54\4\0\11\54\1\103\7\54\1\201\31\54"+
    "\4\0\11\54\1\103\22\54\1\202\16\54\4\0\11\54"+
    "\1\103\11\54\1\203\27\54\4\0\11\54\1\103\7\54"+
    "\1\204\31\54\4\0\11\54\1\103\7\54\1\205\31\54"+
    "\4\0\11\54\1\103\7\54\1\206\27\54\1\0\2\207"+
    "\1\0\2\207\112\0\1\210\24\0\1\12\10\0\3\12"+
    "\5\0\1\211\20\12\3\0\1\12\32\0\1\212\35\0"+
    "\1\12\10\0\3\12\5\0\1\213\20\12\3\0\1\12"+
    "\32\0\1\214\55\0\1\215\36\0\1\12\10\0\3\12"+
    "\5\0\4\12\1\216\14\12\3\0\1\12\11\0\1\12"+
    "\10\0\3\12\5\0\17\12\1\217\1\12\3\0\1\12"+
    "\51\0\1\220\16\0\1\12\10\0\3\12\5\0\6\12"+
    "\1\221\12\12\3\0\1\12\40\0\1\222\54\0\1\223"+
    "\22\0\2\54\4\0\11\54\1\103\7\54\1\224\31\54"+
    "\4\0\11\54\1\103\21\54\1\225\17\54\4\0\11\54"+
    "\1\103\21\54\1\226\15\54\34\0\1\227\23\0\2\212"+
    "\1\0\2\212\1\0\1\12\10\0\3\12\1\230\4\0"+
    "\21\12\3\0\1\12\3\0\2\212\1\0\2\212\15\0"+
    "\1\230\42\0\1\12\10\0\3\12\5\0\3\12\1\231"+
    "\15\12\3\0\1\12\35\0\1\232\32\0\1\12\10\0"+
    "\3\12\5\0\15\12\1\233\3\12\3\0\1\12\3\0"+
    "\2\234\1\0\1\234\1\235\1\0\1\12\10\0\3\12"+
    "\5\0\21\12\3\0\1\12\3\0\2\234\1\0\1\234"+
    "\1\235\116\0\1\236\11\0\2\54\4\0\11\54\1\103"+
    "\7\54\1\237\31\54\4\0\11\54\1\103\14\54\1\240"+
    "\22\54\27\0\1\241\36\0\1\12\10\0\3\12\5\0"+
    "\14\12\1\242\4\12\3\0\1\12\46\0\1\243\13\0"+
    "\2\244\1\0\1\244\1\245\1\0\1\12\10\0\3\12"+
    "\5\0\21\12\3\0\1\12\4\0\1\234\55\0\2\244"+
    "\1\0\1\244\1\245\51\0\2\54\4\0\11\54\1\103"+
    "\7\54\1\246\27\54\7\0\1\12\10\0\3\12\5\0"+
    "\15\12\1\247\3\12\3\0\1\12\47\0\1\250\13\0"+
    "\1\244\55\0\2\250\1\0\2\250\1\0\1\12\10\0"+
    "\3\12\1\251\4\0\21\12\3\0\1\12\3\0\2\250"+
    "\1\0\2\250\15\0\1\251\33\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5640];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\2\11\1\1\1\11\1\1\10\11\1\1\1\11"+
    "\1\1\1\11\3\1\2\11\4\1\1\11\7\1\1\11"+
    "\3\1\2\0\3\1\2\0\4\11\1\1\10\0\2\1"+
    "\3\0\2\1\1\0\1\1\2\0\1\11\13\0\1\11"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\2\1\1\0"+
    "\1\1\12\0\1\11\1\0\2\11\1\0\3\11\1\1"+
    "\1\0\1\1\2\0\2\1\1\0\1\1\3\0\2\1"+
    "\2\0\4\1\1\0\1\1\1\0\1\1\1\0\1\11"+
    "\2\1\1\11\1\1\2\0\1\1\3\0\1\11\1\1"+
    "\1\0\1\1\1\11\1\1\1\0\1\1\1\0\1\11"+
    "\1\1\1\0\1\11\3\1\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public HtmlLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(Tokens.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { error.append(yytext());
            }
            // fall through
          case 51: break;
          case 2:
            { addError();
            }
            // fall through
          case 52: break;
          case 3:
            { addError(); string.setLength(0); yybegin(LITERAL);
            }
            // fall through
          case 53: break;
          case 4:
            { return symbol(Tokens.ID, yytext());
            }
            // fall through
          case 54: break;
          case 5:
            { return symbol(Tokens.PAR_IZQ);
            }
            // fall through
          case 55: break;
          case 6:
            { return symbol(Tokens.PAR_DER);
            }
            // fall through
          case 56: break;
          case 7:
            { return symbol(Tokens.POR);
            }
            // fall through
          case 57: break;
          case 8:
            { return symbol(Tokens.MAS);
            }
            // fall through
          case 58: break;
          case 9:
            { return symbol(Tokens.COMA);
            }
            // fall through
          case 59: break;
          case 10:
            { return symbol(Tokens.MENOS);
            }
            // fall through
          case 60: break;
          case 11:
            { return symbol(Tokens.PUNTO);
            }
            // fall through
          case 61: break;
          case 12:
            { return symbol(Tokens.DIV);
            }
            // fall through
          case 62: break;
          case 13:
            { return symbol(Tokens.INT, Integer.parseInt(yytext()));
            }
            // fall through
          case 63: break;
          case 14:
            { return symbol(Tokens.SEPARADOR);
            }
            // fall through
          case 64: break;
          case 15:
            { return symbol(Tokens.IGUAL);
            }
            // fall through
          case 65: break;
          case 16:
            { return symbol(Tokens.COR_IZQ);
            }
            // fall through
          case 66: break;
          case 17:
            { return symbol(Tokens.COR_DER);
            }
            // fall through
          case 67: break;
          case 18:
            { string.append(yytext());
            }
            // fall through
          case 68: break;
          case 19:
            { yybegin(YYINITIAL); return symbol(Tokens.LITERAL, string.toString());
            }
            // fall through
          case 69: break;
          case 20:
            { string.append('\\');
            }
            // fall through
          case 70: break;
          case 21:
            { yybegin(TAGS); return symbol(Tokens.TAG_FOR);
            }
            // fall through
          case 71: break;
          case 22:
            { string.append('\"');
            }
            // fall through
          case 72: break;
          case 23:
            { string.append('\n');
            }
            // fall through
          case 73: break;
          case 24:
            { string.append('\r');
            }
            // fall through
          case 74: break;
          case 25:
            { string.append('\t');
            }
            // fall through
          case 75: break;
          case 26:
            { return symbol(Tokens.TEXT, yytext());
            }
            // fall through
          case 76: break;
          case 27:
            { addError(); yybegin(VARIABLE);
            }
            // fall through
          case 77: break;
          case 28:
            { addError(); yybegin(TAGS);
            }
            // fall through
          case 78: break;
          case 29:
            { return symbol(Tokens.BR);
            }
            // fall through
          case 79: break;
          case 30:
            { return symbol(Tokens.H1_B);
            }
            // fall through
          case 80: break;
          case 31:
            { return symbol(Tokens.H2_B);
            }
            // fall through
          case 81: break;
          case 32:
            { return symbol(Tokens.TD_B);
            }
            // fall through
          case 82: break;
          case 33:
            { return symbol(Tokens.TH_B);
            }
            // fall through
          case 83: break;
          case 34:
            { return symbol(Tokens.TR_B);
            }
            // fall through
          case 84: break;
          case 35:
            { return symbol(Tokens.H1_E);
            }
            // fall through
          case 85: break;
          case 36:
            { return symbol(Tokens.H2_E);
            }
            // fall through
          case 86: break;
          case 37:
            { return symbol(Tokens.TD_E);
            }
            // fall through
          case 87: break;
          case 38:
            { return symbol(Tokens.TH_E);
            }
            // fall through
          case 88: break;
          case 39:
            { return symbol(Tokens.TR_E);
            }
            // fall through
          case 89: break;
          case 40:
            { yybegin(FOR); return symbol(Tokens.FOR_B);
            }
            // fall through
          case 90: break;
          case 41:
            { string.setLength(0); yybegin(TAGS); return symbol(Tokens.HTML_B);
            }
            // fall through
          case 91: break;
          case 42:
            { return symbol(Tokens.RESULT);
            }
            // fall through
          case 92: break;
          case 43:
            { return symbol(Tokens.FOR_E);
            }
            // fall through
          case 93: break;
          case 44:
            { return symbol(Tokens.HASTA);
            }
            // fall through
          case 94: break;
          case 45:
            { return symbol(Tokens.STRING);
            }
            // fall through
          case 95: break;
          case 46:
            { return symbol(Tokens.HTML_E);
            }
            // fall through
          case 96: break;
          case 47:
            { return symbol(Tokens.TABLE_B);
            }
            // fall through
          case 97: break;
          case 48:
            { return symbol(Tokens.INTEGER);
            }
            // fall through
          case 98: break;
          case 49:
            { return symbol(Tokens.TABLE_E);
            }
            // fall through
          case 99: break;
          case 50:
            { return symbol(Tokens.ITERADOR);
            }
            // fall through
          case 100: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}