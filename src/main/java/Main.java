import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        Socket socket;

        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        serverSocket = new ServerSocket(23444,1, InetAddress.getByName("127.0.0.1"));
        socket = serverSocket.accept();

        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String massageFromClient = dataInputStream.readUTF();

        String massageToClient = massageFromClient + " здарова";

        dataOutputStream.writeUTF(massageToClient);
        dataInputStream.close();
        dataOutputStream.close();

        socket.close();
        serverSocket.close();
        System.out.println("server vse");
    }
}
