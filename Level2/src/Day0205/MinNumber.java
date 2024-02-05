package Day0205;

import java.util.ArrayList;
import java.util.Arrays;

public class MinNumber {
    //    길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
    //    배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며,
    //    두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
    //    (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
    //    예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면
    //    A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
    //    A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
    //    A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
    //    즉, 이 경우가 최소가 되므로 29를 return 합니다.
    //    배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
    public int solution1(int[] A, int[] B) {
        int answer = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                int temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
            }
        }
//        System.out.println(Arrays.toString(A));

        for (int i = 0; i < B.length - 1; i++) {
            if (B[i] < B[i + 1]) {
                int temp = B[i + 1];
                B[i + 1] = B[i];
                B[i] = temp;
            }
        }
//        System.out.println(Arrays.toString(B));

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }
        return answer;
    }

    // 위 방법은 시간 초과....
    // 버블 정렬(Bubble Sort)의 개념을 이용하여 배열을 정렬하려고 시도했지만, 이 방법은 시간 복잡도가 O(n^2)으로 비효율적
    public int solution2(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }
        return answer;
    }

    // sort 안쓰고 하고 싶어서 퀵 정렬로 다시 풀어봄
    public int solution3(int[] A, int[] B) {
        int answer = 0;
        quickSort(A, 0, A.length - 1);
        quickSort(B, 0, B.length - 1);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            int pivotIndex = i + 1;

//            System.out.println(Arrays.toString(arr) + ", pivotIndex = " + pivotIndex);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        MinNumber n = new MinNumber();
//        System.out.println(n.solution1(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
//        System.out.println(n.solution2(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
//        System.out.println(n.solution3(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(n.solution3(new int[]{2, 5, 7, 3, 5, 6, 8, 1}, new int[]{7, 5, 2, 4, 8, 9, 5, 6}));
    }
}
