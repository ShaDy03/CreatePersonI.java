package Utilis;

import Models.Person;
import Models.Ticket;
public class ValidatorProject{
    public static boolean IsEmpty(int nr) {
        if(nr == 0)
            return true;
        return false;
    }

    public static boolean IsEmpty(String entity) {
        if(entity.equals("") || entity.equals(null))
            return true;
        return false;
    }

    public static boolean IsNotEmpty(String entity) {
        if(entity.equals("") || entity.equals(null))
            return false;
        return true;
    }

    public static boolean IsCorrect(Person person) {
        if(IsEmpty(person.GetFullName()))
            return false;
        return true;
    }

    public static boolean IsCorrect(Ticket ticket) {
        if(IsCorrect(ticket.GetPerson()) && !IsEmpty(ticket.GetDescription()) && IsEmpty(ticket.GetTicket()))
            return true;
        return false;
    }
}
