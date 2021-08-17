package cn.konngo.core.io;


/**
 * 测试Aio异步io流
 * @author konngo
 *
 */
public class AioServer {
	private  final int port ; // 端口
	
	public AioServer(int port) {
		this.port = port;
		this.listen(); // 开启监听
	}
	
	/**
	 * 监听客户端请求
	 */
	private void listen() {
		
	}
	
	
	
	public static void main(String[] args) {
		new AioServer(8000);
	}
}
