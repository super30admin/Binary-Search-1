
// Time Complexity :log (n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Main Idea: Atleast one side of the roated sorted array is always sorted take help of that to locate the element.
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        
        int left=0, right=nums.length-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(nums[mid]==target)
                return mid;

            //when left is sorted
            if(nums[left]<=nums[mid]){
                //if target lies in sorted left part means discard right part
                if(target>= nums[left] && target<nums[mid]){
                    right = mid-1;

                }else{
                    //not lies in sorted left part then check right part
                    left= mid+1;
                }
            } 
            //when right is sorted
            else if(nums[mid]<=nums[right]){
                //if target lies in sorted right part
                if(target>nums[mid] && target<=nums[right]){
                    left=mid+1;
                }else{
                    //not lies in sorted right part then search in the left part
                    right=mid-1;
                }
            }
            
        }
        return -1;
    }
        
}