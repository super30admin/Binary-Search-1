// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// ## Problem1 
// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
    // Return false if matrix does not exist or is empty
    if (matrix === null || matrix.length === 0) return false;

    let rows = matrix.length;
    let cols = matrix[0].length;
    // Define the low and high index.
    // High index will be the (total elements-1). We imaginf the 2d matrix as a 1d matrix
    let l = 0;
    let h = (rows * cols) - 1;
    while (l <= h) {
        // Find the mid from the low and high indexs
        // Find the location of the mid index in the matrix
        // row = index / no of cols
        // col = index % no of cols
        let mid = Math.floor((l + ((h - l) / 2))); // to prevent integrer overflow
        let midRow = Math.floor(mid / cols);
        let midCol = Math.floor(mid % cols);
        // Return true id target found
        if (matrix[midRow][midCol] === target)
            return true;
        // Set low index to mid+1 if the target is greater than the mid element
        if (matrix[midRow][midCol] < target) {
            l = mid + 1;
        } else {
            h = mid - 1;
        }
    }
    return false
};

let matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]];
let target = 3;
console.log(searchMatrix(matrix, target));
