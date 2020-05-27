# Time Complexity :O(Log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

#array getter if an exception happens return infinity as i don't know range of elements in array
def get(position):
    array = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18]
    try:
        return array[position]
    except:
        return float('inf')
def search(target):
    """
    :type target: int
    :rtype: int
    """
    start = 0
    end = 1
    #get range of your search
    while get(end) < float('inf'):
        if get(end) > target:
            break
        end = end*2
    # normal binary search
    while start <= end:
        mid = (start+end)//2
        if get(mid) == target:
            return mid
        elif get(mid) > target:
            end = mid-1
        elif get(mid) < target:
            start = mid+1
    return -1

print(search(1))