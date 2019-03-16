# MAAO Project
 MAAO is a JAVA-based project for Retirement Home. 
 We are actually in the release 1 of the project 
 For the moment its key features are:
 - Multi-user can be connected at the same time restricted by a connectionPool (In this case : 2 simultanate connection is available)
 - Users can see all the stairs of the retirement Home
 - Users can update a stair of the retirement Home
 - Users can delete a stair of the retirement Home
 - Users can add a stair of the retirement Home 
 
More information and screenshots can be inserted in the future.
This projected is created by students Information Systems at <a href="http://esipe.u-pec.fr/accueil-fr/accueil-esipe-creteil-805697.kjsp">ESIPE engineering school</a>.

# Installation
If you want to run an instance of MAAO project, we recommand to you to :

- have an MySQL Server up to date (System who dispose MySQL : <a href="http://www.wampserver.com/#download-wrapper">Wamp</a>, <a href="https://www.apachefriends.org/fr/download.html">Xamp</a>  or <a href="https://doc.ubuntu-fr.org/lamp">Lamp</a>)
- have <a href="https://www.eclipse.org/downloads/">Eclipse</a> up to date (don't forget to have the <a href="https://www.java.com/fr/download/">JRE</a> or the <a href="https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">JDK</a> like the JavaSE-1.8)

- Launch your Eclipse
- Launch your MySQL Server
- It is important to adapt the file `propertisa` on `src` for modify with your own parameters (database username, password, etc.). 
- Execute these request on your database :

> --------------
> CREATE DATABASE `maao`;
> DROP TABLE IF EXISTS `stair`;
> CREATE TABLE IF NOT EXISTS `stair` (
>`stair_id` 		int(11) 		NOT NULL 				AUTO_INCREMENT	,
>`stair_name` 	varchar(255) 	COLLATE utf8_unicode_ci DEFAULT NULL	,
> PRIMARY KEY (`stair_id`)													,
> UNIQUE KEY `stair_name` (`stair_name`)
> ) 
> ENGINE=MyISAM 
> AUTO_INCREMENT=36 
> DEFAULT 
> CHARSET=utf8 
> COLLATE=utf8_unicode_ci;

> INSERT INTO `stair` (`stair_name`) VALUES
> ('Etage 1'),
> ('Etage 2'),
> ('Etage 2 bis');

> COMMIT;

--------------

- On Eclipse, click on the menu File => Open Projects from File System
- Choose the MAAO project
- Be sure that all of other project that you have on Eclipse is closed
- Open the project MAAO
- Click on the green launch button to play the application


# Launch Application MAAO
### Window menu IT administrator
- Click on the button `open a connection` (if you want to see a multi-users systems, click how many long you want the button)
- If you want to see all connections available from the menu window, click on the button `Display connections`

### Window for connexion (this window is a provisional window)
- Write for the `username` : `user`, for the `password` : `password123` and click on the button `Connexion`

### Add an element
- Write a name on the input field
- Click on the button `add`

### Update an element
- select a line on the table
- click on the button `modify`
<i>A new input field is visible with the value to modify.</i>
- Modify the name on the input filed 
- Click on the button `submit`

### Delete an element
- select a line on the table
- click on the button `delete`  

## Security
- SQL Request are used on prepared request
- We verify if a same value does not exist in the database
- We limit the number of connection (you can also change the number)
- We verify for not insert a black value in the database
- We verify if the database is connected to see the IT administator panel
- The database connection information is stocked in properties files (called : `propertisa`)

# Source
The source is composed in 4 packages in the folder `src` :
- (default package) [folder]
	- Main.java
- controler [folder]
	- DAO.java
	- DAOStair.java
	- DAOFactory.java
	- DAOConfigurationException.java
	- DataSource.java
	- JDBCConnectionPool.java
	- ReadFileXML.java
- model [folder]
	- Stair.java
- view [folder]
	- Window.java
	- WindowStair.java
	- WindowConnexion.java
	- FirstF.java 
- propertisa [file]

Another files needed to be at the head of the MAAO : properties.xml
The second file need to be in the folder `lib` :
- mysql-connector-java-5.1.21.jar [jar]

# Before commit

Before commiting, we test everithings in an `homologation` branch : <a href="https://github.com/AnsaryMarecar/MAAO/tree/Homologation"> link to this branch </a>

# Contact Information
For contact us, please contact use by e-mail at : 
- ansary.marecar@etu.u-pec.fr (for external communication),
- amine.maza@etu.u-pec.fr,
- oussama.bouachrine@etu.u-pec.fr,
- melissa.oussadi@etu.u-pec.fr.