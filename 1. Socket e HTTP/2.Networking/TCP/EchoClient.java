import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        System.out.println("CLIENT:"+args[0]);

        try {
            echoSocket = new Socket("localhost", 4444);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: taranis.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: taranis.");
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

	while ((userInput = stdIn.readLine()) != null) {
		if (userInput.equals("end.")) break;
	    out.println(args[0]+"-->"+userInput);
	    System.out.println("echo: " + in.readLine());
	}

	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }
}
