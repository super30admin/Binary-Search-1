// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes took me a while to figure out the solution.

// Your code here along with comments explaining your approach

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
//Example 1: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3

var searchMatrix = function (matrix, target) {
  let noOfRows = matrix.length; // m=3
  let noOfColumns = matrix[0].length; // n=4
  let low = 0;
  let high = noOfRows * noOfColumns;
  while (low < high) {
    let mid = (low + high) / 2;
    let i = Math.trunc(mid / noOfColumns);
    let j = Math.trunc(mid % noOfColumns);
    if (matrix[i][j] == target) return true;
    else if (matrix[i][j] < target) low = mid + 1;
    else high = mid;
  }
  return false;
};
