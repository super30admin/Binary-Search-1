// Time Complexity : O(log n)
// Space Complexity : O(1)

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * function ArrayReader() {
 *
 *     @param {number} index
 *     @return {number}
 *     this.get = function(index) {
 *         ...
 *     };
 * };
 */

/**
 * @param {ArrayReader} reader
 * @param {number} target
 * @return {number}
 */
var search = function (reader, target) {
  let low = 0;
  let high = 1;
  while (reader.get(high) < target) {
    low = high;
    high = high * 2;
  }
  while (low <= high) {
    let mid = Math.floor((high + low) / 2);
    if (target === reader.get(mid)) return mid;
    else if (target > reader.get(mid)) low = mid + 1;
    else high = mid - 1;
  }
  return -1;
};
