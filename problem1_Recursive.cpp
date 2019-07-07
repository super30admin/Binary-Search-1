#include <iostream>
#include <vector>

using namespace std;


//Recursive solution

class Solution{
    public:
        int Binary(vector<int>& arr, int target, int start, int end)
        {   
            
            int middle = start + (end - start)/2;
            if(start > end) return -1;
            
            else if(arr[middle] == target) return middle;
            
            else
            {   //left sorted
                if(arr[start] <= arr[middle])
               {
                    if(arr[start] <= target && arr[middle] >= target)
                        return Binary(arr, target, start, middle-1);
                    else    
                       return Binary(arr, target, middle + 1, end);
               }
               
                //right sorted
                else
                {
                    if(arr[middle] <= target && arr[end] >= target)
                        return Binary(arr, target, middle + 1, end);
                    else
                        return Binary(arr, target, start, middle-1);
                }
               
               
            }
            
        }
        
        int Search(vector<int> &arr, int target)
        {
            return Binary(arr, target, 0, arr.size() - 1);
        }
};

int main() {
	//code
	Solution s;
	vector<int>num{4,5,6,7,1,2,3};
	cout<<s.Search(num, 5);
	return 0;
}