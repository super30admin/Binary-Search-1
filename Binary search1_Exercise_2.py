# Binary search - 1

// Time Complexity : O(log N)  ??
// Space Complexity : O(1) constant time complexity?
// Did this code successfully run on Leetcode : No link. NOT giving result in jupyter notebook.
// Any problem you faced while coding this : Not sure of time and space complexity


// Your code here along with comments explaining your approach - 
1. Define a function for binary search with start index, end index.
2. Use a while loop. Calculate the middle index (ensure it doesn't go beyond the bounds).
3. If middle is the target, return the same.
4. If number in left of middle, shift bounds to left-hand side (end is shifted). Else, shift it to right-hand side (start to middle +1).
5. To determine bounds with an array of size

def binarySearch_function(nums,start,end,target): 
  
    while start <= end: 
        middle = start+(end-start)//2
  
        if nums[middle] == target: 
            return middle 
  
        elif nums[middle] > target: 
            #return binarySearch_function(nums,start,middle-1,target)
            end = middle-1
            continue
        
        else:
          #return binarySearch_function(nums,middle+1,end, target) 
            start = middle+1
            continue
  
    return -1
  
def locate(nums, target): 
  
    size, initial_value = 1, nums[0] 
  
    while initial_value < target: 
        left = size              # store previous cycle's right 
        right = 2*size           # consider double size
        return binarySearch_function(nums, left, right,target) 
        initial_value = arr[left]       # update value and size for next cycle 
        size = right

locate([1,2,3,4,5,6,6,7,8], 1)  
