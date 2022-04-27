--SELECT DISTINCT nomCat FROM categorie MINUS SELECT nomCat FROM FilleDe;
--SELECT DISTINCT nomCat FROM FilleDe Where NomCatMere = 'Livre';
--SELECT idProduit, COUNT(*) AS nbproduit FROM offre GROUP BY idProduit;

SELECT
    produit.nomcat, COUNT(produit.nomcat)
FROM offre INNER JOIN produit ON produit.idproduit = offre.idproduit
GROUP BY produit.nomcat;

/*
SELECT
    produit.nomcat, COUNT(produit.nomcat)
FROM offre INNER JOIN etatoffre ON offre.idproduit = etatoffre.idproduit
INNER JOIN Produit ON offre.idproduit=produit.idproduit
WHERE offre.email='jeanette.dupond@g.internet.com' AND etatoffre.nboffre<5
GROUP BY produit.nomcat;
*/

/*
SELECT * FROM produit
INNER JOIN etatoffre ON produit.idproduit = etatoffre.idproduit
WHERE etatoffre.nboffre<5 AND produit.nomcat='Bande dessinee';
*/

/*
SELECT * FROM etatoffre
MINUS
SELECT * FROM etatoffre WHERE nboffre=5;
*/
/*
SELECT mdp FROM client WHERE email='jean.dupont@g.internet.com';


SELECT intitule, prixCourant, descP, URL FROM Produit WHERE idProduit=1;

SELECT COUNT(*) FROM offre WHERE IdProduit=1;
*/

/*
CREATE VIEW EtatOffre AS
SELECT P.idProduit,
       Count(idOffre) AS nboffre
FROM Produit P
LEFT OUTER JOIN Offre O ON O.idProduit = P.idProduit
GROUP BY P.idProduit;
*/

