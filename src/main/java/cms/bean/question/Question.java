package cms.bean.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 问题
 *
 */
@Entity
@Table(indexes = {@Index(name="question_1_idx", columnList="userName,postTime"),@Index(name="question_2_idx", columnList="status,sort,lastUpdateTime"),@Index(name="question_3_idx", columnList="adoptionAnswerId,status,sort,lastUpdateTime")})
public class Question implements Serializable{
	private static final long serialVersionUID = 8441186002971301170L;
	/** Id **/
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** 标题 **/
	@Column(length=190)
	private String title;

	/** 标签 **/
	@Transient
	private List<QuestionTagAssociation> questionTagAssociationList = new ArrayList<QuestionTagAssociation>();
	
	/** 问题内容 **/
	@Lob
	private String content;
	/** 内容摘要 **/
	@Lob
	private String summary;
	/** 追加内容 **/
	@Lob
	private String appendContent;
	
	
	/** 发表时间 **/
	@Temporal(TemporalType.TIMESTAMP)
	private Date postTime = new Date();
	/** 最后回答时间 **/
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAnswerTime;
	/** 最后修改时间 **/
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateTime;
	
	/** IP **/
	@Column(length=45)
	private String ip;
	/** IP归属地 **/
	@Transient
	private String ipAddress;
	
	/** 采纳的答案Id **/
	private Long adoptionAnswerId = 0L;
	
	/** 答案总数 **/
	private Long answerTotal = 0L;
	/** 允许回答 **/
	private boolean allow = true;
	
	/** 查看总数 **/
	private Long viewTotal = 0L;
	
	/** 用户名称 **/
	@Column(length=30)
	private String userName;
	/** 呢称 **/
	@Transient
	private String nickname;
	/** 头像路径 **/
	@Transient
	private String avatarPath;
	/** 头像名称 **/
	@Transient
	private String avatarName;
	
	/** 用户角色名称集合 **/
	@Transient
	private List<String> userRoleNameList = new ArrayList<String>();
	
	/** 是否为员工 true:员工  false:会员 **/
	private Boolean isStaff = false;
	/** 排序  **/
	private Integer sort = 0;
	/** 状态 10.待审核 20.已发布 110.待审核删除 120.已发布删除 **/
	private Integer status = 10;
	
	/**
	 * 添加标签
	 * @param questionTagAssociation
	 */
	public void addQuestionTagAssociation(QuestionTagAssociation questionTagAssociation) {
		this.getQuestionTagAssociationList().add(questionTagAssociation);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAppendContent() {
		return appendContent;
	}
	public void setAppendContent(String appendContent) {
		this.appendContent = appendContent;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public Date getLastAnswerTime() {
		return lastAnswerTime;
	}
	public void setLastAnswerTime(Date lastAnswerTime) {
		this.lastAnswerTime = lastAnswerTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Long getAnswerTotal() {
		return answerTotal;
	}
	public void setAnswerTotal(Long answerTotal) {
		this.answerTotal = answerTotal;
	}
	public boolean isAllow() {
		return allow;
	}
	public void setAllow(boolean allow) {
		this.allow = allow;
	}
	public Long getViewTotal() {
		return viewTotal;
	}
	public void setViewTotal(Long viewTotal) {
		this.viewTotal = viewTotal;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatarPath() {
		return avatarPath;
	}
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
	public String getAvatarName() {
		return avatarName;
	}
	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}
	public List<String> getUserRoleNameList() {
		return userRoleNameList;
	}
	public void setUserRoleNameList(List<String> userRoleNameList) {
		this.userRoleNameList = userRoleNameList;
	}

	public Boolean getIsStaff() {
		return isStaff;
	}
	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<QuestionTagAssociation> getQuestionTagAssociationList() {
		return questionTagAssociationList;
	}
	public void setQuestionTagAssociationList(List<QuestionTagAssociation> questionTagAssociationList) {
		this.questionTagAssociationList = questionTagAssociationList;
	}


	public Long getAdoptionAnswerId() {
		return adoptionAnswerId;
	}


	public void setAdoptionAnswerId(Long adoptionAnswerId) {
		this.adoptionAnswerId = adoptionAnswerId;
	}
	
	
}
