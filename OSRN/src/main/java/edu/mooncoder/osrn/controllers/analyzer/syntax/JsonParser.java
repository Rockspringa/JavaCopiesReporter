
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package edu.mooncoder.osrn.controllers.analyzer.syntax;

import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.osrn.controllers.wrapper.*;
import edu.mooncoder.osrn.controllers.analyzer.lexic.JsonLexer;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class JsonParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Tokens.class;
}

  /** Default constructor. */
  @Deprecated
  public JsonParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public JsonParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public JsonParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\033\000\002\002\004\000\002\002\003\000\002\002" +
    "\002\000\002\006\005\000\002\006\004\000\002\006\005" +
    "\000\002\006\005\000\002\007\005\000\002\007\004\000" +
    "\002\010\003\000\002\010\005\000\002\010\005\000\002" +
    "\010\005\000\002\005\003\000\002\005\005\000\002\005" +
    "\005\000\002\005\004\000\002\004\005\000\002\004\005" +
    "\000\002\004\004\000\002\004\004\000\002\004\005\000" +
    "\002\004\005\000\002\003\003\000\002\003\003\000\002" +
    "\003\003\000\002\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\052\000\010\002\uffff\003\005\007\007\001\002\000" +
    "\004\002\054\001\002\000\006\004\010\005\011\001\002" +
    "\000\004\002\000\001\002\000\012\004\010\005\011\010" +
    "\013\011\012\001\002\000\006\003\050\013\051\001\002" +
    "\000\006\003\024\013\025\001\002\000\004\003\023\001" +
    "\002\000\016\002\ufffd\003\ufffd\010\ufffd\012\ufffd\013\ufffd" +
    "\014\ufffd\001\002\000\010\003\017\010\020\014\016\001" +
    "\002\000\010\003\ufff4\010\ufff4\014\ufff4\001\002\000\010" +
    "\003\021\004\010\005\011\001\002\000\010\003\ufff1\010" +
    "\ufff1\014\ufff1\001\002\000\016\002\ufffe\003\ufffe\010\ufffe" +
    "\012\ufffe\013\ufffe\014\ufffe\001\002\000\010\003\ufff2\010" +
    "\ufff2\014\ufff2\001\002\000\010\003\ufff3\010\ufff3\014\ufff3" +
    "\001\002\000\016\002\ufffb\003\ufffb\010\ufffb\012\ufffb\013" +
    "\ufffb\014\ufffb\001\002\000\010\003\uffed\010\uffed\014\uffed" +
    "\001\002\000\014\003\027\005\026\006\034\007\007\011" +
    "\031\001\002\000\014\003\uffea\010\uffea\012\uffea\013\uffea" +
    "\014\uffea\001\002\000\014\003\uffeb\004\010\005\011\010" +
    "\uffeb\014\uffeb\001\002\000\014\003\uffe8\010\uffe8\012\uffe8" +
    "\013\uffe8\014\uffe8\001\002\000\016\003\005\005\026\006" +
    "\034\007\007\011\031\012\035\001\002\000\010\003\uffef" +
    "\010\uffef\014\uffef\001\002\000\014\003\uffe7\010\uffe7\012" +
    "\uffe7\013\uffe7\014\uffe7\001\002\000\014\003\uffe9\010\uffe9" +
    "\012\uffe9\013\uffe9\014\uffe9\001\002\000\014\003\ufff9\010" +
    "\ufff9\012\ufff9\013\ufff9\014\ufff9\001\002\000\010\012\ufff8" +
    "\013\ufff8\014\ufff8\001\002\000\010\012\041\013\042\014" +
    "\040\001\002\000\014\003\044\005\026\006\034\007\007" +
    "\011\031\001\002\000\014\003\ufffa\010\ufffa\012\ufffa\013" +
    "\ufffa\014\ufffa\001\002\000\004\003\043\001\002\000\010" +
    "\012\ufff6\013\ufff6\014\ufff6\001\002\000\014\004\010\005" +
    "\011\012\ufff5\013\ufff5\014\ufff5\001\002\000\010\012\ufff7" +
    "\013\ufff7\014\ufff7\001\002\000\010\003\017\010\047\014" +
    "\016\001\002\000\016\002\ufffc\003\ufffc\010\ufffc\012\ufffc" +
    "\013\ufffc\014\ufffc\001\002\000\010\003\uffee\010\uffee\014" +
    "\uffee\001\002\000\014\003\052\005\026\006\034\007\007" +
    "\011\031\001\002\000\014\003\uffec\004\010\005\011\010" +
    "\uffec\014\uffec\001\002\000\010\003\ufff0\010\ufff0\014\ufff0" +
    "\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\052\000\006\002\003\006\005\001\001\000\002\001" +
    "\001\000\006\004\014\005\045\001\001\000\002\001\001" +
    "\000\006\004\014\005\013\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\004\021\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\003" +
    "\031\006\027\007\032\001\001\000\002\001\001\000\006" +
    "\004\014\005\045\001\001\000\002\001\001\000\012\003" +
    "\035\006\027\007\032\010\036\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\010\003\044\006\027" +
    "\007\032\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\004\014\005\045\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\003\052\006\027\007\032\001\001\000\006" +
    "\004\014\005\045\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$JsonParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$JsonParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$JsonParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



  private Osrn osrn;

  public Osrn getOsrn() { return osrn; }

  private void addError(int line, int col, String msg) {
    ErrorWrapper.add(line, col, msg);
  }

  public JsonParser(JsonLexer lexer) {
    super(lexer);
  }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$JsonParser$actions {
  private final JsonParser parser;

  /** Constructor */
  CUP$JsonParser$actions(JsonParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$JsonParser$do_action_part00000000(
    int                        CUP$JsonParser$act_num,
    java_cup.runtime.lr_parser CUP$JsonParser$parser,
    java.util.Stack            CUP$JsonParser$stack,
    int                        CUP$JsonParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$JsonParser$result;

      /* select the action based on the action number */
      switch (CUP$JsonParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= syntax EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).value;
		RESULT = start_val;
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$JsonParser$parser.done_parsing();
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // syntax ::= content 
            {
              Object RESULT =null;
		 osrn = OsrnWrapper.close(); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("syntax",0, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // syntax ::= 
            {
              Object RESULT =null;
		 OsrnWrapper.addEmpty(); osrn = OsrnWrapper.close(); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("syntax",0, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // content ::= CUR_IZQ obj CUR_DER 
            {
              OsrnWrapper RESULT =null;

              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("content",4, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // content ::= CUR_IZQ CUR_DER 
            {
              OsrnWrapper RESULT =null;
		 OsrnWrapper.addEmpty(); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("content",4, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // content ::= error obj CUR_DER 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).right;
		OsrnWrapper get = (OsrnWrapper)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).value;
		 addError(getleft, getright, " << { >> antes del objeto."); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("content",4, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // content ::= CUR_IZQ BRA_IZQ error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).value;
		 addError(getleft, getright, " << } >> antes del arreglo."); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("content",4, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // array ::= BRA_IZQ array_ BRA_DER 
            {
              OsrnWrapper RESULT =null;

              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("array",5, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // array ::= BRA_IZQ BRA_DER 
            {
              OsrnWrapper RESULT =null;
		 ArrayWrapper.addEmpty(); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("array",5, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // array_ ::= value 
            {
              OsrnWrapper RESULT =null;
		int valueleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object value = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 ArrayWrapper.addFirst(value); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("array_",6, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // array_ ::= array_ COMMA value 
            {
              OsrnWrapper RESULT =null;
		int valueleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object value = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 ArrayWrapper.add(value); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("array_",6, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // array_ ::= array_ COLON error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).value;
		 addError(getleft, getright, "a << , >> o un << ] >>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("array_",6, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // array_ ::= array_ COMMA error 
            {
              OsrnWrapper RESULT =null;
		int commaleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).left;
		int commaright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).right;
		Object comma = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).value;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 addError(getleft, getright, " <valor>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("array_",6, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // obj ::= pair 
            {
              OsrnWrapper RESULT =null;
		 OsrnWrapper.addFirstPair(PairWrapper.getPair()); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("obj",3, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // obj ::= obj COMMA pair 
            {
              OsrnWrapper RESULT =null;
		 OsrnWrapper.addPair(PairWrapper.getPair()); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("obj",3, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // obj ::= obj COMMA error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 addError(getleft, getright, " << } >> o un <clave-valor>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("obj",3, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // obj ::= obj error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 addError(getleft, getright, "a << , >>, << } >>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("obj",3, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // pair ::= ID COLON value 
            {
              OsrnWrapper RESULT =null;
		int keyleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)).left;
		int keyright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)).right;
		String key = (String)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)).value;
		int valueleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object value = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 PairWrapper.setPair(key, value); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("pair",2, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // pair ::= LITERAL COLON value 
            {
              OsrnWrapper RESULT =null;
		int keyleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)).left;
		int keyright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)).right;
		String key = (String)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)).value;
		int valueleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int valueright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object value = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 PairWrapper.setPair(key, value); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("pair",2, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // pair ::= ID error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 addError(getleft, getright, " << : >>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("pair",2, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // pair ::= LITERAL error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 addError(getleft, getright, " << : >>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("pair",2, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // pair ::= ID COLON error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).value;
		 addError(getleft, getright, " <valor>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("pair",2, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // pair ::= LITERAL COLON error 
            {
              OsrnWrapper RESULT =null;
		int getleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).left;
		int getright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).right;
		Object get = (Object)((java_cup.runtime.Symbol) CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-1)).value;
		 addError(getleft, getright, " <valor>"); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("pair",2, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.elementAt(CUP$JsonParser$top-2)), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // value ::= LITERAL 
            {
              Object RESULT =null;
		int objleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int objright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		String obj = (String)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 RESULT = obj; 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("value",1, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // value ::= INT 
            {
              Object RESULT =null;
		int objleft = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).left;
		int objright = ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()).right;
		int obj = (int)((java_cup.runtime.Symbol) CUP$JsonParser$stack.peek()).value;
		 RESULT = obj; 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("value",1, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // value ::= content 
            {
              Object RESULT =null;
		 RESULT = OsrnWrapper.close(); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("value",1, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // value ::= array 
            {
              Object RESULT =null;
		 RESULT = ArrayWrapper.close(); 
              CUP$JsonParser$result = parser.getSymbolFactory().newSymbol("value",1, ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JsonParser$stack.peek()), RESULT);
            }
          return CUP$JsonParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$JsonParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$JsonParser$do_action(
    int                        CUP$JsonParser$act_num,
    java_cup.runtime.lr_parser CUP$JsonParser$parser,
    java.util.Stack            CUP$JsonParser$stack,
    int                        CUP$JsonParser$top)
    throws java.lang.Exception
    {
              return CUP$JsonParser$do_action_part00000000(
                               CUP$JsonParser$act_num,
                               CUP$JsonParser$parser,
                               CUP$JsonParser$stack,
                               CUP$JsonParser$top);
    }
}

}
