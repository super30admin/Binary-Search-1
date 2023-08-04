// brute force: linear scan
// time: o(n)

// brute force : sort + binary search
// time o(nlogn) + o(logn)
// space: o(n) ; if merge sort

// binary search as is
// is mid the ans?
// find the sorted half compared to mid
// if target is sorted half, search that side, otherwise search on the other side
func search(nums []int, target int) int {
    left := 0
    right := len(nums)-1
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] == target {return mid}
        
        if nums[left] <= nums[mid] {
            if target >= nums[left] && target <= nums[mid] {
                right= mid-1
            } else {
                left = mid+1
            }
        } else { // right sorted
            if target >= nums[mid] && target <= nums[right] {
                left = mid+1
            } else {
                right = mid-1
            }
        }
    }
    return -1
}
