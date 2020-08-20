
    /*  Explanation
    Time Complexity for operators : log(n)   
    Extra Space Complexity for operators : o(1) .. No extra space
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : I forgot with one condition where in while loop  while(low<high). I forgot to check
    low <= high. It failed initially.
    The implemntation consists dividing array and checking the first element with the mid. It will tell which side
    if already in sorted array. Once we found that, we need to travese on that side and check for target.
    If it did not found then try on other side.
    */

public class searchinRotatedSOrtedArray{


    public static void main(String args[]){
            int arr[] = new int[]{4,5,6,7,0,1,2};
            System.out.println(search(arr,0));
    }
    public static int infiniteSortedArray(int[] nums, int target) {
     
        int low =0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return  mid;
            else if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(target<=nums[high] && target>nums[mid]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}