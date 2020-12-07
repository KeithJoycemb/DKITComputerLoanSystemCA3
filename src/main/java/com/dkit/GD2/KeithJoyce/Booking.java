package com.dkit.GD2.KeithJoyce;

public class Booking
{
    private int bookingID;
    private String bookingDateAndTime;
    private String returnDateAndTime;
    private String computerType;
    private String computerAssetTag;
    private String bookingStudentID;


    public Booking(int bookingID, String bookingDateAndTime, String returnDateAndTime, String computerType, String computerAssetTag, String bookingStudentID)
    {
        this.bookingID = bookingID;
        this.bookingDateAndTime = bookingDateAndTime;
        this.returnDateAndTime = returnDateAndTime;
        this.computerType = computerType;
        this.computerAssetTag = computerAssetTag;
        this.bookingStudentID = bookingStudentID;
    }

    public int getBookingID()
    {
        return bookingID;
    }

    public String getBookingDateAndTime()
    {
        return bookingDateAndTime;
    }

    public String getReturnDateAndTime()
    {
        return returnDateAndTime;
    }

    public String getComputerType()
    {
        return computerType;
    }

    public String getComputerAssetTag()
    {
        return computerAssetTag;
    }

    public String getBookingStudentID()
    {
        return bookingStudentID;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", bookingDateAndTime='" + bookingDateAndTime + '\'' +
                ", returnDateAndTime='" + returnDateAndTime + '\'' +
                ", computerType='" + computerType + '\'' +
                ", computerAssetTag='" + computerAssetTag + '\'' +
                ", bookingStudentID='" + bookingStudentID + '\'' +
                '}';
    }
}
