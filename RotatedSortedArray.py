# Complexity: O(log(n))
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # need to find the pivot
        # pivot is a[i]<a[i-1]
            
        if(len(nums)==1):
            if(nums[0]==target):
                return 0
            else:
                return -1
            
        # no rotation
        beg = 0
        end = len(nums)-1
        
        while(beg<=end):
            mid = (beg + end)//2
            # find which end is sorted
            if(nums[mid]==target):
                return mid
            # missed one edge case on leetcode by specifying nums[mid]>nums[beg] (3,1)
            if(nums[mid]>=nums[beg]):
                #left is sorted
                # can't compare using mid as there may be errors due to rotation.
                # eg. [4,5,6,7,0,1,2] and target 2 can be on left and right side
                # so use beg and end to determine target position
                if(nums[beg]<=target and nums[mid]>target):
                    end = mid - 1
                else:
                    # element is in non sorted half
                    beg = mid + 1
            
            else:
                # right is sorted
                if(nums[mid]<target and nums[end]>=target):
                    beg = mid + 1
                else:
                    # element is in non sorted half
                    end = mid - 1
        return -1
