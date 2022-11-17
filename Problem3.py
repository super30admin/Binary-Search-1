#Time complexity:
# O(log(n)) where n is the total number of elements in the array (for setting the bounds)

#Space complexity:
# O(1) - no extra space used

#Unable to submit on leetcode as this is a premium question

#Approach: First set upper and lower bounds by incrementing in powers of two
# lower and upper bounds will be set between floor (log(n)) and floor ((log(n)))+1
# Execute binary search between these two indices
# No need to handle out of bounds case because array reader will give infinity in case of out of bounds

class Solution:
            
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1

        
        low = 0
        high = 1

        #setting bounds

        while self.arrayReader(nums, high) < target:
            low = high
            high = high * 2
        
        #bounds have been found
        while low <= high:
            mid = (low + high) // 2
            midElem = self.arrayReader(nums, mid)

            if midElem == target:
                return mid
            else:
                if midElem < target:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1

        

#array reader self-created
    
    def arrayReader(self, A, index):
        try:
            return A[index]
        except IndexError:
            return float('inf')
                    
                    
        
        
        
        
        
