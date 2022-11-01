#time complexity: O(log(n))
#space complexity: O(1)
#ran on leetcode: yes
# The solution uses binary search. In a sorted rotated array, the array is partially sorted.
# Using the mid and low index, it can be found out which side of the array is sorted, and from here we proceed to the left or right
# of the array based on the target value

class Solution:
    def search(self, nums,target) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                return mid
            #check if left part is sorted
            if(nums[mid]>=nums[low]):
                #check if target is within this range
                if(target>=nums[low] and target<nums[mid]):
                    high=mid-1
                else:
                    low=mid+1
            else:
                if(target>nums[mid] and target<=nums[high]):
                    low=mid+1
                else:
                    high=mid-1
        return -1

s=Solution()
arr=[4,5,6,7,0,1,2]
print(s.search(arr,4))
