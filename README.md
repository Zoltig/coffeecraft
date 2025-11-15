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
- `/drink/Drink.java` – interfejs produktu (`name()`, `cost()`).
- `/drink/Espresso.java` – produkt konkretny.
- `/drink/Americano.java` – produkt konkretny.
- `/drink/Latte.java` – produkt konkretny.
- `/drink/DrinkFactory.java` – **Factory Method**: `create(String type)` zwraca odpowiedni `Drink`.

**Użycie:**
- `Main.java`  
  ```java
  Drink latte = new DrinkFactory().create("latte");

2. **Builder** – `OrderBuilder` pozwala tworzyć zamówienia krok po kroku. 

**Deklaracje (pakiet `order`):**

- `/order/Order.java – agreguje pozycje zamówienia (lista Component) i liczy total().`
- `/order/OrderItem.java – pojedyncza pozycja (opcjonalna, pomocnicza).`
- `/order/OrderBuilder.java – Builder z fluent API: withItem(...), withNote(...), build().`

**Użycie:**
- `Main.java`  
  ```java
  Order order = new OrderBuilder()
    .withItem(set)              /
    .withNote("Na wynos")
    .build();

3. **Singleton** – `ConfigSingleton`, `LoggerSingleton` (globalna konfiguracja i logowanie).  

**Deklaracje (pakiet `common`):**

- `/common/ConfigSingleton.java – Singleton (holder idiom) z walutą i inną konfiguracją.`
- `/common/LoggerSingleton.java – Singleton do logowania (info(String)).`

**Użycie:**
- `Main.java`  
  ```java
  ConfigSingleton.get().setCurrency("PLN");
  System.out.println("Total: " + order.total() + " " + ConfigSingleton.get().currency());

4. **Prototype** – `RecipePrototype`, `BaseRecipes` (klonowanie receptur kaw).  

**Deklaracje (pakiet `recipe`):**

- `/recipe/RecipePrototype.java – Prototype (clone() + settery fluent).`
- `/recipe/BaseRecipes.java – gotowe prototypy (houseLatte(), flatWhite()).`

**Użycie:**
- `Main.java`  
  ```java
  var base = BaseRecipes.houseLatte();
  var mod  = base.clone().shots(base.shots()+1);

5. **Decorator** – `WithExtraShot`, `WithVanilla`, `WithWhippedCream` (dodatki do napojów).  

**Deklaracje (pakiet `addons`):**

-`/addons/DrinkDecorator.java – abstrakcyjny Decorator (deleguje do Drink).`
- `/addons/WithExtraShot.java – dekorator (+3.0 do cost()).`
- `/addons/WithVanilla.java – dekorator (+2.0 do cost()).`
- `/addons/WithWhippedCream.java – dekorator (+2.5 do cost()).`

**Użycie:**
- `Main.java`  
  ```java
  Drink latte = new DrinkFactory().create("latte");
  latte = new WithExtraShot(latte);           

Każdy dekorator zmienia name() i podnosi cost().

6. **Adapter** – `PayXAdapter`, `PayYAdapter` (ułatwiona integracja z systemami płatności).  

**Deklaracje (pakiet `payment`):**

- `/payment/PaymentProcessor.java – docelowe API (pay(double)).`
- `/payment/ExternalPayX.java – „zewnętrzne” API 1 (metoda charge(int cents)).`
- `/payment/ExternalPayY.java – „zewnętrzne” API 2 (metoda makePayment(BigDecimal)).`
- `/payment/PayXAdapter.java – Adapter (przelicza złotówki na grosze i woła charge).`
- `/payment/PayYAdapter.java – Adapter (opakowuje makePayment(BigDecimal)).`

**Użycie:**
- `Main.java`  
  ```java
  PaymentProcessor pay = new PayXAdapter();
  System.out.println("Paid: " + pay.pay(order.total()));

7. **Composite** – `Component`, `SimpleItem`, `Bundle` (pojedyncze pozycje i zestawy traktowane jednakowo).

**Deklaracje (pakiet `bundle`):**

