import Models.Person;
import Utilis.Utility;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuCreateTicketI {
    private static MenuCreateTicketI MCT = new MenuCreateTicketI();
    private JPanel panel1;
    private JRadioButton CreatePerson;
    private JRadioButton OnPersonList;
    private JLabel Title;
    private JButton Next;
    private JLabel ProductBy;

    private MenuCreateTicketI() {
        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility utility = Utility.GetInstance();
                if(!CreatePerson.isSelected()){
                    CreateTicketI.GetInstance().GetList().setVisible(true);
                    CreateTicketI.GetInstance().GetIndexField().setVisible(true);
                    CreateTicketI.GetInstance().GetIndexLabel().setVisible(true);
                    CreateTicketI.GetInstance().GetNameLabel().setVisible(false);
                    CreateTicketI.GetInstance().GetSecondNameLabel().setVisible(false);
                    CreateTicketI.GetInstance().GetNameField().setVisible(false);
                    CreateTicketI.GetInstance().GetSecondNameField().setVisible(false);
                }else{
                    CreateTicketI.GetInstance().GetList().setVisible(false);
                    CreateTicketI.GetInstance().GetIndexField().setVisible(false);
                    CreateTicketI.GetInstance().GetIndexLabel().setVisible(false);
                    CreateTicketI.GetInstance().GetNameLabel().setVisible(true);
                    CreateTicketI.GetInstance().GetSecondNameLabel().setVisible(true);
                    CreateTicketI.GetInstance().GetNameField().setVisible(true);
                    CreateTicketI.GetInstance().GetSecondNameField().setVisible(true);
                }
                ArrayList<String> lista = new ArrayList<String>();
                var i = 0;
                for (Person p : utility.GetPersons()){
                    i++;
                    String name = i + ") " + p.GetFullName();
                    lista.add(name);
                }
                CreateTicketI.GetInstance().GetList().setListData(lista.toArray());
                Interface.frameHCTI.setVisible(false);
                Interface.frameCTI.setVisible(true);
            }
        });
        OnPersonList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatePerson.setSelected(false);
            }
        });
        CreatePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnPersonList.setSelected(false);
            }
        });
    }

    public static MenuCreateTicketI GetInstance(){
        return MCT;
    }

    public JRadioButton GetRadioPersonList(){
        return OnPersonList;
    }

    public JRadioButton GetRadioNewPerson(){
        return CreatePerson;
    }

    public JPanel GetPanel() {
        return panel1;
    }

    public JLabel GetProductBy(){
        return ProductBy;
    }
}
