package 알고리즘4주차;
import java.lang.Comparable;

class webLog implements Comparable<webLog> {
	String IP;
	String URL;
	String Status;
	String Date;
	int time;
	int year;
	public webLog(String a,String b,String c,String d)
	{
		IP=new String(a);
		Date=new String(b);
		URL=new String(c);
		Status=new String(d);
		String temp=b.substring(1,b.indexOf(":"));
		String temp1[]=temp.split("/");
		if(temp1[1].equals("Jan"))
			temp1[1]="01";
		else if(temp1[1].equals("Feb"))
			temp1[1]="02";
		else if(temp1[1].equals("Mar"))
			temp1[1]="03";
		else if(temp1[1].equals("Apr"))
			temp1[1]="04";
		else if(temp1[1].equals("May"))
			temp1[1]="05";
		else if(temp1[1].equals("Jun"))
			temp1[1]="06";
		else if(temp1[1].equals("Jul"))
			temp1[1]="07";
		else if(temp1[1].equals("Aug"))
			temp1[1]="08";
		else if(temp1[1].equals("Sep"))
			temp1[1]="09";
		else if(temp1[1].equals("Oct"))
			temp1[1]="10";
		else if(temp1[1].equals("Nov"))
			temp1[1]="11";
		else if(temp1[1].equals("Dec"))
			temp1[1]="12";
		time=Integer.parseInt(b.substring(b.indexOf(":")+1).replaceAll(":","" ));
		year=Integer.parseInt(temp1[2]+temp1[1]+temp1[0]);
	}
	public String getIP() {return IP;}
	public int getYear() {return year;}
	public int getTime() {return time;}
	@Override
	public int compareTo(webLog o) {
		if(this.year-o.year==0)
			return this.time-o.time;
		return this.year-o.year;}
}
