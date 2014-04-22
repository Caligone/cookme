package processing;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.LoginBean;
import model.UserModelBean;
import dao.fabric.DaoFabric;
import dao.instance.UserDao;
import model.UserSubmissionModelBean;

@ManagedBean
@ApplicationScoped // Utilisation de application scope afin d'offrir un point d'entr�e unique � l'ensemble des clients
public class UserControlerBean {
	private UserDao userDao;
	
	public UserControlerBean() {
		this.userDao=DaoFabric.getInstance().createUserDao();
	}
	
	public String checkUser(LoginBean loginBean){
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(), loginBean.getPwd());
		if( user!=null){
			
			//r�cup�re l'espace de m�moire de JSF
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			
			//place l'utilisateur dans l'espace de m�moire de JSF
			sessionMap.put("loggedUser", user);
			
			//redirect the current page
			return "userdisplay.xhtml";
		}else{
			
			//redirect the current page
			return "userLogin.xhtml";
		}
	}
	
	public void checkAndAddUser(UserSubmissionModelBean userSubmitted){
		
		//V�rifier les propri�t�s de l'utilisateur
		//TODO
		
		//ajout de l'utilisateur � la base de donn�es
		this.userDao.addUser(userSubmitted);
	}

}
