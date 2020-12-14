package com.dkit.GD2.KeithJoyce;

import java.util.Comparator;

public class CompareTime implements Comparator<BookingInformation>
{
    @Override
    public int compare(BookingInformation timeAndDate1, BookingInformation timeAndDate2)
    {
        return timeAndDate1.getReturnDateAndTime().compareTo(timeAndDate2.getBookingDateAndTime());
    }
}
