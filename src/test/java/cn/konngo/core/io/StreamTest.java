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

		// ������Դ����������д��Ŀ�ĵ�--ʹ������
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

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);// 1M������

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
		// ����һ��������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		// ��һ�³�ʼʱ4�����ı�����ֵ
		System.out.println("��ʼʱ-->limit--->" + byteBuffer.limit());
		System.out.println("��ʼʱ-->position--->" + byteBuffer.position());
		System.out.println("��ʼʱ-->capacity--->" + byteBuffer.capacity());
		System.out.println("��ʼʱ-->mark--->" + byteBuffer.mark());

		System.out.println("--------------------------------------");

		// ���һЩ���ݵ���������
		String s = "Java3y";
		byteBuffer.put(s.getBytes());

		// ��һ�³�ʼʱ4�����ı�����ֵ
		System.out.println("put��֮��-->limit--->" + byteBuffer.limit());
		System.out.println("put��֮��-->position--->" + byteBuffer.position());
		System.out.println("put��֮��-->capacity--->" + byteBuffer.capacity());
		System.out.println("put��֮��-->mark--->" + byteBuffer.mark());

	}
}
