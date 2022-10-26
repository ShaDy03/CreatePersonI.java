package Models;

public class Person {

    private String _firstName;
    private String _secondName;

    public Person(String name, String secondName)
    {
        _firstName = name;
        _secondName = secondName;
    }
    public Person()
    {
    }

    public void SetFirstName(String name)
    {
        _firstName = name;
    }

    public void SetSecondName(String secondName)
    {
        _firstName = secondName;
    }

    public String GetFullName()
    {
        return (_firstName + " " + _secondName);
    }



}
