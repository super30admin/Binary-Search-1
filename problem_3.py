#time complexity - O(log(high)) 
#space complexity - O(1) because it uses constant space
#Submit on leetcode - No



class ArrayReader:
    def get(self, index: int) -> int:
        pass


class Solution:
    
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        
        while reader.get(high) is not None and reader.get(high) < target:
            low, high = high, 2 * high

        
        while low <= high:
            mid = low + (high - low) // 2
            mid_val = reader.get(mid) 

            if mid_val == target:
                return mid
                
            elif mid_val < target:
                low = mid + 1
                
            else:
                high = mid - 1
        
        
        return -1

arr_reader = ArrayReader() 
solution = Solution()
ans = solution.search(arr_reader, 10)

if ans == -1:
    print("element is not present in list")
else:
    print("element is present in list at", ans)