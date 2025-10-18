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

**Deklaracje (pakiet `drink`):**
- `src/main/java/pl/pollub/coffeecraft/drink/Drink.java` – interfejs produktu (`name()`, `cost()`).
- `src/main/java/pl/pollub/coffeecraft/drink/Espresso.java` – produkt konkretny.
- `src/main/java/pl/pollub/coffeecraft/drink/Americano.java` – produkt konkretny.
- `src/main/java/pl/pollub/coffeecraft/drink/Latte.java` – produkt konkretny.
- `src/main/java/pl/pollub/coffeecraft/drink/DrinkFactory.java` – **Factory Method**: `create(String type)` zwraca odpowiedni `Drink`.

**Użycie:**
- `Main.java`  
  ```java
  Drink latte = new DrinkFactory().create("latte");

2. **Builder** – `OrderBuilder` pozwala tworzyć zamówienia krok po kroku. 

**Deklaracje (pakiet `order`):**

- `src/main/java/pl/pollub/coffeecraft/order/Order.java – agreguje pozycje zamówienia (lista Component) i liczy total().`
- `src/main/java/pl/pollub/coffeecraft/order/OrderItem.java – pojedyncza pozycja (opcjonalna, pomocnicza).`
- `src/main/java/pl/pollub/coffeecraft/order/OrderBuilder.java – Builder z fluent API: withItem(...), withNote(...), build().`

**Użycie:**
- `Main.java`  
  ```java
  Order order = new OrderBuilder()
    .withItem(set)              /
    .withNote("Na wynos")
    .build();

3. **Singleton** – `ConfigSingleton`, `LoggerSingleton` (globalna konfiguracja i logowanie).  

**Deklaracje (pakiet `common`):**

- `src/main/java/pl/pollub/coffeecraft/common/ConfigSingleton.java – Singleton (holder idiom) z walutą i inną konfiguracją.`
- `src/main/java/pl/pollub/coffeecraft/common/LoggerSingleton.java – Singleton do logowania (info(String)).`

**Użycie:**
- `Main.java`  
  ```java
  ConfigSingleton.get().setCurrency("PLN");
  System.out.println("Total: " + order.total() + " " + ConfigSingleton.get().currency());

4. **Prototype** – `RecipePrototype`, `BaseRecipes` (klonowanie receptur kaw).  

**Deklaracje (pakiet `recipe`):**

- `src/main/java/pl/pollub/coffeecraft/recipe/RecipePrototype.java – Prototype (clone() + settery fluent).`
- `src/main/java/pl/pollub/coffeecraft/recipe/BaseRecipes.java – gotowe prototypy (houseLatte(), flatWhite()).`

**Użycie:**
- `Main.java`  
  ```java
  var base = BaseRecipes.houseLatte();
  var mod  = base.clone().shots(base.shots()+1);

5. **Decorator** – `WithExtraShot`, `WithVanilla`, `WithWhippedCream` (dodatki do napojów).  

**Deklaracje (pakiet `addons`):**

-`src/main/java/pl/pollub/coffeecraft/addons/DrinkDecorator.java – abstrakcyjny Decorator (deleguje do Drink).`
- `src/main/java/pl/pollub/coffeecraft/addons/WithExtraShot.java – dekorator (+3.0 do cost()).`
- `src/main/java/pl/pollub/coffeecraft/addons/WithVanilla.java – dekorator (+2.0 do cost()).`
- `src/main/java/pl/pollub/coffeecraft/addons/WithWhippedCream.java – dekorator (+2.5 do cost()).`

**Użycie:**
- `Main.java`  
  ```java
  Drink latte = new DrinkFactory().create("latte");
  latte = new WithExtraShot(latte);           

Każdy dekorator zmienia name() i podnosi cost().

6. **Adapter** – `PayXAdapter`, `PayYAdapter` (ułatwiona integracja z systemami płatności).  

**Deklaracje (pakiet `payment`):**

- `src/main/java/pl/pollub/coffeecraft/payment/PaymentProcessor.java – docelowe API (pay(double)).`
- `src/main/java/pl/pollub/coffeecraft/payment/ExternalPayX.java – „zewnętrzne” API 1 (metoda charge(int cents)).`
- `src/main/java/pl/pollub/coffeecraft/payment/ExternalPayY.java – „zewnętrzne” API 2 (metoda makePayment(BigDecimal)).`
- `src/main/java/pl/pollub/coffeecraft/payment/PayXAdapter.java – Adapter (przelicza złotówki na grosze i woła charge).`
- `src/main/java/pl/pollub/coffeecraft/payment/PayYAdapter.java – Adapter (opakowuje makePayment(BigDecimal)).`

**Użycie:**
- `Main.java`  
  ```java
  PaymentProcessor pay = new PayXAdapter();
  System.out.println("Paid: " + pay.pay(order.total()));

7. **Composite** – `Component`, `SimpleItem`, `Bundle` (pojedyncze pozycje i zestawy traktowane jednakowo).

**Deklaracje (pakiet `bundle`):**

- `src/main/java/pl/pollub/coffeecraft/bundle/Component.java – wspólny interfejs (name(), price()).`
- `src/main/java/pl/pollub/coffeecraft/bundle/SimpleItem.java – Liść (pojedyncza pozycja z ceną).`
- `src/main/java/pl/pollub/coffeecraft/bundle/Bundle.java – Kompozyt (lista Component, metoda add(...), price() sumuje dzieci).`

**Użycie:**
- `Main.java`  
  ```java
  var croissant = new SimpleItem("Croissant", 7.0);
  var set = new Bundle("Breakfast Set")
    .add(croissant)
    .add(new SimpleItem(latte.name(), latte.cost()));

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