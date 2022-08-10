package test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClassInfoServer {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			ServerSocket server=new ServerSocket(11112);
			Socket client=server.accept();
	
			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			ClassInfo info = (ClassInfo) ois.readObject();
			String id = info.getId();
			String name=info.getName();
			int kor = info.getKor();
			int eng=info.getEng();
			int math=info.getMath();
			
			ClassInfoDAO.getInstance().insert(info);
			
			ois.close();
			is.close();
			client.close();
			server.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
