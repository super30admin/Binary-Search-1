# Time Complexity : It is O(log n) since we dividing the length in each iteration. 
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1

        while(low<=high):
            mid= low +(high-low)//2
            
            print("Low ",low , nums[low])
            print("Mid ",mid , nums[mid])
            print("High ",high , nums[high])
            
            if(nums[mid]==target):
                return mid
            elif(nums[low]==target):
                return low
            elif(nums[high]==target):
                return high 
            
            if(nums[low]<=nums[mid]):
                if(nums[low]<=target and target<=nums[mid]):
                    high=mid - 1
                else:
                    low=mid + 1
            elif(nums[mid]<=nums[high]):
                if(nums[mid]<=target and target<=nums[high]):
                    low=mid + 1
                else:
                    high=mid- 1



        return -1

obj = Solution()
# print(obj.search([4,5,6,7,0,1,2],0))
#print(obj.search([4,5,6,7,0,1,2],3))
# print(obj.search([1],1))
print(obj.search([1,3,5],2))
        