/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.panels;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Room;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Bisso
 */
public class RoomsPanel extends javax.swing.JPanel {

    /**
     * Creates new form RoomsPanel
     */
    private int hospital_id;
    void HideAddAndRemoves(){
        AddCVICU.setVisible(false);
        RemoveCVICU.setVisible(false);
        AddMICU.setVisible(false);
        RemoveMICU.setVisible(false);
        AddNICU.setVisible(false);
        RemoveNICU.setVisible(false);
        AddPICU.setVisible(false);
        RemovePICU.setVisible(false);
        AddSICU.setVisible(false);
        RemoveSICU.setVisible(false);
        AddTICU.setVisible(false);
        RemoveTICU.setVisible(false);
        AddER.setVisible(false);
        RemoveER.setVisible(false);
        AddCovid19.setVisible(false);
        RemoveCovid19.setVisible(false);
    }
    void DeleteAll() throws IOException{
        
       
        for(int i=21;i<=22;i++)
        {
         URL url = new URL("https://glacial-everglades-74360.herokuapp.com/room/"+i);
         HttpURLConnection http = (HttpURLConnection)url.openConnection();
         http.setRequestMethod("DELETE");
         int respondeCode=http.getResponseCode();
        System.out.println("The POST Request Response Code :  " + respondeCode);  
        System.out.println("The POST Request Response Message : " + http.getResponseMessage());

         http.disconnect();
        }
        
    }
    void CreateRooms() throws IOException{
        SetNewRoom("CVICU",false,0);
        SetNewRoom("MICU",false,0);
        SetNewRoom("NICU",false,0);
        SetNewRoom("PICU",false,0);
        SetNewRoom("SICU",false,0);
        SetNewRoom("TICU",false,0);
        SetNewRoom("ER",false,0);
        SetNewRoom("Covid19",false,0);
        
    }
    
    void GetShow(int id)throws IOException{
         HttpURLConnection connection = (HttpURLConnection) new URL("https://glacial-everglades-74360.herokuapp.com/room/?format=json&hid="+id).openConnection();	
	connection.setRequestProperty("Content-Type","application/json");  
        connection.setRequestMethod("GET");
        int respondeCode=connection.getResponseCode();
        //System.out.println("The POST Request Response Code :  " + respondeCode);  
        //System.out.println("The POST Request Response Message : " + connection.getResponseMessage());
        String read="";
        InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());  
        BufferedReader bf = new BufferedReader(isrObj);  
        StringBuffer responseStr = new StringBuffer();  
        while ((read = bf .readLine()) != null)  
        {  
            responseStr.append(read); 
        } 
        System.out.println(responseStr);
        bf.close();  
        connection.disconnect();
        JSONArray arr = new JSONArray(responseStr.toString());
        ArrayList<Integer> vector = new ArrayList<Integer>();
        
