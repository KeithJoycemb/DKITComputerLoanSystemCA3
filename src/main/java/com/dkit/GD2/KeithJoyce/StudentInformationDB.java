package com.dkit.GD2.KeithJoyce;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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


}
