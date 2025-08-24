 # given each row is sorted in non-decreasing order 
    # the first integrer of the row is greater than the last integr of the previous row
    # find if the target exisst in the matrix or not
    # obv brust force line search through the whole matix
    # how can i optimize, instead of each row and col to check can we reduce it ?
    # yes how, so we know that the row is sorted so if the first element of the row is less than target and last eklment of the row is greater than the target
    # then we kno our target if exists exsts in this row if not not there 
    # by this we reduced looking at every row , we will only need the row where out target coudl be 
    # hwo to ientify which row it could be , here is where the second condition we know that the row of first element is greater than the previous row
    # so we check if we compare the firstrow the first element vakue is greater than the target means no need to check this row and the next follow up rows, we check the previous row, so we can keep a loop to see if the prev row exist and the next row first eleent is greater then the tagret we iterater over the prev row
    # can we optimize even more, yes, once we found the row where the tagret could be instead of looking at each col , we can perfrom binary search and reduce the search half o the arry 

    # // Time Complexity : binary search on flattened m*n array O(logmn)
# // Space Complexity : no extra space used only low, high, mid variables O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Problem1(object):
    def searchMatrix(self, matrix, target):
        """
       :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        rows = len(matrix) 
        cols = len(matrix[0])

        low = 0
        high = rows*cols -1 # ranging till last element of the matrix

        while (low <= high):
            mid = low + (high - low) // 2

            row = mid // cols  # divide by number of columns to get the row index
            col = mid % cols   # modulo by number of columns to get the column index


            if matrix[row][col] == target:
                return True
            if matrix[row][col] > target:
                high = mid - 1  # eliminate all elements after mid (including mid) in the flattened view
            else:
                low = mid + 1   # eliminate all elements before mid (including mid) in the flattened view

        
        return False





        