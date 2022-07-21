# Time Complexity : O(log (T-i)) where T is the target value and i is the value of the first element. Please note that i can be negative as well.
# Space Complexity : O(1) as we don't store any data other than basic O(1) variables. 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0
        
        low = 0
        high = target-reader.get(0)
        # The array is said to be sorted in ascending order. The worst or the highest index target can acheieve is 
        # target - first element in the array. This happens when all the possible elements between first element and target are present in the array 
        
        # Now we perform binary search starting with 0 as low and target-reader.get(0) as high
        while(low <= high):
            mid = low + (high-low) // 2 # Calculate mid element
            if reader.get(mid) == target:
                return mid  # Return mid if target is the mid element
            elif target < reader.get(mid):
                high = mid-1 # If target is less than mid element its in left half of mid
            else:
                low = mid+1 # If target is more than mid element its in right half of mid
        return -1 # Returns -1 if element is not found above