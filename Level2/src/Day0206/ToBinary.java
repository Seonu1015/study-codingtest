package Day0206;

import java.util.Arrays;

public class ToBinary {
//    0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
//    x의 모든 0을 제거합니다.
//    x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
//    예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
//    0과 1로 이루어진 문자열 s가 매개변수로 주어집니다.
//    s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
//    이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
    public int[] solution(String s) {
        int[] answer = new int[2];
        int countToBinary = 0;
        int countZero = 0;

        while (!s.equals("1")) {
            int count = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') {
                    count++;
                }
            }
            countZero += count;
            s = toBinary(s.length()-count);
            countToBinary++;
        }
        answer[0] = countToBinary;
        answer[1] = countZero;
        return answer;
    }

    public String toBinary(int number) {
        StringBuilder binary = new StringBuilder();
        while(number>0) {
            binary.insert(0, number%2);
            number /= 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        ToBinary b = new ToBinary();
        System.out.println(Arrays.toString(b.solution("110010101001")));
    }

}
