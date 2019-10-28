import java.util.*;

public class encryption{
    /*Вывод на экран текста в формате Unicode*/
    private static void unicodeList(char[] code) {
        arrayList2(code);
        System.out.println();
        System.out.printf("\nLength of line: ");
        int textLength = code.length;
        System.out.println(textLength);
        System.out.println();
    }

    /*Перевод текста в Unicode*/
    private static char[] textToUnicode(String text) {
        String codeString = "";
        for (char c : text.toCharArray()) {
            byte code = (byte) c;
            codeString += String.format("%04x", code);
        }
        char[] code = codeString.toCharArray();
        return code;
    }

    /*Создание названия для столбцов и колонн*/
    private static char[][] nameOfLinesColumns(char[][] a) {
        int n, m;
        char letters = 65;
        int length = a.length;
        int i = 1;
        while (letters < 91 && i < length) {
            a[0][i] = letters;
            i++;
            letters++;
        }

        letters = 97;
        while (letters < 123 && i < length) {
            a[0][i] = letters;
            i++;
            letters++;
        }

        letters = 65;
        i = 1;
        while (letters < 91 && i < length && a[i][1] != 0x0000) {
            a[i][0] = letters;
            i++;
            letters++;
        }

        letters = 97;
        while (letters < 123 && i < length && a[i][1] != 0x0000) {
            a[i][0] = letters;
            i++;
            letters++;

        }
        return a;
    }

    /*Рассчет размера массива*/
    private static int arrayLength(char[] codeString) {
        int textLength = codeString.length;
        double arrayLengthDouble = Math.sqrt(textLength);
        double arrayLengthDoubleRest = Math.sqrt(textLength) % 1;
        if (arrayLengthDoubleRest > 0) {
            arrayLengthDouble = Math.sqrt(textLength) + 1;
        }
        int arrayLength = (int) Math.round(arrayLengthDouble) + 1;
        return arrayLength;
    }

    /*Заполнение массива*/
    private static char[][] fillingOfArray(char[][] array, char[] code) {
        int textLength = code.length;
        int arrayLength = array.length;
        int q = 0;
        for (int i = 1; i < arrayLength; i++) {
            if (q == textLength) {
                continue;
            }
            for (int j = 1; j < arrayLength; j++) {
                if (q == textLength) {
                    array[i][j] = '0';
                    continue;
                }
                array[i][j] = code[q];
                q++;
            }
        }

        nameOfLinesColumns(array);
        return array;
    }

    /*Вывод на экран двумерного массива*/
    private static void arrayList(char[][] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(a[i][j]/* + " "*/);
            }
            System.out.println();
        }
        //System.out.println();
    }

    /*Вывод на экран одномерного массива*/
    private static void arrayList2(char[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            System.out.print(a[i]);
        }
    }

    /*Функция создания произвольного числа в промежутке*/
    private static int random(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);
        i += min;
        return i;
    }

    /*Изменение расположения строк в массиве*/
    private static char[][] changeLines(char[][] a, int n, int m) {
        n -= 1;
        m -= 1;
        char t;
        int length = a.length;
        for (int j = 0; j < length; j++) {
            t = a[m][j];
            a[m][j] = a[n][j];
            a[n][j] = t;
        }
        return a;
    }

    /*Изменение расположения столбцов в массиве*/
    private static char[][] changeColumns(char[][] a, int n, int m) {
        n -= 1;
        m -= 1;
        char t;
        int length = a.length;
        for (int j = 0; j < length; j++) {
            t = a[j][n];
            a[j][n] = a[j][m];
            a[j][m] = t;
        }
        return a;
    }

    /*Ключ замены*/
    private static char[][] keyOfChanges(char[][] a) {
        byte[] b = new byte[a[1].length];
        //for (int i = 1; i <

        return a;
    }

    /*процесс шифрования массива*/
    private static char[][] secureProcess(char[][] a) {

        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);                                    //ввод текста
        System.out.print("Input your text: ");
        String text = in.nextLine();
        in.close();
        System.out.println();
        char[] code = textToUnicode(text);
        unicodeList(code);
        char[][] myArray = new char[arrayLength(code)][arrayLength(code)];
        fillingOfArray(myArray, code);
        arrayList(myArray);
    }
}
