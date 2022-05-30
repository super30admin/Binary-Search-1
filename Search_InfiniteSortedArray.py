class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
        
    
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right *=2
        

        while left <= right:
            mid = left + ((right - left) //2)
            ele = reader.get(mid)
            
            if ele == target:
                return mid
            if ele > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return -1
'''
All test cases passed on Leetcode
Time Complexity : O(logT) ; T is the target variable
Space Complexity : O(1)

'''