        for(int i=0;i<arr.length();i++)
        {
            JSONObject obj = arr.getJSONObject(i);
            if(obj.getString("type").equals("CVICU"))
            {
                CVICU.setText(Integer.toString(obj.getInt("number")));
            }
            else if(obj.getString("type").equals("MICU"))
            {
                MICU.setText(Integer.toString(obj.getInt("number")));
            }
            else if(obj.getString("type").equals("NICU"))
            {
                NICU.setText(Integer.toString(obj.getInt("number")));
            }
            else if(obj.getString("type").equals("SICU"))
            {
                SICU.setText(Integer.toString(obj.getInt("number")));
            }
            else if(obj.getString("type").equals("PICU"))
            {
                PICU.setText(Integer.toString(obj.getInt("number")));
            }
            else if(obj.getString("type").equals("TICU"))
            {
                TICU.setText(Integer.toString(obj.getInt("number")));
            }
            else if(obj.getString("type").equals("ER"))
            {
                ER.setText(Integer.toString(obj.getInt("number")));
            }
            else if(obj.getString("type").equals("Covid 19"))
            {
                Covid19.setText(Integer.toString(obj.getInt("number")));
            }
        }
    }
    public RoomsPanel(int id) throws IOException {
        initComponents();
        HideAddAndRemoves();
        /*CreateRooms();*/
        //DeleteAll();
        hospital_id=id;
        GetShow(hospital_id);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CVICU = new javax.swing.JLabel();
        AddCVICU = new javax.swing.JLabel();
        RemoveCVICU = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        MICU = new javax.swing.JLabel();
        AddMICU = new javax.swing.JLabel();
        RemoveMICU = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        NICU = new javax.swing.JLabel();
        AddNICU = new javax.swing.JLabel();
        RemoveNICU = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        PICU = new javax.swing.JLabel();
        AddPICU = new javax.swing.JLabel();
        RemovePICU = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        SICU = new javax.swing.JLabel();
        AddSICU = new javax.swing.JLabel();
        RemoveSICU = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        TICU = new javax.swing.JLabel();
        AddTICU = new javax.swing.JLabel();
        RemoveTICU = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        ER = new javax.swing.JLabel();
        AddER = new javax.swing.JLabel();
        RemoveER = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        Covid19 = new javax.swing.JLabel();
        AddCovid19 = new javax.swing.JLabel();
        RemoveCovid19 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(1023, 148));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(128, 128, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/emergency.png"))); // NOI18N
        jLabel1.setText("Room");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setFocusTraversalPolicyProvider(true);
        jLabel1.setIconTextGap(15);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addGap(148, 148, 148))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(175, 75, 75));
        jLabel2.setText("CVICU");

        CVICU.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        CVICU.setForeground(new java.awt.Color(128, 128, 131));
        CVICU.setText("0");
        CVICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CVICUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CVICUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CVICUMousePressed(evt);
            }
        });

        AddCVICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddCVICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddCVICUMousePressed(evt);
            }
        });

        RemoveCVICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveCVICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveCVICUMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(CVICU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(AddCVICU)
                .addGap(105, 105, 105)
                .addComponent(RemoveCVICU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CVICU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddCVICU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveCVICU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(175, 75, 75));
        jLabel20.setText("MICU");

        MICU.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        MICU.setForeground(new java.awt.Color(128, 128, 131));
        MICU.setText("0");
        MICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MICUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MICUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MICUMousePressed(evt);
            }
        });

        AddMICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddMICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddMICUMousePressed(evt);
            }
        });

        RemoveMICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveMICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveMICUMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addGap(66, 66, 66)
                .addComponent(MICU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(AddMICU)
                .addGap(107, 107, 107)
                .addComponent(RemoveMICU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MICU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddMICU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveMICU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(175, 75, 75));
        jLabel24.setText("NICU");

        NICU.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        NICU.setForeground(new java.awt.Color(128, 128, 131));
        NICU.setText("0");
        NICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NICUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NICUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NICUMousePressed(evt);
            }
        });

        AddNICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddNICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddNICUMousePressed(evt);
            }
        });

        RemoveNICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveNICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveNICUMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel24)
                .addGap(73, 73, 73)
                .addComponent(NICU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(AddNICU)
                .addGap(108, 108, 108)
                .addComponent(RemoveNICU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NICU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddNICU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveNICU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(175, 75, 75));
        jLabel28.setText("PICU");

        PICU.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        PICU.setForeground(new java.awt.Color(128, 128, 131));
        PICU.setText("0");
        PICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PICUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PICUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PICUMousePressed(evt);
            }
        });

        AddPICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddPICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddPICUMousePressed(evt);
            }
        });

        RemovePICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemovePICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemovePICUMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel28)
                .addGap(78, 78, 78)
                .addComponent(PICU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(AddPICU)
                .addGap(109, 109, 109)
                .addComponent(RemovePICU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PICU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddPICU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemovePICU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(175, 75, 75));
        jLabel32.setText("SICU");

        SICU.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        SICU.setForeground(new java.awt.Color(128, 128, 131));
        SICU.setText("0");
        SICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SICUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SICUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SICUMousePressed(evt);
            }
        });

        AddSICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddSICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddSICUMousePressed(evt);
            }
        });

        RemoveSICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveSICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveSICUMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel32)
                .addGap(78, 78, 78)
                .addComponent(SICU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(AddSICU)
                .addGap(111, 111, 111)
                .addComponent(RemoveSICU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SICU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddSICU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveSICU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(175, 75, 75));
        jLabel36.setText("TICU");

        TICU.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        TICU.setForeground(new java.awt.Color(128, 128, 131));
        TICU.setText("0");
        TICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TICUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TICUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TICUMousePressed(evt);
            }
        });

        AddTICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddTICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddTICUMousePressed(evt);
            }
        });

        RemoveTICU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveTICU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveTICUMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel36)
                .addGap(78, 78, 78)
                .addComponent(TICU, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(AddTICU)
                .addGap(111, 111, 111)
                .addComponent(RemoveTICU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TICU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddTICU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveTICU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(175, 75, 75));
        jLabel40.setText("ER");

        ER.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        ER.setForeground(new java.awt.Color(128, 128, 131));
        ER.setText("0");
        ER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ERMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ERMousePressed(evt);
            }
        });

        AddER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddERMousePressed(evt);
            }
        });

        RemoveER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveERMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel40)
                .addGap(106, 106, 106)
                .addComponent(ER, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(AddER)
                .addGap(110, 110, 110)
                .addComponent(RemoveER)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ER, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(175, 75, 75));
        jLabel44.setText("Covid 19");

        Covid19.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        Covid19.setForeground(new java.awt.Color(128, 128, 131));
        Covid19.setText("0");
        Covid19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Covid19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Covid19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Covid19MousePressed(evt);
            }
        });

        AddCovid19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddCovid19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddCovid19MousePressed(evt);
            }
        });

        RemoveCovid19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveCovid19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveCovid19MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel44)
                .addGap(35, 35, 35)
                .addComponent(Covid19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(AddCovid19)
                .addGap(108, 108, 108)
                .addComponent(RemoveCovid19)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Covid19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddCovid19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveCovid19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
         
    
    int AddOrMinus(int number,boolean Plus){
       if(Plus)number++;
        else  
        {
            number--;
            if(number<0)number++;
        }
        return number;
    }
    void SetNewRoom(String Type , boolean Plus , int number) throws MalformedURLException, IOException{
        Room room  = new Room();
        room.setType(Type);
        if(Type.equals("CVICU"))
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            CVICU.setText(Integer.toString(number));
        }
        else if(Type.equals("MICU"))
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            MICU.setText(Integer.toString(number));
        }
        else if(Type.equals("NICU"))
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            NICU.setText(Integer.toString(number));
        }
        else if(Type.equals("PICU"))
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            PICU.setText(Integer.toString(number));
        }
        else if(Type.equals("SICU"))
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            SICU.setText(Integer.toString(number));
        }
        else if(Type.equals("TICU"))
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            TICU.setText(Integer.toString(number));
        }
        else if(Type.equals("ER"))
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            ER.setText(Integer.toString(number));
        }
        else
        {
            number = AddOrMinus(number,Plus);
            room.setNumber(number);
            Covid19.setText(Integer.toString(number));
        }
        room.setPrice(1750);
        room.setHospitalID(hospital_id);
        String data="{\n";
        data+="\t\"number\":"+room.getNumber()+",\n";
        data+="\t\"price\":"+room.getPrice()+",\n";
        data+="\t\"type\":\""+room.getType()+"\",\n";
        data+="\t\"available\":"+"true"+",\n";
        data+="\t\"hospital\":"+room.getHospitalID()+"\n";
        data+="}\n";
        HttpURLConnection connection =(HttpURLConnection)new URL("https://glacial-everglades-74360.herokuapp.com/room/").openConnection();
        connection.setRequestProperty("Content-Type","application/json");  
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        OutputStream we = connection.getOutputStream();
        we.write(data.getBytes());
        int respondeCode=connection.getResponseCode();
        System.out.println(data);
        System.out.println("The POST Request Response Code :  " + respondeCode);  
        System.out.println("The POST Request Response Message : " + connection.getResponseMessage());
        connection.disconnect();
        we.close();
        
        
    } 
    ArrayList<Integer> GetNumberRoomType(int hospital_id,String type) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) new URL("https://glacial-everglades-74360.herokuapp.com/room/?format=json&hid="+hospital_id).openConnection();	
	connection.setRequestProperty("Content-Type","application/json");  
        connection.setRequestMethod("GET");
        int respondeCode=connection.getResponseCode();
        //System.out.println("The POST Request Response Code :  " + respondeCode);  
        //System.out.println("The POST Request Response Message : " + connection.getResponseMessage());
        String read="";
        InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());  
        BufferedReader bf = new BufferedReader(isrObj);  
        StringBuffer responseStr = new StringBuffer();  
        while ((read = bf .readLine()) != null)  
        {  
            responseStr.append(read); 
        } 
        System.out.println(responseStr);
        bf.close();  
        connection.disconnect();
        JSONArray arr = new JSONArray(responseStr.toString());
        ArrayList<Integer> vector = new ArrayList<Integer>();
        
        for(int i=0;i<arr.length();i++)
        {
            JSONObject obj = arr.getJSONObject(i);
            if(obj.getString("type").equals(type))
            {
                vector.add(obj.getInt("id"));
            }
        }
        return vector;
    }
    void Delete(int id) throws MalformedURLException, IOException{
       URL url = new URL("https://glacial-everglades-74360.herokuapp.com/room/"+id);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("DELETE");
        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();
    }
    private void CVICUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CVICUMouseEntered
        // TODO add your handling code here:
        CVICU.setForeground(new Color(175,75,75));
    }//GEN-LAST:event_CVICUMouseEntered

    private void CVICUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CVICUMouseExited
        // TODO add your handling code here:
        CVICU.setForeground(new Color(128,128,131));

    }//GEN-LAST:event_CVICUMouseExited

    private void MICUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MICUMouseEntered
        // TODO add your handling code here:
         MICU.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_MICUMouseEntered

    private void MICUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MICUMouseExited
        // TODO add your handling code here:
        MICU.setForeground(new Color(128,128,131));
        
    }//GEN-LAST:event_MICUMouseExited

    private void NICUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NICUMouseEntered
        // TODO add your handling code here:
        NICU.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_NICUMouseEntered

    private void NICUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NICUMouseExited
        // TODO add your handling code here:
        NICU.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_NICUMouseExited

    private void PICUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PICUMouseEntered
        // TODO add your handling code here:
        PICU.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_PICUMouseEntered

    private void PICUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PICUMouseExited
        // TODO add your handling code here:
        PICU.setForeground(new Color(128,128,131));
        
    }//GEN-LAST:event_PICUMouseExited

    private void SICUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SICUMouseEntered
        // TODO add your handling code here:
        SICU.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_SICUMouseEntered

    private void SICUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SICUMouseExited
        // TODO add your handling code here:
        SICU.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_SICUMouseExited

    private void TICUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TICUMouseEntered
        // TODO add your handling code here:
        TICU.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_TICUMouseEntered

    private void TICUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TICUMouseExited
        // TODO add your handling code here:
        TICU.setForeground(new Color(128,128,131));
        
    }//GEN-LAST:event_TICUMouseExited

    private void ERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ERMouseEntered
        // TODO add your handling code here:
        ER.setForeground(new Color(175,75,75));
    }//GEN-LAST:event_ERMouseEntered

    private void ERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ERMouseExited
        // TODO add your handling code here:
        ER.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_ERMouseExited

    private void Covid19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Covid19MouseEntered
        // TODO add your handling code here:
         Covid19.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_Covid19MouseEntered

    private void Covid19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Covid19MouseExited
        // TODO add your handling code here:
        Covid19.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_Covid19MouseExited

    private void CVICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CVICUMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddCVICU.setVisible(true);
        RemoveCVICU.setVisible(true);
    }//GEN-LAST:event_CVICUMousePressed

    private void MICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MICUMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddMICU.setVisible(true);
        RemoveMICU.setVisible(true);
   
    }//GEN-LAST:event_MICUMousePressed

    private void NICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NICUMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddNICU.setVisible(true);
        RemoveNICU.setVisible(true);
   
    }//GEN-LAST:event_NICUMousePressed

    private void PICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PICUMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddPICU.setVisible(true);
        RemovePICU.setVisible(true);
   
    }//GEN-LAST:event_PICUMousePressed

    private void SICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SICUMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddSICU.setVisible(true);
        RemoveSICU.setVisible(true);
   
    }//GEN-LAST:event_SICUMousePressed

    private void TICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TICUMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddTICU.setVisible(true);
        RemoveTICU.setVisible(true);
   
    }//GEN-LAST:event_TICUMousePressed

    private void ERMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ERMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddER.setVisible(true);
        RemoveER.setVisible(true);
   
    }//GEN-LAST:event_ERMousePressed

    private void Covid19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Covid19MousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddCovid19.setVisible(true);
        RemoveCovid19.setVisible(true);
   
    }//GEN-LAST:event_Covid19MousePressed

    private void AddCVICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCVICUMousePressed
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(CVICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"CVICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewRoom("CVICU",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddCVICUMousePressed

    private void RemoveCVICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveCVICUMousePressed
        try {
            int newNumber = Integer.parseInt(CVICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"CVICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewRoom("CVICU",false,newNumber);
            else 
            {
                CVICU.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveCVICUMousePressed

    private void AddMICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMICUMousePressed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(MICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"MICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewRoom("MICU",true,newNumber);
          
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddMICUMousePressed

    private void AddNICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNICUMousePressed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(NICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"NICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
           SetNewRoom("NICU",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddNICUMousePressed

    private void AddPICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPICUMousePressed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(PICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"PICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewRoom("PICU",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddPICUMousePressed

    private void AddSICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddSICUMousePressed
        // TODO add your handling code here:
           try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(SICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"SICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewRoom("SICU",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddSICUMousePressed

    private void AddTICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTICUMousePressed
        // TODO add your handling code here:
           try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(TICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"TICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewRoom("TICU",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddTICUMousePressed

    private void AddERMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddERMousePressed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(ER.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"ER");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewRoom("ER",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddERMousePressed

    private void AddCovid19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCovid19MousePressed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(Covid19.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"Covid19");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewRoom("Covid19",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddCovid19MousePressed

    private void RemoveMICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveMICUMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(MICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"MICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
             if(newNumber-1>0)SetNewRoom("MICU",false,newNumber);
            else 
            {
                MICU.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveMICUMousePressed

    private void RemoveNICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveNICUMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(NICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"NICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewRoom("NICU",false,newNumber);
            else 
            {
                NICU.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveNICUMousePressed

    private void RemovePICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovePICUMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(PICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"PICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewRoom("PICU",false,newNumber);
            else 
            {
                PICU.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemovePICUMousePressed

    private void RemoveSICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveSICUMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(SICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"SICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewRoom("SICU",false,newNumber);
            else 
            {
                SICU.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveSICUMousePressed

    private void RemoveTICUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveTICUMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(TICU.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"TICU");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
             if(newNumber-1>0)SetNewRoom("TICU",false,newNumber);
            else 
            {
                TICU.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveTICUMousePressed

    private void RemoveERMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveERMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(ER.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"ER");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
             if(newNumber-1>0)SetNewRoom("ER",false,newNumber);
            else 
            {
                ER.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveERMousePressed

    private void RemoveCovid19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveCovid19MousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(Covid19.getText());
            ArrayList<Integer>arr=GetNumberRoomType(hospital_id,"Covid19");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewRoom("Covid19",false,newNumber);
            else 
            {
                Covid19.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveCovid19MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddCVICU;
    private javax.swing.JLabel AddCovid19;
    private javax.swing.JLabel AddER;
    private javax.swing.JLabel AddMICU;
    private javax.swing.JLabel AddNICU;
    private javax.swing.JLabel AddPICU;
    private javax.swing.JLabel AddSICU;
    private javax.swing.JLabel AddTICU;
    private javax.swing.JLabel CVICU;
    private javax.swing.JLabel Covid19;
    private javax.swing.JLabel ER;
    private javax.swing.JLabel MICU;
    private javax.swing.JLabel NICU;
    private javax.swing.JLabel PICU;
    private javax.swing.JLabel RemoveCVICU;
    private javax.swing.JLabel RemoveCovid19;
    private javax.swing.JLabel RemoveER;
    private javax.swing.JLabel RemoveMICU;
    private javax.swing.JLabel RemoveNICU;
    private javax.swing.JLabel RemovePICU;
    private javax.swing.JLabel RemoveSICU;
    private javax.swing.JLabel RemoveTICU;
    private javax.swing.JLabel SICU;
    private javax.swing.JLabel TICU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
