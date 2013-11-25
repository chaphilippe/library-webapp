package com.zuhlke.library.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Objects;

@Entity @Table(name = "student") @Cacheable
public class Student implements Serializable {

    private static final long serialVersionUID = 5541659969794633170L;

    @Id 
    @GeneratedValue(generator = "student_id", strategy = GenerationType.TABLE)
    @TableGenerator(name = "student_id", pkColumnValue = "student")
    @Column(name = "student_id")
    private Long id;
    
    @Column(name = "firstname")
    @Length(max = 500) @NotNull @NotEmpty
    private String firstname;
    
    @Column(name = "lastname")
    @Length(max = 500)
    private String lastname;

    @Column(name = "age")
    @Length(max = 255) @NotNull @NotEmpty
    private String age;
    
    @Column(name = "sex")
    @Length(max = 255)
    private String sex;
    
    @Column(name = "origin")
    @Length(max = 255)
    private String origin;
    
    @Column(name = "department")
    @Length(max = 255)
    private String department;
    
    @Column(name = "joined_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinedDate;

    @Column(name = "is_competent", columnDefinition = "BIT")
    private boolean isCompetent;
    
    @Column(name = "is_scholarship", columnDefinition = "BIT")
    private boolean isScholarship;
    
    public Student() { }

    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public boolean getIsCompetent() {
		return isCompetent;
	}

	public void setIsCompetent(boolean isCompetent) {
		this.isCompetent = isCompetent;
	}

	public boolean getIsScholarship() {
		return isScholarship;
	}

	public void setIsScholarship(boolean isScholarship) {
		this.isScholarship = isScholarship;
	}
    
    
    public Long getId() {
        return id;
    }
    
    protected void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
    
    public Student withId(long id) {
        this.id = id;
        return this;
    }
    
    public Student withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    
    public Student withLastname(String lastname) {
    	this.lastname = lastname;
    	return this;
    }
    
    public Student withAge(String age) {
        this.age = age;
        return this;
    }
    
    public Student withSex(String sex) {
    	this.sex = sex;
    	return this;
    }
    
    public Student withOrigin(String origin) {
    	this.origin = origin;
    	return this;
    }

    public Student withDepartment(String department) {
    	this.department = department;
    	return this;
    }
    
    public Student withIssueDate(Date joinedDate) {
    	this.joinedDate = joinedDate;
    	return this;
    }
    
    public Student withIsCompetent(Boolean isCompetent) {
        this.isCompetent = isCompetent;
        return this;
    }
    
    public Student withIsScholarship(Boolean isCompetent) {
    	this.isCompetent = isCompetent;
    	return this;
    }
    

}

