<details>
<summary>Lesson 26. Generics</summary>

## Introduction to Generics in Java

### Introduction to generics: what they are and why they are needed
- **Definition**: Generics in Java is a programming language mechanism that allows you to define classes, interfaces and methods with parameterized types.
- **Purpose of use**: Generics provide a way to create classes, methods and interfaces with flexible typing, while increasing the security of working with data types.

### Overview of the problems that generics solve in Java
- **Improved code readability and security**: Generics provide strict type checking at compile time, which helps prevent errors related to incorrect typecasting.
- **Getting rid of the need for type conversion**: Provide the ability to use generalized types, which eliminates the need for explicit type conversion and simplifies the code.
- **Increased code reuse**: Allows you to create more general and flexible data structures and algorithms that can work with any type of data.
- **Examples of solved problems**: Code without generics is often error-prone due to incorrect casts and may be less readable. Generics eliminate these problems by providing type safety and improved readability.

## Examples of using Generics

### Creating your own generalized class
- **Description**: Generic classes in Java are used to create classes with types that are defined at the time of creating an instance of the class. This allows you to create more versatile and reusable components.
- **Example without using collections**:

  ```java
  public class Box<T> {
      private T content;

      public Box(T content) {
          this.content = content;
      }

      public T getContent() {
          return content;
      }

      public void setContent(T content) {
          this.content = content;
      }
  }

  // Usage
  Box<String> stringBox = new Box<>("Hello, Generics!");
  Box<Integer> integerBox = new Box<>(123);
  ```

### The benefits of using generics
- **Type Safety:** Generics provide compile-time type checking, which avoids `ClassCastException` errors at runtime.
- **Increased flexibility:** Allow you to create code that can work with different types of data, increasing the reuse and versatility of components.
- **Code readability:** Simplify code understanding and support, as data types become clear and predictable.

## Erasure of types (Type Erasure)

### Explanation of the type erasure process in Java
- **What is type erasure**: Type erasure is the process by which the Java compiler converts all generalized types (generics) into ordinary object types or other non-generalized types. This is done to ensure compatibility with code written before the introduction of generics in Java 5.
- **How it works**: At compile time, all generic parameters in generalized types are replaced by their bounds or, if no bounds are specified, by the `Object` type.

### How type erasure affects the use of generics
- **Limitations**: Erasing types limits some features, for example, you cannot use `instanceof` to check generalized types, since there is no information about the exact generalized type at runtime.
- **Examples of limitations**:
- Inability to create an instance of a generalized type (`new T()`).
    - The inability to declare static variables of a specific generalized type.

### Examples and consequences of erasing types
- **Example with a generalized method**:
  ```java
  public <T> boolean isEqual(T t1, T t2) {
  return t1.equals(t2);
  }
  // After erasing the types, the method becomes unavailable
  public boolean isEqual(Object t1, Object t2) {
  return t1.equals(t2);
  }
  ```

### Implications for the developer:
- The need for explicit type conversion when extracting elements from generalized collections.
- The inability to rely on generalized types at runtime to ensure typical security.

## Wrapper Types

### Description and use of wrapper types in the context of generics
- **Description**: Wrapper types in Java are classes that provide a way to wrap primitive data types (`int`, `double`, `char`, etc.) into objects. This allows the use of primitive types in structures that require objects, such as generics.
- **The main wrapper classes** are: `Integer` for `int`, `Double` for `double`, `Character` for `char` and so on.
- **Application in generics**: Since generics work only with objects, wrapper types are necessary to use primitive data types in generalized structures.

### Examples of using wrapper types with generics
- **Example with wrapper type and generic**:
  ```java
  List<Integer> listOfIntegers = new ArrayList<>();
  listOfIntegers.add(10); // Auto-unpacking int to Integer
  int first = listOfIntegers.get(0); // Auto-unpacking Integer to int
  ```

