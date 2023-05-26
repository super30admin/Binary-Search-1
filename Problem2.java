package BinarySearch;
/*
 * Here we are using the concept that at any given time in a rotated sorted array atleast one of the sides is sorted when we select a mid.
 *
 * Time Complexity :
 * O(logN)
 * 
 * Space Complexity :
 * Space complexity is O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : Tried to implement using two pass binary search to find pivot and then search within subarrays but could not pass all cases on leetcode. 
 * Hence, had to modify approach based on concepts taught in class
 * 
 */

public class Problem2 {
    public int search(int[] nums, int target) {

    if(nums.length==0 || nums == null)
        return -1;

    if(nums.length==1)
        return nums[0]==target?0:-1;

    int index=binarySearch(nums,target,0,nums.length-1);
    return index;
    }


    int binarySearch(int[] nums, int target, int low, int high){
        if(low>high){
            return -1;
        }

        int mid=(low+high)/2;
        
        if(nums[mid]==target){
            return mid;
        }
        else if( (nums[low]<=nums[mid])){
        //left sorted
        if((nums[low]<=target && nums[mid]>=target))
            return binarySearch(nums, target, low, mid-1);
        else
            return binarySearch(nums, target, mid+1, high);}
        else{
        //right sorted
        if((nums[high]>=target && nums[mid]<=target))
            return binarySearch(nums, target, mid+1, high);
        else
            return binarySearch(nums, target, low, mid-1);}

        }
    

}
