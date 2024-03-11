<details>
<summary>Lesson 48. Practical lesson </summary>

# Lesson 48. Practical lesson
## Development of a content management system (CMS)

A Content Management System (CMS) is an application that allows users to create, edit, and delete
articles or blog posts. The implementation of such a system includes the creation of a multi-layered architecture consisting of
data models, repositories for storing information and a service layer for processing business logic.

### Models

The application is based on the following models:

- **Article (Article):**
  - `ID': The unique identifier of the article.
  - `title': The title of the article.
  - `content': The content of the article.
  - `publishDate': Date of publication.
  - `AuthorID': The ID of the author of the article.

- **Author:**
- `ID': The unique identifier of the author.
  - `name': The name of the author.
  - `email`: The author's email address.
  - `bio`: A brief biography of the author.

- **Comment:**
- `ID': The unique identifier of the comment.
  - `articleId': The ID of the article to which the comment was left.
  - `text': The text of the comment.
  - `publishDate': The date the comment was published.
  - `AuthorID': The ID of the comment's author.

### Repositories

Repositories responsible for storing and retrieving data are defined for each model:

- **ArticleRepository:** Managing articles (adding, searching, updating, deleting).
- **AuthorRepository:** Author management (add, search, update, delete).
- **CommentRepository:** Comment management (add, search, update, delete).

### Service layer

The service layer contains the business logic of the application and links the user interface to the repositories:

- **ArticleService:** The logic of working with articles, including creating, searching by criteria, updating and deleting.
- **AuthorService:** Author management, including adding new authors and updating their data.
- **CommentService:** Processing comments, including adding to articles, searching for them, updating and deleting them.

This multi-layered architecture allows for a clear division of responsibility between the various components of the system,
thereby facilitating its development, testing and support.

</details>

-----------------
<details>
<summary>Урок 48.  Практическое занятие </summary>

# Урок 48.  Практическое занятие 
## Разработка системы управления контентом (CMS)

Система управления контентом (CMS) - это приложение, которое позволяет пользователям создавать, редактировать и удалять
статьи или блог-посты. Реализация такой системы включает в себя создание многослойной архитектуры, состоящей из моделей
данных, репозиториев для хранения информации и сервисного слоя для обработки бизнес-логики.

### Модели

В основе приложения лежат следующие модели:

- **Статья (Article):**
    - `ID`: Уникальный идентификатор статьи.
    - `title`: Заголовок статьи.
    - `content`: Содержимое статьи.
    - `publishDate`: Дата публикации.
    - `authorId`: Идентификатор автора статьи.

- **Автор (Author):**
    - `ID`: Уникальный идентификатор автора.
    - `name`: Имя автора.
    - `email`: Электронная почта автора.
    - `bio`: Краткая биография автора.

- **Комментарий (Comment):**
    - `ID`: Уникальный идентификатор комментария.
    - `articleId`: Идентификатор статьи, к которой оставлен комментарий.
    - `text`: Текст комментария.
    - `publishDate`: Дата публикации комментария.
    - `authorId`: Идентификатор автора комментария.

### Репозитории

Для каждой модели определены репозитории, отвечающие за хранение и извлечение данных:

- **ArticleRepository:** Управление статьями (добавление, поиск, обновление, удаление).
- **AuthorRepository:** Управление авторами (добавление, поиск, обновление, удаление).
- **CommentRepository:** Управление комментариями (добавление, поиск, обновление, удаление).

### Сервисный слой

Сервисный слой содержит бизнес-логику приложения и связывает пользовательский интерфейс с репозиториями:

- **ArticleService:** Логика работы со статьями, включая создание, поиск по критериям, обновление и удаление.
- **AuthorService:** Управление авторами, включая добавление новых авторов и обновление их данных.
- **CommentService:** Обработка комментариев, включая добавление к статьям, их поиск, обновление и удаление.

Эта многослойная архитектура позволяет четко разделить ответственность между различными компонентами системы, облегчая
тем самым ее разработку, тестирование и поддержку.

</details>

