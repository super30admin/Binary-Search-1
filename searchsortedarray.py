class Solution:
    def search(self, reader, target):
        low = 0
        high = 1
        
        while reader[high] < target:
            low = high
            high = 2 * high
        
        while low <= high:
            mid = low + (high - low) // 2
            if reader[mid] == target:
                return mid
            elif reader[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1



reader = [1, 3, 5, 7, 9, 11, 13, 15]
target = 7
sol = Solution()
result = sol.search(reader, target)
print("Index of the target value:", result)
