"""
This is an interactive problem.

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

You must write an algorithm with O(log n) runtime complexity.

Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.

"""

# Time Complexity : O(log n)
# Space Complexity : O(1) no extra space used
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

        low = 0
        high = 1
        
        # since it is infinite array, we can set boundaries based on target value
        while(reader.get(high) < target):
            low = high
            high = 2*high
            
        # sorted array so can use binary search
        while(low <= high):

            # mid
            mid = low + (high - low) // 2

            # case 1 target is same as mid
            if(reader.get(mid) == target):
                return mid
            
            # case 2 target greater than mid, value is in right half
            elif(reader.get(mid) > target):
                high = mid - 1

            # case 3 target less than mid, value is in left half
            else:
                low = mid + 1
        
        # target not found
        return -1