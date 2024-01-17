<details>
<summary>Collections Framework. English version</summary>

<details>
<summary>Basic information about Collections Framework</summary>

# Collections in Java

Any group of individual objects represented as a whole is called a collection of Java objects. In Java, JDK 1.2
defines a separate structure called the "Collection Framework", which contains all classes and interfaces
of Java collections.

In Java, the collection interface (`java.util.Collection`) and the `Map` interface (`java.util.Map`) are the two main "root"
interfaces of Java collection classes.

## What is a framework in Java?

A framework is a set of classes and interfaces that provide a ready—made architecture. To implement a new function
or class, there is no need to define a structure. However, an optimal object-oriented design always includes
a structure with a set of classes in which all classes perform tasks of the same type.

### The need for a separate data collection platform in Java

Before the advent of the Collection Framework (or before JDK 1.2), the standard methods for grouping Java objects (or collections) were
Arrays or Vectors or Hash tables. All these collections did not have a common interface. Thus, although the main purpose
of all collections is the same, the implementation of all these collections was determined independently and had no correlation between
them. In addition, it is very difficult for users to remember all the different methods, syntax, and constructors.

### Advantages of the Java Collection Framework

Since the lack of a data collection system has led to the above set of disadvantages, the advantages
of the data collection system are listed below.

- **Serial API:** The API has a basic set of interfaces such as `Set`, `List` or `Map` common set
  methods.

- **Reduces programming efforts:** The programmer does not need to worry about the design of the Collection, he can
  focus on making the best use of it in your program. So the basic concept is
  Object-oriented programming (i.e. abstraction) has been successfully implemented.

- **Improves the speed and quality of the program:** Improves productivity by providing high-performance
  implement useful data structures and algorithms, because in this case the programmer does not need to think about the best
  implementations of a specific data structure. He may just use a better implementation to significantly boost
  the performance of your algorithm/program.

### Hierarchy of the data collection platform in Java

The `java.util` package contains all the classes and interfaces required by the `collection` framework. The `collection` framework
contains an interface named the `iterable` interface, which makes it easy to iterate through collections. This
The interface is extended by the main `collection` interface, which acts as the root
for the `collection framework'.
All collections extend this interface, thereby extending the properties of the iterator and methods of this interface. The
following figure shows the hierarchy of the `collection framework` data collection structure.

![img.png](images%2Fimg.png)

### Collection interface methods

This interface contains various methods that can be directly used by all collections implementing this
interface.:

| Method | Description |
|-----------------------------|---------------------------------------------------------------------------------|
| `add(Object)`               | Adds an object to the collection.                                                   |
| `addAll(Collection c)` | Adds all items from the specified collection to this collection.                  |
| `clear()` | Removes all items from this collection.                                         |
| `contains(Object o)` | Returns `true` if the collection contains the specified element.                   |
| `containsAll(Collection c)` | Returns `true` if the collection contains all the items from the specified collection. |
| `equals(Object o)` | Compares the specified object with this collection for equality.                     |
| `hashCode()` | Returns the hash code of this collection.                                              |
| `isEmpty()` | Returns `true` if the collection does not contain elements.                        |
| `iterator()` | Returns an iterator for the items in this collection.                             |
| `max()` | Returns the maximum                                                            

</details>

<details>
<summary>Lesson 27. ArrayList</summary>


# Lesson 27. ArrayList in Java

## Introduction to the List Interface in Java

The `List' interface in Java is part of the Java Collections Framework and is an ordered collection (or
sequence) of elements. The items in the list can be accessed and managed by indexes starting from scratch. The main thing
The difference between the `List` interface and standard arrays lies in its flexibility: unlike arrays, the size of lists
can change dynamically. `List` provides methods for adding, deleting, and accessing items, and also
allows you to search and sort data. This interface is implemented by various classes, such
as `ArrayList`, `LinkedList` and others, each of which has its own characteristics and applications. Learning about `List` and its
implementations, especially `ArrayList', is fundamental to the effective use of collections in Java.

## Introduction to ArrayList

![img_1.png](images%2Fimg_1.png)

### Overview: What is an ArrayList and how does it differ from regular arrays

An `ArrayList` in Java is an implementation of a dynamic array that is part of the Java Collections Framework. Unlike
standard arrays, `ArrayList` provides the ability to dynamically resize. This means that
elements can be added or removed, and the size of the `ArrayList` will automatically adapt to these
changes. 'ArrayList` supports only object data types and cannot store primitive types directly.

### Advantages of using ArrayList over arrays

- **Size flexibility**: The main advantage of `ArrayList` over standard arrays is its ability to
  change the size during program execution. This allows for more efficient memory management, especially when accurate
  The number of elements is unknown in advance.
- **Convenient methods**: `ArrayList` provides many built-in methods for managing elements, such as
  adding, deleting, searching and sorting, which makes it more convenient to use compared to the usual ones
  arrays.
