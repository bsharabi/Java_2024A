package L10;

import DEBUG.TableForDebug;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Mahat_Summer_2022B {

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
    static TableForDebug table;

    public static void main(String[] args) {
        int ans;
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            System.out.println("------------------------------------------");
            switch (num) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    int size = rd.nextInt(10);
                    int[] arr = new int[size];
                    for (int i = 0; i < size; i++)
                        arr[i] = rd.nextInt(80);
                    System.out.println(Arrays.toString(arr));
                    bool = q3_a(arr, 5);
                    System.out.println(bool);
                    int count = q3_b(arr);
                    //[1,2,1,2,1,2,1,2,1,1,1,1,2,1,2,1,2]
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    what(18024, 3);
                    where(new int[]{1234, 5671, 321, 8191, 2402});
                    break;
                case 7:
                    break;
                case 8:
                    why(new int[]{6, 6, 2, 7, 7, 7, 9, 7, 7, 3});
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    int[][] mat =
                            {
                                    new int[]{1, 2, 3, 4, 5, 6, 7},
                                    new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 7, 5, 6},
                                    new int[]{11, 2, 3, 4, 5},
                            };
                    break;
                case -1:
                    return;

            }
        }
    }

    // n = mat.length
    // m =  arr.length
    // n + m*n =n(m+1) ~ n*m if n=m then O(n^2) ~ O(n*m)
    public static boolean q14_b(int[][] mat, int[] arr) {

        for (int i = 0; i < mat.length; i++)
            if (mat[i].length != arr.length)
                return false;

        for (int i = 0; i < arr.length; i++)
            if (q14_a(mat, i, arr[i]) != i)
                return false;

        return true;
    }

    // n = mat.length
    // O(n)
    public static int q14_a(int[][] mat, int col, int value) {
        int cntVal = 0;
        for (int i = 0; i < mat.length; i++)
            if (mat[i][col] == value)
                cntVal++;
        return cntVal;
    }


    public static boolean q3_a(int[] arr, int index) {
        if (arr == null || arr.length == 0 || index == 0 || arr.length - 1 == index)
            return false;

        return arr[index] > arr[index - 1] && arr[index] > arr[index + 1];
    }

    public static int q3_b(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int count = 0;
        boolean bool;
        for (int i = 1; i < arr.length - 1; i = ((bool) ? i + 2 : i + 1))
            if ((bool = q3_a(arr, i)))
                count++;

        return count;
    }


    public static int[] why(int[] arr) {

        int[] temp = new int[arr.length];

        temp[0] = arr[0];

        int count = 1;

        TableForDebug table = new TableForDebug(new String[]{"i", "arr[i]", "arr[i-1]", "temp[count]", "count"});

        for (int i = 1; i < arr.length; i++) {

            table.addRow(new Object[]{i, arr[i], arr[i - 1], temp[count], count});

            if (arr[i] != arr[i - 1]) {

                temp[count] = arr[i];

                table.addRow(new Object[]{i, arr[i], arr[i - 1], temp[count], count});

                count++;

            }

        }

        int[] res = new int[count];

        for (int i = 0; i < count; i++) {

            res[i] = temp[i];

        }

        table.print();

        return res;

    }


    public static boolean what(int num, int dig) {
        table = new TableForDebug(new String[]{"x", "s", "num", "digit"});
        int s = 1;
        int x = 0;
        table.addRow(new Object[]{x, s, num, dig});
        while (num > 0) {
            x = num % 10;
            s = s * (x - dig);
            num = num / 10;
            table.addRow(new Object[]{x, s, num, dig});
        }
        table.print();
        return s == 0;
    }

    public static boolean where(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            boolean isExist = what(arr[i] / 10, arr[i] % 10);
            if (isExist) return false;
        }
        return true;
    }

    static class Country {
        private String name;
        private int infected;
        private int recovered;
        private int dead;

        public Country(String name, int infected, int recovered, int dead) {
            this.name = name;
            this.infected = infected;
            this.recovered = recovered;
            this.dead = dead;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getInfected() {
            return infected;
        }

        public void setInfected(int infected) {
            this.infected = infected;
        }

        public int getRecovered() {
            return recovered;
        }

        public void setRecovered(int recovered) {
            this.recovered = recovered;
        }

        public int getDead() {
            return dead;
        }

        public void setDead(int dead) {
            this.dead = dead;
        }
    }

    static class Status {
        private int count1;
        private int count2;
        private String names;

        public Status() {
            this.count1 = 0;
            this.count2 = 0;
            this.names = "";
        }

        public int getCount1() {
            return count1;
        }

        public void setCount1(int count1) {
            this.count1 = count1;
        }

        public int getCount2() {
            return count2;
        }

        public void setCount2(int count2) {
            this.count2 = count2;
        }

        public String getNames() {
            return names;
        }

        public void setNames(String names) {
            this.names = names;
        }

        public static Status worldStatus(Country[] arr) {
            Status s = new Status();
            int count1 = 0;
            int count2 = 0;
            String names = "";

            for (int i = 0; i < arr.length; i++) {
                Country country = arr[i];
                count1 += (country.getInfected() == 0) ? 1 : 0;
                count2 += (country.getRecovered() > country.getDead()) ? 1 : 0;
                names += (((double) country.getInfected() / country.getRecovered()) > 0.5) ? " " + country.name : "";
            }

            s.setCount1(count1);
            s.setCount2(count2);
            s.setNames(names);

            return s;
        }
    }


    static class SportClub {
        private String name;
        private String sportName;
        private String city;
        private int countOfPlayer;
        private int countOfCoach;

        public SportClub(String name, String sportName, String city, int countOfPlayer, int countOfCoach) {
            this.name = name;
            this.sportName = sportName;
            this.city = city;
            this.countOfPlayer = countOfPlayer;
            this.countOfCoach = countOfCoach;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSportName() {
            return sportName;
        }

        public void setSportName(String sportName) {
            this.sportName = sportName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCountOfPlayer() {
            return countOfPlayer;
        }

        public void setCountOfPlayer(int countOfPlayer) {
            this.countOfPlayer = countOfPlayer;
        }

        public int getCountOfCoach() {
            return countOfCoach;
        }

        public void setCountOfCoach(int countOfCoach) {
            this.countOfCoach = countOfCoach;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SportClub sportClub = (SportClub) o;
            return Objects.equals(name, sportClub.name) &&
                    Objects.equals(sportName, sportClub.sportName) &&
                    Objects.equals(city, sportClub.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, sportName, city, countOfPlayer, countOfCoach);
        }
    }

    static class SportUnion {
        private String unionName;
        private SportClub[] unionData;
        private int numberUnion;

        public SportUnion(String unionName) {
            this.unionName = unionName;
            this.unionData = new SportClub[100];
            this.numberUnion = 0;
        }

        public boolean add(SportClub sportClub) {

            if (numberUnion == 100)
                return false;

            for (int i = 0; i < numberUnion; i++) {
//                if (unionData[i].getName().equals(sportClub.getName()) && unionData[i].getCity().equals(sportClub.getCity()) && unionData[i].getSportName().equals(sportClub.getSportName()))
//                    return false;

                if (unionData[i].equals(sportClub))
                    return false;
            }

            unionData[numberUnion] = sportClub;
            numberUnion++;

            return true;

        }

        public String maxCoach() {
            if (numberUnion == 0)
                return "";

            SportClub maxCO = unionData[0];
            for (int i = 0; i <numberUnion; i++) {
                if(unionData[i].getCountOfCoach()>maxCO.getCountOfCoach())
                    maxCO=unionData[i];
            }
            return maxCO.getName();
        }


        public void SportUnionE(SportUnion[] sportUnions){

            for (int i = 0; i < sportUnions.length; i++) {
                SportUnion su = sportUnions[i];
                int count=0;
                for (int j = 0; j <su.getUnionData().length ; j++) {
                    if(su.getUnionData()[i].getCountOfPlayer()>=50)
                        count++;
                }
                if(count>=5)
                    System.out.println(su.getUnionName());
            }

        }
        public String getUnionName() {
            return unionName;
        }

        public void setUnionName(String unionName) {
            this.unionName = unionName;
        }

        public SportClub[] getUnionData() {
            return unionData;
        }

        public void setUnionData(SportClub[] unionData) {
            this.unionData = unionData;
        }

        public int getNumberUnion() {
            return numberUnion;
        }

        public void setNumberUnion(int numberUnion) {
            this.numberUnion = numberUnion;
        }
    }
}



