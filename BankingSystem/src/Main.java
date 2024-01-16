import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.Thread;

public class Main {
    static Scanner input = new Scanner(System.in);
    static user_pin user_pin = new BankingSystem();
    static BankingSystem bnkstm = new BankingSystem();

    public static void main(String[] args) throws InterruptedException {
        boolean closeProgram = false;
        do {
            SimpleBankingSystemLogo();
            SimpleBankingSystemBody();
        System.out.print("\t\t\t\t\tEnter your PIN : ");
        user_pin.setUserPIN(input.nextInt());
        BankingSystem.clearscreen();
        BankingSystem.LoadingAnimation();
        while (user_pin.getUserPIN() != bnkstm.defaultPIN) {
            BankingSystem.clearscreen();
            SimpleBankingSystemLogo();
            SimpleBankingSystemBody();
            System.out.print("\t\t\t\t\tIncorrect PIN : ");
            user_pin.setUserPIN(input.nextInt());
            BankingSystem.clearscreen();
            BankingSystem.LoadingAnimation();

        }

        input.nextLine();
        //////////////////////////////////////////////////////////////////////////////////////
            boolean exitMainMenu = false;
            do {
                MainMenu();
                System.out.print("\t\t\t\t\t\tEnter your Choice : ");
                char choice = input.nextLine().charAt(0);
                switch(choice) {
                    case 'A':
                        BankingSystem.clearscreen();
                        bnkstm.Withdraw();
                        break;
                    case 'B':
                        BankingSystem.clearscreen();
                        bnkstm.Deposit();
                        BankingSystem.AMLACheck(BankingSystem.money);
                        BankingSystem.clearscreen();
                        BankingSystem.LoadingAnimation();
                        BankingSystem.clearscreen();
                        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                        System.out.println("\t\t\t|           Deposit successful.           |\t\t\t");
                        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                        System.out.println(" ");
                        System.out.print("\t\t\tWould you like to print the receipt? [Y/N] : ");
                        char printReceipt = input.nextLine().charAt(0);
                        while(printReceipt != 'y' && printReceipt != 'Y' && printReceipt != 'n' && printReceipt != 'N') {
                            System.out.println(" ");
                            System.out.print("\t\t\tInvalid Choice : ");
                            printReceipt = input.nextLine().charAt(0);
                        }
                        if(printReceipt=='y' || printReceipt=='Y') {
                            BankingSystem.clearscreen();
                            BankingSystem.LoadingAnimation();
                            bnkstm.receipt(BankingSystem.amountDeposit,"Deposit", BankingSystem.money);
                            System.out.println(" ");
                            System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
                            char exitReceipt = input.nextLine().charAt(0);
                            while(exitReceipt != 'x' && exitReceipt != 'X') {
                                System.out.println(" ");
                                System.out.print("\t\t\tInvalid choice : ");
                                exitReceipt = input.nextLine().charAt(0);
                            }
                            BankingSystem.clearscreen();
                        }
                        else {
                            BankingSystem.clearscreen();
                        }
                        break;
                    case 'C':
                        BankingSystem.clearscreen();
                        bnkstm.CheckBalance();
                        System.out.print("\t\t\tEnter [X] to go back to Main menu : ");
                        char exitCheckBalance = input.nextLine().charAt(0);
                        while(exitCheckBalance!='x' && exitCheckBalance!='X') {
                            System.out.print("\t\t\tInvalid input : ");
                            exitCheckBalance = input.nextLine().charAt(0);
                        }
                        BankingSystem.clearscreen();
                        break;
                    case 'D':
                        BankingSystem.clearscreen();
                        bnkstm.ChangePIN();
                        break;
                }
                if(choice=='X') {
                    exitMainMenu = true;
                }
            }while(!exitMainMenu);
        //////////////////////////////////////////////////////////////////////////////////////////
            System.out.println(" " + " ");
            System.out.print("\t\t\tWould you like to close the program? [Y/N] : ");
            char closeProgramChoice = input.nextLine().charAt(0);
            if(closeProgramChoice=='y' || closeProgramChoice=='Y') {
                closeProgram = true;
            }
            BankingSystem.clearscreen();
    }while(!closeProgram);
        BankingSystem.clearscreen();
        endProgramMSG();
    }

