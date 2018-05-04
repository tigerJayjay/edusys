
package org.es.util.format;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/** 
* @author  tigerJay  
* 日期格式转换器
*/
public class DateUtil {
	/**
	 * 日期对象转化为字符串(yyyy/MM/dd)
	 */
	public static String date2StringSimple(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 日期对象转化为字符串(yyyy/MM/dd hh:mm:ss)
	 */
	public static String date2StringFull(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 字符串转化为日期对象(yyyy/MM/dd)
	 * @throws ParseException 
	 */
	public static Date string2DateSimple(String time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("日期格式化出现异常");
		}
		return date;
	}
	
	/**
	 * 字符串转化为日期对象(yyyy/MM/dd hh:mm:ss)
	 * @throws ParseException 
	 */
	public static Date string2DateFull(String time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("日期格式化异常");
		}
		return date;
	}
	public static List<String> string2DateTotal(String time1,String time2) throws ParseException{
		Date d1 = new SimpleDateFormat("yyyy-MM").parse(time1);
		Date d2 = new SimpleDateFormat("yyyy-MM").parse(time2);
		Calendar dd = Calendar.getInstance();
		dd.setTime(d1);
		List<String> list= new ArrayList();
		while(dd.getTime().before(d2)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdf.format(dd.getTime());
			list.add(str);
			dd.add(Calendar.MONTH,1);
		}
		return list;
	}
	public static String string2Max(String time) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(time);
		Calendar ca = Calendar.getInstance();
		 ca.setTime(dd);
	        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	        String last = format.format(ca.getTime());
	        return last;
	}
	public static String string2Min(String time) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(time);
		Calendar c = Calendar.getInstance();    
	       c.setTime(dd); 
		c.add(Calendar.MONTH, 0);
	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	        String first = format.format(c.getTime());
		return first;
	}
	/*public static void main(String[] arg0) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = new SimpleDateFormat("yyyy-MM-dd").parse("2014-03-23");
		Calendar c = Calendar.getInstance();    
	       c.setTime(dd); 
		c.add(Calendar.MONTH, 0);
	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	        String first = format.format(c.getTime());
	        System.out.println("===============first:"+first);
	
	        
	}*/
}
 