//Time Complexity - O(logn)
//Space Complexity - O(1)
//Worked on Leetcode
/*Figured that binary search can be applied to the array that are partially sorted, so if the target lies in the sorted
 part then we can apply usual binary search*/
public class SearchInRotatedSortedArray {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target  = 0;
        System.out.println(search(nums,target));
    }

    //Brute Force
    //Time Complexity O(n)
    /*
    public static int search(int[]nums, int target){
        if(nums==null || nums.length==0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target) return i;
        }
        return -1;
    }
*/
    public static int search(int[] nums, int target){
        if(nums==null || nums.length==0) return -1;
        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            int mid = start +(end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[start]<=nums[mid]){
                if(target>=nums[start] && target<nums[mid] ) end=mid-1;
                else start = mid+1;
            }
            else{
                if(target>nums[mid] &&target<=nums[end]) start=mid+1;
                else end=mid-1;
            }
        }
    return -1;
    }
}
