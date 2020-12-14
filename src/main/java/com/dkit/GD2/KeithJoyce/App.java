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
        LoanSystemDB loanSystemDB = new LoanSystemDB();
        mainMenuLoop(loanSystemDB);
        StudentInformationMenuLoop(loanSystemDB);
        BookingMenuLoop(loanSystemDB);
        ComputerMenuLoop(loanSystemDB);
    }

    private void mainMenuLoop(LoanSystemDB loanSystemDB)
    {
        loanSystemDB.loadStudentsInfoFromFile();
        loanSystemDB.loadBookingInfoFromFile();
        loanSystemDB.loadDesktopFromFile();
        loanSystemDB.loadLaptopFromFile();
        loanSystemDB.loadRaspberryPiFile();

        boolean loop = true;
        MainMenu menuOption;
        int option;
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
                    if(option < 0 || option >= MainMenu.values().length)
                    {
                        throw new IllegalArgumentException();
                    }
                }
                menuOption = MainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_APPLICATION:
                        loop = false;
                        break;
                    case DISPLAY_STUDENT_INFORMATION_MENU:
                        StudentInformationMenuLoop(loanSystemDB);
                        break;
                    case DISPLAY_BOOKING_MENU:
                        BookingMenuLoop(loanSystemDB);
                        break;
                    case DISPLAY_COMPUTERS_MENU:
                        ComputerMenuLoop(loanSystemDB);
                        break;
                }
            }
            catch(InputMismatchException ime)
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

    private void StudentInformationMenuLoop(LoanSystemDB loanSystemDB)
    {
        StudentInformationMenu menuOption;
        boolean loop = true;
        int option = -1;
        while(loop)
        {
            printStudentInformationMenu();
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
                    if(option < 0 || option >= StudentInformationMenu.values().length)
                    {
                        throw new IllegalArgumentException();
                    }
                }

                menuOption = StudentInformationMenu.values()[option];
                switch (menuOption)
                {
                    case QUIT_STUDENT_INFORMATION_MENU:
                        loop = false;
                        break;
                        //CASES TO DEAL WITH STUDENT INFORMATION
                    case ADD_STUDENT:
                        loanSystemDB.addStudent();
                        break;
                    case EDIT_STUDENT:
                        loanSystemDB.editStudent();
                        break;
                    case REMOVE_STUDENT:
                        loanSystemDB.deleteStudent();
                        break;
                    case PRINT_STUDENT:
                        loanSystemDB.printStudent();
                        break;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
            catch(IllegalArgumentException iae)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
        }
        loanSystemDB.saveStudentInformationToFile();
        System.out.println(Colours.GREEN + "Saving student information to file" + Colours.RESET);
        System.out.println(Colours.BLUE + "Exiting the student information menu" + Colours.RESET);
    }

    private void BookingMenuLoop(LoanSystemDB loanSystemDB)
    {
        BookingMenu menuOption;
        boolean loop = true;
        int option;
        while (loop)
        {
            printBookingMenu();
            try
            {
                String input = keyboard.nextLine();
                if (input.isEmpty() || input.length() > 1)
                {
                    throw new IllegalArgumentException();

                } else {
                    option = Integer.parseInt(input);
                    if (option < 0 || option >= BookingMenu.values().length) {
                        throw new IllegalArgumentException();
                    }
                }
                menuOption = BookingMenu.values()[option];
                switch (menuOption)
                {
                    case QUIT_BOOKING_MENU:
                        loop = false;
                        break;
                    case ADD_BOOKING:
                        loanSystemDB.addBooking();
                        break;
                    case PRINT_STUDENT_BOOKING:
                        loanSystemDB.printBooking();
                        break;
                    case PRINT_ALL_CURRENT_BOOKINGS:
                        loanSystemDB.printAllBookings();
                        break;
                    case DELETE_BOOKING:
                        loanSystemDB.deleteBooking();
                        break;
                    case RETURN_BOOKING:
                        System.out.println("Not implemented");
                        break;
                    case EDIT_BOOKING:
                        loanSystemDB.editBooking();
                        break;
                    case PRINT_AVERAGE_LENGTH:
                        System.out.println("Not implemented");
                        break;
                    case PRINT_STATISTICS:
                        System.out.println("Not implemented");
                        break;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
            catch(IllegalArgumentException iae)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
        }
        loanSystemDB.saveBookingInformationToFile();
        System.out.println(Colours.GREEN + "Saving booking information to file" + Colours.RESET);
        System.out.println(Colours.BLUE + "Exiting the booking menu" + Colours.RESET);
    }

    private void ComputerMenuLoop(LoanSystemDB loanSystemDB)
    {
        ComputerMenu menuOption;
        boolean loop = true;
        int option;
        while(loop)
        {
            printComputerMenu();
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
                    if(option < 0 || option >= ComputerMenu.values().length)
                    {
                        throw new IllegalArgumentException();
                    }
                }
                menuOption = ComputerMenu.values()[option];
                switch (menuOption)
                {
                    case QUIT_COMPUTER_MENU:
                        loop = false;
                        break;
                    case LAPTOPS:
                        loanSystemDB.printAllDesktops();
                        break;
                    case DESKTOPS:
                        loanSystemDB.printAllLaptops();
                        break;
                    case RASPBERRY_PIs:
                        loanSystemDB.printAllRaspberryPi();
                        break;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
            catch(IllegalArgumentException iae)
            {
                System.out.println(Colours.RED + "You entered a non valid option, please enter a valid option" + Colours.RESET);
            }
        }

        System.out.println(Colours.BLUE + "Exiting the Computer menu" + Colours.RESET);
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

    private void printStudentInformationMenu()
    {
        System.out.println("\n System Options: ");
        for(int i = 0; i < StudentInformationMenu.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + StudentInformationMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Please enter the number for the option you would like to use, press 0 to quit the system :");
    }

    private void printBookingMenu()
    {
        System.out.println("\n System Options: ");
        for(int i = 0; i < BookingMenu.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + BookingMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Please enter the number for the option you would like to use, press 0 to quit the system :");
    }

    private void printComputerMenu()
    {
        System.out.println("\n System Options: ");
        for(int i = 0; i < ComputerMenu.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + ComputerMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Please enter the number for the option you would like to use, press 0 to quit the system :");
    }


}
