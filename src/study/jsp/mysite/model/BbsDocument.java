package study.jsp.mysite.model;

public class BbsDocument {
	private int id;
	private String category;
	private String writerName;
	private String writerPw;
	private String email;
	private String subject;
	private String content;
	private int hit;
	private String regDate;
	private String editDate;
	private String ipAddress;
	private int memberId;
	
	//페이지 구현을 위해서 추가된 값
	private int limitStart;
	private int listCount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getWriterPw() {
		return writerPw;
	}
	public void setWriterPw(String writerPw) {
		this.writerPw = writerPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	@Override
	public String toString() {
		return "BbsDocument [id=" + id + ", category=" + category + ", writerName=" + writerName + ", writerPw="
				+ writerPw + ", email=" + email + ", subject=" + subject + ", content=" + content + ", hit=" + hit
				+ ", regDate=" + regDate + ", editDate=" + editDate + ", ipAddress=" + ipAddress + ", memberId="
				+ memberId + ", limitStart=" + limitStart + ", listCount=" + listCount + "]";
	}
	
	
	
	
}
