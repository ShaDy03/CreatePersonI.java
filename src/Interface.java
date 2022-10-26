import Utilis.Utility;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Interface {
    private JPanel panel;
    private JList PersonList;
    private JList TicketList;
    private JButton CreateTicketB;
    private JButton CreatePersonB;
    private JButton SortBy;
    private static CreatePersonI CP = new CreatePersonI();
    private static MenuCreateTicketI MCT;
    private static CreateTicketI CTI;
    public static JFrame frameInterface = new JFrame("Proiectul 2");
    public static JFrame frameHCTI = new JFrame("How do you want to create?");
    public static JFrame frameCPI = new JFrame("Create Person");
    public static JFrame frameCTI = new JFrame("Create Ticket");
    private static Interface main = new Interface();

    public Interface() {
        CreatePersonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameInterface.setVisible(false);
                frameCPI.setVisible(true);
            }
        });

        CreateTicketB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCreateTicketI.GetInstance().GetRadioPersonList().setSelected(false);
                MenuCreateTicketI.GetInstance().GetRadioNewPerson().setSelected(true);
                frameInterface.setVisible(false);
                frameHCTI.setVisible(true);
            }
        });
    }

    public static void main(String args[])
    {
        MCT = MenuCreateTicketI.GetInstance();
        CTI = CreateTicketI.GetInstance();
        frameInterface.setContentPane(main.panel);
        frameCPI.setContentPane(CP.GetPanel());
        frameHCTI.setContentPane(MCT.GetPanel());
        frameCTI.setContentPane(CTI.GetPanel());
        frameCTI.pack();
        frameHCTI.pack();
        frameCPI.pack();
        frameInterface.pack();
        main.ActualiserLists();
        frameInterface.setVisible(true);
    }

    private void SetProductBy(){
        MCT.GetProductBy().setText(Utility.GetInstance().ProductBy);
    }

    public static Interface GetInstance(){
        return main;
    }

    public void ActualiserLists(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Lista de persoane");
        Utility.GetInstance().GetPersons().forEach(p -> lista.add(p.GetFullName()));
        main.PersonList.setListData(lista.toArray());
        lista.clear();
        lista.add("Lista de amenzi");
        Utility.GetInstance().GetTickets().forEach(t -> lista.add(t.GetPerson().GetFullName() + " " + t.GetDescription() + " " + t.GetTicket()));
        main.TicketList.setListData(lista.toArray());
    }
}

