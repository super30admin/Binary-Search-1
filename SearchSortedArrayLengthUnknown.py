# Time Complexity : O(log(n))
# Space Complexity : O(1)
class Solution(object):
    
    def __get(self, nums, index):
        
        try:
            return nums[index]
        except IndexError:
            return 2147483647

    def binarySearch(self, nums1, target):
        l=0
        h=1
        
        while l<=h:
            mid=l+(h-l)//2
            if self.__get(nums1, mid)==target: return mid
            elif self.__get(nums1, h)<target:
                h=2*h
                

            else:
                if self.__get(nums1, l)<=target and self.__get(nums1, h)>=target:
                    if self.__get(nums1, mid)>target :
                        h=mid-1
                    else:
                        l=mid+1
        return -1

nums = [i for i in range(100)]
target = 99
obj = Solution()
print(obj.binarySearch(nums, target))

