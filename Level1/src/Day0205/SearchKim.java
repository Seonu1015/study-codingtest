package Day0205;

public class SearchKim {
    public String solution(String[] seoul) {
        int x = 0;
        for (int i=0; i<seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                x = i;
            }
        }
        return "김서방은 " + x + "에 있다";
    }

    public static void main(String[] args) {
        SearchKim k = new SearchKim();
        System.out.println(k.solution(new String[] {"Jane", "Kim"}));
        System.out.println(k.solution(new String[] {"Queen", "Tod","Kim"}));
    }
}
