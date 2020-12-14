package com.dkit.GD2.KeithJoyce;

public class StudentInformation
{
    private String studentName;
    private String studentEmail;
    private String studentID;
    private String studentPhoneNumber;
    private String studentComputersOnLoan;


    public StudentInformation(String studentName, String studentEmail, String studentID, String studentPhoneNumber, String studentComputersOnLoan)
    {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentID = studentID;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentComputersOnLoan = studentComputersOnLoan;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public String getStudentEmail()
    {
        return studentEmail;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public String getStudentPhoneNumber()
    {
        return studentPhoneNumber;
    }

    public String getStudentComputersOnLoan()
    {
        return studentComputersOnLoan;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public void setStudentEmail(String studentEmail)
    {
        this.studentEmail = studentEmail;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber)
    {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public void setStudentComputersOnLoan(String studentComputersOnLoan)
    {
        this.studentComputersOnLoan = studentComputersOnLoan;
    }

    @Override
    public String toString()
    {
        return "StudentInformation{" +
                "studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentID='" + studentID + '\'' +
                ", studentPhoneNumber='" + studentPhoneNumber + '\'' +
                ", studentComputersOnLoan='" + studentComputersOnLoan + '\'' +
                '}';
    }
}
