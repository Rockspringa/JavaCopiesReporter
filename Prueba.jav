package java.com.util;

import java.util.*; // comentario simple
import java.sql.base1; // Statement,
public class SumNatural {
final private static int asd = 1;
    public void main(String args){
            for(int i = -5; i < 33; i++){
                System.out.println(i + ": " + toBinary(i));
                System.out.println(i);
                //always another way
                System.out.println(i + ": " + Integer.toBinaryString(i));
            }
        }

        /*
         * pre: none
         * post: returns a String with base10Num in base 2
         */
        public String toBinary(int base10Num){
            boolean isNeg = base10Num < 0;
            base10Num = Math.abs(base10Num);
            String result = "";

            while(base10Num > 1){
                result = (base10Num % 2) + result;
                base10Num /= 2;
            }

            result = base10Num + result;

            if( isNeg ) {
                result = "-" + result;}
            return result;
        }

        /*
         * pre: cal != null
         * post: return true if val consists only of characters 1 and 0, false otherwise
         */
        public boolean all0sAnd1s(String val){
            boolean all = true;
            int i = 0;
            char c;

            while(all && i < val.length()){
                c = val.charAt(i);
                i++;
            }
            return all;
        }
}
