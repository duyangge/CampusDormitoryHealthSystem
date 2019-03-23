/**
 * 
 */
package cn.jx.pxc.pda.dao;

import java.util.Date;
import java.util.List;

import cn.jx.pxc.pda.entity.AveragedScoreDormitory;
import cn.jx.pxc.pda.entity.DormitoryInfo;
import cn.jx.pxc.pda.entity.DormitoryScoreInfo;

/**
 *<p> Title:  DormitoryScore.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.dao
 * @author    黄信胜
 * @date      2019年3月22日下午3:06:26
 * @version 版本号
 */
public interface DormitoryScoreDao {
	
	/**检查该寝室id是否存在
	 * @param id
	 * @return
	 * @throws Exception
	 */
	DormitoryScoreInfo checkExitDormitoryScore(Integer id) throws Exception;
	
	
	/**
	 * 无筛选条件，直接查询所有
	 * @return
	 * @throws Exception
	 */
	List<DormitoryScoreInfo> selectDormitoryScore() throws Exception;
	
	
	/**条件查询
	 * @param term
	 * @return
	 * @throws Exception
	 */
	List<DormitoryScoreInfo> selectConditionDormitoryScore(String term) throws Exception;
	
	
	/**添加寝室分数
	 * @param dormitoryScore
	 * @throws Exception
	 */
	Integer addDormitoryScore(DormitoryScoreInfo dormitoryScore) throws Exception;
	
	
	/**删除寝室分数
	 * @param id
	 * @throws Exception
	 */
	void deleteDormitoryScore(Integer id) throws Exception;
	
	
	/**修改寝室分数
	 * @param id
	 * @throws Exception
	 */
	void updateDormitoryScore(Integer id, Double score) throws Exception;
	
	
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
