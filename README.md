# ☕ CoffeeCraft – Wzorce Projektowe

---

## Struktura projektu

- **app** – zawiera klasę `Main`, która demonstruje działanie wszystkich wzorców w praktyce.  
- **addons** – implementuje wzorzec **Decorator** (dodatki do kaw, np. `WithExtraShot`, `WithVanilla`, `WithWhippedCream`).  
- **bundle** – implementuje wzorzec **Composite** (zestawy kawowe i pojedyncze elementy).  
- **common** – implementuje wzorzec **Singleton** (`ConfigSingleton` i `LoggerSingleton`).  
- **drink** – implementuje wzorzec **Factory Method** (`DrinkFactory` tworzy napoje: `Latte`, `Espresso`, `Americano`).  
- **order** – implementuje wzorzec **Builder** (`Order`, `OrderItem`, `OrderBuilder`).  
- **payment** – implementuje wzorzec **Adapter** (adaptery `PayXAdapter`, `PayYAdapter` dla różnych systemów płatności).  
- **recipe** – implementuje wzorzec **Prototype** (`RecipePrototype`, `BaseRecipes` – klonowanie receptur).  
- **test** – testy jednostkowe dla kluczowych wzorców (Decorator, Composite, Adapter, Prototype).

---

## Zaimplementowane wzorce

1. **Factory Method** – `DrinkFactory` tworzy napoje (`Latte`, `Espresso`, `Americano`).  
2. **Builder** – `OrderBuilder` pozwala tworzyć zamówienia krok po kroku.  
3. **Singleton** – `ConfigSingleton`, `LoggerSingleton` (globalna konfiguracja i logowanie).  
4. **Prototype** – `RecipePrototype`, `BaseRecipes` (klonowanie receptur kaw).  
5. **Decorator** – `WithExtraShot`, `WithVanilla`, `WithWhippedCream` (dodatki do napojów).  
6. **Adapter** – `PayXAdapter`, `PayYAdapter` (ułatwiona integracja z systemami płatności).  
7. **Composite** – `Component`, `SimpleItem`, `Bundle` (pojedyncze pozycje i zestawy traktowane jednakowo).

---

## Uruchamianie

1. **Sklonuj repozytorium**
   ```bash
   git clone https://github.com/https://github.com/Zoltig/coffeecraft.git
   cd coffeecraft

2. **Zbuduj projekt**
   ```bash
   mvn clean install

3. Uruchom aplikację (Main demo)
    ```bash
   mvn exec:java


## Testy jednostkowe

Projekt używa JUnit 5.

Testowane wzorce:
- Decorator – sprawdzenie, czy dodatki zwiększają cenę.
- Composite – suma cen w zestawie.
- Adapter – wywołanie poprawnej metody płatności.
- Prototype – niezależność kopii przepisu.

**Zbuduj projekt**
   ```bash
   mvn test