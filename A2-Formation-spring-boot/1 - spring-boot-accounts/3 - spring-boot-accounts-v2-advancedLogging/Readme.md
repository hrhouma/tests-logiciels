# Fichier logback.xml ou logback-spring.xml à ajouter dans le dossier ressources
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

# Configuration de Logback Expliquée

Ce document détaille chaque élément de la configuration de Logback définie dans un fichier XML. Logback est un framework de logging populaire pour Java, offrant une flexibilité et des performances élevées. La configuration ci-dessous est structurée pour gérer différents niveaux de logs (DEBUG, INFO, WARN, ERROR) et les archiver quotidiennement.

## Structure Générale

Le fichier XML commence par la déclaration standard qui spécifie la version XML et l'encodage utilisé :

```xml
<?xml version="1.0" encoding="UTF-8"?>
```

Puis, la racine du document est `<configuration>`, contenant toute la configuration de Logback :

```xml
<configuration>
    ...
</configuration>
```

## Appenders

Les *appenders* sont des composants Logback qui prennent en charge la sortie des logs. Trois appenders sont configurés ici : `GENERAL_LOG_FILE`, `WARN_LOG_FILE`, et `ERROR_LOG_FILE`, chacun étant dédié à un type spécifique de logs.

### Appender GENERAL_LOG_FILE

Cet appender est destiné aux logs généraux de l'application :

```xml
<appender name="GENERAL_LOG_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
```

- `name` : Identifie l'appender.
- `class` : Spécifie la classe Java utilisée, ici un `RollingFileAppender` pour gérer l'archivage des logs.

#### File

```xml
<file>log/app.general.log</file>
```

Définit le fichier de log initial. Les logs seront écrits ici avant d'être archivés selon la politique de rotation.

#### Encoder

```xml
<encoder>
    <pattern>%date %level [%thread] %logger{10} [%file:%line] %msg%n</pattern>
</encoder>
```

Spécifie comment les logs doivent être formatés. Ce format inclut la date, le niveau de log, le thread, une version tronquée du nom du logger, le fichier et la ligne d'où provient le log, et le message du log.

#### RollingPolicy

```xml
<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
```

Définit la politique de rotation basée sur le temps. Les fichiers de logs sont archivés en fonction de l'heure et de la date.

- `fileNamePattern` : Le modèle de nom pour les fichiers archivés. Ici, ils sont nommés avec la date.
- `maxHistory` : Le nombre de jours de logs à conserver.

### Appender WARN_LOG_FILE et ERROR_LOG_FILE

Ces appenders sont configurés de manière similaire à `GENERAL_LOG_FILE` mais sont spécifiques aux logs de niveau WARN et ERROR, respectivement. Ils utilisent un filtre pour ne capturer que les logs de leur niveau spécifié :

```xml
<filter class="ch.qos.logback.classic.filter.LevelFilter">
    <level>WARN</level> <!-- Ou ERROR pour l'appender ERROR_LOG_FILE -->
    <onMatch>ACCEPT</onMatch>
    <onMismatch>DENY</onMismatch>
</filter>
```

`<level>` définit le niveau de log à capturer. `<onMatch>` et `<onMismatch>` déterminent l'action à prendre lorsque le log correspond ou ne correspond pas au niveau spécifié.

## Configuration du Root Logger

```xml
<root level="DEBUG">
```

Définit le niveau de log global de l'application. Ici, il est réglé sur DEBUG, ce qui signifie que tous les logs de niveau DEBUG et plus sévère seront traités.

### Appender-refs

```xml
<appender-ref ref="GENERAL_LOG_FILE" />
<appender-ref ref="WARN_LOG_FILE" />
<appender-ref ref="ERROR_LOG_FILE" />
```

Ces lignes associent les appenders configurés précédemment au root logger, permettant ainsi de diriger les logs vers les fichiers appropriés.

Cette configuration de Logback fournit un système de logging robuste et flexible, avec une séparation claire des logs par niveau de sévérité et une gestion automatique de l'archivage des logs.
