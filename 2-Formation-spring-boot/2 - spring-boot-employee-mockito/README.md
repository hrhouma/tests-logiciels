# Référence : 
https://medium.com/thefreshwrites/junit-and-mockito-in-spring-boot-38dcbf4b132f

Spring Boot utilise Spring Data JPA (Java Persistence API) pour simplifier l'accès aux données dans les applications Java. Le mécanisme de repository de Spring Data JPA fournit une abstraction puissante pour accéder aux données, permettant de créer des requêtes de base sans avoir besoin d'écrire du code SQL spécifique. Spring Data JPA gère la plupart des tâches de routine liées à l'accès aux données, comme l'ouverture et la fermeture de la connexion à la base de données, la conversion des résultats des requêtes en objets Java, etc.

Pour l'exemple de la classe `Employee` que vous avez fourni, on peut créer une interface de repository pour gérer les opérations CRUD (Create, Read, Update, Delete) pour les entités `Employee`. Voici comment cela fonctionne et comment on pourrait implémenter une méthode personnalisée pour rechercher par exemple par le nom de famille :

### Interface Repository

Pour commencer, vous créez une interface qui étend l'une des interfaces de repository fournies par Spring Data JPA, généralement `JpaRepository` ou `CrudRepository`. Ces interfaces définissent des méthodes pour les opérations CRUD standard.

```java
package com.example.mockitodemo.repository;

import com.example.mockitodemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Ici, nous pouvons définir des méthodes personnalisées.
}
```

### Méthodes personnalisées

Spring Data JPA permet de définir des méthodes de recherche personnalisées dans l'interface du repository simplement en déclarant des méthodes suivant une convention de nommage spécifique. Par exemple, si vous souhaitez trouver un employé par son `lastName`, vous pouvez ajouter la méthode suivante à l'interface `EmployeeRepository` :

```java
List<Employee> findByLastName(String lastName);
```

Spring Data JPA génère automatiquement l'implémentation de cette méthode. La partie `findBy` indique à Spring Data JPA que vous souhaitez récupérer des entités en fonction de certains critères, et `LastName` spécifie que le critère de recherche est la propriété `lastName` de l'entité `Employee`. 

Spring Data JPA prend en charge une grande variété de mots-clés qui peuvent être utilisés pour définir des critères de recherche, tels que `GreaterThan`, `LessThan`, `Between`, `Like`, et bien d'autres. Ces mots-clés peuvent être combinés pour créer des requêtes complexes.

### Avantages

- **Réduction du code boilerplate** : Spring Data JPA génère automatiquement les implémentations de repository, ce qui réduit considérablement le montant du code que vous devez écrire et maintenir.
- **Abstraction de la couche d'accès aux données** : Spring Data JPA fournit une abstraction de haut niveau pour l'accès aux données, ce qui permet de changer facilement la base de données sous-jacente sans changer le code de l'application.
- **Intégration avec le reste de l'écosystème Spring** : Spring Data JPA s'intègre bien avec d'autres parties de Spring, comme Spring Security et Spring MVC, permettant un développement cohérent et simplifié des applications.

L'utilisation de Spring Data JPA et de ses interfaces de repository rend l'accès aux données plus simple et plus élégant, en suivant les principes convention over configuration de Spring.

***********
Bien sûr, voici un exemple de fichier `README.md` pour documenter l'utilisation de Spring Data JPA pour accéder à des entités `Employee` dans une application Spring Boot. Vous pouvez ajuster ce modèle selon les besoins spécifiques de votre projet.


# Gestion des Employés avec Spring Boot et Spring Data JPA

Ce projet démontre l'utilisation de Spring Boot et Spring Data JPA pour construire une application de gestion des employés simple mais puissante. L'application permet de créer, lire, mettre à jour et supprimer (CRUD) des informations d'employés dans une base de données.

## Modèle `Employee`

L'entité `Employee` représente les employés dans notre application. Voici sa structure :

```java
package com.example.mockitodemo.model;

import lombok.*;
import jakarta.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;
}
```

## Repository `EmployeeRepository`

Pour accéder aux données des employés, nous utilisons l'interface `EmployeeRepository` qui étend `JpaRepository`. Cela fournit automatiquement des méthodes CRUD pour l'entité `Employee`. Nous pouvons également définir des méthodes personnalisées si nécessaire.

```java
package com.example.mockitodemo.repository;

import com.example.mockitodemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
}
```

## Utilisation

Après avoir défini l'entité `Employee` et le repository `EmployeeRepository`, vous pouvez injecter `EmployeeRepository` dans vos services ou contrôleurs pour effectuer des opérations CRUD sur les employés. Voici un exemple de service utilisant `EmployeeRepository` :

```java
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // Ajoutez d'autres méthodes pour gérer les employés
}
```

