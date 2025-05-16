# modify the element of the array by putting the value at mid location lesser
# or greater than target.
# This way, binary search can be done and time complexity would be O(log (n))
import sys

def find_element(nums, left, right, target) -> int:
    while right > left:
        mid = int(left + (right - left)/2)
        if ((nums[0] > target and nums[0] > nums[mid]) or
            (nums[0] < target and nums[0] < nums[mid])):
            if nums[mid] == target:
                return mid
        else:
            if nums[mid] > target:
                nums[mid] = -sys.maxsize-1
            else:
                nums[mid] = sys.maxsize
        if nums[mid] > target:
            return find_element(nums, left, mid, target)
        else:
            return find_element(nums, mid+1, right, target)
    if nums[left] == target:
        return_val = left
    else:
        return_val = -1 
    return return_val



if __name__ == "__main__":
    nums = [5,7,9,11, 1, 2, 3]
    print(find_element(nums, 0, len(nums)-1, 11))