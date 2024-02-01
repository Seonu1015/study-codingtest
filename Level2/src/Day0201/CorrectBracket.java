package Day0201;

import java.util.Stack;

public class CorrectBracket {
    boolean solution1(String s) {
        boolean answer = true;

        int count = 0;

        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            }
            if(s.charAt(i) == ')') {
                count--;
            }
            if(count < 0) {
                answer = false;
                break;
            }
        }
        if(count != 0) {
            answer = false;
        }
        return answer;
    }

    // 개선 - 스택 사용하기
    boolean solution2(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    answer = false;
                } else {
                    Character top = stack.pop();
                    if(top != '(') {
                        answer = false;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }

    // 개선 - 불필요한 answer, else 제거,
    boolean solution3(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') { // 합쳐버림
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        CorrectBracket b = new CorrectBracket();
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println("s1==============");

        System.out.println(b.solution1(s1));
        System.out.println(b.solution1(s2));
        System.out.println(b.solution1(s3));
        System.out.println(b.solution1(s4));

        System.out.println("s2==============");

        System.out.println(b.solution2(s1));
        System.out.println(b.solution2(s2));
        System.out.println(b.solution2(s3));
        System.out.println(b.solution2(s4));

        System.out.println("s3==============");

        System.out.println(b.solution3(s1));
        System.out.println(b.solution3(s2));
        System.out.println(b.solution3(s3));
        System.out.println(b.solution3(s4));
    }
}
