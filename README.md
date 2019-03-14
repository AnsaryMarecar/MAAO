# MAAO Project
 MAAO is a JAVA-based project for Retirement Home. 
 We are actually in the release 1 of the project 
 For the moment its key features are:
 - User can connect to the application with a connection Pool
 - User can see all the stair of the retirement Home
 - User can update a stair of the retirement Home
 - User can delete a stair of the retirement Home
 - User can add a stair of the retirement Home 
 
More information and screenshots can be inserted in the future.
This projected is created by students of ESIPE.

# Installation
If you want to run an instance of MAAO project, we recommand to you to :
- have an MySQL Server up to date (like Wamp, Xamp or Lamp)
- have Eclipse up to date (don't forget to have the JRE or JDK like the JavaSE-1.8)

- Launch your Eclipse
- Launch your MySQL Server
- It is necessary to have your database on the localhost with an id : root and without password. 
If you have other parameters you need to update information on controler/ConnectionBDD
- Execute these request on your database for create the database:

> --------------
> DROP DATABASE `maao`;
> CREATE DATABASE `maao`;
> DROP TABLE IF EXISTS `maao`.`stair`;

> CREATE TABLE IF NOT EXISTS `maao`.`stair` (
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

> INSERT INTO `maao`.`stair` (`stair_name`) VALUES
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
- Write id : user and for password : password123
- you can also launch at two times the Stair configuration Window.

## Add an element
- Write a name
- Click and add

## Update an element
- select a line on the table
- click on modify
- A new form is vivible with the value to modify.
- Modify the name
- Click on submit

## Delete an element
- select a line on the table
- click on delete  

# Source
The source is composed in 3 packages :
- controler
	- DAO
	- DAOStair
	- ConnectionBDD
	- DataSource
	- JDBCConnectionPool
	- ReadFichier
- model
	- Stair
- view
	- Window
	- WindowStair

# Contact Information
For contact us, please contact use by e-mail at : 
> ansary.marecar@etu.u-pec.fr (for external communication)
> amine.maza@etu.u-pec.fr ()
> melissa.oussadi@etu.u-pec.fr
> oussama.bouachrine@etu.u-pec.fr
>

