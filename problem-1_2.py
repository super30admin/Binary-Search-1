#TIme Complexity: O(logn) where n is the length of the input array
#Space Complexity: O(1)
#Code ran successfully on leetcode
#Faced no problems while code

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        #here we are taking left and right values to be 0 and lenght of the array-1
        self.left=0
        self.right=len(nums)-1
        #checking whether the array is empty or not
        if(len(nums)==0):
            return -1
        #if the array is not empty
        else:
            while(self.left<=self.right):
                #Here we are calulating the mid value
                self.mid=(self.left+self.right)//2
                #if the value at the mid index matches the target, we will return mid value
                if(nums[self.mid]==target):
                    return self.mid
                #if the nums[left]<=nums[mid] which means the values at the left side are sorted
                elif(nums[self.left]<=nums[self.mid]):
                    #if the taget is present in between those indexes
                    if(nums[self.left]<=target<nums[self.mid]):
                        self.right=self.mid-1
                    #if the target is not present between the indexes
                    else:
                        self.left=self.mid+1
                #if the values on the right hand side are sorted
                else:
                    #if the target value is present between mid and right index
                    if(nums[self.mid]<target<=nums[self.right]):
                        self.left=self.mid+1
                    #if the target value not present between mid and right index
                    else:
                        self.right=self.mid-1
            #if the searched value is not present in the array
            return -1
