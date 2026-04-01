# Question (Ex1) : 
> Une méthode default dans une interface peut-elle accéder aux champs privés de la classe qui l'implémente ? 
> Justifiez, en vous appuyant sur isDefective() dans Qualifiable et getQualityScore() dans Duck.

Une méthode `default` n'a pas accès aux champs de la classe implémentante directement.
Elle peut cependant accéder aux autres méthodes définies par l'interface, dont l'implémentation fournit les champs privés.
Ex : Qualifiable.isDefective utilise Qualifiable.getQualityScore(), implémentée dans Duck qui fournit le champ qualityScore.