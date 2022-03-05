'''
// Time Complexity : O(log(I) I is index of target)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took hints to solve this problem


// Your code here along with comments explaining your approach

1. Start with left=0 and right =1 check target falls into this range
    - If target in this range do a binary search 
        - else :
            move left = right and right = right *2 
            and repeat

'''
class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
        
        # search boundaries
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right <<= 1
        
        # binary search
        while left <= right:
            pivot = left + ((right - left) >> 1)
            num = reader.get(pivot)
            
            if num == target:
                return pivot
            if num > target:
                right = pivot - 1
            else:
                left = pivot + 1
        
        # there is no target element
        return -1        
