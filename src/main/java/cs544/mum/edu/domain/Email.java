package cs544.mum.edu.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Email {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;


	
	
	
	@NotEmpty
	private String subject;
	private String content;
	private Date operdate;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<EmailHistory> historys;
	public List<EmailHistory> getHistorys() {
		return historys;
	}
	public void setHistorys(List<EmailHistory> historys) {
		this.historys = historys;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOperdate() {
		return operdate;
	}
	public void setOperdate(Date operdate) {
		this.operdate = operdate;
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
	
}
