class Problem1:
    def search(self, nums: List[int], target: int) -> int:
        # 4 5 6 7 0
        # taking two pointer
        #i=0 ,j=length num
        # i will update the code with binary search
        i=0
        j=len(nums)-1
        while i<=j:
            if target==nums[i]:
                return i
            if target==nums[j]:
                return j
            if target>nums[i]:
                i +=1 #incriment i if target if greater then i index
            else:
                j -=1 #else decriment j
        return -1




        """
        #using python function
        this one running fast
        if target in nums:
            return nums.index(target,0,len(nums))
        else:
            return -1
        """
