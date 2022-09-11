# Time Complexity : O(log n) because twith every iteration the length of array in which we search reduces to half
# Space Complexity : O(1) constant space is required 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Just base test case was failing of matching the 0th index with target which was managed


# Your code here along with comments explaining your approach : - As we know the max length of array could be so I set the last element to that element and then by using binary search 
# I halved the lenght with every iteration based on target. Also, I had to just add a base case of matching target with 1st element


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        first = 1
        last = 10000
        if reader.get(0) == target:
            return 0
        while first <= last:
            midElement = (first + last) // 2
            if reader.get(midElement) != None:
                if reader.get(midElement) == target:
                    return midElement
                elif reader.get(midElement) < target:
                    first = midElement +1
                elif reader.get(midElement) > target:
                    last = midElement - 1
            else:
                midElement = (first + midElement) // 2
        return -1
        