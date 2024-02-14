package Day0214;

import java.util.HashMap;

public class Runner {
    //    수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    //    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    //    완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        for (String person : completion) {
            map.put(person, map.get(person) - 1);
        }
        for (String person : participant) {
            if (map.get(person) > 0) {
                return person;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Runner r = new Runner();
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(r.solution(participant1, completion1));
        System.out.println(r.solution(participant2, completion2));
        System.out.println(r.solution(participant3, completion3));
    }
}
