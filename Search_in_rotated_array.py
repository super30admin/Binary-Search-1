from typing import List
class Solution:

    def find_pivot(self,Arr: List[int])->int:
        low=0
        high=len(Arr)-1
        last_element=Arr[-1]
        while low<=high:
            pivot_index=(low+high)//2
            if Arr[pivot_index]>last_element:
                if Arr[pivot_index]>Arr[pivot_index+1]:
                    return pivot_index
                low=pivot_index+1
            else:
                high=pivot_index-1

        return len(Arr)-1


    def search(self, nums: List[int], target: int) -> int:
        pivot_element= self.find_pivot(nums)
        last_element=nums[-1]
        if pivot_element==len(nums)-1:
            low=0
            high=len(nums)-1
        else:
            if target<last_element:
                low=pivot_element+1
                high=len(nums)-1
            elif target>last_element:
                low=0
                high=pivot_element
            else:
                return len(nums)-1

        while low<=high:
            mid_point=(low+high)//2
            if nums[mid_point]==target:
                return mid_point
            elif nums[mid_point]>target:
                high=mid_point-1
            else:
                low=mid_point+1
        return -1
