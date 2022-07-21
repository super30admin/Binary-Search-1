// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0; int r = n-1;
        while(l<=r){

            int mid = (l + r)/2;
            if(nums[mid] == target)
                return mid;

            else if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<=nums[mid]) {
                    r=mid-1;}
                else{
                    l=mid+1;}
            }
            else{


                if(target>=nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }
                else{
                    r=mid-1;}
            }
        }
        return -1;
    }
    //return -1;
}
