
// Given an integer array sorted in ascending order, write a function to search target in nums. If target exists, 
//then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the 
//array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

// You may assume all integers in the array are less than 10000, and if you access the array out of 
//bounds, ArrayReader.get will return 2147483647.

 // Example 1:

// Input: array = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4
// Example 2:

// Input: array = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1
 

// Note:

// You may assume that all elements in the array are unique.
// The value of each element in the array will be in the range [-9999, 9999].


// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



 class UnknownLengthSearch {
   public  int search(int []nums,int target){
       //1
      //Initially the low pointer would be at 0 and high pointer would be at 1 
      int low=0;
      int high=1;      
       
      //2
      //Update low pointer to high and double
      //the value of high pointer until the value in the high index is less than the target
       while(nums[high]<target){
            low = high;
            high = high * 2;
        }
        //3
        //Search for the element using binary search
        return binarySearch(nums,target,low,high);
    }
            
    
    
  private int binarySearch(int nums[], int target,int low,int high){
      
        while(low<=high){
            int mid=low+(high-low)/2;
        if(target==nums[mid])
            return mid;
        else if(target>nums[mid])
             low=mid+1;
        else 
         high=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        UnknownLengthSearch obj=new UnknownLengthSearch();
        int nums[]={-1,0,3,5,9,12} ;
        int target = 2;
       
        
       int index= obj.search(nums,target);
        System.out.println("target at index:"+index);
    }
}