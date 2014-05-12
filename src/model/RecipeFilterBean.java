package model;

import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecipeFilterBean implements Serializable
{

    public String type;
    public String duration;
    public String xp;
    public String people;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public static void setTypes(Map<String, Object> types) {
        RecipeFilterBean.types = types;
    }

    public static Map<String,Object> types;

    static {
        RecipeFilterBean.types = new HashMap<String,Object>();
        DaoFabric fabric = DaoFabric.getInstance();
        types.put("all", "all");
        types.putAll(fabric.createRecipesDao().getAllTypes());
    }

	public RecipeFilterBean() {
	}

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String,Object> getTypes() {
        return types;
	}

}
