import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class AddStudentPage extends Container {
    private JButton back;
    private JButton add;


    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel ageLabel;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;

    public AddStudentPage(){
        setLayout(null);
        setSize(600,600);

        nameLabel = new JLabel("NAME: ");
        nameLabel.setSize(200,30);
        nameLabel.setLocation(100,150);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setSize(300,30);
        nameField.setLocation(200,150);
        add(nameField);

        surnameLabel = new JLabel("SURNAME: ");
        surnameLabel.setSize(200,30);
        surnameLabel.setLocation(100,200);
        add(surnameLabel);

        surnameField = new JTextField();
        surnameField.setSize(300,30);
        surnameField.setLocation(200,200);
        add(surnameField);

        ageLabel = new JLabel("AGE: ");
        ageLabel.setSize(200,30);
        ageLabel.setLocation(100,250);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setSize(300,30);
        ageField.setLocation(200,250);
        add(ageField);

        back = new JButton("BACK");
        back.setLocation(100,400);
        back.setSize(170,30);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.showMenuPage();
            }
        });
        add(back);

        add = new JButton("ADD");
        add.setLocation(300,400);
        add.setSize(170,30);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText();
                String surname = surnameField.getText();
                int age = Integer.parseInt(ageField.getText());

                refresh();
                Students st = new Students(null, name, surname, age);
                PackageData pd = new PackageData("add_student",st);
                Main.sendPackage(pd);
            }
        });
        add(add);


    }
    public void refresh(){
        ageField.setText(" ");
        nameField.setText(" ");
        surnameField.setText(" ");
    }
}
