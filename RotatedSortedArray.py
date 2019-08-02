class RotatedSortArray:
	def Search(self, nums, target):
		"""
		:type nums: List[int]
		:type target: int
		:rtype: int
		"""
		l = 0
		h = len(nums) - 1
		while(l <= h):
			mid = l + (h - l)//2
			if nums[mid] == target:
				return mid
			elif nums[l] <= nums[mid]:
				if nums[l] <= target and target <= nums[mid]:
					h = mid - 1
				else:
					l = mid + 1
			else:
				if nums[mid] <= target and target <= nums[h]:
					l = mid + 1
				else:
					h = mid - 1
		return -1

if __name__ == "__main__":
	rsa = RotatedSortArray()
	print(rsa.Search([4,5,6,7,0,1,2], 0))