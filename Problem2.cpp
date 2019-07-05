//
// Created by shazmaan on 7/4/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Problem2{
public:
    int prob(vector<int>& vec, int target){
        int low = 0; int high = 1; int val = vec[low];
        while(val<target){
            try{
                low=high; high = high*2;
                val = vec[high];
            }catch (const std::out_of_range& e){
                return MID(vec,low,high,target);
            }
        }
        return MID(vec,low,high,target);
    }
    int MID(vector<int>& vec,int l, int h, int value) {
        int low = l;
        int high = h;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            try {
                int a = vec[mid];
                if (a == value) {
                    return mid;
                } else if (a < value) {
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }

            } catch (const std::out_of_range &e) {
                continue;
            }
        }
        return -1;
    }
};

int main(){
    Problem2 p;
    vector<int>  vec{1,2,3,4,5,6};
    cout<<p.prob(vec,6)<<endl;
    return 0;
}