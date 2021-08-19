# Did this code successfully run on Leetcode : NO

class Solution:
	def search(self, nums: List[int], target: int) -> int:

		def find_pivot(nums, target):
			l = 0
			r = len(nums)-1
			if nums[l] < nums[r]:
				return 0
			while l <= r:
				m = (l+r)//2
				if nums[m] > nums[m+1]:
					return m + 1
				else:
					if nums[m] < nums[l]:
						r = m - 1
					else:
						l = m + 1
		
		def binary_search(nums, l, r, t):
			while l <= r:
				m = int((l+r)/2)
				if nums[m] == t:
					return m
				elif nums[m] > t:
					r = m - 1
				else:
					l = m + 1
			return -1
		
		if len(nums) == 1:
			return 0 if target == nums[0] else -1
		
		pivot = find_pivot(nums, target)
		
		if target < nums[pivot]:
			if target < nums[0]:
				return binary_search(nums, pivot+1, len(nums)-1, target)
			else:
				return binary_search(nums, 0, pivot, target)
		elif target == nums[pivot]:
			return pivot
		else:
			return -1
			