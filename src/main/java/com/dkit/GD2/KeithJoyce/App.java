package com.dkit.GD2.KeithJoyce;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 *
 */
public class App 
{
    private static Scanner keyboard = new Scanner(System.in);

    public static void main( String[] args )
    {
        App loanSystemDB = new App();
        loanSystemDB.start();
    }

    private void start()
    {
        System.out.println(Colours.BLUE + "Hello and welcome to the DKIT computer loan system" + Colours.RESET);
        LoanSystemDB  loanSystemDB = new LoanSystemDB();
        MainMenuLoop(loanSystemDB);
    }

    private void MainMenuLoop(LoanSystemDB loanSystemDB)
    {
        boolean loop = true;
        MainMenu menuOption;
        int option = -1;
        while(loop)

        {
            printMainMenu();
            try
            {
                String input = keyboard.nextLine();

                if(input.isEmpty() || input.length() > 1)
                {
                    throw new IllegalArgumentException();
                }
                else
                {
                    option = Integer.parseInt(input);
                }
                if(option < 0 || option >= MainMenu.values().length)
                {
                    throw new IllegalArgumentException();
                }

                menuOption = MainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_APPLICATION:
                        loop = false;
                        break;
                    case DISPLAY_LOAN_SYSTEM_MENU:
                        LoanSystemMenuLoop(loanSystemDB);
                        break;
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
                keyboard.nextLine();
            }

            catch(IllegalArgumentException iae)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
        }
        System.out.println(Colours.BLUE + "Thank you for using the DKIT Loan System" + Colours.RESET);
    }

    private void LoanSystemMenuLoop(LoanSystemDB loanSystemDB)
    {
        LoanSystemMenu menuOption;
        boolean loop = true;
        int option;
        while(loop)
        {
            printLoanSystemMenu();
            try
            {
                String input = keyboard.nextLine();

                if(input.isEmpty() || input.length() > 1)
                {
                    throw new IllegalArgumentException();
                }
                else
                {
                    option = Integer.parseInt(input);
                }
                if(option < 0 || option >= MainMenu.values().length)
                {
                    throw new IllegalArgumentException();
                }

                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = LoanSystemMenu.values()[option];
                switch (menuOption)
                {
                    case QUIT_LOAN_SYSTEM_MENU:
                        loop = false;
                        break;
                    case ADD_STUDENT:
                        System.out.println("CODE NEEDED");
                        break;
                    case EDIT_STUDENT:
                        System.out.println("CODE NEEDED");
                        break;
                    case REMOVE_STUDENT:
                        System.out.println("CODE NEEDED");
                        break;
                    case PRINT_STUDENT_BOOKING:
                        System.out.println("CODE NEEDED");
                        break;
                    case PRINT_ALL_CURRENT_BOOKINGS:
                        System.out.println("CODE NEEDED");
                        break;
                    case RETURN_BOOKING:
                        System.out.println("CODE NEEDED");
                        break;
                    case PRINT_AVERAGE_LENGTH:
                        System.out.println("CODE NEEDED");
                        break;
                    case PRINT_STATISTICS:
                        System.out.println("CODE NEEDED");
                        break;
                }
            } catch (InputMismatchException ime)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
            catch(IllegalArgumentException iae)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
        }
        System.out.println(Colours.BLUE + "Thank you for using the DKIT Loan System" + Colours.RESET);
    }

    private void printLoanSystemMenu()
    {
        System.out.println("\n System Options: ");
        for(int i=0; i < LoanSystemMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + LoanSystemMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Please enter the number for the option you would like to use, press 0 to quit the system :");
    }

    private void printMainMenu()
    {
        System.out.println("\n System Options: ");
        for(int i=0; i < MainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + MainMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Please enter the number for the option you would like to use, press 0 to quit the system : ");
    }


}