- `/bundle/Component.java – wspólny interfejs (name(), price()).`
- `/bundle/SimpleItem.java – Liść (pojedyncza pozycja z ceną).`
- `/bundle/Bundle.java – Kompozyt (lista Component, metoda add(...), price() sumuje dzieci).`

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
- ```bash
  mvn test
  
# ⚙️ CoffeeCraft – Wzorce Projektowe (Lab 2 – Wzorce behawioralne)

Druga część projektu – implementacja **7 wzorców czynnościowych (behawioralnych)**  
w ramach systemu obsługi zamówień kawowych.

Wzorce wykorzystują istniejące elementy z Lab 1 (Order, Bundle, Payment, Recipe itd.)  
i rozszerzają działanie aplikacji o logikę sterowania, komunikacji, powiadomień i akcji.

---

## 📂 Struktura projektu (część behawioralna)

Wszystkie wzorce mnożone są w nowym pakiecie:
/src/main/java/pl/pollub/coffeecraft/behavior/


W nim podzielone podpakiety:

- **strategy** – wzorzec *Strategy* (różne sposoby liczenia ceny).
- **command** – wzorzec *Command* (polecenia wykonywane na zamówieniu).
- **iterator** – wzorzec *Iterator* (iteracja po elementach zamówienia).
- **observer** – wzorzec *Observer* (publikowanie zdarzeń i subskrypcja).
- **mediator** – wzorzec *Mediator* (pośredniczenie płatności + powiadomień).
- **state** – wzorzec *State* (cykl życia zamówienia).
- **memento** – wzorzec *Memento* (zapisywanie/odtwarzanie stanu edytowanego zamówienia).
- **test** – testy jednostkowe każdego z 7 wzorców.

---

# 🧩 Zaimplementowane wzorce behawioralne

Poniżej znajdziesz **dokładne deklaracje kodu**, **gdzie wzorzec jest zadeklarowany**,  
**gdzie użyty**, oraz krótkie objaśnienie działania – identycznie jak w README z Lab 1.

---

# 1. Strategy – różne strategie liczenia ceny zamówienia

### Deklaracje (pakiet `behavior/strategy`)
- `OrderPricingStrategy` – interfejs strategii (`apply(double total)`).
- `NoDiscount` – strategia domyślna (zwraca total bez zmian).
- `PercentDiscount` – strategia procentowa (np. -10%).
- `OrderPricer` – kontekst korzystający ze strategii.

### Użycie
    var pricer = new OrderPricer();
    System.out.println(pricer.total(order));
    
    pricer.setStrategy(new PercentDiscount(0.10));
    System.out.println(pricer.total(order));


# 2. Command – wykonywanie poleceń na obiekcie (np. dodanie pozycji)
### Deklaracje (pakiet behavior/command)
- Command – interfejs (execute()).
- AddItemCommand – komenda dodająca pozycję do OrderEditor.
OrderInvoker – wywoływacz poleceń (run(Command)).

### Użycie
    var editor = new OrderEditor();
    var cmd = new AddItemCommand(editor, croissant);
    var invoker = new OrderInvoker();
    invoker.run(cmd);

Cel: wykonywanie akcji jako obiektów – gotowe do kolejkowania lub undo/redo.

# 3. Iterator – iterowanie po elementach zamówienia
### Deklaracje (pakiet behavior/iterator)
- OrderIterator – własna implementacja Iteratora dla List<Component>.

### Użycie
    var it = new OrderIterator(order.items());
    while(it.hasNext()) {
        System.out.println(it.next().name());
    }

Cel: jednolity sposób przechodzenia po elementach zamówienia, bez ujawniania listy.

# 4. Observer – powiadamianie subskrybentów o zdarzeniach
### Deklaracje (pakiet behavior/observer)
- OrderEvent – enum zdarzeń (ITEM_ADDED, PAID, SERVED).
- OrderObserver – interfejs obserwatora (onEvent(event, msg)).
- OrderPublisher – wydawca zdarzeń (add(), publish()).
- ConsoleObserver – obserwator wypisujący powiadomienia na konsolę.

### Użycie
    var publisher = new OrderPublisher();
    publisher.add(new ConsoleObserver());
    publisher.publish(OrderEvent.PAID, "Zamówienie opłacone");

Cel: separacja logiki powiadomień od logiki biznesowej.


# 5. Mediator – pośrednik między płatnościami a powiadomieniami
### Deklaracje (pakiet behavior/mediator)
- OrderMediator – obsługuje płatność + publikację zdarzeń.

### Użycie
    var mediator = new OrderMediator(pay, publisher);
    mediator.checkout(order);

Cel: uniknięcie bezpośrednich zależności: Order → Payment → Observer.


# 6. State – reprezentuje różne stany zamówienia
### Deklaracje (pakiet behavior/state)
- OrderState – enum (NEW, PAID, SERVED).
- OrderLifecycle – maszyna stanów (pay(), serve(), state()).

### Użycie
    var lifecycle = new OrderLifecycle();
    lifecycle.pay();
    lifecycle.serve();

Cel: jasne zasady zmiany stanów bez ifów porozrzucanych po kodzie.

# 7. Memento – zapisywanie i odtwarzanie stanu edytowanego zamówienia
### Deklaracje (pakiet behavior/memento)
- OrderEditor – edytor tworzący i modyfikujący zamówienie.
- OrderSnapshot – „memento” przechowujące listę pozycji + notatkę.
- OrderCaretaker – stos snapshotów.

### Użycie
    var editor = new OrderEditor();
    editor.add(croissant);
    editor.note("Na miejscu");
    
    caretaker.push(editor.snapshot());
    editor.note("Na wynos");
    
    editor.restore(caretaker.pop());

Cel: cofanie zmian (undo-like behavior).

# Testy jednostkowe (JUnit 5)

Dla każdego wzorca przygotowano osobny test:
- StrategyTest – czy strategia zmienia cenę.
- CommandTest – czy komenda poprawnie modyfikuje OrderEditor.
- IteratorTest – czy iteruje po elementach.
- ObserverTest – czy obserwator dostaje powiadomienia.
- MediatorTest – czy mediator wykonuje płatność i powiadamia.
- StateTest – czy stan zmienia się poprawnie.
- MementoTest – czy snapshot przywraca stan.

### Uruchomienie:
    mvn test
