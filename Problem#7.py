# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did you run the code on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach in three sentences only


'''
702. Search in a Sorted Array of Unknown Size
'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution: # humne ek class Solution banayi hai jo ArrayReader ka use karti hai target ko dhoondhne ke liye (we have created a class Solution that uses ArrayReader to find the target)
    def search(self, reader: 'ArrayReader', target: int) -> int: # ye function search karta hai target ko ArrayReader ke through (this function searches for the target using ArrayReader)
        if reader.get(0) == target: # agar pehla element target ke barabar hai, to hum 0 return karte hain (if the first element is equal to the target, we return 0)
            return 0 # agar target 0 index par hai, to hum wahi return karte hain (if the target is at index 0, we return that index)
        
        left = 0 # hum left pointer ko Sorted Unknown Array ke 0th index par set karte hain (we set the left pointer at the 0th index of the Sorted Unknown Array)
        right = 1 # hum right pointer ko Sorted Unknown Array ke 1st index par set karte hain (we set the right pointer at the 1st index of the Sorted Unknown Array)
        while reader.get(right) < target: # jab tak right pointer ka value target se chhota hai, tab tak hum right pointer ko double karte hain (as long as the value at the right pointer is less than the target, we double the right pointer)
            # isse hum ensure karte hain ki right pointer target ke barabar ya usse bada ho jaye (this ensures that the right pointer is either equal to or greater than the target
            # agar right pointer ka value target se bada ho jata hai, to hum left pointer ko right pointer ke barabar set karte hain (if the value at the right pointer becomes greater than the target, we set the left pointer to the right pointer)
            left = right # hum left pointer ko right pointer ke barabar set karte hain (we set the left pointer to the right pointer)
            right *= 2 # hum right pointer ko double times aage karte hain (we double the right pointer to move it further ahead)

        # ab hum binary search ka use karte hain left aur right pointers ke beech mein target ko dhoondhne ke liye (now we use binary search to find the target between the left and right pointers)    
        while left <= right: # jab tak left pointer right pointer se chhota ya barabar hai, tab tak hum search karte hain (as long as the left pointer is less than or equal to the right pointer, we continue searching)
            mid = left + (right - left) // 2 # hum mid index ko calculate karte hain (we calculate the mid index)
            val = reader.get(mid) # mid index par value ko ArrayReader se lete hain (we get the value at the mid index from ArrayReader)
            if val == target: # agar mid index par value target ke barabar hai, to hum mid index return karte hain (if the value at the mid index is equal to the target, we return the mid index)
                return mid # agar target mid index par hai, to hum wahi return karte hain (if the target is at the mid index, we return that index)
            elif val < target: # agar mid index par value target se chhoti hai, to hum left pointer ko mid + 1 set karte hain (if the value at the mid index is less than the target, we set the left pointer to mid + 1)
                left = mid + 1 # hum left pointer ko mid + 1 set karte hain (we set the left pointer to mid + 1)
            else: # agar mid index par value target se badi hai, to hum right pointer ko mid - 1 set karte hain (if the value at the mid index is greater than the target, we set the right pointer to mid - 1)
                right = mid - 1 # hum right pointer ko mid - 1 set karte hain (we set the right pointer to mid - 1)

        return -1 # agar target nahi milta, to hum -1 return karte hain (if the target is not found, we return -1)        
            