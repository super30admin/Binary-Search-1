#!/usr/bin/env python
# coding: utf-8

# In[8]:


#time complexity for this problem is O(log(mn))
#space complexity for this problem is O(1)
#faced difficulty in dealing with the indexes. I should have taken examples and written on paper when ever I faced confusion
#executed this in leetcode.
def searchMatrix(matrix, target) -> bool:
        left=0
        len_prim=len(matrix)
        len_secon=len(matrix[0])
        right=(len_prim*len_secon)-1
        mid=(left+right)//2
        # if len_prim*len_secon==1:
        #     return target==matrix[0][0]
        while left<=right:
            ind_prim=mid//len_secon
            ind_secon=mid%len_secon
            if target==matrix[ind_prim][ind_secon]:
                return True
            elif target>matrix[ind_prim][ind_secon]:
                left=mid+1
                mid=(left+right)//2
            else:
                right=mid-1
                mid=(left+right)//2
        return False


# In[ ]:


"""
Time complexity is O(log(n))
Space complexity is O(1)
faced so many problems in framing the loop solution part. Still not confident. should practise more of these type of probs
Executed this problem in leetcode.
"""
def search(nums, target) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid]>=nums[low]:
                if target==nums[mid]:
                    return mid
                elif nums[low]<=target<nums[mid]:
                    high=mid-1
                    continue
                else:
                    low=mid+1
                    continue
            elif nums[mid]<=nums[high]:
                if target==nums[mid]:
                    return mid
                elif nums[high]>=target>nums[mid]:
                    low=mid+1
                    continue
                else:
                    high=mid-1
                    continue
        return -1


# In[ ]:


"""
Time complexity is O(log(n))
Space complexity is O(1)
I did not face much difficulty in solving this. However if i would have used different examples on paper before starting
to solve then it would have taken less time
Executed this problem in leetcode.
"""
def search(self, reader: 'ArrayReader', target: int) -> int:
        x=1
        y=0
        while reader.get(x)!=(2^31)-1:
            if reader.get(x)<target:
                y=x
                x=2*x
            elif reader.get(x)==target:
                return x
            else:
                break
        l=y
        r=x
        m=(l+r)//2
        while l<=r:
            if reader.get(m)==target:
                return m
            elif reader.get(m)>target:
                r=m-1
                m=(l+r)//2
            else:
                l=m+1
                m=(l+r)//2
        return -1


# In[ ]:





# In[ ]:




