# api
TRAVAUX PRATIQUES SUR LES API SPRING BOOT
Etudiants GLSI A & B
Date de validation : 03/04/2023
Indication : le travail va se faire suivant les groupes formés pour l’exposé d’Intégration des SI. Chaque groupe créera un compte Github et enverra son travail sur ce dépôt. Le nom du compte sera libellé comme suit : TP_ISI_GLSI(A ou B)GROUPE_NuméroGroupe_2023. Afin d’évaluer la participation effective de tous les membres du groupe, une vérification sera faite par rapport aux différents commit réalisés par ces derniers. L’exposé ainsi que ce TP seront validés le même jour à la même heure. La note du devoir sera la moyenne des deux notes.
Enoncé
La société bancaire « Ega » voudrait mettre en place un système de gestion de ses clients et des comptes que ces derniers possèdent. Un client peut avoir plusieurs comptes. 
La banque met à disposition des clients deux types de comptes : un compte épargne et un compte courant. 
Un compte est caractérisé par le numéro de compte, le type de compte, la date de création du compte, le solde du compte et le propriétaire du compte. 
Pour le client on retiendra les informations suivantes : nom, prénom, date de naissance, sexe, adresse, numéro de téléphone, courriel et nationalité. 
Le numéro de compte est un ensemble de 5 caractères majuscules alphanumériques générés aléatoirement auquel on concatène l’année de création du compte. 
Le numéro de compte est unique pour un compte. 
Lors de la création du compte son solde est nul. 
TAF : 
1.	Mettre en place une API CRUD pour gérer les comptes et les clients.
2.	Ajouter les possibilités pour le client de : 
a.	Faire un versement sur son compte ;
b.	Faire un retrait sur son compte si le solde le permet ;
c.	Faire un virement d’un compte à un autre
