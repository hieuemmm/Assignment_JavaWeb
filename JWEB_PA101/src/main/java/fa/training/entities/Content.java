package fa.training.entities;

public class Content {
	private int contentID;
	private String title;
	private String brief;
	private String content;
	private String createdDate;
	private String updateTime;
	private int authorID;
	
	public Content() {
	}
	
	public Content(String title, String brief, String content,String createdDate,String updateTime) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdDate = createdDate;
		this.updateTime = updateTime;
	}

	public Content(int contentID, String title, String brief, String content, String createdDate, String updateTime,
			int authorID) {
		super();
		this.contentID = contentID;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdDate = createdDate;
		this.updateTime = updateTime;
		this.authorID = authorID;
	}
	public int getContentID() {
		return contentID;
	}
	public void setContentID(int contentID) {
		this.contentID = contentID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	
}
