package org.es.util.excelutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.es.util.format.DateUtil;


/** 
* @author tigerJay 
* excel操作类
*/
public class POIUtil<T> {
	/**
	 * 将List集合转化为xls文件
	 * @param list 要转化的list集合
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public  HSSFWorkbook out(List<T> list) throws IllegalArgumentException, IllegalAccessException, IOException{
		//创建xls文档对象
		HSSFWorkbook hwb = new HSSFWorkbook();
		//创建表单对象
		HSSFSheet hs = hwb.createSheet();
		//创建行
		HSSFRow hr = hs.createRow(0);
		//创建样式
		HSSFFont font = hwb.createFont();
		font.setFontHeight((short)400);
		HSSFCellStyle cellStyle = hwb.createCellStyle();
		cellStyle.setFont(font);
		hr.setRowStyle(cellStyle);
		//创建单元格对象
		HSSFCell hc = hr.createCell(0);
		//遍历对象集合
		for(int j = 0;j<list.size();j++){
			//获取当前对象
			T t = list.get(j);
			Class<T> clazz = (Class<T>) t.getClass();
			//获取对象属性数组
			Field[] fields = clazz.getDeclaredFields();
			HSSFRow row = hs.createRow(j+1);
			int count = 0;
			for(int i=0;i<fields.length;i++){
				OutName annotation = fields[i].getAnnotation(OutName.class);
				if(j==0&&annotation!=null){
					//获取标题内容
					String titleValue = annotation.value();
					//获取标题单元格
					HSSFCell titleCell = hr.createCell(count);
					titleCell.setCellValue(titleValue);
				}
				Field field = fields[i];
				if(field.getAnnotation(OutName.class)!=null){
					field.setAccessible(true);
					String fieldType = field.getType().getSimpleName();
					Object value = null;
					if(fields[i].get(t)!=null){
						if("Date".equalsIgnoreCase(fieldType)){
							value = DateUtil.date2StringSimple((Date) fields[i].get(t));
						}else{
							value = fields[i].get(t);
						}
						//创建单元格对象
						HSSFCell cell = row.createCell(count);
						cell.setCellValue(String.valueOf(value));
					}
					count++;
				}
			}
		}
	    return hwb;
	}
	/**
	 * xls文档转化为List集合
	 * @param filePath 文档路径
	 * @param clazz
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvalidFormatException 
	 */
	public  List<T> in(String filePath,Class<T> clazz) throws IOException, InstantiationException, IllegalAccessException, InvalidFormatException{
		//保存对象的集合
		List<T> list = new ArrayList<T>();
		//创建文件输入流
		FileInputStream fis = new FileInputStream(new File(filePath));
		//创建xls文档对象
		
		//XSSFWorkbook hw = new XSSFWorkbook(fis);
		Workbook workbook = WorkbookFactory.create(fis);
		//获取表单对象
		Sheet sheet  = workbook.getSheetAt(0);
		//获取第一行
		Row titleRow = sheet.getRow(0);
		//获取列数
		int cellNumber = titleRow.getPhysicalNumberOfCells();
		//获取行数
		int rowNumber = sheet.getLastRowNum()+1;
		//遍历行
		for(int i=1;i<rowNumber;i++){
			//获取当前行对象
			Row currentRow = sheet.getRow(i);
			//创建要转化的对象
			T t = clazz.newInstance();
			//遍历列对象
			for(int j=0;j<cellNumber;j++){
				//获取对象属性数组
				Field[] fields = clazz.getDeclaredFields();
				//获取当前列标题
				String titleName = titleRow.getCell(j).getStringCellValue();
				//获取当前单元格值
				if(currentRow.getCell(j)==null){
					continue;
				}
			    currentRow.getCell(j).setCellType(XSSFCell.CELL_TYPE_STRING);
				String currentCellValue = currentRow.getCell(j).getStringCellValue();
				//获取与标题值相同的注解值的属性对象
				Field resultField = getFieldByOutNameValue(titleName, fields);
				if(resultField!=null){
					//判断属性类型并将当前单元格值赋给对应属性
					String fieldType = resultField.getType().getSimpleName();
					if("Date".equalsIgnoreCase(fieldType)){
						Date date = DateUtil.string2DateSimple(currentCellValue);
						resultField.set(t, date);
					}else if("Integer".equalsIgnoreCase(fieldType)){
						Integer value = Integer.valueOf(currentCellValue);
						resultField.set(t,value);
					}else if("Double".equalsIgnoreCase(fieldType)){
						Double value = Double.valueOf(currentCellValue);
						resultField.set(t,value);
					}else{
						resultField.set(t, currentCellValue);
					}
				}
			}
			list.add(t);
		}
		fis.close();
		return list;
	}
	
	/**
	 * 获取注解值和标题相同的属性对象
	 * @param titleName 标题名
	 * @param fields 属性集合
	 * @return 属性对象
	 */
	private Field getFieldByOutNameValue(String titleName,Field[] fields){
		for(int i = 0;i<fields.length;i++){
			Field field = fields[i];
			field.setAccessible(true);
			if(field.getAnnotation(OutName.class)==null){
				continue;
			}
			String fieldName = field.getAnnotation(OutName.class).value();
			if(titleName.equals(fieldName)){
				return fields[i];
			}
		}
		return null;
	}
} 
