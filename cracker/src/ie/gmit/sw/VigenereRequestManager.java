package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class VigenereRequestManager {
	private BlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(10);
	private Map<Long, String> out = new ConcurrentHashMap<Long, String>();
	private String cypherText;
	VigenereHandler handler;	//	Calling the finshed codes

	public void add(final Request req) { // Should add 
			new Thread(new Runnable() 
			{
				public void run() {
					try {
						queue.put(req);
						out.put(req.getJobNumber(), req.getCypherText());

						handler = new VigenereHandler(queue, out);
						out.put(req.getJobNumber(), handler.returnResult());

					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}).start();
	}

	public String getResult(final long jobNumber) {	//Should be able to call the decrypted codes from here. But it doesn't
		new Thread(new Runnable() 
		{
			public void run() {
				String result = out.get(jobNumber);
				cypherText = result;
			}
		}).start();
		return cypherText;
	}
}