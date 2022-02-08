#Time Complexity; O(Log(n)) ,as Binary Search is used.
#Space Complexity: O(1), as no extra space is used apart from some variables.
# this code is tested on leetcode.
class Solution:
    def __init__(self) -> None:
        pass
    def search(self, arr: list, target: int):
        end,start = 1,0
        while(arr[end]<=target):
            start = end+1
            end = end * 2 # taking the end element multiplied by 2 until the condition is satisfied
        while start<= end: # performing the normal binary search
            mid = int(start + (end-start)/2)
            if arr[mid] == target:
                return mid
            elif arr[mid]< target:
                start = mid + 1
            else:
                end = mid - 1 
        return -1
        

s= Solution()
nums = [1,2,3,4,5]

print(s.search(nums,4))