package dao.instance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.RecipeFilterBean;
import model.RecipeModel;

public class RecipesDao {

	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public RecipesDao(String DB_HOST,String DB_PORT, String DB_NAME,String DB_USER,String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public void addRecipe(RecipeModel recipe) {
		// Cr�ation de la requ�te
		java.sql.Statement query;
		
		// create connection
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			// Creation de l'�l�ment de requ�te
			query = connection.createStatement();

			// Executer puis parcourir les r�sultats
			String sql = "INSERT INTO `Recipe` (`title`, `description`, `expertise`, `duration`, `nbpeople`,`type`) VALUES ('"
					+ recipe.getTitle()
					+ "', '"
					+ recipe.getDescription()
					+ "', '"
					+ recipe.getExpertise()
					+ "', '"
					+ recipe.getDuration()
					+ "', '"
					+ recipe.getNbpeople()
					+ "', '" + recipe.getType() + "');";
			int rs = query.executeUpdate(sql);
			query.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> getAllTypes() {
        Map<String, Object> types = new HashMap<String, Object>();

		// Cr�ation de la requ�te
		java.sql.Statement query;

		try {
		
		// create connection
		connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
				+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			// Creation de l'�l�ment de requ�te
			query = connection.createStatement();

			// Executer puis parcourir les r�sultats
			java.sql.ResultSet rs = query
					.executeQuery("SELECT distinct type FROM Recipe;");
			while (rs.next()) {
				types.put(rs.getString("type"), rs.getString("type"));
			}
			rs.close();
			query.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return types;
	}


    public ArrayList<RecipeModel> getAllRecipes() {
        ArrayList<RecipeModel> recipeList = new ArrayList<RecipeModel>();

        // Cr�ation de la requ�te
        java.sql.Statement query;

        try {

            // create connection
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
                    + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

            // Creation de l'�l�ment de requ�te
            query = connection.createStatement();

            // Executer puis parcourir les r�sultats
            java.sql.ResultSet rs = query
                    .executeQuery("SELECT * FROM Recipe;");
            while (rs.next()) {
                // Cr�ation de  la recette
                RecipeModel recipe = new RecipeModel(
                        rs.getString("title"), rs.getString("description"),
                        rs.getInt("expertise"), rs.getInt("duration"),
                        rs.getInt("nbpeople"), rs.getString("type"));
                System.out.println("Recipe : " + recipe);

                // ajout de la recette r�cup�r�e � la liste
                recipeList.add(recipe);
            }
            rs.close();
            query.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipeList;
    }


    public ArrayList<RecipeModel> getFilteredRecipes(RecipeFilterBean recipeFilterBean) {
        ArrayList<RecipeModel> recipeList = new ArrayList<RecipeModel>();

        // Cr�ation de la requ�te
        java.sql.Statement query;

        try {

            // create connection
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
                    + dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

            // Creation de l'�l�ment de requ�te
            query = connection.createStatement();
            String where = " WHERE ";
            boolean whereB = false;
            if(recipeFilterBean.getDuration() != null && !recipeFilterBean.getDuration().equals("")) {
                where = where.concat("duration <= "+Integer.parseInt(recipeFilterBean.getDuration()));
                whereB = true;
            }
            if(recipeFilterBean.getPeople() != null && !recipeFilterBean.getPeople().equals("")) {
                where = where.concat("nbpeople >= "+Integer.parseInt(recipeFilterBean.getPeople()));
                whereB = true;
            }
            if(recipeFilterBean.getXp() != null && !recipeFilterBean.getXp().equals("")) {
                where = where.concat("expertise <= "+Integer.parseInt(recipeFilterBean.getXp()));
                whereB = true;
            }
            if(recipeFilterBean.getType() != null && !recipeFilterBean.getType().equals("all")) {
                where = where.concat("type = '"+recipeFilterBean.getType()+"'");
                whereB = true;
            }
            if(!whereB) {
                where = "";
            }
            boolean x = recipeFilterBean.getType() != "all";
            System.out.println("X = "+x+"\n "+recipeFilterBean.getType());
            // Executer puis parcourir les r�sultats
            java.sql.ResultSet rs = query.executeQuery("SELECT * FROM Recipe"+where);
            while (rs.next()) {
                // Cr�ation de  la recette
                RecipeModel recipe = new RecipeModel(
                        rs.getString("title"), rs.getString("description"),
                        rs.getInt("expertise"), rs.getInt("duration"),
                        rs.getInt("nbpeople"), rs.getString("type"));
                System.out.println("Recipe : " + recipe);

                // ajout de la recette r�cup�r�e � la liste
                recipeList.add(recipe);
            }
            rs.close();
            query.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipeList;
    }
}
