# RÉPONSES : 

1. **Quelle annotation permet de mapper les requêtes HTTP aux méthodes d'un contrôleur?**
   - `@RequestMapping` est l'annotation qui permet de mapper les requêtes HTTP aux méthodes d'un contrôleur dans Spring MVC. Elle peut être utilisée pour gérer différents types de requêtes HTTP en spécifiant le paramètre `method`.

2. **Quelle est la différence principale entre Page<T> et Slice<T> dans Spring Data?**
   - La différence principale entre `Page<T>` et `Slice<T>` est que `Page<T>` contient des informations sur le nombre total de pages et d'enregistrements, facilitant ainsi la pagination complète, tandis que `Slice<T>` ne fournit que les données de la page courante et un indicateur de la présence ou non d'une page suivante, sans calculer le nombre total d'enregistrements ou de pages. Cela rend `Slice<T>` plus léger en termes de performances lorsque le total n'est pas nécessaire.

3. **Quelle annotation est utilisée pour injecter automatiquement les dépendances dans Spring Boot?**
   - `@Autowired` est l'annotation utilisée pour injecter automatiquement les dépendances dans les beans de Spring Boot.

4. **Quelle annotation est utilisée pour définir qu'une classe est une entité JPA?**
   - `@Entity` est l'annotation utilisée pour définir qu'une classe est une entité JPA, ce qui signifie qu'elle est liée à une table dans la base de données.

5. **Comment spécifier une requête JPQL pour chercher des entités tout en supportant la pagination?**
   - En utilisant `@Query` au-dessus d'une méthode de repository et en passant `Pageable` comme paramètre. Ceci permet d'intégrer la pagination directement dans la requête.

6. **Quelle annotation permet d'activer la découverte de composants dans les packages spécifiés?**
   - `@ComponentScan` est l'annotation qui permet d'activer la découverte automatique de composants, services, configurations, etc., dans les packages spécifiés.

7. **Quelle annotation est utilisée pour récupérer le corps d'une requête HTTP sous forme d'objet Java?**
   - `@RequestBody` est l'annotation utilisée pour récupérer le corps d'une requête HTTP et le désérialiser automatiquement en un objet Java.

8. **Dans JPQL, comment spécifier une clause de pagination pour limiter les résultats d'une requête?**
   - La pagination dans JPQL se fait généralement au niveau de la couche de service ou du repository, en utilisant `Pageable` ou en configurant manuellement les méthodes `setFirstResult()` et `setMaxResults()` sur la `Query`, et non par des mots-clés spécifiques dans la requête JPQL elle-même.

9. **Quelle annotation est utilisée dans Spring Boot pour mapper une méthode de contrôleur à une requête HTTP POST?**
   - `@PostMapping` est une annotation spécialisée qui agit comme un raccourci pour `@RequestMapping(method = RequestMethod.POST)` et est utilisée pour mapper une méthode de contrôleur à une requête HTTP POST.

10. **Dans un repository JPA, quelle interface permet d'implémenter la pagination?**
    - `PagingAndSortingRepository` est l'interface qui étend `CrudRepository` et ajoute des fonctionnalités de pagination et de tri aux opérations CRUD standard.

11. **Pour spécifier le code de statut HTTP d'une réponse, quelle annotation est utilisée?**
    - `@ResponseStatus` est l'annotation utilisée pour spécifier le code de statut HTTP d'une réponse directement sur la méthode d'un contrôleur.

12. **Quelle annotation est utilisée pour marquer un champ ou une propriété comme la clé primaire d'une entité?**
    - `@Id` est l'annotation utilisée pour marquer un champ ou une propriété comme la clé primaire d'une entité JPA.

13. **Pour insérer automatiquement la valeur de la clé primaire lors de la persistance d'une entité, quelle annotation utilise-t-on sur le champ id?**
    - `@GeneratedValue(strategy = GenerationType.AUTO)` est utilisée pour générer automatiquement la valeur de la clé primaire lors de la persistance d'une entité.

14. **Pour mapper les variables de chemin d'une URL, quelle annotation est utilisée?**
    - `@PathVariable` est l'annotation utilisée pour mapper les variables de chemin d'une URL à une méthode de contrôleur.

15. **Quelle annotation est utilisée pour marquer une méthode qui doit être exécutée avant chaque test unitaire dans un contexte Spring Boot?**
    - `@BeforeEach` (dans le contexte de JUnit 5) est l'annotation utilisée pour marquer une méthode qui doit être exécutée avant chaque test unitaire. Pour JUnit 4, l'annotation correspondante serait `@Before`.

16. **Qu'est-ce que ResponseEntity dans Spring Boot et à quoi sert-il?**
    - `ResponseEntity` est un objet qui représente la réponse HTTP complète, y compris le statut, les headers, et le corps. Il permet de personnaliser entièrement la réponse HTTP retournée par un contrôleur.

17. **Quelle annotation est utilisée pour définir des tâches à exécuter de manière asynchrone dans Spring Boot?**
    - `@Async` est l'annotation utilisée pour marquer une méthode devant être exécutée de manière asynchrone, c'est-à-dire dans un thread séparé.

