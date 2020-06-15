import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {

    public static MainFrame frame;
    public static Socket socket;
    public static ObjectOutputStream outStream;
    public static ObjectInputStream inStream;

    public static void main(String[] args) {
        connectToServer("127.0.0.1",2001);
        frame = new MainFrame();
        frame.setVisible(true);
    }

    public static void connectToServer(String ip, int port){
        boolean check = false;
        try{
            socket = new Socket(ip,port);
            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());
            check = true;
        }catch(Exception e){
            e.printStackTrace();
            check = false;
        }
    }

    public static void sendPackage(PackageData pack){
        try{
            outStream.writeObject(pack);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static PackageData getPackage(){
        PackageData pd= new PackageData();
        try{
            pd = (PackageData)inStream.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return pd;
    }
}
