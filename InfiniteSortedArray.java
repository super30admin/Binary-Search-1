/*
Search in Infinite sorted array:

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. 
Accessing an element out of bounds throws exception. 
If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

// K - position where element is present in array
// Time Complexity : O(log k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
This code doesnt work when the target is greater than the largest elemet in the array

// Your code here along with comments explaining your approach
// start with low = 0 and high = 1, keep doubling high to increase the search space, and change low to old high
*/

public class InfiniteSortedArray {
    public static void main(String args[]) {
        int a[] = new int[] {1, 2, 3, 5, 6, 7, 8};
        // System.out.println(findPosition(a, 8));
        System.out.println(findPosition(a, 4));
        // System.out.println(findPosition(a, -12));
    }

    public static int findPosition(int a[], int target) {
        int low = 0;
        int high = 1;
        int key = a[low];

        while (key < target) {
            System.out.println("low: "+ low + " High: "+ + high);
            low = high;
            if (high * 2 <= a.length-1) {
                high = high * 2;
            } else {
                high = a.length-1;
            }                
            key = a[high];
        }
        // System.out.println("low: "+ low + " High: "+ + high);
        return binarySearch(a, low, high, target);
    }

    public static int binarySearch(int a[], int low, int high, int target) {
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low)/2;

            if (a[mid] == target) {
                return mid;
            }
            if (target < a[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }
}