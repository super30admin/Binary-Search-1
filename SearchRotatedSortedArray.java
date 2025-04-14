// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO



public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int k = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                k = i;
                break;
            }
        }
        if( k != 0){
            if( nums[0] == target)
                return 0;
            else if(nums[0] > target){
                start = k;
            }
            else{
                end = k;
            }
        }
        int midIndex;
        while(start <= end){
            midIndex =  start + ((end - start) /2);
            if(nums[midIndex] == target)
                return midIndex;
            else if(nums[midIndex] > target){
                if(nums[midIndex] > target)
                end = midIndex - 1;
            }
            else
                start = midIndex + 1;
        }
        return -1;
    }
}