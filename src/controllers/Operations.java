package controllers;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public interface Operations {
    public boolean Insert(Object object);
    public boolean Delete(Object object);
    public boolean Update(Object object);
    public ArrayList<Object[]> Select();
    public void searchData(String searchQuery, JTable table ,JFrame frame);
}
 