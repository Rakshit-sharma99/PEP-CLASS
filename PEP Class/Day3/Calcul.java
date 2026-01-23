package Day3;

import java.util.*;

public class Calcul{

    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int minus(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(10, 20));      
      
    }
}
