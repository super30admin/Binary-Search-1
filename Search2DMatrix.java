// Time Complexity : Olog(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Implemented Binary Search Algorithm twice
 * First to find the mid [array] of the buckets and then check by binary search if target is present in that bucket[array]
 * If not in mid then check the whether target is less than max value in the mid bucket [array] then only consider left side buckets
 * Else consider only right side buckets
 */

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return bucketsBinarySearch(matrix, 0, matrix.length - 1, target);

    }

    private boolean bucketsBinarySearch(int [][] matrix, int l, int r, int target) {
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int midArrLength =  matrix[mid].length;

            if (binarySearch(matrix[mid], 0, midArrLength -1, target)) {
                return true;
            }

            if (matrix[mid][midArrLength -1] < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return false;
    }

    private boolean binarySearch(int arr[], int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) /2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return false;
    }
}