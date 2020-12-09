package com.dkit.GD2.KeithJoyce;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformationDB
{
    private ArrayList<StudentInformation> studentsInfo;
    private static Scanner keyboard = new Scanner(System.in);

    public StudentInformationDB()
    {
        this.studentsInfo = new ArrayList<>();
    }

    protected void loadStudentsInfoFromFile()
    {
        try(Scanner studentsInfoFile = new Scanner(new BufferedReader(new FileReader("StudentInformation.txt"))))
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
        try(BufferedWriter studentsInfoFile = new BufferedWriter(new FileWriter("StudentInformation.txt")))
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
            System.out.println(Colours.RED+"Sorry could not save student to system"+Colours.RESET);
        }
    }





}
