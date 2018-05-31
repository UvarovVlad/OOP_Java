package ua.lpnuai.oop.pytel109;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;

public class Main{
    private static Scanner sc = new Scanner(System.in);
    private static Container container = new Container();
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
        System.out.println("First name: ");
        String fname = in.nextLine();
        System.out.println("Last name: ");
        String lname = in.nextLine();
        System.out.println("year Of Birsd ");
        int yearOfBd = in.nextInt();
        System.out.println("Education: ");
        String education = in.nextLine();
        System.out.println("Salary: ");
        int salary = in.nextInt();
        System.out.println("Position: ");
        String position = in.nextLine();
        System.out.println("Department: ");
        String department = in.nextLine();
        System.out.println("Characteristic: ");
        String characteristic = in.nextLine();

        user.setId(container.getSize());
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setYearOfBd(yearOfBd);
        user.setEducation(education);
        user.setSalary(salary);
        user.setCharacteristic(characteristic);
        user.setDepartment(department);

        container.add(user);
    }

    public static void deleteUser() {
        System.out.println("Input user id: ");
        int id = sc.nextInt();
        if (id == -1){
            container = new Container();
            try {
                serializator.serialize(container);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        container.delete(id);
    }
    public static void updateUser(){
        deleteUser();
        createUser();
    }


    private static void show( int id) {
        User user = container.get(id);

        System.out.println("First name: "+user.getFirstName());

        System.out.println("Last name: "+user.getLastName());

        System.out.println("year Of Birsd "+user.getYearOfBd());

        System.out.println("Education: "+user.getEducation());

        System.out.println("Salary: "+user.getSalary());

        System.out.println("Position: "+user.getPosition());

        System.out.println("Department: "+user.getDepartment());

        System.out.println("Characteristic: "+user.getCharacteristic());

    }
    private static void show() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < container.getSize(); i++){
                    show(i);
                }
            }
        }
        );
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

