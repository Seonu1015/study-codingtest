package Day0208;

import java.util.*;

public class FunctionDev {
    //    프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
    //    또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
    //    이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
    //    먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
    //    각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (remain % speeds[i] == 0 ? remain / speeds[i] : remain / speeds[i] + 1);
            queue.offer(days);
        }
        List<Integer> dev = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = 1;
            int prev = queue.poll();
            while (!queue.isEmpty() && prev >= queue.peek()) {
                count++;
                queue.poll();
            }
            dev.add(count);
        }
        System.out.println(dev);
        int[] answer = new int[dev.size()];
        for(int i=0; i<dev.size(); i++) {
            answer[i] = dev.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        FunctionDev dev = new FunctionDev();
        int[] p1 = {93, 30, 55};
        int[] s1 = {1, 30, 5};
        System.out.println(Arrays.toString(dev.solution(p1, s1)));
        int[] p2 = {95, 90, 99, 99, 80, 99};
        int[] s2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(dev.solution(p2, s2)));
    }
}
