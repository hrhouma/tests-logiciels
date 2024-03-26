# Guide Théorique sur JUnit 5

Ce document sert de guide d'introduction à JUnit 5, la dernière génération du framework de test unitaire le plus populaire pour les applications Java. JUnit 5 apporte de nombreuses améliorations et nouveautés par rapport à ses prédécesseurs, notamment en termes de modélisation des tests, d'assertions et d'annotations.

## Qu'est-ce que JUnit 5?

JUnit 5 représente la prochaine génération de framework pour l'écriture de tests automatisés en Java. Contrairement à JUnit 4, JUnit 5 est composé de plusieurs modules issus de trois sous-projets principaux :

- **JUnit Platform** : Permet de lancer les tests sur la JVM et définit les API pour développer des frameworks de tests.
- **JUnit Jupiter** : Fournit les API pour l'écriture de tests et extensions en JUnit 5.
- **JUnit Vintage** : Support pour exécuter les tests JUnit 3 et 4 sur la plateforme JUnit 5.

## Prérequis

- Java 8 ou supérieur est requis pour utiliser JUnit 5 en raison de ses dépendances sur les expressions lambda et l'API Stream de Java.
- Un environnement de développement intégré (IDE) qui supporte JUnit 5, tel que IntelliJ IDEA, Eclipse, ou NetBeans.
- Un système de build compatible, comme Maven ou Gradle, configuré dans votre projet.

## Nouveautés de JUnit 5

### Annotations

JUnit 5 introduit plusieurs nouvelles annotations qui simplifient l'écriture des tests :

- `@Test` : Déclare une méthode comme méthode de test.
- `@BeforeEach` / `@AfterEach` : Indique que la méthode annotée doit être exécutée avant ou après chaque méthode de test.
- `@BeforeAll` / `@AfterAll` : Indique que la méthode annotée doit être exécutée une seule fois avant ou après toutes les méthodes de test dans la classe courante.
- `@DisplayName` : Permet de définir un nom personnalisé pour l'affichage des tests.
- `@Nested` : Permet de créer des classes de tests imbriquées pour une meilleure organisation des cas de test.
- `@Tag` : Permet de filtrer les tests à exécuter en fonction de tags.
- `@Disabled` : Permet de désactiver une méthode de test ou une classe de test.

### Assertions

JUnit 5 enrichit les possibilités d'assertion avec de nouvelles méthodes dans la classe `Assertions` :

- `assertEquals`, `assertNotEquals` : Vérifie l'égalité ou la non-égalité.
- `assertTrue`, `assertFalse` : Vérifie qu'une condition est vraie ou fausse.
- `assertNull`, `assertNotNull` : Vérifie qu'un objet est `null` ou non-`null`.
- `assertThrows` : Vérifie qu'une exécution de code lève une exception spécifique.
- `assertAll` : Permet d'exécuter un groupe d'assertions de manière conjointe.

### Assumptions

Les suppositions (`Assumptions`) sont une fonctionnalité permettant de ne faire exécuter un test que si certaines conditions sont remplies :

- `assumeTrue`, `assumeFalse` : Permet d'ignorer un test si la condition n'est pas vraie ou est fausse.
- `assumingThat` : Exécute une partie de code seulement si l'assomption est vraie.

### Tests Paramétrés

JUnit 5 introduit les tests paramétrés, permettant d'exécuter le même test avec différents paramètres :

- Utilisez `@ParameterizedTest` avec diverses sources comme `@ValueSource`, `@CsvSource`, `@MethodSource` pour fournir les valeurs des paramètres.

### Extensions

JUnit 5 permet de créer des extensions personnalisées pour enrichir ou modifier le comportement d'exécution des tests grâce à l'API d'extension.

## Configuration avec Maven

Pour utiliser JUnit 5 avec Maven, ajoutez la dépendance suivante dans votre `pom.xml` :

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.7.0</version>
    <scope>test</scope>
</dependency>
```

Et assurez-vous que Maven utilise le bon plugin pour exécuter les tests :

```xml
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <includes>
            <include>**/*.java</include>
        </includes>
    </configuration>
</plugin>
```

## Configuration avec Gradle

Pour configurer JUnit 5 avec Gradle, assurez-vous d'ajouter la dépendance suivante dans le bloc `dependencies` de votre fichier `build.gradle` :

```groovy
testImplementation('org.junit.jupiter:junit-jupiter-api:5.7.0')
testRuntimeOnly('org.junit.jupiter:junit-jupiter-engine:5.7.0')
```

Et configurez le plugin `test` pour utiliser JUnit Platform :

```groovy
test {
    useJUnitPlatform()
}
```

## Conseils Pratiques

- **Utilisez `@DisplayName` pour améliorer la lisibilité des résultats des tests** : Les noms des méthodes de test ne permettent pas toujours de comprendre immédiatement le but d'un test. L'annotation `@DisplayName` permet de définir un nom explicite qui sera affiché lors de l'exécution des tests.
- **Regroupez les assertions liées avec `assertAll`** : Cette pratique permet de s'assurer que tous les assertions d'un bloc sont évaluées, fournissant une vue complète des échecs d'assertion pour un test donné.
- **Exploitez les tests paramétrés pour éviter les duplications** : Au lieu d'écrire plusieurs tests qui se ressemblent mais qui diffèrent seulement par les valeurs utilisées, les tests paramétrés permettent de centraliser la logique de test et de la tester avec différents jeux de données.
- **Utilisez des extensions pour étendre les capacités de JUnit** : Que ce soit pour ajouter un comportement avant ou après l'exécution des tests, gérer des ressources, ou injecter des dépendances personnalisées, les extensions offrent un moyen puissant de personnaliser le cycle de vie des tests.

## Ressources pour Aller Plus Loin

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/) : La documentation officielle de JUnit 5 est l'endroit idéal pour approfondir votre compréhension du framework.
- [Baeldung on JUnit 5](https://www.baeldung.com/junit-5) : Baeldung propose une série de tutoriels bien écrits sur différentes fonctionnalités de JUnit 5.
- [Spring Framework Testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing) : Découvrez comment Spring supporte les tests, y compris l'intégration avec JUnit 5.

JUnit 5 marque une avancée significative par rapport à JUnit 4, offrant plus de flexibilité, de nouvelles fonctionnalités, et une meilleure intégration avec les environnements de développement modernes. En adoptant JUnit 5, vous pouvez améliorer la qualité de vos tests et, par conséquent, de votre code.