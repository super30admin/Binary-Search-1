/*
* TC: O(log n)
* SC: O(1)
*
* Approach:
* Since the elements are  of unknown length we take the low as index 0 and high as index 1
* We then do a loop till we find an element that's greater than the target.
* Once we find the element we then do a binary search till we find the element if not found we return -1;
* */

const binarySearch = (arr, target, low, high) => {
  while (low <= high) {
    const mid = Math.floor(low + (high-low)/2);
    if (arr[mid] == target) {
      return mid;
    } else if (target > arr[mid]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return -1;
}
const search = (reader, target) => {
  let low = 0;
  let high = 1;

  while(reader[high] < target) {
    low = high;
    high = high * 2;
  }

  return binarySearch(reader, target, low, high);

}