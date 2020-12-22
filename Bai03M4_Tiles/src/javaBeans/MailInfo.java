package javaBeans;


public class MailInfo {
	private String from;
	private String password;
	private String subject;
	private String email;
	private String content;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MailInfo() {
		super();
	}
	public MailInfo(String from, String password, String subject, String email, String content) {
		super();
		this.from = from;
		this.password = password;
		this.subject = subject;
		this.email = email;
		this.content = content;
	}
}
