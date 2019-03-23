/**
 * 
 */
package cn.jx.pxc.pda.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import cn.jx.pxc.pda.dao.DormitoryScoreDao;
import cn.jx.pxc.pda.entity.AveragedScoreDormitory;
import cn.jx.pxc.pda.entity.DormitoryInfo;
import cn.jx.pxc.pda.entity.DormitoryScoreInfo;

/**
 *<p> Title:  DormitoryScoreDaoImpl.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.dao.impl
 * @author    黄信胜
 * @date      2019年3月22日下午3:15:22
 * @version 版本号
 */
@Repository
@SuppressWarnings("all")
public class DormitoryScoreDaoImpl extends BaseDaoHibernate implements DormitoryScoreDao {

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#selectDormitoryScore()
	 */
	@Override
	public List<DormitoryScoreInfo> selectDormitoryScore() throws Exception {
		return (List<DormitoryScoreInfo>) this.getHibernateTemplate().find("from DormitoryScoreInfo");
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#selectConditionDormitoryScore()
	 */
	@Override
	public List<DormitoryScoreInfo> selectConditionDormitoryScore(String content) throws Exception {
		String selectContent = "from DormitoryScoreInfo where instr(dormitoryIdScore,'"+content+"')>0";
		List<DormitoryScoreInfo> list = (List<DormitoryScoreInfo>) this.getHibernateTemplate().find(selectContent);
		return list;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#deleteDormitoryScore(java.lang.Integer)
	 */
	@Override
	public void deleteDormitoryScore(Integer id) throws Exception {
		DormitoryScoreInfo dt = this.checkExitDormitoryScore(id);
		this.getHibernateTemplate().delete(dt);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#updateDormitoryScore(java.lang.Integer)
	 */
	@Override
	public void updateDormitoryScore(Integer id,Double score) throws Exception {
		DormitoryScoreInfo dor = this.checkExitDormitoryScore(id);
			dor.setDormitoryScore(score);
			dor.setScoreDate(new Date());
			this.getHibernateTemplate().update(dor);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#checkExitDormitoryScore(java.lang.Integer)
	 */
	@Override
	public DormitoryScoreInfo checkExitDormitoryScore(Integer id) throws Exception {
		List<DormitoryScoreInfo> list = (List<DormitoryScoreInfo>) this.getHibernateTemplate().find("from DormitoryScoreInfo where id=?", id);
		if(list != null && list.size() >0) return list.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#addDormitoryScore(cn.jx.pxc.pda.entity.DormitoryScoreInfo)
	 */
	@Override
	public Integer addDormitoryScore(DormitoryScoreInfo dormitoryScore) throws Exception {
		return (Integer) this.getHibernateTemplate().save(dormitoryScore);
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#selectAllDormitory()
	 */
	@Override
	public List<DormitoryInfo> selectAllDormitory() throws Exception {
		List<DormitoryInfo> list = (List<DormitoryInfo>) this.getHibernateTemplate().find("from DormitoryInfo");
		return list;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.DormitoryScoreDao#calculateAvgScore(java.util.Date, java.util.Date)
	 */
	@Override
	public List<AveragedScoreDormitory> calculateAvgScore(Date startTime, Date endTime) throws Exception {
		String content="select distinct new "
							+ "cn.jx.pxc.pda.entity.AveragedScoreDormitory(dsi.dormitoryIdScore,"
							+ "ci.classAcademic,"
							+ "ci.className,ci.classTeacher,AVG(dsi.dormitoryScore))" + 
							" from " + 
							"DormitoryScoreInfo dsi," + 
							"ClassInfo ci," + 
							"ClassAndDormitory cad " + 
							"where  " + 
							" dsi.scoreDate between '"+startTime+"' and '"+endTime+"' and ci.classId=cad.classId " + 
							" and dsi.dormitoryIdScore=cad.dormitoryId" + 
							" group by " + 
							" dsi.dormitoryIdScore," + 
							"ci.classAcademic," + 
							"ci.className," + 
							"ci.classTeacher";
		return (List<AveragedScoreDormitory>) this.getHibernateTemplate()
				.getSessionFactory().getCurrentSession().createQuery(content).list();
	}

}
