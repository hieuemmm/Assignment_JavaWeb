package fa.training.entities;

public class Member {
	private int memberId;
	private String firstName;
	private String lastName;
	private String userName;
	private String passWork;
	private String phone;
	private String email;
	private String description;
	private String createdDate;
	private String updateTime;
	private int contentID;
	
	public Member() {
		super();
	}
	public Member(String userName, String passWork, String email) {
		super();
		this.userName = userName;
		this.passWork = passWork;
		this.email = email;
	}
	public Member(int memberId, String firstName, String lastName, String userName, String passWork, String phone,
			String email, String description, String createdDate, String updateTime) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWork = passWork;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.createdDate = createdDate;
		this.updateTime = updateTime;
	}
	public Member(int memberId, String firstName, String lastName, String phone, String email, String description) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.description = description;
	}
	public Member(int memberId, String firstName, String lastName, String phone, String email, String description, String createdDate, String updateTime) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.createdDate = createdDate;
		this.updateTime = updateTime;
	}
	public Member(int memberId, String firstName, String lastName, String userName, String passWork, String phone, String email, String description, String createdDate, String updateTime, int contentID) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWork = passWork;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.createdDate = createdDate;
		this.updateTime = updateTime;
		this.contentID = contentID;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWork() {
		return passWork;
	}
	public void setPassWork(String passWork) {
		this.passWork = passWork;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getContentID() {
		return contentID;
	}
	public void setContentID(int contentID) {
		this.contentID = contentID;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", passWork=" + passWork + ", phone=" + phone + ", email=" + email + ", description="
				+ description + ", createdDate=" + createdDate + ", updateTime=" + updateTime + ", contentID="
				+ contentID + "]";
	}
}
