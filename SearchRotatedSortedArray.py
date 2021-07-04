
# Time Complexity :O(Log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
def search(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    start = 0
    end = len(nums)-1
    while start <=end:
        mid = (start+end)//2
        if nums[mid] == target:
            return mid
        # if start < end no rotation happened
        if nums[start] < nums[end]:
            if nums[mid] > target:
                end = mid-1
                continue
            else:
                start = mid+1
                continue
        else:
        # if mid > end sorted array on left 
            if nums[mid] > nums[end]:
                # if in sorted part search it else search other part
                if nums[start] <= target<= nums[mid]:
                    end = mid -1
                else:
                    start = mid + 1
                    
            else:
            # if mid < end sorted array on right 
                if nums[mid] <= target <= nums[end]:
                # if in sorted part search it else search other part
                    start = mid + 1
                else:
                    end = mid -1
                
            
    return -1


array = [16,17,18,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
print(search(array,4))