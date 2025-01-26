package cs2725.impl;

/**
 * A node in a doubly linked list.
 *
 * @param <T> the type of the element stored in the node
 */
class DoublyLinkedNode<T> {
    
    /**
     * The data stored in this node.
     */
    private T data;

    /**
     * The previous node in the list.
     */
    private DoublyLinkedNode<T> prev;

    /**
     * The next node in the list.
     */
    private DoublyLinkedNode<T> next;

    /**
     * Constructs a new node with the specified data.
     *
     * @param data the data to be stored in this node
     */
    DoublyLinkedNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    /**
     * Returns the data stored in this node.
     *
     * @return the data stored in this node
     */
    public T getData() {
        return data;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node in the list
     */
    public DoublyLinkedNode<T> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev the node to be set as the previous node
     */
    public void setPrev(DoublyLinkedNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list
     */
    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the node to be set as the next node
     */
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }
}