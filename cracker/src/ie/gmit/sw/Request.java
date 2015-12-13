package ie.gmit.sw;

//	Just some Constructors, getters and setters.

public class Request {
	private String cypherText;
	private int maxKeySize;
	private long jobNumber;
	
	public Request(String txt, int key, long job) {
		setCypherText(txt);
		setMaxKeySize(key);
		setJobNumber(job);
	}

	public String getCypherText() {
		return cypherText;
	}

	public void setCypherText(String cypherText) {
		this.cypherText = cypherText;
	}

	public int getMaxKeySize() {
		return maxKeySize;
	}

	public void setMaxKeySize(int maxKeySize) {
		this.maxKeySize = maxKeySize;
	}

	public long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(long jobNumber) {
		this.jobNumber = jobNumber;
	}
}