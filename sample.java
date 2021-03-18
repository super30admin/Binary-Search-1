// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Search in a 2D matrix
// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null && matrix[0].length) {
          return false;
        }
        int start = 0, end = (matrix.length * matrix[0].length) -1;
        // initalise start and end
        while(start <= end) {
            int mid = start + (end-start)/2;
            int row = mid/matrix[0].length;
            // divide by number of columns conside example [1,2]
            int col = mid % matrix[0].length;
            // perform normal binary search
            if(matrix[row][col] == target) {
                return true;
            }
            else if(matrix[row][col] > target) {
                end = mid -1;
            }
            else {
                start = mid + 1;
            }

        }
        return false;
    }
}

//Search in a 2D matrix
// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;
        while(row <= matrix.length -1 && col >=0) {
            if(matrix[row][col] == target) {
                return true;
            }
            else if(matrix[row][col] > target) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}

// Time Complexity : O(log T) where T is the target index
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Infinte sorted array:
class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        // keep incrementing the end pointer till we reach an index which has a value greater than equal to target
        while(reader.get(end) <= target) {
            start = end;
            end = end * 2;
        }
        // perform binary search as we have the start and the end index
        // also we have array sorted
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(reader.get(mid) == target) {
                return mid;
            }
            else if(target > reader.get(mid)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Rotated sorted array:
// Approach 1:
// Find the minimum element in a rotated sorted array
// After finding the minimum element we can apply binary search on 0, minEle-1 and minEle to n-1 as we have two sorted arrays
class Solution {
    public int search(int[] nums, int target) {
        int minEle = -1;
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int prev = (mid - 1 + nums.length)%nums.length;
            // if mid == 0 then -1 is not possible
            int next = (mid + 1 % nums.length);
            // mid == nums.length-1 then the next index is 0
            if(nums[start] <=nums[mid] && nums[mid] <= nums[end]) {
                minEle = start;
                break;
            }
            else if(nums[mid] < nums[next] && nums[mid] < nums[prev]) {
                minEle = mid;
                break;
            }
            else if(nums[mid] >= nums[start]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        int first = binarySearch(nums, 0, minEle -1, target);
        // binary search for first sorted array
        int second = binarySearch(nums, minEle, nums.length-1, target);
        // binary search for second sorted array
        return first == -1? second: first;

    }
    public int binarySearch(int [] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            }
            // left side is sorted
            else if(nums[mid] >= nums[start]) {
                // search if the target is in the left side which is sorted
                if(nums[start]<=target && target < nums[mid]) {
                    end = mid -1;
                }
                // search in the right side
                else {
                    start = mid + 1;
                }
            }
            //right side is sorted
            else {
                // search in the right side
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                }
                // search in the left side
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;

    }
}
