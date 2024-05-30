<h1>Wetterstation Backend</h1>
Andreas Dötzl und  Jasmin Feichtinger

<h2> Technische Beschreibung </h2>

Für eine Microservice-Architektur werden mehrere Komponenten benötigt. 
Es wird dafür ein Discovery Service, Gateway Service, Load Balancer, Konfigurationsserver und zumindest ein Miroservice benötigt. 
Für die Kommunikation zwischen Client und den Service wurde REST-API verwendet. 
Folgend finden Sie eine kurze Beschreibung der einzelnen Komponenten.

<h3>Discovery Service (EUREKA) </h3>
Alle Dienste registrieren sich beim Discovery Service, dadurch haben sie die Möglichkeit sich gegenseitig zu finden und miteinander zu kommunizieren, ohne den Port und den Hostnamen bei jeden manuell hinterlegen zu müssen. 
Der Discovery Service, weiß genau wo welcher Service liegt, und verbindet die Service dann dementsprechend weiter. 

<h3>Gateway Service</h3>
Es handelt sich um ein API-Management-Tool. 
Der Gatway nimmt die API-Aufrufe des Clients entgegen und leitet sie an die einzelnen Service weiter. 

<h3>Load Balancer</h3>
Der Load Balancer kümmert sich um die Lastenverteilung. 
Verteilt die Anfragen so, dass kein Server überlastet wird.

<h3>Konfigurationsserver / Config Service</h3>
Im Konfigurationsserver werden Informationen für mehrere Service gespeichert. 
Dadurch muss man nicht bei jedem einzelnen Service die Information manuell hinterlegen. 
Man, könnte hier zum Beispiel hinterlegen, wie man die Datenbank erreichen kann. 

<h3>Microservice</h3>
Es wird versucht Geschäftsfunktionalität in mehrere unabhängigen kleinen Funktionen aufzuteilen. 
Dadurch entstehen mehrere Microservice die unabhängig voneinander verwaltet oder aktualisiert werden können. 
Die Microservice stellen eine API zur Verfügung, über die andere Komponenten mit den Diensten kommunizieren können. 

<h3>REST-API</h3>
API ist ein Satz von Befehlen den der Client eingeben muss, um mit einem externen Programm zu kommunizieren. 
REST (Representatation State Transfer) ist eine standardisierte Architektur wie diese Befehle eingegeben werden müssen. 
REST-API ist ein einfacher Weg um mit den Service zu interagieren. 
Man braucht sich dadurch keine Sorgen zu machen, wie die Daten sind oder wie man eine Anfrage sendet. 


<h2> Starten des Programmes: </h2>

Man benötigt einen lokale Datenbank, um das Programm ausführen zu können.
Die Daten gehören dann im GitHub Repository "ha-microservice-architecture-config-server-feichtinger_doetzl/weather-ws.properties" dementsprechend geändert.
1) DiscoveryService-Eureka starten
2) ConfigServer starten
3) APIGateway starten
4) RestfulAPI starten


<h2> Pitfalls: </h2>

1) Swagger UI: springdoc-openapi-data-rest Lib eingebunden, aber die springdoc-openapi-ui fehlt und dadurch beendete sich die JVM.
1) Config Server Datei
    1) GitHub Repsotory privat ungeignent, da jeder Teilnehmer, den Token zum anlegen von Repostories erhält und im Namen eines andern welche
    erstellen kann.
    1) Die Datei Local erstellen, bedeute, jeder Teilnemer muss die Datei local erstellen und den Code dafür ändern
    wäre OK wenn alle Local gemeinsam darauf arbeiten.
    1) GitHub Repsotory public, hat jeder einsicht, in der Arbeitswelt nicht geeignet
1) H2 Datenbank ist nicht für die Anwendung von zwei Instanzen möglich. Daher Änderung von H2 auf locale Datenbank

<h2> Durchführung Beispiele </h2>
Unter "BeispielFuerDieDurchfuehrung.pdf" haben wir die CRUD funktionen durchführt und mit Screenshots dokumentiert.
Wir haben unsere Abrufe mit Postman durchgeführt.

<h2> Quellenverzeichnis: </h2>

Grundgerüst gebildet mit folgendem Link:
https://spring.io/guides/gs/accessing-data-rest/

Erweitere H2 Features:
1) Diverse Einstellungen https://www.baeldung.com/spring-boot-h2-database
1) JPA und H2 Settings https://www.bezkoder.com/spring-boot-jpa-h2-example/
1) Speichern der H2 Daten https://www.baeldung.com/h2-embedded-db-data-storage
1) Swagger-UI Integration  https://springdoc.org/

Erstellung Locale Datenbank:
1) Download: https://www.postgresql.org/download/windows/
1) Anleitung: https://www.postgresqltutorial.com/postgresql-getting-started/install-postgresql/

Gateway, Config Server, Discovery Service implementiert mit folgender online Schulung:
https://www.udemy.com/course/spring-boot-microservices-and-spring-cloud/
