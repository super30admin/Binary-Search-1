
// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes(Geeks fo Geeks)
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

##Problem:  Suppose you are given a sorted array of unknown length and a number to search for, return the index of the number. 
##Accessing an element out of bounds throws exception. 
##If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1. 


Code:


def infsearch(nums,target):
    low = 0
    high = 1
    while(target > nums[high]): ##Check for if target is greater than value at high pointer
        low = high
        high = 2 * high
        
    while(low <= high):
        mid = low + (high - low) // 2
        if (target == nums[mid]):
            return mid ##if value is found at mid. return mid.
        else:
            if (target < nums[mid]):    
                high = mid - 1
            else:
                low = mid + 1
    return -1 ##if value is not found return -1

# Driver function 
arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170] 
ans = infsearch(arr,111) 
if ans == -1: 
	print "Element not found"
else: 
	print"Element found at index",ans 


