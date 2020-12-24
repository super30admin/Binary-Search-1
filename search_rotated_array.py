# Approach: Similar to binary serach problem, but since array is shifted at a pivot we need to determine what direction to move along
# We check if target matches element at middle idx -- return the middle index
# If not
    # We need to check if left num is <= middle and check for 2 conditions
    # Condition1: Is target < middle element and 
    # Condition2: Is target >= left element so that we can apply binary search on this sub array

    # Repeat for the else condition as well


# Time complexity: O(log(N))
# Space Complexity: O(1)
# Successfully ran on leetcode

def search(nums, target):

    leftIdx = 0
    rightIdx = len(nums) - 1

    while leftIdx <= rightIdx:
        middleIdx = (leftIdx + rightIdx) // 2

        if target == nums[middleIdx]:
            return middleIdx

        elif nums[leftIdx] <= nums[middleIdx]:
            # to determine the direction as to which side we need to check
            
            if target < nums[middleIdx] and target >= nums[leftIdx]:
                # then target exists in this sub array, eliminate right sub array
                rightIdx = middleIdx - 1

            else:
                leftIdx = middleIdx + 1

        else:
            if target > nums[middleIdx] and target <= nums[rightIdx]:
                # then target exists in this sub array eliminate left sub array
                leftIdx = middleIdx + 1

            else:
                rightIdx = middleIdx - 1

    return -1

