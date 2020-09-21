package controllers;

import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;

public interface Operations {
    public boolean Insert(Object object, InputStream image);
    public boolean Delete(Object object);
    public boolean Update(Object object);
    public ArrayList<Object[]> Select();
    public void searchData(String searchQuery, JTable table ,JFrame frame);
    public String getImage(String id);
}
 