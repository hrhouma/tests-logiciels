# Partie 2 - Guide Débutant pour Tester un Contrôleur Spring avec Mockito

Ce README vise à expliquer, pas à pas, comment tester une classe de contrôleur dans une application Spring, en utilisant Mockito pour simuler les dépendances. Le code ci-dessous est un exemple de test unitaire pour un contrôleur qui gère les comptes utilisateur.

## Prérequis

- Connaissance basique de Java
- Introduction à Spring Framework
- Familiarité avec les concepts de test unitaire

## Environnement de Test

Le test est construit en utilisant :

- **JUnit** : Un framework pour les tests unitaires en Java.
- **Mockito** : Un framework de simulation pour isoler les tests des dépendances.
- **Spring Test** : Offre des fonctionnalités de test pour les applications Spring.

## Structure du Test

### Importations

```java
import com.eazybytes.accounts.service.AccountsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
```

- **Service & Contrôleur** : `AccountsService` et `AccountsController` sont les classes testées.
- **JUnit & Mockito** : Utilisés pour créer et exécuter le test.
- **Spring MVC Test** : Permet de simuler des requêtes HTTP.

### Configuration du Test

```java
@RunWith(MockitoJUnitRunner.class)
public class AccountsControllerTest {
```

- `@RunWith(MockitoJUnitRunner.class)`: Indique à JUnit d'utiliser Mockito pour les simulations et l'injection de dépendances.

### Simulation et Injection

```java
@Mock
private AccountsService accountsService;

@InjectMocks
private AccountsController accountsController;
```

- `@Mock` : Crée une version simulée de `AccountsService`.
- `@InjectMocks` : Crée une instance de `AccountsController` et injecte les simulations nécessaires.

### Initialisation

```java
private MockMvc mockMvc;

@Before
public void setup() {
    this.mockMvc = standaloneSetup(accountsController).build();
}
```

- `MockMvc` : Facilite l'envoi de requêtes HTTP au contrôleur et l'assertion des résultats.
- `@Before setup()`: Exécuté avant chaque test pour initialiser `MockMvc`.

### Test Unitaire

```java
@Test
public void testGetAccountDetails() throws Exception {
    when(accountsService.getAccountsById(1L)).thenReturn(new Accounts());

    mockMvc.perform(get("/myAccount/1"))
            .andExpect(status().isOk());

    verify(accountsService).getAccountsById(1L);
}
```

- `@Test` : Indique que c'est une méthode de test.
- `when(...).thenReturn(...)`: Configure le comportement simulé de `getAccountsById`.
- `mockMvc.perform(get("/myAccount/1"))`: Simule une requête GET vers `/myAccount/1`.
- `.andExpect(status().isOk())`: Vérifie que la réponse a un statut HTTP 200 (OK).
- `verify(...)`: S'assure que `getAccountsById` a été appelé avec l'argument `1L`.

## Conclusion

Ce guide a introduit les concepts de base pour tester un contrôleur Spring avec Mockito et JUnit. Le but est de s'assurer que le contrôleur réagit correctement aux requêtes HTTP, sans nécessiter une connexion réelle à la base de données ou d'autres services. En isolant le test au contrôleur, vous pouvez rapidement identifier et corriger les bugs dans la logique de votre application.

# Partie 2 - Intégration de JUnit 4 pour le Test dans Spring Boot

Ce guide fournit les étapes nécessaires pour ajouter des tests unitaires à votre application Spring Boot en utilisant JUnit 4. Nous couvrirons l'ajout de la dépendance JUnit au `pom.xml`, la création de tests pour un service et un contrôleur, et l'exécution des tests.

## Ajout de la Dépendance JUnit

1. **Modifier le fichier `pom.xml`**

   Ouvrez votre fichier `pom.xml` et ajoutez la dépendance suivante dans la section `<dependencies>` pour inclure JUnit 4 dans votre projet :

   ```xml
   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.13.2</version>
       <scope>test</scope>
   </dependency>
   ```

## Écriture de Tests Unitaires

### Tests pour `AccountsService`

1. **Création de la Classe de Test**

   Dans le dossier `src/test/java`, créez une classe de test dans le même package que `AccountsService`. Nommez cette classe `AccountsServiceTest.java`.

   ```java
   package com.eazybytes.accounts.service;

   import static org.junit.Assert.assertNotNull;
   import static org.mockito.Mockito.*;

   import org.junit.Before;
   import org.junit.Test;
   import org.mockito.InjectMocks;
   import org.mockito.Mock;
   import org.mockito.MockitoAnnotations;

   import java.util.Optional;

   public class AccountsServiceTest {

       @Mock
       private AccountsRepository accountsRepository;

       @InjectMocks
       private AccountsService accountsService;

       @Before
       public void setUp() {
           MockitoAnnotations.initMocks(this);
       }

       @Test
       public void testGetAccountsById() {
           Accounts mockAccount = new Accounts();
           mockAccount.setAccountNumber(1L);
           when(accountsRepository.findById(1L)).thenReturn(Optional.of(mockAccount));

           Accounts result = accountsService.getAccountsById(1L);

           assertNotNull(result);
           verify(accountsRepository).findById(1L);
       }
   }
   ```

### Tests pour `AccountsController`

1. **Création de la Classe de Test**

   Dans le dossier `src/test/java`, créez une classe de test dans le même package que `AccountsController`. Nommez cette classe `AccountsControllerTest.java`.

   ```java
   package com.eazybytes.accounts.controller;

   import com.eazybytes.accounts.service.AccountsService;
   import org.junit.Before;
   import org.junit.Test;
   import org.junit.runner.RunWith;
   import org.mockito.InjectMocks;
   import org.mockito.Mock;
   import org.mockito.junit.MockitoJUnitRunner;

   import static org.mockito.Mockito.*;
   import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
   import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
   import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

   import org.springframework.test.web.servlet.MockMvc;

   @RunWith(MockitoJUnitRunner.class)
   public class AccountsControllerTest {

       private MockMvc mockMvc;

       @Mock
       private AccountsService accountsService;

       @InjectMocks
       private AccountsController accountsController;

       @Before
       public void setup() {
           this.mockMvc = standaloneSetup(accountsController).build();
       }

       @Test
       public void testGetAccountDetails() throws Exception {
           when(accountsService.getAccountsById(1L)).thenReturn(new Accounts());

           mockMvc.perform(get("/myAccount/1"))
                   .andExpect(status().isOk());

           verify(accountsService).getAccountsById(1L);
       }
   }
   ```

## Exécution des Tests

Pour exécuter vos tests, utilisez la commande Maven suivante dans votre terminal :

```sh
mvn test
```

Ce processus exécutera tous les tests unitaires dans le dossier `src/test/java`. Vous devriez voir dans la sortie de la console si tous les tests ont réussi ou si certains ont échoué.
