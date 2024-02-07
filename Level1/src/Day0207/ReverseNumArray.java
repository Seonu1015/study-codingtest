package Day0207;

import java.util.Arrays;

public class ReverseNumArray {
//    자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
//    예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
    public int[] solution(long n) {
        String nString = String.valueOf(n);
        int[] answer = new int[nString.length()];

        int index = 0;
        while (n > 0) {
            answer[index] = (int) (n % 10);
            n /= 10;
            index++;
        }
        return answer;
    }

    public static void main(String[] args) {
        ReverseNumArray a = new ReverseNumArray();
        System.out.println(Arrays.toString(a.solution(1211133)));
    }
}
