package Day2013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumTwo {
    //    정수 배열 numbers가 주어집니다.
    //    numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
    //    배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
//                System.out.println(sum);
                if (nums.contains(sum)) {
                    continue;
                }
                nums.add(sum);
            }
        }
        System.out.println(nums);
        return answer;
    }
    public static void main(String[] args) {
        SumTwo s = new SumTwo();
        System.out.println(Arrays.toString(s.solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(s.solution(new int[]{5, 0, 2, 7})));
    }
}
