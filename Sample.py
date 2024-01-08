# Search in 2D Matrix

# // Time Complexity : O(log(m*n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach in three sentences only


# Do binary search on the matrix. Get row and col using division and modulus operators.
def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:  
    N = len(matrix)
    M = len(matrix[0])

    start = 0
    end = M*N - 1

    while start <= end:

        mid = (start + end) // 2
        row = mid // M 
        col = mid % M 
        
        currEle = matrix[row][col]

        if currEle == target:
            return True 
        elif currEle < target:
            start = mid + 1
        else:
            end = mid - 1

    return False



# Search in Rotated Sorted Array

# // Time Complexity : O(log N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach in three sentences only


# Check which part is sorted and then update accordingly.
def search(self, nums: List[int], target: int) -> int:
        left = 0 
        right = len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid 
            elif nums[mid] <= nums[right]:
                if nums[mid] <= target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                if nums[left] <= target <= nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1 