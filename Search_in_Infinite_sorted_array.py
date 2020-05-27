# Time Complexity : O(logn)
# 
# Space Complexity : O(1)
# 
# Did this code successfully run on Leetcode : N/A
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. Since the input list is an infinite sorted steam, we need to define the end index to apply binary search. Any index which holds a value greater or equal to the target can be taken as end index
# 2. The end index is initialized with value 1. The value is doubled at each iteration until a desired value has been reached
class Solution:
	def __init__(self):
		self.input = []

	def addElementInStream(self, element):
		"""
		Add new elements in the input stream
		"""
		self.input.append(element)

	def search(self, target):

		start = 0
		end = 1

		# Loop to find the end index
		while True:
			if self.input[end] == target:
				return end
			if self.input[end] > target:
				break
			end = end * 2

		# usual binary search after the end index is defined
		while start <= end:
			mid  = (start + end) // 2
			if self.input[mid] == target:
				return mid
			elif self.input[mid] < target:
				start = mid+1
			else:
				end = mid - 1
		return -1