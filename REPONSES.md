# Question (Ex1) : 
> Une méthode default dans une interface peut-elle accéder aux champs privés de la classe qui l'implémente ? 
> Justifiez, en vous appuyant sur isDefective() dans Qualifiable et getQualityScore() dans Duck.

Une méthode `default` n'a pas accès aux champs de la classe implémentante directement.
Elle peut cependant accéder aux autres méthodes définies par l'interface, dont l'implémentation fournit les champs privés.
Ex : Qualifiable.isDefective utilise Qualifiable.getQualityScore(), implémentée dans Duck qui fournit le champ qualityScore.

# Question (Ex2) :
> Dans ce projet, Maintainable est une interface et Machine est une classe abstraite. 
> Quelle règle Java vous aurait empêché de faire l'inverse 
> (rendre Maintainable abstraite et Machine une interface) ? 
> Plus généralement, quand choisit-on une interface plutôt qu'une classe abstraite ?

On choisit une interface pour exprimer une relation de type "sait-faire" plutôt que "est-un" pour une classe.
Maintenable a peu à gagner à devenir une classe abstraite, et Machine en tant qu'interface serait appauvrie car 
elle n'aurait pas les champs nécessaires à son fonctionnement.

# Question (Ex4) : 
> Expliquez pourquoi canBeFulfilled(Stock<Duck> stock) serait une signature plus restrictive que 
> canBeFulfilled(Stock<? extends Duck> stock). 
> Donnez un exemple de code Java qui compilerait avec la seconde mais pas avec la première.

La première option va nous permettre de lire dans un Stock contenant exclusivement des Duck,
tandis que la seconde accepterait des Stock<MiniDuck> par exemple.

