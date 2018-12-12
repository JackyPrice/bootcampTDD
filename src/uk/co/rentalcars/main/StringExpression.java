package uk.co.rentalcars.main;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Scanner;

public class StringExpression {

    public static HashMap<String, Integer> stringToInt = new HashMap<>();
    public static HashMap<String, String> intToString = new HashMap<>();
    public static HashMap<String, String> stringSym = new HashMap<>();
    public static HashMap<String, String> symString = new HashMap<>();

    public static void main(String[] args) throws ScriptException { //ScriptException from javaScriptConverter()
        Scanner scanner = new Scanner(System.in);
        populateHashMaps();

        System.out.println("This program takes a math based text input and returns the answer in text." +
                "\nThe following commands may be used:" +
                "\n - plus" +
                "\n - minus" +
                "\n - times" +
                "\n - divideby" +
                "\nPlease be aware that the order of precedence applies to calculations" +
                "\nAll numbers must be represented per digit, e.g. 12 = onetwo"
        );
            System.out.print("Input: ");
            String input = scanner.nextLine();

            System.out.println("Your input is: " + input); //confirms user input

            String intResult = stringToIntConverter(input); //runs StringToIntConverter()

//            System.out.println("inside the main : " + stringToInt.get("zero"));

            System.out.print("This converts to: " + intResult); // result from StringToIntConverter()

//            if(intResult.contains("/0")){
//                System.out.println("cannot divide by zero");
//            }
            if (intResult.contains("/")) {
                double evaluated = jsConverterDivide(intResult);
                System.out.print(" = " + evaluated + "\nWhich in words is: " + numberToStringConverter(evaluated));

            } else {
                int evaluated = jsConverterNotDivide(intResult);
                System.out.print(" = " + evaluated + "\nWhich, in words, is: " + numberToStringConverter(evaluated));
            }


        }



        public static String stringToIntConverter (String userInput){

            String check = "";
            String intResult = "";

            for (int i = 0; i < userInput.length(); i++) {
                check += userInput.charAt(i); // builds string to check
                if (stringToInt.containsKey(check)) { // if it contains "one", "two", "three" etc
//                    System.out.println("contains " + check);
                    intResult += stringToInt.get(check); // adds the numerical value to a string
                    check = ""; //clears string for next input

                } else if (stringSym.containsKey(check)) {
//                    System.out.println("contains " + check);
                    intResult += stringSym.get(check); // checks for add, minus etc
                    check = "";

                }
            }
            return intResult; // once complete, input "onetwoplusthree" will be outputted as "12+3"
        }

        public static <T extends Number > String numberToStringConverter(T result)
        { //generics - any type that's a number

            String stringIn = result.toString();
            String check = "";
            String stringResult = "";

            for (int i = 0; i < stringIn.length(); i++) {
                check += stringIn.charAt(i);
                if (symString.containsKey(check)) {
                    stringResult += symString.get(check); // checks for add, minus etc
                    check = "";
                } else if (stringIn.contains(check)) {
                    stringResult += intToString.get(check);
                    check = "";
                }
            }
            return stringResult;
        }


        /* uses the JavaScript engine to take a String type Math expression (e.g. "1+2+3") and return answer (int 6)*/
        public static int jsConverterNotDivide (String string) throws ScriptException
        { //throws exception because intelliJ
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");

            return (int)engine.eval(string); //cast as int, as this will be used only for integers

        }

        /* uses the JavaScript engine which returns a double, for division */
        public static double jsConverterDivide (String string) throws ScriptException
        { //throws exception because intelliJ

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            if(engine.eval(string)instanceof Integer){
//                System.out.println("int");
                return (int)engine.eval(string);
            }
            else {
//                System.out.println("double");
                return (double) engine.eval(string); //cast as int, as this will be used only for integers
            }
        }

        public static void populateHashMaps () {

            //populate stringInt
            stringToInt.put("zero", 0);
            stringToInt.put("one", 1);
            stringToInt.put("two", 2);
            stringToInt.put("three", 3);
            stringToInt.put("four", 4);
            stringToInt.put("five", 5);
            stringToInt.put("six", 6);
            stringToInt.put("seven", 7);
            stringToInt.put("eight", 8);
            stringToInt.put("nine", 9);


            //populate intToString
            intToString.put("0", "zero");
            intToString.put("1", "one");
            intToString.put("2", "two");
            intToString.put("3", "three");
            intToString.put("4", "four");
            intToString.put("5", "five");
            intToString.put("6", "six");
            intToString.put("7", "seven");
            intToString.put("8", "eight");
            intToString.put("9", "nine");


            //populate stringSym
            stringSym.put("plus", "+");
            stringSym.put("minus", "-");
            stringSym.put("times", "*");
            stringSym.put("divideby", "/");

            //populate symString
            symString.put(".", "point");
            symString.put("-", "minus");

            //populate stringSym
            stringSym.put("point", ".");
        }
    }
