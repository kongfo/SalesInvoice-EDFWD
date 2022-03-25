/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EDFWD.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Mohamed
 */
public class InvoiceLinesTableModel extends AbstractTableModel {

    private List<InvoiceLine> invoiceLines;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    public InvoiceLinesTableModel(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }
    
    
    @Override
    public int getRowCount() {
        return invoiceLines.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Item Name";
            case 1 -> "Item Price";
            case 2 -> "Count";
            case 3 -> "Line Total";
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> String.class;
            case 1 -> Double.class;
            case 2 -> Integer.class;
            case 3 -> Double.class;
            default -> Object.class;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine row = invoiceLines.get(rowIndex);
        
        return switch (columnIndex) {
            case 0 -> row.getItemName();
            case 1 -> row.getItemPrice();
            case 2 -> row.getItemCount();
            case 3 -> row.getLineTotal();
            default -> "";
        };
        
    }
    
}
