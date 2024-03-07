package Task_1;

import java.util.Random;

public class FormReport {
    private int numberOfReport;
    private String nameOfReport;

    public FormReport() {
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

    public FormReport formReport() {
        // просто какая-то логика по формированию отчета
        FormReport report = new FormReport();
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
}
