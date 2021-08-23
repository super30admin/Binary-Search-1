class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        arr = nums
        low = 0
        high = len(nums)-1

        while(low<=high):
            
            mid = (low + high)//2
            
            if(arr[mid] == target):
                
                return mid
            
            elif(arr[low] < arr[mid]):
                
                if(arr[low] <= target and arr[mid] > target):

                    high = mid - 1

                else:

                    low = mid + 1

            else:
                
                if(arr[low] <= target and arr[mid] >= target):
                    
                    low = mid + 1
                    
                else:
                    
                    high = mid - 1
                
        return -1        