    static void SimpleBankingSystemLogo() {
        System.out.println(" ");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|          Simple Banking System          |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
    }

    static void SimpleBankingSystemBody() {
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|                Made By                  |\t\t\t");
        System.out.println("\t\t\t|                  Bucz                   |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
    }

    static void MainMenu() {
        SimpleBankingSystemLogo();
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|        [A] Withdraw   [B] Deposit       |\t\t\t");
        System.out.println("\t\t\t|                                         |\t\t\t");
        System.out.println("\t\t\t|   [C] Check Balance    [D] Change PIN   |\t\t\t");
        System.out.println("\t\t\t|                                         |\t\t\t");
        System.out.println("\t\t\t|            [X] EXIT MAIN MENU           |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
    }



    static void endProgramMSG() {
        System.out.println("\t\t\t*------------------------------------------*\t\t\t");
        System.out.println("\t\t\t|     Thank You For Using The Program!    |\t\t\t");
        System.out.println("\t\t\t*------------------------------------------*\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|   [   Special Thanks To Our Group   ]   |\t\t\t");
        System.out.println("\t\t\t|                                         |\t\t\t");
        System.out.println("\t\t\t|  Group Member #1       Group Member #2  |\t\t\t");
        System.out.println("\t\t\t|  Group Member #3       Group Member #4  |\t\t\t");
        System.out.println("\t\t\t|              Group Member #5            |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
    }
}

class user_pin {
    private int userPin;
    void setUserPIN(int userPin) {
        this.userPin = userPin;
    }

    int getUserPIN() {
        return userPin;
    }
    int defaultPIN = 123456;
}

class BankingSystem extends user_pin {
    static Scanner input = new Scanner(System.in);
    static int money = 100000;
    int amountWithdraw = 0;
    static int amountDeposit = 0;
    Date crtDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    void Withdraw() throws InterruptedException {

        int []WithdrawMoney = {1000, 2000, 4000, 7000, 9000, amountWithdraw};
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|                Withdraw                 |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|          [A] 1,000   [B] 2,000          |\t\t\t");
        System.out.println("\t\t\t|                                         |\t\t\t");
        System.out.println("\t\t\t|          [C] 4,000   [D] 7,000          |\t\t\t");
        System.out.println("\t\t\t|                                         |\t\t\t");
        System.out.println("\t\t\t|          [E] 9,000   [F] OTHERS         |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");

        System.out.print("\t\t\t\t\t\t Enter your choice : ");
        char choice = input.nextLine().charAt(0);
        clearscreen();
        switch (choice) {

            case 'A':
                if(WithdrawMoney[0] >= money) {
                    sufficientFundLogo();
                    Thread.sleep(3000);
                    clearscreen();
                    break;
                }
                LoadingAnimation();
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                System.out.println("\t\t\t|         You have Withdraw [1,000]       |\t\t\t");
                System.out.println("\t\t\t|             From your Account           |\t\t\t");
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                money -= WithdrawMoney[0];
                System.out.println(" ");
                System.out.print("\t\t\tWould you like to print the receipt? [Y/N] : ");
                char printReceipt = input.nextLine().charAt(0);
                while(printReceipt != 'y' && printReceipt != 'Y' && printReceipt != 'n' && printReceipt != 'N') {
                    System.out.println(" ");
                    System.out.print("\t\t\tInvalid Choice : ");
                    printReceipt = input.nextLine().charAt(0);
                }
                if(printReceipt=='y' || printReceipt=='Y') {
                    clearscreen();
                    LoadingAnimation();
                    clearscreen();
                    receipt(WithdrawMoney[0],"Withdraw",money);
                    System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
                    char exitReceipt = input.nextLine().charAt(0);
                    while(exitReceipt != 'x' && exitReceipt != 'X') {
                        System.out.println(" ");
                        System.out.print("\t\t\tInvalid choice : ");
                        exitReceipt = input.nextLine().charAt(0);
                    }
                    clearscreen();
                }
                else {
                    clearscreen();
                    break;
                }
                break;

            case 'B':
                if(WithdrawMoney[1] >= money) {
                    sufficientFundLogo();
                    Thread.sleep(3000);
                    clearscreen();
                    break;
                }
                LoadingAnimation();
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                System.out.println("\t\t\t|        You have Withdraw [2,000]        |\t\t\t");
                System.out.println("\t\t\t|            From your Account            |\t\t\t");
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                money -= WithdrawMoney[1];
                System.out.println(" ");
                System.out.print("\t\t\tWould you like to print the receipt? [Y/N] : ");
                printReceipt = input.nextLine().charAt(0);
                while(printReceipt != 'y' && printReceipt != 'Y' && printReceipt != 'n' && printReceipt != 'N') {
                    System.out.println(" ");
                    System.out.print("\t\t\tInvalid Choice : ");
                    printReceipt = input.nextLine().charAt(0);
                }
                if(printReceipt=='y' || printReceipt=='Y') {
                    clearscreen();
                    LoadingAnimation();
                    clearscreen();
                    receipt(WithdrawMoney[1],"Withdraw",money);
                    System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
                    char exitReceipt = input.nextLine().charAt(0);
                    while(exitReceipt != 'x' && exitReceipt != 'X') {
                        System.out.println(" ");
                        System.out.print("\t\t\tInvalid choice : ");
                        exitReceipt = input.nextLine().charAt(0);
                    }
                    clearscreen();
                }
                else {
                    clearscreen();
                    break;
                }
                break;

            case 'C':
                if(WithdrawMoney[2] >= money) {
                    sufficientFundLogo();
                    Thread.sleep(3000);
                    clearscreen();
                    break;
                }
                LoadingAnimation();
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                System.out.println("\t\t\t|         You have Withdraw [4,000]       |\t\t\t");
                System.out.println("\t\t\t|             From your Account           |\t\t\t");
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                money -= WithdrawMoney[2];
                System.out.println(" ");
                System.out.print("\t\t\tWould you like to print the receipt? [Y/N] : ");
                printReceipt = input.nextLine().charAt(0);
                while(printReceipt != 'y' && printReceipt != 'Y' && printReceipt != 'n' && printReceipt != 'N') {
                    System.out.println(" ");
                    System.out.print("\t\t\tInvalid Choice : ");
                    printReceipt = input.nextLine().charAt(0);
                }
                clearscreen();
                if(printReceipt=='y' || printReceipt=='Y') {
                    LoadingAnimation();
                    clearscreen();
                    receipt(WithdrawMoney[2],"Withdraw",money);
                    System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
                    char exitReceipt = input.nextLine().charAt(0);
                    while(exitReceipt != 'x' && exitReceipt != 'X') {
                        System.out.println(" ");
                        System.out.print("\t\t\tInvalid choice : ");
                        exitReceipt = input.nextLine().charAt(0);
                    }
                    clearscreen();
                }
                else {
                    clearscreen();
                    break;
                }
                break;

            case 'D':
                if(WithdrawMoney[3] >= money) {
                    sufficientFundLogo();
                    Thread.sleep(3000);
                    clearscreen();
                    break;
                }
                LoadingAnimation();
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                System.out.println("\t\t\t|        You have Withdraw [7,000]        |\t\t\t");
                System.out.println("\t\t\t|            From your Account            |\t\t\t");
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                money -= WithdrawMoney[3];
                System.out.println(" ");
                System.out.print("\t\t\tWould you like to print the receipt? [Y/N] : ");
                printReceipt = input.nextLine().charAt(0);
                while(printReceipt != 'y' && printReceipt != 'Y' && printReceipt != 'n' && printReceipt != 'N') {
                    System.out.println(" ");
                    System.out.print("\t\t\tInvalid Choice : ");
                    printReceipt = input.nextLine().charAt(0);
                }
                if(printReceipt=='y' || printReceipt=='Y') {
                    clearscreen();
                    LoadingAnimation();
                    clearscreen();
                    receipt(WithdrawMoney[3],"Withdraw",money);
                    System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
                    char exitReceipt = input.nextLine().charAt(0);
                    while(exitReceipt != 'x' && exitReceipt != 'X') {
                        System.out.println(" ");
                        System.out.print("\t\t\tInvalid choice : ");
                        exitReceipt = input.nextLine().charAt(0);
                    }
                    clearscreen();
                }
                else {
                    clearscreen();
                    break;
                }
                break;

            case 'E':
                if(WithdrawMoney[4] >= money) {
                    sufficientFundLogo();
                    Thread.sleep(3000);
                    clearscreen();
                    break;
                }
                LoadingAnimation();
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                System.out.println("\t\t\t|        You have Withdraw [9,000]        |\t\t\t");
                System.out.println("\t\t\t|            From your Account            |\t\t\t");
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                money -= WithdrawMoney[4];
                System.out.println(" ");
                System.out.print("\t\t\tWould you like to print the receipt? [Y/N] : ");
                printReceipt = input.nextLine().charAt(0);
                while(printReceipt != 'y' && printReceipt != 'Y' && printReceipt != 'n' && printReceipt != 'N') {
                    System.out.println(" ");
                    System.out.print("\t\t\tInvalid Choice : ");
                    printReceipt = input.nextLine().charAt(0);
                }
                if(printReceipt=='y' || printReceipt=='Y') {
                    clearscreen();
                    LoadingAnimation();
                    clearscreen();
                    receipt(WithdrawMoney[4],"Withdraw",money);
                    System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
                    char exitReceipt = input.nextLine().charAt(0);
                    while(exitReceipt != 'x' && exitReceipt != 'X') {
                        System.out.println(" ");
                        System.out.print("\t\t\tInvalid choice : ");
                        exitReceipt = input.nextLine().charAt(0);
                    }
                    clearscreen();
                }
                else {
                    clearscreen();
                    break;
                }
                break;
            case 'F':
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                System.out.println("\t\t\t|                  OTHERS                 |\t\t\t");
                System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
                System.out.print  ("\t\t\tEnter the amount you want to Withdraw : ");
                WithdrawMoney[5] = input.nextInt();
                if(WithdrawMoney[5] >= money) {
                    sufficientFundLogo();
                    Thread.sleep(3000);
                    input.nextLine();
                    clearscreen();
                    break;
                }
                money -= WithdrawMoney[5];
                input.nextLine();
                System.out.println(" ");
                System.out.print("\t\t\tWould you like to print the receipt? [Y/N] : ");
                printReceipt = input.nextLine().charAt(0);
                while(printReceipt != 'y' && printReceipt != 'Y' && printReceipt != 'n' && printReceipt != 'N') {
                    System.out.println(" ");
                    System.out.print("\t\t\tInvalid Choice : ");
                    printReceipt = input.nextLine().charAt(0);
                }
                if(printReceipt=='y' || printReceipt=='Y') {
                    clearscreen();
                    LoadingAnimation();
                    clearscreen();
                    receipt(WithdrawMoney[5],"Withdraw",money);
                    System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
                    char exitReceipt = input.nextLine().charAt(0);
                    while(exitReceipt != 'x' && exitReceipt != 'X') {
                        System.out.println(" ");
                        System.out.print("\t\t\tInvalid choice : ");
                        exitReceipt = input.nextLine().charAt(0);
                    }
                    clearscreen();
                }
                else {
                    clearscreen();
                    break;
                }

                break;
        }

    }

    void Deposit() {
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|                Deposit                  |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println(" ");
        System.out.print("\t\t\tEnter the amount you want to deposit : ");
        amountDeposit = input.nextInt();
        money += amountDeposit;
    }

    void CheckBalance() {
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t          Your Current Balance :           \t\t\t");
        System.out.println("\t\t\t\t\t\t\t [" + money + "₱]            \t\t\t\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
    }

    void ChangePIN() throws InterruptedException {
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|               Change PIN                |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println(" ");
        System.out.print("\t\t\tEnter new PIN : ");
        defaultPIN = input.nextInt();
        clearscreen();
        LoadingAnimation();
        clearscreen();
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|         PIN Successfully Change!        |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        input.nextLine();
        System.out.print("\t\t\tEnter [X] to go back to the Main menu : ");
        char exitReceipt = input.nextLine().charAt(0);
        while(exitReceipt != 'x' && exitReceipt != 'X') {
            System.out.println(" ");
            System.out.print("\t\t\tInvalid choice : ");
            exitReceipt = input.nextLine().charAt(0);
        }
        clearscreen();
    }

    //////////////////////FUNCTIONALITIES///////////////////////////
    static void LoadingAnimation() throws InterruptedException {
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        System.out.println("\t\t\t|                Processing               |\t\t\t");
        System.out.println("\t\t\t*-----------------------------------------*\t\t\t");
        for(int i = 0; i<=50; i++) {
            Thread.sleep(100);
            System.out.print("\r\t\t\t\t\t\t\t  [ "+i+"% ]");
        }
        clearscreen();
    }

    static void clearscreen() {
        for(int i = 0; i<30; i++) {
            System.out.println(" ");
        }
    }

    static void sufficientFundLogo() throws InterruptedException {
        clearscreen();
        LoadingAnimation();
        clearscreen();
        System.out.println("\t\t\t*-------------------------------------------------------*\t\t\t");
        System.out.println("\t\t\t| Unable to complete transaction. Insufficient balance. |\t\t\t");
        System.out.println("\t\t\t*-------------------------------------------------------*\t\t\t");
    }

    static void AMLACheck(int cash) throws InterruptedException {
        if (cash > 500000) {
            clearscreen();
            LoadingAnimation();
            clearscreen();
            System.out.println("\t\t\t*------------------------------------------------*\t\t\t");
            System.out.println("\t\t\t| Deposits over $500,000 require AMLA reporting. |\t\t\t");
            System.out.println("\t\t\t|     Please allow 15 seconds for processing     |\t\t\t");
            System.out.println("\t\t\t|            before funds transfer.              |\t\t\t");
            System.out.println("\t\t\t*------------------------------------------------*\t\t\t");
            Thread.sleep(15000);
            input.nextLine();
            clearscreen();

        }
    }
    /////////////////////RECEIPT///////////////////////////////////
    void receipt(int WithdrawMoney, String transactionType, int curBalance) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Manila"));
        String DateNTime = dateFormat.format(crtDate);
        System.out.println("\t\t\t*------------------------------------------*\t\t\t");
        System.out.println("\t\t\t|          B A N K    R E C E I P T        |\t\t\t");
        System.out.println("\t\t\t*------------------------------------------*\t\t\t");
        System.out.println("\t\t\t*------------------------------------------*\t\t\t");
        System.out.println("\t\t\t|   Date & Time: " + DateNTime + "       |");
        System.out.println("\t\t\t|                                          |");
        System.out.println("\t\t\t|   Transaction Type : " + transactionType + "            |");
        System.out.println("\t\t\t|                                          |");
        System.out.println("\t\t\t|   Amount ₱ : " + WithdrawMoney + "                        |");
        System.out.println("\t\t\t|                                          |");
        System.out.println("\t\t\t|   Current Balance : " + curBalance + "                |");
        System.out.println("\t\t\t*------------------------------------------*\t\t\t");
    }

}