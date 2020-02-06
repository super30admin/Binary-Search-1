class Solution(object):

    def search(self,nums,target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low+high)//2
            if target == nums[mid]:
                return mid
            elif nums[mid] >= nums[low]:
                if target>=nums[low] and target<=nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[mid] <= nums[high]:
                if target <= nums[high] and target >=nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1


def main():
    nums = [4,5,6,7,0,1,2]
    target = 2
    result = Solution().search(nums,target)
    print(result)

if __name__ == "__main__":
    main()
