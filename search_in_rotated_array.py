class Solution:
    def search(self, nums: List[int], target: int) -> int:

        '''
        The intricacy of solving this problem is you have to understand, which part of the mid is sorted
        Is it left or right?
        Once you find that, then you figure out rest
        Like whether the number which ever you are searching in the sorted or not.

        I have to practice this problem atleast 3 more times to get the hang of it.

        Time Complexity: O(log n)
        Space Complexity: O(1)
        '''


        low =0
        high= len(nums)-1

        while(low<=high):
            mid = (low+high)//2

            print(mid)

            if(nums[mid]==target):
                return mid

            # This is the pivotal moment where the decision happen.
            elif(nums[mid]>=nums[low]):
                #  which mean left part of the array is sorted:
                # Now lets check if target is present in this part


                if(nums[low]<=target and nums[mid]>target):
                    high=mid-1
                else:
                    low = mid+1

            else:

                if(nums[mid]<target and target<=nums[high]):
                    low=mid+1
                else:
                    high=mid-1




        return -1

