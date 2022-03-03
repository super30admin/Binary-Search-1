// Time Complexity : O(Log N base 2)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

//Problem2 -- Search in Rotated search array
/*
We are finding which part of the array is sorted in this rotated sorted array
according tot hat we will reduce search space to find target

We find mid index and check target is in left sorted side of array or right sorted side of array and according to that updating values of low and high

*/

class Search {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(nums[mid] == target) return mid;
            else if(nums[l] <= nums[mid]){ // LEFT SIDE SORTED
                if(nums[l] <= target && nums[mid] > target){
                    h = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            else{// RIGHT SIDE SORTED
                if(nums[h] >= target && target > nums[mid]){
                    l = mid + 1;
                }
                else{
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}


public class BS1_Problem2 {
    public static void main(String[] args){
        Search s = new Search();
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println("Target " + target + "  is located at : " + s.search(arr, target) );
    }
}
