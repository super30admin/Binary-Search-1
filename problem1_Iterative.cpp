#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>

using namespace std;


//iterative solution 
class Solution{
    public:
        int Search(vector<int>& arr, int target)
        {   
            int start = 0;
            int end = arr.size() - 1;
            int middle;
            
            while(start <= end)
            {
               middle = start + (end - start)/2;
               
               if(arr[middle] == target) return middle;
               
               //left sorted
               if(arr[start] <= arr[middle])
               {
                    if(arr[start] <= target && arr[middle] >= target)
                        end = middle -1;
                    else    
                        start = middle + 1;
               }
               
               //right sorted
               else
               {
                    if(arr[middle] <= target && arr[end] >= target)
                        start = middle + 1;
                    else
                        end = middle - 1;
               }
            
            }
            
            return -1;
        }
};

int main() {
	//code
	Solution s;
	vector<int>num{4,5,6,7,1,2,3};
	cout<<s.Search(num, 5);
	return 0;
}

