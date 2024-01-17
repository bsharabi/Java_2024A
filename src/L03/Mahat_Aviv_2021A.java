package L03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2021A {

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
                    String[] colors = {"Red, Yellow", "Green", "Blue"};
                    Box[] boxes = new Box[4];
                    for (int i = 0; i < 4; i++) {
                        boxes[i] = new Box(colors[rd.nextInt(3)], rd.nextInt(20) + 1, rd.nextInt(20) + 1, rd.nextInt(20) + 1);
                    }
                    System.out.println(Arrays.toString(boxes));
                    Box box = new Box("Red");
                    System.out.println(box);

                    String color = Box.smallBox(boxes);
                    System.out.println(color);
                    break;
                case 3:

                    break;
                case 4:
                    bool = q4(new int[]{4, 131, 13, 0, 7, 3, 1,});
                    break;
                case 5:
                    break;
                case 6:
                    String str = "Lionel.Messi";
                    bool = q6(str);
                    System.out.println(bool);
                    str = "www.sport5.il";
                    bool = q6(str);
                    System.out.println(bool);
                    str = "ABC";
                    bool = q6(str);
                    System.out.println(bool);
                    str = "efG.";
                    bool = q6(str);
                    System.out.println(bool);
                    str = ".ab.Cd";
                    bool = q6(str);
                    System.out.println(bool);
                    str = " abc..def ";
                    bool = q6(str);
                    System.out.println(bool);


                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    int number = 12345;
                    int count = q10_a(number);
                    int deg = q10_b(new int[]{123, 456, 987, 56452, 0, 4562, 5486, 1254});
                    bool = q10_c(new int[]{123, 456, 987, 56452, 0, 4562, 5486, 1254});
                    bool = q10_c(new int[]{1, 0,});


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

    private static boolean q10_c(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (q10_a(arr[i]) != i)
                return false;
        }
        return true;
    }

    // נגדיר את m להיות אורך המערך
    // ואז הסיבוכיות היא O(m*n)
    // בכל איטרציה של הלולאה אנחנו מבצעים n פעולות של סעיף א'
    private static int q10_b(int[] arr) {
        int maxDeg = q10_a(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int tempDeg = q10_a(arr[i]);
            if (tempDeg > maxDeg)
                maxDeg = tempDeg;
        }
        return maxDeg;
    }

    // נגדיר את n להיות כמות הספרות במספר ואז O(n)
    // הלולאה מבצעת בדיוק n איטרציות
    private static int q10_a(int number) {
        int count = 0;
        long n = 4564564654l;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 0)
                count++;
            number /= 10;
        }
        return count;
    }


    private static boolean q6(String str) {
        int size = str.length();

        if (str.charAt(size - 1) == '.' || str.charAt(0) == '.')
            return false;

        boolean bool = false;

        for (int i = 1; i < size - 1; i++) {

            if (str.charAt(i) == '.') {
                bool = true;
                if (str.charAt(i + 1) == '.')
                    return false;
            }
        }

        return bool;
    }

    private static boolean q4(int[] arr) {

        if (arr == null)
            return false;
        int size = arr.length;
        int mid = size / 2;
        if (size % 2 == 0)
            return false;
        for (int i = 0; i < mid; i++) {
            if (arr[i] < 0 || arr[i] > 9)
                return false;
        }

        if (arr[mid] != 0)
            return false;


        for (int i = mid + 1; i < size; i++) {
            if (arr[i] >= 0 && arr[i] < 10)
                return false;
        }

        return true;
    }

    private static void q1() {
        int num;
        int countEven = 0, sumOdd = 0;
        int sumDigit = 0;
        for (int i = 0; i < 40; i++) {
            while ((num = sc.nextInt()) < 0) {
                System.out.println("Invalid Argument");
            }
            if (num % 2 == 0)
                countEven++;
            else
                sumOdd += num;
            if (num > 99 && num < 1000) {
                while (num != 0) {
                    sumDigit += num % 10;
                    num /= 10;
                }
            }
            System.out.println(sumDigit);
            sumDigit = 0;

        }
        System.out.println(countEven);
        System.out.println(sumOdd);
    }

    static class Box {

        private String color;
        private int length;
        private int width;
        private int height;


        public Box(String color, int length, int width, int height) {
            this.color = color;
            this.length = length;
            this.width = width;
            this.height = height;
        }

        public Box(String color) {
            this.color = color;
            this.length = 10;
            this.width = 10;
            this.height = 10;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int calacVolume() {
            return height * width * length;
        }

        public static String smallBox(Box[] arr) {
            if (arr == null)
                return "null";
            Box boxMin = arr[0];
            int boxVMin = boxMin.calacVolume();


            for (int i = 1; i < arr.length; i++) {
                Box temp = arr[i];
                int tempMin = temp.calacVolume();
                if (boxVMin > tempMin) {
                    boxVMin = tempMin;
                    boxMin = temp;
                }
            }
            System.out.println(boxMin);
            return boxMin.getColor();

        }

        @Override
        public String toString() {
            return "Box{" +
                    "color='" + color + '\'' +
                    ", length=" + length +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
}
