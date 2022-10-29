package fa.training.entities;

public class Member {
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private String phone;
	private String email;
	private String description;
	private String createdDate;
	private String updateTime;
	
	public Member() {
	}
	
	public Member(String userName, String passWord, String email, String createdDate) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.createdDate = createdDate;
	}

	public Member(String userName, String firstName, String lastName, String phone, String description, String updateTime) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.description = description;
		this.updateTime = updateTime;
	}

	public Member(String firstName, String lastName, String userName, String passWord, String phone, String email, String description, String createdDate, String updateTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.createdDate = createdDate;
		this.updateTime = updateTime;
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
		return userName.trim();
	}
	public void setUserName(String userName) {
		this.userName = userName.trim();
	}
	public String getPassWord() {
		return passWord.trim();
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord.trim();
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
	@Override
	public String toString() {
		return "Member [firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", passWord=" + passWord + ", phone=" + phone + ", email=" + email + ", description="
				+ description + ", createdDate=" + createdDate + ", updateTime=" + updateTime + "]";
	}
}
