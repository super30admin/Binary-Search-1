# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
1. Since the maxsize was 10*4 let us put the right index to 9999. If the target is found at index 0, return 0
2. Calculate mid and check if its equal to target. If not, check which side the element lies and modify the left or right pointers accordingly
3. Repeat until left<=right or target is found and return the index or -1
'''

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0
        right = 9999
        if reader.get(left) == target:
            return 0
        while(left<=right):
            mid = left+ (right-left)//2
            mid_ele = reader.get(mid)
            right_ele = reader.get(right)
            left_ele = reader.get(left)
            if mid_ele  == target:
                return mid
            if mid_ele < target <= right_ele:
                left = mid+1
            else:
                right = mid-1
            if left_ele <= target < mid_ele:
                right = mid-1
            else:
                left = mid+1
        return -1