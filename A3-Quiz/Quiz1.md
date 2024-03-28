**Évaluation formative - Spring Boot**

*This form will record your name, please fill your name. 90 minutes.*

1. Quelle annotation permet de mapper les requêtes HTTP aux méthodes d'un contrôleur? - (3 Points)  
   A. @GetMapping  
   B. @PostMapping  
   C. @RequestMapping  
   D. @Query

3. Quelle est la différence principale entre Page<T> et Slice<T> dans Spring Data? - (3 Points)   
   A. Page<T> contient des informations sur le nombre total de pages, tandis que Slice<T> ne fournit que les données de la page courante sans calculer le total.   
   B. Slice<T> est utilisé exclusivement pour les données JSON, tandis que Page<T> est pour les données XML.   
   C. Page<T> est obsolète et Slice<T> est la nouvelle API.   
   D. Aucune différence; Page et Slice sont interchangeables.   

5. Quelle annotation est utilisée pour injecter automatiquement les dépendances dans Spring Boot? - (3 Points)
   A. @Inject   
   B. @Autowired   
   C. @Resource   
   D. @Provide   

6. Quelle annotation est utilisée pour définir qu'une classe est une entité JPA? - (3 Points)
   A. @Entity   
   B. @JpaEntity   
   C. @DbEntity   
   D. @Persistable   

7. Comment spécifier une requête JPQL pour chercher des entités tout en supportant la pagination? - (3 Points)
   A. En utilisant @Query au-dessus d'une méthode de repository et en passant Pageable comme paramètre.  
   B. En déclarant une méthode dans le repository avec un retour de type List et en ajoutant manuellement des paramètres de pagination.  
   C. En utilisant @Pagination sur les entités JPA.  
   D. Par l'annotation @EnableJpqlPagination au niveau de la classe d'application principale.  

8. Quelle annotation permet d'activer la découverte de composants dans les packages spécifiés? - (3 Points)
   A. @ComponentScan  
   B. @EnableAutoConfiguration   
   C. @ScanComponents  
   D. @Discover   

9. Quelle annotation est utilisée pour récupérer le corps d'une requête HTTP sous forme d'objet Java? - (3 Points)
   A. @RequestBody   
   B. @RequestPayload   
   C. @InputBody   
   D. @PostBody   

10. Dans JPQL, comment spécifier une clause de pagination pour limiter les résultats d'une requête? - (3 Points)
   A. Ajout de LIMIT et OFFSET à la fin de la requête JPQL   
   B. Utilisation des méthodes setFirstResult() et setMaxResults() sur la Query   
   C. JPQL supporte directement les mots-clés PAGE et SIZE   
   D. La pagination n'est pas supportée en JPQL   

11. Quelle annotation est utilisée dans Spring Boot pour mapper une méthode de contrôleur à une requête HTTP POST? - (3 Points)
   A. @GetMapping  
   B. @PostMapping   
   C. @RequestMapping(method = RequestMethod.POST)   
   D. @SubmitMapping   

12. Dans un repository JPA, quelle interface permet d'implémenter la pagination? - (3 Points)
    A. CrudRepository   
    B. JpaRepository   
    C. PagingAndSortingRepository   
    D. SimpleJpaRepository   

13. Pour spécifier le code de statut HTTP d'une réponse, quelle annotation est utilisée? - (4 Points)
    A. @ResponseStatus   
    B. @HttpCode   
    C. @StatusCode   
    D. @ResponseCode   

14. Quelle annotation est utilisée pour marquer un champ ou une propriété comme la clé primaire d'une entité? - (3 Points)
    A. @PrimaryKey   
    B. @Id   
    C. @Key   
    D. @EntityId  

15. Pour insérer automatiquement la valeur de la clé primaire lors de la persistance d'une entité, quelle annotation utilise-t-on sur le champ id? - (3 Points)
    A. @GeneratedValue(strategy = GenerationType.AUTO)  
    B. @AutoGenerate  
    C. @PrimaryKey  
    D. @IdAuto  

16. Pour mapper les variables de chemin d'une URL, quelle annotation est utilisée? - (3 Points)
    A. @RequestParam  
    B. @PathVariable  
    C. @RequestBody  
    D. @RequestHeader  

17. Quelle annotation est utilisée pour marquer une méthode qui doit être exécutée avant chaque test unitaire

 dans un contexte Spring Boot? - (3 Points)  
    A. @BeforeTest  
    B. @PreTest   
    C. @BeforeEach  
    D. @Before  

