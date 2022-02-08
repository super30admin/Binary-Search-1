#Time Complexity; O(Log(n)) ,as Binary Search is used.
#Space Complexity: O(1), as no extra space is used.
# this code is tested on leetcode.
class Solution:
    def search(self, arr: list, target: int) -> int:
        start = 0 # 2 pointers are defined
        end = len(arr) - 1
        
        while start<=end: # breaking condition for while loop
            mid = int (start + (end-start)/2) # calculates mid-value
            if arr[mid] == target: # if the target is the mid value
                return mid
            if arr[mid] <= arr[end]: # if the array is right sorted
                if arr[mid]<= target and target<= arr[end]: # if the element is between mid and end 
                    start = mid+1
                else: 
                    end = mid - 1
            else: # if the array is left sorted
                if arr[start]<= target and target <= arr[mid]: # if the element is between start and mid
                    end = mid - 1
                else:
                    start = mid+1
        return -1

        3,4,5,6,7,1,2