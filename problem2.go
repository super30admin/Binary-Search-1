// Time Complexity :  O(log(n))
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
func search(nums []int, target int) int {
    left := 0
    right := len(nums)-1
    
    for left<=right{
        mid := left+(right-left)/2
        if nums[mid] == target{
            return mid
        }else if nums[mid] >= nums[left]{
            if target>=nums[left] && target < nums[mid]{
                right = mid -1
            }else{
                left = mid + 1
            }
            
        }else{
            if target <= nums[right] && target > nums[mid]{
                left = mid+1
            }else{
                right = mid - 1
            }
        }
    }
    return -1
}
