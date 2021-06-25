#Time Complexity :  O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums)-1

        while(low<=high):
            mid = low + (high-low)//2
            if nums[mid]==target:
                return mid
            elif  nums[mid] >= nums[low]:
                if target>= nums[low] and target<nums[mid]:
                    high = mid -1

                else:
                    low = mid+1
            else:
                if target >nums[mid] and target <= nums[high]:
                    low = mid+1
                else:
                    high = mid -1

        return -1


mat = [4,5,6,7,1,2,3]
target = 3
q = Solution().search(mat,target)
print(q)