# 🛵 Gestion d'un Parc de Scooters

> Projet académique — Application de bureau Java (Swing) pour la gestion d'un parc de scooters en location : marques, modèles, clients, permis et flotte de véhicules.

---

## Contexte

Projet réalisé en binôme dans le cadre d'un cours de **programmation orientée objet en Java**.  
L'objectif était de modéliser et implémenter un système de gestion de parc de scooters en appliquant le patron **MVC** (Modèle - Vue - Contrôleur) et les principes fondamentaux de la POO (encapsulation, associations, composition).

> Fork du projet original : [Ghiles-Mansouri/GestionDunParcPourScooters](https://github.com/Ghiles-Mansouri/GestionDunParcPourScooters)

---

## Table des matières

- [Architecture MVC](#architecture-mvc)
- [Modèle de données](#modèle-de-données)
- [Fonctionnalités](#fonctionnalités)
- [Structure des fichiers](#structure-des-fichiers)
- [Prérequis & lancement](#prérequis--lancement)

---

## Architecture MVC

```
GestionParcPourScooters/
├── Model/           ← Entités métier (Parc, Scooter, Client…)
├── Contrôleurs/     ← Logique applicative, gestion des actions
├── vue/             ← Interface graphique Swing
└── Application.java ← Point d'entrée, initialisation des données
```

```
Application.java
      │
      ▼
  new Parc(...)
      │
      ├── addMarque(Yamaha, Honda, BMW…)
      │       └── addModele(XMAX, TMAX, ZIP50…)
      │
      ├── addClient(...)
      │       └── addPermis(A, B, A1…)
      │
      ├── addScooter(S001…S0010)
      │
      └── new FenetrePrincipale(parc)  ←  lance l'interface
```

---

## Modèle de données

| Classe | Description | Attributs principaux |
|---|---|---|
| `Parc` | Conteneur principal de la flotte | nom, capacité, adresse |
| `Marque` | Constructeur (Yamaha, Honda…) | nom, liste de modèles |
| `Modele` | Référence d'un scooter | code, marque, permis requis |
| `Scooter` | Véhicule individuel de la flotte | immatriculation, modèle |
| `Client` | Locataire inscrit au parc | nom, prénom, téléphone, permis |
| `Permis` | Permis de conduire du client | code, catégorie (A / B / A1) |

### Relations

```
Parc ──< Marque ──< Modele ──< Scooter
                       │
                    Permis (requis)
                       │
                    Client ──< Permis (possédés)
```

Un `Modele` peut exiger un permis particulier (ex. XMAX → A1, TMAX → B).  
Un `Client` peut posséder plusieurs permis de catégories différentes.

### Données d'exemple incluses

Au démarrage, l'application charge automatiquement :

- **1 parc** : *Parc des fenecs*, 10 places, 9 boulevard d'Algérie 75019
- **5 marques** : Yamaha, Honda, BMW Motorrad, Peugeot, Piaggio
- **5 modèles** : MOD001, MOD002, ZIP50, XMAX, TMAX
- **10 scooters** : S001 à S0010
- **3 catégories de permis** : A, B, A1

---

## Fonctionnalités

- Visualisation de la flotte complète (scooters, modèles, marques)
- Gestion des clients et de leurs permis
- Association permis requis / modèle (vérification d'éligibilité à la location)
- Interface graphique Swing avec fenêtre principale interactive

---

## Structure des fichiers

```
GestionParcPourScooters/
├── Application.java         # Point d'entrée, données d'initialisation
├── Application.class        # Bytecode compilé
├── Model/
│   ├── Parc.java
│   ├── Marque.java
│   ├── Modele.java
│   ├── Scooter.java
│   ├── Client.java
│   └── Permis.java
├── Contrôleurs/
│   └── (contrôleurs MVC)
└── vue/
    └── FenetrePrincipale.java   # Fenêtre principale Swing
```

---

## Prérequis & lancement

**Prérequis :** Java 11+

### Compilation

```bash
javac -d . Application.java Model/*.java Contrôleurs/*.java vue/*.java
```

### Exécution

```bash
java Application
```

L'interface graphique s'ouvre directement avec le parc pré-rempli.

---

## Auteurs

- [naitkaci-anis](https://github.com/naitkaci-anis)
- [Ghiles-Mansouri](https://github.com/Ghiles-Mansouri)

---

## Licence

MIT
