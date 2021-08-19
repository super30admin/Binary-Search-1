# Did this code successfully run on Leetcode : YES

class Solution:
	def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
		m, n= len(matrix), len(matrix[0])
		# for x in range(m):
		#     for y in range(n):
		#         if matrix[x][y] == target:
		#             return True
		# return False
		
#         def binary_search(array, target):
#             start = 0
#             end = len(array)-1
#             mid = (start + (end - start)//2)
#             while start <= end:
#                 mid = (start + (end - start)//2)
#                 if array[mid] == target:
#                     return True
#                 if array[mid] > target:
#                     end = mid - 1
#                 else:
#                     start = mid + 1
#             return False
		
#         for i in range(m):
#             if binary_search(matrix[i], target):
#                 return True

#         return False

		l, r = 0, (m*n) - 1
		while l <= r:
			mid = (l+r)//2
			x = matrix[mid//n][mid%n]
			if x == target:
				return True
			elif x < target:
				l = mid + 1
			else:
				r = mid - 1
				
		return False