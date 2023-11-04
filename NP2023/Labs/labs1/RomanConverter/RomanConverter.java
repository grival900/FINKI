package Labs.labs1.RomanConverter;

import java.util.Scanner;
import java.util.stream.IntStream;

class RomanConverterTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        IntStream.range(0, n)
                .forEach(x -> System.out.println(RomanConverter.toRoman(scanner.nextInt())));
        scanner.close();
    }
}


class RomanConverter {
    private static final int[] decimals = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    /**
     * Roman to decimal converter
     *
     * @param n number in decimal format
     * @return string representation of the number in Roman numeral
     */
    public static String toRoman(int n) {
        // your solution here
        StringBuilder str = new StringBuilder();
        while(n>0){
            int index=0;
            for(int i=0; i<decimals.length; i++){
                if(n>=decimals[i]){
                    index=i;
                }
            }
            str.append(letters[index]);
            n-=decimals[index];
        }
        return str.toString();
    }

}
