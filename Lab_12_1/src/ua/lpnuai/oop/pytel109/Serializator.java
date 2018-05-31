package ua.lpnuai.oop.pytel109;

import java.awt.*;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Serializator {

    public void serialize(ArrayList<User> ts) throws Exception {
        FileOutputStream fos = new FileOutputStream("temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ts);
        oos.flush();
        oos.close();

    }
    public ArrayList<User> deserialize() throws Exception {
        FileInputStream fis = new FileInputStream("temp.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<User> c = (ArrayList<User>)  ois.readObject();
        ois.close();
        return c;
    }
}
