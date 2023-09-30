# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity - O(log m) + O(log n) - As binary search is used O(log n) 
# and initially we have incremented the high pointer by 2, so its O(log m)

# Space Complexity - O(1) - No extra auxillary space is being used 

# Approach - Initialize high pointer to index 1 and then increment by 2 to get the biggest number just larger to target
# After low and high is established, binary search is applied to get the index of the target


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0; high = 1
        curr_high = reader.get(high)
        while target > curr_high:
            high = high * 2
            curr_high = reader.get(high)

        # Making sure that the target lies b/w low and high
        # by increasing 2 steps every interation till target < high
        while (low <= high):
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) <= target:
                low = mid + 1
            else:
                high = mid - 1 

        return -1