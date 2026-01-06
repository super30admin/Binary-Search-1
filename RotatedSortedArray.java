//Time Complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*Approach:
Used binary search for O(log n)
In rotated sorted arrays either one of the side is sorted.
we find which side is sorted and then check if the target exists in that range, and we keep updating the low and high indexes
we keep doing this until we find the exact range or find mid element which is equal to target.
else we return element not found
 */

import java.util.Scanner;

public class RotatedSortedArray {

    public static void main(String args[]) {

//        Reading the input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();


        int low = 0;
        int high = n-1;
        int idx = -1;
        while (low<=high) {
            int mid = low + (high - low)/2; // better to calculate mid this way to avoid integer overflow for large index numbers
            if (arr[mid] == target) {
                 idx = mid;
                 break;
            } else if (arr[low]<=arr[mid]){ //left sorted
                // if left most element is less than mid ele, then it is a left sorted array
                //check if the target exists in that range and accordingly update high or low
                if (target>=arr[low] && target<arr[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else{ //right sorted
                if (target>arr[mid] && target<=arr[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        if (idx== -1){
            System.out.println("ele doesnt exist"); // if index not found
        } else {
            System.out.println(idx);
        }
    }
}

/*sample input
7 //size of array
4 //array elements
5
6
7
0
1
2
0 //target element
 */
