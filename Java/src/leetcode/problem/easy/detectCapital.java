package leetcode.problem.easy;

public class detectCapital {

    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count == 0
                || (count == 1 && Character.isUpperCase(word.charAt(0)))
                || count == word.length();
    }
}
