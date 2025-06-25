# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did you run the code on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach in three sentences only


'''
74. Search a 2D Matrix
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]: # hum check karte hain agar matrix khali hai ya pehli row khali hai
            return False # agar khali hai toh hum False return karte hain
        m = len(matrix) # hum matrix ki rows ki sankhya ko m mein store karte hain (we store the length of the matrix or length of columns in m)
        n = len(matrix[0]) # hum pehli row ki columns ki sankhya ko n mein store karte hain (we store the length of the first row or length of rows in n)

        # ab hum binary search ka istemal karte hain (we use binary search)
        left = 0 # hum left ko 0 se initialize karte hain (we initialize left to 0)
        right = m * n - 1 # hum right ko m * n - 1 se initialize karte hain (we initialize right to m * n - 1)
        while left <= right: # jab tak left chhota ya barabar hai right se (while left is less than or equal to right)
            middle = (left + right) // 2 # hum middle ko left aur right ka average lete hain (we calculate the middle index)
            idx_row = middle // n # hum middle ko n se divide karke row index nikaalte hain (we find the row index)
            idx_col = middle % n # hum middle ko n se modulo karke column index nikaalte hain (we find the column index)
            if matrix[idx_row][idx_col] == target: # agar matrix ke is index par value target ke barabar hai (if the value at this index in the matrix is equal to the target)
                return True
            else: # agar nahi hai (if not)
                if matrix[idx_row][idx_col] < target: # agar matrix ke is index par value target se chhoti hai (if the value at this index in the matrix is less than the target)
                    left = middle + 1 # toh hum left ko middle + 1 karte hain (we move left to middle + 1)
                else: # agar matrix ke is index par value target se badi hai (if the value at this index in the matrix is greater than the target)
                    right = middle - 1 # toh hum right ko middle - 1 karte hain (we move right to middle - 1)
        return False # agar hum while loop se bahar nikalte hain, toh iska matlab target nahi mila (if we exit the while loop, it means the target was not found)