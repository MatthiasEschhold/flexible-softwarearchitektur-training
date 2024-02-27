# Lokale Nutzung der Lab-Beschreibung

Für die Beschreibung wird MkDocs verwendet.
Die wichtigsten Command für die lokale Nutzung sind:

* `mkdocs serve` - Start the live-reloading docs server.
* `mkdocs build` - Build the documentation site.
* `mkdocs -h` - Print help message and exit.

# Installation von MkDocs

Siehe [MkDocs Installation Guide](https://www.mkdocs.org/user-guide/installation/).

## Installation unter Ubuntu

### Installation von Python

```java
sudo apt-get install python3
```

### Installation von Pip

```java
sudo apt-get install pip
```

Installation überprüfen:

```java
pip -V
```

## Installation unter Windows

### Installation von Python und Pip

Windows-Installer ist [hier](https://www.python.org/downloads/release/python-3113/) verfügbar.

Installation überprüfen:

```java
pip -V
```

## Installation von MkDocs

```java
pip install mkdocs
```

```java
pip install mkdocs-material
```

```java
pip install mkdocs-material-extensions
```

# Lab-Beschreibung lokal veröffentlichen

```java
mkdocs build
```

```java
mkddocs serve
```

[Open in browser](http://127.0.0.1:8000/hexacleanws/) (http://127.0.0.1:8000/hexacleanws/)