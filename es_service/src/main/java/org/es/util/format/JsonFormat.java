
package org.es.util.format;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;

/** 
* @author 作者 tigerJay E-mail: 
* @version 创建时间：2018年1月23日 下午3:36:30 
* List转Json处理工具类 
*/
public class JsonFormat {
	public static <T> JSONObject List2Json(List<T> list,int total) throws IllegalArgumentException, IllegalAccessException{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", total);
		List<Map> list1 = new ArrayList<Map>();
		
		//遍历List对象
		for(int i=0;i<list.size();i++){
			T t = list.get(i);
			Class<T> clazz = (Class<T>) t.getClass();
			//通过反射获取对象所有属性集合
			Field[] fields = clazz.getDeclaredFields();
			//遍历集合
			Map<String,Object> mapTemp = new HashMap<String,Object>();
			for(int j = 0;j<fields.length;j++){
				//获取当前属性对象
				Field currField = fields[j];
				//获取当前属性名
				String fieldName = currField.getName();
				currField.setAccessible(true);
				//获取当前属性类型
				String type = currField.getType().getSimpleName();
				if(currField.get(t)!=null){
					if("Date".equalsIgnoreCase(type)){
						String date = DateUtil.date2StringSimple((Date)currField.get(t));
						mapTemp.put(fieldName, date);
					}else{
						mapTemp.put(fieldName, currField.get(t));
					}
				}
			}
			list1.add(mapTemp);
		}
		map.put("rows",list1);
		return (JSONObject) JSONObject.toJSON(map);
	}
	
	public static <T> JSONObject model2Json(T t) throws IllegalArgumentException, IllegalAccessException{
			Class<T> clazz = (Class<T>) t.getClass();
			//通过反射获取对象所有属性集合
			Field[] fields = clazz.getDeclaredFields();
			//遍历集合
			Map<String,Object> mapTemp = new HashMap<String,Object>();
			for(int j = 0;j<fields.length;j++){
				//获取当前属性对象
				Field currField = fields[j];
				//获取当前属性名
				String fieldName = currField.getName();
				currField.setAccessible(true);
				//获取当前属性类型
				String type = currField.getType().getSimpleName();
				if(currField.get(t)!=null){
					if("Date".equalsIgnoreCase(type)){
						String date = DateUtil.date2StringSimple((Date)currField.get(t));
						mapTemp.put(fieldName, date);
					}else{
						mapTemp.put(fieldName, currField.get(t));
					}
				}
			}
		return (JSONObject) JSONObject.toJSON(mapTemp);
	}
	
}
 