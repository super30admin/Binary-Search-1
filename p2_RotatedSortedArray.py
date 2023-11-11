class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        #check if num list exist
        if nums == None:
            return -1

        #set left and right pointers
        l, r = 0, len(nums) - 1

        while l <= r:
            
            #find mid index to compare value with target
            mid = (l + r) // 2

            if nums[mid] == target:
                return mid

            # sorted left half
            if nums[l] <= nums[mid]:
                
                # Checking id target in range to update pointers
                if nums[l] <= target <= nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            
            # sorted right half
            else:
                # Checking id target in range to update pointers
                if nums[mid] <= target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1

        # if search fails           
        return -1 

# ------------------------------------------------------------------------------------------------------------------------ 
# Time complexity: O(logn)