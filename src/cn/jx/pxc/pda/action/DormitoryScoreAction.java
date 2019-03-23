/**
 * 
 */
package cn.jx.pxc.pda.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jx.pxc.pda.entity.AveragedScoreDormitory;
import cn.jx.pxc.pda.entity.DormitoryInfo;
import cn.jx.pxc.pda.entity.DormitoryScoreInfo;
import cn.jx.pxc.pda.service.DormitoryScoreService;

/**
 *<p> Title:  DormitoryScoreAction.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.action
 * @author    黄信胜
 * @date      2019年3月22日下午3:35:49
 * @version 版本号
 */
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class DormitoryScoreAction extends ActionSupport implements ModelDriven<DormitoryScoreInfo>{
	
	private Date startTime;
	
	private Date endTime;
	
	@Resource
	private DormitoryScoreService dormitoryScoreService;
	
	private ActionContext con = ActionContext.getContext();
	
	private DormitoryScoreInfo dormitoryScoreInfo = new DormitoryScoreInfo();
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public DormitoryScoreInfo getModel() {
		return dormitoryScoreInfo;
	}
	
	/**
	 * 公共部分，更新最新的评分列表
	 */
	public void getAllDorSco() {
		List<DormitoryScoreInfo> dorScoList;
		try {
			dorScoList = dormitoryScoreService.getAllDormitoryScore();
			List<DormitoryInfo> dorList = dormitoryScoreService.selectAllDormitory();
			con.getSession().put("dorScoList",dorScoList );
			con.getSession().put("dorList",dorList );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 无筛选条件，得到所有寝室评分
	 * @return
	 */
	public String getAllDormitoryScore() {
		try {
			this.getAllDorSco();
			return "dorScoList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**按寝室号查询寝室分数
	 * @return
	 */
	public String selectConditionDormitoryScore() {
		try {
			List<DormitoryScoreInfo> dorScoList = dormitoryScoreService.selectConditionDormitoryScore(dormitoryScoreInfo.getDormitoryIdScore());
			con.getSession().put("dorScoList",dorScoList );
			return "dorScoList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**删除某个寝室分数
	 * @return
	 */
	public String deleteDormitoryScore() {
		try {
			Boolean termExit = dormitoryScoreService.deleteDormitoryScore(dormitoryScoreInfo.getId());
			if(termExit) {}else {
				ServletActionContext.getRequest().setAttribute("massages", "删除失败，无此对应分数的id");
			}
			this.getAllDorSco();
			return "dorScoList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**修改寝室分数
	 * @return
	 */
	public String updateDormitoryScore() {
		try {
			Boolean termExit = dormitoryScoreService.updateDormitoryScore(dormitoryScoreInfo.getId(), dormitoryScoreInfo.getDormitoryScore());
			if(termExit) {}else {
				ServletActionContext.getRequest().setAttribute("massages", "修改失败，无此对应分数的id");
			}
			this.getAllDorSco();
			return "dorScoList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**添加寝室分数
	 * @return
	 */
	public String addDormitoryScore() {
		try {
			Boolean termExit = dormitoryScoreService.addDormitoryScore(dormitoryScoreInfo);
			if(termExit) {}else {
				ServletActionContext.getRequest().setAttribute("massages", "添加失败！");
			}
			this.getAllDorSco();
			return "dorScoList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**求寝室评分平均数
	 * @return
	 */
	public String averageDormitoryScore() {
		try {
			
			List<AveragedScoreDormitory> averageScoreList = dormitoryScoreService.calculateAvgScore(new java.sql.Date(startTime.getTime()), new java.sql.Date(endTime.getTime()));
			con.getSession().put("averageScoreList", averageScoreList);
			return "lookAverageScore";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


}
