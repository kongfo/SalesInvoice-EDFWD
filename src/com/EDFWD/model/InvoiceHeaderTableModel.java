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
public class InvoiceHeaderTableModel extends AbstractTableModel {

    public void removeRow(int selectedRowForDeletion) {
        
    }

    private List<InvoiceHeader> invoicesList;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    public InvoiceHeaderTableModel(List<InvoiceHeader> invoicesList) {
        this.invoicesList = invoicesList;
    }

    public List<InvoiceHeader> getInvoicesList() {
        return invoicesList;
    }
    
    
    @Override
    public int getRowCount() {
        return invoicesList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Invoice Num";
            case 1 -> "Customer Name";
            case 2 -> "Invoice Date";
            case 3 -> "Invoice Total";
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Integer.class;
            case 1 -> String.class;
            case 2 -> String.class;
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
        InvoiceHeader row = invoicesList.get(rowIndex);
        
        return switch (columnIndex) {
            case 0 -> row.getInvNum();
            case 1 -> row.getCustomerName();
            case 2 -> df.format(row.getInvDate());
            case 3 -> row.getInvTotal();
            default -> "";
        };
        
    }
    
}

