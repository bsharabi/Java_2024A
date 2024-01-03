package L02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2020B {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {
        int ans;
        boolean bool;

        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            System.out.println("------------------------------------------");
            switch (num) {
                case 1:
                    q1();
                    break;
                case 2:
                    int size = rd.nextInt(100) + 1;
                    Jumper[] jumpers = new Jumper[size];
                    for (int i = 0; i < size; i++) {
                        jumpers[i] = new Jumper("name-" + i, rd.nextInt(100) + 1);
                    }
                    double avg = Jumper.q2_a(jumpers);
                    System.out.println("Avg -> " + avg);
                    System.out.println(Arrays.toString(jumpers));
                    Jumper.q2_b(jumpers);
                    break;
                case 3:
                    break;
                case 4:
                    bool = q4(new int[]{44, 31, 13, 10, 56, 2});
                    bool = q4(null);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    String str = "READ ONLY MEMORY";
                    String newStr = q9(str);
                    System.out.println(newStr);
                    break;
                case 10:
                    int[] arr = new int[]{4, 10, 13, 71, 10, 10, 71, 71, 2, 10};
                    num = 71;
                    int dis = q10_a(arr, 71);
                    System.out.println(num + " Dis -> " + dis);
                    num = q10_b(arr);
                    System.out.println("Min dis -> " + num);
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case -1:
                    return;

            }

        }
    }

    //O(n^2)
    private static int q10_b(int[] arr) {
        int min = q10_a(arr, arr[0]); // n
        int number = arr[0]; // 1
        int size = arr.length; // 1
        for (int i = 1; i < size; i++) { // n
            int tempMin = q10_a(arr, arr[i]);  // n
            if (min >= tempMin) { // 1
                min = tempMin;
                number = arr[i];
            }
        }

        return number;
    }

    //O(n)
    private static int q10_a(int[] arr, int num) {

        int counterLeft = 0, counterRight = 0; // 1
        int size = arr.length; // 1

        // n
        for (counterLeft = 0; counterLeft < size; counterLeft++)
            if (arr[counterLeft] == num)
                break;
        // 1
        if (counterLeft == size)
            return -1;

        // n
        for (int i = size - 1; i >= counterLeft; i--, counterRight++)
            if (arr[i] == num)
                break;

        return counterLeft + counterRight;
    }

    private static String q9(String str) {
        if (str == null)
            return null;
        int size = str.length();
        String newStr = str.charAt(0) + ".";

        //"READ ONLY MEMORY"
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == ' ')
                newStr += str.charAt(++i) + ".";
        }
        return newStr;

    }

    private static void q1() {

        int cntDigit = 0;
        int cntA = 0;

        String str = "";
        int size;
        char ch;

        for (int i = 0; i < 50; i++) {

            str = sc.next();
            size = str.length();
            ch = str.charAt(0);

            if (size % 2 == 0)
                System.out.println(ch);
            else
                System.out.println(str.charAt(size - 1));

            ch = str.charAt(size - 1);
            cntA += (ch == 'A') ? 1 : 0;
            cntDigit += (ch >= '0' && ch <= '9') ? 1 : 0;

        }

    }

    private static boolean q4(int[] arr) {
        if (arr == null)
            return false;

        int size = arr.length;
        if (size % 2 != 0 || size < 4)
            return false;

        int rightSum = 0;
        int leftSum = 0;
        int middle = size / 2;

        for (int i = 0; i < middle; i++)
            leftSum += arr[i];

        for (int i = middle; i < size; i++)
            rightSum += arr[i];

        return rightSum == leftSum;
    }

    static class Jumper {

        private String name;
        private double score;

        public Jumper(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public static double q2_a(Jumper[] arr) {
            if (arr == null)
                return 0;

            double avg = 0;
            int counter = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    avg += arr[i].getScore();
                    counter++;
                }
            }

            return avg / counter;
        }

        public static void q2_b(Jumper[] arr) {
            if (arr == null)
                return;

            double avg = q2_a(arr);

            for (int i = 0; i < arr.length; i++) {
                Jumper jumper = arr[i];
                if (jumper != null && jumper.getScore() > avg) {
                    System.out.println(jumper.getName());
                }
            }

        }

        @Override
        public String toString() {
            return "Jumper{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

}
