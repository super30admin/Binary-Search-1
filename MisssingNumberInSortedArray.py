# // Time Complexity : O(logN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach



def missingNumber(array):
     low = 0
     high = len(array) -1
     
     while (high -low) > 1:
        mid = low + (high-low)//2
        if (array[low] - low) != (array[mid]- mid):
            high = mid 

        elif (array[mid] - mid) != (array[high] - high):
            low = mid

     return array[low]+1

array = [1,3,4,5,6,7,8]

print(missingNumber(array))




    
