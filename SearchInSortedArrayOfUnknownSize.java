package S30_Codes.Binary_Search_1;

// Time Complexity : O(log n) // n = length of the secret array
// Space Complexity : O(1)

/*
This is ArrayReader's API interface/
You should not implement it, or speculate about its implementation
interface ArrayReader {
    public int get(int index) {}
}
*/

/*
Constraints :
* 1 <= secret.length <= 10^4
* -10^4 <= secret[i], target <= 10^4
secret is sorted in a strictly increasing order
*/

import java.util.Arrays;

public class SearchInSortedArrayOfUnknownSize {
    private static int search(int[] arr, int target){
        int start = 0;
        int end = target - arr[0];
//        int end = 1;
//        while (target > arr[end]){
//            start = end+1;
//            end = end*2;
//        }

        while (start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static void main(String args[]){
        int arr[] = new int[1000_000];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = -1;
        arr[1] = 0;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 9;
        arr[5] = 12;

        int target = 55;

        System.out.println(search(arr, target));
    }
}

