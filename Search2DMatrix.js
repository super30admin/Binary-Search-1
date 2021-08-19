// Time Complexity : log(m) + log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


var searchMatrix = function (matrix, target) {
    if (!matrix || matrix.length === 0) return false;

    let m = matrix.length, n = matrix[0].length
    let low = 0, high = (m * n) - 1;

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        let r = Math.floor(mid / n), c = mid % n;
        if (matrix[r][c] === target) return true;
        else if (matrix[r][c] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return false;

};