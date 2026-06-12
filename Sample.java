// Approach:
// Treat the 2D matrix as a single sorted array and apply binary search.
// Convert the middle index into row and column indices to access the matrix element.
// Return true if the target is found, otherwise return false.

// Time Complexity: O(log(M * N))
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int r=mid/n;
            int c=mid%n;
            if(matrix[r][c]==target) return true;
            else if(matrix[r][c]<target) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}
//problem 2
// Approach:
// Use binary search to determine which half of the array is sorted.
// Check whether the target lies in the sorted half and discard the other half.
// Continue until the target is found or the search space becomes empty.

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }if(nums[low]<=nums[mid]){//left sorted
                if(nums[low]<=target && target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{ //right sorted
                if(nums[mid]<target && nums[high]>=target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
    }
    return -1;
}
}
//problem 3
// Approach:
// Expand the search range exponentially until the target is within the range or exceeded.
// Apply binary search on the identified range to locate the target.
// Return the index if found, otherwise return -1.

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // Expand the search range
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = reader.get(mid);

            if (value == target)
                return mid;
            else if (value < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
