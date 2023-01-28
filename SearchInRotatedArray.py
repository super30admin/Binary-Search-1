# All test cases in leetcode passed.
# Here though the array is rotated by findng the mid, either the left side is dorted or right side is sorted. 
# If in left sorted space check if target lies there else if in right sorted space then check if target lies there.
# Time complexity - O(logn)
# Space complexity - O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        
        if not nums:
            return -1

        if len(nums)==1:
            return 0 if nums[0]==target else -1

        l = 0
        h = len(nums)-1

        while l<=h:
            mid = (l+h)//2

            if nums[mid]==target:
                return mid
            
            
            if nums[mid]>=nums[l]: #condition for left sorted
                #if left sorted then check if target lies b/w l and mid
                if target>=nums[l] and target<nums[mid]:
                    h = mid-1
                else:
                    l = mid+1
            else:
                #if right sorted then check if target lies b/w mid and h
                if target>nums[mid] and target<=nums[h]:
                    l = mid+1
                else:
                    h = mid-1
        return -1



        