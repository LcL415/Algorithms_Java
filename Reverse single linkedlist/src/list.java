public class list {
    ListNode head;

    public list(ListNode head) {
        this.head = head;
    }
    public void addfirst(ListNode firstnode){
        firstnode.next=head;
        head=firstnode;
    }
    public ListNode removeFirst(){
        ListNode firstnode = head;
        if(firstnode!=null){
            head=firstnode.next;
        }
        return firstnode;

    }
}
