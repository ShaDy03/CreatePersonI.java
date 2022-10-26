import Models.Person;
import Models.Ticket;
import Utilis.Utility;
import Utilis.ValidatorProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateTicketI {
    private static CreateTicketI CTI = new CreateTicketI();
    private JPanel panel1;
    private JList PersonList;
    private JTextField NameTF;
    private JTextField SecondNameTF;
    private JTextField DescriptionTF;
    private JTextField ValueTF;
    private JLabel Name;
    private JLabel SecondName;
    private JLabel Description;
    private JLabel Value;
    private JLabel IndexPerson;
    private JTextField IndexPersonTF;
    private JButton InsertB;

    private CreateTicketI() {
        InsertB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility utility = Utility.GetInstance();
                if(IndexPerson.isVisible()){
                    if(CheckData()){
                        if(IsNumber(IndexPersonTF) && IsNumber(ValueTF)){
                            utility.AddTicket(new Ticket(utility.GetPersonOnTicket(Integer.parseInt(IndexPersonTF.getText())),
                                    DescriptionTF.getText(),
                                    Integer.parseInt(ValueTF.getText())));

                        }else{
                            ErrorMessage(ValueTF.getText() + " or "+ IndexPersonTF.getText() + " aren't number!");
                        }

                    }else {
                        ErrorMessage("Complete all textbox!");
                    }
                }
                else{
                    if(CheckData()) {
                        if (IsNumber(ValueTF)) {
                            utility.AddTicket(new Ticket(NameTF.getText(),
                                    SecondNameTF.getText(),
                                    DescriptionTF.getText(),
                                    Integer.parseInt(ValueTF.getText())));
                        }
                        else{
                            ErrorMessage(ValueTF.getText() + " isn't number!");
                        }
                    }
                    else {
                        ErrorMessage("Complete all textbox!");
                    }
                }
                Cleaner();
                Interface.GetInstance().ActualiserLists();
                Interface.frameCTI.setVisible(false);
                Interface.frameInterface.setVisible(true);
            }
        });
    }
    public JPanel GetPanel() {
        return panel1;
    }
    private void  Cleaner(){
        IndexPersonTF.setText("");
        NameTF.setText("");
        SecondNameTF.setText("");
        DescriptionTF.setText("");
        ValueTF.setText("");
    }

    public static CreateTicketI GetInstance(){return CTI;}
    private void ErrorMessage(String message){
        JOptionPane.showConfirmDialog(
                new JFrame("Error"),
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private boolean IsNumber(JTextField textField){
        try {
            Integer.parseInt(textField.getText());
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    private boolean CheckData(){
        if(IndexPerson.isVisible()){
            if(ValidatorProject.IsNotEmpty(IndexPersonTF.getText()) &&
                    ValidatorProject.IsNotEmpty(DescriptionTF.getText()) &&
                    ValidatorProject.IsNotEmpty(ValueTF.getText())){
                return true;
            }
        }else{
            if(ValidatorProject.IsNotEmpty(DescriptionTF.getText()) &&
                    ValidatorProject.IsNotEmpty(NameTF.getText()) &&
                    ValidatorProject.IsNotEmpty(SecondNameTF.getText()) &&
                    ValidatorProject.IsNotEmpty(ValueTF.getText())){
                return true;
            }
        }
        return false;
    }

    public JTextField GetIndexField(){
        return IndexPersonTF;
    }

    public JTextField GetNameField(){
        return NameTF;
    }

    public JTextField GetSecondNameField(){
        return SecondNameTF;
    }

    public JList GetList(){
        return PersonList;
    }

    public JLabel GetIndexLabel(){
        return IndexPerson;
    }

    public JLabel GetNameLabel(){
        return Name;
    }

    public JLabel GetSecondNameLabel(){
        return SecondName;
    }
}
