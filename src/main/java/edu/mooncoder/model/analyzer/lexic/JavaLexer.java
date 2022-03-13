// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/main/resources/lexico.jflex

package edu.mooncoder.model.analyzer.lexic;

import java_cup.runtime.Symbol;
import edu.mooncoder.model.analyzer.syntax.Tokens;


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
    "\1\0\1\25\1\26\1\27\1\26\2\0\22\10\1\30"+
    "\7\10\1\0\1\31\1\0\1\32\1\33\1\0\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\10\1\45\1\46\1\47\1\50\1\51\1\52\1\10"+
    "\1\53\1\54\1\55\1\56\1\57\1\60\3\10\1\61"+
    "\1\62\1\63\7\0\1\3\u01a2\0\2\3\326\0\u0100\3";

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
    "\1\17\1\20\1\21\1\22\1\23\1\5\1\7\1\1"+
    "\15\5\1\24\1\7\1\25\1\26\1\27\1\30\1\22"+
    "\2\0\1\31\1\32\1\0\1\2\1\0\5\5\1\33"+
    "\4\5\1\34\14\5\1\35\1\36\1\37\1\40\1\41"+
    "\1\0\1\42\5\0\11\5\1\43\15\5\1\44\1\45"+
    "\1\46\1\47\1\0\1\2\5\5\1\50\2\5\2\51"+
    "\2\52\6\5\1\53\1\54\4\5\1\55\2\5\1\0"+
    "\10\5\2\56\1\57\1\5\2\60\1\0\2\61\5\5"+
    "\1\62\1\63\1\64\2\65\2\5\2\66\2\67\1\5";

  private static int [] zzUnpackAction() {
    int [] result = new int[179];
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
    "\0\0\0\64\0\150\0\150\0\234\0\320\0\150\0\u0104"+
    "\0\150\0\u0138\0\u016c\0\150\0\150\0\150\0\u01a0\0\150"+
    "\0\u01d4\0\u0208\0\u023c\0\u0270\0\150\0\320\0\320\0\u02a4"+
    "\0\150\0\u0104\0\u02d8\0\u030c\0\u0340\0\u0374\0\u03a8\0\u03dc"+
    "\0\u0410\0\u0444\0\u0478\0\u04ac\0\u04e0\0\u0514\0\u0548\0\150"+
    "\0\u057c\0\150\0\u05b0\0\150\0\u05e4\0\150\0\u0618\0\u064c"+
    "\0\150\0\u0208\0\u0680\0\u06b4\0\u0208\0\u06e8\0\u071c\0\u0750"+
    "\0\u0784\0\u07b8\0\u07ec\0\u0820\0\u0854\0\u0888\0\u08bc\0\u0104"+
    "\0\u08f0\0\u0924\0\u0958\0\u098c\0\u09c0\0\u09f4\0\u0a28\0\u0a5c"+
    "\0\u0a90\0\u0ac4\0\u0af8\0\u0b2c\0\150\0\150\0\150\0\150"+
    "\0\150\0\u0b60\0\150\0\u0b94\0\u0bc8\0\u0bfc\0\u0c30\0\u0c64"+
    "\0\u0c98\0\u0ccc\0\u0d00\0\u0d34\0\u0d68\0\u0d9c\0\u0dd0\0\u0e04"+
    "\0\u0e38\0\u0104\0\u0e6c\0\u0ea0\0\u0ed4\0\u0f08\0\u0f3c\0\u0f70"+
    "\0\u0fa4\0\u0fd8\0\u100c\0\u1040\0\u1074\0\u10a8\0\u10dc\0\150"+
    "\0\150\0\150\0\150\0\u1110\0\u0680\0\u1144\0\u1178\0\u11ac"+
    "\0\u11e0\0\u1214\0\u1248\0\u127c\0\u12b0\0\150\0\u12e4\0\150"+
    "\0\u1318\0\u134c\0\u1380\0\u13b4\0\u13e8\0\u141c\0\u1450\0\u0104"+
    "\0\u0104\0\u1484\0\u14b8\0\u14ec\0\u1520\0\u0104\0\u1554\0\u1588"+
    "\0\u15bc\0\u15f0\0\u1624\0\u1658\0\u168c\0\u16c0\0\u16f4\0\u1728"+
    "\0\u175c\0\150\0\u1790\0\u0104\0\u17c4\0\150\0\u17f8\0\u182c"+
    "\0\150\0\u1860\0\u1894\0\u18c8\0\u18fc\0\u1930\0\u1964\0\u0104"+
    "\0\u0104\0\150\0\150\0\u1998\0\u19cc\0\u1a00\0\150\0\u1a34"+
    "\0\150\0\u1a68\0\u1a9c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[179];
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
    "\1\3\1\31\1\32\1\10\1\33\1\34\1\35\1\36"+
    "\1\37\2\10\1\40\3\10\1\41\1\10\1\42\1\43"+
    "\1\44\1\45\1\10\1\46\1\47\1\50\1\51\1\52"+
    "\2\53\1\3\2\53\1\3\1\53\1\54\21\53\1\55"+
    "\32\53\66\0\1\4\110\0\1\56\44\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\26\10\15\0\1\31\51\0"+
    "\2\57\1\0\2\57\1\0\1\57\1\0\21\57\1\60"+
    "\32\57\17\0\1\61\65\0\1\61\66\0\1\62\55\0"+
    "\1\63\4\0\1\64\62\0\1\65\1\0\1\24\47\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\22\10\1\66"+
    "\3\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\16\10\1\67\1\10\1\70\5\10\13\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\10\10\1\71\2\10\1\72"+
    "\12\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\16\10\1\73\7\10\13\0\1\10\13\0\1\10\3\0"+
    "\1\10\2\0\13\10\1\74\12\10\13\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\1\10\1\75\7\10\1\76"+
    "\4\10\1\77\7\10\13\0\1\10\13\0\1\10\3\0"+
    "\1\10\2\0\6\10\1\100\5\10\1\101\1\102\10\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\5\10"+
    "\1\103\20\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\1\10\1\104\16\10\1\105\2\10\1\106\2\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\5\10"+
    "\1\107\20\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\25\10\1\110\13\0\1\10\13\0\1\10\3\0"+
    "\1\10\2\0\10\10\1\111\7\10\1\112\5\10\13\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\16\10\1\113"+
    "\7\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\10\10\1\114\15\10\65\0\1\31\1\0\2\53\1\0"+
    "\2\53\1\0\1\53\1\0\21\53\1\0\32\53\7\0"+
    "\1\115\40\0\1\116\2\0\1\117\1\0\1\120\21\0"+
    "\1\121\57\0\1\122\3\0\1\123\34\0\1\124\2\0"+
    "\1\125\1\0\1\126\6\0\2\63\4\127\10\63\1\130"+
    "\45\63\2\64\1\4\2\64\1\5\56\64\10\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\20\10\1\131\5\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\16\10"+
    "\1\132\7\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\5\10\1\133\20\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\1\10\1\134\24\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\1\10\1\135\24\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\23\10"+
    "\1\136\2\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\21\10\1\137\4\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\13\10\1\140\12\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\15\10\1\141\10\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\20\10"+
    "\1\142\5\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\17\10\1\143\6\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\22\10\1\144\3\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\25\10\1\145\13\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\3\10\1\146"+
    "\22\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\11\10\1\147\4\10\1\150\7\10\13\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\2\10\1\151\23\10\13\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\22\10\1\152"+
    "\3\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\11\10\1\153\14\10\13\0\1\10\13\0\1\10\3\0"+
    "\1\10\2\0\11\10\1\154\14\10\13\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\23\10\1\155\2\10\13\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\11\10\1\156"+
    "\14\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\11\10\1\157\14\10\16\0\1\160\63\0\1\161\63\0"+
    "\1\162\63\0\1\163\50\0\16\127\1\164\45\127\2\63"+
    "\4\127\10\63\1\130\4\63\1\165\40\63\10\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\11\10\1\166\14\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\13\10"+
    "\1\167\12\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\1\10\1\170\24\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\20\10\1\144\5\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\21\10\1\171\4\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\2\10"+
    "\1\172\23\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\5\10\1\173\20\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\21\10\1\155\4\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\1\10\1\174\24\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\16\10"+
    "\1\175\7\10\4\0\2\176\1\0\1\176\1\177\2\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\26\10\4\0"+
    "\2\200\1\0\1\200\1\201\2\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\26\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\12\10\1\202\13\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\24\10\1\203\1\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\22\10"+
    "\1\204\3\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\13\10\1\205\12\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\23\10\1\206\2\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\22\10\1\207\3\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\21\10"+
    "\1\210\4\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\5\10\1\211\20\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\4\10\1\212\21\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\13\10\1\213\12\10"+
    "\3\0\16\127\1\164\4\127\1\4\40\127\10\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\15\10\1\214\10\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\5\10"+
    "\1\215\20\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\12\10\1\216\13\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\21\10\1\217\4\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\13\10\1\220\12\10"+
    "\4\0\2\221\1\0\2\221\2\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\26\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\13\10\1\222\12\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\20\10\1\223\5\10"+
    "\5\0\1\176\63\0\1\200\71\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\1\10\1\224\24\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\1\10\1\225\24\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\5\10"+
    "\1\226\20\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\11\10\1\227\14\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\20\10\1\230\5\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\3\10\1\231\22\10"+
    "\4\0\2\232\1\0\1\232\1\233\2\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\26\10\13\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\5\10\1\234\20\10\13\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\7\10\1\144"+
    "\16\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\1\10\1\235\24\10\4\0\2\236\1\0\1\236\1\237"+
    "\2\0\1\10\13\0\1\10\3\0\1\10\2\0\26\10"+
    "\13\0\1\10\13\0\1\10\3\0\1\10\2\0\5\10"+
    "\1\144\20\10\4\0\2\221\1\0\2\221\36\0\1\240"+
    "\20\0\2\241\1\0\1\241\1\242\2\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\26\10\13\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\22\10\1\243\3\10\13\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\7\10\1\244"+
    "\16\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\22\10\1\245\3\10\13\0\1\10\13\0\1\10\3\0"+
    "\1\10\2\0\3\10\1\246\22\10\13\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\3\10\1\247\22\10\13\0"+
    "\1\10\13\0\1\10\3\0\1\10\2\0\15\10\1\250"+
    "\10\10\13\0\1\10\13\0\1\10\3\0\1\10\2\0"+
    "\10\10\1\251\15\10\5\0\1\232\71\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\15\10\1\144\10\10\5\0"+
    "\1\236\122\0\1\252\24\0\1\241\62\0\2\253\1\0"+
    "\1\253\1\254\2\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\26\10\13\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\5\10\1\255\20\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\5\10\1\247\20\10\13\0\1\10"+
    "\13\0\1\10\3\0\1\10\2\0\22\10\1\256\3\10"+
    "\4\0\2\257\1\0\1\257\1\260\2\0\1\10\13\0"+
    "\1\10\3\0\1\10\2\0\26\10\5\0\1\253\62\0"+
    "\2\261\1\0\1\261\1\262\2\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\26\10\13\0\1\10\13\0\1\10"+
    "\3\0\1\10\2\0\5\10\1\263\20\10\5\0\1\257"+
    "\63\0\1\261\71\0\1\10\13\0\1\10\3\0\1\10"+
    "\2\0\4\10\1\247\21\10\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6864];
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
    "\2\0\2\11\2\1\1\11\1\1\1\11\2\1\3\11"+
    "\1\1\1\11\4\1\1\11\3\1\1\11\16\1\1\11"+
    "\1\1\1\11\1\1\1\11\1\1\1\11\2\0\1\11"+
    "\1\1\1\0\1\1\1\0\27\1\5\11\1\0\1\11"+
    "\5\0\27\1\4\11\1\0\11\1\1\11\1\1\1\11"+
    "\20\1\1\0\10\1\1\11\3\1\1\11\1\1\1\0"+
    "\1\11\10\1\2\11\3\1\1\11\1\1\1\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[179];
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

  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private Symbol symbol(int type, Object value) {
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
            { System.out.println("error: " + (yyline + 1) + ", " + (yycolumn + 1));
            }
            // fall through
          case 56: break;
          case 2:
            { /* ignore */
            }
            // fall through
          case 57: break;
          case 3:
            { return symbol(Tokens.NEGAR);
            }
            // fall through
          case 58: break;
          case 4:
            { string.setLength(0); yybegin(LITERAL);
            }
            // fall through
          case 59: break;
          case 5:
            { return symbol(Tokens.ID);
            }
            // fall through
          case 60: break;
          case 6:
            { return symbol(Tokens.MOD);
            }
            // fall through
          case 61: break;
          case 7:
            { return symbol(Tokens.LOGIC);
            }
            // fall through
          case 62: break;
          case 8:
            { return symbol(Tokens.PAR_IZQ);
            }
            // fall through
          case 63: break;
          case 9:
            { return symbol(Tokens.PAR_DER);
            }
            // fall through
          case 64: break;
          case 10:
            { return symbol(Tokens.POR);
            }
            // fall through
          case 65: break;
          case 11:
            { return symbol(Tokens.MAS);
            }
            // fall through
          case 66: break;
          case 12:
            { return symbol(Tokens.COMA);
            }
            // fall through
          case 67: break;
          case 13:
            { return symbol(Tokens.MENOS);
            }
            // fall through
          case 68: break;
          case 14:
            { return symbol(Tokens.PUNTO);
            }
            // fall through
          case 69: break;
          case 15:
            { return symbol(Tokens.DIV);
            }
            // fall through
          case 70: break;
          case 16:
            { return symbol(Tokens.ENTERO);
            }
            // fall through
          case 71: break;
          case 17:
            { return symbol(Tokens.SEPARADOR);
            }
            // fall through
          case 72: break;
          case 18:
            { return symbol(Tokens.RELATIONAL);
            }
            // fall through
          case 73: break;
          case 19:
            { return symbol(Tokens.IGUAL);
            }
            // fall through
          case 74: break;
          case 20:
            { return symbol(Tokens.LLA_IZQ);
            }
            // fall through
          case 75: break;
          case 21:
            { return symbol(Tokens.LLA_DER);
            }
            // fall through
          case 76: break;
          case 22:
            { string.append(yytext());
            }
            // fall through
          case 77: break;
          case 23:
            { yybegin(YYINITIAL); return symbol(Tokens.LITERAL, string.toString());
            }
            // fall through
          case 78: break;
          case 24:
            { string.append('\\');
            }
            // fall through
          case 79: break;
          case 25:
            { return symbol(Tokens.UNARY);
            }
            // fall through
          case 80: break;
          case 26:
            { return symbol(Tokens.DECIMAL);
            }
            // fall through
          case 81: break;
          case 27:
            { return symbol(Tokens.DO);
            }
            // fall through
          case 82: break;
          case 28:
            { return symbol(Tokens.IF);
            }
            // fall through
          case 83: break;
          case 29:
            { string.append('\"');
            }
            // fall through
          case 84: break;
          case 30:
            { string.append('\n');
            }
            // fall through
          case 85: break;
          case 31:
            { string.append('\r');
            }
            // fall through
          case 86: break;
          case 32:
            { string.append('\t');
            }
            // fall through
          case 87: break;
          case 33:
            { return symbol(Tokens.CHAR, yytext().charAt(1);
            }
            // fall through
          case 88: break;
          case 34:
            { return symbol(Tokens.CHAR, '\\');
            }
            // fall through
          case 89: break;
          case 35:
            { return symbol(Tokens.FOR);
            }
            // fall through
          case 90: break;
          case 36:
            { return symbol(Tokens.CHAR, '\"');
            }
            // fall through
          case 91: break;
          case 37:
            { return symbol(Tokens.CHAR, '\n');
            }
            // fall through
          case 92: break;
          case 38:
            { return symbol(Tokens.CHAR, '\r');
            }
            // fall through
          case 93: break;
          case 39:
            { return symbol(Tokens.CHAR, '\t');
            }
            // fall through
          case 94: break;
          case 40:
            { return symbol(Tokens.ELSE);
            }
            // fall through
          case 95: break;
          case 41:
            { return symbol(Tokens.TYPE);
            }
            // fall through
          case 96: break;
          case 42:
            { return symbol(Tokens.NEW);
            }
            // fall through
          case 97: break;
          case 43:
            { /*return symbol(Tokens.THIS);*/
            }
            // fall through
          case 98: break;
          case 44:
            { return symbol(Tokens.BOOL);
            }
            // fall through
          case 99: break;
          case 45:
            { return symbol(Tokens.BREAK);
            }
            // fall through
          case 100: break;
          case 46:
            { return symbol(Tokens.VOID);
            }
            // fall through
          case 101: break;
          case 47:
            { return symbol(Tokens.WHILE);
            }
            // fall through
          case 102: break;
          case 48:
            { return symbol(Tokens.CLASS);
            }
            // fall through
          case 103: break;
          case 49:
            { return symbol(Tokens.FINAL);
            }
            // fall through
          case 104: break;
          case 50:
            { return symbol(Tokens.RETURN);
            }
            // fall through
          case 105: break;
          case 51:
            { return symbol(Tokens.SWITCH);
            }
            // fall through
          case 106: break;
          case 52:
            { return symbol(Tokens.ELIF);
            }
            // fall through
          case 107: break;
          case 53:
            { return symbol(Tokens.IMPORT);
            }
            // fall through
          case 108: break;
          case 54:
            { return symbol(Tokens.VISIBILITY);
            }
            // fall through
          case 109: break;
          case 55:
            { return symbol(Tokens.PACKAGE);
            }
            // fall through
          case 110: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
