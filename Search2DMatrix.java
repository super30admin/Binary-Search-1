// Time Complexity: O(log(m*n))
//   - Binary search is applied on a sorted array of size m*n (total elements in the matrix).
//   - Each binary search iteration reduces the search space by half, resulting in logarithmic time complexity.

// Space Complexity: O(1)
//   - The space used is constant as it does not depend on the input size.
//   - Only a few integer variables are used for indices and bounds.

// Did this code successfully run on Leetcode: Yes

// Any problem you faced while coding this: No

// Approach:
// 1. Initialize low as 0 and high as m*n - 1, where m is the number of rows and n is the number of columns.
// 2. Perform binary search by calculating the mid index.
// 3. Convert the mid index to corresponding row and column indices (r, c).
// 4. If the target element is found at matrix[r][c], return true.
// 5. If the target is greater, move to the right half of the search space by updating low = mid + 1.
// 6. If the target is smaller, move to the left half of the search space by updating high = mid - 1.
// 7. Repeat steps 2-6 until low <= high.
// 8. If the loop terminates without finding the target, return false.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low =0;
        int high = m*n -1;

        while(low <=high)
        {
            int mid = low+(high - low)/2;
            int r= mid/n;
            int c = mid %n;

            if(matrix[r][c] == target)
            {
                return true;
            }
            else if(matrix[r][c] < target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }
}