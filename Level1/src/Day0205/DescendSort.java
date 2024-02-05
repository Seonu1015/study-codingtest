package Day0205;

import java.util.Arrays;

public class DescendSort {
//    함수 solution은 정수 n을 매개변수로 입력받습니다.
//    n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
//    예를들어 n이 118372면 873211을 리턴하면 됩니다.
    public long solution(long n) {
        long answer = 0;
        String num = "" + n;
        int[] numbers = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            numbers[i] = num.charAt(i) - '0';
        }
//        System.out.println(Arrays.toString(numbers));

        // 버블 정렬 - 내림차순
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if(numbers[j] < numbers[j+1]) {
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
//        System.out.println(Arrays.toString(numbers));

        // 정렬한 숫자를 문자열로
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numbers.length; i++) {
            sb.append(numbers[i]);
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }

    public static void main(String[] args) {
        DescendSort n = new DescendSort();
        System.out.println(n.solution(285959846));
    }
}
