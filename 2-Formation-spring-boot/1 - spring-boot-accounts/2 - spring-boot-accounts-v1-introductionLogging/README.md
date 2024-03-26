# Configuration de Logging avec Logback dans Spring Boot
Nous expliquons la configuration du logging dans une application JAVA. 

# Il y a 2 méthodes pour travailler avec le logging 
1. Ajout du logging dans applications.properties (Méthode #1) 
2. Ajout d'un fichier `logback.xml` ou `logback-spring.xml` dans le dossier Ressources. Dans ce cas, on ne met rien dans applications.properties (Méthode #2) 

# Méthode 1 - Ajout du Logging dans applications.properties (Ce projet)
> [!CAUTION]
> Assurez vous de ne pas avoir aucun des deux fichiers `logback.xml` ou `logback-spring.xml` dans cas. **Au pire, renommez les !!!**

```
# DataSource Configuration
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/microDemo1
spring.datasource.username=hrgres
spring.datasource.password=hrgres
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server Configuration
server.port=8080

# Niveaux de logging
logging.level.root=WARN
logging.level.com.eazybytes=DEBUG
logging.level.org.springframework.web=INFO
# Emplacement et nom du fichier de log
logging.file.path=logs
logging.file.name=app.log
# Format de sortie pour la console
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
```

# Méthode 2 - Ajout du Logging dans applications.properties (Prochain dossier v2 - advancedLogging)
> [!CAUTION]
> Assurez vous d'avoir soit `logback.xml` ou `logback-spring.xml` et de ne rien mettre dans  **applications.properties** en relation avec le logging !!!


# Différence entre `logback.xml` et `logback-spring.xml`.

## Introduction
- Nous expliquons l'utilisation de `logback.xml` et `logback-spring.xml` dans les projets Spring Boot !
- Logback est un framework de journalisation largement utilisé dans la communauté Java, offrant des performances élevées et une grande flexibilité.
- Spring Boot le supporte nativement, simplifiant ainsi la configuration de la journalisation dans vos applications.

# Différence entre `logback.xml` et `logback-spring.xml`

- **`logback.xml`**: 
    - Utilisé par Logback comme fichier de configuration standard.
    - Chargé tôt dans le cycle de démarrage de l'application.
    - Ne permet pas l'utilisation directe des fonctionnalités spécifiques à Spring Boot dans la configuration.

- **`logback-spring.xml`**: 
    - Recommandé pour les applications Spring Boot.
    - Permet l'intégration avec les fonctionnalités de Spring Boot, telles que les profils et les propriétés d'environnement.

# Quand utiliser `logback-spring.xml`?

Utilisez `logback-spring.xml` pour bénéficier pleinement des fonctionnalités de Spring Boot, notamment :

- **Conditionnement basé sur les profils Spring**:
    Vous pouvez activer ou désactiver certaines configurations de log basées sur le profil actif de Spring, ce qui est particulièrement utile pour différencier les configurations de dev, test et prod.

    ```xml
    <springProfile name="development">
        <!-- Configuration spécifique au développement -->
    </springProfile>
    <springProfile name="!development">
        <!-- Configuration pour les autres environnements -->
    </springProfile>
    ```

- **Utilisation de propriétés d'environnement**:
    Intégrez les propriétés d'environnement dans votre configuration de journalisation, permettant une personnalisation et une flexibilité accrues.

    ```xml
    <property name="LOGS" value="${LOG_PATH:-logs}"/>
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>${LOGS}/app.log</file>
        <!-- Plus de configuration -->
    </appender>
    ```

## Conclusion

Choisir entre `logback.xml` et `logback-spring.xml` dépend de vos besoins spécifiques en matière de journalisation et de la manière dont vous souhaitez intégrer la configuration de la journalisation avec les fonctionnalités de Spring Boot. En règle générale, pour les applications Spring Boot, `logback-spring.xml` est le choix recommandé pour tirer pleinement parti de l'intégration avec Spring.

---

**Ressources supplémentaires**:
- [Logback Documentation](http://logback.qos.ch/documentation.html)
- [Spring Boot Logging](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.logging)

# Annexe #1 :  Explication du fichier applications.properties

```
# DataSource Configuration
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/microDemo1
spring.datasource.username=hrgres
spring.datasource.password=hrgres
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server Configuration
server.port=8080


# Niveaux de logging
logging.level.root=WARN
logging.level.com.eazybytes=DEBUG
logging.level.org.springframework.web=INFO
# Emplacement et nom du fichier de log
logging.file.path=logs
logging.file.name=app.log
# Format de sortie pour la console
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
```

La configuration ci-dessus est un exemple de fichier de configuration pour une application Spring Boot, utilisée pour connecter une base de données PostgreSQL, configurer le serveur et les niveaux de logging. Cette configuration est souvent placée dans un fichier `application.properties` ou `application.yml` dans les ressources de l'application. Elle permet de définir comment l'application doit se comporter en termes de persistance des données, de fonctionnement du serveur, et de gestion des logs.

### DataSource Configuration

Ces propriétés configurent la source de données de l'application, ici une base de données PostgreSQL.

- `spring.datasource.driverClassName=org.postgresql.Driver` : Spécifie le nom de classe complet du driver JDBC de PostgreSQL. Ce driver permet à l'application de communiquer avec la base de données PostgreSQL.

- `spring.datasource.url=jdbc:postgresql://localhost:5432/microDemo1` : L'URL de connexion à la base de données. Cette URL suit le format JDBC standard pour PostgreSQL. Elle spécifie que la base de données (`microDemo1`) se trouve sur `localhost` (la machine locale) et écoute sur le port `5432`, qui est le port par défaut pour PostgreSQL.

- `spring.datasource.username=hrgres` et `spring.datasource.password=hrgres` : Les credentials utilisés pour s'authentifier auprès de la base de données. Ils doivent correspondre à un utilisateur existant dans votre instance PostgreSQL.

- `spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect` : Définit le dialecte Hibernate à utiliser. Le dialecte permet à Hibernate, l'implémentation JPA utilisée par Spring Boot, de générer du SQL optimisé pour la version spécifique de la base de données utilisée, ici PostgreSQL.

- `spring.jpa.hibernate.ddl-auto=update` : Configure la stratégie de gestion du schéma de base de données. `update` signifie que Hibernate ajustera automatiquement le schéma existant pour correspondre aux entités mappées, sans effacer les données.

- `spring.jpa.show-sql=true` : Lorsque cette propriété est définie sur `true`, Hibernate affiche toutes les instructions SQL générées dans le journal de l'application. Utile pour le débogage et la compréhension de ce qui se passe "sous le capot".

### Server Configuration

- `server.port=8080` : Définit le port sur lequel le serveur Spring Boot sera démarré. Ici, l'application sera accessible via le port `8080`.

### Niveaux de logging

Ces propriétés permettent de configurer les niveaux de logging pour différents packages ou classes de l'application.

- `logging.level.root=WARN` : Le niveau de logging global est défini sur `WARN`, ce qui signifie que seuls les messages de niveau WARN ou plus critique (ERROR, FATAL) seront enregistrés pour toutes les classes qui n'ont pas un niveau spécifique configuré.

- `logging.level.com.eazybytes=DEBUG` : Pour les classes dans le package `com.eazybytes`, le niveau de logging est défini sur `DEBUG`. Cela signifie que tous les messages de niveau DEBUG, INFO, WARN, ERROR et FATAL seront loggés pour ces classes.

- `logging.level.org.springframework.web=INFO` : Pour les classes dans le package `org.springframework.web`, le niveau de logging est défini sur `INFO`, permettant de loguer les messages de niveau INFO et plus critique.

### Configuration du fichier de log

- `logging.file.path=logs` et `logging.file.name=app.log` : Ces propriétés définissent l'emplacement (`logs`) et le nom du fichier de log (`app.log`). Ainsi, les logs de l'application seront écrits dans le fichier `app.log` situé dans un répertoire `logs`.

- `logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n` : Définit le format des messages de log qui s'affichent dans la console. Ce format inclut la date et l'heure de l'événement, le nom du thread, le niveau de gravité du log, le nom du logger et le message lui-même.

# Exemple
Voici un exemple de message de log qui correspondrait au format spécifié par `logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n` :

```
2024-03-21 15:42:07 [main] INFO  com.eazybytes.controller.HomeController - Request received for home page
```

Décortiquons cet exemple pour voir comment il correspond au format défini :

- `%d{yyyy-MM-dd HH:mm:ss}` : La date et l'heure de l'événement de log, formatées en `année-mois-jour heure:minute:seconde`. Ici, `2024-03-21 15:42:07`.

- `[%thread]` : Le nom du thread d'où provient le log. Dans cet exemple, c'est le thread principal, donc `[main]`.

- `%-5level` : Le niveau de gravité du log, justifié à gauche sur 5 caractères. `INFO` est le niveau dans cet exemple, et il est suivi de quelques espaces pour garantir un alignement uniforme.

- `%logger{36}` : Le nom du logger qui a généré le message, tronqué ou complété pour tenir sur 36 caractères. Ici, `com.eazybytes.controller.HomeController` est le nom complet du logger. Si le nom avait été plus long, il aurait été tronqué à 36 caractères.

- `- %msg%n` : Le message de log lui-même, précédé d'un tiret pour le séparer du reste. Ici, le message est `Request received for home page`. `%n` représente un saut de ligne, garantissant que chaque message de log est bien sur une nouvelle ligne.

Ce format permet une lecture facile et structurée des logs, facilitant le débogage et le suivi des activités de l'application.