- **Auto-packing and auto-unpacking**: With 'ArrayList`, you can easily use wrapper classes for primitive
  data types such as `Integer` and `Double`, which are automatically packed and unpacked.

## Basics of working with ArrayList

### Creating an ArrayList: How to initialize and use ArrayList

There are several ways to create an `ArrayList`. The easiest way is to use a constructor without arguments, which
creates an empty list. You can also initialize an `ArrayList` with an initial capacity or an existing collection.
For example, `ArrayList<String> list = new ArrayList<>();` creates an empty list of strings.

### Main methods: add, get, set, remove, size

- `add(Object)` - adds an item to the end of the list.
- `get(int index)` - returns an element at the specified index.
- `set(int index, Object)` - replaces the element in the specified position.
- `remove(int index)` or `remove(Object)` - removes an element by index or value.
- `size()` - returns the number of items in the list.

### Automatic resizing: How the ArrayList automatically expands and contracts

The `ArrayList` automatically increases its capacity when the number of items exceeds the current capacity of the list. This
is due to the redistribution of the internal array. When deleting elements, the size of the `ArrayList` does not decrease
automatically, but you can manually reduce the size using the `trimToSize()` method.

## Working with data in ArrayList

### Adding Elements: Different ways to add elements
- **Direct addition**: Using the `add(Object)` method to add an item to the end of the list.
- **Adding by index**: The `add(int index, Object element)` method allows you to insert an element at a certain position in the list.

![img_2.png](images%2Fimg_2.png)

### Deleting items: How and when to delete items from the list
- **Deleting by index**: The `remove(int index)` method deletes an element at the specified index.
- **Deletion by value**: The `remove(Object o)` method deletes the first occurrence of the specified element, if it is present in the list.

![img_3.png](images%2Fimg_3.png)

### Searching and updating items: Getting data and changing items in the list
- **Searching for an element**: The `indexOf(Object o)` method returns the index of the first occurrence of the element, `contains(Object o)` checks for the presence of the element.
- **Updating the element**: The `set(int index, Object element)` method replaces the element at the specified position.

### Iterating over elements: Using loops and iterators to bypass the ArrayList
- **Using a for-each loop**: A convenient way to iterate through elements without accessing the index.
- **Using the iterator**: Iterators allow you to more flexibly manage the iteration process, including removing elements during iteration.

| Operation | Complexity | Description |
|---------------------|------------------|----------------------------------------------|
| `add(E e)` | O(1) Amortized | Adding an item to the end of the list. The complexity can increase to O(n) when the array is expanded. |
| `add(int index, E element)` | O(n) | Adding an element to the specified position. Requires shifting all subsequent elements. |
| `get(int index)`    | O(1) | Getting an element by index.               |
| `set(int index, E element)` | O(1) | Replacing an element at a given position.         |
| `remove(int index)` | O(n) | Deleting an element by index. Requires shifting all subsequent elements. |
| `remove(Object o)` | O(n) | Deleting the first occurrence of the specified element, if present. |
| `size()` | O(1) | Getting the size of the list.                    |
| `clear()` | O(n) | Removing all items from the list.           |
| `contains(Object o)`| O(n) | Checking for the presence of an item in the list.          |
| `indexOf(Object o)` | O(n) | Getting the index of the first occurrence of the element.|
| `lastIndexOf(Object o)` | O(n) | Getting the index of the last occurrence of the element. |



## Conclusion: Learning ArrayList in Java

### Summarizing the key points of the lesson
- We have studied the `ArrayList`, a dynamic data structure that provides flexibility and convenience of working with arrays of objects in Java.
- We reviewed the basic operations such as adding, deleting, searching and updating items, as well as various ways to iterate through the list.
- We learned about the advantages of using `ArrayList` compared to standard arrays, including dynamic resizing and more convenient data management methods.

</details>
</details>

------------

<details>
<summary>Collections Framework. Русскаязычная версия</summary>

<details>
<summary>Основная информация о Collections Framework</summary>

# Collections in Java

Любая группа отдельных объектов, представленных как единое целое, называется коллекцией объектов Java. В Java в JDK 1.2
определена отдельная структура под названием "Collection Framework", которая содержит все классы и интерфейсы коллекций
Java.

В Java интерфейс коллекции (`java.util.Collection`) и интерфейс `Map` (`java.util.Map`) — два основных «корневых»
интерфейса классов коллекций Java.

## Что такое фреймворк в Java?

Фреймворк — это набор классов и интерфейсов, которые предоставляют готовую архитектуру. Чтобы реализовать новую функцию
или класс, нет необходимости определять структуру. Однако оптимальный объектно-ориентированный дизайн всегда включает в
себя структуру с набором классов, в которой все классы выполняют задачи одного и того же типа.

