# Guide Détaillé de Test avec JUnit 5 pour le Projet Spring Boot "Accounts"

Ce document est un guide complet destiné à aider les étudiants à comprendre et à implémenter des tests unitaires et d'intégration dans le projet Spring Boot "Accounts" en utilisant JUnit 5. Ce guide couvre tout, de la configuration initiale à des exemples de tests détaillés pour les différentes couches de l'application.

## Sommaire

- [Prérequis](#prérequis)
- [Configuration de Test](#configuration-de-test)
  - [Mise à Jour des Dépendances](#mise-à-jour-des-dépendances)
- [Principes de Test avec JUnit 5](#principes-de-test-avec-junit-5)
- [Écriture de Tests](#écriture-de-tests)
  - [Tests des Contrôleurs](#tests-des-contrôleurs)
  - [Tests des Services](#tests-des-services)
  - [Tests des Repositories](#tests-des-repositories)
- [Exécution des Tests](#exécution-des-tests)
- [Ressources Complémentaires](#ressources-complémentaires)
- [FAQ](#faq)

## Prérequis

- JDK 1.8 ou supérieur
- Maven ou Gradle configuré dans votre projet
- Connaissance de base de Spring Boot et JUnit

## Configuration de Test

### Mise à Jour des Dépendances

Pour utiliser JUnit 5, assurez-vous que votre fichier `pom.xml` inclut la bonne dépendance `spring-boot-starter-test` avec l'exclusion de JUnit 4 pour éviter tout conflit :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <version>VotreVersionDeSpringBoot</version>
    <scope>test</scope>
    <exclusions>
        <exclusion>
            <groupId>org.junit.vintage</groupId>
            <artifactId>junit-vintage-engine</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

Cette configuration assure que vous utilisez JUnit Jupiter (JUnit 5) pour vos tests.

## Principes de Test avec JUnit 5

JUnit 5 est structuré autour de plusieurs modules, dont JUnit Jupiter pour écrire des tests et JUnit Platform pour lancer les tests. Avec JUnit 5, vous bénéficiez de :

- Annotations améliorées (`@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`, `@Test`)
- Support pour l'exécution conditionnelle des tests
- Possibilité de définir des tags pour filtrer les tests à exécuter
- Support pour les tests paramétrés et les tests dynamiques

## Écriture de Tests

### Tests des Contrôleurs

Pour tester un contrôleur, utilisez `@WebMvcTest` et `MockMvc` pour simuler des requêtes HTTP :

```java
@WebMvcTest(AccountsController.class)
class AccountsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountsService service;

    @Test
    void shouldReturnAccountDetails() throws Exception {
        mockMvc.perform(get("/myAccount/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.accountNumber").value("1"));
    }
}
```

### Tests des Services

Utilisez `@ExtendWith(MockitoExtension.class)` pour injecter des mocks dans vos tests de service :

```java
@ExtendWith(MockitoExtension.class)
class AccountsServiceTest {

    @Mock
    private AccountsRepository repository;

    @InjectMocks
    private AccountsService service;

    @Test
    void shouldReturnAccountForGivenId() {
        when(repository.findById(1L)).thenReturn(Optional.of(new Accounts()));
        Accounts account = service.getAccountsById(1L);
        assertNotNull(account);
    }
}
```

### Tests des Repositories

`@DataJpaTest` fournit une configuration simplifiée pour les tests d'intégration de repository en utilisant une base de données en mémoire :

```java
@DataJpaTest
class AccountsRepositoryTest {

    @Autowired
    private AccountsRepository repository;

    @Test
    void shouldFindAccountByCustomerId() {
        Accounts savedAccount = repository.save(new Accounts(/* initialiser les champs requis */));
        Optional<Accounts> foundAccount = repository.findByCustomerId(savedAccount.getCustomerId());
        assertTrue(foundAccount.isPresent());
        assertEquals(savedAccount.getCustomerId(), foundAccount.get().getCustomerId());
    }
}
```

## Exécution des Tests

Pour lancer les tests, exécutez les commandes suivantes en fonction de votre gestionnaire de projet :

- **Pour Maven :**

  ```sh
  mvn test
  ```

  Cette commande va compiler votre projet et exécuter tous les tests présents dans le dossier `src/test/java`.

- **Pour Gradle :**

  ```sh
  ./gradlew test
  ```

  Semblable à Maven, cette commande compile le projet et exécute tous les tests. Les résultats des tests sont généralement disponibles dans `build/reports/tests/test/index.html` pour une consultation facile.

## Ressources Complémentaires

Pour approfondir votre compréhension et vos compétences en test avec JUnit 5 et Spring Boot, voici quelques ressources recommandées :

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/) : Le guide officiel de l'utilisateur JUnit 5.
- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/) : Guide de démarrage rapide de Spring pour le test des applications web.
- [Baeldung Testing Articles](https://www.baeldung.com/spring-boot-testing) : Une collection d'articles sur le test dans Spring Boot.
- [Testing in Spring Boot](https://reflectoring.io/spring-boot-test/) : Un tutoriel approfondi sur le test avec Spring Boot.

## FAQ

- **Q : Quand utiliser `@MockBean` vs `@Mock`?**
  
  **R :** Utilisez `@MockBean` dans les tests Spring Boot lorsque vous avez besoin que le contexte Spring remplace un bean par un mock. `@Mock` est utilisé avec Mockito en dehors du contexte Spring pour créer des objets mock.

- **Q : Dois-je toujours utiliser une base de données en mémoire pour les tests de repository?**
  
  **R :** Une base de données en mémoire (comme H2) est recommandée pour les tests d'intégration, car elle est rapide et ne nécessite pas de configuration de base de données externe. Cependant, pour les tests qui dépendent de fonctionnalités spécifiques à une base de données, envisagez d'utiliser la même base de données que celle de production.

- **Q : Comment puis-je exécuter uniquement un sous-ensemble de tests?**
  
  **R :** Avec Maven, vous pouvez utiliser l'option `-Dtest=ClassName#methodName` pour exécuter un test spécifique. Avec Gradle, utilisez `--tests "ClassName.methodName"`.

- **Q : Puis-je utiliser JUnit 5 avec des versions plus anciennes de Spring Boot?**
  
  **R :** JUnit 5 est supporté par défaut à partir de Spring Boot 2.2.0. Pour les versions antérieures, vous devrez peut-être ajouter des configurations supplémentaires pour intégrer JUnit 5.

---

- Ce guide a pour but de vous fournir une base solide pour tester efficacement votre application Spring Boot "Accounts" avec JUnit 5.
- N'oubliez pas que la pratique et l'exploration continuelles des fonctionnalités de JUnit 5 et de Spring Boot enrichiront vos compétences en test et contribueront à la qualité globale de vos projets.
