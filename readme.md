Comment déployer l'application OC.ESCALADE

Pour déployer l'application vous aurez besoin des logiciels suivants : 

Java, Apache Tomcat, Apache Maven, PostgreSQL

1/ Téléchargez et installez la version 8 de Java sur https://www.java.com/fr/download/
2/ Téléchargez et installez le JDK (Java Development Kit) Java SE 8u201 depuis le site d'Oracle
3/ Téléchargez et installez Apache Maven depuis le site https://maven.apache.org
4/ Téléchargez et installez le serveur Apache Tomcat depuis le site https://tomcat.apache.org
5/ Téléchargez et installez PostgreSQL. Installez également pgAdmin. C'est un outil graphique qui va vous permettre d'administrer PostgreSQL et lancer des scripts SQL. 

Vous devrez ensuite déployer la base de données :

Dans le dossier d'installation de PostgreSQL, lancez l'application pgAdmin4.

Pour commencer, vous devez établir une connexion à un nouveau serveur. Dans le menu, cliquez sur l'icone représentant une prise. Donnez un nom à cette connexion (ex: localhost_demo) et renseignez comme hôte "localhost"(adresse IP configuré dans le serveur PostgreSQL).
Pour le port, renseignez 5432. 

Vous devez ensuite créer un utilisateur. Cliquez sur "Role de connexion", clic droit -> Role de connexion. Renseignez un nom de rôle et dans l'onglet Définition vous devrez renseignez un mot de passe. 

Vous pouvez désormais créer la base de donnée. Faites un clic droit sur "Bases de données" --> ajouter une base de donnée. Renseignez un nom et le propriétaire (utilisateur crée à l'étape précédente) puis validez.

Déroulez la nouvelle base de données pour afficher son contenu. Faite un clic droit sur "public" puis dans la liste proposé sélectionnez "Create Script".

Retournez sur github, cliquez sur le bouton Clone or Download puis sur Download ZIP.

Dézipper le dossier et allez dans le dossier base_de_donnees.

Faites un clic droit sur le fichier "bdd_oc_escalade" et ouvez le avec un éditeur de texte. Copiez le contenu et collez le dans l'éditeur de pgAdmin et cliquez sur l'icône dans la barre de tâches qui ressemble à un éclair.

Maintenant que vous avez crée la base de donnée, il va falloir déployer l'application.

Retournez dans le dossier OC_ESCALADE, et ouvrez le dossier oc_escalade. Copiez le chemin qui pointe vers ce dossier.

Ouvez votre invite de commande, tapez la commande cd suivi du chemin copié à l'étape précédente. Faites entrer.

Entrez la commande mvn package afin d'empaqueter l'application.

Ouvrez ensuite le dossier target en suivant le chemin suivant : projet6-webapp\target et copiez le fichier projet6-webapp.war.

Rendez-vous dans le dossier apache-tomcat-9.0.16-windows-x64, ouvrez le dossier Webapps et coller le ficher projet6-webapp.rar à l'intérieur.

Pour lancer le serveur Tomcat, revenez dans le dossier précédent et ouvrez le dossier bin. Double cliquez sur le fichier startup.

Une invite de commande va s'ouvrir.

Ouvez votre navigateur et entrez l'URL suivante : https://localhost:8080/projet6-webapp/




