// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach


// Search 2D Matrix
//Time complexity O(log(n))
//Executed in leetcode : yes
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int lengthOfArray = matrix.length * matrix[0].length;
        int high = lengthOfArray;
        int low = 0;
        int mid = (high - low) / 2 + low;
        int row = mid / matrix[0].length;
        int col = mid % matrix[0].length;

        while (low < high && matrix[row][col] != target && low != mid) {

            if (target < matrix[row][col]) {
                high = mid;
                mid = (high - low) / 2 + low;
                row = mid / matrix[0].length;
                col = mid % matrix[0].length;

            } else if (target > matrix[row][col]) {
                low = mid;
                mid = (high - low) / 2 + low;
                row = mid / matrix[0].length;
                col = mid % matrix[0].length;
            }
        }

        if (target == matrix[row][col]) {
            return true;
        }
        return false;
    }


//Rotated Array
//Time complexity : O(log(n))
//Space Complexity : O(1)
//Executed in leetcode : yes
    // Any problem you faced while coding this : to understand which side of array to avoid

    class Solution {
        public int search(int[] nums, int target) {
            int low=0;
            int high=nums.length-1;
            while(low<=high){
                int mid = (high-low)/2 +low;
                if(nums[mid]==target) return mid;
                if(nums[low]<=nums[mid]){
                    if(nums[mid]>target && nums[low]<=target){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }else if(nums[mid]<=nums[high]){
                    if (target>nums[mid] && target<=nums[high]) {
                        low=mid+1;
                    }else{
                        high=mid-1;
                    }
                }
            }
            return -1;
        }
    }






    //Time complexity O(1)
//        Executed in leet code : no
    //infinite Array
    class Solution {
        int low = 0;
        int high = 1;
        while(reader.get(high)<target)

        {
            low = high;
            high = high * 2;
        }
        while(low<=high)

        {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            return -1;
        }


    }


}