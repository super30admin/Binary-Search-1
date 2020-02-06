'''
Iterative:

Time Complexity : O(log n)
Space Complexity : O(1)

Recursive:
Time Complexity : O(log n)
Space Complexity : O(log n)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : None

Explanation: Check if mid is element if yes then return position
else check if left is sorted, if it is then if target<high of left array
if yes increase high = mid - 1 else  low = mid + 1
Check if target < high of the right array if yes then increase low = mid+1
and high = mid-1 then do this recursively until u reach middle element
'''

class Solution:
    #Recusive search
    def Itersearch(self, nums, target) :
        if nums == None:
            return -1

        if len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = int(low + ((high - low) / 2))
            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]:
                # left sorted
                if nums[low] <= target and target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            else:
                # right sorted
                if nums[mid] <= target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1

    def search(self, nums, target):
        if nums == None:
            return -1

        if len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        return self.helper(nums, target, low, high)

    def helper(self, nums, target, low, high):

        if high<low:
            return -1

        mid = int(low + ((high - low) / 2))
        if nums[mid] == target:
            return mid

        if nums[low] <= nums[mid]:
            # left sorted
            if nums[low] <= target and target <= nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        else:
            # right sorted
            if nums[mid] <= target and target <= nums[high]:
                low = mid + 1
            else:
                high = mid - 1

        return self.helper(nums, target, low, high)

obj = Solution()
result = obj.search([4,5,6,7,0,1,2],6)
print("Result is present at " + str(result))