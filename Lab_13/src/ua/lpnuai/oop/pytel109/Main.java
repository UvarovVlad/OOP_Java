package ua.lpnuai.oop.pytel109;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;

public class Main{
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<User> container = new ArrayList<>();
    private static Serializator serializator = new Serializator();

    public static boolean isWord(String in){
        return Pattern.matches("[a-zA-Z]+",in);
    }

    public static boolean isNumber(String in){
        return Pattern.matches("[0-9]+",in);
    }

    public static boolean validDate(String in){
        return Pattern.matches("[0-9.,]+",in);
    }

    private static void createUser() {
        User user = new User();
        Scanner in = new Scanner(System.in);

        System.out.println("Please fill up this resume");
        System.out.println("Full name: ");
        String name = in.nextLine();
        System.out.println("Date of settlement: ");
        String dare_s = in.nextLine();
        System.out.println("Date of eviction: ");
        String date_e = in.nextLine();
        System.out.println("Number: ");
        String num = in.nextLine();
        System.out.println("Reason: ");
        String reason = in.nextLine();

        user.setId(container.size());
        if (true) {
            user.setName(name);
            user.setnum(num);
            user.setreason(reason);
            user.setdate_e(date_e);
            user.setdate_s(dare_s);
        }
        else {
            System.out.println("Data is throng try again");
            return;
        }
        container.add(user);
    }

    public static void deleteUser() {
        System.out.println("Input user id: ");
        int id = sc.nextInt();
        if (id == -1){
            container = new ArrayList<>();
            try {
                serializator.serialize(container);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        container.remove(id);
    }
    public static void updateUser(){
        deleteUser();
        createUser();
    }


    private static void show( int id) {
        User user = container.get(id);
        System.out.print("ID : ");
        System.out.println(user.getId());
        System.out.println("Full name: " + user.getName());
        System.out.println("Date of settlement: " + user.getdate_s());
        System.out.println("Date of eviction: " + user.getdare_e());
        System.out.println("Number: " + user.getnum());
        System.out.print("Reason: " + user.getreason());
        System.out.print("\n");
    }
    private static void show() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < container.size(); i++){
                    show(i);
                }
            }
        });
        thread.start();
    }


    static void select(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("What are you want?(w/r/u/d/e)");
            String s = scanner.next();
            switch (s){
                case "l":{
                    try {
                        container = serializator.deserialize();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }break;
                case "s":{
                    try {
                        serializator.serialize(container);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }break;
                case "e":{
                    System.exit(0);
                }break;
                case "w":{
                    createUser();
                }break;
                case "r":{
                    show();
                }break;
                case "d":{
                    deleteUser();
                }break;
                case "u":{
                    updateUser();
                }break;
            }
    }


    public static void main(String[] args) {
        Thread first;
        while (true) {

            select();
        }
    }
}
