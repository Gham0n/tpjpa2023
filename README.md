# TAA - Un doctolib

## Authors

- [Hamon Guillaume](https://github.com/Gham0n/tpjpa2023)
- [Léo Nolière](https://github.com/LeoNoliere)

## Description du projet

On souhaite développer l'application suivante de type prise de RDV pour tout professionnel. Chaque professionnel de l’application pourra se créer un compte, se loguer, mettre à disposition l’url de récupération des créneaux disponibles, définir la durée nominal d’un RDV et les intitulés possibles d’un RDV.
Un utilisateur souhaitant consulter un professionnel pourra aussi se créer un compte, se loguer et consulter la liste des créneaux disponibles et réserver un créneau.

## Installation

#### TP1 - Mapping Relationnel

Nous avons donc plusieurs entitées:

- Les medecins (Nom)
- Les patients(Nom)
- Les rendez-vous (Date+Heure, l'intitulé du rdv, le medecin, le patient)
- Les intitulés (Urgence, Ordonance, Consultation classique)

Nous pouvons voir notre base de données fonctionelle sur `show-hsqldb` et qui tourne sur `run-hsqldb-server`. nous pouvons afficher ou modifier manuellement des données.

- [x] Entités
- [x] DAO
- [x] Base de données SQL

#### TP1 - Mapping Relationnel

---

#### TP2 - Servlett - API Rest - OpenAI

Nous pouvons donc envoyer et/ou recevoir des données depuis l'URL que nous entrons.

L'API marche mais nous ne l'avons pas developpé.

- [x] Servlett
  > NOTE: les servlets ont été remplacés par l'API Rest
- [x] API Rest
- [x] OpenAPI

#### TP2 - Servlett - API Rest - OpenAI

---

#### TP3 - Spring

La partie Spring a bien été ajoutée

- [x] Injections de dépendances
- [x] Spring AOP
- [x] Spring data / Spring boot

#### TP3 - Spring

---

#### TP4 - Keycloak

Nous avons réussi à configurer le domaine, à creer les utilisateurs, cependant, nous n'avons pas terminé.

Notre code compile correctement et se lance mais nous avons un soucis, nous arrivons correctement à acceder a l'indexmain, mais lorsque nous voulons aller dans la page reserver aux users ou aux admins, nos pages ne sont pas disponibles.

Nous avons rencontrés des problèmes de configuration sachant que nous étions sous Windows et sans accès à docker.

- [x] Configurer le domaine
- [x] Creer les utilisateurs
- [ ] Adaptation à notre code

#### TP4 - Keycloak

---


---