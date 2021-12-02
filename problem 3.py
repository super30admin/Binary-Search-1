# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :YES

class Solution:
    def search(self, reader, target):
        # length atleast 1 given in contrains 
        low=0
        high=0
        # standard binary search checking
        while(low<=high):
            # finding mid
            mid=(low+high)//2
            # check if the element is found return index if true
            if target==reader.get(mid):
                return mid
            else:
                # check if target is greater than move low mid+1 and high low*2 reverse binary search kind of approach  move right
                if target>reader.get(mid):
                    low=mid+1
                    high=2*low
                else:
                    # if target less than mid than high mid-1 standard binary search approach move left
                    high=mid-1
        # element not found return -1 given in contrains 
        return -1
        