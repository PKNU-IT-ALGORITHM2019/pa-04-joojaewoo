package 알고리즘4주차;

import java.util.Comparator;

public class webLogIPComparator implements Comparator<webLog> {
	@Override
	public int compare (webLog s1,webLog s2) {
		if(s1==null||s2==null)
			return 0;
		String webLogIP1=s1.getIP();
		String webLogIP2=s2.getIP();
		int a=webLogIP1.compareTo(webLogIP2);
		if(a==0) {
			if(s1.year-s2.year==0)
				return s1.time-s2.time;
			else
				return s1.year-s2.year;
		}
		return a;
	}

}
