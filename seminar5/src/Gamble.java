import java.util.Arrays;
import java.util.Random;

public class Gamble {

    public static void main(String[] args) {
        byte[][] array = new byte[3][3];
        fillArray(array);
        printArray(array);
        int field = copyOfField(array);
        byte [][] copyOfField = new byte[3][3];
        returnField(copyOfField, field);
        System.out.println();
        printArray(copyOfField);
    }


    public static void fillArray(byte[][] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (byte) rand.nextInt(0, 4);
            }
        }
    }

    public static void printArray(byte[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int copyOfField(byte[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                sb.append(array[i][j]);
            }
        }
        if (sb.toString().startsWith("0")) {
            String result = sb.toString().replaceFirst("0", "-");
            return Integer.parseInt(result);
        }
        return Integer.parseInt(sb.toString());
    }


    public static void returnField(byte[][] array, int field) {
        String number = String.valueOf(field);
        int target = 0;
        if (number.charAt(target) == '-') {
            number = number.replaceFirst("-", "0");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Byte.parseByte(String.valueOf(number.charAt(target)));
                target++;
            }
        }
    }
}
