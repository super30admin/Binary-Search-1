
#Time complexity= O(logn)
#Space Complexity=O(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        #determine the length of the array using binary search 
        left=0
        right=1
        while reader.get(right)<target:
            left=right
            right <<=1
                
        #perform binary search untill the left point crosses the right pointer 
        while left<=right:
             # calculate the index of the middle element is the target, return its index
            middle=(left+right)//2
            middle_value=reader.get(middle)
            if middle_value==target:
                return middle
            # check if the target is on the right side of the matrix
            if middle_value>target:
                right=middle-1 #update the right pointer to find the target
            else:
                left=middle+1 #other wise update the left pointer to find the target
        return -1
        