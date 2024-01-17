public interface Rentable {
    /**
     * ИНТЕРФЕЙС урок 20
     * Сдает квартиру в аренду на указанный срок.
     * @param months Количество месяцев аренды.
     */
    void rentOut(int months);

    /**
     * Прекращает договор аренды.
     */
    void terminateRental();
}
