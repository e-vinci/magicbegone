# Magic be gone

Petit répertoire qui illustre comment pourraient être implémentées des fonctionnalité de Spring ou de JPA.
L'idée n'est pas que cela soit correct ou complet (ces packages sont bien plus complexes) mais de démontrer qu'il ne s'agit pas de magie et qu'il est possible de construire ces solutions avec les mêmes outils que ceux que l'on utilise au cours.

## Exemple "JPA"

Voir dans la class main - on créer deux modèles simples (Student & Car) et un Repository pour sauvegarder leurs valeurs en base de données.
Le code ne fait aucune connection réele mais se contente de générer les ordres SQLs nécessaires.

### Comment cela fonctionne

Le code fait appel à ce qu'on nomme la "Reflection" an Java - la capacité de récupérer des infomrations sur la structure (Classe) ou le contenu (Instances, attributes) d'objets.

