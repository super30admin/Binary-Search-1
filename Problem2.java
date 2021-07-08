/* Exercise 2:
Search in Infinite sorted array: 

Given a sorted array of unknown length and a number to search for, 
return the index of the number in the array. Accessing an element 
out of bounds throws exception. If the number occurs multiple times, 
return the index of any occurrence. If it isn’t present, return -1.
*/

// Time Complexity : 0(log N)  (in total its O(2logN)): O(logN) for binary search and O(logN) for multiplier)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes(on geeksforgeeks IDE)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// first start with Linear search. As this is an infinite array, so we don't know the length of array
// and we don't know the end index. Linear Search isn't possible here because:
//1) if we try while loop, and element is not present, it will not break and keep iterating further
//2) if element is present, then we can find the target
// second, start with binary search. Consider taking two pointers: low(0) and high(1)
// increment low as high and high as 2*high
//we are considering 2(As multiplier) because binary search is a factor of 2 and it will give us best results in tradeoff
//in short, we keep tending towards the target by incrementing low and high indexes
// and once we found out target lies between low and high interval, we apply binary search
//note: in while loop for binary search, (low<=high) is the terminating condition as there will be a condition when low and high indexes coincide and we break the loop

public class InfiniteArray{
    public static void main(String args[]){
        int[] arr = {3,5,7,10,11,15,16,17,18};
        int target = 11;
        int idx = modifiedBinarySearch(arr, target);
        System.out.println("Index: "+idx);
    }

    public static int modifiedBinarySearch(int[] arr, int target){
        int low = 0;
        int high = 1;
        //keep incrementing low as high and high as 2*high until target is greater than high index value
        while(target > arr[high]){
            low = high;
            high = 2*high;
        }
        //when target lies between low and high indexes
        //binary search
        while(low <= high){
            //helps with Integer overflow problem
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(target < arr[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}