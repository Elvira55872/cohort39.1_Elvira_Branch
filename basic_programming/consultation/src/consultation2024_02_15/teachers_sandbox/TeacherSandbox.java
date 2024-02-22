package consultation2024_02_15.teachers_sandbox;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherSandbox {
    public static void main(String[] args) {

        String a = "2345678987654345678567654567876546789876543456787654345678765439876545678";
        String b = "23456789876543456789876545678";

        System.out.println(add(a, b).equals(add2(a, b)));

    }


    public static String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
        }

        return result.toString();
    }

    public static String add2(String a, String b) {
        return new BigInteger(a).add(new BigInteger(b)).toString();
    }


}
