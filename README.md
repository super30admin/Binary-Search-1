# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

// Time Complexity : O(log m + log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Keeping track of what is been returned by which element was hard.


// Your code here along with comments explaining your approach: Did a row based binary search to find if the target's reange exsisted within the matrix then performed a binary search in a specific row if the target's range was present.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        
        top = 0
        bot = ROWS-1
        // Loop for ffinding specific row 
        while top <= bot:
            mid = (top + bot) // 2
            if matrix[mid][COLS-1] < target :
                top = mid + 1
            
            elif matrix[mid][0] > target:
                bot = mid -1 
                
            else:
                break
        // loop to find target        
        l, r = 0 , COLS-1
        while l <= r:
            m = (l + r) //2
            
            if matrix[mid][m] == target:
                return True
            elif matrix[mid][m] > target:
                r = m -1
            else:
                l = m + 1
        return False
        

            
        

## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : the idea was hard to learn until being taught in class.

// Your code here along with comments explaining your approach: Comparing the middle element to its ends to see if the sorted order matches and then finding if the target is present in the list is the concept

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        self.low = 0
        self.high = len(nums) -1 
        while self.low <= self.high:
            self.mid = self.low + (self.high - self.low) // 2 
            
            if nums[self.mid] == target:
                return self.mid
            //reduces search space by half whenever the condition fails
            elif nums[self.low] <= nums[self.mid]:
                if target >= nums[self.low] and target < nums[self.mid]:
                    self.high = self.mid -1

                else:
                    self.low = self.mid +1

            else:
                if target > nums[self.mid] and target <= nums[self.high]:
                    self.low = self.mid +1
                
                else:
                    self.high = self.mid -1
        return -1

            
            


## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: The mid element is compared with the target if the target's range is greater then the size of the array reader is increased by twice. If still the target is not equal to mid then we return -1


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        self.low = 0
        self.high = 1
        while self.low <= self.high:
            self.mid = self.low + (self.high-self.low) //2
        
            if reader.get(self.mid) == target: return self.mid
            if reader.get(self.mid) < target:
                self.low = self.mid +1
                self.high = 2*self.high

            else:
                while self.low <= self.high:
                    self.mid = self.low + (self.high-self.low) //2
                    
                    if reader.get(self.mid) == target: return self.mid
                    
                    if reader.get(self.mid) > target:
                        self.high = self.mid-1 
                    else:
                        self.low = self.mid +1

                return -1
                
                    
                

