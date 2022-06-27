# time complexity: O(log n)- binary search
# space complexity: O(1) - constant space
# Approach : since, the array length is not known.
# set 0 as low and high as 1 and increment high by high *2 
#until we dont come across value greater than target. (value at high)
# since value at high is not greater than target yet,
# we wudnt have come across target, So low can now be changed to high
# this will minimize the search space further
# if target < value at high-break out of loop
# now do normal binary search inside the low and high values.


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while(target > reader.get(high)):
            low = high
            if reader.get(high)==target:
                return high
            high = high * 2
        while(low <= high):
            mid = low + (high - low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid)>=target:
                high = mid - 1
            else:
                low = mid + 1
        return -1