Here `Integer` is used as a wrapper type for `int` to allow storing integers in a list
An `ArrayList' that is generalized.

### Discussion of the advantages and limitations of wrapper types
**Advantages:**
- **Auto-packing and auto-unpacking:** Modern versions of Java automatically convert primitive types to the corresponding wrapper types and back, making it easier to work with them.
- **Usage in collections and generics:** Wrapper types allow you to store primitive data in generalized data structures such as lists and sets.

**Restrictions:**
- **Efficiency:** The use of wrapper types may affect performance due to the need for
- **Null values:** Wrapper types can contain `null`, which can lead to a `NullPointerException` in cases,
  when the primitive type does not allow `null`.

## Conclusion: Generics in Java

### Summarizing the key points of the lesson

- **Importance of Generics**: Generics in Java are a powerful tool for increasing flexibility, type safety and code readability. They allow you to create classes, interfaces, and methods that can work with different types of data.

- **Usage examples**: We've looked at how generics are used to create generic classes and methods that can work with any type of data, while avoiding typecasting errors and increasing code readability.

- **Erasing types**: It is important to understand how erasing types affects working with generics, especially with regard to the limitations associated with creating instances of generalized types and using generics at runtime.

- **Generalized Methods**: Generalized methods add additional flexibility to programming, allowing you to create methods that are adaptable to different types of data.

- **Wrapper Types**: Wrapper types play a key role in using generics with primitive data types, providing auto-packaging and auto-unpacking between primitives and their wrappers.

### Final thoughts
- Using generics in Java requires understanding their basics and limitations. They provide type safety and eliminate the need for explicit type conversions, making the code more flexible and easily maintained.
- The practice and application of these concepts in real projects will help to deepen understanding and effectively use the advantages of generics in Java programming.
</details>

------------

<details>
<summary>Lesson 26. Generics (дженерики)</summary>


## Введение в Дженерики в Java

### Введение в дженерики: что это такое и зачем они нужны
- **Определение**: Дженерики (Generics) в Java - это механизм языка программирования, позволяющий определять классы, интерфейсы и методы с параметризованными типами.
- **Цель использования**: Дженерики предоставляют способ создания классов, методов и интерфейсов с гибкой типизацией, повышая при этом безопасность работы с типами данных.

### Обзор проблем, которые решают дженерики в Java
- **Улучшение читаемости и безопасности кода**: Дженерики обеспечивают строгую проверку типов во время компиляции, что помогает предотвращать ошибки, связанные с неправильным приведением типов.
- **Избавление от необходимости приведения типов**: Предоставляют возможность использовать обобщенные типы, что устраняет необходимость в явном приведении типов и упрощает код.
- **Повышение переиспользуемости кода**: Позволяют создавать более общие и гибкие структуры данных и алгоритмы, которые могут работать с любыми типами данных.
- **Примеры решаемых проблем**: Код без дженериков часто подвержен ошибкам из-за неправильных приведений и может быть менее читаемым. Дженерики устраняют эти проблемы, обеспечивая типобезопасность и улучшенную читаемость.

## Примеры использования Generics

### Создание собственного обобщенного класса
- **Описание**: Обобщенные классы в Java используются для создания классов с типами, которые определяются в момент создания экземпляра класса. Это позволяет создавать более универсальные и многоразовые компоненты.
- **Пример без использования коллекций**:

  ```java
  public class Box<T> {
      private T content;

      public Box(T content) {
          this.content = content;
      }

      public T getContent() {
          return content;
      }

      public void setContent(T content) {
          this.content = content;
      }
  }

  // Использование
  Box<String> stringBox = new Box<>("Hello, Generics!");
  Box<Integer> integerBox = new Box<>(123);
  ```

### Преимущества использования дженериков
- **Безопасность типов:** Дженерики обеспечивают проверку типов во время компиляции, что позволяет избегать ошибок `ClassCastException` во время выполнения.
- **Повышение гибкости:** Позволяют создавать код, который может работать с различными типами данных, увеличивая повторное использование и универсальность компонентов.
- **Читаемость кода:** Упрощают понимание и поддержку кода, так как типы данных становятся ясными и предсказуемыми.

## Стирание типов (Type Erasure)

### Объяснение процесса стирания типов в Java
- **Что такое стирание типов**: Стирание типов - это процесс, при котором компилятор Java преобразует все обобщенные типы (generics) в обычные объектные типы или другие не-обобщенные типы. Это делается для обеспечения совместимости с кодом, написанным до введения дженериков в Java 5.
- **Как это работает**: Во время компиляции, все типовые параметры в обобщенных типах заменяются их границами (bounds) или, если границы не указаны, типом `Object`.

### Как стирание типов влияет на использование дженериков
- **Ограничения**: Стирание типов ограничивает некоторые возможности, например, нельзя использовать `instanceof` для проверки обобщенных типов, так как во время выполнения информация о точном обобщенном типе отсутствует.
- **Примеры ограничений**:
    - Невозможность создать экземпляр обобщенного типа (`new T()`).
    - Невозможность объявления статических переменных специфического обобщенного типа.

### Примеры и последствия стирания типов
- **Пример с обобщенным методом**:
  ```java
  public <T> boolean isEqual(T t1, T t2) {
      return t1.equals(t2);
  }
  // После стирания типов метод становится недоступным
  public boolean isEqual(Object t1, Object t2) {
      return t1.equals(t2);
  }
  ```

### Последствия для разработчика:
- Необходимость явного приведения типов при извлечении элементов из обобщенных коллекций.
- Невозможность полагаться на обобщенные типы во время выполнения для обеспечения типовой безопасности.

## Оберточные типы (Wrapper Types)

### Описание и использование оберточных типов в контексте дженериков
- **Описание**: Оберточные типы в Java — это классы, которые предоставляют способ обертывания примитивных типов данных (`int`, `double`, `char` и т.д.) в объекты. Это позволяет использовать примитивные типы в структурах, требующих объектов, как, например, в дженериках.
- **Основные оберточные классы**: `Integer` для `int`, `Double` для `double`, `Character` для `char` и так далее.
- **Применение в дженериках**: Так как дженерики работают только с объектами, оберточные типы необходимы для использования примитивных типов данных в обобщенных структурах.

### Примеры использования оберточных типов с дженериками
- **Пример с оберточным типом и дженериком**:
  ```java
  List<Integer> listOfIntegers = new ArrayList<>();
  listOfIntegers.add(10); // Автоупаковка int в Integer
  int first = listOfIntegers.get(0); // Автораспаковка Integer в int
  ```

Здесь `Integer` используется в качестве оберточного типа для `int`, чтобы позволить хранить целые числа в списке
`ArrayList`, который является обобщенным.

### Обсуждение преимуществ и ограничений оберточных типов
**Преимущества:**
- **Автоупаковка и автораспаковка:** Современные версии Java автоматически преобразуют примитивные типы в соответствующие оберточные типы и обратно, упрощая работу с ними.
- **Использование в коллекциях и дженериках:** Оберточные типы позволяют хранить примитивные данные в обобщенных структурах данных, таких как списки и множества.

**Ограничения:**
- **Производительность:** Использование оберточных типов может влиять на производительность из-за необходимости
- **Null-значения:** Оберточные типы могут содержать `null`, что может привести к `NullPointerException` в случаях,
  когда примитивный тип не допускает `null`.

## Заключение: Дженерики в Java

### Обобщение ключевых моментов урока

- **Важность дженериков**: Дженерики в Java являются мощным инструментом для повышения гибкости, безопасности типов и читаемости кода. Они позволяют создавать классы, интерфейсы и методы, которые могут работать с различными типами данных.

- **Примеры использования**: Мы рассмотрели, как дженерики используются для создания универсальных классов и методов, которые могут работать с любым типом данных, избегая при этом ошибок приведения типов и повышая читаемость кода.

- **Стирание типов**: Важно понимать, как стирание типов влияет на работу с дженериками, особенно в отношении ограничений, связанных с созданием экземпляров обобщенных типов и использованием дженериков во время выполнения.

- **Обобщенные методы**: Обобщенные методы добавляют дополнительную гибкость в программирование, позволяя создавать методы, адаптируемые к различным типам данных.

- **Оберточные типы**: Оберточные типы играют ключевую роль в использовании дженериков с примитивными типами данных, обеспечивая автоупаковку и автораспаковку между примитивами и их обертками.

### Заключительные мысли
- Использование дженериков в Java требует понимания их основ и ограничений. Они обеспечивают безопасность типов и избавляют от необходимости явного приведения типов, делая код более гибким и легко поддерживаемым.
- Практика и применение этих концепций в реальных проектах помогут углубить понимание и эффективно использовать преимущества дженериков в программировании на Java.


</details>