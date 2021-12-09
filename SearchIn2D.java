// Time Complexity : O(logm*logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : Yes, while setting the constraints that lead to array our of bounds exception


// Your code here along with comments explaining your approach

public class SearchIn2D {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            if(m==1 && n==1) {
                return matrix[0][0] == target;
            }

            if(m == 1) {
                int ans = binarySearch(matrix[0], target, 0, n-1);
                return ans != -1;
            }
            return  helper(matrix, target, 0, m-1, 0, n-1);
        }

        public boolean helper(int [][] matrix, int target, int rStart, int rEnd, int cStart, int cEnd) {

            if(rStart > rEnd || cStart > cEnd || rStart <0 || cStart<0 || rEnd >= matrix.length || cEnd >=matrix[0].length) {
                return false;
            }

            int rowMid = rStart + (rEnd -rStart)/2;
            int cMid = cStart + (cEnd -cStart)/2;

            if(matrix[rowMid][cMid] == target) {
                return true;
            }

            // Reaching here when only two rows are left, and in one of the row we might have the target present
            if(rEnd - rStart < 2) {

                // if the target is > mid, in that case we apply binary search over two arrays
                // option1 - in the row below the mid row, because the target is greater than mid
                // If we don't find ans in the first option 1, we search in the same row but the col start is greater than the col mid.
                if(matrix[rowMid][cMid] < target) {
                    int ans1 = binarySearch(matrix[rowMid], target, cMid+1, cEnd);
                    if(ans1 ==-1) {
                        int ans2 = binarySearch(matrix[rowMid+1], target, cStart, cEnd);
                        return ans2 != -1;
                    } else {
                        return true;
                    }
                }
                // This is just the reverse of the above case
                // We are trying to find the ans in the above row because target < mid element.
                else {
                    int ans1 = binarySearch(matrix[rowMid], target, cStart, cMid-1);
                    if(ans1 ==-1) {
                        int ans2 = binarySearch(matrix[rowMid-1], target, cStart, cEnd);
                        return ans2 != -1;
                    } else {
                        return true;
                    }
                }

            }

            // We are reducing the search space by rows
            // We are doing this till only two rows are left
            if(matrix[rowMid][cMid] < target) {
                return helper(matrix, target, rowMid, rEnd, cStart, cEnd);
            } else {
                return helper(matrix, target, rStart, rowMid, cStart, cEnd);
            }

        }

        //Normal Binary Search method that returns the index when target is found
        int binarySearch(int [] arr, int target, int startIndex, int endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;

            while (startIndex < endIndex) {
                if(arr[midIndex] == target) {
                    return midIndex;
                }

                if(arr[midIndex] < target) {
                    startIndex = midIndex +1;
                } else {
                    endIndex = midIndex -1;
                }
                midIndex = startIndex + (endIndex - startIndex) / 2;
            }
            return -1;
        }
    }


}
