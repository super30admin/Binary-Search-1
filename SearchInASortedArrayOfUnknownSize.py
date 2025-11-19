'''
In this problem, a sorted array of unique secret elements, I used 2 pointer low and high.
initial values of low is 0 and high is 1, and I doubled the high value as long as its value is less than target value
then I compared the target to my mid value and if its equal I returned my mid value, if its less then I moved my high pointer ro mid -1
if its greater low pointer to mid+1
'''
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        # updating the values of low and high pointers
        while reader.get(high) < target:
            low = high
            high = high * 2
        
        while low <= high:
            mid = (low+high)//2
            # if mid value is same as target return the mid value
            if reader.get(mid) == target:
                return mid
            # if mid is greater than target move the high pointer to mid-1
            elif reader.get(mid) > target:
                high = mid - 1
            # else move low to mid+1
            else:
                low = mid + 1
        return -1

'''
Time Complexity: O(log n)
Space Complexity: O(1)
'''