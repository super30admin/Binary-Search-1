#Time Complexity; O(Log(n)) ,as Binary Search is used.
#Space Complexity: O(1), as no extra space is used apart from some variables.
# this code is tested on leetcode.
class Solution:
    def searchMatrix(self, arr: list, target: int) -> bool:
        m = len(arr) # number of rows
        n = len(arr[0]) # number of columns
        start = 0
        end = (m*n) - 1
        while(start<=end):
            mid = int(start + (end-start)/2)
            i,j = int(mid/n), int(mid%n) # calculating the 2 indices as per imagining the 2D matrix in a straight array

            if arr[i][j] == target: # applying the binary search
                return True # if the element is present
            elif arr[i][j]> target:
                end = mid + 1
            else:
                start = mid - 1
        return False # if the element is not present.



s = Solution()
nums = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
print(s.searchMatrix(nums,4))
