package ru.innopolis;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.OutputStream;

/**
 * <b>Генератор PDF-отчета</b>
 * Created by <i><b>s.molokovskikh</i></b> on 13.11.17.
 */
public class JasperReportGeneartor {

    private static final Logger LOG = LoggerFactory.getLogger(JasperReportGeneartor.class);

    static void generateJasperReportPdf(OutputStream out, ServletContext servletContext) {

        try {
            String realPath = servletContext.getRealPath("json_report_template.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(realPath);
            new JasperReportBuilder()
                    .setDataSource(getJsonDataSource())
                    .setTemplateDesign(jasperDesign)
                    .toPdf(out);
        } catch (DRException |JRException e) {
            LOG.error("Error load template jasperReport: {}", e);
        }

    }

    private static JRDataSource getJsonDataSource() throws JRException {
        JsonDataSource jsonDataSource = new JsonDataSource("http://resources.finance.ua/ua/public/currency-cash.json","organizations");
        return jsonDataSource;
    }

}
