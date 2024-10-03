public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode p = this;
        while (p.next != null) {
            sb.append(p.val).append(",");
            p = p.next;
        }

        sb.append(p.val).append("]");

        return sb.toString();
    }
}
