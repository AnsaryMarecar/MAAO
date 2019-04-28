package org.secure.retirement.home.frame;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateItem {

    private Date mDate;

    public DateItem(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        return sdf.format(mDate);
    }
}