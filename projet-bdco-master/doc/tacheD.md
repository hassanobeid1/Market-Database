# Tache D : analyse des accès à la base de données

##liste catégories
```SELECT DISTINCT nomCat FROM categories MINUS SELECT nomCat FROM FilleDe ```

```SELECT DISTINCT nomCat FROM FilleDe Where NomCatMere = $cat```
##Liste articles

###Création de la vue des produits avec leur offre
```CREATE VIEW EtatOffre AS
SELECT P.idProduit,
       Count(idOffre) AS nboffre
FROM Produit P
LEFT OUTER JOIN Offre O ON O.idProduit = P.idProduit
GROUP BY P.idProduit;```


###Liste de tous les articles en vente
```SELECT * FROM etatoffre
MINUS
SELECT * FROM etatoffre WHERE nboffre=5;```

```SELECT idProduit FROM produit WHERE nomCat = $film```

###Liste article par catégories
```SELECT * FROM produit
INNER JOIN etatoffre ON produit.idproduit = etatoffre.idproduit
WHERE etatoffre.nboffre<5 AND produit.nomcat=$nomCat;```

##authentification

```SELECT mdp FROM client WHERE email=$mail```

##consulter un article

``` SELECT intitule, prixCourant, descP, URL FROM Produit WHERE idProduit=$id```
##poser une enchère
```SELECT COUNT(*) FROM offre WHERE IdProduit = $id```
```SELECT prixPropose FROM offre WHERE IdProduit = $id```
```INSERT INTO offre(*) VALUES ($id, $date, $prix,$produit,$mail)```

##recommandations client


###requête affichant les catégories triées par nombre d'offre non conclue par une vente pour un utilisateur donné
```SELECT
    produit.nomcat, COUNT(produit.nomcat)
FROM offre INNER JOIN etatoffre ON offre.idproduit = etatoffre.idproduit
INNER JOIN Produit ON offre.idproduit=produit.idproduit
WHERE offre.email=$mail AND etatoffre.nboffre<5
GROUP BY produit.nomcat;```

##recommandations générales

###requête affichant les catégories triées par nombre d'offre pour tous les utilisateurs

```SELECT
    produit.nomcat, COUNT(produit.nomcat)
FROM offre INNER JOIN produit ON produit.idproduit = offre.idproduit
GROUP BY produit.nomcat;```
