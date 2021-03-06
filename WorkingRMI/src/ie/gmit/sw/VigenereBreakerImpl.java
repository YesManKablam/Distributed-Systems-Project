package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VigenereBreakerImpl extends UnicastRemoteObject implements VigenereBreaker{
	private static final long serialVersionUID = 1L;
	private KeyEnumerator breaker;
	private VigenereBreaker vb;
	private long jobNumber;
	private int maxKeyLength;
	private String cypherText;
	
	@SuppressWarnings("deprecation")	//	This was stopping a null pointer, but doesn't seem to anymore. But I'm not taking the chance of removing it.
	public VigenereBreakerImpl() throws Exception {
		breaker = new KeyEnumerator();
	}
		
	public VigenereBreakerImpl(long jobNum, int maxKeyLength, String cypherText) throws RemoteException {
		super();
		this.jobNumber = jobNum;
		this.maxKeyLength = maxKeyLength;
		this.cypherText = cypherText;
	}
		
	public String decrypt(String cypherText, int maxKeyLength) throws RemoteException {
		KeyEnumerator s = null;
			try {		//	Autogenerated try catch here.
				s = new KeyEnumerator();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return s.crackCypher(cypherText, maxKeyLength).toString();
	}
	
	// Return decrypted text
	public String getDecryption(VigenereBreaker vb) throws RemoteException {
		this.vb = vb;
		System.out.println("CypherText: " + cypherText + " MaxKeyLength: " + maxKeyLength);
		return vb.decrypt(cypherText, maxKeyLength);
	}
	
}
