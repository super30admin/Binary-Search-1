class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        def search(nums: List[int], target: int) -> int:
            if len(nums)==1:
                return nums[0] == target

            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = (low + high)//2 # O(1)
                
                if nums[mid] == target:
                    return True

                # check first half
                if nums[low] <= nums[mid]: # O(1)
                    if nums[low] <= target < nums[mid]:  # Line 12 and 19 shrink search in half so O(log n)
                        high = mid - 1
                    else:
                        low = mid + 1

                # Check second half
                else:
                    if nums[mid] < target <= nums[high]:
                        low = mid + 1
                    else:
                        high = mid - 1

            return False

        for i in range(len(matrix)):
            if search(matrix[i],target):
                return True
        return False

        