// Time Complexity : flatten arary - O(n) binary Search - O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


var searchMatrix = function (matrix, target) {
    let newArr = flatten(matrix);

    return binarySearch(newArr, target);

};

var binarySearch = function (arr, target) {
    let left = 0;
    let right = arr.length - 1;
    let mid;
    while (left <= right) {
        mid = Math.floor((left + right) / 2)

        if (arr[mid] === target) {
            return true;
        }

        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return arr[mid] === target ? true : false;
}


var flatten = function (arr) {
    let newArr = [];
    for (let i = 0; i < arr.length; i++) {
        if (Array.isArray(arr[i])) {
            newArr = newArr.concat(flatten(arr[i]));
        } else {
            newArr.push(arr[i]);
        }
    }
    return newArr
}