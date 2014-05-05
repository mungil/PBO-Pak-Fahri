/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//from : http://javahungry.blogspot.com/2013/06/calendar-implementation-gui-based.html
package calender;

/**
 *
 * @author tea
 */
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Calender
{
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static JLabel lblMonth, lblYear, lblChMonth;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear, cmbMonth;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //tabel model
    static JScrollPane stblCalendar; //the scrollpane
    static JPanel pnlCalendar;
    static int realYear, realMonth, realDay, currentYear, currentMonth;
    static String fullMonth;
    static int page = 10; //for year
   
    public static void main(String args []) {
        //look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException e) { }
        catch(InstantiationException e) { }
        catch(IllegalAccessException e) { }
        catch(UnsupportedLookAndFeelException e) { }
        
        
        //prepare frame
        frmMain = new JFrame("Example Calender GUI");
        frmMain.setSize(670, 350); //Set size tp 400x400
        pane    = frmMain.getContentPane(); //Get content pane
        pane.setLayout(null); //Applay null layout
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cose when X clicked
        
        //Create controls        
        lblChMonth = new JLabel("Month");
        lblChMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        lblYear = new JLabel("Year");
        lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        //Create button next & prev
        btnPrev = new JButton("<< Prev");
        btnNext = new JButton("Next >>");
        
        cmbYear     = new JComboBox();
        cmbMonth    = new JComboBox(months);      
        
        mtblCalendar    = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        
        tblCalendar = new JTable(mtblCalendar);
        tblCalendar.setFont(new Font("Tahoma", Font.ITALIC, 14));
        
        stblCalendar    = new JScrollPane(tblCalendar);
        pnlCalendar     = new JPanel(null);
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder(""));
        
        //Register actions listeners
        cmbYear.addActionListener(new cmbYear_Action());
        cmbMonth.addActionListener(new cmbMonth_Action());
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        
        //Add controls to pane
        pane.add(pnlCalendar);
        pnlCalendar.add(lblChMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(cmbMonth);
        pnlCalendar.add(stblCalendar, BorderLayout.CENTER);
        
        //Set bounds
        //setBounds(int x, int y, int width, int height)
        pnlCalendar.setBounds(10, 10, 650, 300);
        lblChMonth.setBounds(10, 13, 50, 20);
        lblYear.setBounds(200, 13, 100, 20);
        cmbYear.setBounds(250, 13, 80, 20);
        cmbMonth.setBounds(75, 13, 110, 20);
        btnPrev.setBounds(375, 10, 100, 25);
        btnNext.setBounds(500, 10, 100, 25);
        stblCalendar.setBounds(10, 45, 630, 244);
        
        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        
        //Get real month/year
        GregorianCalendar cal   = new GregorianCalendar(); //Create calendar
        realDay                 = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth               = cal.get(GregorianCalendar.MONTH); //Get month        
        realYear                = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth            = realMonth; //Match month and year
        currentYear             = realYear;
        
        //Add headers
        String[] headers = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday"}; //All headers
        for(int i=0; i<7; i++) {
            mtblCalendar.addColumn(headers[i]);
        }
        
       
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(37);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
        
        //set autoselect cmbMonth in today
        cmbMonth.setSelectedIndex(realMonth);
        
        //Event click in table
        tblCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tblCalendar.rowAtPoint(e.getPoint());
                int col = tblCalendar.columnAtPoint(e.getPoint());
                //build dialog
                JOptionPane.showMessageDialog(null,"Date in your click : "+tblCalendar.getValueAt(row,col).toString()+"/"+currentMonth+"/"+currentYear);
            }
        });
        
        //Change background in event click in table
        
        //Populate table
        for (int i=realYear-page; i<=realYear+page; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (realMonth, realYear); //Refresh calendar
    }
    
    public static void refreshCalendar(int month, int year) {
        //variables
        int nod, som;
        
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        
        //Too early
        if(month==0 && year==realYear-page) {
            btnPrev.setEnabled(false);
        }
        //Too late
        if(month==11 && year==realYear+page) {
            btnNext.setEnabled(false);
        }
        
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combobox
        
        //Clear table
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw calendar
        for(int i=1; i<=nod; i++){
            int row     = new Integer((i+som-2)/7);
            int column  = (i+som-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }
        
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
        
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
                    setBackground(new Color(192, 192, 192));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            setHorizontalAlignment(JLabel.CENTER); //setting align element
            return this;
        }
    }
    
    static class btnPrev_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(currentMonth == 0) {
                currentMonth = 11;
                currentYear -= 1;
                cmbMonth.setSelectedIndex(currentMonth);
                cmbYear.setSelectedItem(currentYear);
            }
            else {
                currentMonth -= 1;
                cmbMonth.setSelectedIndex(currentMonth);
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    
    static class btnNext_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(currentMonth == 11) {
                currentMonth = 0;
                currentYear += 1;
                cmbMonth.setSelectedIndex(currentMonth);
                cmbYear.setSelectedItem(currentYear);
            }
            else {
                currentMonth += 1;
                cmbMonth.setSelectedIndex(currentMonth);
            }
            refreshCalendar(currentMonth, currentYear);            
        }
    }
    
    static class cmbYear_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(cmbYear.getSelectedItem()!=null) {
                String b    = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }
    
    static class cmbMonth_Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(cmbMonth.getSelectedItem()!=null) {
                String a = cmbMonth.getSelectedItem().toString();
                switch(a) {
                    case "January"   : currentMonth = 0; break;                 
                    case "February"  : currentMonth = 1; break;
                    case "March"     : currentMonth = 2; break;
                    case "April"     : currentMonth = 3; break;
                    case "May"       : currentMonth = 4; break;
                    case "June"      : currentMonth = 5; break;
                    case "July"      : currentMonth = 6; break;
                    case "August"    : currentMonth = 7; break;
                    case "September" : currentMonth = 8; break;
                    case "October"   : currentMonth = 9; break;
                    case "November"  : currentMonth = 10; break;
                    case "December"  : currentMonth = 11; break;
                    default : currentMonth = 0; break;
                }
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }
}