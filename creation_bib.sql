/*
Script de création de la base de donnée de la bibliothèque de l'IUT de Velizy
*/
DROP TABLE ETUDIANT;
DROP TABLE LIVRE;
DROP TABLE EXEMPLAIRE;
DROP TABLE EMPRUNT;
DROP TABLE RESERV;


CREATE TABLE ETUDIANT(
id_et INT PRIMARY KEY NOT NULL,
nom varchar(20) NOT NULL,
prenom varchar(20) NOT NULL,
mdp varchar(20) NOT NULL,
email varchar(30) NOT NULL);

CREATE TABLE LIVRE(
id_livre INT PRIMARY KEY NOT NULL,
auteur varchar(30),
titre varchar(30));

CREATE TABLE EXEMPLAIRE(
id_ex INT PRIMARY KEY NOT NULL,
id_livre INT REFERENCES LIVRE(id_livre));



CREATE TABLE EMPRUNT(
id_et INT REFERENCES ETUDIANT(id_et),
id_ex INT REFERENCES EXEMPLAIRE(id_ex),
date_emp DATE NOT NULL,
date_retour DATE NOT NULL);

CREATE TABLE RESERV (
id_livre INT REFERENCES LIVRE(id_livre),
id_et INT REFERENCES ETUDIANT(id_et),
date_res DATE NOT NULL,
date_fin_res DATE NOT NULL);