### Необходимость в отдельной платформе сбора данных в Java

До появления Collection Framework (или до JDK 1.2) стандартными методами группировки объектов Java (или коллекций) были
Массивы или Векторы или Хеш-таблицы. Все эти коллекции не имели общего интерфейса. Таким образом, хотя основная цель
всех коллекций одна и та же, реализация всех этих коллекций определялась независимо и не имела никакой корреляции между
ними. Кроме того, пользователям очень сложно запомнить все различные методы, синтаксис и конструкторы.

### Преимущества Java Collection Framework

Поскольку отсутствие системы сбора данных привело к вышеуказанному набору недостатков, ниже приведены преимущества
системы сбора данных.

- **Последовательный API:** API имеет базовый набор интерфейсов, таких как `Set`, `List` или `Map` общий набор
  методов.

- **Уменьшает усилия по программированию:** Программисту не нужно беспокоиться о дизайне Коллекции, он может
  сосредоточиться на ее наилучшем использовании в своей программе. Таким образом, основная концепция
  объектно-ориентированного программирования (т.е. абстракции) была успешно реализована.

- **Повышает скорость и качество программы:** Повышает производительность за счет обеспечения высокопроизводительной
  реализации полезных структур данных и алгоритмов, поскольку в этом случае программисту не нужно думать о лучшей
  реализации конкретная структура данных. Он может просто использовать лучшую реализацию, чтобы значительно повысить
  производительность своего алгоритма/программы.

### Иерархия платформы сбора данных в Java

Пакет `java.util` содержит все классы и интерфейсы, необходимые платформе `collection` framework. Фреймворк `collection`
содержит интерфейс с именем `iterable` интерфейс, который позволяет легко перебирать коллекции. Этот
интерфейс расширяется за счет основного интерфейса `collection`, который выступает в качестве корня
для `collection framework`.
Все коллекции расширяют этот интерфейс, тем самым расширяя свойства итератора и методов этого интерфейса. На
следующем рисунке показана иерархия структуры сбора данных `collection framework`.

![img.png](images%2Fimg.png)

### Методы интерфейса коллекции

Этот интерфейс содержит различные методы, которые могут напрямую использоваться всеми коллекциями, реализующими этот
интерфейс:

| Метод                       | Описание                                                                        |
|-----------------------------|---------------------------------------------------------------------------------|
| `add(Object)`               | Добавляет объект в коллекцию.                                                   |
| `addAll(Collection c)`      | Добавляет все элементы из указанной коллекции в эту коллекцию.                  |
| `clear()`                   | Удаляет все элементы из этой коллекции.                                         |
| `contains(Object o)`        | Возвращает `true`, если коллекция содержит указанный элемент.                   |
| `containsAll(Collection c)` | Возвращает `true`, если коллекция содержит все элементы из указанной коллекции. |
| `equals(Object o)`          | Сравнивает указанный объект с этой коллекцией на равенство.                     |
| `hashCode()`                | Возвращает хеш-код этой коллекции.                                              |
| `isEmpty()`                 | Возвращает `true`, если коллекция не содержит элементов.                        |
| `iterator()`                | Возвращает итератор для элементов в этой коллекции.                             |
| `max()`                     | Возвращает максималь                                                            

</details>

<details>
<summary>Урок  27. ArrayList</summary>


# Lesson 27. ArrayList в Java

## Введение в Интерфейс List в Java

Интерфейс `List` в Java является частью Java Collections Framework и представляет собой упорядоченную коллекцию (или
последовательность) элементов. Элементы в списке могут быть доступны и управляемы по индексам, начиная с нуля. Главное
отличие интерфейса `List` от стандартных массивов заключается в его гибкости: в отличие от массивов, размер списков
может динамически изменяться. `List` предоставляет методы для добавления, удаления и доступа к элементам, а также
позволяет выполнять поиск и сортировку данных. Этот интерфейс реализуется различными классами, такими
как `ArrayList`, `LinkedList` и другими, каждый из которых имеет свои особенности и применения. Изучение `List` и его
реализаций, особенно `ArrayList`, является фундаментальным для эффективного использования коллекций в Java.

## Введение в ArrayList

![img_1.png](images%2Fimg_1.png)

### Обзор: Что такое ArrayList и как он отличается от обычных массивов

`ArrayList` в Java — это реализация динамического массива, которая является частью Java Collections Framework. В отличие
от стандартных массивов, `ArrayList` обеспечивает возможность динамического изменения размера. Это означает, что
элементы могут быть добавлены или удалены, и размер `ArrayList` будет автоматически адаптироваться к этим
изменениям. `ArrayList` поддерживает только объектные типы данных и не может хранить примитивные типы напрямую.

### Преимущества использования ArrayList по сравнению с массивами

