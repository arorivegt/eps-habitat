package org.habitatguate.hgerp.util;

import java.util.Date;

public class ConvertDate {
    public static Date g(Date date) {
        if (date != null) {
            long timeStamp = date.getTime();
            return new Date(timeStamp);
        }
        return null;
    }
}
