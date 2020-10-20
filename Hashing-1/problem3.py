// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach




class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        
        element=s.split()
        
        pdict={}
        sdict={}
        
        if len(pattern)!=len(element):
            return False
            
        for i in range(len(pattern)):
            if pattern[i] not in pdict:
                pdict[pattern[i]]=element[i]
            else:
                if pdict[pattern[i]]!=element[i]:
                    return False
                
                
            if element[i] not in sdict:
                sdict[element[i]]=pattern[i]
            else:
                if sdict[element[i]]!=pattern[i]:
                    return False
        
        return True
                
