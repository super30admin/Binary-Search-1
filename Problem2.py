# // Time Complexity :O(Logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        In this problem there is one property in rotated sorted arry one side is always
        sorted , check with examples, atleast one side is sorted
        so check which side is sorted and range if target is in range or not
        

        """
        l,h=0,len(nums)-1
        while(l<=h):
            mid=l + (h-l)//2
            if nums[mid]==target:return mid

            #if left is sorted
            if nums[l]<=nums[mid]:
                if nums[l]<=target<nums[mid]:
                    h=mid-1
                else:
                    l=mid+1
            elif nums[mid]<=nums[h]:
                if nums[mid]<target<=nums[h]:
                    l=mid+1
                else:
                    h=mid-1
        return -1
        
            


        
