package Day0205;

public class CenterStr {
//    단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
    public String solution(String s) {
        String answer = "";
        int n = s.length()/2;
        if (s.length()%2==0) {
            answer = s.substring(n-1, n+1);
        } else {
            answer = s.substring(n, n+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        CenterStr cs = new CenterStr();
        System.out.println(cs.solution("abcde"));
        System.out.println(cs.solution("qwer"));
        System.out.println(cs.solution("aabbccddee"));
    }
}
