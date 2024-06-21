package codewars;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CodewarsMain {

    public static void main(String[] args) {
//        Double[] a = new Double[4];
//        a[0] = 2.2;
//        System.out.println(findUniqN(a));
//        int[] dices = new int[] {5, 1, 3, 4, 1};
////        System.out.println(greedy(dices));
//        System.out.println(encode("Prespecialized"));

//        System.out.println(top3(" ' ' ''' "));


//        System.out.println(getPeaks(new int[]{2,1,3,1,2,2,2,2})); // {2,1,3,1,2,2,2,2,1}
//        System.out.println(orderWeight("56 65 74 100 99 68 86 180 90")); // output = "100 180 90 56 65 74 68 86 99"
//        System.out.println(getPins("8"));
//        System.out.println(treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2), new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)));
//        String maze = ".W...W.W..\n"+
//                ".......W..\n"+
//                "W..W......\n"+
//                "...W.WW...\n"+
//                "WW..W..WW.\n"+
//                ".....W....\n"+
//                "W.W.W....W\n"+
//                "...WW...W.\n"+
//                ".W........\n"+
//                ".W........";
//        System.out.println(pathFinder(maze));
//        System.out.println(findAll(59, 11));
//        System.out.println(decompose(250));
//        System.out.println(properFractions(999999999));
//        System.out.println(hammingNumbers(5));
//        System.out.println(formatDuration(3662));
//        System.out.println(balanceNparantheses(3));
//        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } ));
        System.out.println(0 / 4);
    }


    public static String stripComments(String text, String[] commentSymbols) {
        Pattern pttrn = Pattern.compile("([" + String.join("", commentSymbols)  + "])[^\n]*");
        return pttrn.matcher(text).replaceAll("")
                .lines()
                .map(line -> line.trim().isEmpty() ? line : line.trim())
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    public static List<String> balanceNparantheses(int n) {
        List<String> combinations = new ArrayList<>();
        balanceParenthesesHelper_BT(combinations, n, 0, 0, new StringBuilder());

        return combinations;
    }

    public static void balanceParenthesesHelper_BT (List<String> combinations, int n, int open, int close, StringBuilder comb) {
        if (comb.length() == n * 2) {
            combinations.add(comb.toString());
            return;
        }

        if (open < n) {
            balanceParenthesesHelper_BT(combinations, n, open+1, close, comb.append("("));
            comb.deleteCharAt(comb.length()-1);
        }
        if (close < open) {
            balanceParenthesesHelper_BT(combinations, n, open, close+1, comb.append(")"));
            comb.deleteCharAt(comb.length()-1);
        }

    }

    public static String formatDuration(int seconds) {

        if (seconds <= 0) {
            return "now";
        }

        int[] results = new int[]{seconds / (3600*24*365), (seconds / (3600*24)) % 365,
                (seconds / (60*60)) % 24, (seconds / 60) % 60, (seconds % 60) % 60};
        String[] category = new String[] {" year", " day", " hour", " minute", " second"};
        String output = "";
        int count = 0;
        for (int i = results.length-1; i >= 0; i--) {
            if (results[i] > 0) {
                if (count == 1) {
                    output = " and " + output;
                } else if(count > 0) {
                    output = ", " + output;
                }

                output = (results[i] > 1 ? category[i]+"s" : category[i]) + output;
                output = results[i] + output;
                count++;
            }
        }

        return output;
    }


    public static int hammingNumbers(int n) {
        int count = 0;

        int[] arr = new int[]{2,3,5};
        int[] powers = new int[]{0, 0, 0};
        for (int i = 0; i < n; i++) {
            int temp = Integer.MAX_VALUE;
            int lstIndex = -1;
            for (int k=0 ; k<3; k++) {
                if (Math.pow(arr[k], powers[k]+1) < temp) {
                    if (lstIndex != -1) {
                        powers[lstIndex]--;
                    }
                    lstIndex = k;
                    temp = (int) Math.pow(arr[k], powers[k]+1);
                    powers[k]++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i] + "**" + powers[i]);
        }
        return 0;
    }


    public static long properFractions(long d) {
        long count = 0;
        long startTime = System.currentTimeMillis();
        System.out.println(eulerTotient(d));
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime + "asd");
        return count;
    }

    public static long eulerTotient(long n) {
        long result = n;

        // Consider all prime factors of n and subtract their multiples from result
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                // Subtract multiples of p
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    public static String decompose(long n) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Long> sequence = new ArrayList<>();
        long target = (long) Math.pow(n, 2);

        getSequencesForNsquared(sequence, target, n);

        if (sequence.isEmpty()) {
            return null;
        }
        Collections.sort(sequence);

        return sequence.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public static void getSequencesForNsquared(List<Long> sequence, long target, long lastNum) {
        Stack<Long> numStack = new Stack<>();
        Stack<Long> resultStack = new Stack<>();

        numStack.push(lastNum);
        resultStack.push(target);

        while (!numStack.isEmpty()) {
            long currentNum = numStack.pop();

            for (long i = currentNum - 1; i > 0; i--) {
                long result = resultStack.peek() - i * i;
                if (result >= 0) {
                    sequence.add(i);
                    numStack.push(i);
                    resultStack.push(result);

                    if (result == 0) {
                        return;
                    }
                }
            }

            // Backtrack
            if (!sequence.isEmpty()) {
                resultStack.pop();
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    private static long count;
    private static long min;
    private static long max;

    public static List<Long> findAll(long targetSum, int numDigits) {
        List<Long> output = new ArrayList<>();
        count = 0;
        min = 0;
        max = 0;

        getRecursivelyAllNums(0, 1, targetSum, numDigits);

        if (count>0) {
            output.add(count);
            output.add(min);
            output.add(max);
        }
        return output;
    }

    public static void getRecursivelyAllNums(long currNum, int prevDigit, long targetSum, long numDigits) {
        if (targetSum == 0 && numDigits == 0) {
            if (count == 0) min = currNum;
            min = Math.min(min, currNum);
            max = Math.max(max, currNum);
            count++;
        } else if (numDigits != 0) {
            for (int i = prevDigit; i < 10; i++) {
                getRecursivelyAllNums(10 * currNum + i, i, targetSum-i, numDigits-1);
            }
        }
    }




    public static boolean pathFinder(String maze) {
        String[] rows = maze.split("\n");
        int n = rows.length;
        char[][] mazeArr = new char[n][n];
        boolean[][] matrix = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            mazeArr[i] = rows[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mazeArr[i][j] == 'W') {
                    matrix[i][j] = false;
                    continue;
                }
                if (i == 0 && j == 0) {
                    matrix[0][0] = true;
                } else if (i == 0) {
                    matrix[0][j] = matrix[0][j-1];
                } else if (j == 0) {
                    matrix[i][0] = matrix[i-1][0];
                } else {
                    matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
                }
            }

        }
        return matrix[n-1][n-1];
    }



    public static List<Integer> treeByLevels(Node node) {
        List<Integer> output = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            for (int i = 0; i<q.size();i++) {
                Node k = q.poll();
                if (k != null) {
                    q.add(k.left);
                    q.add(k.right);
                    output.add(k.value);
                }
            }

        }
        return output;
    }



    private static final Map<Character, List<Character>> adjacentsMap;

    static {
        adjacentsMap = new HashMap<>();
        adjacentsMap.put('0', List.of('8'));
        adjacentsMap.put('1', List.of('2', '4'));
        adjacentsMap.put('2', List.of('1', '3', '5'));
        adjacentsMap.put('3', List.of('2', '6'));
        adjacentsMap.put('4', List.of('1', '5', '7'));
        adjacentsMap.put('5', List.of('2', '4', '6', '8'));
        adjacentsMap.put('6', List.of('3', '5', '9'));
        adjacentsMap.put('7', List.of('4', '8', '0'));
        adjacentsMap.put('8', List.of('5', '7', '9'));
        adjacentsMap.put('9', List.of('6', '8'));
    }

    public static List<Character> getAdjacents(char digit) {
        return adjacentsMap.get(digit);
    }

    public static List<String> getPins(String observed) {

        List<String> result = new ArrayList<>();
        get(observed, new StringBuilder(), result);
        return result;
    }

    private static void get(String observed, StringBuilder pin, List<String> result) {
        if (pin.length() == observed.length()) {
            result.add(pin.toString());
            return;
        }

        int index = pin.length();
        char digit = observed.charAt(index);
        List<Character> adjacents = new ArrayList<>(getAdjacents(digit));
        adjacents.add(digit);

        for (char adjacent : adjacents) {
            pin.append(adjacent);
            get(observed, pin, result);
            pin.deleteCharAt(pin.length() - 1);
        }
    }

    public static String orderWeight(String s) {
        String[] weights = s.trim().split("\\s+");
        Arrays.sort(weights, Comparator.comparing(CodewarsMain::calculateSumDigits).thenComparing(String::compareTo));

        return String.join(" ", weights);
    }

    public static int calculateSumDigits(String number) {
        int sum = 0;
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }

    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> pos_peak = new HashMap<>();
        pos_peak.put("pos", new ArrayList<Integer>());
        pos_peak.put("peaks", new ArrayList<Integer>());
        int currentPos = -1;
        int currentPeak = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                currentPos = i;
                currentPeak = arr[i];
            } else if (arr[i-1] > arr[i] && currentPos != -1) {
                pos_peak.get("pos").add(currentPos);
                pos_peak.get("peaks").add(currentPeak);
                currentPos = -1;
            }
        }
        return pos_peak;
    }


    public static List<String> top3(String sentence) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        String cleanedString = sentence.replaceAll("[^a-zA-Z\\s']+", " ");
        String[] allWords = cleanedString.split("\\s+");

        for (String w : allWords) {
            if (!w.isBlank()) {
                wordsMap.put(w.toLowerCase(), wordsMap.getOrDefault(w.toLowerCase(), 1) + 1);
            }
        }
        System.out.println(wordsMap);
        List<String> output = new ArrayList<>();

        while (!wordsMap.isEmpty() && output.size() < 3) {
            String word = maxValueInMap(wordsMap);
            if (!word.matches("^'+$")) {
                output.add(word);
            }
        }

        return output;
    }

    public static String maxValueInMap(HashMap<String, Integer> wordsMap) {
        int valFound = Integer.MIN_VALUE;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry: wordsMap.entrySet()) {
            if (entry.getValue() > valFound) {
                valFound = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        wordsMap.remove(maxWord);
        return maxWord;
    }


    public static String encode(String word){
        HashMap<Character, Integer> charMap = new HashMap<>();
        String wordEncoded = "";
        String wordLower = word.toLowerCase();
        for (char c: wordLower.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (char c: wordLower.toCharArray()) {
            wordEncoded = (charMap.get(c) > 1) ? wordEncoded.concat(")") : wordEncoded.concat("(");
        }

        return wordEncoded;
    }
    public static int greedy(int[] dice){
        int points = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int n : dice) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for (int value = 1; value <= 6 ; value++) {
            int count = countMap.getOrDefault(value, 0);
            
            if (count >= 3) {
                if (value == 1) {
                    points += 1000;
                } else {
                    points += value * 100;
                }
                count -= 3;
            }

            if (value == 1) {
                points += count * 100;
            } else if (value == 5) {
                points += count * 50;
            }

        }

        return points;
    }
    public static boolean isPangram(String sentence) {
        HashSet<Character> letters = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)){
                letters.add(c);}
        }
        return letters.size() == 26;
    }

    public static boolean isIsogram(String s) {
        HashSet<Character> letters = new HashSet<>();
        for (char c: s.toLowerCase().toCharArray()) {
            if (letters.contains(c)) {
                return false;
            }
            letters.add(c);
        }
        return true;
    }

    public static boolean comb(int[] a, int[] b) {
        HashMap<Integer, Integer> n_squared = new HashMap<>();
        if (a==null || b==null){return false;}
        for (int n: a) {
            int key = (int) Math.pow(n, 2);
            if (n_squared.containsKey(key)) {
                n_squared.put(key, n_squared.get(key)+1);
            } else {
                n_squared.put(key, 1);
            }
        }
        for (int n: b) {
            if (n_squared.containsKey(n) && n_squared.get(n) > 0) {
                n_squared.put(n, n_squared.get(n)-1);
            } else{
                return false;
            }
        }
        return true;
    }

    public static String getPhoneNumber(int[] numbers) {

        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2],numbers[3],numbers[4],numbers[5],
                numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static int[] DeadFish_parse(String data) {
        ArrayList<Integer> output = new ArrayList<>();
        int value = 0;

        for (char c: data.toCharArray()) {
            switch (c) {
                case 'i' -> value++;
                case 'd' -> value--;
                case 's' -> value *= value;
                case 'o' -> output.add(value);
                default -> {
                }
            }
        }
        int[] res = new int[output.size()];

        for (int i=0; i<output.size(); i++) {
            res[i] = output.get(i);
        }

        return res;
    }
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return factorial(n-1) * n;
    }

    public static int zeros_in_factorial(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static Double findUniqN(Double[] arr) {
        HashMap<Double, Integer> numbers = new HashMap<>();

        for (Double n: arr) {
            if (numbers.containsKey(n)) {
                numbers.put(n, numbers.get(n) + 1);
            } else {
                numbers.put(n, 1);
            }
        }
        Double min_key = 0.0;
        int min_value = Integer.MAX_VALUE;
        for (Map.Entry<Double, Integer> entry: numbers.entrySet()) {
            if (entry.getValue() < min_value) {
                min_value = entry.getValue();
                min_key = entry.getKey();
            }
        }
        return min_key;
    }


//    public static List<Integer>
}
