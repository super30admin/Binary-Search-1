# Search in a 2D matrix:

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        try:
            length = len(matrix[0])
            counter1, counter2 = 0, length-1
            while True:
                if matrix[counter1][counter2] == target:
                    return True
                elif matrix[counter1][counter2]>target:
                    counter2-=1
                    continue
                counter1 = counter1 + 1
                if counter1 >= len(matrix) or counter2<0:
                    return False
        except:
            return False
        
        class Solution:
            
    '''
    # Solution from Jaspinder (translated to Python3) - not working in leetcode, please revert why
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        try:
            if matrix == None or len(matrix) == 0: return False
            m = len(matrix); n = len(matrix[0])
            low = 0; high = m*n - 1

            while low <= high:
                mid = low + (high - low)//2
                row = mid//m; col = mid%n

                if target == matrix[row][col]: return True
                elif matrix[row][col] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return False
        except:
            return False
    '''
        
# Problem: search in rotated sorted array (using binary search)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)
        while low<high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            if nums[low]<=nums[mid]:
                if target >=nums[low] and target <nums[mid]:
                    high = mid
                else:
                    low = mid+1
            else:
                if target<=nums[high-1] and target>nums[mid]:
                    low = mid+1
                else:
                    high = mid
        return -1

# Search element in infinite array using binary search
# assume the array is infinite, means no out of bound error?
# assume that the element is always present in the array to return a valid position

class Solution:
    
    def SearchElement(arr, value):

        low = 0; high = 1 # starting to search
        '''
        to find a subarray (identified by start and end indices in a given array)
        containing the value and call binary search within the subarray
        '''

        if value == arr[0]:
            return 0
        else:
            while arr[high] < value:
                low = high
                high = high*2 if high < 10000 else 10000 # given in the question, the highest index as 10000

        found = False
        position = -1
        mid = low + (high - low)//2   

        while low <= high:
            if arr[mid] == value:
                found = True
                position = mid
                break

            if value > arr[mid]:
                low = mid + 1
                mid = low + (high - low)//2
            else:
                high = mid - 1
                mid = low + (high - low)//2

        return position    
