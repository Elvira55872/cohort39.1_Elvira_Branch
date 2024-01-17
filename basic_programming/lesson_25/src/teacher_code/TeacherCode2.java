package teacher_code;

import practice.IncorrectFloorNumberException;

public class TeacherCode2 {
    public static void main(String[] args) {
        // если метод выбрасывает задекларированный checked exception, как метод:
        // setFloor(int floor) -> throws IncorrectFloorNumberException <-
        // мы обязаны обработать вызов данного кода спецефическим образом,
        // то есть теперь мы не можем просто вызвать данный метод:
        // setFloor(13);
        // мы должны сделать это либо в блоке try-catch,
        // либо добавить аналогичное предупреждение в сигнатуру метода, откуда происходит вызов, в нашем случае:

        //      main(String[] args)     -> throws IncorrectFloorNumberException <-      {
        //          setFloor(13);
        //      }

        try {
            setFloor(13);
        } catch (IncorrectFloorNumberException e) {
            e.printStackTrace();
        }

        System.out.println("Работа завершена");

    }

    // throws - выбрасывает, те буквально, метод "setFloor" выбрасывает исключение "IncorrectFloorNumberException"
    // если бы, IncorrectFloorNumberException унаследовался от одного из RuntimeException, то он бы относился к
    // unchecked exception и не было бы потребности указывать в сигнатуре метода, о том,
    // что данный метод может приводить к подобной ошибке
    static void setFloor(int floor) throws IncorrectFloorNumberException {
        if (floor == 13) {
            IncorrectFloorNumberException exception = new IncorrectFloorNumberException("13 этажа быть не должно!");

            // throw - выбрось, то есть буквально "выбрось новое IncorrectFloorNumberException"
            throw exception;

            // непроверяемое исключение (unchecked exception), оно не требует указания в сигнатуре метода
            // throw new RuntimeException("message");
        } else if (floor > 15) {
            // new IncorrectFloorNumberException("Здание не должно быть выше 15 этажей!") -
            // экземпляр класса IncorrectFloorNumberException
            throw new IncorrectFloorNumberException("Здание не должно быть выше 15 этажей!");
            // return
        }

        System.out.println("Correct floor number: " + floor);
    }




    public static void example() {
        // прилоение переводчик
        // - загрузите файл пдф, ворд и тп
        // - пользователь загружает архив с такими файлами
        try {
            // попытка прочесть то что там загрузил пользователь
        } catch (Exception ex) {
            // обработка исключений, если пользователь отправил некорректный файл
            // или файл закрыт паролем и чтение недоступно
        }



        // попытка отправить огромный файл
        try {
            // пытаемся отправить данный файл
        } catch (Exception ex) {
            // сетевое подключение прервалось и файл не отправился

        }
    }
}
