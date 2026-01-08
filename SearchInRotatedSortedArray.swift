//
//  SearchInRotatedSortedArray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 12/30/25.
//

/*
 Property - Atleast one side of the array will always be sorted. Either left side, right side or both sides.
 Binary search can be applied on it.
 It can also be done using
 
 Time complexity - O(log n) because search space is being reduced by half (In both iterative and recursive)
 Space complexity - Iterative approach is better than recursive approach. Recursive approach needs O(log n) extra space because it uses call stack. Iterative approach doesn't need it.
  */
class SearchInRotatedSortedArray {
    
    func search(nums: [Int], target: Int) -> Int {
        
        var low = 0
        var high = nums.count - 1
        while (low <= high) {
            let mid = low + (high - low)/2
            if (nums[mid] == target) {
                return mid
            } else if (nums[low] <= nums[mid]) {
                //left side is sorted. Now check if the target is present at the left side of array
                if (nums[low] <= target && nums[mid] > target) {
                    //So, target is present at the left side of array. Move towards the left side.
                    high = mid - 1
                } else {
                    //Move towards the right side
                    low = mid + 1
                }
            } else {
                //If left side is not sorted then surely the right side will be sorted.
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
        }
        //didn't find the target
        return -1
    }
    
    func searchWithAConditionChange(nums: [Int], target: Int) -> Int {
        var low = 0
        var high = nums.count - 1
        while (low < high) {
            let mid = low + (high - low) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[low] <= nums[mid]) {
                //left side is sorted. Check if the target is present at the left side
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid
                } else {
                    low = mid + 1
                }
            } else {
                //If left side is not sorted then surely the right side will be sorted
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1
                } else {
                    high = mid
                }
            }
        }
        if (nums[low] == target) {
            return low
        }
        //didn't find the target
        return -1
    }
    
    init() {
//        [3, 6, 8, 10, 1, 2]
        let indexOfItem = searchWithAConditionChange(nums: [4,5,6,7,8,9,0], target: 0)
        print("indexOfItem \(indexOfItem)")
    }
}
