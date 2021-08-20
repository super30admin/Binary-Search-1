# // Time Complexity :O(logn)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :no,premium account
# // Any problem you faced while coding this :not while coding, but no premium account


# // Your code here along with comments explaining your approach



arr=[1,3,5,7,12,13,14,15,16,17,18,19,20]
target=16
low=0 
high=1
while(arr[high]<target):
    low=high
    high=high*2
while(low<=high):
    mid=(low+high)//2
    if(arr[mid]==target):
        print(mid)
    if target<=arr[mid]:
        high=mid-1
    else:
        low=mid+1