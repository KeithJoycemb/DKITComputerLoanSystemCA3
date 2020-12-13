package com.dkit.GD2.KeithJoyce;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanSystemDB
{
    private ArrayList<StudentInformation> studentsInfo;
    private ArrayList<BookingInformation> bookingInfo;
    private static Scanner keyboard = new Scanner(System.in);

    public LoanSystemDB()
    {
        this.studentsInfo = new ArrayList<>();
        this.bookingInfo = new ArrayList<>();
    }

    protected void loadStudentsInfoFromFile()
    {
        try(Scanner studentsInfoFile = new Scanner(new BufferedReader(new FileReader("students.txt"))))
        {
            String input;
            while(studentsInfoFile.hasNextLine())
            {
                input = studentsInfoFile.nextLine();
                String[] data = input.split(",");
                String studentName = data[0];
                String studentEmail = data[1];
                String studentID = data[2];
                String studentPhoneNumber = data[3];
                String studentComputerOnLoan = data[4];

                StudentInformation readInStudent = new StudentInformation(studentName, studentEmail, studentID, studentPhoneNumber, studentComputerOnLoan);
                this.studentsInfo.add(readInStudent);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println(Colours.RED + "System could not load in student information" + Colours.RESET);
        }
    }

    public void saveStudentInformationToFile()
    {
        try(BufferedWriter studentsInfoFile = new BufferedWriter(new FileWriter("students.txt")))
        {
            for(StudentInformation student : studentsInfo)
            {
                studentsInfoFile.write(student.getStudentName() + "," + student.getStudentEmail() + "," + student.getStudentID() + "," +
                        student.getStudentPhoneNumber() + "," + student.getStudentComputersOnLoan());

                studentsInfoFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.RED + "Sorry could not save student to system" + Colours.RESET);
        }
    }

    private static String enterInformation(String Information)
    {
        String input;
        System.out.print("Please enter the " + Information + " : ");
        input = keyboard.nextLine();
        return input;
    }

    public void addStudent()
    {
        String studentName = enterInformation("Name of student");
        String studentEmail = enterInformation("Email of student");
        String studentID = enterInformation("Student ID");
        String studentPhoneNumber = enterInformation("Students Phone Number");
        String studentComputersOnLoan = enterInformation("Computer Student has on loan");

        StudentInformation addStudent = new StudentInformation(studentName, studentEmail, studentID, studentPhoneNumber, studentComputersOnLoan);
        this.studentsInfo.add(addStudent);
    }

    private StudentInformation searchForStudent(String studentToFind)
    {
        for (StudentInformation student : studentsInfo)
        {
            if (student.getStudentName().equals(studentToFind))
            {
                return student;
            }
        }
        return null;
    }

    public void printStudent()
    {
        String nameToPrint = enterInformation("Student to print");
        StudentInformation studentToPrint = searchForStudent(nameToPrint);
        if(studentToPrint != null)
        {
            System.out.println(studentToPrint);
        }
        else
        {
            System.out.println(Colours.RED + "This student does not exist in the system" + Colours.RESET);
        }
    }

    public void deleteStudent()
    {
        if(this.studentsInfo != null)
        {
            String studentToFind = enterInformation("Students name to delete");
            StudentInformation studentToDelete = searchForStudent(studentToFind);
            if(studentToDelete != null)
            {
                studentsInfo.remove(studentToDelete);
                System.out.println(Colours.GREEN + "Removed student from system" + Colours.RESET);
            }
            else
            {
                System.out.println(Colours.RED + "This student does not exist in the system" + Colours.RESET);
            }
        }
    }

    public void editStudent()
    {
        String studentToFind = enterInformation("Student to edit");
        StudentInformation studentToEdit = searchForStudent(studentToFind);

        boolean loop = true;
        EditStudentMenu menuOption;
        int option;
        while(loop)
        {
            printStudentMenu();
            try
            {
                String input = keyboard.nextLine();
                if (input.isEmpty() || input.length() > 1)
                {
                    throw new IllegalArgumentException();
                } else {
                    option = Integer.parseInt(input);
                    if (option < 0 || option >= EditStudentMenu.values().length)
                    {
                        throw new IllegalArgumentException();
                    }
                }

                menuOption = EditStudentMenu.values()[option];
                switch (menuOption)
                {
                    case QUIT_STUDENT_EDIT_MENU:
                        loop = false;
                        break;
                    case EDIT_STUDENT_NAME:
                        studentToEdit.setStudentName(enterInformation("Edit Name"));
                        break;
                    case EDIT_STUDENT_EMAIL:
                        studentToEdit.setStudentEmail(enterInformation("Edit Email"));
                        break;
                    case EDIT_STUDENT_ID:
                        studentToEdit.setStudentID(enterInformation("Edit Student ID"));
                        break;
                    case EDIT_STUDENT_PHONE_NUMBER:
                        studentToEdit.setStudentPhoneNumber(enterInformation("Edit Phonenumber"));
                        break;
                    case EDIT_STUDENT_COMPUTER_ON_LOAN:
                        studentToEdit.setStudentComputersOnLoan(enterInformation("Edit Computer on loan"));
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
        System.out.println(Colours.BLUE + "Student Information has been updated" + Colours.RESET);
    }

    private void printStudentMenu()
    {
        System.out.println("\n System Options: ");
        for(int i=0; i < EditStudentMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + EditStudentMenu.values()[i].toString()+Colours.RESET);
        }
        System.out.print("Please enter the number for the option you would like to use, press 0 to quit the system :");
    }

    //*******************************************************************************BOOKING CODE***********************************************************************************************************************

    public void saveBookingInformationToFile()
    {
        try(BufferedWriter bookingInfoFile = new BufferedWriter(new FileWriter("booking.txt")))
        {
            for(BookingInformation booking : bookingInfo)
            {
                bookingInfoFile.write(booking.getBookingID() + "," + booking.getBookingDateAndTime() + "," + booking.getReturnDateAndTime() + "," + booking.getComputerType() +
                        "," + booking.getComputerAssetTag() + "," + booking.getBookingStudentID());
                bookingInfoFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.RED + "Sorry could not save booking to system" + Colours.RESET);
        }
    }

    protected void loadBookingInfoFromFile()
    {
        try(Scanner bookingInfoFile = new Scanner(new BufferedReader(new FileReader("booking.txt"))))
        {
            String input;
            while(bookingInfoFile.hasNextLine())
            {
                input = bookingInfoFile.nextLine();
                String[] data = input.split(",");
                int bookingID =  Integer.parseInt(data[0]);
                LocalDateTime bookingDateAndTime = LocalDateTime.parse(data[2]);
                LocalDateTime returnDateAndTime = LocalDateTime.parse(data[1]);
                String computerType = data[3];
                String computerAssetTag = data[4];
                String bookingStudentID = data[5];

                BookingInformation readInBooking = new BookingInformation(bookingID,bookingDateAndTime,returnDateAndTime,computerType,computerAssetTag,bookingStudentID);
                this.bookingInfo.add( readInBooking);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println(Colours.RED + "System could not load in booking information" + Colours.RESET);
        }
    }

    public void addBooking()
    {
        int bookingID = Integer.parseInt(enterInformation("Booking ID"));
        LocalDateTime bookingDateAndTime = LocalDateTime.now();
        LocalDateTime returnDateAndTime =  LocalDateTime.now();
        String computerType = enterInformation("Type of computer");
        String computerAssetTag = enterInformation("Computer asset tag");
        String bookingStudentID = enterInformation(" Students ID");

        BookingInformation addBooking = new BookingInformation(bookingID, bookingDateAndTime, returnDateAndTime, computerType,computerAssetTag, bookingStudentID);
        this.bookingInfo.add(addBooking);
    }

    private BookingInformation searchForBooking(String bookingToFind)
    {
        for (BookingInformation booking : bookingInfo)
        {
            if (booking.getBookingStudentID().equals(bookingToFind))
            {
                return booking;
            }
        }
        return null;
    }

    public void printBooking()
    {
        String studentIDToPrint = enterInformation("Booking to find");
        BookingInformation bookingToPrint = searchForBooking(studentIDToPrint);
        if(bookingToPrint != null)
        {
            System.out.println(bookingToPrint);
        }
        else
        {
            System.out.println(Colours.RED + "This booking does not exist in the system" + Colours.RESET);
        }
    }

    public void deleteBooking()
    {
        if(this.bookingInfo != null)
        {
            String bookingToFind = enterInformation("Booking to delete");
            BookingInformation bookingToDelete = searchForBooking(bookingToFind);
            if(bookingToDelete != null)
            {
                bookingInfo.remove(bookingToDelete);
                System.out.println(Colours.GREEN + "Removed booking from system" + Colours.RESET);
            }
            else
            {
                System.out.println(Colours.RED + "There is no booking matching that ID" + Colours.RESET);
            }
        }
    }

    public void printAllBookings()
    {
        for(BookingInformation allBookings : bookingInfo)
        {
            System.out.println(allBookings);
        }
    }
}