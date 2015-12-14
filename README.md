# G00301273 Distributed Systems Project

When you asked for all of the source code, I wan't certain if you meant the /src/ folders or everything. So I decided not to take the risk and just uploaded everything.

WorkingRMI is the Servant and the Vigenere files. cracker is the tomcat files.

The Servant.java file should be ran from the jar file before deploying the Tomcat application.

Servant needs a text file called wap.txt. It is in the jar already, but if some bizarre reason it doesn't work, there's a copy in WorkingRMI.

The project will take in an encrypted string and try and decrypt it. 

Queues are there and should be Threaded. 

Unfortunately, I was not able to fix the queues. The string is decrypted and sent back to the queues, however it does not get displayed at the very end.

System logs do show that it it get’s decrypted and it does make it’s way back.

It’s either adding to the out queue incorrectly, or I’m calling it wrong in the CrackerHandler file.

Unfortunately I am out of time.

Code is commented, so it should make sense. I hope.
