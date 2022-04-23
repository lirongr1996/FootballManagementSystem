package Service;


import Domain.AppController;

import java.util.Scanner;

public class UserService {
    public static Scanner reader=new Scanner(System.in);

    public static String[] getInput (String s1,String s2){
        String[] input=new String[2];
        System.out.println(s1);
        input[0]=reader.next();
        System.out.println(s2);
        input[1]=reader.next();
        return input;
    }

    public static void main (String args[]){
        AppController ac=new AppController();
        String username=null;
        String []input=new String[2];
        int chosen;

        do {
            System.out.println("1. login");
            System.out.println("2. Referee Registration");
            System.out.println("3. Games Placement");
            System.out.println("4. exit");
            chosen=reader.nextInt();
            switch (chosen){
                case 1:
                    input=getInput("Enter your username: ","Enter your password: ");
                    username=ac.login(input[0],input[1]);
                    break;
                case 2:
                    if(username==null) {
                        System.out.println("you need to login first");
                        break;
                    }
                    input=getInput("Enter referee's name: ","Enter the training: ");
                    ac.RefereeRegistration(username,input[0],input[1]);
                     break;
                case 3:
                    if(username==null) {
                        System.out.println("you need to login first");
                        break;
                    }
                    input=getInput("Enter referee's name: ","Enter the training: ");
                    ac.Placement(username,input[0],input[1]);
                    break;
            }

        }while(chosen==4);

    }
}
