package DEBUG;

import java.util.ArrayList;

public class TableForDebug {

    public ArrayList<String[]> table;

    private int[] columnWidth;

    private final int numColumns;

    public int rowNumber = 0;


    public TableForDebug(String[] headers) {

        table = new ArrayList<>();

        numColumns = headers.length;

        columnWidth = new int[numColumns];

        for (int i = 0; i < headers.length; i++) {

            columnWidth[i] = headers[i].length();

        }

        table.add(headers);

    }


    public void addRow(int[] row) {

        if (row.length != numColumns) {

            throw new IllegalArgumentException("Row must have the same number of columns as the table");

        }

        String[] strings = new String[row.length];

        for (int i = 0; i < row.length; i++) {

            strings[i] = Integer.toString(row[i]);

        }

        for (int i = 0; i < row.length; i++) {

            if (strings[i].length() > columnWidth[i]) {

                columnWidth[i] = strings[i].length();

            }

        }

        addRow(strings);

    }


    public void addRow(Object[] row) {

        if (row.length != numColumns) {

            throw new IllegalArgumentException("Row must have the same number of columns as the table");

        }

        String[] strings = new String[row.length];

        for (int i = 0; i < row.length; i++) {

            strings[i] = row[i].toString();

        }

        for (int i = 0; i < row.length; i++) {

            if (strings[i].length() > columnWidth[i]) {

                columnWidth[i] = strings[i].length();

            }

        }

        addRow(strings);

    }


    public void addRow(String[] row) {

        if (row.length != numColumns) {

            throw new IllegalArgumentException("Row must have the same number of columns as the table");

        }

        rowNumber++;

        for (int i = 0; i < row.length; i++) {

            if (row[i].length() > columnWidth[i]) {

                columnWidth[i] = row[i].length();

            }

        }

        table.add(row);

    }


    public void printTable() {

        printStartLine();

        for (int i = 0; i < table.size(); i++) {

            printRow(table.get(i));

            if (i != table.size() - 1) {

                printSeparator();

            }

        }

        printEndLine();

    }


    private void printEndLine() {

        System.out.print("╚" + "═".repeat(columnWidth[0] + 2));

        for (int i = 1; i < numColumns; i++) {

            System.out.print("╩" + "═".repeat(columnWidth[i] + 2));

        }

        System.out.println("╝");

    }


    private void printRow(String[] strings) {

        for (int i = 0; i < numColumns; i++) {

            System.out.print("║ " + strings[i]);

            for (int j = strings[i].length(); j < columnWidth[i] + 1; j++) {

                System.out.print(" ");

            }

        }

        System.out.println("║");

    }


    private void printSeparator() {

        System.out.print("╠" + "═".repeat(columnWidth[0] + 2));

        for (int i = 1; i < numColumns; i++) {

            System.out.print("╬" + "═".repeat(columnWidth[i] + 2));

        }

        System.out.println("╣");

    }


    private void printStartLine() {

        System.out.print("╔" + "═".repeat(columnWidth[0] + 2));

        for (int i = 1; i < numColumns; i++) {

            System.out.print("╦" + "═".repeat(columnWidth[i] + 2));

        }

        System.out.println("╗");

    }


    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("╔");

        for (int i = 0; i < numColumns; i++) {

            sb.append("═".repeat(columnWidth[i] + 2));

            if (i != numColumns - 1) {

                sb.append("╦");

            }

        }

        sb.append("╗\n");

        for (String[] row : table) {

            sb.append("║ ");

            for (int i = 0; i < numColumns; i++) {

                sb.append(row[i]);

                for (int j = row[i].length(); j < columnWidth[i]; j++) {

                    sb.append(" ");

                }

                sb.append(" ║ ");

            }

            sb.append("\n");

            if (row != table.get(table.size() - 1)) {

                sb.append("╠");

                for (int i = 0; i < numColumns; i++) {

                    sb.append("═".repeat(columnWidth[i] + 2));

                    if (i != numColumns - 1) {

                        sb.append("╬");

                    }

                }

                sb.append("╣\n");

            }

        }

        sb.append("╚");

        for (int i = 0; i < numColumns; i++) {

            sb.append("═".repeat(columnWidth[i] + 2));

            if (i != numColumns - 1) {

                sb.append("╩");

            }

        }

        sb.append("╝");

        return sb.toString();

    }


    public void print() {

        System.out.println(this);

    }


}