- **Гибкость размера**: Основное преимущество `ArrayList` перед стандартными массивами заключается в его способности
  изменять размер во время выполнения программы. Это позволяет более эффективно управлять памятью, особенно когда точное
  количество элементов заранее неизвестно.
- **Удобные методы**: `ArrayList` предоставляет множество встроенных методов для управления элементами, таких как
  добавление, удаление, поиск и сортировка, что делает его более удобным в использовании по сравнению с обычными
  массивами.
- **Автоупаковка и автораспаковка**: С `ArrayList` можно легко использовать оберточные классы для примитивных типов
  данных, такие как `Integer` и `Double`, которые автоматически упаковываются и распаковываются.

## Основы работы с ArrayList

### Создание ArrayList: Как инициализировать и использовать ArrayList

`ArrayList` можно создать несколькими способами. Самый простой способ - использовать конструктор без аргументов, который
создает пустой список. Также можно инициализировать `ArrayList` с начальной емкостью или существующей коллекцией.
Например, `ArrayList<String> list = new ArrayList<>();` создает пустой список строк.

### Основные методы: add, get, set, remove, size

- `add(Object)` - добавляет элемент в конец списка.
- `get(int index)` - возвращает элемент по указанному индексу.
- `set(int index, Object)` - заменяет элемент в указанной позиции.
- `remove(int index)` или `remove(Object)` - удаляет элемент по индексу или значению.
- `size()` - возвращает количество элементов в списке.

### Автоматическое изменение размера: Как ArrayList автоматически расширяется и сжимается

`ArrayList` автоматически увеличивает свою емкость, когда количество элементов превышает текущую емкость списка. Это
происходит благодаря перераспределению внутреннего массива. При удалении элементов размер `ArrayList` не уменьшается
автоматически, но можно вручную уменьшить размер, используя метод `trimToSize()`.

## Работа с данными в ArrayList

### Добавление элементов: Различные способы добавления элементов
- **Прямое добавление**: Использование метода `add(Object)` для добавления элемента в конец списка.
- **Добавление по индексу**: Метод `add(int index, Object element)` позволяет вставить элемент на определенную позицию в списке.

![img_2.png](images%2Fimg_2.png)

### Удаление элементов: Как и когда следует удалять элементы из списка
- **Удаление по индексу**: Метод `remove(int index)` удаляет элемент по указанному индексу.
- **Удаление по значению**: Метод `remove(Object o)` удаляет первое вхождение указанного элемента, если он присутствует в списке.

![img_3.png](images%2Fimg_3.png)

### Поиск и обновление элементов: Получение данных и изменение элементов в списке
- **Поиск элемента**: Метод `indexOf(Object o)` возвращает индекс первого вхождения элемента, `contains(Object o)` проверяет наличие элемента.
- **Обновление элемента**: Метод `set(int index, Object element)` заменяет элемент на указанной позиции.

### Перебор элементов: Использование циклов и итераторов для обхода ArrayList
- **Использование for-each цикла**: Удобный способ перебора элементов без доступа к индексу.
- **Использование итератора**: Итераторы позволяют более гибко управлять процессом перебора, включая удаление элементов во время итерации.

| Операция            | Сложность        | Описание                                     |
|---------------------|------------------|----------------------------------------------|
| `add(E e)`          | O(1) амортизированно | Добавление элемента в конец списка. Сложность может увеличиться до O(n) при расширении массива. |
| `add(int index, E element)` | O(n) | Добавление элемента в заданную позицию. Требует сдвига всех последующих элементов. |
| `get(int index)`    | O(1)             | Получение элемента по индексу.               |
| `set(int index, E element)` | O(1) | Замена элемента на заданной позиции.         |
| `remove(int index)` | O(n)             | Удаление элемента по индексу. Требует сдвига всех последующих элементов. |
| `remove(Object o)`  | O(n)             | Удаление первого вхождения указанного элемента, если он присутствует. |
| `size()`            | O(1)             | Получение размера списка.                    |
| `clear()`           | O(n)             | Удаление всех элементов из списка.           |
| `contains(Object o)`| O(n)             | Проверка наличия элемента в списке.          |
| `indexOf(Object o)` | O(n)             | Получение индекса первого вхождения элемента.|
| `lastIndexOf(Object o)` | O(n)         | Получение индекса последнего вхождения элемента. |



## Заключение: Изучение ArrayList в Java

### Обобщение ключевых моментов урока
- Мы изучили `ArrayList` — динамическую структуру данных, которая обеспечивает гибкость и удобство работы с массивами объектов в Java.
- Рассмотрели основные операции, такие как добавление, удаление, поиск и обновление элементов, а также различные способы итерации по списку.
- Узнали о преимуществах использования `ArrayList` по сравнению со стандартными массивами, включая динамическое изменение размера и более удобные методы управления данными.

</details>
</details>