18. **Quelle annotation Spring Data est utilisée pour créer automatiquement un bean repository qui interagit avec l'entité spécifiée?**
    - `@Repository` est l'annotation utilisée pour marquer une interface comme un repository Spring Data, ce qui permet à Spring de créer automatiquement un bean repository qui interagit avec l'entité spécifiée.

19. **Quelle annotation est utilisée pour activer la mise en cache dans une application Spring?**
    - `@EnableCaching` est l'annotation utilisée pour activer la mise en cache dans une application Spring, permettant l'utilisation des annotations de cache telles que `@Cacheable`, `@CacheEvict`, etc.

20. **Quelle annotation est utilisée pour gérer les transactions de base de données dans Spring Boot?**
    - `@Transactional` est l'annotation utilisée pour gérer les transactions de base de données, garantissant ainsi l'intégrité des données en cas de succès ou d'échec des opérations.

21. **Quelle annotation marque une classe comme un service dans Spring Boot?**
    - `@Service` est l'annotation qui marque une classe comme un service, indiquant à Spring qu'il s'agit d'une couche de service dans l'architecture de l'application.

22. **Quelle annotation est utilisée pour marquer une classe comme un contrôleur REST dans Spring Boot?**
    - `@RestController` est l'annotation qui combine `@Controller` et `@ResponseBody`, indiquant à Spring qu'il s'agit d'un contrôleur dont toutes les méthodes renvoient des données qui doivent être écrites directement dans le corps de la réponse, typiquement pour construire des services web RESTful.

23. **Quelle annotation permet de marquer une interface comme un repository Spring Data?**
    - `@Repository` est également l'annotation qui permet de marquer une interface comme un repository Spring Data, facilitant l'intégration avec la couche de persistance et l'abstraction de l'accès aux données.
      
24. **Quelle annotation est utilisée pour activer la mise en cache dans une application Spring?**
    - `@EnableCaching` est l'annotation qui permet d'activer la mise en cache au niveau de l'application. Elle doit être ajoutée à une classe de configuration pour permettre l'utilisation des annotations `@Cacheable`, `@CacheEvict`, et `@CachePut` pour contrôler la mise en cache.

25. **Quelle annotation est utilisée pour gérer les transactions de base de données dans Spring Boot?**
    - `@Transactional` est l'annotation qui permet de déclarer des méthodes ou des classes entières comme transactionnelles, ce qui signifie que toutes les opérations réalisées à l'intérieur seront exécutées dans le cadre d'une transaction de base de données.

26. **Quelle annotation marque une classe comme un service dans Spring Boot?**
    - `@Service` est l'annotation qui marque une classe comme un service, ce qui indique à Spring qu'il s'agit d'un composant au niveau de la couche de service de l'architecture de l'application.

27. **Comment retourner une réponse HTTP 404 NOT FOUND en utilisant ResponseEntity?**
    - `return ResponseEntity.notFound().build();` est l'approche recommandée pour retourner une réponse HTTP 404 NOT FOUND en utilisant `ResponseEntity` dans Spring Boot.

28. **Quelle annotation est utilisée pour gérer les exceptions spécifiques dans les contrôleurs de Spring Boot?**
    - `@ExceptionHandler` est l'annotation utilisée pour gérer les exceptions spécifiques dans les contrôleurs de Spring Boot, permettant de définir des méthodes au sein des contrôleurs qui seront appelées pour gérer certaines exceptions.

29. **Quelle annotation est utilisée pour marquer une classe comme un contrôleur REST dans Spring Boot?**
    - `@RestController` est l'annotation qui marque une classe comme un contrôleur REST, combinant `@Controller` et `@ResponseBody` pour indiquer que chaque méthode renvoie une réponse qui doit être écrite directement dans le corps de la réponse.

30. **Quelle méthode ResponseEntity permet de personnaliser entièrement la réponse, y compris le statut, les headers, et le corps?**
    - `ResponseEntity.status(HttpStatus.OK)` permet de personnaliser entièrement la réponse, en offrant la possibilité de définir le statut, les headers, et le corps de la réponse.

31. **Pour mapper une méthode de contrôleur à une requête HTTP GET, quelle annotation est utilisée?**
    - `@GetMapping` est l'annotation utilisée pour mapper une méthode de contrôleur à une requête HTTP GET. Elle est un raccourci pour `@RequestMapping(method = RequestMethod.GET)`.

32. **Quel est le rôle principal de ResponseEntity dans un contrôleur Spring Boot?**
    - Le rôle principal de `ResponseEntity` dans un contrôleur Spring Boot est de personnaliser les réponses HTTP. Il permet de contrôler entièrement le corps, le statut, et les headers de la réponse HTTP retournée par un contrôleur.

33. **Quelle annotation permet de marquer une interface comme un repository Spring Data?**
    - Il n'y a pas d'annotation spécifique comme `@DataRepository`, `@EntityRepository`, ou `@InterfaceRepository` pour marquer une interface comme un repository dans Spring Data. L'annotation `@Repository` est généralement utilisée pour indiquer qu'une interface est un repository, bien qu'elle ne soit pas toujours nécessaire, car Spring Data peut reconnaître automatiquement les interfaces qui étendent `Repository`, `CrudRepository`, ou d'autres sous-interfaces spécifiques.
