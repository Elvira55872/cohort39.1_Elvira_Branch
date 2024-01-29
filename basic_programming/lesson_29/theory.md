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

<details>
<summary>Lesson 28. LinkedList (Linked List)</summary>

# Lesson 28. LinkedList

## Introduction

### Defining linked lists

A Linked List is a data structure consisting of nodes, each of which contains data and
a link (or pointer) to the next node in the list. This structure allows you to efficiently insert and delete elements
without having to redistribute or reorganize the entire data structure, as required in arrays.

### Comparing linked lists with arrays

1. **Dynamic size**: Unlike arrays, the size of a linked list is not fixed, and it can
   dynamically increase or decrease.

2. **Memory**: Linked lists use memory more efficiently, as they allocate memory for new ones
   elements as needed, while arrays require a pre-determined amount of memory,
   even if it is not fully used.

3. **Element access time**: In arrays, access to an element by index is fast, while
   as in linked lists, to access an item, you must go through the list.

4. **Insertion and Deletion**: Inserting and deleting items in linked lists is usually faster than in arrays,
   especially if you need to insert or delete items at the beginning or middle of the list.

5. **Random Access**: Arrays provide efficient random access to items, whereas
   accessing a specific item in a linked list requires a sequential pass from the beginning or end of the list.

6. **Memory for additional data**: Each node in the linked list requires additional memory to
   store a pointer to the next or previous elements, while arrays do not require this.

## Basic concepts

### Singly Linked Lists

A singly linked list is a data structure where each element (node) contains data and a link to the next
node in the list. This is the simplest form of a linked list, where passage is possible only in one direction - from
the beginning to the end:
![img_4.png](images%2Fimg_4.png)

- **Node structure**: Each node contains two elements - data and a link to the next node.
- **Advantages**: Ease of implementation, efficient memory usage, dynamic size management.
- **Disadvantages**: Access to elements is only sequential, deletion requires access to the previous node.

### Doubly Linked Lists

A doubly linked list is similar to a singly linked one, but each node contains links to both the next and
previous nodes. This allows a bidirectional passage through the list:
![img_5.png](images%2Fimg_5.png)

- **Node Structure**: Each node contains data, a link to the next node, and a link to the previous node.
- **Advantages**: Bidirectional access, more convenient removal of elements.
- **Disadvantages**: More memory usage due to additional links, implementation complexity.

### Circular Linked Lists

A cyclic list can be singly connected or doubly connected, but in it the last node contains a reference to the
first node, forming a closed loop. This provides endless cyclic access to the elements:
![img_6.png](images%2Fimg_6.png)

- **Features**: In a singly linked cyclic list, the last node points to the first one. In a doubly connected -
  additionally, the first node points to the last one.
- **Advantages**: Allows infinite traversal of list items, useful for applications where the list
  constantly moving around (for example, carousels).
- **Disadvantages**: The need for additional processing during insertion and deletion to maintain cyclicity,
  it is easy to create an endless cycle with incorrect processing.

## Examples and practical tasks

### Implementation of basic methods for a single-linked and double-linked list

#### A single-linked list

- **Adding an item to the end of the list**: Traversing the list to the last item, then inserting a new node.
- **Deleting an element by value**: Searching for a node with a given value and deleting it, while updating the link
  the previous node.
- **Searching for an element by value**: Sequentially traversing the list, checking the value of each node.

#### A doubly linked list

- **Adding an item to the end of the list**: Inserting a new node after the current last node and updating the links.
- **Deleting an item by value**: Similar to a singly linked list, but with updating the previous and next links.
- **Searching for an item by value**: The same as in a singly linked list, but with the ability to move in both directions.

### Solving typical tasks on linked lists

#### List Conversion

List reversal is the process of changing the direction of relationships so that the first element becomes the last and the last
one becomes the first. This can be done by sequentially rearranging the links to the nodes.

**Example for a singly linked list:**

```java
public void reverse() {
    Node prev = null;
    Node current = head;
    Node next;
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
}
```

