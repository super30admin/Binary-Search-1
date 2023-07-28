#Time Complexity:O(logN)
#space complexity:O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left=0
        right=len(nums)-1
       
       # Perform binary search until the left pointer crosses the right pointer
        while left<=right:
            middle=(left+right)//2 # Calculate the middle index of the current range
            if nums[middle]==target: # If the middle element is the target, return its index
                return middle
             # Check if the left half of the range is sorted
            elif nums[middle]>=nums[left]:
            
            # If the target falls within the sorted left half, update the right pointer
                if target>=nums[left] and target<nums[middle]:
                    right = middle-1
                else:# Otherwise, update the left pointer to search in the unsorted right half
                    left=middle +1 
              # If the right half of the range is sorted
            else:
             # If the target falls within the sorted right half, update the left pointer

                if target<=nums[right] and target>nums[middle]:
                    left=middle+1
                else: # Otherwise, update the right pointer to search in the unsorted left half
                    right=middle-1
        # If the target is not found in the array, return -1    
        return -1

        