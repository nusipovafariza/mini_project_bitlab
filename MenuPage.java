import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends Container {
    private JButton addSt;
    private JButton listSt;
    private JButton exit;

    public MenuPage(){
        setSize(600,600);
        setLayout(null);

        addSt = new JButton("ADD STUDENT");
        addSt.setSize(200,30);
        addSt.setLocation(150,150);
        addSt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students s = new Students();
                PackageData pd = new PackageData("add_student",s);
                Main.sendPackage(pd);
                Main.frame.showAddStudentPage();


            }
        });
        add(addSt);
        listSt = new JButton("LIST STUDENTS");
        listSt.setSize(200,30);
        listSt.setLocation(150,200);
        listSt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students s = new Students();
                PackageData pd = new PackageData("list_students",s);
                Main.sendPackage(pd);
                Main.frame.showListStudentPage();
                Main.frame.listStudentPage.refresh();


            }
        });
        add(listSt);

        exit = new JButton("EXIT");
        exit.setSize(200,30);
        exit.setLocation(150,250);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.exit();

            }
        });
        add(exit);

    }

}
