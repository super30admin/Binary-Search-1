// Time Complexity : 0(log(m*n))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
//Intuition is to do a binary search on the flattened list of elements in the matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        int low=0,mid,midRow,midColumn;
        int high=rows*columns-1;
        while(low<=high){
            mid=low+(high-low)/2;

            //converting mid to appropriate row and column
            midRow=mid/columns;
            midColumn=mid%columns;

            if(matrix[midRow][midColumn]==target){
                return true;
            }else if(matrix[midRow][midColumn]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}

// Time Complexity : 0(log(n))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
//Intuition is to do a binary search on the array assuming at least one half of the array
//will always be sorted and check if the target exists
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int low=0,mid;
        int high=nums.length-1;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
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

// Time Complexity : 0(log(n))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/*Intuition is to take a high starting at index 1 and keep doubling it while doing the
binary search once the target is not found and when the target is supposed to lie
in the upper half of the array
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;

        while(low<=high){
            if(reader.get(high)==target){
                return high;
            }
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }else if(reader.get(mid)< target){
                low=mid+1;
                high=2*high;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}