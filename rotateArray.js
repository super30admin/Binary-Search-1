/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);

        if (nums[mid] === target) {
            return mid;
        }


        // to see if left side is sorted
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target <= nums[mid]) {
                // target is in the left of the array
                right = mid - 1;

            } else {
                //else, target is in the right side of the array
                left = mid + 1;
            }
        }

        // else, the right array is sorted
        else {
            if (nums[mid] <= target && target <= nums[right]) {
                // target is in the right side of the array
                left = mid + 1;

            } else {
                // else, target is in the left of the array
                right = mid - 1;
            }
        }


    }

    return -1;
};