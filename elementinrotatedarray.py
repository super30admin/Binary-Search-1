class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # so here in an array we know that one part of the arrray is sorted and the other part of the array is not sorted .      
        # this is just am extension of binary search and we need three pointer low, mid, high (just like binary search
        
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
        # we need to keep traversing until the low pointer traverses the high pointer, i.e low should always will be less than or equl to high

                #checking if the middle element is the target, if yes, then return the index
            if nums[mid]==target:
                return mid
            elif (nums[low]<=nums[mid]): #we are checking if the left side is sorted first, for that, low                                                                                    will always be less than mid ex ->[4,5,6,7,8,9,0,1,2]
                if(nums[low]<=target and nums[mid]>=target):# this means element 
                    high=mid-1          #is lying in first half, so bring the high pointer to mid-1
                else:
                    low=mid+1 #else its lying the other half, incremenr the low pointer
            else: #now its not the middle element, nor the left side is sorted,we check on the right side [6,7,0,1,2,3,4,5]
                if(nums[mid]<=target and nums[high] >=target): 
                    low=mid+1
                else:
                    high=mid-1
        return -1