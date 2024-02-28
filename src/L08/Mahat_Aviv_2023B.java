package L08;

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
                    q2();
                    break;
                case 3:
                    int[] arr = {1, 2, 3, 4, 5, 6};
                    bool = q3_a(arr, 0, 4);
                    System.out.println(bool);
                    bool = q3_b(arr);
                    System.out.println(bool);

                    break;
                case 4:
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
                    String[] s = {"ABCCBA", "12A21", "a0X%11%X0a"};
                    for (int i = 0; i < s.length; i++) {
                        bool = q9_a(s[i]);
                        System.out.println("isPali -> " + bool);
                    }
                    String[] sL = {"f12d4A%B##C1^BAd?f01", "ABCCBA", "AbbCbbA"};
                    for (int i = 0; i < sL.length; i++) {
                        bool = q9_b(sL[i]);
                        System.out.println("isPaliL -> " + bool);
                    }

                    break;
                case 10:
                    break;
                case 11:

                    int[][] mat = new int[][]
                            {{1, 2, 3, 4},
                                    {5, 6, 7, 8},
                                    {9, 10, 11, 12}};

                    int col = rd.nextInt(mat[0].length);
                    int row = rd.nextInt(mat.length);

                    bool = q11_a(mat, row, col);
                    System.out.println(bool);

                    int maxLone = q11_b(mat);
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

    private static void q2() {
        String s;
        int count = 0;
        while ((s = sc.next()).length() <= 13) {
            boolean X = false;
            boolean Y = true;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'X')
                    X = true;
                else if (ch == 'Y')
                    Y = true;
            }
            if (X && !Y)
                count++;

        }
        System.out.println(count);
    }

    public static boolean q3_a(int[] arr, int ind, int value) {
        for (int i = ind + 1; i < arr.length; i++) {
            if (arr[i] == value)
                return true;
        }
        return false;
    }
    public static boolean q3_b(int[] arr ){
        for (int i = 0; i < arr.length; i++) {
            if (q3_a(arr,i,arr[i]))
                return false;
        }
        return true;
    }
    private static void q1() {
        int num;
        for (int i = 0; i < 100; i++) {
            num = sc.nextInt();
            if (num > 0) {
                if (Math.log(num) + 1 == 3) {
                    int sumDigit = 0;
                    while (num > 0) {
                        sumDigit += num % 10;
                        num /= 10;
                    }
                    System.out.println(sumDigit);
                }
            } else {
                i--;
            }
        }

    }

    private static boolean q9_b(String s) {
        int r = 0, l = s.length() - 1;
        while (r <= l) {
            if (!Character.isAlphabetic(s.charAt(r)))
                r++;
            else if (!Character.isAlphabetic(s.charAt(l)))
                l--;
            else if (s.charAt(r++) != s.charAt(l--))
                return false;
        }
        return true;
    }

    private static boolean q9_a(String s) {
        int r = 0, l = s.length() - 1;
        while (r <= l) {
            if (s.charAt(r++) != s.charAt(l--))
                return false;
        }
        return true;
    }

    // m = mat.length
    // n = mat[max(row)].length
    //O(n*m*O(q11_a)) ~ O(n*m*n) if n > m then O(n*n*n) = O(n^3)
    private static int q11_b(int[][] mat) {

        int max = -1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (q11_a(mat, i, j) && max < mat[i][j])
                    max = mat[i][j];
            }
        }

        return max;
    }

    // m = mat.length
    // n = mat[row].length
    // O(n+m) ~ if n > m then O(2n) = O(n)
    private static boolean q11_a(int[][] mat, int row, int col) {

        int loneItem = mat[row][col];
        for (int i = 0; i < mat[row].length; i++) {
            if (loneItem == mat[row][i] && i != col)
                return false;
        }

        for (int i = 0; i < mat.length; i++) {
            if (loneItem == mat[i][col] && i != row)
                return false;
        }

        return true;
    }


}
