package test2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClassInfoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.0.70", 11112);
		
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		ClassInfo info = new ClassInfo();
		info.setId("admin");
		info.setName("kang");
		info.setKor(10);
		info.setEng(10);
		info.setMath(10);
		
		oos.writeObject(info);
		oos.flush();
	
		oos.close();
		os.close();
		socket.close();
	}
}
