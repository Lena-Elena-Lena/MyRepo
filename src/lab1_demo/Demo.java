package lab1_demo;

import java.io.Serializable;
import java.util.Date;

public class Demo implements Serializable
{	
	public static int last=0;
	private int id;
	private String name;
	private String message;
	private Date date;
	private transient int temp;
	private int ex;
	
	public Demo(){last=0; id=1; name="MyName"; message="NoMessage"; date=new Date(); temp=1;}

	public Demo(int l, int i, String n, String m, Date d, int t)
	{last=l; id=i; name=n; message=m; date=d; temp=t;}
	public String toString()
	{
	 return new String("last="+last+"\n"+"id="+id+"\n"+"name: "+
	name+"\n"+"message: "+message+"\n"+"date: "+date.toString()+"\n"+"temp="+temp);
	}
	
}
