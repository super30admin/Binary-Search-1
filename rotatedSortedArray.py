#Successfully submitted to Leetcode
#Time Complexity : O(logn)
#Understood the approach but had problems in implementing it.
class Solution:
    def search(self, nums, target):
        if not nums:
            return -1
        left = 0
        right = len(nums)-1


        while right-left >1:
            if nums[left] == target:
                return left
            if nums[right] == target:
                return right
            mid = (left+right)//2
            if nums[mid] == target:
                return mid
            if nums[left] <= nums[mid]:
                if target>= nums[left] and  target < nums[mid]:
                    right = mid
                else:
                    left = mid
            else:
                if target<= nums[right] and target > nums[mid]:
                    left = mid
                else:
                    right = mid

        return -1

s = Solution()
print(s.search([4,5,6,7,0,1,2],0))
print(s.search([4,5,6,7,0,1,2],6))
print(s.search([4,5,6,7,0,1,2],3))
