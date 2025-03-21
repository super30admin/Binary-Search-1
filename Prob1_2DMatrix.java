class Solution {
    public boolean isIsomorphic(String s, String t) {

        //This solution is using 2 HashMaps
        /*
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar) != tChar) return false;
            } else{
                sMap.put(sChar, tChar);
            }

            if(tMap.containsKey(tChar)){
                if(tMap.get(tChar) != sChar) return false;
            } else {
                tMap.put(tChar, sChar);
            }
        }
        return true;

*/
        //This solution is using 1 HashMap & 1 HashSet
        //This is more optimized one
        /*
        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i =0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar) != tChar) return false;
            } else{
                if(set.contains(tChar)) return false;
                sMap.put(sChar, tChar);
                set.add(tChar);
            }
        }
        return true;
        */

        //using our own array, ASCII values for every character
        char[] sMap = new char[256];
        boolean[] set = new boolean[100];

        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap[sChar - ' '] != 0){ //suppose sChar is a, then ASCII of a is 97. Therefore, 97 != 0
                if(sMap[sChar - ' '] != tChar) return false;
            } else{
                if(set[tChar - ' ']) return false;
                sMap[sChar - ' '] = tChar;
                set[tChar - ' '] = true;
            }
        }
        return true;

    }
}
