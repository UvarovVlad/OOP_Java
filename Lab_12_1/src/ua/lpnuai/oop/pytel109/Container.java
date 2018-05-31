package ua.lpnuai.oop.pytel109;

import java.io.Serializable;

public class Container<T> implements Serializable {
    private int size = 0;
    private User head;
    private User element;
    private User prev = head;

    public void add(User user) {
        if(size == 0) {
            this.head = user;
            this.element = user;
        }
        else if (size == 1) {
            this.head.setNext(user);
            this.element = user;
        } else {
            while(element.getNext() != null) {
                this.element = element.getNext();
            }
            this.element.setNext(user);
        }
        size++;
    }

    public User get(T id) {
        this.element = this.head;
        for(int i = 0; i < size; i++) {
            if(this.element.getId() == id) {
                return this.element;
            }
            else {
                this.element = this.element.getNext();
            }
        }
        return null;
    }

    public void delete(T id) {
        this.element = this.head;
        for(int i = 0; i < size; i++) {
            if(this.element.getId() == id && i == 0) {
                this.head = this.head.getNext();
                this.element = this.element.getNext();
                size --;

                return;
            }
            else if(this.element.getId() == id) {
                this.element = this.element.getNext();
                this.prev.setNext(this.element);
                size--;
                return;
            }
            this.prev = this.element;
            this.element = this.element.getNext();
        }
    }

    public int getSize() {
        return this.size;
    }

    public User getIndex(int j) {
        this.element = this.head;
        for(int i = 0; i < j; i++) {
            this.element = this.element.getNext();
        }
        return this.element;
    }
}
