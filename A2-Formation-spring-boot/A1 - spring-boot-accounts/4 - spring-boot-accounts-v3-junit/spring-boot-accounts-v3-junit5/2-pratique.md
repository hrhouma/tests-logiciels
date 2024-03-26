# Série d'exercices sur les tests avec JUnit 5 pour le projet "Accounts"

Ces exercices permettront aux étudiants de se familiariser avec la rédaction de tests unitaires et d'intégration en utilisant JUnit 5 pour le projet "Accounts" sous Spring Boot. Les exercices couvriront les tests des contrôleurs, services, et repositories.

## Exercice 1: Tests des Contrôleurs avec MockMvc

**Objectif** : Écrire des tests pour vérifier le comportement des endpoints du contrôleur `AccountsController`.

1. **Tester `getAccountDetails` pour un compte existant** :
   - Simulez une requête GET à `/myAccount/{id}` avec un ID valide.
   - Vérifiez que le statut de la réponse est OK (200).
   - Vérifiez que le corps de la réponse contient les détails du compte attendus.

2. **Tester `getAllAccounts` pour récupérer tous les comptes** :
   - Simulez une requête GET à `/accounts`.
   - Vérifiez que le statut de la réponse est OK (200).
   - Vérifiez que le corps de la réponse contient la liste des comptes.

3. **Tester `newAccount` avec des données de compte valides** :
   - Simulez une requête POST à `/newAccount` avec un corps de requête contenant les détails d'un nouveau compte.
   - Vérifiez que le statut de la réponse est OK (200) ou CREATED (201).
   - Vérifiez que le corps de la réponse contient un message confirmant la création du compte.

## Exercice 2: Tests des Services avec Mockito

**Objectif** : Écrire des tests pour vérifier la logique métier implémentée dans `AccountsService`.

1. **Tester `getAccountsById` pour un compte existant** :
   - Mockez `AccountsRepository` pour retourner un objet `Accounts` lorsque `findById` est appelé avec un ID spécifique.
   - Appelez `getAccountsById` avec cet ID et vérifiez que le compte retourné correspond à l'objet mocké.

2. **Tester `getAllAccounts` pour s'assurer qu'il retourne tous les comptes** :
   - Mockez `AccountsRepository` pour retourner une liste d'objets `Accounts` lorsque `findAll` est appelé.
   - Appelez `getAllAccounts` et vérifiez que la liste retournée correspond à la liste mockée.

3. **Tester `save` pour un nouveau compte** :
   - Créez un objet `Accounts` pour un nouveau compte.
   - Mockez `AccountsRepository` pour retourner l'objet `Accounts` lorsque `save` est appelé.
   - Appelez `save` avec le nouveau compte et vérifiez que la méthode retourne le résultat attendu.

## Exercice 3: Tests des Repositories avec @DataJpaTest

**Objectif** : Écrire des tests d'intégration pour `AccountsRepository` en utilisant une base de données en mémoire.

1. **Tester `findByCustomerId` pour s'assurer qu'il retourne le compte correct** :
   - Utilisez `TestEntityManager` pour insérer un objet `Accounts` dans la base de données en mémoire.
   - Appelez `findByCustomerId` avec l'ID du client utilisé et vérifiez que le compte retourné correspond à celui inséré.

2. **Tester `save` pour s'assurer qu'un nouveau compte est correctement persisté** :
   - Créez un nouvel objet `Accounts` et utilisez la méthode `save` du repository pour le persister.
   - Utilisez `findById` pour récupérer le compte persisté et vérifiez que les détails correspondent.

## Consignes Générales

- Veillez à suivre les bonnes pratiques de nommage des méthodes de test : le nom doit refléter le cas de test et le résultat attendu.
- Utilisez `@BeforeEach` pour initialiser les mocks et les objets communs avant chaque test.
- Commentez votre code pour expliquer la logique des tests, surtout lors de la vérification des résultats.

Ces exercices offrent une occasion pratique de travailler avec JUnit 5 et d'approfondir votre compréhension du test d'applications Spring Boot. Bonne chance !