#Time Complexity: O(log n)
#Did the Code run on leetcode: Yes It passed all the test cases in leetcode.
#Did you face any problem: Had to do trail and error for finding the which side of the sorted array to choose.



class Solution:
    def search(self, nums, target: int) -> int:
        l = 0
        high = len(nums) - 1
        while (l <= high):
            #Finds the mid index
            mid = l + (high - l) // 2
            if nums[mid] == target:
                return mid
            #left sorted array
            elif (nums[l] <= nums[mid]):
                #check if the value is in the range of the left sorted array
                if (nums[l] <= target and mid > target):
                    #if yes then move the search to the left part of the array
                    high = mid - 1
                else:
                    #if no then search in the right part of the array.
                    l = mid + 1
            else:
                #right sorted array
                #find if the target is in the range of the right sorted array
                if (nums[high] >= target and nums[mid] <= target):
                    #change the search to the right part of the array
                    l = mid + 1
                else:
                    #change the search to the left part of the array
                    high = mid - 1

        #if there are no values found then return -1
        return -1

