package p1;
import java.util.*;
class BarberShop
{
	  boolean barber_busy=true;
	  int count_customers=10;
	  static int c=0;
	  static Stack<Integer> s=new Stack(); // for the queue before haircut
	
	  public synchronized void getBarber(int id) throws InterruptedException
	  { 
		  System.out.println("Customer "+(id+1)+" got the seat in queue");
		  while(barber_busy)
		  {
			  wait();
			  
		  }
		  count_customers-=1;
		  s.pop();
		  System.out.println("hair cutting for customer"+ (id+1));
		  barber_busy=true;
		  Thread.sleep(1000);
		  notifyAll();
	  }
	  
	  public boolean getSeat()
	  {
		  if(s.size()<5)
		  {
			  return true;
		  }
		  return false;
	  }
	  
	  public synchronized void start_haircut() throws InterruptedException
	  {
		  
		  while(!barber_busy) wait();	      
			barber_busy=false;
			notifyAll();
		  
	  }

}

class Customer extends Thread
{   BarberShop b;
    static int count=0;
	int id;
	Customer(BarberShop b,int id)
	{
		this.b=b;
		this.id=id;
		
	}
	public void run()
	{
		
		try { 
			
			if(count>=5) {
			while(b.getSeat()==false);
			}
			count++;
    		// System.out.println("Customer "+(id+1)+" got the seat in queue");
			BarberShop.s.add(id);
			 b.getBarber(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
public class BarberProblem { 
	
	public static void main(String...args) throws InterruptedException
	{   System.out.println("Barber opened");
	    System.out.println("Customer is selected randomly from queue not in fifo order");
		BarberShop bs=new BarberShop();
		int no_of_customers=10;
	    Customer c[]=new Customer[no_of_customers];
	    for(int i=0;i<no_of_customers;i++)
	    {
	    	c[i]=new Customer(bs,i);
		    c[i].start();
	    	//System.out.println(i);
	    }
	    Barber b=new Barber(bs);
		b.start();
		
	}
}
	
  class Barber extends Thread{
		BarberShop bs;
		Barber(BarberShop bs)
		{
			this.bs=bs;
		}
		public void run()
		{    System.out.println("Barber started hair cut");
			while(bs.count_customers>0)
			{
				try {
					bs.start_haircut();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			System.out.println("Haircut for all customers is done");
		}
	}

