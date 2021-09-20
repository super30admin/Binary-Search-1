class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        # Edge case
        #Check if length of array is 0 or elemts are None
        if(nums== None or len(nums)==0):
            return -1
        # Base case
        while(low<=high):
            middle=low+((high-low)//2)
            if (target==nums[middle]):
                return middle
                print("middle", middle)
            print(nums[low])
            print(nums[middle])
            #logic case
            #Condition to check if left side is sorted. Else block will be executed if right side is sorted
            if (nums[low] <= nums[middle]):
                if(target>= nums[low] and target <= nums[middle]):
                    high=middle-1
                else:
                    low=middle+1
            #if right side is sorted
            else:
                if(target> nums[middle] and target <= nums[high]):
                    low=middle+1
                else:
                    high=middle-1
        return -1
            
               
            
            
        

        