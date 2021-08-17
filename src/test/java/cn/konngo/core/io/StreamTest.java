package cn.konngo.core.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import cn.konngo.collection.Test;

public class StreamTest {

	private long transferFile(File source, File des) throws IOException {
		long startTime = System.currentTimeMillis();

		if (!des.exists())
			des.createNewFile();

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

		// 将数据源读到的内容写入目的地--使用数组
		byte[] bytes = new byte[1024 * 1024];
		int len;
		while ((len = bis.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	private long transferFileWithNIO(File source, File des) throws IOException {
		long startTime = System.currentTimeMillis();

		if (!des.exists())
			des.createNewFile();

		RandomAccessFile read = new RandomAccessFile(source, "rw");
		RandomAccessFile write = new RandomAccessFile(des, "rw");

		FileChannel readChannel = read.getChannel();
		FileChannel writeChannel = write.getChannel();

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);// 1M缓冲区

		while (readChannel.read(byteBuffer) > 0) {
			byteBuffer.flip();
			writeChannel.write(byteBuffer);
			byteBuffer.clear();
		}

		writeChannel.close();
		readChannel.close();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	private void test2() {
	}

	public static void main(String[] args) throws IOException {
		// 创建一个缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		// 看一下初始时4个核心变量的值
		System.out.println("初始时-->limit--->" + byteBuffer.limit());
		System.out.println("初始时-->position--->" + byteBuffer.position());
		System.out.println("初始时-->capacity--->" + byteBuffer.capacity());
		System.out.println("初始时-->mark--->" + byteBuffer.mark());

		System.out.println("--------------------------------------");

		// 添加一些数据到缓冲区中
		String s = "Java3y";
		byteBuffer.put(s.getBytes());

		// 看一下初始时4个核心变量的值
		System.out.println("put完之后-->limit--->" + byteBuffer.limit());
		System.out.println("put完之后-->position--->" + byteBuffer.position());
		System.out.println("put完之后-->capacity--->" + byteBuffer.capacity());
		System.out.println("put完之后-->mark--->" + byteBuffer.mark());

	}
}
