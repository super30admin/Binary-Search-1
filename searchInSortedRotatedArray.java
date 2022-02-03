// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int l = nums.length;
        int s = 0;
        int e = l - 1;
        
        if(l == 1)
            if(nums[0] == target)
                return 0;
            else 
                return -1;
        //rotation Point
        int rp = findRotationIndex(nums, s, e);
        if(rp == 0)
            s = 0;
        else if(nums[0] > target)
            s = rp;
        else
            e = rp;
        //Normal binary search
        while(s <= e){
            int mid = s + (e-s)/2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                e = mid - 1;
            else 
                s = mid + 1;
        }
        return -1;
    }
    //This function would find the location where the rotation is reflected
    public int findRotationIndex(int[] nums, int s, int e){
        if(nums[s] < nums[e])
            return 0;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] > nums[mid + 1])
                return mid + 1;
            else{
                if(nums[mid] < nums[s])
                    e = mid - 1;
                else
                    s = mid + 1;
            }
        }
        return 0;
    } 
}