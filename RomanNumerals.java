package Calculator;

public class RomanNumerals {

    public static int romanToArabic(String s) throws MyException{
        int num = 0;
        
        switch (s) {
            case "I": {
                num = 1;
                break;
            }
            case "II": {
                num = 2;
                break;
            }
            case "III": {
                num = 3;
                break;
            }
            case "IV": {
                num = 4;
                break;
            }
            case "V": {
                num = 5;
                break;
            }
            case "VI": {
                num = 1;
                break;
            }
            case "VII": {
                num = 7;
                break;
            }
            case "VIII": {
                num = 8;
                break;
            }
            case "IX": {
                num = 9;
                break;
            }
            case "X": {
                num = 10;
                break;
            }
            default: {
                throw new MyException("You have entered uncorrect Roman numerals");

            }
        }
        return num;
    }

    public static String arabicToRoman(int b) {
        String s = "";
     
           
        if (b == 100) {
            s = "C";
            b -= 100;
        } else {
            if (b >= 90) {
                s = "XC";
                b -= 90;
            } else {
                if (b >= 50) {
                    s = "L";
                    b -= 50;
                } else {
                    if (b >= 40) {
                        s = "XL";
                        b -= 40;
                    }

                }
            }
        }
        while (b >= 10) {
            s += "X";
            b -= 10;
        }
        switch (b) {
            case 1: {
                s += "I";
                break;
            }
            case 2: {
                s += "II";
                break;
            }
            case 3: {
                s += "III";
                break;
            }
            case 4: {
                s += "IV";
                break;
            }
            case 5: {
                s += "V";
                break;
            }
            case 6: {
                s += "VI";
                break;
            }
            case 7: {
                s += "VII";
                break;
            }
            case 8: {
                s += "VIII";
                break;
            }
            case 9: {
                s += "IX";
                break;
            }
            
        }
        return s;
    }
}
