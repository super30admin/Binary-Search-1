// Time Complexity :O(log(n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, nums, target):
        if not nums:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]:
                if target >= nums[low] and target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target >= nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1

def main():
    size = int(input("Enter the size of the array: "))
    nums = []

    print("Enter the array elements:")
    for _ in range(size):
        nums.append(int(input()))

    target = int(input("Enter the target value: "))

    solution = Solution()
    result = solution.search(nums, target)


    print(result)


if __name__ == "__main__":
    main()
