// Time Complexity : O(log(n))
// Space Complexity : O(1) -> contant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the shift while accounting for all cases.


// Your code here along with comments explaining your approach


class rotateArraySearch {
    
    public int getShift(int[] nums){
        int start=0;
        int l = nums.length;
        int end = l-1;
        int mid;
        
        while(start <= end){
            mid = (start + end) / 2;
            if((mid+1 >= l))
                return 0;
            if((nums[mid] > nums[mid+1]))
                return mid + 1;
            else if(nums[mid] > nums[end])
                start = mid + 1;
            else if(nums[mid] < nums[start])
                end = mid - 1;
            else
                start = mid+1;
            }
        return 0;
    }
    public int search(int[] nums, int target) {
        
        int shift = getShift(nums);
        
        int start=shift;
        int l=nums.length;
        int end = shift + l-1;
        int mid;
                
        while(start <= end){
            mid = (start + end) / 2;
            //System.out.println(mid + " " + nums[mid % l]);
            if(nums[mid % l] == target)
                return (mid%l);
            else if(nums[mid % l] < target)
                start = mid + 1;
            else
                end = mid -1;   
            }
        return -1;
    }
}