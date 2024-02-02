package Day0202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthNumber {
    //배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
    //예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
    //array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
    //1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
    //2에서 나온 배열의 3번째 숫자는 5입니다.
    //배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
    // commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    public int[] solution1(int[] array, int[][] commands) {
        int[] res = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = command[0] - 1; j < command[1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            int k = command[2];
            res[i] += list.get(k - 1);
        }
        return res;
    }

    // 개선 - sort를 사용하지 않고 퀵 정렬을 사용해서 풀이
    public int[] solution2(int[] array, int[][] commands) {
        int[] res = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = command[0] - 1; j < command[1]; j++) {
                list.add(array[j]);
            }
            list = sortList(list);
//            System.out.println("정렬된 리스트" + list);
            int k = command[2];
//            System.out.println(k);
            res[i] += list.get(k-1);
        }
        return res;
    }

    public static ArrayList<Integer> sortList(ArrayList<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        int pivot = arr.get(arr.size() / 2);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> middle = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int n : arr) {
            if (n < pivot) {
                left.add(n);
            } else if (n == pivot) {
                middle.add(n);
            } else {
                right.add(n);
            }
        }

        left = sortList(left);
        right = sortList(right);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }

    public static void main(String[] args) {
        KthNumber n = new KthNumber();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(n.solution1(arr, commands)));
        System.out.println(Arrays.toString(n.solution2(arr, commands)));
    }
}
