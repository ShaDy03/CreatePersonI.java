import Models.Person;
import Utilis.Utility;
import Utilis.ValidatorProject;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePersonI {
    private JPanel panel1;
    private JLabel TitleCPI;
    private JTextField NameTF;
    private JLabel Name;
    private JLabel SecondName;
    private JTextField SecondNameTF;
    private JButton Insert;

    public CreatePersonI() {
        Insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ValidatorProject.IsNotEmpty(NameTF.getText()) && ValidatorProject.IsNotEmpty(SecondNameTF.getText())){
                    Utility.GetInstance().AddPerson(new Person(NameTF.getText(), SecondNameTF.getText()));
                    Interface.GetInstance().frameCPI.setVisible(false);
                    Interface.GetInstance().ActualiserLists();
                    Cleaner();
                    Interface.GetInstance().frameInterface.setVisible(true);
                }
                else {
                    ErrorMessage();
                }
            }
        });
    }

    private void Cleaner(){
        NameTF.setText("");
        SecondNameTF.setText("");
    }
    //am adaugat ceva
    public JPanel GetPanel(){
        return panel1;
    }

    private void ErrorMessage(){
        JOptionPane.showConfirmDialog(new JFrame(),
                "Complete foreach textbox!",
                "Error",
                JOptionPane.WARNING_MESSAGE);
    }
}
