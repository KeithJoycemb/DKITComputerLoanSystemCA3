package com.dkit.GD2.KeithJoyce;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
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
                String bookingDateAndTime = data[1];
                String returnDateAndTime = data[2];
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
        String bookingDateAndTime = enterInformation("Date of Booking");
        String returnDateAndTime = enterInformation("Date of return");
        String computerType = enterInformation("Type of computer");
        String computerAssetTag = enterInformation("Computer asset tag");
        String bookingStudentID = enterInformation(" Students ID");

        BookingInformation addBooking = new BookingInformation(bookingID, bookingDateAndTime, returnDateAndTime, computerType,computerAssetTag, bookingStudentID);
        this.bookingInfo.add(addBooking);
    }

    private BookingInformation searchForBooking(int bookingToFind)
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
        int bookingIDToPrint = Integer.parseInt(enterInformation("Booking to find"));
        BookingInformation bookingToPrint = searchForBooking(bookingIDToPrint);
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
            int bookingToFind = Integer.parseInt(enterInformation("Booking to delete"));
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
}