package Models;

public class Ticket {
    private Person _person;
    private String _descriptionFact;
    private int _valueTicket;

    public Ticket(Person person, String descriptionFact, int valueTicket)
    {
        _person = person;
        _descriptionFact = descriptionFact;
        _valueTicket = valueTicket;
    }

    public Ticket(String firstName, String secondName, String descriptionFact, int valueTicket)
    {
        _person = new Person(firstName, secondName);
        _descriptionFact = descriptionFact;
        _valueTicket = valueTicket;
    }

    public Ticket()
    {
    }

    public void SetPerson(String firstName, String secondName)
    {
        _person.SetFirstName(firstName);
        _person.SetSecondName(secondName);
    }

    public void SetDescription(String description)
    {
        _descriptionFact = description;
    }

    public void SetTicket(int value)
    {
        _valueTicket = value;
    }

    public Person GetPerson()
    {
        return _person;
    }

    public String GetDescription()
    {
        return _descriptionFact;
    }

    public int GetTicket()
    {
        return _valueTicket;
    }
}

