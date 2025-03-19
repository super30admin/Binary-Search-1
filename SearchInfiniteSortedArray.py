# Time Complexity : O(log2 n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No I donot have access to leetcode premium
# Any problem you faced while coding this : No

# class SearchInfiniteSortedArray:
def SearchInfiniteSortedArray(nums: List[int], target:int) -> int:
        low = 0
        high = 1
        while nums[high] < target:
            low = high
            high = high*2
            
        while(low<=high):
            mid = low+(high-low)//2
            if(nums[mid]== target):
              return mid
            elif(nums[mid] > target):
                high = mid -1
            else:
                low = mid+1
        return -1

# SearchInfiniteSortedArray = SearchInfiniteSortedArray()
nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
target = 5
index1 = SearchInfiniteSortedArray(nums, target)
print(index1) # 4

target = 1 
index3 = SearchInfiniteSortedArray(nums, target)
print(index3) # 0  
target = 21
index2 = SearchInfiniteSortedArray(nums, target)
print(index2) # -1          


# def binary_search(arr, low, high, key):
#     while low <= high:
#         mid = (low + high) // 2
#         if arr[mid] < key:
#             low = mid + 1
#         elif arr[mid] > key:
#             high = mid - 1
#         else:
#             return mid
#     return -1

# def search_infinite_sorted_array(arr, key):
#     low = 0
#     high = 1
#     while arr[high] < key:
#         low = high
#         high = 2 * high
#     return binary_search(arr, low, high, key)

# # Example usage:
# arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170]
# key = 130
# index = search_infinite_sorted_array(arr, key)
# if index != -1:
#     print(f"Element {key} found at index {index}")
# else:
#     print(f"Element {key} not found in the array")