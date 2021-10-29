# Time Complexity: O(log n)
# Space Complexity: O(1)

# Logic: find the middle element, due to rotation either left or mid would be sorted or right of mid would be sorted
# locate in which region target lies & discard the other region. Keep on searching for the element in the sorted part
# keep on changing the range for the middle element. If found return index else -1

class Solution:
    def search(self, nums, target) -> int:
        if len(nums) == 0:
            return -1
        
        if len(nums) == 1:
            if nums[0] == target:
                return 0
            else:
                return -1

        start = 0
        end = len(nums) - 1

        if nums[start] == target:
            return start
        if nums[end] == target:
            return end

        while start <= end:
            mid = (start+end)//2

            if nums[mid] == target:
                return mid
            
            # Left is sorted
            if nums[start] <= nums[mid]:
                # Target in left side
                if nums[start] <= target < nums[mid]:
                    end = mid -1
                # Target in right Side
                else:
                    start = mid + 1
            # Right is sorted
            else:
                # Target in right side
                if nums[mid] < target <= nums[end]:
                    start = mid + 1
                # Target in left side
                else:
                    end = mid - 1
        return -1


obj = Solution()
print(obj.search([4,5,6,7,0,1,2],0))
print(obj.search([4,5,6,7,0,1,2],3))
print(obj.search([1],0))
print(obj.search([3,4,5,1,2],1))
print(obj.search([5,1,2,3,4],1))
