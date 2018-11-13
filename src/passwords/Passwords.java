/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwords;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Purew
 */
public class Passwords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean gened = false;

        int passwords = 0;

        String cat = "";

        String password = "";
        
        String pass = "";

        BufferedWriter buffW = null;

        //create a file for the passwords
        File passFile = new File("C:/Users/Purew/OneDrive/Desktop/passFile.txt");

        //check if the file was already created
        if (passFile.exists()) {
            //add to the file
            try {
                FileWriter fileW = new FileWriter(passFile, true);
                buffW = new BufferedWriter(fileW);
            } catch (IOException ex) {
                Logger.getLogger(Passwords.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //adding passwords
            boolean adding = false;
            do {
                try {
                    passFile.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //create a file (and buffer) writer
                try {
                    FileWriter fileW = new FileWriter(passFile);
                    buffW = new BufferedWriter(fileW);

                    //ask for what the password is for
                    System.out.println("What will this password be for?");
                    cat = in.nextLine();
                    //get the pass or gen one
                    System.out.println("What is the pass you want to store? (or type gen for a generated password)");
                    pass = in.nextLine();
                    if (pass.equalsIgnoreCase("gen")) {
                        gened = true;
                        //get the desired length
                        System.out.println("How long do you want the password to be?");
                        int passLength = in.nextInt();
                        //create a random pass
                        String[] passArray = new String[passLength];
                        //alphabet
                        String[] abc = new String[26];
                        abc[0] = "a";
                        abc[1] = "b";
                        abc[2] = "c";
                        abc[3] = "d";
                        abc[4] = "e";
                        abc[5] = "f";
                        abc[6] = "g";
                        abc[7] = "h";
                        abc[8] = "i";
                        abc[9] = "j";
                        abc[10] = "k";
                        abc[11] = "l";
                        abc[12] = "m";
                        abc[13] = "n";
                        abc[14] = "o";
                        abc[15] = "p";
                        abc[16] = "q";
                        abc[17] = "r";
                        abc[18] = "s";
                        abc[19] = "t";
                        abc[20] = "u";
                        abc[21] = "v";
                        abc[22] = "w";
                        abc[23] = "x";
                        abc[24] = "y";
                        abc[25] = "z";

                        for (int i = 0; i < passLength; i++) {
                            //if number(1) or letter(2)
                            int charType = (int) (Math.random() * 2 + 1);
                            if (charType == 1) {
                                int randNum = (int) (Math.random() * 9 + 0);
                                passArray[i] = Integer.toString(randNum);
                            } else {
                                int randNum = (int) (Math.random() * 25 + 0);
                                String let = abc[randNum];
                                passArray[i] = let;
                            }
                        }
                        //convert the array to the string
                        for (int i = 0; i < passLength; i++) {
                            pass += passArray[i];
                        }
                    }
                    passwords++;
                    password += "-" + cat + " : " + pass;

                    //ask if they want to add more passwords
                    System.out.println("Would like to add another password? [y/n]");
                    String answer = in.nextLine();
                    if (gened == true) {
                        String reset = in.nextLine();
                        gened = false;
                    }
                    if (answer.equalsIgnoreCase("n")) {
                        adding = false;
                        break;
                    } else {
                        adding = true;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } while (adding == true);
            try {
                //store the password under the catagory
                for (int i = 0; i < passwords - 1; i++) {
                    int start = password.indexOf("-") + 1;
                    int end = cat.length() + pass.length() + 3;
                    String fin = password.substring(start, end);
                    password = password.substring(fin.length() + 1, password.length());
                    buffW.write(fin);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Passwords.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                buffW.close();
            } catch (IOException ex) {
                Logger.getLogger(Passwords.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
