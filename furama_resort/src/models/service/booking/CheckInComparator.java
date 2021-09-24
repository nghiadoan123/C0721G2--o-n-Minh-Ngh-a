package models.service.booking;

import java.util.Comparator;

public class CheckInComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getCheckIn().compareTo(o2.getCheckIn());
    }
}
