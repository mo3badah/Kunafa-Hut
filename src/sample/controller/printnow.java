/*
package sample.controller;

import javafx.print.PrinterJob;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class printnow {

    public static void printCard(final String bill ) {
        final PrinterJob job = PrinterJob.getPrinterJob();

        Printable contentToPrint = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2d.setFont(new Font("Monospaced", Font.BOLD, 7));

                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                } //Only one page

                String Bill [] = bill.split(";");
                int y = 0;
                for (int i = 0; i < Bill.length; i++) {
                    g2d.drawString(Bill[i], 0, y);
                    y = y + 15;
                }

                return PAGE_EXISTS;
            }
        };

        PageFormat pageFormat = new PageFormat();
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        Paper pPaper = pageFormat.getPaper();
        pPaper.setImageableArea(0, 0, pPaper.getWidth() , pPaper.getHeight() -2);
        pageFormat.setPaper(pPaper);
        job.setPrintable(contentToPrint, pageFormat);

        try {
            job.print();
        } catch (PrinterException e) {
            System.err.println(e.getMessage());
        }
    }
}
*/