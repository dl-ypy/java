import java.io.IOException;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			while (true){
				Socket s = ss.accept();
System.out.println("a client connected!");    //以后要注释的写到最左边，方便寻找
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
