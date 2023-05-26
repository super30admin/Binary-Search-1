#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Yes, I was unable to find the solution for O(log n) time 


#Initially, iterated over the list to find the minimum element which indicates the starting position and also the offset factor by which the list has been rotated. Then used binary search to find the position of target where I used the offset factor to find the actual position. In order to mention the range of start and end within the length of the list, I had to perform the modulo operation.


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        factor = 0
        for idx in range(len(nums)):
            if min(nums[factor],nums[idx]) != nums[factor]:
                factor = idx

        st, ed = 0, len(nums)-1

        while st <= ed:
            mid = st + (ed - st) // 2
            if nums[(mid + factor)%len(nums)] > target:
                ed = mid - 1
            elif nums[(mid + factor)%len(nums)] < target:
                st = mid + 1
            else:
                return (mid + factor)%len(nums)
        return -1