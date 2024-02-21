package Day0221;

import java.util.HashMap;

public class NumericString {
    //    네오와 프로도가 숫자놀이를 하고 있습니다.
    //    네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
    //    다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
    //    1478 → "one4seveneight"
    //    234567 → "23four5six7"
    //    10203 → "1zerotwozero3"
    //    이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
    //    s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
    public int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> numbers = new HashMap<>();
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                for (int j = 1; j <= 5; j++) {
                    String word = s.substring(i, i + j);
                    if (numbers.containsKey(word)) {
                        number.append(numbers.get(word));
                        i += j - 1;
                        break;
                    }
                }
            }
        }
        answer = Integer.parseInt(number.toString());
        return answer;
    }

    public int solution1(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < numbers.length; i++) {
            s = s.replace(numbers[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        NumericString s = new NumericString();
        System.out.println(s.solution("one4seveneight"));
        System.out.println(s.solution("23four5six7"));
        System.out.println(s.solution("2three45sixseven"));
        System.out.println(s.solution("123"));

        System.out.println(s.solution1("one4seveneight"));
        System.out.println(s.solution1("23four5six7"));
        System.out.println(s.solution1("2three45sixseven"));
        System.out.println(s.solution1("123"));
    }
}
