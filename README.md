# ConferenceRoomsReservationSystem
Conference Rooms Reservation System

Cel projektu:
Celem zadania jest zaprojektowanie i implementacja (bardzo uproszczonego) systemu rezerwacji sal konferencyjnych dla dowolnej liczby organizacji w oparciu o zadanie dla grupy Java Backend w ramach Intive Patronage 2019.

1. Zadania przygotowawcze:
   Zadanie nr 1
   Jako programista chciałbym mieć stworzony projekt oparty na Spring Boot. Projekt powinien składać się z następujących zależności
   Web
   Data
   Kod źródłowy powinien znajdować się na wybranym przez siebie repozytorium.
   Projekt powinien dać budować się za pomocą narzędzia Maven
   Zadanie nr 2
   Jako programista chciałbym mieć opracowaną struktur rozwoju projektu, nazwy i rozłożenie pakietów. Ponadto należy opracować strategię pracy w gicie oraz schemat nazewnictwo commitów.

Nazewnictwo branchy:
Gałąź na nowe funkcjonalności: feature/CRRS-ticket_number, gdzie ticket number jest to numer zadania obecnie wykonywanego,np. feature/CRRS-2.4
Gałąź na błędy wykryte po skończeniu wykonywania zadania: fix/CRRS-ticket_number, gdzie ticket_number jest to numer zadania którego dotyczy odkryty błąd,np. fix/CRRS-3.6
Nazewnictwo commitów:
Struktura: git commit -m “prefix(crrs): ticket short description”
Prefix:
feature - dodanie nowej funkcjonalności w ramach zadania
fix - usunięcie błędu w ramach dodawanej funkcjonalności
change - modyfikacja fragmentu dodawanej funkcjonalności
delete - usunięcie fragmentu dodawanej funkcjonalności
test -  dodawanie testów jednostkowych w ramach funkcjonalności
Krótki opis: krótki opis commitu, max do 100 znaków
Schematy pracy z gitem:

