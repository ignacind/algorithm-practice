package hackerrank;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static java.util.Collections.max;

public class HackerRankMain {
//    public static void main(String[] args) throws ParseException {
////        List<Integer> arr = new ArrayList<>();
////        arr.add(10);
////        arr.add(10);
////        arr.add(20);
////        arr.add(10);
////        arr.add(50);//10 20 20 10 10 30 50 10 20
////        arr.add(10);
////        arr.add(20);
////        arr.add(30);
////
////        int[] a = {1,2,3,4,5,6,7};
//////        findZigZagSequence(a,a.length);
//////        System.out.println(sockMerchant(5, arr));
//////        System.out.println(pageCount(5,3));
//////        System.out.println(caesar_chiper("a bcdefghijklmnopqrstuvwxyz", 3));
////
////        List<Integer> skill = new ArrayList<>();
////        skill.add(1);
////        skill.add(5);
////        skill.add(4);
////        skill.add(2);
////        long result = getTotalEfficiency(skill);
////        System.out.println(result);
////        List<Integer> arr = new ArrayList<>();
////        arr.add(5);
////        arr.add(6);
////
////        arr.add(11);
////        System.out.println(balancedSums(arr));
////        System.out.println(counterGame(132));
//
//
//        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//        Date d1 = formato.parse("02-08-2025");
//        Date d2 = formato.parse("04-09-2025");
//        System.out.println(luckyDates(d1, d2));
//    }
//


    public static int luckyDates(Date d1, Date d2) {
        SimpleDateFormat sFormat = new SimpleDateFormat("dMMyyyy");
        String date1 = sFormat.format(d1);
        String date2 = sFormat.format(d2);

        int n1 = Integer.parseInt(date1);
        int n2 = Integer.parseInt(date2);

        if (n1 > n2) {
            int temp = n2;
            n2 = n1;
            n1 = temp;
        }

        int countLuckyDates = 0;
        while (n1 <= n2) {
            if (n1 % 4 == 0 || n1 % 7 == 0) {
                countLuckyDates++;
            }

            if (n2 % 4 == 0 || n2 % 7 == 0) {
                countLuckyDates++;
            }
            n1+=1;
            n2-=1;
        }

        return countLuckyDates;
    }
    public static String counterGame(long n) {
        int turn = 1;
        double res;
        while (n != 1) {
            res = Math.log(n) / Math.log(2);
            if (!(res == (int) res)) {
                long aux = 1;
                while (aux < n) {
                    aux *= 2;
                }
                n -= aux/2;
            } else {
                n /= 2;
            }
            turn *= -1;
        }

        return (turn * -1 ==1) ? "Louise" : "Richard";
    }



    public static String balancedSums(List<Integer> arr) {
        int totalSum = arr.stream().mapToInt(Integer::intValue).sum();
        int leftSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            int rightSum = totalSum - leftSum - arr.get(i);
            if (leftSum == rightSum) {
                return "YES";
            }
            leftSum += arr.get(i);
        }

