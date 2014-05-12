package processing;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.LoginBean;
import model.UserModelBean;
import dao.fabric.DaoFabric;
import dao.instance.UserDao;
import model.UserSubmissionModelBean;

@ManagedBean
@ApplicationScoped
public class UserControlerBean {
	private UserDao userDao;

	public UserControlerBean() {
		this.userDao=DaoFabric.getInstance().createUserDao();
	}

	public String checkUser(LoginBean loginBean) {
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(), loginBean.getPwd());
		if(user != null) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("loggedUser", user);
		}

		return "menu.xhtml";
	}

	public String logout() {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.remove("loggedUser");

			return "menu.xhtml";
	}

	public boolean isConnected() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		if (sessionMap.containsKey("loggedUser")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String checkAndAddUser(UserSubmissionModelBean userSubmitted){

        this.userDao.addUser(userSubmitted);

        return "menu";
	}

}
