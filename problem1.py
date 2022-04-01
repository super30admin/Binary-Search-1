# Search a 2D Matrix


# // Time Complexity :O(Log (m*n))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def searchMatrix( matrix, target) -> bool:
    if len(matrix)==0 or matrix==None:
        return False
    row = len(matrix)
    col= len(matrix[0])
    low=0
    high=(row*col)-1
    while(low<=high):
        mid = low +(high-low)//2            #find the mid index as if the array was 1d
        r = mid//col                        #to find the row, you just need to divide the index by the number of elements in the column
        c = mid%col                         #to find the column, you just have to mod the index by the number of elements in the column
        if(matrix[r][c] == target):         #then just regular binary search
            return True
        elif(matrix[r][c] < target):
            low=mid+1
        else:
            high=mid-1
        
    return False

#testing
print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3))