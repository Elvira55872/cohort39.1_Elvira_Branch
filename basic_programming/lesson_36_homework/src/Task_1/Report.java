package Task_1;

import java.util.Random;

/**
 * Задание 1
 * Создать класс Report, который имеет две ответственности:
 * формирование и печать отчёта.
 * <p>
 * Затем разделите его так, чтобы каждый класс имел только одну ответственность.
 */

public class Report {
    private int numberOfReport;
    private String nameOfReport;

    public Report() {
        numberOfReport = 0;
        nameOfReport = null;
    }

    public void setNumberOfReport(int numberOfReport) {
        this.numberOfReport = numberOfReport;
    }

    public void setNameOfReport(String nameOfReport) {
        this.nameOfReport = nameOfReport;
    }

    public int getNumberOfReport() {
        return numberOfReport;
    }

    public String getNameOfReport() {
        return nameOfReport;
    }

    public Report formReport() {
        // просто какая-то логика по формированию отчета
        Report report = new Report();
        Random random = new Random();

        report.setNumberOfReport(random.nextInt(0, 3));
        if (report.getNumberOfReport() == 0) {
            report.setNameOfReport("Отчет о работе");
        } else if (report.getNumberOfReport() == 1) {
            report.setNameOfReport("Отчет о результатах");
        } else if (report.getNumberOfReport() == 2) {
            report.setNameOfReport("Отчет о затратах");
        }
        return report;
    }

    public String printReport(Report report) {
        // какая-то логика
        return "Печать отчета: \n" + report.getNameOfReport() + "\n"
                + "Номер отчета: " + report.getNumberOfReport();
    }
}
