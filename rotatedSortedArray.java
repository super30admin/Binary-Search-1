/**Time Complexity :
    O(log n)
// Space Complexity :
    O(1)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
// Your code here along with comments explaining your approach
**/




class rotatedSortedArray{
    public int search(int[] nums, int target) {
        //to handle edge case
        if(nums==null || nums.length==0){ return -1;}
        int n=nums.length;
        int low = 0, high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }

            //check sorted part
            else if(nums[low]<=nums[mid]){

                //check if target lies between sorted part
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }
                else{
                    low=low+1;
                }
            }

            //check for the remaining part
            else{
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}