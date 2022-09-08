package com.example.onlinefood;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    public static void main(String[] args) {

    }
    Socket client;
    BufferedReader reader;
    BufferedWriter writer;
    Thread t;

    public ClientHandler(Socket client) {
        this.client = client;
        t=new Thread(this);
        t.start();

    }


    @Override
    public void run() {

            try {

                InputStreamReader ois= new InputStreamReader(client.getInputStream());
                OutputStreamWriter oos= new OutputStreamWriter(client.getOutputStream());

                BufferedWriter writer= new BufferedWriter(oos);
                BufferedReader reader = new BufferedReader(ois);
                while (true) {

                    String str = reader.readLine();
                    if(str==null){
                        break;
                    }
                    if (str.equals("initializeHomePage")) {
                        writer.write(foodList() + "\n");
                        writer.flush();
                    } else if (str.contains("getFood")) {
                        String ids = reader.readLine();
                        writer.write(addedfood(ids) + "\n");
                        writer.flush();
                    } else if (str.contains("prices")) {
                        String food = reader.readLine();
                        writer.write(priceList(food) + "\n");
                        writer.flush();
                    } else {
                        System.out.println("[Client] " + str);
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private String foodList(){
        String foods = "";

        try{
            FileReader file = new FileReader("C:/Users/Shahriar Rahman/OneDrive/onlinefood/src/main/java/com/example/onlinefood/food.txt");
            BufferedReader reader = new BufferedReader(file);

            String line;
            while((line=reader.readLine()) != null){
                foods = foods + line + "###";
            }

            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return foods;
    }
    private String addedfood(String ids){
        String [] list = ids.split("##");
        String sList = "";

        try{
            FileReader file = new FileReader("C:/Users/Shahriar Rahman/OneDrive/onlinefood/src/main/java/com/example/onlinefood/food.txt");
            BufferedReader reader = new BufferedReader(file);

            String line;
            while((line=reader.readLine()) != null){
                String [] parts = line.split("#");
                for (String s: list){
                    if(parts[0].equals(s)){
                        sList += parts[1]+"#";
                        break;
                    }
                }
            }

            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sList;
    }
    private String priceList(String food){
        String price="";

        try{
            FileReader file = new FileReader("C:/Users/Shahriar Rahman/OneDrive/onlinefood/src/main/java/com/example/onlinefood/food.txt");
            BufferedReader reader = new BufferedReader(file);

            String line;
            while((line=reader.readLine()) != null){
                String [] parts = line.split("#");
                if(parts[1].equals(food)){
                    price += parts[3];
                    break;
                }
            }

            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return price;
    }
}
