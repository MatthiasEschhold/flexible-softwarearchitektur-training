# Domain Service Pattern des Domain Ring

##  Domain Service Pattern

Ein _Domain Service_ implementiert Business Logik, die keinem Domänenobjekt zugeordnet werden kann, oder 
wenn für die Ausführung der Business Logik zusätzlich Abhängigkeiten aufgebaut werden müssen, die den 
Abhängigkeitsregeln eines Domänenobjekts widersprechen würden

## Anwendungsfall Risikobewertung und Diebstahlprüfung

### Coding Task 4

<b>Implementiere den TheftRiskRatingService</b>
<br/>
<ol>
<li>Erstelle das Package <i>domain.service</i> als Subpackage von <i>vehicle</i> und erstelle den Domain Service <i>TheftRiskRatingService</i></li>
<li>Integriere die Risikobewertung in den Anlageprozess für ein Fahrzeug</li>
<li>Betrachte das ausgebaute Domänenmodell in <i>domain.service</i> und nutze die Domänenobjekte</li>
<li>Wird ein Risikobewertung > 60 Risikopunkte ermittelt, muss eine Diebstahlabfrage bei Interpol durchgeführt werden</li>
<li>Ergänze Use Case und Adapter Implementierung für die Diebstahlabfrage bei Interpol, für die Abfrage von Risikoländer sowie -marken</li>
</ol>
<br/>

<details>
   <summary>User Story Risikobewertung Fahrzeudiebstahl nach §0815a</summary>

Als Produktmanager möchte ich, dass die Risikobewertung für ein Fahrzeug im Anlageprozess durchgeführt wird.
Die Risikobewertung folgt dem im folgenden beschriebenen Regelwerk:

<ol>
<li></li>
</ol>

<i>Akzeptanzkriterien</i>:
<ol>
<li></li>
</ol>

</details>


<details>
   <summary>Erweitere Risikobewertung auf Basis von Risikoländer und Risikomarken für die Risikobewertung nach §0815a</summary>

Als Produktmanager möchte dich die Risikobewertung nach §0815a mit der Berücksichtigung von Risikoländern und -marken erweitern.

<ol>
<li></li>
</ol>

<i>Akzeptanzkriterien</i>:
<ol>
<li></li>
</ol>

</details>

<b>Weitere Informationen zur Risikobewertung und Diebstahlabfrage bei Interpol:</b>

<details>
      <summary>Use Case Diebstahlabfrage Interpol</summary>

   ```java
public interface DetectInterpolTheftStatus {
    TheftStatus detect(Vin vin, LicensePlate licensePlate);
}
   ```
</details>

<details>
      <summary>Use Case Abfrage Risikoländer</summary>

   ```java
public interface FetchHighRiskCountries {
    HighRiskCountries fetch();
}
   ```
</details>

<details>
      <summary>Use Case Abfrage Risikomarken</summary>

   ```java
public interface FetchHighRiskVehicleModels {
    HighRiskVehicleModels fetch();
}
   ```
</details>