package Chat;
import java.net.*; 
import java.io.*; 
import java.util.*; 
  
public class Server { 
  
    public static void main(String args[]) throws IOException, InterruptedException 
    { 
   
        DatagramSocket ss = new DatagramSocket(1234); 
        InetAddress ip = InetAddress.getLocalHost(); 
        System.out.println("user1"); 
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
                            DatagramPacket sp = new DatagramPacket(sd,sd.length,ip,5334);  
                            ss.send(sp); 
                            String msg = new String(sd); 
                            System.out.println("user1 says: "+ msg); 
                            if ((msg).equals("bye")) { 
                                System.out.println("user1:"+ " Bye"); 
                                break; 
                            } 
                           System.out.println("Waiting for"+ " user2s response... "); 
                        } 
                    } 
                } 
                catch (Exception e) { 
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
                            DatagramPacket sp1= new DatagramPacket( rd,rd.length); 
                            ss.receive(sp1); 
                            String msg = (new String(rd)).trim(); 
                            System.out.println("user2:"+" "+msg);
                            if (msg.equals("bye")) { 
                                System.out.println("user2:"+ "Bye"); 
                                break; 
                            } 
                        } 
                    } 
                } 
                catch (Exception e) { 
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