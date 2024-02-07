package L07;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2023B {

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
                    break;
                case 3:
                    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
                    bool = q3(arr);
                    System.out.println(bool);
                    int cnt = countNumber(arr[0], arr);

                    int[] arr2 = new int[20];
                    do {
                        for (int i = 0; i < 20; i++) {
                            arr2[i] = rd.nextInt(90) + 10;
                        }

                        System.out.println(Arrays.toString(arr2));
                    } while (!q3(arr2));

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    String str = "%%ABBCCC??DD";
                    String s = what(str);
                    System.out.println(s);

                    str = "%%ABC??D";
                    s = what(str);
                    System.out.println(s);

                    String str1 = "%ABC??D";
                    String str2 = "%AABCC??DD";
                    System.out.println("str1 -> " + str1 + " output ->" + what(str1));
                    System.out.println("str2 -> " + str2 + " output ->" + what(str2));

                    System.out.println("בהינתן מחרוזת לפעולה הפעולה מחזירה מחרוזת חדשה ללא כפילויות של אותיות גדולות סמוכות (ללא רצפים)");
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    bool = q9("String s", 2);


                    int k = q9_b("String s");
                    String s1[] = {"aaaa", "bbbb", "ac", "ca"};
                    String strs[] = q9_c(s1);
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    int[][] mat = new int[10][10];
                    for (int i = 0; i < 10; i++) {
                        mat[i] = new int[10];
                        for (int j = 0; j < 10; j++) {
                            mat[i][j] = rd.nextInt(1000);
                        }
                    }
                    bool = q12(mat);
                    break;
                case 13:
                    break;
                case -1:
                    return;

            }
        }
    }

    private static boolean q12(int[][] mat) {

        for (int i = 0; i < mat[0].length; i++) {
            boolean bool = true;
            for (int j = 0; j < mat.length; j++) {
                int num = mat[j][i];
                int rightD = num % 10;
                while (num > 9)
                    num /= 10;
                int leftD = num % 10;
                if (rightD % leftD != 0) {
                    bool = false;
                    break;
                }
            }
            if (bool)
                return true;
        }
        return false;
    }

    private static String[] q9_c(String s1[]) {

        String[] str = new String[s1.length];
        int k = 0;
        for (int i = 0; i < s1.length; i++) {
            if (q9_b(s1[i]) == -1)
                str[k++] = s1[i];
        }
        String[] strTemp = new String[k];

        for (int i = 0; i < k; i++) {
            strTemp[i] = str[i];
        }

        return strTemp;
    }

    private static int q9_b(String s) {

        for (int i = s.length(); i > 1; i--) {
            if (q9(s, i))
                return i;
        }
        return -1;
    }

    private static boolean q9(String s, int k) {
        if (s.length() % k != 0)
            return false;
        int index = s.length() / k;
        for (int i = 0; i < s.length() - index; i++) {
            if (s.charAt(i) != s.charAt(index + i))
                return false;
        }
        return true;

    }

    public static String what(String s) {
        String str = "";
        int i;
        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) < 'A' || s.charAt(i) > 'Z') {
                str += s.charAt(i);
            } else {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    str += s.charAt(i);
                }
            }
        }
        str += s.charAt(i);
        return str;
    }

    private static int countNumber(int num, int[] arr) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                cnt++;
        }
        return cnt;
    }

    private static boolean q3WithFunc(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (countNumber(arr[i], arr) != 2)
                return false;
        }
        return true;
    }

    private static boolean q3(int[] arr) {

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    cnt++;
            }
            if (cnt != 2)
                return false;
            cnt = 0;
        }
        return true;
    }

    private static void q1() {

        int cnt = 0;
        int sum = 0;
        int sumDigit = 0;
        int num;
        while ((num = sc.nextInt()) != 500) {
            sum += num;
            cnt++;
            if (num % 2 != 0) {
                while (num != 0) {
                    sumDigit += num % 10;
                    num /= 10;
                }

                System.out.println("SumDigit -> " + sumDigit);
                sumDigit = 0;
            }
        }

        System.out.println("Avg -> " + (double) sum / ((cnt == 0) ? 1 : cnt));
    }
}
