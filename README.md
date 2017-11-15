# Исследование JasperReport

## Последовательность запуска ##

1. git clone https://github.com/molokovskikh/jasperReportPdfExample
2. cd jasperReportPdfExample
3. ./gradlew appStartWar

для оставновки сервера необходимо в другой консоли запустить
1. cd jasperReportPdfExample
2. ./gradlew appStop

 тестовый URL для возврата PDF-отчета
 http://localhost:8080/jasperReportPdfExample/rest/api/jasperreport/pdf

 тестовый URL для проверки работоспособности
 http://localhost:8080/jasperReportPdfExample/rest/api/jasperreport/echo?message=helloWorld
