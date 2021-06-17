package _09_dsa_list.bai_tap;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Node() {
        }

        public Object getData() {
            return this.data;
        }
    }

    // mô tả số lượng node có trong danh sách
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    /**
     * them vao dau 1 gia tri
     *
     * @param element
     */
    public void addFirst(E element) {
        //khai báo biến là temp tham chiếu đến giá trị của head
        Node temp = head;
        //biến head sẽ nhân giá trị là 1 cái node mới
        head = new Node(element);
        //head.next trỏ đến temp
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        // khai báo biến temp trỏ đến head
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, E element) {
        // khai báo biến temp trỏ đến head
        Node temp = head;
        // Khái báo node holder
        Node holder;
        // cho contror chạy đến vị trí index -1
        for (int i =0; i< index && temp.next !=null;i++){
            temp = temp.next;
        }
        // cho holder tham chiếu đến vị trí index
        holder = temp.next;
        //Node tại vị trí index -1 sẽ trỏ tới node mới
        temp.next = new Node(element);
        // node mới sẽ trỏ đến holder
        temp.next.next = holder;
        // tăng số lượng phần tử trong danh sách lên 1
        numNodes++;
    }
    public Object get(int index){
        // khai báo biến temp trỏ tới head
        Node temp = head;
        for (int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * tra ve so luong node
     * @return
     */
    public int size (){
        return numNodes;
    }

    /**
     * remove phan tu theo vi tri chi dinh
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index > numNodes){
            throw new IllegalArgumentException("Error index: " + index);
        }
        // khai báo biến temp trở đến head
        Node temp = head;
        Object data;

        //nếu index = 0 thì sẽ trả về data hiện tại
        if (index == 0){
            data = temp.data;
            head = head.next;
            numNodes--;
        }else{
            for ( int i =0;i<index -1 && temp.next != null;i++){
                temp = temp.next;

            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    public boolean remove (E element){
        //remove đối tượng nếu nó là element head
        if (head.data.equals(element)){
            remove(0);
            return true;
        }else {
            Node temp = head;
            while (temp.next != null){
                // nếu như tồn tại 1 phần tử có data bằng data ở node nào đó thì bị remove
                if (temp.next.data.equals(element)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }

    public MyLinkedList<E> clone(){
        // kiểm tra linked có phần tử hay không
        if (numNodes == 0){
            throw new NullPointerException("LinkedList is null");
        }
        // khai báo linkedlist trả về
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        // khai báo 1 temp trỏ đến head
        Node temp = head;
        // add temp vào danh sách trả về để làm head
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp!= null){
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean constrains (E element){
        Node temp = head;
        while (temp.next != null){
            if (temp.data.equals(element)){
                return true;
            }
            temp = temp.next;

        }
        return false;
    }

    public int indexOf(E element){
        Node temp = head;
        for (int i=0;i< numNodes;i++){
            if (temp.getData().equals(element)){
                return i;
            }
        }
        return -1;
    }
}
