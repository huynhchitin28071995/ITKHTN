package models;

import java.sql.Date;

public class Member {
	private long id;
	private String username, password, email, fullName;
	private byte gender;
	private Date addedDate;

	public Member(long id, String username, String password, String email, String fullName, byte gender,
			Date addedDate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.gender = gender;
		this.addedDate = addedDate;
	}

	public Member(long id, String username) {
		this(id, username, null, null, null, Byte.MIN_VALUE, null);
	}

	public Member(long id, String username, String password, String email, String fullName, byte gender) {
		this(id, username, password, email, fullName, gender, null);
	}

	private Member(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
		this.fullName = builder.fullName;
		this.gender = builder.gender;
		this.addedDate = builder.addedDate;
	}

	public static class Builder { // prefer this to constructor
		private long id;
		private String username, password, email, fullName;
		private byte gender;
		private Date addedDate;

		public Builder() {

		}

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder fullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public Builder gender(byte gender) {
			this.gender = gender;
			return this;
		}

		public Builder addedDate(Date addedDate) {
			this.addedDate = addedDate;
			return this;
		}

		public Member build() {
			return new Member(this);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", fullName=" + fullName + ", gender=" + gender + ", addedDate=" + addedDate + "]";
	}

	public void println() {
		System.out.println(this.toString());
	}

}
