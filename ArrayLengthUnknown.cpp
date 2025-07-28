#include<iostream>
#include<vector>
using namespace std;
/*
->Double the high index until the target is within range.
->Perform binary search between low and high.
->Efficient for unknown-size sorted arrays using ArrayReader.
TC: O(log n) , SC: O(1)
*/
class Solution{
public:
    int search(ArrayReader reader, int target){
        int low=0, high=1;

        while(reader.get(high)<target){
            low=high;
            high=high*2;
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target) return mid;
            if(reader.get(mid)>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
};
int main(){
    return 0;
}