package Task_1;

public class PrintReport {

    public String printReport(Report report) {
        // какая-то логика
        return "Печать отчета: \n" + report.getNameOfReport() + "\n"
                + "Номер отчета: " + report.getNumberOfReport();
    }
}
