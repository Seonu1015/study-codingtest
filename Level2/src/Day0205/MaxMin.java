package Day0205;

import java.util.Arrays;

public class MaxMin {
    //    문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
    //    str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
    //    예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
    public String solution(String s) {
        String answer = "";

        // 문자열을 숫자 배열로 변환
        String[] numberString = s.split(" ");
        int[] numbers = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }

        // 최댓값 최솟값 구하기
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return min + " " + max;
    }

    public String solution1(String s) {
        String answer = "";
        String[] numberString = s.split(" ");

        // 최댓값 최솟값 구하기
        int min = Integer.parseInt(numberString[0]);
        int max = Integer.parseInt(numberString[0]);
        for (int i = 1; i < numberString.length; i++) {
            int n = Integer.parseInt(numberString[i]);
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        MaxMin mm = new MaxMin();
        System.out.println(mm.solution("1 2 3 4"));
        System.out.println(mm.solution("-1 -2 -3 -4"));

        System.out.println(mm.solution1("1 2 3 4"));
        System.out.println(mm.solution1("-1 -2 -3 -4"));
    }
}
