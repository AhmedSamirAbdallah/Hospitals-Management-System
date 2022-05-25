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
import main.Blood;
import main.Room;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bisso
 */
public class BloodBankPanel extends javax.swing.JPanel {

    /**
     * Creates new form RoomsPanel
     */
    private int hospital_id;
    void HideAddAndRemoves(){
        AddAP.setVisible(false);
        RemoveAP.setVisible(false);
        AddAM.setVisible(false);
        RemoveAM.setVisible(false);
        AddBP.setVisible(false);
        RemoveBP.setVisible(false);
        AddBM.setVisible(false);
        RemoveBM.setVisible(false);
        AddOP.setVisible(false);
        RemoveOP.setVisible(false);
        AddOM.setVisible(false);
        RemoveOM.setVisible(false);
        AddABP.setVisible(false);
        RemoveABP.setVisible(false);
        AddABM.setVisible(false);
        RemoveABM.setVisible(false);
    }
    public BloodBankPanel(int id) throws IOException {
        initComponents();
        HideAddAndRemoves();
        hospital_id=id;
        GetShow();
    }
   
     int AddOrMinus(int number,boolean Plus){
       if(Plus)number++;
        else  
        {
            number--;
            if(number<0)number++;
        }
        return number;
    }
    void SetNewBlood(String Type , boolean Plus , int number) throws MalformedURLException, IOException{
        Blood blood  = new Blood();
        blood.setType(Type);
        blood.setHospitalID(hospital_id);
        if(Type.equals("A+"))
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            APLabel.setText(Integer.toString(number));
        }
        else if(Type.equals("A-"))
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            AMLabel.setText(Integer.toString(number));
        }
        else if(Type.equals("B+"))
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            BPLabel.setText(Integer.toString(number));
        }
        else if(Type.equals("B-"))
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            BMLabel.setText(Integer.toString(number));
        }
        else if(Type.equals("O+"))
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            OPLabel.setText(Integer.toString(number));
        }
        else if(Type.equals("O-"))
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            OMLabel.setText(Integer.toString(number));
        }
        else if(Type.equals("AB+"))
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            ABPLabel.setText(Integer.toString(number));
        }
        else
        {
            number = AddOrMinus(number,Plus);
            blood.setCount(number);
            ABMLabel.setText(Integer.toString(number));
            
        }
        String data="{\n";
        data+="\t\"type\":\""+blood.getType()+"\",\n";
        data+="\t\"count\":"+blood.getCount()+",\n";
        data+="\t\"hospital\":"+blood.getHospitalID()+"\n";
        data+="}\n";
        //System.out.println(data);
        HttpURLConnection connection =(HttpURLConnection)new URL("https://glacial-everglades-74360.herokuapp.com/blood/").openConnection();
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
    ArrayList<Integer> GetNumberBloodType(int hospital_id,String type) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) new URL("https://glacial-everglades-74360.herokuapp.com/blood/?format=json&hid="+hospital_id).openConnection();	
	connection.setRequestProperty("Content-Type","application/json");  
        connection.setRequestMethod("GET");
        int respondeCode=connection.getResponseCode();
        System.out.println("The POST Request Response Code :  " + respondeCode);  
        System.out.println("The POST Request Response Message : " + connection.getResponseMessage());
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
        URL url = new URL("https://glacial-everglades-74360.herokuapp.com/blood/"+id);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("DELETE");
        System.out.println(http.getResponseCode() + " Delete " + http.getResponseMessage());
        http.disconnect();
    }
    void GetShow()throws IOException{
        HttpURLConnection connection = (HttpURLConnection) new URL("https://glacial-everglades-74360.herokuapp.com/blood/?format=json&hid="+hospital_id).openConnection();	
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
            if(obj.getString("type").equals("A+"))
            {
                APLabel.setText(Integer.toString(obj.getInt("count")));
            }
            else if(obj.getString("type").equals("A-"))
            {
                AMLabel.setText(Integer.toString(obj.getInt("count")));
            }
            else if(obj.getString("type").equals("B+"))
            {
                BPLabel.setText(Integer.toString(obj.getInt("count")));
            }
            else if(obj.getString("type").equals("B-"))
            {
                BMLabel.setText(Integer.toString(obj.getInt("count")));
            }
            else if(obj.getString("type").equals("O+"))
            {
                OPLabel.setText(Integer.toString(obj.getInt("count")));
            }
            else if(obj.getString("type").equals("O-"))
            {
                OMLabel.setText(Integer.toString(obj.getInt("count")));
            }
            else if(obj.getString("type").equals("AB+"))
            {
                ABPLabel.setText(Integer.toString(obj.getInt("count")));
            }
            else if(obj.getString("type").equals("AB-"))
            {
                ABMLabel.setText(Integer.toString(obj.getInt("count")));
            }
        }
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
        AP = new javax.swing.JLabel();
        APLabel = new javax.swing.JLabel();
        AddAP = new javax.swing.JLabel();
        RemoveAP = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        AM = new javax.swing.JLabel();
        AMLabel = new javax.swing.JLabel();
        AddAM = new javax.swing.JLabel();
        RemoveAM = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        BP = new javax.swing.JLabel();
        BPLabel = new javax.swing.JLabel();
        AddBP = new javax.swing.JLabel();
        RemoveBP = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        BM = new javax.swing.JLabel();
        BMLabel = new javax.swing.JLabel();
        AddBM = new javax.swing.JLabel();
        RemoveBM = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        OP = new javax.swing.JLabel();
        OPLabel = new javax.swing.JLabel();
        AddOP = new javax.swing.JLabel();
        RemoveOP = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        OM = new javax.swing.JLabel();
        OMLabel = new javax.swing.JLabel();
        AddOM = new javax.swing.JLabel();
        RemoveOM = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        ABP = new javax.swing.JLabel();
        ABPLabel = new javax.swing.JLabel();
        AddABP = new javax.swing.JLabel();
        RemoveABP = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        ABM = new javax.swing.JLabel();
        ABMLabel = new javax.swing.JLabel();
        AddABM = new javax.swing.JLabel();
        RemoveABM = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(1023, 148));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(128, 128, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/blood-donation.png"))); // NOI18N
        jLabel1.setText("Blood Bank");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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

        AP.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        AP.setForeground(new java.awt.Color(175, 75, 75));
        AP.setText("A+");

        APLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        APLabel.setForeground(new java.awt.Color(128, 128, 131));
        APLabel.setText("0");
        APLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                APLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                APLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                APLabelMousePressed(evt);
            }
        });

        AddAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddAPMousePressed(evt);
            }
        });

        RemoveAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveAPMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(AP)
                .addGap(57, 57, 57)
                .addComponent(APLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(AddAP)
                .addGap(108, 108, 108)
                .addComponent(RemoveAP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(APLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddAP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveAP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        AM.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        AM.setForeground(new java.awt.Color(175, 75, 75));
        AM.setText("A-");

        AMLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        AMLabel.setForeground(new java.awt.Color(128, 128, 131));
        AMLabel.setText("0");
        AMLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AMLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AMLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AMLabelMousePressed(evt);
            }
        });

        AddAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddAMMousePressed(evt);
            }
        });

        RemoveAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveAMMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(AM)
                .addGap(66, 66, 66)
                .addComponent(AMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(AddAM)
                .addGap(109, 109, 109)
                .addComponent(RemoveAM)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddAM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        BP.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        BP.setForeground(new java.awt.Color(175, 75, 75));
        BP.setText("B+");

        BPLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        BPLabel.setForeground(new java.awt.Color(128, 128, 131));
        BPLabel.setText("0");
        BPLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BPLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BPLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BPLabelMousePressed(evt);
            }
        });

        AddBP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddBP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddBPMousePressed(evt);
            }
        });

        RemoveBP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveBP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveBPMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BP)
                .addGap(61, 61, 61)
                .addComponent(BPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(AddBP)
                .addGap(108, 108, 108)
                .addComponent(RemoveBP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddBP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveBP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        BM.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        BM.setForeground(new java.awt.Color(175, 75, 75));
        BM.setText("B-");

        BMLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        BMLabel.setForeground(new java.awt.Color(128, 128, 131));
        BMLabel.setText("0");
        BMLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BMLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BMLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BMLabelMousePressed(evt);
            }
        });

        AddBM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddBM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddBMMousePressed(evt);
            }
        });

        RemoveBM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveBM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveBMMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BM)
                .addGap(69, 69, 69)
                .addComponent(BMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(AddBM)
                .addGap(108, 108, 108)
                .addComponent(RemoveBM)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddBM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveBM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        OP.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        OP.setForeground(new java.awt.Color(175, 75, 75));
        OP.setText("O+");

        OPLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        OPLabel.setForeground(new java.awt.Color(128, 128, 131));
        OPLabel.setText("0");
        OPLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OPLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OPLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OPLabelMousePressed(evt);
            }
        });

        AddOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddOP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddOPMousePressed(evt);
            }
        });

        RemoveOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveOP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveOPMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(OP)
                .addGap(62, 62, 62)
                .addComponent(OPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(AddOP)
                .addGap(107, 107, 107)
                .addComponent(RemoveOP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddOP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveOP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        OM.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        OM.setForeground(new java.awt.Color(175, 75, 75));
        OM.setText("O-");
        OM.setToolTipText("");

        OMLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        OMLabel.setForeground(new java.awt.Color(128, 128, 131));
        OMLabel.setText("0");
        OMLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OMLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OMLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OMLabelMousePressed(evt);
            }
        });

        AddOM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddOM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddOMMousePressed(evt);
            }
        });

        RemoveOM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveOM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveOMMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(OM)
                .addGap(70, 70, 70)
                .addComponent(OMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(AddOM)
                .addGap(110, 110, 110)
                .addComponent(RemoveOM)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddOM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveOM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        ABP.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        ABP.setForeground(new java.awt.Color(175, 75, 75));
        ABP.setText("AB+");

        ABPLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        ABPLabel.setForeground(new java.awt.Color(128, 128, 131));
        ABPLabel.setText("0");
        ABPLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ABPLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ABPLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ABPLabelMousePressed(evt);
            }
        });

        AddABP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddABP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddABPMousePressed(evt);
            }
        });

        RemoveABP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveABP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveABPMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ABP)
                .addGap(48, 48, 48)
                .addComponent(ABPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(AddABP)
                .addGap(109, 109, 109)
                .addComponent(RemoveABP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ABPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ABP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddABP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveABP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        ABM.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        ABM.setForeground(new java.awt.Color(175, 75, 75));
        ABM.setText("AB-");

        ABMLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        ABMLabel.setForeground(new java.awt.Color(128, 128, 131));
        ABMLabel.setText("0");
        ABMLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ABMLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ABMLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ABMLabelMousePressed(evt);
            }
        });

        AddABM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/plus.png"))); // NOI18N
        AddABM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddABMMousePressed(evt);
            }
        });

        RemoveABM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/negative.png"))); // NOI18N
        RemoveABM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemoveABMMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ABM)
                .addGap(57, 57, 57)
                .addComponent(ABMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(AddABM)
                .addGap(110, 110, 110)
                .addComponent(RemoveABM)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ABMLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ABM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(AddABM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveABM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void APLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APLabelMouseEntered
        // TODO add your handling code here:
        APLabel.setForeground(new Color(175,75,75));
    }//GEN-LAST:event_APLabelMouseEntered

    private void APLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APLabelMouseExited
        // TODO add your handling code here:
        APLabel.setForeground(new Color(128,128,131));

    }//GEN-LAST:event_APLabelMouseExited

    private void AMLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMLabelMouseEntered
        // TODO add your handling code here:
         AMLabel.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_AMLabelMouseEntered

    private void AMLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMLabelMouseExited
        // TODO add your handling code here:
        AMLabel.setForeground(new Color(128,128,131));
        
    }//GEN-LAST:event_AMLabelMouseExited

    private void BPLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BPLabelMouseEntered
        // TODO add your handling code here:
        BPLabel.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_BPLabelMouseEntered

    private void BPLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BPLabelMouseExited
        // TODO add your handling code here:
        BPLabel.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_BPLabelMouseExited

    private void BMLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMLabelMouseEntered
        // TODO add your handling code here:
        BMLabel.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_BMLabelMouseEntered

    private void BMLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMLabelMouseExited
        // TODO add your handling code here:
        BMLabel.setForeground(new Color(128,128,131));
        
    }//GEN-LAST:event_BMLabelMouseExited

    private void OPLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OPLabelMouseEntered
        // TODO add your handling code here:
        OPLabel.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_OPLabelMouseEntered

    private void OPLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OPLabelMouseExited
        // TODO add your handling code here:
        OPLabel.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_OPLabelMouseExited

    private void OMLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OMLabelMouseEntered
        // TODO add your handling code here:
        OMLabel.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_OMLabelMouseEntered

    private void OMLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OMLabelMouseExited
        // TODO add your handling code here:
        OMLabel.setForeground(new Color(128,128,131));
        
    }//GEN-LAST:event_OMLabelMouseExited

    private void ABPLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABPLabelMouseEntered
        // TODO add your handling code here:
        ABPLabel.setForeground(new Color(175,75,75));
    }//GEN-LAST:event_ABPLabelMouseEntered

    private void ABPLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABPLabelMouseExited
        // TODO add your handling code here:
        ABPLabel.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_ABPLabelMouseExited

    private void ABMLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMLabelMouseEntered
        // TODO add your handling code here:
         ABMLabel.setForeground(new Color(175,75,75));
        
    }//GEN-LAST:event_ABMLabelMouseEntered

    private void ABMLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMLabelMouseExited
        // TODO add your handling code here:
        ABMLabel.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_ABMLabelMouseExited

    private void APLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_APLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddAP.setVisible(true);
        RemoveAP.setVisible(true);
    }//GEN-LAST:event_APLabelMousePressed

    private void AMLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddAM.setVisible(true);
        RemoveAM.setVisible(true);
   
    }//GEN-LAST:event_AMLabelMousePressed

    private void BPLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BPLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddBP.setVisible(true);
        RemoveBP.setVisible(true);
   
    }//GEN-LAST:event_BPLabelMousePressed

    private void BMLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddBM.setVisible(true);
        RemoveBM.setVisible(true);
   
    }//GEN-LAST:event_BMLabelMousePressed

    private void OPLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OPLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddOP.setVisible(true);
        RemoveOP.setVisible(true);
   
    }//GEN-LAST:event_OPLabelMousePressed

    private void OMLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OMLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddOM.setVisible(true);
        RemoveOM.setVisible(true);
   
    }//GEN-LAST:event_OMLabelMousePressed

    private void ABPLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABPLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddABP.setVisible(true);
        RemoveABP.setVisible(true);
   
    }//GEN-LAST:event_ABPLabelMousePressed

    private void ABMLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMLabelMousePressed
        // TODO add your handling code here:
        HideAddAndRemoves();
        AddABM.setVisible(true);
        RemoveABM.setVisible(true);
   
    }//GEN-LAST:event_ABMLabelMousePressed

    private void AddAPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAPMousePressed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(APLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"A+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("A+",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddAPMousePressed

    private void AddAMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAMMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(AMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"A-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("A-",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddAMMousePressed

    private void AddBPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBPMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(BPLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"B+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("B+",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddBPMousePressed

    private void AddBMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBMMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(BMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"B-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("B-",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddBMMousePressed

    private void AddOPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddOPMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(OPLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"O+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("O+",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddOPMousePressed

    private void AddOMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddOMMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(OMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"O-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("O-",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddOMMousePressed

    private void AddABPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddABPMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(ABPLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"AB+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("AB+",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddABPMousePressed

    private void AddABMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddABMMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int newNumber = Integer.parseInt(ABMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"AB-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            SetNewBlood("AB-",true,newNumber);
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddABMMousePressed

    private void RemoveAPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveAPMousePressed
        // TODO add your handling code here:
        try {
            int newNumber = Integer.parseInt(APLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"A+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
             
            }
            if(newNumber-1>0)SetNewBlood("A+",false,newNumber);
            else 
            {
                APLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveAPMousePressed

    private void RemoveAMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveAMMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(AMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"A-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewBlood("A-",false,newNumber);
            else 
            {
                AMLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveAMMousePressed

    private void RemoveBPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveBPMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(BPLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"B+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewBlood("B+",false,newNumber);
            else 
            {
                BPLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveBPMousePressed

    private void RemoveBMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveBMMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(BMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"B-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewBlood("B-",false,newNumber);
            else 
            {
                BMLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveBMMousePressed

    private void RemoveOPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveOPMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(OPLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"O+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewBlood("O+",false,newNumber);
            else 
            {
                OPLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveOPMousePressed

    private void RemoveOMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveOMMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(OMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"O-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewBlood("O-",false,newNumber);
            else 
            {
                OMLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveOMMousePressed

    private void RemoveABPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveABPMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(ABPLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"AB+");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewBlood("AB+",false,newNumber);
            else 
            {
                ABPLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveABPMousePressed

    private void RemoveABMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveABMMousePressed
        // TODO add your handling code here:
         try {
            int newNumber = Integer.parseInt(ABMLabel.getText());
            ArrayList<Integer>arr=GetNumberBloodType(hospital_id,"AB-");
            for(int i=0;i<arr.size();i++)
            {
                Delete(arr.get(i));
            }
            if(newNumber-1>0)SetNewBlood("AB-",false,newNumber);
            else 
            {
                ABMLabel.setText("0");
            }
        } catch (IOException ex) {
            Logger.getLogger(RoomsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RemoveABMMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ABM;
    private javax.swing.JLabel ABMLabel;
    private javax.swing.JLabel ABP;
    private javax.swing.JLabel ABPLabel;
    private javax.swing.JLabel AM;
    private javax.swing.JLabel AMLabel;
    private javax.swing.JLabel AP;
    private javax.swing.JLabel APLabel;
    private javax.swing.JLabel AddABM;
    private javax.swing.JLabel AddABP;
    private javax.swing.JLabel AddAM;
    private javax.swing.JLabel AddAP;
    private javax.swing.JLabel AddBM;
    private javax.swing.JLabel AddBP;
    private javax.swing.JLabel AddOM;
    private javax.swing.JLabel AddOP;
    private javax.swing.JLabel BM;
    private javax.swing.JLabel BMLabel;
    private javax.swing.JLabel BP;
    private javax.swing.JLabel BPLabel;
    private javax.swing.JLabel OM;
    private javax.swing.JLabel OMLabel;
    private javax.swing.JLabel OP;
    private javax.swing.JLabel OPLabel;
    private javax.swing.JLabel RemoveABM;
    private javax.swing.JLabel RemoveABP;
    private javax.swing.JLabel RemoveAM;
    private javax.swing.JLabel RemoveAP;
    private javax.swing.JLabel RemoveBM;
    private javax.swing.JLabel RemoveBP;
    private javax.swing.JLabel RemoveOM;
    private javax.swing.JLabel RemoveOP;
    private javax.swing.JLabel jLabel1;
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
