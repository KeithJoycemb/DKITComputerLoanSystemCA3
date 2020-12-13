package com.dkit.GD2.KeithJoyce;

import java.time.LocalDateTime;

public class BookingInformation
{
    private int bookingID;
    private LocalDateTime bookingDateAndTime;
    private LocalDateTime returnDateAndTime;
    private String computerType;
    private String computerAssetTag;
    private String bookingStudentID;


    public BookingInformation(int bookingID, LocalDateTime bookingDateAndTime, LocalDateTime returnDateAndTime, String computerType, String computerAssetTag, String bookingStudentID)
    {
        this.bookingID = bookingID;
        this.bookingDateAndTime = bookingDateAndTime;
        this.returnDateAndTime = returnDateAndTime.plusMonths(1);
        this.computerType = computerType;
        this.computerAssetTag = computerAssetTag;
        this.bookingStudentID = bookingStudentID;
    }

    public int getBookingID()
    {
        return bookingID;
    }

    public LocalDateTime getBookingDateAndTime()
    {
        return bookingDateAndTime;
    }

    public LocalDateTime getReturnDateAndTime()
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
    public String toString()
    {
        return "BookingInformation{" +
                "bookingID=" + bookingID +
                ", bookingDateAndTime=" + bookingDateAndTime +
                ", returnDateAndTime=" + returnDateAndTime +
                ", computerType='" + computerType + '\'' +
                ", computerAssetTag='" + computerAssetTag + '\'' +
                ", bookingStudentID='" + bookingStudentID + '\'' +
                '}';
    }
}
