/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Purew
 */
public class Reader {
    public static void main(String[] args) throws Exception {
        Scanner in =  new Scanner(System.in);
        //get the file
        FileReader file = new FileReader("C:/Users/Purew/OneDrive/Desktop/passFile.txt");
        BufferedReader reader = new BufferedReader(file);
        
        //get the text in the file
        String text = "";
        String line = reader.readLine();
        while (line != null){
            text += line;
            text += "*";
            line = reader.readLine();
        }
        
        //close render
        reader.close();
        
        //ask for the wanted catagory
        System.out.println("What catagory would you like?");
        String cat = in.nextLine();
        
        //change the case
        text.toLowerCase();
        cat.toLowerCase();
        
        //search for the catagory
        if(text.contains(cat)){
            int passStart = text.indexOf(cat) + cat.length() + 3;
            int passEnd = text.indexOf("*", passStart);
            String pass = text.substring(passStart, passEnd);
            System.out.println("The Password for the catagory " + cat + " is " + pass);
        }else{
            System.out.println("That's a known catagory!");
        }
    }
}
