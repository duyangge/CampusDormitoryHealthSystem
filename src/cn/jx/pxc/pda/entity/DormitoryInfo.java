package cn.jx.pxc.pda.entity;

/**
 *<p> Title:  DormitoryInfo.java</p>
 *<p> Description:  寝室信息</p>
 * @package   com.pxxy.dormitoryassessment.bean
 * @author    admin
 * @date      2019年3月22日上午8:54:50
 * @version 1.0
 */
public class DormitoryInfo {
    private String dormitoryId;


	public String getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(String dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	@Override
	public String toString() {
		return "DormitoryInfo [ dormitoryId=" + dormitoryId + "]";
	}

}