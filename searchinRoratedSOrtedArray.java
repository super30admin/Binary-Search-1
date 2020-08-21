    /*  Explanation
    Time Complexity for operators : log(n) 
    Extra Space Complexity for operators : o(1) .. No extra space
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    Initillay it will try go to the mid element. It target founds at mid then it will return.
    Then it will compare with the lower elemnt that means left most elment in the array.
    If nums[mid]>=nums[low] then check whether target is in between the range of mid and low.If it is then go to left side else on right side.
    Similarly for comparing mid with highest element.
    */

public class searchinRotatedSOrtedArray{


    public static void main(String args[]){
            int arr[] = new int[]{4,5,6,7,0,1,2};
            System.out.println(search(arr,0));
    }
    public static int search(int[] nums, int target) {
     
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
