package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
//contrainte BEAN implements Serializable
public class UserModelBean implements Serializable{
	private String lastname;
    private String firstname;
    private String email;
	private int age;
	private String login;
	private String pwd;
	
	//Contrainte BEAN constructeur sans param�tre
	public UserModelBean() {
	}
	
	public UserModelBean(String lastname,String firstname, String email, int age,String login,String pwd) {
		this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
		this.age = age;
		this.login = login;
		this.pwd = pwd;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
	
	@Override
	public String toString() {
		return "[FIRSTNAME]:"+this.getFirstname()+",[LASTNAME]:"+this.getLastname()+",[EMAIL]:"+this.getEmail()+",[AGE]:"+this.getAge()+",[LOGIN]:"+this.getLogin()+",[PWD]:"+this.getPwd();
	}
	

}
