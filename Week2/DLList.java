package Week2;

class DLList {
    class Node {
        // Each node object has these three fields
        private Object element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(Node p) {
            previous = p;
        }

        // This function returns the previous Node
        public Node getPrevious() {
            return previous;
        }
    }

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;
    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public DLList() {
        head = null;
        tail = null;
    }

    /**
     * @return The element in the head Node of the DLL
     */
    public Object getHead() {
        return head.getElement();
    }

    /**
     * @return The element in the tail Node of the DLL
     */
    public Object getTail() {
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addFirst(Object e) {
        if(head == null) {
            tail = head = new Node(e, null, null);
            return;
        }

        Node n = new Node(e, null, head);
        head.setPrevious(n);
        head = n;
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if(head == null) return null;
        if(head.getNext() == null) {
            Object temp = head.getElement();
            head = tail = null;
            return temp;
        }

        Object temp = head.getElement();
        Node n = head.getNext();
        n.setPrevious(null);
        head = n;

        return temp;
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addLast(Object e) {
        if(head == null) {
            addFirst(e);
            return;
        }

        Node n = new Node(e, tail, null);
        tail.setNext(n);
        tail = n;
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if(tail == null) return null;
        if(tail == head) return removeFirst();

        Object temp = tail.getElement();
        Node n = tail.getPrevious();
        n.setNext(null);
        tail = n;

        return temp;
    }

    /**
     * @return the number of Nodes in the list
     */
    public int size() {
        if(head == null) return 0;

        Node current = head;
        int counter = 1;

        while(current.getNext() != null) {
            current = current.getNext();
            counter++;
        }

        return counter;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos
     *     The position to insert the element at.
     * @param e
     *     The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        if(pos == 0) {
            addFirst(e);
            return;
        }
        if(pos >= this.size()) {
            addLast(e);
            return;
        }

        Node current = head;

        while(pos > 1) {
            current = current.getNext();
            pos--;
        }

        Node p = current;
        Node n = current.getNext();

        Node node = new Node(e, p, n);
        p.setNext(node);
        n.setPrevious(node);
    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos
     *     The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if(pos >= this.size()) return null;
        if(pos == 0) return removeFirst();

        Node current = head;
        while (pos-- > 0) current = current.getNext();

        Node temp = current;
        Node n = current.getNext();
        Node p = current.getPrevious();

        if(n != null) n.setPrevious(p);

        p.setNext(n);
        return temp.getElement();
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     */
    public DLList reverse() {
        if(tail == null) return null;

        DLList res = new DLList();
        Node temp = this.head;

        while(temp.getNext() != null) {
            res.addFirst(temp.getElement());
            temp = temp.getNext();
        }

        res.addFirst(temp.getElement());
        return res;
    }
}


