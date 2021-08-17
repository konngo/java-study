package cn.konngo.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试非阻塞
 * @author konngo
 *
 */
public class NioTest {
	public static void main(String[] args) throws Exception {
		FileInputStream fiStream = new FileInputStream(new File("C:\\Users\\LiJunPeng\\eclipse-workspace\\java-study\\src\\main\\resources\\test.txt"));
//		byte[] b = new byte[5];
//		int len;//每次读入到byte字节中的长度  
//		while ((len = fiStream.read(b)) != -1) {
//			for (int i = 0; i < len; i++) {
//				System.out.print((char) b[i]);
//			}
//		}
//		
		FileChannel channel = fiStream.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(10);
		int flag = channel.read(buffer);
		
		
		//while(flag != -1) {
			buffer.flip();
			while (buffer.remaining()>0) {
				char b = (char)buffer.get();
				System.out.println(b);
				
			}

			buffer.clear();
			flag = channel.read(buffer);
		//}
			System.out.println(flag);

			buffer.flip();
			while (buffer.remaining()>0) {
				char b = (char)buffer.get();
				System.out.println(b);
				
			}
		
	}
}
