package com.dkit.GD2.KeithJoyce;

public class StudentInformation
{
    private String studentName;
    private String studentEmail;
    private String studentID;

    public StudentInformation(String studentName, String studentEmail, String studentID)
    {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentID = studentID;
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

    @Override
    public String toString()
    {
        return "StudentInformation{" +
                "studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
