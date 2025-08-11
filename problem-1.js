/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    const m = matrix.length;
    const n = matrix[0].length;

    let low = 0;
    let high = (m*n)-1;

    while(low <= high) {
        const mid = Math.floor(low + ((high-low)/2));  
        const r = Math.floor(mid / n);
        const c = mid % n;
        const val = matrix[r][c];
        if(val == target) return true;
        else if (val > target) high = mid - 1;
        else if (val < target) low = mid + 1;
    }

    return false;
};