## Conclusion

Ce guide montre comment configurer un projet Spring Boot avec Spring Data JPA pour gérer les données des employés de manière simple et efficace. Grâce à l'abstraction fournie par Spring Data JPA, l'accès et la gestion des données deviennent plus faciles et plus rapides, permettant aux développeurs de se concentrer sur la logique métier de l'application plutôt que sur la gestion de la base de données.


Ce `README.md` fournit une vue d'ensemble basique de la manière de travailler avec Spring Data JPA dans un projet Spring Boot, y compris des informations sur l'entité `Employee`, le repository `EmployeeRepository`, et un exemple d'utilisation dans un service. Vous pouvez étoffer ce fichier avec plus de détails spécifiques à votre projet, comme les instructions d'installation, de configuration, et d'exécution de l'application.
*****
L'erreur que vous avez rencontrée et la solution que vous avez trouvée touchent à un aspect fondamental de Spring Data JPA : la capacité de créer des requêtes de manière déclarative grâce à la convention de nommage dans les interfaces de repository.

Lorsque vous avez tenté d'utiliser la méthode `employeeRepository.findByEmail(employee.getEmail());` sans avoir explicitement déclaré cette méthode dans votre interface `EmployeeRepository`, Spring Data JPA ne pouvait pas résoudre cette méthode car elle ne faisait pas partie des méthodes CRUD générées automatiquement ni n'était définie par vous dans l'interface. Spring Data JPA génère des implémentations de méthode au runtime basées sur les noms des méthodes déclarées dans vos interfaces de repository, en suivant une convention de nommage spécifique qui permet d'interpréter le nom de la méthode comme une requête.

Lorsque vous avez ajouté la méthode `Optional<Employee> findByEmail(String email);` à votre interface `EmployeeRepository`, vous avez explicitement défini une méthode de recherche par l'email de l'employé. En utilisant le mot-clé `findBy` suivi du nom de l'attribut `Email` (avec une majuscule correspondant exactement au nom de la propriété de l'entité, en supposant que votre entité `Employee` a une propriété `email`), vous avez indiqué à Spring Data JPA de générer une requête qui recherche un employé par son adresse email. Le retour de cette méthode sous forme d'un `Optional<Employee>` est une bonne pratique pour gérer le cas où aucun employé n'est trouvé avec l'email spécifié, évitant ainsi les `NullPointerException`.

### Pourquoi définir cette méthode explicitement ?

- **Spécificité des requêtes** : Les méthodes CRUD génériques fournies par `JpaRepository` couvrent des opérations de base comme trouver tous les enregistrements ou trouver par ID. Pour des requêtes spécifiques basées sur d'autres attributs, vous devez les définir explicitement.
  
- **Type de retour adapté** : En utilisant `Optional`, vous adoptez une approche plus sûre pour gérer la possibilité de valeurs nulles, ce qui est courant lors de la recherche d'enregistrements dans une base de données.

- **Convention de nommage** : Spring Data JPA repose fortement sur la convention de nommage pour traduire les méthodes définies dans l'interface de repository en requêtes SQL. En suivant cette convention, vous bénéficiez de la puissance de Spring Data JPA sans écrire de code SQL ou JPQL explicite.

Cette approche illustre la flexibilité et la puissance de Spring Data JPA, permettant aux développeurs de construire rapidement des applications robustes et maintenables en réduisant le besoin d'écrire et de maintenir du code boilerplate pour l'accès aux données.

**********
Votre observation est tout à fait juste et touche à une nuance importante de la façon dont Spring Data JPA fonctionne et fournit ses fonctionnalités.

### Pourquoi `findById` est disponible sans déclaration explicite

La méthode `findById` fait partie des méthodes fournies par défaut par l'interface `JpaRepository` que votre `EmployeeRepository` étend. L'interface `JpaRepository` hérite de `CrudRepository` et de `PagingAndSortingRepository`, qui ensemble, fournissent un ensemble riche de méthodes CRUD opérationnelles, y compris `findById`, `findAll`, `save`, et bien d'autres. Ces méthodes sont immédiatement disponibles pour être utilisées avec n'importe quelle entité que votre repository gère, sans nécessiter de déclarations supplémentaires de votre part. Cela est possible parce que ces opérations sont très communes et nécessaires pour la plupart des types d'entités, donc Spring Data JPA les rend disponibles par défaut.

### Pourquoi `findByEmail` doit être déclarée explicitement

En revanche, `findByEmail` est une méthode de recherche basée sur un attribut spécifique de votre entité `Employee` qui n'est pas couverte par les méthodes CRUD standard. Spring Data JPA ne peut pas prévoir quelles requêtes basées sur des attributs spécifiques vous pourriez vouloir exécuter, car cela dépend entièrement de la logique métier de votre application et du modèle de données. C'est pourquoi vous devez déclarer explicitement ces méthodes dans votre interface de repository pour que Spring Data JPA puisse les interpréter et générer les implémentations correspondantes au runtime.

