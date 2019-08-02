class SearchInfiniteArray:
	def findPos(self, arr, target):
		l = 0
		h = 2
		try:
			while(arr[h] < target):
				l = h 
				h *= 2
		except Exception as e:
			try:
				while(l >= 0):
					if arr[l] == target:
						return l
					l += 1
			except Exception as e1:
				print("Not found")
		return self.BSearch(arr, target, l, h)

	def BSearch(self, arr, target, low, high):
		while(low <= high):
			mid = low + (high - low)//2
			if arr[mid] == target:
				return mid
			elif arr[mid] > target:
				high = mid - 1
			else:
				low = mid + 1
		return -1

if __name__ == "__main__":
	SIA = SearchInfiniteArray()
	print(SIA.findPos([2,4,5,11,15,17,18,19,20,23], 23))