Gałęzią domyślna dla codziennej pracy będzie gałąź develop. Każde nowe zadanie ma być realizowane w ramach tzw. Feature branch. Po zakończeniu implementacji każdy feature branch powinien być domergowany z powrotem do gałęzi develop. Po wykonaniu każdej sekcji zadań: organization, conference room, equipment, reservation tworzony będzie tzw. Release branch na którym inkrementowana będzie wersja aplikacji. Następnie Release branch będzie domergowywany z powrotem do gałęzi develop oraz gałęzi master która następnie będzie tagowania (https://git-scm.com/book/en/v2/Git-Basics-Tagging)

Przykład. Programista ma za zadanie dodać implementację dla zadania 2.2. W gałęzi develop znajduje się najbardziej aktualna wersja kodu źródłowego. Programista powinien stworzyć nową gałąź i dokonać wymaganych zmian, a następnie po pozytywnym review kodu powinien scalić swój branch z gałęzią develop.
git checkout -b feature/CRRS-2.2 -> tworzymy nową gałąź na nową funkcjonalność odchodząc od gałęzi develop
Programista implementuje wymaganą funkcjonalność
git add . -> dodajemy wszystkie zmiany do indexu
git commit -m “feature(crrs): implement feature” -> comitujemy wprowadzone zmiany
git push --set-upstream origin feature/CRRS-2.2 -> wysyłamy zmiany na gałąź zdalną tak by były widoczne na serwerze. W przypadku gdy gałąź zdalna już istnieje wystarczy wykonać polecenie git push
git checkout develop -> przechodzimy na gałąź develop w celu zintegrowania zmian z gałęzi feature/CRRS-2.2
git merge feature/CRRS-2.2 -> scalamy zmiany z feature brancha do gałęzi develop
git push -> wysyłamy zmiany lokalne gałęzi develop na gałąź zdalną origin/develop

Nazewnictwo pakietów:

Wszystkie funkcjonalności w ramach projektu powinny się znaleźć w ramach jednego z powyższych pakietów, np. OrganizationController -> organization, ReservationService -> reservation. W ramach każdego z 4 pakietów można grupować klasy w dowolne podpakiety.

Zadanie nr 3
Jako programista chciałbym jest określony schemat bazodanowy uwzględniający wstępne założenia projektu, wraz z określonymi kolumnami tabel oraz rodzaje relacji.



2. Zadania organizacja:
   Zadanie nr 1.
   Jako użytkownik chciałbym mieć możliwość wykonywania podstawowych operacji CRUD dla 
   organizacji. Ponadto każda organizacja powinna być walidowana zgodnie z wymaganiami projektowymi.
   Pakiet organizacja, w którym znajdzie się
   //Klasa modelowa organizacja (nazwa - id, opis)
   //RestController
   //Serwis
   //Repositorium (baza danych H2 i Spring Data)
   //Operacja do zaimplementowania
   //Dodawanie
   //Odczyt
   Edycja
   //Usuwanie
   //Walidacja
   //Swagger
   Zadanie nr 2.
   //Zaimplementuj mechanizm sprawdzania unikalności nazwy organizacji. 
   W systemie może istnieć tylko jedna organizacja o danej nazwie. W przypadku próby duplikacji 
   rekordów użytkownikowi powinien zostać zwrócony kod błędu 400 z odpowiednią wiadomością.
//Zaimplementuj mechanizm umożliwiający wyszukiwanie organizacji po konkretnym identyfikatorze.
//Jako użytkownik chciałbym mieć możliwość sortowania organizacji po nazwie zarówno w kolejności rosnącej 
jak i malejącej.
   Zadanie nr 3.
   Jako klient chciałbym mieć testy jednostkowe i integracyjne sprawdzające poprawność zaimplementowanej funkcjonalności

Testy jednostkowe Repository
Testy jednostkowe Service
Testy jednostkowe Controller
Testy integracyjne


//Zadanie nr 4.

//Obecnie zmiana nazwy organizacji jest niemożliwa, żeby rozwiązać ten problem wprowadź:
//Abstrakcyjne id do modelu Organizations (autogenerowane)
//Name powinno być zwykłym polem klasy z dotychczasową walidacją
//Zmodyfikuj metody serwisu tak by odwoływały się do ID
//Dodaj metodę findByName do repository w celu uzyskania istniejącego rozwiązania



3. Zadania Sala konferencyjna:

Zadanie nr 1.
//Jako użytkownik chciałbym mieć możliwość wykonywania podstawowych operacji CRUD dla sal konferencyjnych. 
Ponadto każda sala konferencyjna powinna być walidowana zgodnie z wymaganiami projektowymi.
//Encja z polami, id, name, identifier, level, availability, numer_of_seats
Serwis - logika biznesowa dla sali konferencyjnej
//Repository - obsługa bazy danych
Controller - obsługa żądań Http: get, post, delete, update
Walidacji  - zgodnie z dokumentem pdf
git
//localhost:8080/h2-console

Zaimplementuj mechanizm sprawdzania unikalności nazwy sali konferencyjnej. W systemie może istnieć tylko jedna sala konferencyjna o danej nazwie. W przypadku próby duplikacji rekordów użytkownikowi powinien zostać zwrócony kod błędu 400 z odpowiednią wiadomością.

Uwzględnij modyfikację encji sali konferencyjnej tak by zawierała relację z organizacją. Daj użytkownikowi możliwość wprowadzania nowych sal konferencyjnych dla danej organizacji.
Zadanie nr 2.
Zaimplementuj mechanizm umożliwiający wyszukiwanie sal konferencyjnych po konkretnym identyfikatorze. Dodatkowo jako użytkownik chciałbym mieć możliwość wyszukiwania sali po nazwie, dostępności, liczby miejsc (bez rozgraniczenia na typ), identyfikatorze, organizacji
Zadanie nr 3.
Jako użytkownik chciałbym mieć możliwość sortowania sal konferencyjnych po nazwie zarówno w kolejności rosnącej jak i malejącej.
Zadanie nr 4.
Jako klient chciałbym mieć testy jednostkowe i integracyjne sprawdzające poprawność zaimplementowanej funkcjonalności.

4. Rezerwacja sal konferencyjnych:
   Zadanie nr 1.

Jako użytkownik chciałbym mieć możliwość wykonywania podstawowych operacji CRUD dla rezerwacji sal konferencyjnych. Każda rezerwacja powinna zawierać informacje takie jak:
Początek rezerwacji
Koniec rezerwacji
Nazwa rezerwacji
Salę konferencyjną do rezerwacji
Unikalne id (UUID)

Dodawanie/aktualizacja rezerwacji:
Czy sala istnieje
Powinniśmy sprawdzać czy sala nie jest zarezerwowana w pokrywających przedziałach czasowych

Api powinno wspierać również następujące rezerwacje:
Usuwanie rezerwacji
Aktualizacje rezerwacji
Pobieranie rezerwacji po
Id sali konferencyjnej
Nazwie sali konferencyjnej
Id rezerwacji
Przedziale czasowym


Zadanie nr 2.

Napisać testy integracyjne dla funkcjonalności rezerwacji:
Dodawanie rezerwacji: unikalnej, już istniejącej
Modyfikacja rezerwacji: na nową, na już istniejącą
Pobieranie rezerwacji: w przedziale czasowym
4. Zadania dodatkowe:
   Zadanie nr 1.
   Zaproponuj mechanizm paginacji danych: https://www.baeldung.com/rest-api-pagination-in-spring


