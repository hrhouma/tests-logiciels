# Projet Calculatrice MAVENisé

### Étape 1: Installer Maven

Assurez-vous que Maven est installé sur votre système. Vous pouvez vérifier cela en exécutant:

```bash
mvn -v
```

Si Maven n'est pas installé, vous devrez le télécharger et l'installer. Suivez les instructions sur le [site officiel de Maven](https://maven.apache.org/install.html).

### Étape 2: Générer le squelette de projet Maven

Utilisez le `maven-archetype-quickstart` pour générer une structure de projet de base:

```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=calculatrice -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Changez `com.example` avec le nom de groupe que vous souhaitez utiliser et `calculatrice` avec le nom de l'artefact pour votre projet.

### Étape 3: Structure du projet

Maven va créer une structure de dossier standard pour votre projet:

```
calculatrice
│   pom.xml
└───src
    ├───main
    │   └───java
    │       └───com
    │           └───example
    │                   App.java
    └───test
        └───java
            └───com
                └───example
                        AppTest.java
```

### Étape 4: Écrire la logique de la Calculatrice

Modifiez le fichier `App.java` pour créer une classe de calculatrice simple. Voici un exemple de ce que cela pourrait ressembler:

```java
package com.example;

public class Calculatrice {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
```

### Étape 5: Écrire les Tests Unitaires

Modifiez le fichier `AppTest.java` pour ajouter des tests unitaires à votre calculatrice. Vous utiliserez JUnit, qui est inclus par défaut dans le `maven-archetype-quickstart`.

```java
package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import org.junit.Test;

public class CalculatriceTest {

    private Calculatrice calculatrice;

    @Before
    public void setUp() {
        calculatrice = new Calculatrice();
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculatrice.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, calculatrice.subtract(2, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculatrice.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculatrice.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculatrice.divide(1, 0);
        });
    }
}
```
### Étape 6: Ajouter des Dépendances junit4 + build java 17

Si vous souhaitez ajouter des dépendances externes pour étendre les fonctionnalités de votre calculatrice, vous pouvez les ajouter dans le fichier `pom.xml`. Par exemple, pour ajouter une bibliothèque de mathématiques, vous pourriez faire:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.example</groupId>
    <artifactId>calculatrice</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    
    <name>calculatrice</name>
    <url>http://maven.apache.org</url>
    
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <release>17</release>
                </configuration>
            </plugin>
        </plugins>
    </build>
 
</project>
```

### Étape 7: Construire et Tester le Projet

Construisez et testez votre projet avec Maven en utilisant la commande suivante à la racine du projet:

```bash
mvn clean install
```

Cette commande va nettoyer le projet (supprimer le répertoire `target`), exécuter les tests, et construire le projet.

### Étape 8: Complexité Progressive

Une fois que vous avez une application de calculatrice de base avec des tests, vous pouvez augmenter la complexité en ajoutant :

- Gestion des exceptions et validation des entrées.
- Fonctions scientifiques comme les racines carrées, les exponentielles, etc.
- Interface utilisateur en ligne de commande pour interagir avec la calculatrice.
- Interface graphique en utilisant Swing ou JavaFX.
- Journalisation avec Log4j ou SLF4J pour enregistrer les opérations et les erreurs.
- Utilisation de bibliothèques mathématiques externes pour étendre les fonctionnalités.
- Configuration des profils Maven pour différents environnements de déploiement.
- Intégration avec des systèmes de build et d'intégration continue comme Jenkins.

### Étape 9: Ajouter des Dépendances Complexes

Si vous souhaitez ajouter des dépendances externes pour étendre les fonctionnalités de votre calculatrice, vous pouvez les ajouter dans le fichier `pom.xml`. Par exemple, pour ajouter une bibliothèque de mathématiques, vous pourriez faire:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.example</groupId>
    <artifactId>calculatrice</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    
    <name>calculatrice</name>
    <url>http://maven.apache.org</url>
    
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <release>17</release>
                </configuration>
            </plugin>
        </plugins>
    </build>
 
</project>
```
