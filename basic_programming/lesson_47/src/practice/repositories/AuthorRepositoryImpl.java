package practice.repositories;

import practice.interfaces.AuthorRepository;
import practice.models.Author;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    private List<Author> authors;

    /**
     * данная конструкция необходима так как в случае первого создания данного объекта AuthorRepositoryImpl все поля
     * будут проинициализированны значениями по умолчанию, для ссылочных объектов, в данном случае List<Author> authors,
     * значения по умолчанию равны null, что в последствии приведет к NullPointerException. Дабы избежать этого, лист
     * инициализируется внутри конструктора при создании экземпляра класса
     */
    public AuthorRepositoryImpl() {
        authors = new ArrayList<>();
    }

    /**
     * данный конструктор позволяет нам создать репозиторий авторов на основе уже имеющейся коллекции из авторов. По той
     * же причине, что и в другом конструкторе, дабы избежать NullPointerException, мы инициализируем List<Author>
     * authors, как новый массив. Также это зазитит нас от перекрестных ссылок, если мы будем просто ссылаться на объект
     * из контруктора, тк в этом случае изменение одного объекта будет отражаться на другом, тк ссылки двух переменных
     * будут указывать на один объект
     *
     * @param authors
     */
    public AuthorRepositoryImpl(Collection<Author> authors) {
        this.authors = new ArrayList<>(authors);
    }

    @Override
    public void addAuthor(Author author) {
        if (authors.contains(author)) {
            System.out.println("Author has already exist");
        } else {
            authors.add(author);
            System.out.println("Author has been added");
        }
    }

    @Override
    public List<Author> findAllAuthors() {
        return authors;
    }

    @Override
    public boolean removeAuthor(Author author) {
        return authors.remove(author);
    }
}
