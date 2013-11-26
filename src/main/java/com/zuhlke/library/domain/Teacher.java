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

@Entity @Table(name = "teacher") @Cacheable
public class Teacher implements Serializable {

	@Id 
    @GeneratedValue(generator = "teacher_id", strategy = GenerationType.TABLE)
    @TableGenerator(name = "teacher_id", pkColumnValue = "teacher")
    @Column(name = "teacher_id")
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
    @Length(max = 1)
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
    private Boolean isCompetent;
  
    public Teacher() { }

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

	public Boolean getIsCompetent() {
		return isCompetent;
	}

	public void setIsCompetent(Boolean isCompetent) {
		this.isCompetent = isCompetent;
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
    
    public Teacher withId(long id) {
        this.id = id;
        return this;
    }
    
    public Teacher withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    
    public Teacher withLastname(String lastname) {
    	this.lastname = lastname;
    	return this;
    }
    
    public Teacher withAge(String age) {
        this.age = age;
        return this;
    }
    
    public Teacher withSex(String sex) {
    	this.sex = sex;
    	return this;
    }
    
    public Teacher withOrigin(String origin) {
    	this.origin = origin;
    	return this;
    }

    public Teacher withDepartment(String department) {
    	this.department = department;
    	return this;
    }
    
    public Teacher withJoinedDate(Date joinedDate) {
    	this.joinedDate = joinedDate;
    	return this;
    }

    public Teacher withIsCompetent(Boolean isCompetent) {
        this.isCompetent = isCompetent;
        return this;
    }
    
    public Teacher withIsScholarship(Boolean isCompetent) {
    	this.isCompetent = isCompetent;
    	return this;
    }
    

}

