#using binary search 
#first find the mid element, check which side is sorted and go to the sorted side,check if element lies in the range of sorted side,if not go to the other side and repeat the process until you find the element or the base case fails(loop terminates)



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                return mid     
            
            else:
                #check if left side is sorted
                if nums[low]<=nums[mid]:
                    #check if target lies in the range of left side,go to left sub-                     array ,repeat process
                    if nums[low]<=target<nums[mid]:
                        high=mid-1
                    #go to right sub-array,repeat process
                    else:
                        low=mid+1
                else:
                    #right side is sorted
                    #check if target lies in range of right side
                    #if yes then go to the right,repeat process
                    if nums[mid]<target<=nums[high]:
                        low=mid+1
                    #go to the left sub -array,repeat process
                    else:
                        high=mid-1
          
        return -1                
                        
                        
                     