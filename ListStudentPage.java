import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListStudentPage extends Container {
    private JButton back;
    private JTable table;
    private String columnNames[] = {"id", "name","surname","age"};
    public ListStudentPage(){
        setSize(600,600);
        setLayout(null);

        back = new JButton("BACK");
        back.setSize(200,30);
        back.setLocation(250,450);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.showMenuPage();
            }
        });
    }
    public void fillArea(){
        PackageData response = Main.getPackage();
        ArrayList<Students> students = response.getStudents();
        Object values[][] = new Object[students.size()][4];
        for (int i=0; i<students.size();i++){
            values[i][0] = students.get(i).getId();
            values[i][1] = students.get(i).getName();
            values[i][2] = students.get(i).getSurname();
            values[i][3] = students.get(i).getAge();
        }
        table = new JTable(values, columnNames);

        table.setSize(575,400);
        table.setLocation(10,10);
        add(table);

    }
    public void refresh(){
        table.revalidate();
    }
}
