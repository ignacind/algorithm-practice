package codewars.kata;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Find_the_unkown_digit {
    public static int solveExpression(String s) {
        Pattern pattern = Pattern.compile("(-?[0-9?]+)([-+*])(-?[0-9?]+)(=)(-?[0-9?]+)");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            String op = matcher.group(2);
            String[] numbers = {matcher.group(1), matcher.group(3), matcher.group(5)};
            Set<Character> search = new HashSet<>();

            for (char c = '0'; c <= '9'; c++) {
                search.add(c);
            }

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    search.remove(c);
                }
            }

            for (int i = 0; i < 3; i++) {
                if (numbers[i].length() > 1
                        && numbers[i].startsWith("?")
                || (numbers[i].startsWith("-")
                        && numbers[i].charAt(1) == '?'))
                {
                    search.remove('0');
                }
            }

            for (char digit : search) {
                int[] v = new int[3];

                for (int i = 0; i < 3; i++) {
                    v[i] = Integer.parseInt(numbers[i].replace('?', digit));
                }

                if (evaluateExpression(v[0], op, v[1]) == v[2]) {
                    return Character.getNumericValue(digit);
                }
            }
        }

        return -1;
    }

    private static int evaluateExpression(int p1, String op, int p2) {
        return op.equals("+") ? p1 + p2 : (op.equals("-") ? p1 - p2 : p1 * p2);
    }



    @DisplayName("Sample tests")
    @Test
    public void testSample() {
        System.out.println(Find_the_unkown_digit.solveExpression("-?56373--9216=-?47157"));

//        assertEquals( 2, codewars.kata.Find_the_unkown_digit.solveExpression("1+1=?"), "expression = \"1+1=?\"");
//        assertEquals( 6, codewars.kata.Find_the_unkown_digit.solveExpression("123*45?=5?088"), "expression = \"123*45?=5?088\"");
//        assertEquals( 0, codewars.kata.Find_the_unkown_digit.solveExpression("-5?*-1=5?"), "expression = \"-5?*-1=5?\"");
//        assertEquals(-1, codewars.kata.Find_the_unkown_digit.solveExpression("19--45=5?"), "expression = \"19--45=5?\"");
//        assertEquals( 5, codewars.kata.Find_the_unkown_digit.solveExpression("??*??=302?"), "expression = \"??*??=302?\"");
//        assertEquals( 2, codewars.kata.Find_the_unkown_digit.solveExpression("?*11=??"), "expression = \"?*11=??\"");
//        assertEquals( 2, codewars.kata.Find_the_unkown_digit.solveExpression("??*1=??"), "expression = \"??*1=??\"");
//        assertEquals(-1, codewars.kata.Find_the_unkown_digit.solveExpression("??+??=??"), "expression = \"??+??=??\"");
    }
}