### Search for the middle element
To find the middle element in the list, you can use two pointers: one moves at double speed, and
the other at a normal speed. When the fast pointer reaches the end of the list, the slow pointer will point to the middle element.

```java
public Node findMiddle() {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

```

## Conclusion

### A brief overview of the topics covered
In this lesson, we covered the key aspects of working with linked lists in Java. The following topics are considered:
- **Definition and basic concepts of linked lists**: Understanding singly linked, doubly linked and cyclic lists.
- **Implementation of a singly linked list**: Creating a node class, adding, deleting, and searching for elements.
- **Implementation of a doubly linked list**: Extended node structure, features of adding and removing elements.
- **Practical tasks**: Handling the list and searching for the middle element, to develop practical skills of working with lists.

</details>


<details>
<summary>Lesson 28. LinkedList (Linked List)</summary>

# Lesson 28. LinkedList

## Introduction

### Defining linked lists

A Linked List is a data structure consisting of nodes, each of which contains data and
a link (or pointer) to the next node in the list. This structure allows you to efficiently insert and delete elements
without having to redistribute or reorganize the entire data structure, as required in arrays.

### Comparing linked lists with arrays

1. **Dynamic size**: Unlike arrays, the size of a linked list is not fixed, and it can
   dynamically increase or decrease.

2. **Memory**: Linked lists use memory more efficiently, as they allocate memory for new ones
   elements as needed, while arrays require a pre-determined amount of memory,
   even if it is not fully used.

3. **Element access time**: In arrays, access to an element by index is fast, while
   as in linked lists, to access an item, you must go through the list.

4. **Insertion and Deletion**: Inserting and deleting items in linked lists is usually faster than in arrays,
   especially if you need to insert or delete items at the beginning or middle of the list.

5. **Random Access**: Arrays provide efficient random access to items, whereas
   accessing a specific item in a linked list requires a sequential pass from the beginning or end of the list.

6. **Memory for additional data**: Each node in the linked list requires additional memory to
   store a pointer to the next or previous elements, while arrays do not require this.

## Basic concepts

### Singly Linked Lists

A singly linked list is a data structure where each element (node) contains data and a link to the next
node in the list. This is the simplest form of a linked list, where passage is possible only in one direction - from
the beginning to the end:
![img_4.png](images%2Fimg_4.png)

- **Node structure**: Each node contains two elements - data and a link to the next node.
- **Advantages**: Ease of implementation, efficient memory usage, dynamic size management.
- **Disadvantages**: Access to elements is only sequential, deletion requires access to the previous node.

### Doubly Linked Lists

A doubly linked list is similar to a singly linked one, but each node contains links to both the next and
previous nodes. This allows a bidirectional passage through the list:
![img_5.png](images%2Fimg_5.png)

- **Node Structure**: Each node contains data, a link to the next node, and a link to the previous node.
- **Advantages**: Bidirectional access, more convenient removal of elements.
- **Disadvantages**: More memory usage due to additional links, implementation complexity.

### Circular Linked Lists

A cyclic list can be singly connected or doubly connected, but in it the last node contains a reference to the
first node, forming a closed loop. This provides endless cyclic access to the elements:
![img_6.png](images%2Fimg_6.png)

- **Features**: In a singly linked cyclic list, the last node points to the first one. In a doubly connected -
  additionally, the first node points to the last one.
- **Advantages**: Allows infinite traversal of list items, useful for applications where the list
  constantly moving around (for example, carousels).
- **Disadvantages**: The need for additional processing during insertion and deletion to maintain cyclicity,
  it is easy to create an endless cycle with incorrect processing.

## Examples and practical tasks

### Implementation of basic methods for a single-linked and double-linked list

#### A single-linked list

- **Adding an item to the end of the list**: Traversing the list to the last item, then inserting a new node.
- **Deleting an element by value**: Searching for a node with a given value and deleting it, while updating the link
  the previous node.
- **Searching for an element by value**: Sequentially traversing the list, checking the value of each node.

#### A doubly linked list

