# Guide de Test pour le Projet Spring Boot - Account

Ce guide détaillé explique comment tester efficacement les différentes couches de l'application Spring Boot "Account". En couvrant les tests unitaires et d'intégration des contrôleurs, services, et repositories, ce document vise à promouvoir une qualité et une stabilité élevées dans le développement.

## Table des Matières

1. Introduction
2. Configuration de Test
3. Tests des Contrôleurs
4. Tests des Services
5. Tests des Repositories
6. Exécution des Tests
7. Outils et Frameworks

## Introduction

Tester est crucial pour maintenir la qualité de l'application "Account". Ce guide se concentre sur les stratégies de test pour les couches principales, en utilisant JUnit pour les tests unitaires et Spring Test pour les tests d'intégration.

## Configuration de Test

Pour commencer, assurez-vous que votre projet contient les dépendances JUnit et Spring Test dans `pom.xml` :

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <version>VotreVersionSpringBoot</version>
    <scope>test</scope>
</dependency>
```

## Tests des Contrôleurs

Les tests de contrôleur vérifient le traitement des requêtes et des réponses HTTP. Utilisez `MockMvc` pour simuler les appels d'API.

```java
@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountsController.class)
public class AccountsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountsService accountsService;

    // Exemple de test
    @Test
    public void getAccountDetails_ShouldReturnAccount() throws Exception {
        // Simuler la logique du service ici

        mockMvc.perform(get("/myAccount/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("1"));
    }
}
```

## Tests des Services

Les tests de service examinent la logique métier. Simulez les dépendances avec Mockito.

```java
@RunWith(MockitoJUnitRunner.class)
public class AccountsServiceTest {
    @InjectMocks
    private AccountsService accountsService;

    @Mock
    private AccountsRepository accountsRepository;

    // Exemple de test
    @Test
    public void getAccountById_ShouldReturnAccount() {
        // Simuler les réponses du repository ici

        assertNotNull(accountsService.getAccountsById(1L));
    }
}
```

## Tests des Repositories

Les tests de repository assurent que les interactions avec la base de données sont correctes. `@DataJpaTest` facilite les tests d'intégration de repository.

```java
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountsRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountsRepository accountsRepository;

    // Exemple de test
    @Test
    public void findByCustomerId_ShouldReturnAccount() {
        // Préparer le scénario de données

        Accounts account = accountsRepository.findByCustomerId(1);
        assertEquals(account.getCustomerId(), 1);
    }
}
```

## Exécution des Tests

Pour lancer tous les tests, utilisez la commande Maven :

```bash
mvn clean test
```

Cette commande nettoiera le projet (en supprimant le dossier `target`) et exécutera ensuite tous les tests définis.

## Outils et Frameworks

- **JUnit** : Framework de test pour Java.
- **Mockito** : Framework de simulation pour isoler les tests des dépendances externes.
- **Spring Test** : Propose des outils de test pour les applications Spring.
- **Maven** : Outil de gestion et de compréhension de projet.

# Explications supplémentaires : 

Chacun de ces extraits de code illustre une approche différente pour tester une partie spécifique de l'application Spring Boot, en se concentrant sur les contrôleurs, les services et les repositories. Examinons chaque extrait et expliquons-le en détail.

### Tests des Contrôleurs avec `@WebMvcTest`

```java
@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountsController.class)
public class AccountsControllerTest {
    ...
}
```

- **@RunWith(SpringRunner.class)** : Cette annotation indique à JUnit d'exécuter le test avec le support de Spring Test. `SpringRunner` est une alias pour `SpringJUnit4ClassRunner` et permet l'intégration de la logique de test de Spring avec JUnit.

- **@WebMvcTest(value = AccountsController.class)** : Spécifie que le test se concentre uniquement sur le contrôleur `AccountsController`. Cette annotation charge uniquement les composants nécessaires pour tester le contrôleur, rendant le test léger et rapide. Elle configure automatiquement `MockMvc`, ce qui est essentiel pour tester les requêtes et réponses HTTP sans démarrer un serveur complet.

- **@Autowired private MockMvc mockMvc;** : `MockMvc` est injecté dans le contexte de test. Il est utilisé pour simuler des requêtes HTTP vers le contrôleur et pour affirmer des attentes sur les réponses.

- **@MockBean private AccountsService accountsService;** : Remplace le bean `AccountsService` dans le contexte de l'application par un mock. Cela isole le test du contrôleur des dépendances externes.

### Tests des Services avec `@RunWith(MockitoJUnitRunner.class)`

```java
@RunWith(MockitoJUnitRunner.class)
public class AccountsServiceTest {
    ...
}
```

- **@RunWith(MockitoJUnitRunner.class)** : Active les annotations de Mockito dans le test, comme `@Mock` et `@InjectMocks`, permettant l'injection de dépendances simulées.

- **@InjectMocks private AccountsService accountsService;** : Crée une instance de `AccountsService` et injecte les dépendances mockées (comme `AccountsRepository`) dans celle-ci.

- **@Mock private AccountsRepository accountsRepository;** : Crée un mock pour `AccountsRepository`, qui peut être configuré pour simuler des réponses spécifiques, isolant ainsi les tests de la base de données.

### Tests des Repositories avec `@DataJpaTest`

```java
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountsRepositoryTest {
    ...
}
```

- **@RunWith(SpringRunner.class)** : Configure le support de test Spring, nécessaire pour l'intégration avec JPA.

- **@DataJpaTest** : Configure une configuration de test spécifique pour le testing de JPA. Elle configure une base de données en mémoire pour les tests, configure Hibernate, Spring Data, et DataSource. Cela permet de tester le repository dans un environnement isolé.

- **@Autowired private TestEntityManager entityManager;** : Permet d'insérer ou de rechercher des entités de test. `TestEntityManager` est une alternative simplifiée à `EntityManager` pour les tests.

- **@Autowired private AccountsRepository accountsRepository;** : Injecte le repository à tester dans le contexte de test. Grâce à `@DataJpaTest`, les opérations du repository peuvent être testées contre la base de données en mémoire.

- Chacun de ces tests vise à isoler une partie spécifique de l'application (contrôleur, service, repository) pour vérification, en utilisant les fonctionnalités de Spring et Mockito pour simuler les dépendances et tester le comportement attendu dans des conditions contrôlées.
- Ce guide fournit une base solide pour tester efficacement les applications Spring Boot, en s'assurant que chaque couche de l'application est correctement testée pour maintenir la qualité et la stabilité.
