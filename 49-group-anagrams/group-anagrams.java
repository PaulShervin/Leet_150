class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs)
        {
            char[] char_str=str.toCharArray();
            Arrays.sort(char_str);
            String ans=new String(char_str);
            if(!map.containsKey(ans))
            {
                map.put(ans,new ArrayList<>());
            }
            map.get(ans).add(str);
        }
        return new ArrayList<>(map.values());
    }
}