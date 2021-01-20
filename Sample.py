"""
**************SEARCH IN A ROTATED SORTED ARRAY**************

APPROACH 1: Iterate approach

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : No


Your code here along with comments explaining your approach """

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # Iterate over the array and if element found return it's index if not return -1
        for i in range(len(nums)):
            if nums[i] == target:
                return i
        else:
            return -1

"""
An Improved version of the above code
APPROACH 1.1: Iterate approach

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : No


Your code here along with comments explaining your approach """

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        maxi = nums.index (max(nums))       #Calculate the maximum element index
        if nums[0] <= target:               
            for i in range(maxi+1):         #if index is leeser then the first element, search in array from starting to minimum index 
                if nums[i] == target:
                    return i
            return -1
        else:
            for j in range(maxi,len(nums)):
                if nums[j]== target:        #if index is greater then the first element, search in array from minimum index to end
                    return j
        return -1                           #if not found return -1


"""
SEARCH IN A ROTATED SORTED ARRAY

APPROACH 2: Binary Search

Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : No


Your code here along with comments explaining your approach """

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low,high = 0,len(nums) -1       
        
        while low <= high:
            mid = ( low + high) // 2        #Calculate the middle element
            
            if nums[mid] == target:         #if middle element found, return its index
                return mid                  
            elif nums[mid] >= nums[low]:       
                """If the middle element is greater than the initial/first element, then the target would be between low to mid
                if target is between low and mid, then search in left part of the array i.e. between low and mid
                else serach in right part of the array i.e. mid to high"""
                
                if nums[low] <= target < nums[mid]: 
                    high = mid - 1  
                else:
                    low = mid + 1
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                    
        return -1



"""
**************SEARCH IN A SORTED ARRAY OF UNKNOWN SIZE**************

APPROACH 1: Binary Search

Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : No


Your code here along with comments explaining your approach """

# class ArrayReader:
#     def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        if reader.get(0) == target:
            return 0                    #if the first element is target return 0 
        slow = 0
        fast = 1

        #Two pointers + windown approach. 
        #if the element is greater than target, the loop exists. 
        #I.e. target is between slow and fast window. 
        
        while (reader.get(fast) < target):
            slow = fast
            fast = fast * 2
                                        
        #Perform Binary serach on the array
        while slow <= fast:
            
            mid = (slow + fast) // 2
            
            if reader.get(mid) == target:
                return mid            
            elif reader.get(mid) > target:
                fast = mid -1
            else:
                slow = mid + 1
        else:
            return -1
            
            
            