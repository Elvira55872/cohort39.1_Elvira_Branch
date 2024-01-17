package lesson21.OOP.residential;

public interface Rentable {
    /**
     * Сдает квартиру в аренду на указанный срок.
     * @param months Количество месяцев аренды.
     */
    void rentOut(int months);

    /**
     * Прекращает договор аренды.
     */
    void terminateRental();
}
