/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode bust = head;
        ListNode hit = head;

        while(hit != null && hit.next != null){
            bust = bust.next;
            hit = hit.next.next;

            if(bust == hit){
                ListNode pret = head;
                while(pret != bust){
                    pret = pret.next;
                    bust = bust.next;
                }
                return bust;
            }
        }
        return null;
    }
}