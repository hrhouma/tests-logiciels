# LOGGING
```bash
git clone https://github.com/hrhouma/tests-unitaires-junit4.git
cd tests-unitaires-junit4/
cd 1-Formation-spring-boot/
cd '1 - spring-boot-accounts/'
cd spring-boot-accounts-v2-advancedLogging/
mvn clean install ou (mvn clean install -DskipTests)
mvn spring-boot:run 
```
# Questions
1. Est-il possible d'avoir un maxHistory de 1 heure ? de 5 minutes ?
2. C'est quoi les niveaux de gravité par ordre croissant ?
3. Pourquoi app.general.log contient-il tous les messages de logging ? Pourquoi app.error.log ne contient que les erreurs ? app.warn.log ne contient-il que les avertissements ?

# Réponses

Le fichier `logging.xml` configure Logback pour enregistrer des logs dans différents fichiers en fonction de leur niveau de gravité.

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <!-- General Log Appender -->
    <appender name="GENERAL_LOG_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>log/app.general.log</file> <!-- Modifié pour inclure le dossier log -->
        <encoder>
            <pattern>%date %level [%thread] %logger{10} [%file:%line] %msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>log/app.general.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
    </appender>

    <!-- WARN Log Appender -->
    <appender name="WARN_LOG_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>log/app.warn.log</file> <!-- Modifié pour inclure le dossier log -->
        <encoder>
            <pattern>%date %level [%thread] %logger{10} [%file:%line] %msg%n</pattern>
        </encoder>
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>WARN</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>log/app.warn.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
    </appender>

    <!-- ERROR Log Appender -->
    <appender name="ERROR_LOG_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>log/app.error.log</file> <!-- Modifié pour inclure le dossier log -->
        <encoder>
            <pattern>%date %level [%thread] %logger{10} [%file:%line] %msg%n</pattern>
        </encoder>
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>log/app.error.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
    </appender>

    <!-- Root Logger Configuration -->
    <root level="DEBUG">
        <appender-ref ref="GENERAL_LOG_FILE" />
        <appender-ref ref="WARN_LOG_FILE" />
        <appender-ref ref="ERROR_LOG_FILE" />
    </root>

</configuration>
```



### 1. Est-il possible d'avoir un `maxHistory` de 1 heure ou de 5 minutes ?

La propriété `maxHistory` dans la configuration de Logback détermine le nombre maximal de jours pendant lesquels les fichiers journaux sont conservés avant d'être supprimés. Elle ne permet pas de spécifier une durée en heures ou minutes directement. Si vous souhaitez gérer vos fichiers journaux sur une base horaire ou même plus fréquemment, vous devriez regarder du côté de la personnalisation de la politique de roulement (`RollingPolicy`) pour voir s'il y a des extensions ou des configurations personnalisées qui pourraient répondre à ce besoin. Cependant, par défaut, Logback et la plupart des systèmes de journalisation sont conçus pour gérer les rotations sur une base quotidienne ou plus longue, pas sur des périodes aussi courtes.

### 2. Quels sont les niveaux de gravité par ordre croissant ?

Les niveaux de gravité (ou niveaux de log) dans Logback et dans de nombreux systèmes de logging sont, par ordre croissant de gravité :

1. `TRACE` : Le niveau le plus détaillé, utilisé pour des informations extrêmement détaillées sur le fonctionnement d'une application.
2. `DEBUG` : Informations de débogage fine, utiles pour le développement et le dépannage.
3. `INFO` : Événements d'exécution réguliers, indiquant le bon fonctionnement de l'application.
4. `WARN` : Avertissements sur des événements potentiellement problématiques qui n'empêchent pas l'application de fonctionner.
5. `ERROR` : Erreurs qui affectent le fonctionnement de l'application mais ne l'arrêtent pas nécessairement.
6. `OFF` : Un niveau spécial qui désactive le logging.

### 3. Pourquoi `app.general.log` contient-il tous les messages de logging ? Pourquoi `app.error.log` ne contient que les erreurs ? `app.warn.log` ne contient-il que les avertissements ?

Dans notre configuration, trois appenders (sorties de log) sont définis pour capturer et enregistrer les logs à différents niveaux de gravité :

- **`GENERAL_LOG_FILE`** : Cet appender n'a pas de filtre défini, donc il capture et enregistre tous les messages loggés au niveau configuré dans le logger racine (`root`) et au-dessus. Puisque le niveau du logger racine est défini sur `DEBUG`, cet appender capturera `DEBUG` et tous les niveaux de gravité plus élevés (`INFO`, `WARN`, `ERROR`).

- **`WARN_LOG_FILE`** et **`ERROR_LOG_FILE`** : Ces appenders utilisent des filtres pour capturer uniquement les messages de log de niveaux spécifiques (`WARN` pour le premier, `ERROR` pour le second). Le filtre `LevelFilter` est configuré avec `onMatch=ACCEPT` pour le niveau spécifié et `onMismatch=DENY` pour tous les autres niveaux. Cela signifie que `app.warn.log` enregistrera uniquement les messages de niveau `WARN`, et `app.error.log` enregistrera uniquement les messages de niveau `ERROR`.

Notre configuration démontre une utilisation typique des niveaux de log et des filtres pour séparer les logs en fonction de leur gravité, facilitant ainsi la surveillance et le débogage de l'application.