- **Adding an item to the end of the list**: Inserting a new node after the current last node and updating the links.
- **Deleting an item by value**: Similar to a singly linked list, but with updating the previous and next links.
- **Searching for an item by value**: The same as in a singly linked list, but with the ability to move in both directions.

### Solving typical tasks on linked lists

#### List Conversion

List reversal is the process of changing the direction of relationships so that the first element becomes the last and the last
one becomes the first. This can be done by sequentially rearranging the links to the nodes.

**Example for a singly linked list:**

```java
public void reverse() {
    Node prev = null;
    Node current = head;
    Node next;
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
}
```

### Search for the middle element
To find the middle element in the list, you can use two pointers: one moves at double speed, and
the other at a normal speed. When the fast pointer reaches the end of the list, the slow pointer will point to the middle element.

```java
public Node findMiddle() {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

```

| Operation | LinkedList | ArrayList |
|----------------------|---------------|---------------|
| Adding to the end | O(1) | O(1)* |
| Adding to the beginning | O(1) | O(n) |
| Adding to the middle | O(n) | O(n) |
| Removing from the end | O(n) | O(1)* |
| Deleting from the beginning | O(1) | O(n) |
| Removing from the middle | O(n) | O(n) |
| Index search | O(n) | O(1) |
| Search by value | O(n) | O(n) |
| List size | O(1) | O(1) |

## Conclusion

### A brief overview of the topics covered
In this lesson, we covered the key aspects of working with linked lists in Java. The following topics are considered:
- **Definition and basic concepts of linked lists**: Understanding singly linked, doubly linked and cyclic lists.
- **Implementation of a singly linked list**: Creating a node class, adding, deleting, and searching for elements.
- **Implementation of a doubly linked list**: Extended node structure, features of adding and removing elements.
- **Practical tasks**: Handling the list and searching for the middle element, to develop practical skills of working with lists.

</details>

<details>
<summary>Lesson 29. Set. Contract for `hashCode` and `equals` Methods in Java </summary>

# Contract for `hashCode` and `equals` Methods in Java

## `equals` Contract

1. **Reflexivity**: An object must be equal to itself.
    ```java
    x.equals(x) // should return true
    ```

2. **Symmetry**: If `x` is equal to `y`, then `y` should be equal to `x`.
    ```java
    x.equals(y) == y.equals(x) // should be true
    ```

3. **Transitivity**: If `x` is equal to `y` and `y` is equal to `z`, then `x` should be equal to `z`.
    ```java
    if (x.equals(y) && y.equals(z)) {
        x.equals(z); // should return true
    }
    ```

4. **Consistency**: Multiple invocations of `equals` on the same objects should return the same result, provided no information used in the `equals` comparisons is modified.

5. **Non-equality to `null`**: Any non-null reference `x.equals(null)` should return `false`.

## `hashCode` Contract

1. **Consistency**: During a single execution of an application, the method should consistently return the same integer value, provided no information used in the `equals` method has changed.

2. **Equality of Objects implies Equality of Hash Codes**: If `x.equals(y)` returns `true`, then `x.hashCode()` should return the same hash code as `y.hashCode()`.

## Relationship between `hashCode` and `equals`

If two objects are considered equal according to the `equals` method, their hash codes must also be equal. However, the reverse is not necessarily true: equal hash codes do not guarantee object equality. In other words, two different objects can have the same hash code, leading to a collision.

Therefore, when overriding one of these methods, it's generally necessary to override the other as well, adhering to the specified contract.

# Set in Java

## Overview

The `Set` interface is present in the `java.util` package and extends the `Collection` interface. It is an unordered collection of objects in which duplicate values cannot be stored. Essentially, it implements the mathematical concept of a set. This interface contains methods inherited from the `Collection` interface, and adds a feature that restricts the insertion of duplicate elements.

There are two main sub-interfaces that extend the `Set` interface:

- `SortedSet`
- `NavigableSet`


## NavigableSet and SortedSet

