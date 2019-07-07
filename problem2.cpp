#include <iostream>
#include <vector>
using namespace std;

/*

Notes: There's some problem with exception handling that is giving me errors on GeeksforGeeks. 
	   I understand the algorithm well and have coded this independently after watching 
	   the lecture video. 
*/
class Solution{
    public:
        int BinarySearch(vector<int> &arr, int target, int start, int end)
        {   
            int middle;
            while(start<= end)
            {
                middle = start + (end - start)/2;
                
				if(arr[middle] == target) return middle;   
                else if(arr[middle] < target) start = middle + 1;
                else end = middle -1; 
            }
            
            return -1;
        }
        
        int SortedArr(vector<int> arr, int target)
        {
            int start = 0;
            int end = 1;
            
            try
            {
                while(arr[end] <= target)
                {
                    start = end;
                    end = 2*end;
                }
            }
            
            catch(exception &e)
            {   
                try
                {
                     while(arr[start] < target)
                    {
                        if(arr[start] == target)
                            return start;
                        start++;
                    }
                }
                
                catch(exception &f)
                {
                   cout<<"-1";
                }
                    
            }
            
            return BinarySearch(arr, target, start, end);
        }
};

int main() {
    Solution s;
    vector<int>my_vec{1,3,5,7,8,9,15};
    cout<<s.SortedArr(my_vec, 9);
	return 0;
}