# Application Bancaire EazyBytes

Cette application Spring Boot est une démonstration simple d'un système de gestion de comptes bancaires et de clients.

## Fonctionnalités

L'application offre les fonctionnalités suivantes :

- **Gestion des comptes** : Création, consultation, mise à jour et suppression de comptes bancaires.
- **Gestion des clients** : Création, consultation, mise à jour et suppression de clients.
- **Opérations en vrac** : Prise en charge de la création et de la suppression en masse des comptes.

## Technologies Utilisées

- **Spring Boot** : Framework principal pour le développement de l'application.
- **Spring Data JPA** : Pour l'accès et la manipulation de la base de données.
- **Lombok** : Pour réduire le boilerplate code des modèles.
- **H2 Database** : Base de données en mémoire utilisée pour le développement et les tests.
- **Swagger/OpenAPI** : Documentation et test des endpoints API.

## Structure du Projet

Le projet est organisé en plusieurs packages principaux :

- `controller` : Contient les contrôleurs Spring MVC qui gèrent les requêtes HTTP.
- `model` : Définit les entités JPA représentant les tables de base de données.
- `repository` : Interfaces Spring Data pour l'accès aux données.
- `service` : La couche métier qui contient la logique d'application.
- `configuration` : Configuration de l'application et beans Spring.

## Configuration

L'application est configurée pour utiliser une base de données H2 en mémoire par défaut, avec la configuration suivante dans `application.properties` :

```properties
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## Démarrage de l'Application

Pour exécuter l'application, assurez-vous d'avoir Maven et Java 11 (ou plus récent) installés sur votre machine. Ensuite, exécutez la commande suivante à la racine du projet :

```bash
mvn spring-boot:run
```

L'application démarre sur `http://localhost:8080`.

## Documentation API

Une fois l'application démarrée, la documentation de l'API générée par Swagger est accessible à :

```
http://localhost:8080/swagger-ui.html
```
