/*
Search in Infinite sorted array:

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for,
return the index of the number in the array. Accessing an element out of bounds throws exception.
If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
*/

// Time Complexity : O(log k), k -> idx of target element
//          2 search - one where search space is doubled and other halved in each iteration - binary search
//          i.e 2 O(logk) -> O(log k)
// Space Complexity : O(1) - no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. First search to decide the low and high boundaries by doubling the high index in each iteration
//      until we reach out of bounds exception
// 2. Another binary search to find target within low and high index that we found above
// 3. Assuming if arr value is Integer.MAX_VALUE, it is out of bounds


public class SearchUnknownSizeArr {
    private static int search(int[] arr, int target) {
        int l=0, h=1;

        // binary search to find the low and high index
        while(arr[h] != Integer.MAX_VALUE && target > arr[h]){
            l = h;
            h *= 2;
        }

        //binary search to find the index of target
        while(l <= h) {
            int mid = l + (h-l)/2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] == Integer.MAX_VALUE || arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int h = Integer.MAX_VALUE;
        System.out.println(search(new int[]{2, 10, 20, 40, h, h, h, h, h}, 2)); //0
        System.out.println(search(new int[]{2, 10, 20, 40, h, h, h, h, h}, 10));//1
        System.out.println(search(new int[]{2, 10, 20, 40, h, h, h, h, h}, 20)); //2
        System.out.println(search(new int[]{2, 10, 20, 40, h, h, h, h, h}, 40)); //3
        System.out.println(search(new int[]{2, 10, 20, 40, h, h, h, h, h}, 70)); //-1
        System.out.println(search(new int[]{2, 10, 20, 40, h, h, h, h, h}, -10)); //-1
    }
}
