class Solution:
    def search(self, nums: List[int], target: int) -> int: # [4,5,1,2,3]  target = 4
    # TIME COMPLEXITY: O(Log n)
    # SPACE COMPLEXITY: O(1)
        def binary(s,e,target):
            while s <= e:
                mid = (s+e) // 2
                if target < nums[mid]:
                    e = mid - 1
                elif target > nums[mid]:
                    s = mid + 1
                else:
                    return mid
            return -1
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = (start + end) // 2
            # print("mid", mid)
            if nums[start] <= nums[mid]:
                if target >= nums[start] and target <= nums[mid]:
                    # print("First half")
                    return binary(start, mid, target)
                else:
                    # print("Failed Target Cond")
                    start = mid + 1
                    continue
            elif nums[mid] <= nums[end]:
                if target >= nums[mid] and target <= nums[end]:
                    # print("Second half")
                    return binary(mid, end, target)
                else:
                    # print("Failed Target Cond")
                    end = mid - 1
                    continue
        return -1