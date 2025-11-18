package listapi;

public class GenericStack<E> {

    private java.util.LinkedList<E> list = new java.util.LinkedList<E>();
    
    public GenericStack() { }
    
    public void push(E e) {
        list.addLast(e);
    }
    
    public E pop() {
        return list.removeLast();
    }
    
    public int size() {
        return list.size();
    }
    
    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }
    
} // end of GenericStack
