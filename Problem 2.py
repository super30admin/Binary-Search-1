class Solution:
    def search(self, nums: List[int], target: int) -> int:
        '''
        mid < right = right part
            
        mid > right = left part
        '''
        if len(nums) == 1: return 0 if nums[0] == target else -1
        left, right = 0, len(nums)-1

        while left <= right:
            mid = (left + right)//2

            if nums[mid] == target: return mid

            if nums[mid] <= nums[right]:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            elif nums[mid] > nums[right]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        '''
         5 6 7 8 9 1 2 3 4 t = 3

        
        '''   
        l, r = 0, len(nums) - 1

        while l <= r:
            mid = (l+r)//2

            if nums[mid] == target: return mid
        
            if nums[mid] <= nums[r]: #mid is in right part
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            else: #mid is in left part
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                
                else:
                    l = mid + 1
        return -1

                
        
        

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       



        #old
        """
        [4,5,6,7,0,1,2]

        if mid < high:#ascending right
            if mid < target:
                low = mid + 1
            
            if mid > target:
                high = mid

        elif mid> high: 6 > 2 
            if mid < target:
                if low < target:
                    high = mid 
                else:
                    low = mid + 1
            
            elif mid > target:
                high = mid

        """
        # edges = 1. len(nums)? 1? 2. numbers unique? 3. max size of nums

        if len(nums) == 1:
            return 0 if nums[0] == target else -1

        low, high = 0, len(nums) - 1

        while low < high:
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid

            
            if nums[mid] < nums[high]: #right is ascending
                if nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid

            elif nums[mid] > nums[high]:
                # if nums[mid] < target:
                if nums[low] < target:
                    high = mid
                
                else:
                    low = mid + 1
                # elif nums[mid] > target:
                #     high = mid
        return -1
                
            

        
        

