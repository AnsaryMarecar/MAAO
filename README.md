# NOT MAINTAINED

# SAFE RETIREMENT HOME Project
 SAFE RETIREMENT HOME is a JAVA-based project for Retirement Home. 
 We are actually in the release 3 of the project 

More information and screenshots can be inserted in the future.
This projected was created by students in Engineering School.

# Installation
If you want to run an instance of MAAO project, we recommand to you to :

- have an MySQL Server up to date (System who dispose MySQL : <a href="http://www.wampserver.com/#download-wrapper">Wamp</a>, <a href="https://www.apachefriends.org/fr/download.html">Xamp</a>  or <a href="https://doc.ubuntu-fr.org/lamp">Lamp</a>)
- have <a href="https://www.eclipse.org/downloads/">Eclipse</a> up to date (don't forget to have the <a href="https://www.java.com/fr/download/">JRE</a> or the <a href="https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">JDK</a> like the JavaSE-1.8)

- Launch your Eclipse
- Launch your MySQL Server
- It is important to adapt the file `propertis` on `src` for modify with your own parameters (database username, password, etc.). 
- Execute these request on your database :

> --------------
> CREATE DATABASE `maao`;
> DROP TABLE IF EXISTS `type_sensor`;
> CREATE TABLE IF NOT EXISTS `type_sensor` (
>`type_sensor_id` 		int(11) 		NOT NULL 				AUTO_INCREMENT	,
>`type_sensor_name` 	varchar(255) 	COLLATE utf8_unicode_ci DEFAULT NULL	,
> PRIMARY KEY (`type_sensor_id`)													,
> UNIQUE KEY `type_sensor_name` (`type_sensor_name`)
> ) 
> ENGINE=MyISAM 
> AUTO_INCREMENT=36 
> DEFAULT 
> CHARSET=utf8 
> COLLATE=utf8_unicode_ci;

> INSERT INTO `type_sensor` (`type_sensor_name`) VALUES
> ('CAPTEUR DE MOUVEMENT'),
> ('HUMIDITE'),
> ('FUMEE');

> COMMIT;

--------------

- On Eclipse, click on the menu File => Open Projects from File System
- Choose the MAAO project
- Be sure that all of other project that you have on Eclipse is closed
- Open the project MAAO
- Click on the green launch button to play the application


# Launch Application SERVICE
###

# Launch Application CLIENT
###

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
- The database connection information is stocked in properties files (called : `properties`) on server

# Before commit

Before commiting, we test everithings in an `homologation` branch : <a href="https://github.com/AnsaryMarecar/MAAO/tree/Homologation"> link to this branch </a>

# Contact Information
For contact us, please contact use by e-mail at : 
- ansary.marecar@edu.esiee.fr (for external communication),
- oussama.bouachrine@etu.u-pec.fr,
- amine.maza@esiea.fr,
- melissa.oussadi@etu.u-pec.fr.
