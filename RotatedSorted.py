"""
We use binary search by finding mid and checking if nums[mid] == target.
Check which half (left-mid or mid-right) is sorted and check if the target is in that half.
Change left and right accordingly and continue search in the sorted half.
"""
"""
Time Complexity:
O(log n) — Binary search in a rotated array.
Space Complexity:
O(1) — No extra space used.
"""

class RotatedSorted:
    def search(self, nums: list[int], target: int) -> int:

        left = 0
        right = len(nums) - 1
        
        while (left <= right):

            mid = (left+right)//2

            if nums[mid] == target:
                return mid

            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
    

if __name__=="__main__":
    rs = RotatedSorted()
    nums = [4,5,6,7,0,1,2]
    print(rs.search(nums,0))
    print(rs.search(nums,3))
    