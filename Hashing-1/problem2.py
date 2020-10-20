// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

Iterate through the string -- for each element map to the value 
update the same in the second dictionary also .
if the respective value for the key is not matching return false














class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        sdict={}
        tdict={}
        
        if len(s)!=len(t) :
            return False
        
        for i in range (len(s)):
            if s[i] not in sdict:
                sdict[s[i]]=t[i]
            else:
                if sdict[s[i]]!=t[i]:
                    return False
            
            if t[i] not in tdict:
                tdict[t[i]]=s[i]
            else:
                if tdict[t[i]]!=s[i]:
                    return False
                
        return True
                
