import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData pd;

            while ((pd= (PackageData)inputStream.readObject())!=null){
                if (pd.getOperationType().equals("list_students")){
                    ArrayList<Students> db = Server.getAllStudents();
                    PackageData response = new PackageData("list_students",db);
                    outputStream.writeObject(response);
                }
                else if (pd.getOperationType().equals("add_student")){
                    Students student = pd.getStudent();
                    Server.addStudent(student);
                }
            }
        }catch (Exception e){
            System.exit(0);
           e.printStackTrace();

        }

    }
}
