# // Time Complexity : O log (N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : figuring out the greater than eauL or just greater than in the line 19


# // Your code here along with comments explaining your approach in three sentences only
# WE CHECK IF LEFT IS SORTED (INCREASING CONTIOUSLY), IF IT IS IF MAKE SURE TARGET IS IN THE RANGE,
# IF NOT WE DISACRD THE LEFT HALF, IF IT IS DICARD RIGHT HALF. IF LEFT IS NOT SORTED THEN WE KNOW THAT
# RIGHT IS SORTED ,WE THEN JUST HAVE TO MAKE SURE TARGET IS THERE IN THE HALF AND AGAIN NARROW SEARCH SPACE.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1

        while l <= r:
            m = (l + r)//2

            if target == nums[m]:
                return m

            elif nums[l] <= nums[m]:
                # WE KNOW LEFT IS SORTED (INCREASING)
                if nums[l] <= target <= nums[m]:
                    # TARGET BELONGS IN THE SORTED PART
                    r = m - 1
                else:
                    # DISCARD LEFT SIDE ENTIRELY SINCE TARGET CANNOT POSSIBLE LIE HERE
                    l = m + 1
            else:
                # WE KNOW RIGHT IS SORTED (INCREASING)
                if nums[m] <= target <= nums[r]:
                    # TARGET BELONGS IN THE SORTED PART
                    l = m + 1
                else:
                    # DISCARD LEFT SIDE ENTIRELY SINCE TARGET CANNOT POSSIBLE LIE HERE
                    r = m - 1
        return -1
