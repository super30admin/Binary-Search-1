#Time Complexity  : O(logn)
# Space Complexity : O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0;
        end = len(nums)-1;
        mid = 0;
        
        while(start <= end):
            mid = start + (end - start)//2;
            if target == nums[mid]:
                    return mid

            if (nums[start] <= nums[mid]): #sorted
               # sorted array , do binary search and find the target
                if( nums[start] <= target and nums[mid] > target):
                    end = mid-1;
                else:# target will be in unsorted region
                    start = mid+1;
            
            
            else:    #unsorted array
                if(nums[end] >= target and nums[mid] < target ):
                    start = mid+1;
                else:
                    end = mid-1;
        return -1