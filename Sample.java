// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid] ) {
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
                
            }
            
            else{
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
        
    }
}

// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach




class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int low=0;
        int high=matrix[0].length*matrix.length-1;
        int row=0;
        int col=0;
        int mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            row=mid/matrix[0].length;
            col=mid%matrix[0].length;
            if(matrix[row][col]==target){
                return true;
            }if(matrix[row][col]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
            
        }
        return false;
        
    }
}