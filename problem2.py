# Time Complexity : O(log(m * n)) where m is the number of rows and n is the number of columns, log because each comparison reduces the search space by half
# Space Complexity : O(1) as no extra space was used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I tried brute force first by traversing the entire matrix but that was O(m * n) time complexity, used binary search and Raj's sir approach. 


# Your code here along with comments explaining your approach in three sentences only 
# Search 2D Matrix
# I used binary search to find the target in the 2D matrix. I imagine the 2D array as 1D array and find the mid and then 
# I find the row and column of the mid element using mathematical operations (mid // n and mid % n) and then apply binary search on the row and column