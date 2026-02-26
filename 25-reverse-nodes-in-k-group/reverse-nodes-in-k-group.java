class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||k==1) return head;
        ListNode ans=new ListNode(0);
        ans.next=head;
        ListNode prev_blk=ans;
        ListNode prev_ptr=head;
        while (true){
            ListNode nxt_ptr=prev_blk;
            int ind=0;
            while (ind<k&&nxt_ptr!=null) {
                nxt_ptr=nxt_ptr.next;
                ind++;
            }
            if (nxt_ptr==null) break;
            ListNode nxt_blk=nxt_ptr.next;
            ListNode prev=nxt_blk;
            ListNode curr=prev_ptr;
            while (curr!=nxt_blk) {
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            prev_blk.next=nxt_ptr;
            prev_blk=prev_ptr;
            prev_ptr=nxt_blk;
        }
        return ans.next;
    }
}