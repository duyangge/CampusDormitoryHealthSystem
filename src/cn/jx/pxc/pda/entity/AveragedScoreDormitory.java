/**
 * 
 */
package cn.jx.pxc.pda.entity;

/**
 *<p> Title:  AveragedScoreDormitory.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.entity
 * @author    黄信胜
 * @date      2019年3月23日下午4:03:16
 * @version 版本号
 */
public class AveragedScoreDormitory {
	private String dormitoryId;
	private String academics;
	private String classes;
	private String teacher;
	private Double avgScore;
	
	/**
	 * @param dormitoryId
	 * @param academics
	 * @param classes
	 * @param teacher
	 * @param avgScore
	 */
	public AveragedScoreDormitory(String dormitoryId, String academics, String classes, String teacher,
			Double avgScore) {
		super();
		this.dormitoryId = dormitoryId;
		this.academics = academics;
		this.classes = classes;
		this.teacher = teacher;
		this.avgScore = avgScore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academics == null) ? 0 : academics.hashCode());
		result = prime * result + ((avgScore == null) ? 0 : avgScore.hashCode());
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((dormitoryId == null) ? 0 : dormitoryId.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AveragedScoreDormitory other = (AveragedScoreDormitory) obj;
		if (academics == null) {
			if (other.academics != null)
				return false;
		} else if (!academics.equals(other.academics))
			return false;
		if (avgScore == null) {
			if (other.avgScore != null)
				return false;
		} else if (!avgScore.equals(other.avgScore))
			return false;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		if (dormitoryId == null) {
			if (other.dormitoryId != null)
				return false;
		} else if (!dormitoryId.equals(other.dormitoryId))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}
	public String getDormitoryId() {
		return dormitoryId;
	}
	public void setDormitoryId(String dormitoryId) {
		this.dormitoryId = dormitoryId;
	}
	public String getAcademics() {
		return academics;
	}
	public void setAcademics(String academics) {
		this.academics = academics;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public Double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
	@Override
	public String toString() {
		return "AveragedScoreDormitory [dormitoryId=" + dormitoryId + ", academics=" + academics + ", classes="
				+ classes + ", teacher=" + teacher + ", avgScore=" + avgScore + "]";
	}
	
	
	
}
