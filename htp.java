import java.net.*;
import java.util.Date;
import java.nio.file.Files;
import java.io.*;
public class htp
{
    public static void main(String[] args) throws Exception
    {
        htp server=new htp();
        int port=8081;
        final ServerSocket serverSocket=new ServerSocket(port);
        System.err.println("Server is runnning on port: "+port);
        boolean runing=true;
        while(runing)
        {
            try(Socket client=serverSocket.accept())
            {
                server.sendPage(client);
            }
            catch(IOException e)
            {
                System.out.println("Something wents wrong");
                System.exit(1);
            }
        }
        try{
            serverSocket.close();
        }    
        finally
        {
            System.out.println("Server is now close...");
        }
    }
    private void sendPage(Socket client) throws Exception
    {
        System.out.println("Page writter called");
        File a1 =new File("index.html");
        PrintWriter printWriter=new PrintWriter(client.getOutputStream());
        BufferedReader reader=new BufferedReader(new FileReader(a1));
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type:text/html");
        printWriter.println("Content-Length: "+a1.length());
        printWriter.println("\r\n");
        String line=reader.readLine();
        while(line!=null)
        {
            printWriter.println(line);
            line=reader.readLine();
        }
        reader.close();
        printWriter.close();
    }    
}        