package _case_study.furama_resort.libs;

import _case_study.furama_resort.models.booking_contract.Booking;
import _case_study.furama_resort.models.person.Employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class CompreSor implements Comparator<Booking> {
    DateFormat anhquandeptraihihi = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public int compare(Booking o1, Booking o2) {
        try {
            return anhquandeptraihihi.parse(o1.getStartDay()).compareTo(anhquandeptraihihi.parse(o2.getStartDay()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
