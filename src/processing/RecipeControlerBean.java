package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;
import model.RecipeFilterBean;
import model.RecipeListModelBean;
import model.RecipeModel;

@ManagedBean
@ApplicationScoped

public class RecipeControlerBean {
	private RecipesDao recipeDao;
	
	public RecipeControlerBean() {
		this.recipeDao=DaoFabric.getInstance().createRecipesDao();
	}
	
	
	public String loadAllRecipe(){
		ArrayList<RecipeModel> list = this.recipeDao.getAllRecipes();
		
		RecipeListModelBean recipeList=new RecipeListModelBean();
		
		for(RecipeModel recipe:list){
			recipeList.addRecipeList(recipe);
		}
		
		//r�cup�re l'espace de m�moire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		
		//place la liste de recette dans l'espace de m�moire de JSF
		sessionMap.put("recipeList", recipeList);

        return "recipesearch";
	}

    public String filterRecipe(RecipeFilterBean recipeFilterBean){
        ArrayList<RecipeModel> list = this.recipeDao.getFilteredRecipes(recipeFilterBean);

        RecipeListModelBean recipeList = new RecipeListModelBean();

        for(RecipeModel recipe:list){
            recipeList.addRecipeList(recipe);
        }

        //r�cup�re l'espace de m�moire de JSF
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();

        //place la liste de recette dans l'espace de m�moire de JSF
        sessionMap.put("recipeList", recipeList);

        return "recipesearch";
    }

}
