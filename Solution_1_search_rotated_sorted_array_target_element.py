// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No
'''
1. check if array is left sorted or right sorted
2. if array is right sorted then check if element is present
   within the right sorted array. if it is present, end pointer to 
   this array and perform bnary search.
3. If not in right sorted array then move to left unsorted array.
   check again for left and right sorted array. 
4. Iterate over left sorted and right sorted arrays by moving the pointer 
   based on  condition the target should be within the range.
5. if found return the value else return -1
   


'''



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        start=0
        end=len(nums) -1
        
        while start<= end:
            
            mid= start+(end-start)//2
        
                
            if nums[mid] == target:
                return mid

            # check if its right sorted

            if nums[start] <= nums[mid]:

                if nums[start] <= target and target < nums[mid]:
                    end=mid-1
                else:
                    start=mid+1

            else:
                if nums[mid] < target and target <= nums[end]:
                    start=mid+1
                else:
                    end=mid-1
        return -1
                    
                    
                    
        
