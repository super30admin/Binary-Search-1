class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        #Initializing low and high index values of the array
        low = 0;
        high = len(nums)

        #Looping over until low index is less than high index value
        while low< high:
            #Calculating the mid index
            mid = (low + high) //2

            #If value at mid index equal to target return value at mid index
            if nums[mid] == target:
                return mid
            #If target value between low and mid index update low and high
            elif nums[low] <= nums[mid]:
                if target >= nums[low] and target <= nums[mid]:
                    high = mid
                else:
                    low = mid+1
            #If target value between mid and high index update low and high
            else:
                if target >= nums[mid] and target <=nums[high-1]:
                    low = mid +1
                else:
                    high = mid
        return -1


#Implementing the rotated sorted array using binary search with time complexity O(logn)
