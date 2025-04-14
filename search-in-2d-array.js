/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  let m = matrix.length;
  let n = matrix[0].length;
  let low = 0;
  let high = m * n - 1;

  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);
    let row = Math.floor(mid / n);
    let column = Math.floor(mid % n);

    if (matrix[row][column] == target) {
      return true;
    } else if (matrix[row][column] > target) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  return false;
};

var searchMatrixV2 = function (matrix, target) {
  let row = find_row_index(matrix, target);
  if (row === -1) return false;
  let col = find_col_index(matrix[row], target);
  if (col === -1) return false;
  return matrix[row][col] == target;
};

var find_row_index = function (array, target) {
  let left = 0;
  let right = array.length - 1;

  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2);
    let high = array[mid][array[mid].length - 1];
    let low = array[mid][0];
    if (low <= target && target <= high) {
      return mid;
    } else if (high >= target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return -1;
};

var find_col_index = function (array, target) {
  let left = 0;
  let right = array.length;
  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2);
    let element = array[mid];
    if (element == target) {
      return mid;
    } else if (element >= target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return -1;
};

test("Scenario #1:", () => {
  let input = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60],
  ];
  let target = 3;
  expect(searchMatrixV2(input, target)).toStrictEqual(true);
});
