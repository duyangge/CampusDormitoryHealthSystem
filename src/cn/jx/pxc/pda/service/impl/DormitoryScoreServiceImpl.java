/**
 * 
 */
package cn.jx.pxc.pda.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.pda.dao.DormitoryScoreDao;
import cn.jx.pxc.pda.entity.AveragedScoreDormitory;
import cn.jx.pxc.pda.entity.DormitoryInfo;
import cn.jx.pxc.pda.entity.DormitoryScoreInfo;
import cn.jx.pxc.pda.service.DormitoryScoreService;

/**
 *<p> Title:  DormitoryScoreServiceImpl.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.service.impl
 * @author    黄信胜
 * @date      2019年3月22日下午3:27:43
 * @version 版本号
 */
@Service
@Transactional
public class DormitoryScoreServiceImpl implements DormitoryScoreService {
	
	@Resource
	private DormitoryScoreDao dormitoryScoreDao;
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.DormitoryScoreService#getAllDormitoryScore()
	 */
	@Override
	public List<DormitoryScoreInfo> getAllDormitoryScore() throws Exception {
		return dormitoryScoreDao.selectDormitoryScore();
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.DormitoryScoreService#selectConditionDormitoryScore(java.lang.String)
	 */
	@Override
	public List<DormitoryScoreInfo> selectConditionDormitoryScore(String term) throws Exception {
		return dormitoryScoreDao.selectConditionDormitoryScore(term);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.DormitoryScoreService#deleteDormitoryScore(java.lang.Integer)
	 */
	@Override
	public Boolean deleteDormitoryScore(Integer id) throws Exception {
		//检查该寝室分数id是否存在
		DormitoryScoreInfo dt = dormitoryScoreDao.checkExitDormitoryScore(id);
		if(dt != null) {
			dormitoryScoreDao.deleteDormitoryScore(id);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.DormitoryScoreService#updateDormitoryScore(java.lang.Integer, java.lang.Double)
	 */
	@Override
	public Boolean updateDormitoryScore(Integer id, Double score) throws Exception {
		//检查寝室id是否还在
		DormitoryScoreInfo dor = dormitoryScoreDao.checkExitDormitoryScore(id);
		if(dor != null) {
			dormitoryScoreDao.updateDormitoryScore(id, score);
			return true;
		}
		return false;		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.DormitoryScoreService#addDormitoryScore(cn.jx.pxc.pda.entity.DormitoryScoreInfo)
	 */
	@Override
	public Boolean addDormitoryScore(DormitoryScoreInfo dormitoryScore) throws Exception {
		Integer id = dormitoryScoreDao.addDormitoryScore(dormitoryScore);
		if(id == -1) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.DormitoryScoreService#selectAllDormitory()
	 */
	@Override
	public List<DormitoryInfo> selectAllDormitory() throws Exception {
		
		return dormitoryScoreDao.selectAllDormitory();
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.DormitoryScoreService#calculateAvgScore(java.util.Date, java.util.Date)
	 */
	@Override
	public List<AveragedScoreDormitory> calculateAvgScore(Date startTime, Date endTime) throws Exception {
		// TODO Auto-generated method stub
		return dormitoryScoreDao.calculateAvgScore(startTime, endTime);
	}

}
