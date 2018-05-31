package ua.lpnuai.oop.pytel109;

import java.io.Serializable;

public class User<T> implements Serializable {

    private User next;

    public User getNext() {
        return this.next;
    }

    public void setNext(User next) {
        this.next = next;
    }

    private T id;
    private T name;
    private T date_s;
    private T date_e;
    private T num;
    private T reason;


    public void setId(T i) {
        id = i;
    }

    public T getId() {
        return id;
    }

    public void setName(String s) {
        name = (T) s;
    }
    public T getName() {
        return name;
    }

    public void setdate_e(String s) {
        date_e = (T) s;
    }
    public T getdare_e(){
        return  date_e;
    }

    public void setdate_s(String  n) {
        date_s = (T) n;
    }
    public T getdate_s() {
        return date_s;
    }

    public void setnum(String s) {
        num = (T) s;
    }
    public T getnum() {
        return num;
    }

    public void setreason(String s) {
        reason = (T) s;
    }
    public T getreason() {
        return reason;
    }
}