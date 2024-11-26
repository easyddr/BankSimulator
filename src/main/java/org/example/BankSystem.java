package org.example;

import java.util.Scanner;

public class BankSystem {
    private int money = 10000;
    private String pinCode = "1234";

    Scanner scanner = new Scanner(System.in);

    public void userCommunication(){
        boolean a = true;

        System.out.println("Hello! I am chat bot of EMM Bank, how can I help you? ");
        System.out.println("Operations:\n-Put money on card(put)\n-Withdraw money(get)" +
                "\n-Put money on deposit(dep)\n-Check balance(show)\n-Exit from app(exit)");

        System.out.print("Enter your password: ");
        String printPin = scanner.next();

        while(a){
            if (!printPin.equals(pinCode)){
                System.out.println("Wrong password");
                break;
            }
            else{
                System.out.print("Enter: ");
                String userInp = scanner.next().trim().toLowerCase();

                switch (userInp){
                    case "put":
                        putOnBalance();
                        break;
                    case "get":
                        withdraw();
                        break;
                    case "show":
                        checkBalance();
                        break;
                    case "exit":
                        a = false;
                        break;
                    case "dep":
                        depositSystem();
                        break;


                }
            }


        }

    }

    private int withdraw(){
        System.out.print("Enter how much money you want to withdraw(ending -0-): ");
        int getMoney = scanner.nextInt();

        if(getMoney > money){
            System.out.println("Non avalible balance");
        }
        else{
            money -= getMoney;
            System.out.println("Succesful");
        }
        return money;
    }

    private void checkBalance(){
        System.out.print("Your balance: " + money + "\n");
    }

    private int putOnBalance(){
        System.out.print("Enter how much money you want to put on your balance(ending -0-): ");
        int putMoney = scanner.nextInt();

        if (putMoney % 10 == 0) {
            System.out.println("Succesful");
        }
        else{
            System.out.println("Error");
        }
        return money += putMoney;
    }

    private int depositSystem(){
        System.out.print("Enter how much money you want to put on deposit on 5% year(0-3000)(ending -0-): ");
        int deposit = scanner.nextInt();

        if (deposit > 0 && deposit <= 3000){
            int persentage = (int) (deposit * 0.5);
            money += persentage;
            System.out.println("Succesful, you get: " + persentage);
        }
        else {
            System.out.println("Enter number between 0 and 3000");
        }

        return money;
    }





}
