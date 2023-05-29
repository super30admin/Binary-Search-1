# Time Complexity : O(Logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA


# Approach is to move the left pointer to mid+1 if mid is lesser than target and move the high to mid-1 if the target is lower than mid.

class Solution:
    def search(self, reader, target):
        l=0
        h=10001
        while(l<=h):
            m=l+(h-l)//2
            if(reader.get(m)== target):
                return m
            elif(reader.get(m)<target):
                l=m+1
            else:
                h=m-1
        return -1

