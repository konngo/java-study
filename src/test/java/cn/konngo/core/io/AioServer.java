package cn.konngo.core.io;


/**
 * ����Aio�첽io��
 * @author konngo
 *
 */
public class AioServer {
	private  final int port ; // �˿�
	
	public AioServer(int port) {
		this.port = port;
		this.listen(); // ��������
	}
	
	/**
	 * �����ͻ�������
	 */
	private void listen() {
		
	}
	
	
	
	public static void main(String[] args) {
		new AioServer(8000);
	}
}
