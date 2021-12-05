# Projekt konkursowy monitorowania jednostek morskich - konkurs CTM

## O Aplikacji:
* Technologie: 
- Backend: Spring Boot, Hibernate, JUnit
- Baza danych: Postgres
  - Dla niektórych zapytań dodano CACHE
- Frotend: Thymeleaf, HTML, JavaScript,
- Mapy: leaflet
- Obrazy: Google Programmable Search Engine: https://programmablesearchengine.google.com/about/
  - Skonfigurowany pod adresy: ![image](https://user-images.githubusercontent.com/30650024/144754602-ea8cd71b-2edb-4ea5-b855-1a7c53707028.png)
- API AIS: https://www.barentswatch.no/
- Cron - Schedule: Spring 
- Docker:
  - Docker compose:
    - Api: Obraz aplikazji
    - pgdb: Obraz bazy danych PostgreSQL (latest)
      - Baza danych odtwarzana jest z inicjalnego sql: backup3.sql  
      - Zainicjalizowana jest danymi o portach i rodzajach statków z AIS, które pochodza z darmowych i otwarych baz danych

   
## Prezentacja podstawowych ekranów: 
### Strona główna:
* Aplikacja wycentrowana jest na Oslo i domyślne wyświetlane sa tylko te statki, dla których znane jest położenie:
  - ![image](https://user-images.githubusercontent.com/30650024/144754638-249444c0-cd48-47cf-adaf-c51a63f2150a.png)
  - Możliwe jest właczenie warstwy pozwalajacej zobaczyc wszystkie statki:
    - ![image](https://user-images.githubusercontent.com/30650024/144754678-28e24794-4c62-4832-a2ed-bc908665f08d.png)
  - Po najechaniu kursorem na znacznik statku rysowana jest linia do portu docelowego
  - Po kliknięciu w znacznik statku prezentowane sa skrócone informacje 
  - Po klknięciu w link About this vessel przekierowuje nas na ekran widoku szczegółowego o statku
  - Po kliknięciu w link See Destination przesuwa mapę do portu docelowego, zachowujac niebieska linię, która do niego kieruje, po kolejnym kliknięciu usuwa tę linię. 
    -   ![image](https://user-images.githubusercontent.com/30650024/144754944-2fc53a7d-62a6-467e-ba5e-27eabc7b8674.png)
    -   ![image](https://user-images.githubusercontent.com/30650024/144754949-c68d29c7-db97-4ae3-baa1-ef155d07d9c4.png)
  - Po kliknięciu w znacznik portu pokazywane sa podstawowe informacje o porcie
  - Po klknieciu w About this port przekierowuje nas do ekranu widoku szczegółowego o porcie

### Strona widoku szczegółowego o statku: 
- Przykład statku BALTIYSKIY zmierzejacego do portu Gdynia:
  - Nazwa i zdjęcie:
    -  ![image](https://user-images.githubusercontent.com/30650024/144755050-0491997a-6c74-4ee3-b7d6-010d1a85c01c.png)
  - Podstawowe informacje:
    - ![image](https://user-images.githubusercontent.com/30650024/144755086-26caf1e1-aa4b-419a-b677-2cc6c1c0421c.png)
  - Historia pozycji statku na podstawie danych z bazy:
    - ![image](https://user-images.githubusercontent.com/30650024/144755117-7f5c5876-0125-4565-af00-aacd207a85ec.png)
   - Zarejestrowane pozycje:
     -  ![image](https://user-images.githubusercontent.com/30650024/144755138-cde4042c-1d4c-41bc-8398-d843e09a6ff3.png)

### Strona widoku szczegóówego o porcie:
- Przykład strony widoku szczegółowego o porcie Gdynia: 
  - Nazwa i zdjęcie portu:
    - ![image](https://user-images.githubusercontent.com/30650024/144755208-bedd9f69-9f4b-4cdd-8b30-92002bc52d72.png)
  - Informacje o porcie: 
    - ![image](https://user-images.githubusercontent.com/30650024/144755237-a3c8218d-4218-4ff8-a95d-b421660d3985.png)

## Podstawowe funkcjonalności i założenia:
* Dostępna jest mapa pozwalająca na podgląd jednostek
* Markery na mapie dzięlą się na niebieskie - statki i czarne - porty
* Po lewej stronie ekranu dostępny jest filtr warstw, aby pokazać/ukryć statki dla których jesteśmy w stanie okreslić port docelowy
* Najechanie na znak statku pokazuje jego trasę(w linii prostej) do portu docelowego
* Kliknięcie w znak statku pokazuje jego postawowe informacje:
  * Nazwa
  * Typ
  * Port docelowy
  * "O statku" - Link przekierowujący do strony szczegółowej o statku
  * Zobacz cel - Link, który powoduje przemieszczenie się na mapie do portu docelowego
* Kliknięcie w znak portu pokazuje jego postawowe informacje:
  * Nazwa portu: 
  * Rodzaj portu: Sea
* Kliknięcie w About this vessel otwiera nową stronę z informacjami o statku:
  * Podstawowe informacje
  * Zdjęcie statku znalezione przez Google Search
  * Informacja o statku uzyskane z https://www.barentswatch.no/ oraz bazy danych
  * Tabela z informacjami i ostatnich znanych pozycjach statku
  * Mapa nakreślająca punkty przemieszczania się statku na podstawie danych z bazy
* W tle aplikacja co 15 minut (Schedule + cron) odczytuje położenie wszystkich statków (w obszarze Norwegii) i zapisuje ich dane do bazy
* Zapisane dane z bazy o położeniu statkow prezentowane sa na ekranie localhost:8080/vessels/{MMSI}
* Kliknięcie w About this port otwiera nową stronę z informacjami o porcie:
  * Podstawowe informacje
  * Zdjęcie portu znalezione przez Google Search
  * Informacje o porcie uzyskane z bazy


## Jak uruchomić:
Prerekwizyt: Docker
* Uruchomienie:
  * `docker-compose -up`
    
## Linki
- HomePage: 
http://localhost:8080/

- Przykład strony o statku:
http://localhost:8080/vessels/259983000

- Przykład strony o porcie:
http://localhost:8080/port/16718



