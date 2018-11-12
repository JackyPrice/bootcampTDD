package uk.co.rentalcars.main.trailanderror;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.util.Scanner;

public class trialanderror {

    public static void main(String[] args) throws ScriptException {

        Scanner scanner = new Scanner(System.in);

        String a = "1+2+3";
        System.out.println(a);

        System.out.println("Test input to convert string to int:");
        String b = scanner.nextLine();
        System.out.println(b);

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        System.out.println(engine.eval(b));

//        System.out.println("input is: " +input);
//        int parse = Integer.parseInt(input);

//        System.out.println(parse);
    }

}
