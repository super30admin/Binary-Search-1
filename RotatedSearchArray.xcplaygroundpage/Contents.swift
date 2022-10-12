// Space O(logN)
// time O(1)


func search(_ nums: [Int], _ target: Int) -> Int {
    var low = 0, high = nums.count - 1
    while low <= high {
        let middle = low + (high - low) / 2
        if nums[middle] == target {
            return middle
        } else if nums[middle] >= nums[low] {
            // un rotated array is on the left
            if target >= nums[low] && target < nums[middle] {
                high = middle - 1
            } else {
                low = middle + 1
            }
        } else {
            // Un rotated array is on the right
            if target <= nums[high] && target > nums[middle] {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }
    }
    return -1
}

