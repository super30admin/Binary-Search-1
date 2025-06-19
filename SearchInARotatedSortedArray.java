//Problem - Search in a Rotated Sorted Array 
//Leetcode Problem link - https://leetcode.com/problems/search-in-rotated-sorted-array/

//Time complexity - O(log(n)) 
//Space complexity - O(log(n)) - Each recursive call is added to stack 
//Solution:

public class SearchInARotatedSortedArray{

    public static int search(int[] nums, int target) {
       return binarysearch(nums, 0, nums.length-1, target);
    }

        private static int binarysearch(int[]nums, int low , int high, int target){
            if(low>high) return -1; //base case   
        
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;

            if(nums[mid]>=nums[low]){
            //left sorted arrray     
            if(nums[low] <= target && nums[mid]> target){
                return binarysearch(nums,low,mid-1,target);
            }
            else{
                return binarysearch(nums,mid+1,high,target);
                }

            }
            else{
                if(nums[mid]<target && nums[high] >= target){
                    return binarysearch(nums,mid+1,high,target);
                }
                else{
                     return binarysearch(nums,low,mid-1,target);
                }
            }
        }
    
        public static void main(String args[]){

            // Problem2_RSA_RecursiveApproach obj = new Problem2_RSA_RecursiveApproach();
            int [] nums = {4,5,6,7,0,1,2}; 
            int target = 12;
            System.out.println(search(nums, target));

        }

}