### Résumé

- `findById` et d'autres méthodes CRUD sont disponibles par défaut avec `JpaRepository` car elles sont essentielles et universellement applicables à tous les types d'entités.
- Des méthodes comme `findByEmail` doivent être définies explicitement dans votre interface de repository car elles dépendent des attributs spécifiques de vos entités et des besoins particuliers de votre application.

Cette distinction permet à Spring Data JPA d'offrir une grande flexibilité et puissance, vous permettant d'accéder facilement aux opérations de données les plus communes tout en vous donnant la capacité de personnaliser le comportement du repository pour répondre à des besoins spécifiques.
**********
La confusion vient du fait que `JpaRepository` et d'autres interfaces parentes dans Spring Data JPA, comme `CrudRepository` ou `PagingAndSortingRepository`, fournissent déjà un ensemble de méthodes CRUD de base qui sont communes à toutes les entités. Ces méthodes couvrent les opérations essentielles de manipulation des données, et elles sont automatiquement disponibles dans tous les repositories qui étendent ces interfaces. Voici quelques-unes de ces méthodes et ce qu'elles font :

### Méthodes fournies par `CrudRepository`
- **save(S entity)** : Enregistre une entité donnée. Si l'entité a déjà un ID, elle sera mise à jour ; sinon, une nouvelle entrée sera créée.
- **findById(ID id)** : Récupère une entité par son ID. Le résultat est encapsulé dans un `Optional` pour gérer les cas où l'entité n'existe pas.
- **existsById(ID id)** : Vérifie si une entité avec l'ID spécifié existe.
- **findAll()** : Récupère toutes les entités du type spécifié.
- **count()** : Compte le nombre d'entités disponibles.
- **deleteById(ID id)** : Supprime l'entité avec l'ID spécifié.
- **delete(S entity)** : Supprime l'entité donnée.
- **deleteAll(Iterable<? extends S> entities)** : Supprime toutes les entités fournies.
- **deleteAll()** : Supprime toutes les entités du repository.

### Méthodes ajoutées par `PagingAndSortingRepository`
- **findAll(Sort sort)** : Récupère toutes les entités, triées selon le critère spécifié.
- **findAll(Pageable pageable)** : Récupère les entités selon la pagination et le tri spécifiés.

### Méthodes ajoutées par `JpaRepository`
- **findAll()** : Surcharge la méthode pour retourner une liste au lieu d'un `Iterable`.
- **flush()** : Force la mise à jour ou l'insertion des modifications en attente dans la base de données.
- **saveAndFlush(S entity)** : Enregistre immédiatement une entité et applique les modifications en base de données.
- **deleteInBatch(Iterable<T> entities)** : Supprime en lot les entités fournies sans utiliser la vérification d'état par enregistrement, ce qui peut être plus performant pour de grandes quantités.
- **deleteAllInBatch()** : Supprime toutes les entités en un seul batch, ce qui est plus performant que de supprimer les enregistrements un par un.

Ces méthodes couvrent les opérations de base nécessaires pour l'accès aux données et la manipulation des entités dans la plupart des applications, ce qui rend le développement plus rapide et plus efficace. Si vous avez besoin de fonctionnalités supplémentaires ou spécifiques qui ne sont pas couvertes par ces méthodes (comme `findByEmail` dans votre cas), vous devez les déclarer explicitement dans votre interface de repository. Spring Data JPA générera alors automatiquement l'implémentation de ces méthodes selon la convention de nommage que vous avez utilisée.

************
Pour votre entité `Employee` dans le package `com.example.mockitodemo.model`, vous pouvez définir plusieurs méthodes personnalisées dans votre interface de repository pour répondre à divers besoins de recherche et de manipulation des données. Voici quelques exemples de méthodes que vous pourriez vouloir déclarer, en fonction des fonctionnalités que vous souhaitez implémenter dans votre application :

### Rechercher par Nom et Prénom

```java
List<Employee> findByFirstName(String firstName);
List<Employee> findByLastName(String lastName);
```

### Recherche Combinée

Pour rechercher des employés par une combinaison de nom et prénom :

```java
List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
```

### Recherche Par Nom avec Tri

Si vous souhaitez récupérer les employés triés par leur nom de famille :

```java
List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);
```

### Recherche Par Email

Comme vous l'avez déjà ajouté, mais pour compléter :

```java
Optional<Employee> findByEmail(String email);
```

### Recherche par Statut d'Activité

