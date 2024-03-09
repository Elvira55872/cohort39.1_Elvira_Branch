@FunctionalInterface
interface Action<T> {
    void execute(T t);
}