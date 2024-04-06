package ringbuffer;

import java.util.Iterator;

public class RingBufferImpl<E> implements RingBuffer<E> { 
    private static class Node<E> {
        public E data;
        public Node<E> next;
        
        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> first;
    public final int maxSize;

    public RingBufferImpl(int maxSize) {
        if (maxSize < 1) {
            throw new IllegalArgumentException();
        }

        this.maxSize = maxSize;
    }

    public E poll() {
        if (first == null) {
            return null;
        }

        var result = first.data;
        first = first.next;
        
        return result;
    }

    public E peek() {
        if (first == null) {
            return null;
        }

        return first.data;
    }

    public void add(E data) {
        if (first == null) {
            first = new Node<E>(data);
        } else { 
            getLastNode().next = new Node<E>(data);
        
            if (getSize() > maxSize) {
                poll();
            }
        }
    }
    
    private Node<E> getLastNode() {
        var result = first;

        while (result.next != null) {
            result = result.next;
        }

        return result;
    }
    
    public int getSize() {
        var result = 0;

        for (var node = first; node != null; node = node.next) {
            result++;
        }

        return result;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = first;
            
            public boolean hasNext() {
                return node != null;
            }
            
            public E next() {
                var result = node.data;
                node = node.next;
                
                return result;
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}