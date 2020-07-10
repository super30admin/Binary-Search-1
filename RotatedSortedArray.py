# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Iterative Solution
class Solution:

    def search(self, nums: List[int], target: int) -> int:

        #Intializing the left and right values which is start and end, In python we can give this by 0(start) and len(nums)-1 (end)
        left = 0
        right = len(nums) - 1

        #If this case fails means we reached end of the list and no numbers to search and we will return -1
        while left <= right:
            #Calculating mid => this way of calculting mid will prevent overflow.
            mid = left + (right - left) // 2

            #If mid is the target we will return it
            if nums[mid] == target:
                return mid

            #If this case pass - means it is left sorted else it is right sorted
            if nums[left] <= nums[mid]:

                # If this case pass - means the target is between this left and mid and we convert it to new range by keeping the left same and right to mid -1
                #Else vice versa of it
                if nums[left] <= target <= nums[mid]:

                    right = mid - 1

                else:

                    left = mid + 1
            else:

                # If this case pass - means the target is between this Right and mid and we convert it to new range by keeping the Right same and left to mid +1
                # Else vice versa of it
                if nums[right] >= target >= nums[mid]:

                    left = mid + 1
                else:

                    right = mid - 1

        return -1


# Recursive

# Time Complexity : O(log(n))
# Space Complexity : O(n) - I have no clear explanation about this. This is just a random guess.please give me the explanation for this. Thanks.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No



#Instead of while loop we will do recursive function

class Solution2:

    def search(self, nums: List[int], target: int) -> int:

        return self.binarySearch(nums, 0, len(nums) - 1, target)

    def binarySearch(self, nums, left, right, target) -> int:

        if left > right:
            return -1

        mid = left + (right - left) // 2

        if nums[mid] == target:
            return mid

        if nums[left] <= nums[mid]:

            if nums[left] <= target <= nums[mid]:

                right = mid - 1

            else:

                left = mid + 1


        else:

            if nums[right] >= target >= nums[mid]:

                left = mid + 1

            else:

                right = mid - 1

        return self.binarySearch(nums, left, right, target)
