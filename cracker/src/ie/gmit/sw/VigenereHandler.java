package ie.gmit.sw;

//Thank you for pointing in the right direction on friday

import java.rmi.Naming;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class VigenereHandler {
	private BlockingQueue<Request> queue;	//	Request in queue
	private Map<Long, String> out = new ConcurrentHashMap<Long, String>();	//	Request out map
	private String result;
	private Request req;
	
	public VigenereHandler(BlockingQueue<Request> q, Map<Long, String> out)
	{
		this.out = out;
		this.queue = q;
		run();		//	This stops a null pointer exception
	}
	
	public void run()
	{		
		try
		{
			req = queue.take();
			VigenereBreaker vb = (VigenereBreaker) Naming.lookup("rmi://localhost:1099/cypher-service"); // Set to localhost to hopefully run on other's machines without config
			result = vb.decrypt(req.getCypherText(), req.getMaxKeySize());	//	Calls the breaker via the interface 
			out.put(req.getJobNumber(), result);
			System.out.println(result);	//	Check if the decrpyt that comes back is okay
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}	
	
	public String returnResult()
	{
		return out.get(req.getJobNumber());
	}
}