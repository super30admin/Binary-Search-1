
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The idea to find the range to get high pointer was a little tricky


# Your code here along with comments explaining your approach 
class Solution(object):
    def binarySearch(self, low, high, arr, target):
        
        while low <= high:
            mid = low + (high - low)//2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
        
    def search(self, arr, target):
        """
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        
        val = arr[0]
        
        while val < target:    #Check till the time we get a range and a high pointer
            low = high
            high = 2 * high
            val = arr[high]
        
        return self.binarySearch(low, high, arr, target)


s = Solution()
print s.search([-1,0,3,5,9,12],4)