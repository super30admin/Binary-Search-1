import java.util.*;
import java.lang.*;
import java.io.*;

class SearchRotatedSortedArray  {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1, mid = -1;
        while(lo <= hi) {
            mid = lo + (hi-lo)/2;
            
            // if target is found at mid then just return it;
            if(nums[mid] == target) return mid;

            // if lower half is sorted
            if(nums[lo] <= nums[mid]) {
                if(nums[lo] <= target && target < nums[mid]) {
                    // if target is in the range of upper half then exclude the lower half
                    hi = mid-1;
                } else {
                    // if target is not found in the upper half the exclude it
                    lo = mid+1;
                }
            } else { // else when upper half is sorted
                if(nums[mid] <= target && target <= nums[hi]) {
                    // if target is in the range of the upper half the remove the lower half
                    lo = mid+1;
                } else {
                    // if target is not found in the upper half then exclude it
                    hi = mid-1;
                }
            }
        }
        return -1; // if target is not found then return -1
    }
    
    public static void main(String[] args){
        SearchRotatedSortedArray ob = new SearchRotatedSortedArray();
        int[] nums  = {7,9,12,-3,0,2,4,5};
        int target = 9;
        System.out.println(ob.search(nums, target));
    }
}

//Time complexity : O(logN) N is the number of elements in array
//Space complexity : O(1)