        return "NO";
    }

    public static void minMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        long max_sum = arr.subList(1, arr.size()).stream().mapToLong(Integer::longValue).sum();
        long min_sum = arr.subList(0, arr.size()-1).stream().mapToLong(Integer::longValue).sum();
        System.out.print(min_sum + " " + max_sum);
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> answers = new ArrayList<>();
        int[][] arr = new int[n][];
        int lastAns = 0;

        for (int i = 0; i < queries.size(); i++) {
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            int idx = ((x^n) % lastAns);

            if (queries.get(i).get(0) == 1) {
                answers.add(y);
            } else if (queries.get(i).get(0) == 2) {
                lastAns = arr[idx][y % arr[idx].length];
                answers.add(lastAns);
            }
        }

        return answers;
    }

    public static long getTotalEfficiency(List<Integer> skill) {
        // Write your code here
        if (skill.size() % 2 != 0) {
            return -1;
        }
        int sumSkills = 0;

        HashMap<Integer, Integer> skills_map = new HashMap<>();

        for (int n: skill) {
            sumSkills += n;
            if (skills_map.containsKey(n)) {
                skills_map.put(n, skills_map.get(n)+1);
            } else {
                skills_map.put(n, 1);
            }
        }



        if (sumSkills % 2 != 0) {
            return -1;
        }
        int team_sum = sumSkills / 2;
        long total = 0;

        for (Map.Entry<Integer, Integer> entry: skills_map.entrySet()) {
            int mssing = team_sum - entry.getKey();

            if (!skills_map.containsKey(mssing)) {
                return -1;
            }
            if (entry.getValue() != skills_map.get(mssing)) {
                return -1;
            }

            total += (long) entry.getValue() * (mssing * entry.getKey());

        }

        return total/2;
    }

    public static List<Integer> sentTimes(int numberOfPorts, int transmissionTime, List<Integer> packetIds) {
        HashMap<Integer, Integer> ports_map = new HashMap<>();
        for (int i = 0; i < numberOfPorts; i++) {
            ports_map.put(i, 0);
        }
        int count = 0;
        List<Integer> packet = new ArrayList<>();

        for (Integer id : packetIds) {
            int hash = id % numberOfPorts;
            if (ports_map.get(hash) <= count) {
                packet.add(hash);
                ports_map.put(hash, transmissionTime + count);
                count++;
            } else {
                while (ports_map.get(hash) > count) {
                    hash = (hash + 1) % numberOfPorts;
                }
                ports_map.put(hash, transmissionTime + count);
                packet.add(hash);
                count++;
            }
        }

        return packet;
    }
    public static int maxMin_unfairness(int k, List<Integer> arr) {
        int min_unfairness = Integer.MAX_VALUE;
        int current_unfairness;
        Collections.sort(arr);
        for (int i = 0; i< arr.size()-k+1;i++) {
            current_unfairness = arr.get(i+k-1) - arr.get(i);
            min_unfairness = Math.min(min_unfairness, current_unfairness);
        }
        return min_unfairness;
    }

    public static String caesar_chiper(String s, int k) {
        StringBuilder msg_chipered = new StringBuilder();
        int ascii;
        char newChar;
        for (char c: s.toCharArray()) {
            newChar = c;
            if ('A' <= c && c <= 'Z') {
                ascii = ((int) c) - 65;
                newChar = (char) (((ascii + k) % 26) + 65);

            } else if ('a' <= c && c <= 'z') {
                ascii = ((int) c) - 97;
                newChar = (char) (((ascii + k) % 26) + 97);

            }
            msg_chipered.append(newChar);


        }

        return msg_chipered.toString();
    }


    public static int towerBreakers(int n, int m) {
        if (n % 2 == 0 || m == 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int max_sum = 0;
        int n = matrix.size() - 1;
        int n1;
        int n2;
        int n3;
        int n4;
        for (int i = 0; i<n/2; i++) {
            for (int j = 0; j<n/2; j++) {
                n1 = matrix.get(i).get(j);
                n2 = matrix.get(i).get(n-j);
                n3 = matrix.get(n-i).get(j);
                n4 = matrix.get(n-i).get(n-j);
                max_sum += Math.max(Math.max(n1,n2), Math.max(n3, n4));

            }
        }
        return max_sum;
    }

    public static int pageCount(int n, int p) {

        int front = (p / 2);
        int back = (n / 2) - (p / 2);

        return Math.min(front, back);
    }
    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = n/2;
        System.out.println(Arrays.toString(a));
        System.out.println(a[mid]);
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st ++;
            ed --;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer, Integer> socks = new HashMap<>();
        int nPairs = 0;
        for (int x: ar) {
            if (socks.containsKey(x)) {
                socks.put(x, socks.get(x)+1);
            } else {
                socks.put(x, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: socks.entrySet()) {
            if (entry.getValue() >= 2) {
                nPairs += entry.getValue() / 2;

            }
        }
        return nPairs;
    }


}