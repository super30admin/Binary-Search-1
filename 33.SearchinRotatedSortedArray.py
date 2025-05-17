# Time Complexity :O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach in three sentences only
# divided given list into two segments, left of mid and right of mid
# then chose the segment which is sorted, then checked if target belongs in the sorted segment or not
# based on it went further by eleminating one part (reduced to half) and repeat until we find the index of target
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        r=len(nums)-1
        while l<=r:
            k = (l+r)//2
            if nums[k]==target:
                return k
            elif nums[l]<=nums[k]:
                if nums[l]<=target and nums[k]>target:
                    r=k-1
                else:
                    l=k+1
            else:
                if nums[k]<target and nums[r]>=target:
                    l=k+1
                else:
                    r=k-1
        return -1
