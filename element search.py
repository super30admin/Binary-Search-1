#time Complexity O(logN)
#Space Complexity 0(1)
# it ran in leetcode
# Lot of issue arises while coding the code specially elif conditions  (Plese let me know if it is a good approach)
# Approach : 

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0
        end = len(nums) - 1
        #1) create a while loop
        while ( start <= end ):
            # 2) compute mid value and check if target is there or not (if yes return mid) 
            mid = ( start + end ) // 2
         
            if nums[mid] == target:
                return mid
            #3) if not (Two conditions)
            
            #4) if start element is less than mid element (that means that part of array might be sorted)
                       
            elif ( nums[start] <= nums[mid] ):
                
                #5) and then check if target is between those two element if it is update end to mid (we know were to search)
                if( nums[start] <= target < nums[mid] ):
                    end = mid
             
                else:
                    start = mid + 1   # else element is present after mid element
            
    
            else: 
                # else if target between mid and end update(start to mid +1)
                if ( nums[mid] < target <= nums[end] ): 
                    start = mid + 1
                
                # update end to mid (since target value is before mid)
                else:
                    end = mid

        return -1