Si votre entité `Employee` avait un champ indiquant si l'employé est actuellement actif ou non, vous pourriez vouloir ajouter :

```java
List<Employee> findByActive(boolean isActive);
```

Note : Vous devrez ajouter le champ `active` à votre classe `Employee` pour utiliser cette méthode.

### Pagination

Pour récupérer les employés avec pagination :

```java
Page<Employee> findAll(Pageable pageable);
```

Cette méthode permet de contrôler le nombre d'employés retournés dans une requête et de les paginer, ce qui est utile pour les interfaces utilisateur qui affichent les données sous forme de liste ou de tableau paginé.

### Recherche avec des Critères Spécifiques (Utilisation de Specifications)

Pour des requêtes plus complexes, vous pouvez utiliser le mécanisme de spécifications de Spring Data JPA. Cela vous permet de construire des requêtes dynamiquement avec des critères spécifiques :

```java
List<Employee> findAll(Specification<Employee> spec);
```

Note : Utiliser `Specification` nécessite une compréhension plus approfondie de Spring Data JPA et peut rendre votre code plus complexe, mais c'est un outil puissant pour les requêtes conditionnelles complexes.

### Conclusion

Ces exemples montrent comment étendre votre repository pour inclure des méthodes qui répondent à des besoins spécifiques de votre application, en utilisant les noms de propriétés de votre entité `Employee`. Spring Data JPA rend ces personnalisations simples grâce à sa convention de nommage et à sa capacité à générer automatiquement les requêtes correspondantes. Selon les besoins exacts de votre application, vous pouvez ajouter ou modifier ces méthodes pour effectuer des opérations de données plus ciblées.

****
**JPQL
Le Java Persistence Query Language (JPQL) est un langage de requête orienté objet utilisé pour effectuer des requêtes dans des applications gérées par JPA, y compris les applications Spring Data JPA. JPQL est conçu pour simplifier la manipulation de données persistantes sans utiliser de requêtes SQL directes, permettant ainsi aux développeurs de travailler directement avec les classes et les instances d'objet Java plutôt qu'avec des tables et des colonnes de base de données.

Dans le contexte de Spring Data JPA, vous pouvez utiliser JPQL pour définir des requêtes personnalisées dans vos interfaces de repository. Ces requêtes sont spécifiées à l'aide de l'annotation `@Query` au-dessus des méthodes de l'interface. Voici comment vous pouvez appliquer JPQL pour effectuer des requêtes complexes qui ne peuvent pas être facilement réalisées en utilisant uniquement la convention de nommage de Spring Data JPA.

### Exemple d'utilisation de JPQL avec votre entité `Employee`

Imaginons que vous vouliez effectuer une recherche d'employés basée sur un critère plus complexe que ceux couverts par les méthodes simples de Spring Data JPA. Vous pourriez vouloir rechercher des employés par nom de famille avec un tri spécifique, ou peut-être effectuer des opérations de jointure avec une autre entité. Voici quelques exemples d'utilisation de JPQL dans votre repository :

#### Rechercher des employés par nom de famille

```java
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.lastName = :lastName")
    List<Employee> findByLastName(String lastName);
}
```

#### Compter les employés par nom de famille

```java
@Query("SELECT COUNT(e) FROM Employee e WHERE e.lastName = :lastName")
long countByLastName(String lastName);
```

#### Recherche d'employés avec une jointure (exemple hypothétique)

Supposons que vous ayez une autre entité, `Department`, et que chaque `Employee` appartient à un `Department`. Vous pourriez vouloir trouver tous les employés d'un certain département :

```java
@Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName")
List<Employee> findByDepartmentName(String departmentName);
```

Note : Cet exemple suppose que votre entité `Employee` a une association `department` mappée à une entité `Department`.

### Avantages de JPQL

- **Indépendance de la base de données** : Les requêtes JPQL sont traduites en SQL par le fournisseur JPA, ce qui signifie que vos requêtes sont indépendantes du dialecte SQL spécifique à la base de données.
- **Sécurité** : Utiliser JPQL aide à prévenir les injections SQL puisque les paramètres de requête sont automatiquement échappés.
- **Orientation objet** : JPQL vous permet de travailler directement avec les classes et les propriétés d'objet, ce qui est plus naturel dans le contexte d'une application Java.

### Conclusion

JPQL offre une flexibilité et une puissance considérables pour définir des requêtes personnalisées dans vos applications Spring Data JPA, vous permettant de gérer des cas d'utilisation complexes qui vont au-delà des capacités des conventions de nommage simples. En utilisant l'annotation `@Query`, vous pouvez intégrer des requêtes JPQL directement dans vos interfaces de repository pour effectuer des opérations de données sophistiquées tout en bénéficiant de l'intégration et de la simplicité d'utilisation de Spring Data JPA.
