package client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client 
{


    public static void main(String[] args)
    {
        try
         {      
           Socket s=new Socket("localhost",6666);  
           DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
           DataInputStream din=new DataInputStream(s.getInputStream());
            Scanner input = new Scanner(System.in);
            String sent = "dd";
            do
           {    
           System.out.println("\nEnter string that is be sent to server::");
           //sent = "dd";
           sent = input.nextLine();
           System.out.println("\nString sent::"+ sent);
           dout.writeUTF(sent);
           String recv= (String )din.readUTF();
           System.out.println("\nRecieved  "+ recv);
           } while(!sent.equals("bye"));
           //{    
           din.close();
           dout.flush();  
           dout.close();  
           s.close();  
         }
         catch(Exception e)
         {System.out.println(e);}  
     }  
     
}
