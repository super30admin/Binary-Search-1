// Time Complexity : O(log n)
// Space Complexity : O(1) - constance
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

const searchA2dMatrix = (arr, target) => {
  let low = 0;
  let high = arr.length * arr[0].length - 1;
  let mid = 0;
  let midIdx;

  while (low <= high) {
    midIdx = Math.floor((low + high) / 2);
    mid =
      arr[Math.floor(midIdx / arr[0].length)][
        Math.floor(midIdx % arr[0].length)
      ];

    if (mid === target) {
      return true;
    }

    if (mid < target) {
      low = midIdx + 1;
    } else {
      high = midIdx - 1;
    }
  }
  return false;
};

console.log(
  searchA2dMatrix(
    [
      [1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60],
    ],
    7
  )
);
