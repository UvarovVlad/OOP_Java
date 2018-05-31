package ua.lpnuai.oop.pytel109;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void read(){
        int count=0;
        List<String> info = new LinkedList<>();
        String line;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("Text.txt"));

            while((line=reader.readLine())!=null){
                info.add(line);
                count++;
            }
            reader.close();

        }
        catch (IOException e){
            System.out.println("Error");

        }
        for(int i=0;i<count/5;i++) {
            System.out.print("ID : ");
            System.out.println(i+1);
            System.out.println("Full name: " + info.get(i * 5));
            System.out.println("Date of settlement: " + info.get((5*i+1)));
            System.out.println("Date of eviction: " + info.get((5*i+2)));
            System.out.println("Number: " + info.get((5*i+3)));
            System.out.print("Reason: " + info.get((5*i+4))+"\n");
            System.out.print("\n");
        }

    }
    public static void delete(int id) throws IOException {
        FileWriter fw = new FileWriter("Text.txt",false);
        List<String> info = new LinkedList<>();
        String line;
        int cout = 0;
        boolean ex = false;

        if(id == 0){
            fw.write("");
            return;
        }

        try{
            BufferedReader reader = new BufferedReader(new FileReader("Text.txt"));

            while((line=reader.readLine())!=null){
               if (line == "ID : "+id)
                   ex = true;
               if (!(line == "ID : "+id) || ex){
                    info.add(line);
               }
               if(ex){
                   cout++;
               }
               if (cout >= 4){
                   ex = false;
               }

            }

            for (int i = 0; i < info.size(); i++){
                fw.write(info.get(i));
            }
            reader.close();

        }
        catch (IOException e){
            System.out.println("Error");

        }
    }

    public static void write(){
        try {
            Scanner infowriter = new Scanner(System.in);
            FileWriter fw=new FileWriter("Text.txt",true);
            System.out.println("Please fill up this resume");
            System.out.println("Full name: ");
            String lineTowrite = infowriter.nextLine();
            fw.write(lineTowrite);
            fw.write(System.lineSeparator());
            System.out.println("Date of settlement: ");
            lineTowrite = infowriter.nextLine();
            fw.write(lineTowrite);
            fw.write(System.lineSeparator());
            System.out.println("Date of eviction: ");
            lineTowrite = infowriter.nextLine();
            fw.write(lineTowrite);
            fw.write(System.lineSeparator());
            System.out.println("Number: ");
            lineTowrite = infowriter.nextLine();
            fw.write(lineTowrite);
            fw.write(System.lineSeparator());
            System.out.println("Reason: ");
            lineTowrite = infowriter.nextLine();
            fw.write(lineTowrite);
            fw.write(System.lineSeparator());
            fw.close();

        }
        catch (IOException e){
            System.out.println("Error");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("What are you want?(w/r/e)");
            String s = scanner.next();
            switch (s){
                case "e":
                    System.exit(0);
                break;

                case "r":{
                    read();
                }break;
                case "d":{
                    int id = scanner.nextInt();
                    try {
                        delete(id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }break;
                case "u":{
                    int id = scanner.nextInt();
                    try {
                        delete(id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    write();
                }break;
                case "w":{
                    write();
                }
            }

        }
	// write your code here
    }
}
