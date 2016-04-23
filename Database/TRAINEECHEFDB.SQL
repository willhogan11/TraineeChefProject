DROP SCHEMA IF EXISTS TRAINEECHEFDB;

CREATE DATABASE TRAINEECHEFDB;
USE TRAINEECHEFDB;


	-- Create Chef table
	CREATE TABLE CHEF
	(
		CHEF_ID INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT, 
		F_NAME VARCHAR(20) NOT NULL, 
		SURNAME VARCHAR(50) NOT NULL
	);

	-- Create the Food type table that will contain part of each meal structure, ie Starter
	CREATE TABLE FOOD_TYPE
	(
		FOOD_TYPE_ID INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
		TYPE_NAME VARCHAR(35) NOT NULL
	);

	-- Create the FOOD_ORIGIN table, that contains the recipes origin
	CREATE TABLE FOOD_ORIGIN
	(
		FOOD_ORIGIN_ID INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT, 
		ORIGIN VARCHAR(50) NOT NULL
	);

	-- Create the recipe table
	CREATE TABLE recipe (
		RECIPE_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
		NAME varchar(80) NOT NULL,
		DESCRIPTION text NOT NULL,
		PREP_TIME_HOURS int(11) NOT NULL,
		PREP_TIME_MINS int(11) NOT NULL,
		INGREDIENTS text NOT NULL,
		DIRECTIONS text NOT NULL,
		IMAGE longblob,
		CHEF_ID int(10) unsigned NOT NULL,
		FOOD_TYPE_ID int(10) unsigned NOT NULL,
		FOOD_ORIGIN_ID int(10) unsigned NOT NULL,
		PRIMARY KEY (RECIPE_ID),
		KEY CHEF_ID (CHEF_ID),
		KEY FOOD_TYPE_ID (FOOD_TYPE_ID),
		KEY FOOD_ORIGIN_ID (FOOD_ORIGIN_ID),
		CONSTRAINT recipe_ibfk_1 FOREIGN KEY (CHEF_ID) REFERENCES chef (CHEF_ID) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT recipe_ibfk_2 FOREIGN KEY (FOOD_TYPE_ID) REFERENCES food_type (FOOD_TYPE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT recipe_ibfk_3 FOREIGN KEY (FOOD_ORIGIN_ID) REFERENCES food_origin (FOOD_ORIGIN_ID) ON DELETE CASCADE ON UPDATE CASCADE
	);

	-- Create the ingredients table
	CREATE TABLE INGREDIENTS
	(
		INGRED_ID INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT, 
		NAME VARCHAR(50) NOT NULL
	);


	-- Junction Table to facilitate the many to many issue, between Recipe and Ingredients tables
	CREATE TABLE RECIPE_INGREDIENTS
	(
		RECIPE_ID INT UNSIGNED NOT NULL, 
		INGRED_ID INT UNSIGNED NOT NULL, 
		PRIMARY KEY(RECIPE_ID, INGRED_ID), 
		FOREIGN KEY (RECIPE_ID) REFERENCES RECIPE(RECIPE_ID)
			ON DELETE CASCADE
			ON UPDATE CASCADE, 
		FOREIGN KEY (INGRED_ID) REFERENCES INGREDIENTS(INGRED_ID)
			ON DELETE CASCADE
			ON UPDATE CASCADE
	);



	INSERT INTO FOOD_ORIGIN
		(ORIGIN)
	VALUES
		("Mixed"),("Global"),("Eastern European"),("Western European"),("Scandinavian"),
		("North African"),("South African"),("Central African"),("Middle Eastern"),("Asian"),
		("Italian"),("Chinese"),("Cantonese"),("Japanese"),("Greek"),("Indonesian"),("Thai"),("English"), ("Dutch"),
		("French"),("German"),("Spanish"),("Portuguese"),("Mexican"),("Polish"),("Russian"),("Brazilian"),("Indian"),
		("Central American"),("South American"),("Irish"),("Scottish"),("Welsh"),("Morrocan"),("Turkish"),("Not Known"); 


	INSERT INTO FOOD_TYPE
		(TYPE_NAME)
	VALUES
		("General"),("Starter"),("Main"),("Salad"),("Dessert"), ("Soups"), ("AntiPasta"), ("Pasta");


	-- Test Chef Inserts
	INSERT INTO CHEF
		(F_NAME, SURNAME)
	VALUES
		("Will", "Hogan"),
		("Mike", "Kelly"),
		("John", "Rabbitte"),
		("Gerry", "Mahony"),
		("Michelle", "Doherty");


	INSERT INTO INGREDIENTS
		(NAME)
	VALUES
		("Salt"),("Sugar"),("Black Pepper"), ("Butter"), ("White Pepper"),("5 Spice"),("Eggs"),("Milk"),("Yeast"),("Flour"),("Baking Soda"),("Cheese"),("Tomatoes"); 


	-- Test recipes
	INSERT INTO RECIPE
		(NAME, DESCRIPTION, PREP_TIME_HOURS, PREP_TIME_MINS, INGREDIENTS, DIRECTIONS, IMAGE, CHEF_ID, FOOD_TYPE_ID, FOOD_ORIGIN_ID)
	VALUES
		("Spanish Omellette", "This is a fantastic Spanish dish that has wonderful textures.......", 1, 20, "3 Eggs, 200gs Flour, 200ml milk......", "Beat eggs together with ingredients.........", "C:/Users/william/Desktop", 1, 2, 22), 
		("Spaghetti Bolognese", "A great italian Classic Dish that brings together the best of........", 0, 45, "500g Mince, 200g Spaghetti......", "Boil Pasta, Cut and Fry vegetables, Fry mince..........", "C:/Users/william/Desktop", 2, 3, 11), 
		("Tomato Soup", "A lovely winter warmer that makes..........", 0, 20, "8 Plum Tomatoes, Salt, Pepper, Cream........", "Blitz Tomatoes in a blender, add cream...........", "C:/Users/william/Desktop", 3, 2, 2);
