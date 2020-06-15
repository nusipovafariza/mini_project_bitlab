import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.*;
import java.util.ArrayList;

public class Server {
    private static Connection connection;

    public static void disconnect(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useUnicode=true&serverTimezone=UTC","root", "");
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            ServerSocket serverSocket = new ServerSocket(2001);

            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ServerThread st = new ServerThread(socket);
                st.start();

            }
        }  catch (Exception e){
            //e.printStackTrace();
            System.out.println("Fail");
            System.exit(0);
        }

    }
    public static void addStudent(Students student){
        try{
            Statement st = connection.createStatement();
            String sql = "insert into students(name,surname,age) values(\""+student.getName()+"\",\""+student.getSurname()+"\",\""+student.getAge()+"\")";
            st.executeUpdate(sql);
            st.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                list.add(new Students(id,name,surname,age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
