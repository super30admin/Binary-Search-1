// TC:O(logn);
// SC:O(1);

// Approach:
// Here we find the ranges of search space by keeping intially low and high pointers at 0,1 indices
// checking whether high is less than target and updating high to high*2, And then we perform the 
// Binary search in this range;

class Solution {
public:
    int search(const ArrayReader& reader, int target) {

        int low=0;
        int high=1;
        // First step is to find the range of search space
        while(reader.get(high)<target)
        {
                low=high;
                high=high*2;            
        }
        // then performing Binary search on Search space
        return BS(reader,target,low,high);
    }

    int BS(const ArrayReader& reader, int target,int low,int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target)
            return mid;
            else if(target<reader.get(mid))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
};