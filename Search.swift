// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach  
    func search(_ nums: [Int], _ target: Int) -> Int {
        var start = 0
        var end = nums.count - 1
        while start <= end {
            var mid = start + (end - start) / 2 
            if nums[mid] == target {
                return mid
            }
            if nums[mid] >= nums[start] {
                if target >= nums[start] && target < nums[mid] {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            } else {
                if target > nums[mid] && target <= nums[end] {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
        }
        return -1
    }
