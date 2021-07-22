// Problem2 
//Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
//the approach for this problem is finding where the array has been rotated adn then treatign it like a normal sort array
//time complexity : O(log n)
//Leet code solution accepted : all test cases passed
class Solution {
    public int search(int[] nums, int target) {
        //check if given arr is empty 
        if (nums==null ||nums.length==0) return -1;
        //performing binary search on the given roatated aaray to find the index at which it was rotated;
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            //rotating the array to crrect order
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else{
                right=mid;
            }
        }
        //creating a  new start point
       int start = left;
       left =0;
       right = nums.length-1;
       //if these condiotons match you can point out wehre the array is starting
       if(target>=nums[start]&&target<=nums[right]){
           left=start;

       }else{
           right = start;
       }
       //performing regular binary search 
       while(left<=right){
           int mid = left+(right-left)/2;
           if (nums[mid]==target){
               return mid;
           }else if (target>nums[mid]){
               left = mid+1;
           }else if (target<nums[mid]){
               right = mid-1;
           }
           
       }
       return -1;
        
    }
}