16. Qu'est-ce que ResponseEntity dans Spring Boot et à quoi sert-il? - (3 Points)  
    A. Un objet qui représente la réponse HTTP, y compris le statut, les headers, et le corps.  
    B. Une entité JPA pour mapper les tables de base de données.  
    C. Un composant pour injecter des dépendances.   
    D. Un outil pour configurer la sécurité de l'application.   

17. Quelle annotation Spring Boot est utilisée pour déclarer qu'une méthode doit être exécutée après chaque test unitaire? - (3 Points)  
    A. @AfterEach  
    B. @PostTest  
    C. @AfterTest  
    D. @Cleanup  

18. Quelle annotation est utilisée pour marquer une classe comme un composant, permettant à Spring de détecter automatiquement et de gérer le bean? - (3 Points)  
    A. @Bean  
    B. @Component  
    C. @Service  
    D. @Entity  

19. Quelle annotation est utilisée pour marquer une classe Java comme entité JPA? - (3 Points)  
    A. @EntityModel  
    B. @Entity  
    C. @TableEntity  
    D. @JPAEntity  

20. Comment effectuer une pagination dans une requête SQL native avec Spring Data JPA? - (3 Points)  
    A. En utilisant @Query(nativeQuery = true) avec un paramètre Pageable.  
    B. En ajoutant des clauses LIMIT et OFFSET directement dans la requête SQL.  
    C. Il n'est pas possible d'utiliser la pagination avec des requêtes SQL natives.  
    D. En utilisant @NativePagination.  

21. Quelle annotation est utilisée pour définir des tâches à exécuter de manière asynchrone dans Spring Boot? - (3 Points)  
    A. @Async  
    B. @Scheduled  
    C. @EnableAsync  
    D. @Task  

22. Quelle annotation Spring Data est utilisée pour créer automatiquement un bean repository qui interagit avec l'entité spécifiée? - (3 Points)  
    A. @EntityRepository  
    B. @TableRepository  
    C. @Repository  
    D. @DataRepository  
 
23. Quelle annotation permet de spécifier la table de base de données associée à une entité JPA? - (3 Points)  
    A. @Table(name = "nom_de_la_table")  
    B. @EntityTable(name = "nom_de_la_table")  
    C. @DatabaseTable(name = "nom_de_la_table")  
    D. @DbTable(name = "nom_de_la_table")   

24. Quelle annotation est utilisée pour activer la mise en cache dans une application Spring? - (3 Points)  
    A. @Cacheable  
    B. @EnableCaching  
    C. @CacheEvict  
    D. @CachePut  

25. Quelle annotation est utilisée pour gérer les transactions de base de données dans Spring Boot? - (3 Points)  
    A. @Transactional  
    B. @PersistenceContext  
    C. @Entity  
    D. @Query  

26. Quelle annotation marque une classe comme un service dans Spring Boot? - (3 Points)  
    A. @Controller  
    B. @Entity  
    C. @Service  
    D. @Component  

27. Comment retourner une réponse HTTP 404 NOT FOUND en utilisant ResponseEntity? - (3 Points)  
    A. return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    B. return ResponseEntity.notFound().build();  
    C. return ResponseEntity.status(200).body();  
    D. return ResponseEntity.ok();  

28. Quelle annotation est utilisée pour gérer les exceptions spécifiques dans les contrôleurs de Spring Boot? - (3 Points)  
    A. @ErrorHandler  
    B. @ExceptionCatcher  
    C. @ExceptionHandler  
    D. @Catch  

29. Quelle annotation est utilisée pour marquer une classe comme un contrôleur REST dans Spring Boot? - (3 Points)  
    A. @Service  
    B. @RestController  
    C. @Repository  
    D. @Autowired  

30. Quelle méthode ResponseEntity permet de personnaliser entièrement la réponse, y compris le statut, les headers, et le corps? - (3 Points)  
    A. ResponseEntity.ok()  
    B. ResponseEntity.status(HttpStatus.OK)  
    C. ResponseEntity.headers()  
    D. ResponseEntity.body()  

31. Pour mapper une méthode de contrôleur à une requête HTTP GET, quelle annotation est utilisée? - (3 Points)  
    A. @PostMapping  
    B. @GetMapping  
    C. @RequestMapping  
    D. @PutMapping  

32. Quel est le rôle principal de ResponseEntity dans un contrôleur Spring Boot? - (3 Points)  
    A. Exécuter des requêtes de base de données  
    B. Injecter des dépendances dans les beans  
    C. Gérer la pagination des données  
    D. Personnaliser les réponses HTTP  

33. Quelle annotation permet de marquer une interface comme un repository Spring Data? - (3 Points)  
    A. @Repository  
    B. @DataRepository  
    C. @EntityRepository  
    D. @InterfaceRepository  
