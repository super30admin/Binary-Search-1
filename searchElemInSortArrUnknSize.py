#Time Complexity :  log(n) + log(k) or which ever is greater of the two that is log(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0                                             #using two pointers
        high = 1
        while reader.get(high) < target:                    #value at high < target
            low = high                                      #move low to high position
            high = 2*high                                   #high is incremented 2 times
        
        while low <= high:                                  #once we find the exact range between which our target lies we do Binary search
            mid = low + (high-low)//2                       #calculating mid
            if reader.get(mid) == target:                   #if mid is target we return mid
                return mid
            elif target < reader.get(mid):                  #if target is less than mid change high pointer to mid - 1
                high = mid - 1
            else:
                low = mid + 1                               #else change low pointer to mid + 1
        return -1                                           #if target not found we return -1