package charImage.style;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	public  static String getStringTime() {
		DateFormat df1 = new SimpleDateFormat("yyyyMMdd");
		String time = df1.format(new Date());
		return time;
	}
	public static String getStringLongTime(){
		   DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  
           String time1 = df.format(new Date());  
           return time1;
	}
}