In the above diagram, the `NavigableSet` interface extends the `SortedSet` interface. Since a set doesn't retain the insertion order, the `NavigableSet` interface provides the implementation to navigate through the set. The class which implements `NavigableSet` is `TreeSet`, which is an implementation of a self-balancing tree. Therefore, this interface provides us with a way to navigate through this tree.

## Declaration

The `Set` interface is declared as:

```java
public interface Set<E> extends Collection<E>
```

## Creating Set Objects
Since Set is an interface, objects cannot be created of the type Set. We always need a class that extends this list in order to create an object. After the introduction of Generics in Java 1.5, it is possible to restrict the type of object that can be stored in the Set. A type-safe set can be defined as:
```java
// Obj is the type of the object to be stored in Set
Set<Object> set = new HashSet<Object>();
```
## Classes Implementing the Set Interface in Java

| Class          | Storage Mechanism                 | Order Retention                   | Time Complexity for Basic Operations | Thread-Safety       | Null Elements                   |
|----------------|-----------------------------------|-----------------------------------|-------------------------------------|---------------------|---------------------------------|
| `HashSet`      | Hash Table                        | Does not retain order             | Constant time                       | No                  | Allows                          |
| `TreeSet`      | Red-Black Tree                    | Elements are sorted               | Logarithmic time                    | No                  | Not allowed (Java 7 and above)  |
| `LinkedHashSet`| Hash Table and Doubly-linked List | Retains insertion order           | Constant time                       | No                  | Allows                          |



<hr style="height:2px; border-width:0; color:gray; background-color:gray;">

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

<details>
<summary>Урок  28. LinkedList (Связанный список)</summary>

# Lesson 28.LinkedList (Связанный список)

## План урока по теме "Связные списки (Linked List) в Java"

## Введение

### Определение связных списков

Linked List (Связный список) - это структура данных, состоящая из узлов, каждый из которых содержит данные и ссылку
(или указатель) на следующий узел в списке. Эта структура позволяет эффективно вставлять и удалять элементы
без необходимости перераспределения или реорганизации всей структуры данных, как это требуется в массивах.

### Сравнение связных списков с массивами

1. **Динамический размер**: В отличие от массивов, размер связного списка не фиксирован, и он может
   динамически увеличиваться или уменьшаться.

2. **Память**: Связные списки более эффективно используют память, так как они выделяют память под новые
   элементы по мере необходимости, в то время как массивы требуют заранее определенного количества памяти,
   даже если она не полностью используется.

3. **Время доступа к элементам**: В массивах доступ к элементу по индексу выполняется быстро, в то время
   как в связных списках для доступа к элементу необходимо пройти через список.

4. **Вставка и удаление**: Вставка и удаление элементов в связных списках обычно быстрее, чем в массивах,
   особенно если необходимо вставить или удалить элементы в начале или середине списка.

5. **Случайный доступ**: Массивы обеспечивают эффективный случайный доступ к элементам, тогда как для
   доступа к определенному элементу в связном списке требуется последовательный проход от начала или конца списка.

6. **Память на дополнительные данные**: Каждый узел в связном списке требует дополнительной памяти для
   хранения указателя на следующий или предыдущий элементы, в то время как массивы не требуют этого.

## Основные концепции

### Односвязные списки (Singly Linked Lists)

Односвязный список - это структура данных, где каждый элемент (узел) содержит данные и ссылку на следующий
узел в списке. Это самая простая форма связного списка, где проход возможен только в одном направлении - от
начала к концу:
![img_4.png](images%2Fimg_4.png)

- **Структура узла**: Каждый узел содержит два элемента - данные и ссылку на следующий узел.
- **Преимущества**: Простота реализации, эффективное использование памяти, динамичное управление размером.
- **Недостатки**: Доступ к элементам только последовательный, удаление требует доступа к предыдущему узлу.

### Двусвязные списки (Doubly Linked Lists)

Двусвязный список похож на односвязный, но каждый узел содержит ссылки как на следующий, так и на
предыдущий узлы. Это позволяет двунаправленный проход по списку:
![img_5.png](images%2Fimg_5.png)

