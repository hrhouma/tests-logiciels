# Choix 2 - Énoncé du Laboratoire: Gestion des Utilisateurs avec JDBC et JUnit

**Objectif du Laboratoire:** Ce laboratoire vise à renforcer vos compétences en Java, spécifiquement dans la manipulation de bases de données avec JDBC (Java Database Connectivity) les tests unitaires avec JUnit. Les étudiants seront chargés de développer, tester et améliorer une application de gestion des utilisateurs. Le fichier est dans le même dossier choix 2.

**Description du Projet:**
- Vous allez travailler sur une application Java simple pour la gestion des utilisateurs dans une base de données. 
- L'application permettra d'ajouter, de supprimer, de mettre à jour et de récupérer des utilisateurs depuis une base de données MySQL en utilisant JDBC. 
- Vous utiliserez JUnit pour écrire des tests unitaires afin de valider la logique de votre application.

**Partie 1: Configuration de l'Environnement**
1. **Base de données:** Utilisez le script SQL fourni pour créer votre base de données et la table `users`. Assurez-vous que MySQL est installé et configuré sur votre machine.
2. **Environnement de Développement:** Importez le projet dans votre IDE préféré (Eclipse, IntelliJ, etc.). Assurez-vous que les librairies JDBC et JUnit sont ajoutées à votre projet.

**Partie 2: Développement de l'Application**
1. **Implémentation de `UserDao`**: En vous basant sur le squelette de classe fourni, implémentez les méthodes pour interagir avec la base de données. Ceux-ci incluent `addUser`, `deleteUser`, `updateUser`, `getAllUsers`, et `getUserByUsername`.
2. **Gestion des Exceptions**: Améliorez la gestion des exceptions dans `UserDao` pour traiter de manière appropriée les erreurs de base de données.

**Partie 3: Tests Unitaires avec JUnit**
1. **Écriture des Tests**: Créez une classe de test `UserDaoTest` et écrivez des tests unitaires pour chaque méthode de `UserDao`. Assurez-vous de tester à la fois les cas de succès et les cas d'erreur.
2. **Isolation de la Base de Données**: Utilisez une base de données en mémoire (comme H2) pour vos tests unitaires ou gérez les transactions pour assurer l'isolation entre les tests.
3. **Mocking**: Explorez l'utilisation de mocks pour simuler les objets de connexion à la base de données, permettant de tester `UserDao` sans nécessiter une connexion réelle à la base de données.

**Partie 4: Améliorations et Refactoring**
1. **Refactoring**: Analysez et refactorisez votre code pour améliorer sa lisibilité, sa maintenabilité et ses performances.
2. **Gestion des Erreurs**: Implémentez une stratégie de gestion des erreurs plus robuste dans l'application, en utilisant des logs ou des exceptions personnalisées.

# Critères d'Évaluation:
- **Fonctionnalité (40%)**: L'application doit fonctionner comme spécifié, avec toutes les fonctionnalités implémentées correctement.
- **Tests Unitaires (30%)**: Les tests doivent couvrir tous les cas d'usage et passer avec succès.
- **Qualité du Code (20%)**: Le code doit être clair, bien organisé et suivre les bonnes pratiques de programmation Java.
- **Gestion des Erreurs (10%)**: L'application doit gérer les erreurs de manière élégante et informative.

**Livraison:**
Votre projet final doit être soumis sous forme d'archive contenant tous les fichiers source et les fichiers de test. Incluez également un fichier README avec des instructions sur la configuration de l'environnement, la manière d'exécuter l'application et les tests.

**Date Limite de Soumission:** Dernier jour du cours le 23 avril 2024.

Bonne chance et bon codage!

# Références : 
## lien 1 : 
https://drive.google.com/drive/folders/1aA2-6lXalJjOdYKY_i9upsWbb3ufT8l4?usp=sharing 
## lien 2 : 
https://drive.google.com/drive/folders/1PxIzi3MsCEZ-raf0zEOjSHQn_Fb88ftK?usp=sharing
## lien 3 : 
https://drive.google.com/drive/folders/1KUU1Xo2NihxGNOSxv9_MFhdQhKesVisv?usp=sharing

