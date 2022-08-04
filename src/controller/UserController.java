package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import model.User;


public class UserController {
    private User user;
    private LinkedList<User> users;
    
    public UserController(){
        read();
    }
    
    public void read(){
        try{
            FileReader filePath = new FileReader("data/users.csv");
            Scanner file = new Scanner(filePath);
            users = new LinkedList<User>();

            while(file.hasNext()){
                String[] data = file.nextLine().split(",");
                user = new User(data[0], data[1]);
                users.add(user);
            }

            file.close();
            filePath.close();
        }catch(IOException error){
            System.out.println("Read error");
        }

    }
    
    public boolean read(String username, String password){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername().equals(username) 
                && users.get(i).getPassword().equals(password)){
                System.out.println("welcome");
                return true;
            }
        }
        System.out.println("Access Denied");
        return false;
    }

    public void create(String username, String password){
        try{
            FileWriter file = new FileWriter("data/users.csv", true);
            User user = new User(username, password);
            users.add(user);
            file.write(username + "," + password);
            file.write(System.lineSeparator());

            file.close();
        }catch(IOException error){
            System.out.println("Create error");
        }

    }

    public void update(String username, String newUsername, String password, String newPassword){
        try{
            FileWriter file = new FileWriter("data/users.csv", false);

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                    users.get(i).setUsername(newUsername);
                    users.get(i).setPassword(newPassword);
                }
                file.write(users.get(i).getUsername() + "," + users.get(i).getPassword());
                file.write(System.lineSeparator());
            }

            file.close();
        }catch(IOException error){
            System.out.println("Update error");
        }

    }
    
    public void delete(String username, String password) {
        try{
            FileWriter file = new FileWriter("data/users.csv", false);

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                    users.set(i, null);
                }else{
                    file.write(users.get(i).getUsername() + "," + users.get(i).getPassword());
                    file.write(System.lineSeparator());
                }
            }

            file.close();
        }catch(IOException error){
            System.out.println("Delete error");
        }
    }
}