- **Структура узла**: Каждый узел содержит данные, ссылку на следующий узел и ссылку на предыдущий узел.
- **Преимущества**: Двунаправленный доступ, более удобное удаление элементов.
- **Недостатки**: Больше занимаемой памяти из-за дополнительных ссылок, сложность реализации.

### Циклические списки (Circular Linked Lists)

Циклический список может быть односвязным или двусвязным, но в нем последний узел содержит ссылку на
первый узел, формируя замкнутый цикл. Это обеспечивает бесконечный циклический доступ к элементам:
![img_6.png](images%2Fimg_6.png)

- **Особенности**: В односвязном циклическом списке последний узел указывает на первый. В двусвязном -
  дополнительно первый узел указывает на последний.
- **Преимущества**: Позволяет бесконечно обходить элементы списка, полезно для приложений, где список
  постоянно перебирается (например, карусели).
- **Недостатки**: Необходимость дополнительной обработки при вставке и удалении для поддержания цикличности,
  легко создать бесконечный цикл при неправильной обработке.

## Примеры и практические задачи

### Реализация базовых методов для односвязного и двусвязного списка

#### Односвязный список

- **Добавление элемента в конец списка**: Проход по списку до последнего элемента, затем вставка нового узла.
- **Удаление элемента по значению**: Поиск узла с заданным значением и его удаление, при этом необходимо обновить ссылку
  предыдущего узла.
- **Поиск элемента по значению**: Последовательный проход по списку с проверкой значения каждого узла.

#### Двусвязный список

- **Добавление элемента в конец списка**: Вставка нового узла после текущего последнего узла и обновление ссылок.
- **Удаление элемента по значению**: Аналогично односвязному списку, но с обновлением предыдущей и следующей ссылок.
- **Поиск элемента по значению**: Такой же, как в односвязном списке, но с возможностью движения в обоих направлениях.

### Решение типичных задач на связные списки

#### Обращение списка

Обращение списка - это процесс изменения направления связей так, чтобы первый элемент стал последним, а последний -
первым. Это можно сделать путем последовательного переставления ссылок на узлы.

**Пример для односвязного списка:**

```java
public void reverse() {
    Node prev = null;
    Node current = head;
    Node next;
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
}
```

### Поиск среднего элемента
Для нахождения среднего элемента в списке можно использовать два указателя: один перемещается с двойной скоростью, а
другой - с обычной. Когда быстрый указатель достигает конца списка, медленный будет указывать на средний элемент.

```java
public Node findMiddle() {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

```

| Операция             | LinkedList | ArrayList     |
|----------------------|------------|---------------|
| Добавление в конец   | O(1)       | O(1)*         |
| Добавление в начало  | O(1)       | O(n)          |
| Добавление в середину| O(n)       | O(n)          |
| Удаление из конца    | O(1)       | O(1)*         |
| Удаление из начала   | O(1)       | O(n)          |
| Удаление из середины | O(n)       | O(n)          |
| Поиск по индексу     | O(n)       | O(1)          |
| Поиск по значению    | O(n)       | O(n)          |
| Размер списка        | O(1)       | O(1)          |

## Заключение

### Краткий обзор пройденных тем
В рамках данного урока мы охватили ключевые аспекты работы со связными списками в Java. Рассмотрены следующие темы:
- **Определение и основные концепции связных списков**: Понимание односвязных, двусвязных и циклических списков.
- **Реализация односвязного списка**: Создание класса узла, добавление, удаление и поиск элементов.
- **Реализация двусвязного списка**: Расширенная структура узла, особенности добавления и удаления элементов.
- **Практические задачи**: Обращение списка и поиск среднего элемента, для развития практических навыков работы со списками.

</details>

<details>
<summary>Урок 29. Set (Множества). Контракт методов `hashCode` и `equals` в Java </summary>

# Контракт методов `hashCode` и `equals` в Java

## Контракт `equals`

