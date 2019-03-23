package cn.jx.pxc.pda.entity;

import java.util.Date;

/**
 *<p> Title:  dormitoryScoreInfo.java</p>
 *<p> Description:  不同的日期的寝室卫生分数</p>
 * @package   com.pxxy.dormitoryassessment.bean
 * @author    黄信胜
 * @date      2019年3月22日上午8:55:45
 * @version 版本号
 */
public class DormitoryScoreInfo {
    private Integer id;

    private String dormitoryIdScore;

    private Double dormitoryScore;

    private Date scoreDate;

    private String scoreUsername;
    
    private String remarks;
    
    public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDormitoryIdScore() {
        return dormitoryIdScore;
    }

    public void setDormitoryIdScore(String dormitoryIdScore) {
        this.dormitoryIdScore = dormitoryIdScore == null ? null : dormitoryIdScore.trim();
    }

    public Double getDormitoryScore() {
        return dormitoryScore;
    }

    public void setDormitoryScore(Double dormitoryScore) {
        this.dormitoryScore = dormitoryScore;
    }

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }


	public String getScoreUsername() {
		return scoreUsername;
	}

	public void setScoreUsername(String scoreUsername) {
		this.scoreUsername = scoreUsername;
	}

	@Override
	public String toString() {
		return "DormitoryScoreInfo [id=" + id + ", dormitoryIdScore=" + dormitoryIdScore + ", dormitoryScore="
				+ dormitoryScore + ", scoreDate=" + scoreDate + ", scoreUsername=" + scoreUsername + ", remarks="
				+ remarks + "]";
	}

    
}