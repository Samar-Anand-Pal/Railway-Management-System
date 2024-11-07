package com.example.railway_management.service;

import com.example.railway_management.model.FoodOrder;
import com.example.railway_management.model.Passenger;
import com.example.railway_management.model.Ticket;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class PdfExportService {

    // Method to generate the PDF
    public static ByteArrayInputStream passengerPDFReport(List<Passenger> passengers, Ticket ticket, int distance, List<FoodOrder> foodOrders, List<Double> foodPrices) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Passenger Information", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            // Creating Table with 6 columns (5 for passenger info and 1 for train info)
            PdfPTable table = new PdfPTable(6);

            // Define PDF Table Headers
            Stream.of("First Name", "Gender", "Age", "Seat No", "Coach No", "Train").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.CYAN);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            // Adding Passenger Data to Table
            for (Passenger passenger : passengers) {
                PdfPCell firstNameCell = new PdfPCell(new Phrase(passenger.getFirstName()));
                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(firstNameCell);

                PdfPCell genderCell = new PdfPCell(new Phrase(passenger.getGender()));
                genderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(genderCell);

                // Calculate Age from Date of Birth
                int age = passenger.getAge();
                PdfPCell ageCell = new PdfPCell(new Phrase(String.valueOf(age)));
                ageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(ageCell);

                // Seat Number Cell
                int seatNo = passenger.getSeatNo();
                PdfPCell seatNoCell = new PdfPCell(new Phrase(String.valueOf(seatNo)));
                seatNoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(seatNoCell);

                // Coach Number Cell
                int coachNo = passenger.getCoachNo();
                PdfPCell coachNoCell = new PdfPCell(new Phrase(String.valueOf(coachNo)));
                coachNoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(coachNoCell);

                int trainNo = ticket.getTrainId();
                PdfPCell trainNoCell = new PdfPCell(new Phrase(String.valueOf(trainNo)));
                trainNoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(trainNoCell);
            }

            // Add Table to the Document
            document.add(table);

            // Add a section for Food Orders corresponding to the ticketId
            if (!foodOrders.isEmpty()) {
                document.add(Chunk.NEWLINE);
                Paragraph foodOrderHeader = new Paragraph("Food Orders", FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
                foodOrderHeader.setAlignment(Element.ALIGN_CENTER);
                document.add(foodOrderHeader);

                // Creating Table for Food Orders
                PdfPTable foodTable = new PdfPTable(4); // 4 columns for food name, quantity, price, and total price

                // Define PDF Table Headers for Food Orders
                Stream.of("Food Name", "Quantity", "Price", "Total Price").forEach(headerTitle -> {
                    PdfPCell header = new PdfPCell();
                    Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                    header.setBackgroundColor(Color.CYAN);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(headerTitle, headFont));
                    foodTable.addCell(header);
                });

                // Adding Food Orders Data to the Table
                for (int i = 0; i < foodOrders.size(); i++) {
                    FoodOrder foodOrder = foodOrders.get(i);
                    PdfPCell foodNameCell = new PdfPCell(new Phrase(foodOrder.getFoodName()));
                    foodNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    foodTable.addCell(foodNameCell);

                    PdfPCell quantityCell = new PdfPCell(new Phrase(String.valueOf(foodOrder.getQuantity())));
                    quantityCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    foodTable.addCell(quantityCell);

                    // Use the calculated price from the list
                    double foodPrice = foodPrices.get(i);
                    PdfPCell priceCell = new PdfPCell(new Phrase(String.valueOf(foodPrice)));
                    priceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    foodTable.addCell(priceCell);

                    // Calculate and display the total price
                    double totalPrice = foodPrice * foodOrder.getQuantity();
                    PdfPCell totalPriceCell = new PdfPCell(new Phrase(String.valueOf(totalPrice)));
                    totalPriceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    foodTable.addCell(totalPriceCell);
                }

                // Add Food Orders Table to the Document
                document.add(foodTable);
            }

            // Close the Document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
