package com.dkit.GD2.KeithJoyce;

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
        System.out.print("Please enter the students " + Information + " : ");
        input = keyboard.nextLine();
        return input;
    }

    public void addStudent()
    {
        String studentName = enterInformation("Name");
        String studentEmail = enterInformation("Email");
        String studentID = enterInformation("ID");
        String studentPhoneNumber = enterInformation("Phone Number");
        String studentComputersOnLoan = enterInformation("Computer On Loan");

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

    //***********************************************************************BOOKING CODE***********************************************************************************************************************

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
            System.out.println(Colours.RED + "System could not load in student information" + Colours.RESET);
        }
    }

    public void addBooking()
    {
        int bookingID;
    }
}