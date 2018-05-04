package org.es.service.manager.classroom;

import org.es.bean.JsonResult;
import org.es.model.Classroom;
import org.es.model.RoomUseInfo;

/**
 * 教室操作接口
 * @author Administrator
 *
 */
public interface IClassRoomService {
    /**
     * 添加教室信息
     */
	boolean insertClassRoom(Classroom classRoom);
	
	/**
	 * 删除教室信息
	 */
	boolean deleteClassRoom(Integer no);
	
	/**
	 * 更新教室信息
	 * @param no
	 * @return
	 */
	boolean updateClassRoom(Classroom classRoom);
	
	/**
	 * 获取某时间可用教室信息
	 */
	JsonResult getUsableClassRoomByCondition(String condition,Integer pageNum,Integer pageSize);
	
	/**
	 * 获取全部教室信息
	 */
	JsonResult getClassRoomByCondition(String condition,Integer pageNum,Integer pageSize);
	
	boolean insertRoomUseInfo(RoomUseInfo useInfo);
}
