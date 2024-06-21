package hackerrank.week3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Map<Character, Character> bracketsMapper = new HashMap<>();
        bracketsMapper.put('(', ')');
        bracketsMapper.put('[', ']');
        bracketsMapper.put('{', '}');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && bracketsMapper.get(stack.peek()) == c) {
                stack.pop();
            } else if (bracketsMapper.containsKey(c)) {
                stack.push(c);
            } else {
                return "NO";
            }
        }

        return "YES";
    }

    @Test
    public void sampleTest() {
        System.out.println(isBalanced("{(([])[])[]}"));
        System.out.println(isBalanced("{(([])[])[]]}"));
    }
}
