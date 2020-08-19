class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1

        while(low <= high):

            mid = (low + high)//2
            if target == nums[mid]:
                return mid
            elif nums[low] <= nums[mid]:
                if target < nums[mid] and target >= nums[low]:
                    high = mid-1
                else:
                    low = mid+1
            else:
                if target > nums[mid] and target <= nums[high]:
                     low = mid +1
                else:
                    high= mid -1
        return -1


# Time Complexity: O(log n)
# Space Complexity:O(1)

"""
Array is rotated but sorted. Binary Search is used.
Middle index is calculated.
Middle element is compared with the low element.
If low element is lesser or more than the element at mid, then target is compared with the mid element and Low and high pointers are moved accordingly.
If the element is not found return -1

"""
