'''
Time Complexity
O(n) if array is already sorted else O(logn) in avrage time complexity

Space Complexity
O(1) no extra space used

Approach
since the array might be rotated so find the pivot index by looping throgh the array 
if pivot found pass the first array and perform binary search 
else perform binary search in the next set of elements in the array
'''



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        rotate_val = len(nums)-1
        x = -1
        y = -1
        for i in range(len(nums)-1):
            if nums[i+1]<nums[i]:
                rotate_val = i
                break
        #print(rotate_val)
        if target>nums[rotate_val]:
            return -1
        elif target<=nums[rotate_val] and target>=nums[0]:
            x = self.BinSearch(nums,0, rotate_val, target)
        elif rotate_val!=len(nums)-1 and target >=nums[rotate_val+1] and target <=nums[-1]:
            y = self.BinSearch(nums, rotate_val+1, len(nums)-1, target)
            
        #print(x)
        #print(y)
            
        if x>y:
            return x
        else:
            return y
        
            
            
            
        # end_val = len(nums)-1
        # while end_val!=rotate_val:
        #     tmp = nums[-1]
        #     for j in range(len(nums)-1, 0,-1):
        #         nums[j+1] = nums[j]
        #     nums[0] = tmp
        #     end_val-=1
        # print(nums)
        
    def BinSearch(self, arr, l, r, target):
        if l<=r:
            mid = (l+r)//2
            if target == arr[mid]:
                return mid
            elif target> arr[mid]:
                return self.BinSearch(arr, mid+1, r, target)
            else:
                return self.BinSearch(arr, l, mid-1, target)
        else:
            return -1
    