package edu.technique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import edu.dao.classes.UserDao;
import edu.dao.interfaces.IUserDao;
import edu.technique.DataSource;
import edu.utils.errors.JDBCSQLconfigExceptions;


/**
*
* @author Hamza Bouali
*
*/
public class DataSource {

	private static final String FICHIER_PROPERTIES = "configuration.properties";
	private static final String PROPERTY_URL ="url";
	private static final String PROPERTY_DRIVER ="driver";
	private static final String PROPERTY_NOM_UTILISATEUR ="login";
	private static final String PROPERTY_MOT_DE_PASSE ="password";

	private String url;
	private String login;
	private String password;
	//private Connection connection;
	//private Properties properties;
	//private static DataSource instance;
	
	
	DataSource(String url,String login,String password) {
		this.url = url;
		this.login = login;
		this.password = password;
	}
	
	public static DataSource getInstance() throws JDBCSQLconfigExceptions {
		Properties properties = new Properties();
		String url;
		String driver;
		String login;
		String password;
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);
		if (fichierProperties == null) {
			throw new JDBCSQLconfigExceptions("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable");
		}
		
		// TODO Auto-generated constructor stub
		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			login = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			password = properties.getProperty(PROPERTY_MOT_DE_PASSE);
			/*connection = DriverManager.getConnection(url, login, password);
		} catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
		}*/
		}catch (IOException e) {
			throw new JDBCSQLconfigExceptions("Impossible de charger le fichier Properties " + FICHIER_PROPERTIES,e);
			}
		
		try {
			Class.forName(driver);
		}catch (ClassNotFoundException e) {
			throw new JDBCSQLconfigExceptions("Le Driver est introuvable dans le classpath.",e);
		}
		DataSource instance = new DataSource(url, login, password);
		return instance;
		
	}
	/*Chargement de la Base de Donnée */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,login,password);
		}
	
    /*public Connection getConnection() {
        return connection;
    }*/
    
    /*Récuperation de l'implementation des différents DAO*/
	public IUserDao getUserDao() {
		return new UserDao(this);
	}
	
}
