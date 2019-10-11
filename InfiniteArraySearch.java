/*
Author: Akhilesh Borgaonkar
Problem: Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
    Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence.
    If it isn’t present, return -1.
Approach: Using binary search to find the target in a sub array whose bounds are determined in chunks. The lower bound starts with 0th
    index and increments as high. The higher bound starts with 1st index in the array and increments as twice of its current value.
    The sub array is then subject to normal binary search with newer calculated bounds.
Time Complexity: O(logn) where n is number of elements in the array.
Space complexity: O(1) constant
Verified on IDE.
*/

public class InfiniteLength {

    private static int binarySearch(int low, int high, int[] arr, int target){  //standard binary search

        while(low<=high){                   //not letting low cross high ptr
            int mid = low + (high-low)/2;   //calculating mid
            if(target == arr[mid])          //target found and return
                return mid;
            if(target > arr[mid])
                low = mid + 1;
            if(target < arr[mid])
                high = mid - 1;
        }
        return -1;
    }

    private static int modifiedBinarySearch(int[] arr, int target){
        int low = 0;
        int high = 1;
        int tmp = arr[0];

        while (target > tmp){       //checking if the target is in the current sub array
            low = high;             //if not in subarray then low of next sub array will be high of previous
            high = 2*high;          //and we look until twice the index of previous high ptr
            tmp = arr[high];
        }
        return binarySearch(low, high, arr, target);
    }

    public static void main(String[] args) {

        int[] arr = {1,2,4,5,6,7,8,9,10,13,14,15};
        int target = 7;
        System.out.println(modifiedBinarySearch(arr, target));
    }
}