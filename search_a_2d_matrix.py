# https://leetcode.com/problems/search-a-2d-matrix/

# Checking the target element is present in the matrix for this first unpack the matrix into signle dimension and iteration over the each list. while iterating through the list used intial checks like if the last element is greater/less than target and contiued the loop accordingly and once we find the row for the target applied the binary search. Complexity O(m + log n)

# leetcode wants O(log(m*n))

class Solution:
    def searchMatrix(self,matrix: list[list[int]], target: int) -> bool:
        # unpacking the matrix into the row
        for row in matrix:
            # best case if the last element is target
            if row[-1] == target:
                return True
            # if last element in the row is smaller than the target it 
            # will not exist in this row; move on to the next row
            elif row[-1] < target:
                continue
            # if first element in the row is greater than the target it 
            # will not exist in this row; move on to the next row
            elif row[0] > target:
                continue

            low = 0
            high = len(row)-1
            
            # apply the binary search
            while low <= high:
                mid = (low + high) // 2
                # if the mid element is target
                if target == row[mid]:
                    return True
                # if the target is less than the mid element shift the pointer to left half
                if target < row[mid]:
                    high = mid - 1
                # if the target is greater than the mid element shift the pointer to the right half   
                else:
                    low = mid + 1
        return False
    
search = Solution()
print(search.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],34))