1. **Рефлексивность**: Объект должен быть равен самому себе.
    ```java
    x.equals(x) // должно вернуть true
    ```

2. **Симметричность**: Если `x` равно `y`, то `y` должно быть равно `x`.
    ```java
    x.equals(y) == y.equals(x) // должно быть true
    ```

3. **Транзитивность**: Если `x` равно `y` и `y` равно `z`, то `x` должно быть равно `z`.
    ```java
    if (x.equals(y) && y.equals(z)) {
        x.equals(z); // должно вернуть true
    }
    ```

4. **Консистентность**: Многократные вызовы `equals` с теми же объектами должны возвращать одинаковый результат, при условии, что информация, используемая в сравнениях на равенство, не меняется.

5. **Неравенство с `null`**: Любая не-null ссылка `x.equals(null)` должна возвращать `false`.

## Контракт `hashCode`

1. **Консистентность**: В течение одного выполнения приложения, метод должен всегда возвращать одно и то же целочисленное значение, если информация, используемая в методе `equals`, не изменилась.

2. **Если объекты равны, хеш-коды тоже должны быть равны**: Если `x.equals(y)` возвращает `true`, то `x.hashCode()` должен возвращать тот же хеш-код, что и `y.hashCode()`.

## Взаимосвязь `hashCode` и `equals`

Если два объекта считаются равными по методу `equals`, их хеш-коды также должны быть равны. Однако обратное не всегда верно: равенство хеш-кодов не гарантирует равенство объектов. Другими словами, два различных объекта могут иметь одинаковый хеш-код, что является коллизией.

Таким образом, при переопределении одного из этих методов, как правило, необходимо переопределить и другой, соблюдая указанный контракт.

# Множество (Set) в Java

## Обзор

Интерфейс `Set` находится в пакете `java.util` и расширяет интерфейс `Collection`. Это неупорядоченная коллекция объектов, в которой не могут храниться дубликаты. По сути, он реализует математическое понятие множества. Этот интерфейс содержит методы, унаследованные от интерфейса `Collection`, и добавляет функцию, которая ограничивает вставку дублирующих элементов.

Есть два основных подинтерфейса, которые расширяют интерфейс `Set`:

- `SortedSet`
- `NavigableSet`


## NavigableSet и SortedSet

На приведенной выше диаграмме интерфейс `NavigableSet` расширяет интерфейс `SortedSet`. Поскольку множество не сохраняет порядок вставки, интерфейс `NavigableSet` предоставляет реализацию для навигации по множеству. Класс, который реализует `NavigableSet`, — это `TreeSet`, являющийся реализацией самобалансирующегося дерева. Таким образом, этот интерфейс предоставляет нам способ навигации по этому дереву.

## Объявление

Интерфейс `Set` объявлен так:

```java
public interface Set<E> extends Collection<E>
```

## Создание объектов Set
Поскольку Set является интерфейсом, объекты типа `Set` создать нельзя. Нам всегда нужен класс, который расширяет этот список, чтобы создать объект. После введения обобщений в `Java 1.5` стало возможным ограничить тип объекта, который может быть сохранен в `Set`. Типобезопасное множество можно определить так:
```java
// Obj is the type of the object to be stored in Set
Set<Object> set = new HashSet<Object>();
```

## Классы, реализующие интерфейс Set в Java

| Класс         | Хранение                          | Порядок                           | Сложность операций                     | Потокобезопасность | Null-элементы                  |
|---------------|-----------------------------------|-----------------------------------|---------------------------------------|--------------------|--------------------------------|
| `HashSet`      | Хеш-таблица                       | Не сохраняет порядок               | Константное время для основных операций| Нет                | Допускает                       |
| `TreeSet`      | Красно-черное дерево              | Элементы отсортированы            | Логарифмическое время                 | Нет                | Не допускает (Java 7 и выше)    |
| `LinkedHashSet`| Хеш-таблица и двусвязный список   | Сохраняет порядок вставки          | Константное время для основных операций| Нет                | Допускает                       |

</details>
</details>


