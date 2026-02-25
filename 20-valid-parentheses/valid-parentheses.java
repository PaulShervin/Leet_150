class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character>queue=new ArrayDeque<>();
        for(char ch:s.toCharArray())
        {
            if(map.containsKey(ch))
            {
                if(!queue.isEmpty() && queue.peek()==map.get(ch))
                {
                    queue.pop();
                }
                else{
                    return false;
                }
            }
            else{
                queue.push(ch);
            } 
        }    
        return queue.isEmpty();    
    }
}