//package uk.co.rentalcars.withjavacalculator;
//
//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//
//public class StringExpression {
//
//    public static HashMap<String, Integer> stringToInt = new HashMap<>();
//    public static HashMap<String, String> intToString = new HashMap<>();
//    public static HashMap<String, String> stringSym = new HashMap<>();
//    public static HashMap<String, String> symString = new HashMap<>();
//
//    public static void main(String[] args) throws ScriptException { //ScriptException from javaScriptConverter()
//        Scanner scanner = new Scanner(System.in);
//        populateHashMaps();
//
//        String[] aaaa = {"1", "1+2", "4"};
//        int count = 0;
//        for (int i = 0; i < aaaa.length; i++) {
//            if (aaaa[i].contains("\\+")) {
//                count = i;
//            }
//        }
//
////aaaa = ArrayUtils.removeElement(aaaa,count);
//
//
////        String string = "1+2+3-4";
////        String[] posnumbers = string.split("\\+");
////        for(String number : posnumbers){
////            if(number.contains("\\-")){
////                posnumbers[1].contains("\\-"){
////                    posnumbers[1].trim();
////                }
////
////                posnumbers[number].trim();
////            }
////        }
////        String[] negnums = new String[10];
////
////            for (String number : posnumbers){
////                negnums = number.split("\\-");
////            }
////
////        for (String number : posnumbers){
////            System.out.println(number);
////        }
////        for (String number : negnums){
////            System.out.println(number);
////        }
//////        System.out.println(numbers);
//
//        System.out.print("Input: ");
//        String input = scanner.nextLine();
//
//        System.out.println("Your input is: " + input); //confirms user input
//
//        String intResult = stringToIntConverter(input); //runs StringToIntConverter()
//
//        System.out.println("inside the main : " + stringToInt.get("zero"));
//
//        System.out.println("This converts to: " + intResult); // result from StringToIntConverter()
//
//
////        System.out.println("TEST " + parseInteger2(intResult));
//
//
//        if (intResult.contains("/")) {
//            double evaluated = jsConverterDivide(intResult);
//            System.out.println("Which in words is: " + numberToStringConverter(evaluated));
//
//        } else {
//            int evaluated = jsConverterNotDivide(intResult);
//            System.out.println("Which in words is: " + numberToStringConverter(evaluated));
//        }
//
//
//    }
//
//    public static int parseInteger(String input) {
//        if (input.contains("\\+") && !input.contains(".")) {
//            String[] plusNums = input.split("\\+");
//            int result = 0;
//            for (int i = 0; i < plusNums.length; i++) {
//                result += Double.parseDouble(plusNums[i]);
//            }
//            return result;
//        } else if (input.contains("\\-") && !input.contains(".") && !input.contains("\\+")) {
//            String[] numbers = input.split("\\-");
//            int result = Integer.parseInt(numbers[0]);
//            for (int i = 1; i < numbers.length; i++) {
//                result += Double.parseDouble(numbers[i]) - Double.parseDouble(numbers[i]);
//            }
//            return result;
//        }
//        return -1;
//    }
////        else if (input.contains("\\-") && !input.contains(".") && input.contains("\\+"){
////            String[] posNumbers = input.split
////        }
////
////
////
////
////    }
//
////    public  <T> parseInteger2(String input) {
////
////        double dubResult = 0;
//////        if (input.contains(".") && input.contains("\\+")) {
////            String[] numbers = input.split("\\+");
////            for (int i = 0; i < numbers.length; i++) {
////                dubResult += Double.parseDouble(numbers[i]);
//
//
////        }         String[] numbers = input.split("\\-");
////        GenericType result = new GenericType(Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]));
////        System.out.println("TEST: " + result.getT());
////
////        else {
////            String[] numbers = input.split("\\+");
////            GenericType result = new GenericType(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
////            System.out.println(result);
////            }
////        }
////        GenericType result = new GenericType<Double>(dubResult);
////        return result.getT();
////    }
//
//
//    public static String stringToIntConverter(String userInput) {
//
//        String check = "";
//        String intResult = "";
//
//        for (int i = 0; i < userInput.length(); i++) {
//            check += userInput.charAt(i); // builds string to check
//            if (stringToInt.containsKey(check)) { // if it contains "one", "two", "three" etc
//                System.out.println("contains " + check);
//                intResult += stringToInt.get(check); // adds the numerical value to a string
//                check = ""; //clears string for next input
//
//            } else if (stringSym.containsKey(check)) {
//                System.out.println("contains " + check);
//                intResult += stringSym.get(check); // checks for add, minus etc
//                check = "";
//
//            }
//        }
//        return intResult; // once complete, input "onetwoplusthree" will be outputted as "12+3"
//    }
//
//    public static <T extends Number> String numberToStringConverter(T result) { //generics - any type that's a number
//
//        String stringIn = result.toString();
//        String check = "";
//        String stringResult = "";
//
//        for (int i = 0; i < stringIn.length(); i++) {
//            check += stringIn.charAt(i);
//            if (symString.containsKey(check)) {
//                stringResult += symString.get(check); // checks for add, minus etc
//                check = "";
//            } else if (stringIn.contains(check)) {
//                stringResult += intToString.get(check);
//                check = "";
//            }
//        }
//        return stringResult;
//    }
//
//
//    /* uses the JavaScript engine to take a String type Math expression (e.g. "1+2+3") and return answer (int 6)*/
//    public static int jsConverterNotDivide(String string) throws ScriptException { //throws exception because intelliJ
//        ScriptEngineManager mgr = new ScriptEngineManager();
//        ScriptEngine engine = mgr.getEngineByName("JavaScript");
//
//        return (int) engine.eval(string); //cast as int, as this will be used only for integers
//
//    }
//
//    /* uses the JavaScript engine which returns a double, for division */
//    public static double jsConverterDivide(String string) throws ScriptException { //throws exception because intelliJ
//        ScriptEngineManager mgr = new ScriptEngineManager();
//        ScriptEngine engine = mgr.getEngineByName("JavaScript");
//
//        return (double) engine.eval(string); //cast as int, as this will be used only for integers
//
//    }
//
//    public static void populateHashMaps() {
//
//        //populate stringInt
//        stringToInt.put("zero", 0);
//        stringToInt.put("one", 1);
//        stringToInt.put("two", 2);
//        stringToInt.put("three", 3);
//        stringToInt.put("four", 4);
//        stringToInt.put("five", 5);
//        stringToInt.put("six", 6);
//        stringToInt.put("seven", 7);
//        stringToInt.put("eight", 8);
//        stringToInt.put("nine", 9);
//
//
//        //populate intToString
//        intToString.put("0", "zero");
//        intToString.put("1", "one");
//        intToString.put("2", "two");
//        intToString.put("3", "three");
//        intToString.put("4", "four");
//        intToString.put("5", "five");
//        intToString.put("6", "six");
//        intToString.put("7", "seven");
//        intToString.put("8", "eight");
//        intToString.put("9", "nine");
//
//
//        //populate stringSym
//        stringSym.put("plus", "+");
//        stringSym.put("minus", "-");
//        stringSym.put("times", "*");
//        stringSym.put("divide", "/");
//
//        //populate symString
//        symString.put(".", "point");
//
//        //populate stringSym
//        stringSym.put("point", ".");
//    }
//}
//
