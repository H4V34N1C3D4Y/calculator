package Calculator;

import java.util.*;

public class Calculator {

    public static void createNextOperation() throws MyException {
        System.out.println("Input:\n");
        Scanner p = new Scanner(System.in);
        String t = p.nextLine();

        if (t.matches("quit")) {
           
        } else {
            Calculation(t);
            System.out.println("\nTo stop program enter \"quit\"");
            System.out.println();
            createNextOperation();
        }
    }

    public static boolean includesArabicNumerals(String s) {
        return (s.matches("(.*)[0-9](.*)"));
    }

    public static boolean includesRomanNumerals(String s) {
        return (s.matches("(.*)[IVX](.*)"));
    }

    public static boolean isRomanNumeral(char c) {
        return (c == 'I') || (c == 'V') || (c == 'X');
    }

    public static boolean isArabicNumeral(char c) {
        return (c > 47) && (c < 58);
    }

    public static boolean isOperation(char c) {
        return (c == '+') || (c == '-') || (c == '*') || (c == '/');
    }

    public static char getOperation(String s) throws MyException {
        char op = 0;
        for (int i = 0; i < s.length(); i++) {
            if (op != 0) {
                break;
            } else {
                if (isOperation(s.charAt(i))) {
                    op = s.charAt(i);
                }
            }
            if ((op == 0) && (i == s.length() - 1)) {
                throw new MyException("You have not entered any operation");
            }
        }
        return op;
    }

    public static int[] getTwoNumbers(String s) throws MyException {
        int a[] = new int[2];
        int count = 0;
        String q = "";
        for (int i = 0; i < s.length(); i++) {
            if (!isOperation(s.charAt(i)) && !isArabicNumeral(s.charAt(i)) && !isRomanNumeral(s.charAt(i)) && s.charAt(i) != ' ') {
                throw new MyException("You have not entered any correct character");

            }
        }
        if (!includesArabicNumerals(s) && !includesRomanNumerals(s)) {
            throw new MyException("You have not entered any number");
        } else {
            if (includesArabicNumerals(s) && includesRomanNumerals(s)) {
                throw new MyException("You have entered Roman and Arabic numerals");
            } else {
                if (includesArabicNumerals(s) && !includesRomanNumerals(s)) {

                    for (int i = 0; i < s.length(); i++) {
                        if (isArabicNumeral(s.charAt(i))) {
                            q += s.charAt(i);
                            if (i == s.length() - 1) {
                                a[count] = Integer.parseInt(q);
                                if ((a[count] > 10) || (a[count] < 1)) {
                                    throw new MyException("You have entered uncorrect number");
                                }
                                q = "";
                                count++;
                            }
                        } else {
                            if (isArabicNumeral(s.charAt(i - 1))) {

                                a[count] = Integer.parseInt(q);
                                if ((a[count] > 10) || (a[count] < 1)) {
                                    throw new MyException("You have entered uncorrect number");
                                }
                                q = "";
                                count++;
                            }
                        }
                    }
                }
                if (!includesArabicNumerals(s) && includesRomanNumerals(s)) {
                    for (int i = 0; i < s.length(); i++) {
                        if (isRomanNumeral(s.charAt(i))) {
                            q += s.charAt(i);
                            if (i == s.length() - 1) {
                                a[count] = RomanNumerals.romanToArabic(q);
                                q = "";
                                count++;
                            }
                        } else {
                            if (isRomanNumeral(s.charAt(i - 1))) {

                                a[count] = RomanNumerals.romanToArabic(q);
                                q = "";
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public static void Calculation(String s) throws MyException {
        
        System.out.println("\nOutput:\n");
        
        int result = 0;
        int remainder = 0;                                               // В случае остатка от деления
        int NumbersCollection[] = getTwoNumbers(s);
        
        switch (getOperation(s)) {
            
            case '+':
                result = NumbersCollection[0] + NumbersCollection[1];
                break;
            case '-':
                result = NumbersCollection[0] - NumbersCollection[1];
                break;
            case '*':
                result = NumbersCollection[0] * NumbersCollection[1];
                break;
            case '/':
                result = NumbersCollection[0] / NumbersCollection[1];
                remainder = NumbersCollection[0] % NumbersCollection[1];
                break;

        }
        if (includesArabicNumerals(s)) {  
            
                System.out.println(result);
            
            if (remainder != 0) {
                System.out.println("Remainder:");
                System.out.println(remainder);
            }
        } else {
            
            System.out.println(RomanNumerals.arabicToRoman(result));
            if (remainder != 0) {
                System.out.println("Remainder:");
                System.out.println(RomanNumerals.arabicToRoman(remainder));
            }
        }
    }

    public static void main(String[] args) throws MyException {
        
        createNextOperation();
    }
}
