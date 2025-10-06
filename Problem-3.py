
# Time Complexity : O(log(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : NA(Premium program)
# Any problem you faced while coding this : NA
def search( arr, target: int) -> int:
        # Approach: Expand the search boundary exponentially until 'high' is greater than target
        low, high = 0, 1 
        while arr[high]< target:
            low =high
            high*=2
        while(low<=high):
                mid = (low+high)//2 # Calculate mid index
                # Check if the mid element matches the target
                if arr[mid]==target: 
                    return mid
                 # If mid element is smaller than target, search the right half
                elif arr[mid]< target:
                    low= mid+1
                
                # If mid element is greater than target, search the left half
            
                else:
                    high = mid -1
        # Target not found            
        return -1
        
                    
                


print(search([1,3,4,5,6,7,8,34,67,89,100,237, 268, 300,344, 566,799,800], 11))