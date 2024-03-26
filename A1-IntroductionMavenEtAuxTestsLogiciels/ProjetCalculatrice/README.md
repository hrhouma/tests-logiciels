# 1 - Instrcutions
```bash
git clone https://github.com/hrhouma/tests-unitaires-junit4.git
cd tests-unitaires-junit4
mvn clean 
mvn install
mvn clean install 
mvn test
mvn package
mvn clean package -DskipTests
mvn site
mvn deploy
```
# 2 - Explications

Maven est un outil de gestion et d'automatisation de projet pour Java, et ces commandes sont couramment utilisées pour gérer le cycle de vie d'un projet.

### `mvn clean`

- **Objectif :** Supprime les fichiers générés dans le dossier `target` du projet. Cette commande assure que votre prochaine construction sera réalisée à partir d'un état propre, sans aucun artefact des constructions précédentes.
  
### `mvn install`

- **Objectif :** Compile le code source du projet, exécute les tests, et place le package généré dans votre dépôt Maven local. Cela rend le package disponible pour d'autres projets Maven sur votre machine.

### `mvn clean install`

- **Objectif :** Combiner les deux commandes précédentes. Elle nettoie d'abord le projet en supprimant les fichiers générés précédemment dans le dossier `target`, puis compile le code source, exécute les tests, et installe le package dans votre dépôt Maven local.

### `mvn test`

- **Objectif :** Exécute les tests unitaires du projet en utilisant un framework de test comme JUnit ou TestNG. Les tests sont définis dans le dossier `src/test/java`.

### `mvn package`

- **Objectif :** Compile le code source du projet, exécute les tests, et crée un package (par exemple, un fichier JAR ou WAR) dans le dossier `target`. Cette commande ne déploie pas le package dans le dépôt Maven local.

### `mvn clean package -DskipTests`

- **Objectif :** Cette commande combine l'action de nettoyage et de packaging, mais elle saute l'exécution des tests. L'option `-DskipTests` est utilisée pour accélérer le processus de construction lorsque l'on sait que les tests ont déjà été passés ou lorsque les tests ne sont pas pertinents pour la tâche en cours.

### `mvn site`

- **Objectif :** Génère un site web pour le projet qui contient des rapports sur l'état du projet, la documentation Javadoc, les métriques de qualité du code, les résultats des tests, et d'autres informations pertinentes. Ce site est utile pour la documentation et l'analyse de la qualité du projet.

### `mvn deploy`

- **Objectif :** Compile le code source du projet, exécute les tests, package le projet et déploie le package généré dans un dépôt Maven distant configuré. Cette commande est utilisée pour partager le package avec d'autres développeurs et projets. Elle nécessite que la configuration du dépôt distant soit définie dans le fichier `pom.xml` du projet, souvent dans la section `distributionManagement`.

Ces commandes représentent les étapes courantes du cycle de vie de construction d'un projet Maven. Elles permettent aux développeurs de gérer efficacement les dépendances, de compiler le code, d'exécuter des tests, de générer de la documentation, et de déployer des artefacts, le tout de manière standardisée et automatisée.

# 3 - Différences entre Les commandes Maven `mvn package`, `mvn install`, et `mvn site` 

Ces commandes servent des objectifs différents dans le cycle de vie d'un projet Maven. 

### `mvn package`

- **Objectif :** Compile le code source du projet, exécute les tests unitaires et package le code compilé dans son format distribuable, tel qu'un fichier JAR pour les bibliothèques ou WAR/EAR pour les applications web, sans l'installer dans le dépôt Maven local. Cela signifie que le package peut être utilisé localement mais n'est pas accessible aux autres projets Maven sur votre machine.
- **Usage typique :** Quand vous souhaitez générer rapidement un artefact pour le tester ou le déployer manuellement sans affecter votre dépôt Maven local.

### `mvn install`

- **Objectif :** Effectue toutes les étapes de `mvn package` et, en plus, installe l'artefact dans votre dépôt Maven local. Cela rend l'artefact accessible pour d'autres projets Maven sur votre machine, leur permettant d'ajouter l'artefact comme dépendance.
- **Usage typique :** Quand vous développez plusieurs projets en parallèle et que l'un dépend de l'artefact de l'autre. Installer l'artefact permet aux projets de se référer à la version locale sans avoir besoin de la déployer dans un dépôt distant.

### `mvn site`

- **Objectif :** Génère un site web pour votre projet qui contient divers rapports comme la documentation Javadoc, les résultats des analyses de qualité de code, les résultats des tests, et d'autres informations utiles pour les développeurs et les parties prenantes. Ce site est généré dans le dossier `target/site` du projet.
- **Usage typique :** Pour la documentation du projet et l'analyse de la qualité du code. Le site généré peut être consulté localement ou déployé sur un serveur pour être accessible à une équipe plus large.

### Différences Clés

- **Finalité :** `mvn package` et `mvn install` sont liés à la préparation et à la disponibilité de l'artefact pour une utilisation ultérieure, soit localement (`package`), soit dans des projets Maven locaux (`install`). `mvn site`, en revanche, concerne la génération de documentation et de rapports pour le projet.
- **Résultat :** `package` génère un artefact (e.g., JAR, WAR) mais ne l'ajoute pas au dépôt local, tandis que `install` le fait. `site` produit un ensemble de documents HTML et n'affecte pas la génération ou l'installation d'artefacts.
- **Utilisation :** `package` et `install` sont souvent utilisés dans le développement et la distribution de logiciels, tandis que `site` est utilisé pour la génération de documentation et de rapports sur le projet.

En résumé, `mvn package` et `mvn install` sont utilisés pour gérer les artefacts d'un projet, tandis que `mvn site` est utilisé pour la génération de documentation et de rapports.


```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=calculator -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
mvn test 
mvn clean package -DskipTests
mvn test -Dtest=CalculatriceTest#testConcatenateMots_succes1
mvn test -Dtest=CalculatriceTest#testConcatenateMots_succes1 -Dsurefire.failIfNoSpecifiedTests=false 
```
