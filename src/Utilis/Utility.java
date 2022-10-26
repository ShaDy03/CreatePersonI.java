package Utilis;
import Models.Person;
import Models.Ticket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utility {
    public final String ProductBy = "Purcia Claudiu";
    private static Utility Instance = new Utility();
    private static int Tickets;
    private static int Persons;
    private List<Person> _personList = new ArrayList<Person>();
    private List<Ticket> _ticketList = new ArrayList<Ticket>();
    private Utility(){}

    public void AddTicket(Ticket ticket){
        if(ValidatorProject.IsCorrect(ticket))
        Utility.Tickets++;
        _ticketList.add(ticket);
        AddPerson(ticket.GetPerson());
    }

    public static Utility GetInstance(){
        return Instance;
    }

    public void AddPerson(Person person){
        if(ValidatorProject.IsCorrect(person)){
            boolean exist = false;
            for(int i = 0; i < _personList.size(); i++){
                if(_personList.get(i).GetFullName().equals(person.GetFullName())){
                    exist = true;
                    break;
                }
            }
            if(!exist){
                Utility.Persons++;
                _personList.add(person);
                return;
            }
        }
        System.out.println("I can't add this person!");

    }
    public Ticket SortBy(int sortBy){
        if(ValidatorProject.IsEmpty(sortBy))
            return null;
        switch (sortBy){
            case 1:
                _ticketList.sort(Collections.reverseOrder(Comparator.comparingInt(Ticket::GetTicket)));
                return _ticketList.get(0);
            case 2:
                _ticketList.sort(Comparator.comparingInt(Ticket::GetTicket));
                return _ticketList.get(0);
            default:
                return null;
        }
    }
    public Person GetPersonOnTicket(int nrPerson){
        if(ValidatorProject.IsEmpty(nrPerson))
            return null;
        return _personList.get(nrPerson - 1);
    }

    public List<Person> GetPersons(){
        return _personList;
    }

    public List<Ticket> GetTickets(){
        return _ticketList;
    }
}

