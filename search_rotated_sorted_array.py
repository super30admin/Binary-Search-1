class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) <= 3:
            return nums.index(target) if target in nums else -1
        
        def find_pivot(arr):
            for i in range(len(arr) -1):
                if arr[i] > arr[i+1]:
                    return i
                    break
            return -1
        
        pivot = find_pivot(nums)
        
        def find_element(arr, start, end):
            
            if start <= end:
                mid = (start+end) // 2
                if arr[mid] == target:
                    return mid
                elif arr[mid] < target:
                    return find_element(arr, mid+1, end)
                elif arr[mid] > target:
                    return find_element(arr, start, mid - 1)
            else:
                return -1
        
        res_1 = find_element( nums, 0, pivot)
        res_2 = find_element( nums, pivot+1, len(nums)-1)
        
        print(pivot)
        print(res_1)
        print(res_2)
        if res_1 != -1:
            return res_1
        else:
            return res_2
        