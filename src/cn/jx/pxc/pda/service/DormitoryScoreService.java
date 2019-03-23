/**
 * 
 */
package cn.jx.pxc.pda.service;

import java.util.Date;
import java.util.List;

import cn.jx.pxc.pda.entity.*;

/**
 *<p> Title:  DormitoryScoreService.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.service
 * @author    黄信胜
 * @date      2019年3月22日下午3:25:58
 * @version 版本号
 */
public interface DormitoryScoreService {
	
	/**
	 * 查看所有的寝室评分
	 * @return
	 * @throws Exception
	 */
	List<DormitoryScoreInfo> getAllDormitoryScore() throws Exception;
	
	/**条件查询
	 * @param term
	 * @return
	 * @throws Exception
	 */
	List<DormitoryScoreInfo> selectConditionDormitoryScore(String term) throws Exception;
	
	
	/**删除寝室分数
	 * @param id
	 * @throws Exception
	 */
	Boolean deleteDormitoryScore(Integer id) throws Exception;
	
	
	/**修改寝室分数
	 * @param id
	 * @throws Exception
	 */
	Boolean updateDormitoryScore(Integer id, Double score) throws Exception;
	
	
	/**添加寝室分数
	 * @param dormitoryScore
	 * @return
	 * @throws Exception
	 */
	Boolean addDormitoryScore(DormitoryScoreInfo dormitoryScore) throws Exception;
	
	/**查询所有的寝室
	 * @return
	 * @throws Exception
	 */
	List<DormitoryInfo> selectAllDormitory() throws Exception;
	
	/**计算一段时间内的寝室平均分
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	List<AveragedScoreDormitory> calculateAvgScore(Date startTime, Date endTime) throws Exception;

}
