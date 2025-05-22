''''
We find the middle of the array and then run binary searches in tow portions
The left sorted portion and the right sorted portion.
For the left sorted portion, we use mid and extreme left value to shiif the left, middle and right. 
This same is applied to the right sorted portion

Time compelxity - O(log-n)
Space complexity - O(1)
'''


class SearchRotatedSortedArray:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid
            
            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        return -1

                
            


