package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped //Dur�e de vue uniquement lors d'une requ�te
//m�me propri�t�s que UserModelBean mais port�e diff�rente
public class UserSubmissionModelBean extends UserModelBean{

    private String pwd2;

	public UserSubmissionModelBean() {
	}
    public String getPwd2() {
        return pwd2;
    }

    public void setPwd2(String pwd2) {
        this.pwd2 = pwd2;
    }
}
