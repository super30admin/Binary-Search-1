/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  const m = matrix.length;
  const n = matrix[0].length;
  let lo = 0,
    hi = m * n - 1;

  while (lo <= hi) {
    let mid = (lo + hi) >>> 1;
    const row = Math.floor(mid / n);
    const col = mid % n;
    const val = matrix[row][col];
    if (target === val) return true;
    else if (val < target) {
      lo = mid + 1;
    } else {
      hi = mid - 1;
    }
  }
  return false;
};
