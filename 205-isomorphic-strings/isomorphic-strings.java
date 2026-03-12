class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> char_s=new HashMap<>();
        Map<Character,Integer> char_t=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(!char_s.containsKey(s.charAt(i)))
            {
                char_s.put(s.charAt(i),i);
            }
            if(!char_t.containsKey(t.charAt(i)))
            {
                char_t.put(t.charAt(i),i);
            }
            if(!char_s.get(s.charAt(i)).equals(char_t.get(t.charAt(i))))
            {
                return false;
            }
        }
        return true;
    }
}