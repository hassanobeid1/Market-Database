/*INSERT ALL
    INTO Categorie (NomCat) VALUES ('Film')
    INTO Categorie (NomCat) VALUES ('Livre')
    INTO Categorie (NomCat) VALUES ('Jeu')
    INTO Categorie (NomCat) VALUES ('Musique')
    INTO Categorie (NomCat) VALUES ('Bande dessinee')
SELECT * FROM dual;
*/
INSERT ALL
    INTO Client (Email, Mdp, Nom, Prenom, DateNaissance, AddrPostale) VALUES ('jean.dupont@g.internet.com','jeand','Dupont','Jean',TO_DATE('1960-05-25_00:00:00','yyyy-mm-dd_hh24:mi:ss'),'12 Rue des pruneaux 38000 Grenoble')
    INTO Client (Email, Mdp, Nom, Prenom, DateNaissance, AddrPostale) VALUES ('jeanette.dupond@g.internet.com','jeanetted','Dupond','Jeanette',TO_DATE('1962-03-20_00:00:00','yyyy-mm-dd_hh24:mi:ss'),'12 Rue des pruneaux 38000 Grenoble')
SELECT * FROM dual;
    
--INSERT INTO FilleDe (NomCat, NomCatMere) VALUES ('Bande dessinee','Livre');

--ALTER TABLE caracteristiques
--    MODIFY valeur varchar2(50);

/*
INSERT ALL
    INTO Produit (idProduit, intitule, prixCourant, descp, url, nomcat) VALUES (1,'Tintin au Tibet',11.5,'Un avion de ligne à bord duquel le jeune Chinois Tchang se rendait en Europe s`est écrasé dans l`Himalaya','https://images-na.ssl-images-amazon.com/images/I/51uZrJMUaIL._SX348_BO1,204,203,200_.jpg','Bande dessinee')
    INTO Produit (idProduit, intitule, prixCourant, descp, url, nomcat) VALUES (2,'Les Miserables',5,'L`avenir arrivera-t-il ? il semble qu`on peut presque se faire cette question quand on voit tant d`ombre terrible. Sombre face-à-face des égoïstes et des misérables.','https://images.epagine.fr/100/9782075128100_1_75.jpg','Livre')
    INTO Produit (idProduit, intitule, prixCourant, descp, url, nomcat) VALUES (3,'Expandables 3',9.99,'Barney, Christmas et le reste de l`équipe affrontent Conrad Stonebanks, qui fut autrefois le fondateur des Expendables avec Barney. Stonebanks devint par la suite un redoutable trafiquant darmes, que Barney fut obligé d`abattre... Du moins, cest ce qu`il croyait. Les Expendables vont livrer leur bataille la plus explosive et la plus personnelle...','https://fr.web.img3.acsta.net/pictures/14/07/10/11/30/285929.jpg','Film')
SELECT * FROM dual;
      

INSERT ALL
    INTO Caracteristiques (idproduit, nomcara, valeur) VALUES (1,'Auteur','Herge')
    INTO Caracteristiques (idproduit, nomcara, valeur) VALUES (1,'Editeur','Casterman')
SELECT * FROM dual;
*/
    
INSERT ALL
    INTO Offre VALUES (1,TO_DATE('2021-04-16_22:21:20','yyyy-mm-dd_hh24:mi:ss'),11.5,1,'jean.dupont@g.internet.com')
    INTO Offre VALUES (2,TO_DATE('2021-05-16_15:31:21','yyyy-mm-dd_hh24:mi:ss'),11.75,1,'jeanette.dupond@g.internet.com')
SELECT * FROM dual;