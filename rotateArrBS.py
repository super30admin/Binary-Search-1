

def search(self, nums: List[int], target: int) -> int:
        """
        Time complexity: Log(n)
        """
        left,right =0,len(nums)-1
        
        #Base case: if nums empty
        if not nums:
            return -1

        if(nums[left]>nums[right]):
            mid = 0
            while left<=right:
                mid = (left+right)//2
                if nums[mid] > nums[mid+1]:
                    break
                elif nums[mid]> nums[-1]:
                    left = mid + 1
                else:
                    right = mid - 1

            if target <= nums[mid] and target >= nums[0]:
                left, right = 0, mid
            elif target >=nums[mid+1] and target <= nums[-1]:
                left, right = mid+1, len(nums)-1
        
        while left<=right:
            mid = (right+left)//2
            if nums[mid]==target: 
                return mid
            elif nums[mid]>target:
                right=mid-1
            else:
                left=mid+1
        return -1