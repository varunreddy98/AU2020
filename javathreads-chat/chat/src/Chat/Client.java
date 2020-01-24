package Chat;
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
public class Client { 
  
    public static void main(String args[]) 
        throws IOException, InterruptedException 
    { 
        DatagramSocket cs= new DatagramSocket(5334); 
        InetAddress ip = InetAddress.getLocalHost(); 
        System.out.println("Running user1"); 
        System.out.println("user2 is Up....");  
        Thread send; 
        send = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    Scanner sc = new Scanner(System.in); 
                    while (true) { 
                        synchronized (this) 
                        { 
                            byte[] sd = new byte[1000]; 
                            sd = sc.nextLine().getBytes(); 
                            DatagramPacket sp= new DatagramPacket(sd,sd.length,ip,1234); 
                            cs.send(sp);  
                            String msg = new String(sd); 
                            System.out.println("user2 says: "+ msg);  
                            if (msg.equals("bye")) { 
                                System.out.println("user2 "+ "Bye "); 
                                break; 
                            } 
                            System.out.println("Waiting for" + "user1 response..."); 
                        } 
                    } 
                } 
                catch (IOException e) { 
                    System.out.println("Exception occured"); 
                } 
            } 
        }); 

        Thread rec;
        rec= new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
  
                    while (true) { 
                        synchronized (this) 
                        { 
  
                            byte[] rd = new byte[1000]; 
                            DatagramPacket sp1=new DatagramPacket(rd,rd.length); 
                            cs.receive(sp1); 
                            String msg = (new String(rd)).trim(); 
                            System.out.println("user1: " + msg);  
                            if (msg.equals("bye")) { 
                                System.out.println("user1"+ " Bye"); 
                                break; 
                            } 
                        } 
                    } 
                } 
                catch (IOException e) { 
                    System.out.println("Exception occured"); 
                } 
            } 
        }); 
  
        send.start(); 
        rec.start(); 
  
        send.join(); 
        rec.join(); 
    } 
} 