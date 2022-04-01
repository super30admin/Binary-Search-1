// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class prob2 {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l -(l-h)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[l]<=nums[mid]){
                if(nums[l]<=target&&target<nums[mid]){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(nums[mid]<target&&target<=nums[h]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
        }
        return -1;
    }
}
