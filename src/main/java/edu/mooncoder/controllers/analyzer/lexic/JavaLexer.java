// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/main/resources/lexico.jflex

package edu.mooncoder.controllers.analyzer.lexic;

import java_cup.runtime.Symbol;

import edu.mooncoder.controllers.analyzer.syntax.Tokens;
import edu.mooncoder.model.containers.CommentsHolder;
import edu.mooncoder.model.containers.ErrorsHolder;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class JavaLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int LITERAL = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

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
    "\1\6\1\7\1\0\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\12\24"+
    "\1\25\1\26\1\27\1\30\1\27\2\0\22\10\1\31"+
    "\7\10\1\0\1\32\1\0\1\33\1\34\1\0\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\10\1\46\1\47\1\50\1\51\1\52\1\53\1\10"+
    "\1\54\1\55\1\56\1\57\1\60\1\61\3\10\1\62"+
    "\1\63\1\64\7\0\1\3\u01a2\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
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
    "\2\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\1\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\5\1\7"+
    "\1\1\15\5\1\25\1\7\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\2\0\1\34\1\35\1\0\1\36\1\0"+
    "\1\23\7\5\1\37\4\5\1\40\14\5\1\41\1\42"+
    "\1\43\1\44\1\45\1\0\1\46\5\0\2\36\13\5"+
    "\1\47\15\5\1\50\1\51\1\52\1\53\1\0\1\36"+
    "\3\5\1\54\3\5\1\55\2\5\2\56\2\57\7\5"+
    "\1\60\4\5\1\61\14\5\2\62\1\63\1\5\2\64"+
    "\1\5\2\65\5\5\1\66\1\5\1\67\1\70\2\71"+
    "\2\5\2\72\2\73\1\5";

  private static int [] zzUnpackAction() {
    int [] result = new int[192];
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
    "\0\0\0\65\0\152\0\152\0\237\0\324\0\152\0\u0109"+
    "\0\u013e\0\u0173\0\u01a8\0\152\0\152\0\u013e\0\u01dd\0\152"+
    "\0\u0212\0\u0247\0\u027c\0\u02b1\0\152\0\152\0\u02e6\0\324"+
    "\0\u031b\0\152\0\u0109\0\u0350\0\u0385\0\u03ba\0\u03ef\0\u0424"+
    "\0\u0459\0\u048e\0\u04c3\0\u04f8\0\u052d\0\u0562\0\u0597\0\u05cc"+
    "\0\152\0\u0601\0\152\0\u0636\0\152\0\u066b\0\152\0\152"+
    "\0\u06a0\0\u06d5\0\152\0\u0247\0\u070a\0\u073f\0\u0247\0\152"+
    "\0\u0774\0\u07a9\0\u07de\0\u0813\0\u0848\0\u087d\0\u08b2\0\u08e7"+
    "\0\u091c\0\u0951\0\u0986\0\u09bb\0\u0109\0\u09f0\0\u0a25\0\u0a5a"+
    "\0\u0a8f\0\u0ac4\0\u0af9\0\u0b2e\0\u0b63\0\u0b98\0\u0bcd\0\u0c02"+
    "\0\u0c37\0\152\0\152\0\152\0\152\0\152\0\u0c6c\0\152"+
    "\0\u0ca1\0\u0cd6\0\u0d0b\0\u0d40\0\u0d75\0\152\0\u0daa\0\u0ddf"+
    "\0\u0e14\0\u0e49\0\u0e7e\0\u0eb3\0\u0ee8\0\u0f1d\0\u0f52\0\u0f87"+
    "\0\u0fbc\0\u0ff1\0\u0109\0\u1026\0\u105b\0\u1090\0\u10c5\0\u10fa"+
    "\0\u112f\0\u1164\0\u1199\0\u11ce\0\u1203\0\u1238\0\u126d\0\u12a2"+
    "\0\152\0\152\0\152\0\152\0\u12d7\0\u070a\0\u130c\0\u1341"+
    "\0\u1376\0\u0109\0\u13ab\0\u13e0\0\u1415\0\u0109\0\u144a\0\u147f"+
    "\0\152\0\u14b4\0\152\0\u14e9\0\u151e\0\u1553\0\u1588\0\u15bd"+
    "\0\u15f2\0\u1627\0\u165c\0\u0109\0\u1691\0\u16c6\0\u16fb\0\u1730"+
    "\0\u0109\0\u1765\0\u179a\0\u17cf\0\u1804\0\u1839\0\u186e\0\u18a3"+
    "\0\u18d8\0\u190d\0\u1942\0\u1977\0\u19ac\0\152\0\u19e1\0\u0109"+
    "\0\u1a16\0\152\0\u1a4b\0\u1a80\0\152\0\u1ab5\0\u1aea\0\u1b1f"+
    "\0\u1b54\0\u1b89\0\u1bbe\0\u0109\0\u1bf3\0\u0109\0\u0109\0\152"+
    "\0\u1c28\0\u1c5d\0\u1c92\0\152\0\u1cc7\0\152\0\u1cfc\0\u1d31";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[192];
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
    "\1\3\2\4\1\3\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\3\1\32\1\33\1\10\1\34\1\35\1\36"+
    "\1\37\1\40\2\10\1\41\3\10\1\42\1\10\1\43"+
    "\1\44\1\45\1\46\1\10\1\47\1\50\1\51\1\52"+
    "\1\53\2\54\1\3\2\54\1\3\1\54\1\55\22\54"+
    "\1\56\32\54\67\0\1\4\112\0\1\57\44\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\26\10\33\0\1\60"+
    "\46\0\1\32\52\0\2\61\1\0\2\61\1\0\1\61"+
    "\1\0\22\61\1\62\32\61\17\0\1\63\10\0\1\60"+
    "\55\0\1\63\6\0\1\60\60\0\1\64\56\0\1\65"+
    "\4\0\1\66\4\0\1\60\56\0\1\67\1\0\1\24"+
    "\70\0\1\70\44\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\22\10\1\71\3\10\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\16\10\1\72\1\10\1\73\5\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\1\10"+
    "\1\74\6\10\1\75\2\10\1\76\12\10\13\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\5\10\1\77\10\10"+
    "\1\100\7\10\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\13\10\1\101\12\10\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\1\10\1\102\7\10\1\103\4\10"+
    "\1\104\7\10\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\6\10\1\105\5\10\1\106\1\107\10\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\5\10\1\110"+
    "\20\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\1\10\1\111\16\10\1\112\2\10\1\113\2\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\5\10\1\114"+
    "\20\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\22\10\1\115\2\10\1\116\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\20\10\1\117\5\10\13\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\16\10\1\120\7\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\10\10"+
    "\1\121\15\10\66\0\1\32\1\0\2\54\1\0\2\54"+
    "\1\0\1\54\1\0\22\54\1\0\32\54\7\0\1\122"+
    "\41\0\1\123\2\0\1\124\1\0\1\125\21\0\1\126"+
    "\60\0\1\127\3\0\1\130\35\0\1\131\2\0\1\132"+
    "\1\0\1\133\6\0\2\65\4\134\10\65\1\135\46\65"+
    "\2\66\1\136\2\66\1\137\57\66\10\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\20\10\1\140\5\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\16\10\1\141"+
    "\7\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\5\10\1\142\20\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\21\10\1\143\4\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\1\10\1\144\24\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\1\10\1\145"+
    "\24\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\6\10\1\146\17\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\23\10\1\147\2\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\21\10\1\150\4\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\13\10\1\151"+
    "\12\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\15\10\1\152\10\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\20\10\1\153\5\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\17\10\1\154\6\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\22\10\1\155"+
    "\3\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\25\10\1\156\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\3\10\1\157\22\10\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\11\10\1\160\4\10\1\161\7\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\2\10"+
    "\1\162\23\10\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\22\10\1\163\3\10\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\1\10\1\164\24\10\13\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\11\10\1\165\14\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\23\10"+
    "\1\166\2\10\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\11\10\1\167\14\10\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\11\10\1\170\14\10\16\0\1\171"+
    "\64\0\1\172\64\0\1\173\64\0\1\174\51\0\16\134"+
    "\1\175\46\134\2\65\4\134\10\65\1\135\4\65\1\176"+
    "\41\65\2\0\1\136\72\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\11\10\1\177\14\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\13\10\1\200\12\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\1\10\1\201"+
    "\24\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\5\10\1\202\20\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\20\10\1\155\5\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\21\10\1\203\4\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\1\10\1\204"+
    "\24\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\2\10\1\205\23\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\5\10\1\206\20\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\21\10\1\166\4\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\1\10\1\207"+
    "\24\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\16\10\1\210\7\10\4\0\2\211\1\0\1\211\1\212"+
    "\2\0\1\10\13\0\1\10\4\0\1\10\2\0\26\10"+
    "\4\0\2\213\1\0\1\213\1\214\2\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\26\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\12\10\1\215\13\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\24\10\1\216"+
    "\1\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\22\10\1\217\3\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\13\10\1\220\12\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\23\10\1\221\2\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\22\10\1\222"+
    "\3\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\22\10\1\223\3\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\5\10\1\224\20\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\4\10\1\225\21\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\13\10\1\226"+
    "\12\10\3\0\16\134\1\175\4\134\1\136\41\134\10\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\15\10\1\227"+
    "\10\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\5\10\1\230\20\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\12\10\1\231\13\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\21\10\1\232\4\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\23\10\1\233"+
    "\2\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\13\10\1\234\12\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\13\10\1\235\12\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\20\10\1\236\5\10\5\0"+
    "\1\211\64\0\1\213\72\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\1\10\1\237\24\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\1\10\1\240\24\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\5\10\1\241"+
    "\20\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\11\10\1\242\14\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\20\10\1\243\5\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\11\10\1\244\14\10\13\0"+
    "\1\10\13\0\1\10\4\0\1\10\2\0\3\10\1\245"+
    "\22\10\4\0\2\246\1\0\1\246\1\247\2\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\26\10\13\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\5\10\1\250\20\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\7\10"+
    "\1\155\16\10\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\1\10\1\251\24\10\4\0\2\252\1\0\1\252"+
    "\1\253\2\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\26\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\13\10\1\254\12\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\5\10\1\155\20\10\4\0\2\255\1\0"+
    "\1\255\1\256\2\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\26\10\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\22\10\1\257\3\10\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\7\10\1\260\16\10\13\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\22\10\1\261\3\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\3\10"+
    "\1\262\22\10\13\0\1\10\13\0\1\10\4\0\1\10"+
    "\2\0\3\10\1\263\22\10\13\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\15\10\1\264\10\10\13\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\3\10\1\265\22\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\10\10"+
    "\1\266\15\10\5\0\1\246\72\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\15\10\1\155\10\10\5\0\1\252"+
    "\72\0\1\10\13\0\1\10\4\0\1\10\2\0\22\10"+
    "\1\267\3\10\5\0\1\255\63\0\2\270\1\0\1\270"+
    "\1\271\2\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\26\10\13\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\5\10\1\272\20\10\13\0\1\10\13\0\1\10\4\0"+
    "\1\10\2\0\5\10\1\263\20\10\13\0\1\10\13\0"+
    "\1\10\4\0\1\10\2\0\22\10\1\273\3\10\4\0"+
    "\2\274\1\0\1\274\1\275\2\0\1\10\13\0\1\10"+
    "\4\0\1\10\2\0\26\10\4\0\2\4\1\0\1\4"+
    "\1\5\2\0\1\10\13\0\1\10\4\0\1\10\2\0"+
    "\26\10\5\0\1\270\63\0\2\276\1\0\1\276\1\277"+
    "\2\0\1\10\13\0\1\10\4\0\1\10\2\0\26\10"+
    "\13\0\1\10\13\0\1\10\4\0\1\10\2\0\5\10"+
    "\1\300\20\10\5\0\1\274\64\0\1\276\72\0\1\10"+
    "\13\0\1\10\4\0\1\10\2\0\4\10\1\263\21\10"+
    "\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7526];
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
    "\2\0\2\11\2\1\1\11\4\1\2\11\2\1\1\11"+
    "\4\1\2\11\3\1\1\11\16\1\1\11\1\1\1\11"+
    "\1\1\1\11\1\1\2\11\2\0\1\11\1\1\1\0"+
    "\1\1\1\0\1\11\31\1\5\11\1\0\1\11\5\0"+
    "\1\11\32\1\4\11\1\0\13\1\1\11\1\1\1\11"+
    "\32\1\1\11\3\1\1\11\2\1\1\11\12\1\1\11"+
    "\3\1\1\11\1\1\1\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[192];
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
  private StringBuffer string = new StringBuffer();
  private StringBuffer error = new StringBuffer();

  private Symbol symbol(int type) {
    addError();
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private void addError() {
    if (error.length() != 0) {
      ErrorsHolder.addLexicalError(yyline + 1, yycolumn - error.length(), error.toString());
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
  public JavaLexer(java.io.Reader in) {
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
          case 60: break;
          case 2:
            { addError();
            }
            // fall through
          case 61: break;
          case 3:
            { return symbol(Tokens.NEGAR);
            }
            // fall through
          case 62: break;
          case 4:
            { addError(); string.setLength(0); yybegin(LITERAL);
            }
            // fall through
          case 63: break;
          case 5:
            { return symbol(Tokens.ID, yytext());
            }
            // fall through
          case 64: break;
          case 6:
            { return symbol(Tokens.MOD);
            }
            // fall through
          case 65: break;
          case 7:
            { return symbol(Tokens.LOGIC);
            }
            // fall through
          case 66: break;
          case 8:
            { return symbol(Tokens.PAR_IZQ);
            }
            // fall through
          case 67: break;
          case 9:
            { return symbol(Tokens.PAR_DER);
            }
            // fall through
          case 68: break;
          case 10:
            { return symbol(Tokens.POR);
            }
            // fall through
          case 69: break;
          case 11:
            { return symbol(Tokens.MAS);
            }
            // fall through
          case 70: break;
          case 12:
            { return symbol(Tokens.COMA);
            }
            // fall through
          case 71: break;
          case 13:
            { return symbol(Tokens.MENOS);
            }
            // fall through
          case 72: break;
          case 14:
            { return symbol(Tokens.PUNTO);
            }
            // fall through
          case 73: break;
          case 15:
            { return symbol(Tokens.DIV);
            }
            // fall through
          case 74: break;
          case 16:
            { return symbol(Tokens.ENTERO, Integer.parseInt(yytext()));
            }
            // fall through
          case 75: break;
          case 17:
            { return symbol(Tokens.COLON);
            }
            // fall through
          case 76: break;
          case 18:
            { return symbol(Tokens.SEPARADOR);
            }
            // fall through
          case 77: break;
          case 19:
            { return symbol(Tokens.RELATIONAL2);
            }
            // fall through
          case 78: break;
          case 20:
            { return symbol(Tokens.IGUAL);
            }
            // fall through
          case 79: break;
          case 21:
            { return symbol(Tokens.LLA_IZQ);
            }
            // fall through
          case 80: break;
          case 22:
            { return symbol(Tokens.LLA_DER);
            }
            // fall through
          case 81: break;
          case 23:
            { string.append(yytext());
            }
            // fall through
          case 82: break;
          case 24:
            { yybegin(YYINITIAL); return symbol(Tokens.LITERAL, string.toString());
            }
            // fall through
          case 83: break;
          case 25:
            { string.append('\\');
            }
            // fall through
          case 84: break;
          case 26:
            { return symbol(Tokens.RELATIONAL1);
            }
            // fall through
          case 85: break;
          case 27:
            { return symbol(Tokens.IGUAL_);
            }
            // fall through
          case 86: break;
          case 28:
            { return symbol(Tokens.UNARY);
            }
            // fall through
          case 87: break;
          case 29:
            { return symbol(Tokens.DECIMAL, Double.parseDouble(yytext()));
            }
            // fall through
          case 88: break;
          case 30:
            { addError(); CommentsHolder.addComment(yytext());
            }
            // fall through
          case 89: break;
          case 31:
            { return symbol(Tokens.DO);
            }
            // fall through
          case 90: break;
          case 32:
            { return symbol(Tokens.IF);
            }
            // fall through
          case 91: break;
          case 33:
            { string.append('\"');
            }
            // fall through
          case 92: break;
          case 34:
            { string.append('\n');
            }
            // fall through
          case 93: break;
          case 35:
            { string.append('\r');
            }
            // fall through
          case 94: break;
          case 36:
            { string.append('\t');
            }
            // fall through
          case 95: break;
          case 37:
            { return symbol(Tokens.CHAR, yytext().charAt(1));
            }
            // fall through
          case 96: break;
          case 38:
            { return symbol(Tokens.CHAR, '\\');
            }
            // fall through
          case 97: break;
          case 39:
            { return symbol(Tokens.FOR);
            }
            // fall through
          case 98: break;
          case 40:
            { return symbol(Tokens.CHAR, '\"');
            }
            // fall through
          case 99: break;
          case 41:
            { return symbol(Tokens.CHAR, '\n');
            }
            // fall through
          case 100: break;
          case 42:
            { return symbol(Tokens.CHAR, '\r');
            }
            // fall through
          case 101: break;
          case 43:
            { return symbol(Tokens.CHAR, '\t');
            }
            // fall through
          case 102: break;
          case 44:
            { return symbol(Tokens.CASE);
            }
            // fall through
          case 103: break;
          case 45:
            { return symbol(Tokens.ELSE);
            }
            // fall through
          case 104: break;
          case 46:
            { return symbol(Tokens.TYPE, yytext().strip());
            }
            // fall through
          case 105: break;
          case 47:
            { return symbol(Tokens.NEW);
            }
            // fall through
          case 106: break;
          case 48:
            { return symbol(Tokens.BOOL);
            }
            // fall through
          case 107: break;
          case 49:
            { return symbol(Tokens.BREAK);
            }
            // fall through
          case 108: break;
          case 50:
            { return symbol(Tokens.VOID, yytext().strip());
            }
            // fall through
          case 109: break;
          case 51:
            { return symbol(Tokens.WHILE);
            }
            // fall through
          case 110: break;
          case 52:
            { return symbol(Tokens.CLASS);
            }
            // fall through
          case 111: break;
          case 53:
            { return symbol(Tokens.FINAL);
            }
            // fall through
          case 112: break;
          case 54:
            { return symbol(Tokens.RETURN);
            }
            // fall through
          case 113: break;
          case 55:
            { return symbol(Tokens.SWITCH);
            }
            // fall through
          case 114: break;
          case 56:
            { return symbol(Tokens.DEFAULT);
            }
            // fall through
          case 115: break;
          case 57:
            { return symbol(Tokens.IMPORT);
            }
            // fall through
          case 116: break;
          case 58:
            { return symbol(Tokens.VISIBILITY);
            }
            // fall through
          case 117: break;
          case 59:
            { return symbol(Tokens.PACKAGE);
            }
            // fall through
          case 118: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
