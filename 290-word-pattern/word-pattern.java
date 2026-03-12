class Solution {
    public boolean wordPattern(String pattern, String s) {
        String ch[]=s.split(" ");
        Map<Character,String> map=new HashMap<>();
        Set<Character> set_1=new HashSet<>();
        Set<String> set_2=new HashSet<>();
        for(int i=0;i<pattern.length();i++)
        {
            if(ch.length!=pattern.length())
            {
                return false;
            }
            set_1.add(pattern.charAt(i));
            set_2.add(ch[i]);
            if(map.containsKey(pattern.charAt(i))  && !(map.get(pattern.charAt(i)).equals(ch[i])))
            {
                return false;
            }
            else{
                map.put(pattern.charAt(i),ch[i]);
            }
        }
        if(set_1.size()!=set_2.size())
        {
            return false;
        }
        return true;
    }
}