import javax.swing.*;

public class MainFrame extends JFrame {
    public MenuPage menuPage;
    public AddStudentPage addStudentPage;
    public ListStudentPage listStudentPage;

    public MainFrame(){
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENTS APPLICATION");
        setResizable(false);

        menuPage = new MenuPage();
        menuPage.setLocation(0,0);
        add(menuPage);

        addStudentPage = new AddStudentPage();
        addStudentPage.setLocation(0,0);
        add(addStudentPage);

        listStudentPage = new ListStudentPage();
        listStudentPage.setLocation(0,0);
        add(listStudentPage);
        showMenuPage();

    }
    public void showMenuPage(){
        menuPage.setVisible(true);
        listStudentPage.setVisible(false);
        addStudentPage.setVisible(false);
    }
    public void showAddStudentPage(){
        menuPage.setVisible(false);
        listStudentPage.setVisible(false);
        addStudentPage.setVisible(true);
    }
    public void showListStudentPage(){

        menuPage.setVisible(false);
        listStudentPage.setVisible(true);
        addStudentPage.setVisible(false);
        listStudentPage.fillArea();

    }
    public void exit(){
        System.exit(0);

    }

}
