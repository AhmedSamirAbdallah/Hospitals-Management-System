/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.panels;

/**
 *
 * @author Bisso
 */
import java.awt.Color;
import java.io.BufferedInputStream;
import main.LostPerson;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Character.toLowerCase;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
public class LostPeoplePanel extends javax.swing.JPanel {

    /**
     * Creates new form RoomsPanel
     */
    private int hospital_Id;
    void ShowLostPeopoleBySsnAndName(){
        NameLabel.setVisible(true);
        SsnLabel.setVisible(true);
        CaseLabelN_S.setVisible(true);
        GenderLabelN_S.setVisible(true);
        ReasonLabelN_S.setVisible(true);
        NameLostPeople.setVisible(true);
        SsnLostPeople.setVisible(true);
        CaseLostPeopleN_S.setVisible(true);
        GenderLostPeopleN_S.setVisible(true);
        ReasonLostPeopleN_S.setVisible(true);
    }
    void ShowLostPeopoleByDescription(){
        /*panels*/
        HideLostPeopleBySsnAndNamePanels();
        ShowLostPeopleByDescriptionPanels();
        ShirtLabel.setVisible(true);
        HairLabel.setVisible(true);
        SkinLabel.setVisible(true);
        HeightLabel.setVisible(true);
        GenderLabel_Description.setVisible(true);
        CaseLabel_Description.setVisible(true);
        ReasonLabel_Description.setVisible(true);
        ShirtcolorLostPeople.setVisible(true);
        HaircolorLostPeople.setVisible(true);
        SkincolorLostPeople.setVisible(true);
        HeightLostPeople.setVisible(true);
        GenderLostPeople_Description.setVisible(true);
        CaseLostPeople_Description.setVisible(true);
        ReasonLostPeople_Description.setVisible(true);
    }
    void HideLostPeopleBySsnAndName(){
        NameLabel.setVisible(false);
        SsnLabel.setVisible(false);
        CaseLabelN_S.setVisible(false);
        GenderLabelN_S.setVisible(false);
        ReasonLabelN_S.setVisible(false);
        NameLostPeople.setVisible(false);
        SsnLostPeople.setVisible(false);
        CaseLostPeopleN_S.setVisible(false);
        GenderLostPeopleN_S.setVisible(false);
        ReasonLostPeopleN_S.setVisible(false);

    }
    void HideLostPeopleByDescription(){
       /*panels*/
        ShirtLabel.setVisible(false);
        HairLabel.setVisible(false);
        SkinLabel.setVisible(false);
        HeightLabel.setVisible(false);
        GenderLabel_Description.setVisible(false);
        CaseLabel_Description.setVisible(false);
        ReasonLabel_Description.setVisible(false);
        ShirtcolorLostPeople.setVisible(false);
        HaircolorLostPeople.setVisible(false);
        SkincolorLostPeople.setVisible(false);
        HeightLostPeople.setVisible(false);
        GenderLostPeople_Description.setVisible(false);
        CaseLostPeople_Description.setVisible(false);
        ReasonLostPeople_Description.setVisible(false);
        LostPeople_Details.setVisible(false);
        detailsLabel.setVisible(false);

        
    }
    void ShowLostPeopleBySsnAndNamePanels(){
        NameAndShirtPanel.setVisible(true);
        SsnAndHairPanel.setVisible(true);
        GenderAndSkinPanel.setVisible(true);
        CaseAndHeightPanel.setVisible(true);
        ReasonAndGendertPanel.setVisible(true);
        
    }
    void HideLostPeopleBySsnAndNamePanels()
    {
        NameAndShirtPanel.setVisible(false);
        SsnAndHairPanel.setVisible(false);
        GenderAndSkinPanel.setVisible(false);
        CaseAndHeightPanel.setVisible(false);
        ReasonAndGendertPanel.setVisible(false);
    }
    void ShowLostPeopleByDescriptionPanels(){
        ShowLostPeopleBySsnAndNamePanels();
        CaseDescriptionPanel.setVisible(true);
        ReasonDescriptionPanel.setVisible(true);
       
        LostPeople_Details.setVisible(true);
        detailsLabel.setVisible(true);
    }
    void HideLostPeopleByDescriptionPanels(){
        HideLostPeopleBySsnAndNamePanels();
        CaseLostPeople_Description.setVisible(false);
        ReasonLostPeople_Description.setVisible(false);
        UnseccussfulInput.setText("");
    }
    void  HideAllPanels(){
        UnseccussfulInput.setText("");
        LostPeople_Details.setVisible(false);
        detailsLabel.setVisible(false);
        NameAndShirtPanel.setVisible(false);
        SsnAndHairPanel.setVisible(false);
        GenderAndSkinPanel.setVisible(false);
        CaseAndHeightPanel.setVisible(false);
        ReasonAndGendertPanel.setVisible(false);
        CaseDescriptionPanel.setVisible(false);
        ReasonDescriptionPanel.setVisible(false);
    }
    public LostPeoplePanel(int id) {
        
        initComponents();
        HideAllPanels();
       SaveLabel.setVisible(false);
       hospital_Id=id;
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
        NameAndShirtPanel = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        ShirtcolorLostPeople = new javax.swing.JTextField();
        ShirtLabel = new javax.swing.JLabel();
        NameLostPeople = new javax.swing.JTextField();
        SsnAndHairPanel = new javax.swing.JPanel();
        SsnLabel = new javax.swing.JLabel();
        HaircolorLostPeople = new javax.swing.JTextField();
        HairLabel = new javax.swing.JLabel();
        SsnLostPeople = new javax.swing.JTextField();
        GenderAndSkinPanel = new javax.swing.JPanel();
        GenderLabelN_S = new javax.swing.JLabel();
        SkincolorLostPeople = new javax.swing.JTextField();
        SkinLabel = new javax.swing.JLabel();
        GenderLostPeopleN_S = new javax.swing.JTextField();
        CaseAndHeightPanel = new javax.swing.JPanel();
        CaseLabelN_S = new javax.swing.JLabel();
        HeightLostPeople = new javax.swing.JTextField();
        HeightLabel = new javax.swing.JLabel();
        CaseLostPeopleN_S = new javax.swing.JTextField();
        ReasonAndGendertPanel = new javax.swing.JPanel();
        ReasonLabelN_S = new javax.swing.JLabel();
        GenderLostPeople_Description = new javax.swing.JTextField();
        GenderLabel_Description = new javax.swing.JLabel();
        ReasonLostPeopleN_S = new javax.swing.JTextField();
        CaseDescriptionPanel = new javax.swing.JPanel();
        CaseLostPeople_Description = new javax.swing.JTextField();
        CaseLabel_Description = new javax.swing.JLabel();
        ReasonDescriptionPanel = new javax.swing.JPanel();
        ReasonLostPeople_Description = new javax.swing.JTextField();
        ReasonLabel_Description = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SaveLabel = new javax.swing.JLabel();
        detailsLabel = new javax.swing.JLabel();
        LostPeople_Details = new javax.swing.JTextField();
        UnseccussfulInput = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setInheritsPopupMenu(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(1023, 148));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(128, 128, 131));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Images/confusion (1).png"))); // NOI18N
        jLabel1.setText("LOST PEOPLE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setFocusTraversalPolicyProvider(true);
        jLabel1.setIconTextGap(15);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(219, 219, 219))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NameAndShirtPanel.setBackground(new java.awt.Color(255, 255, 255));

        NameLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(175, 75, 75));
        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NameLabel.setText("Name : ");

        ShirtcolorLostPeople.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        ShirtcolorLostPeople.setForeground(new java.awt.Color(128, 128, 131));
        ShirtcolorLostPeople.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ShirtcolorLostPeople.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        ShirtLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ShirtLabel.setForeground(new java.awt.Color(175, 75, 75));
        ShirtLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ShirtLabel.setText(" Shirt Color : ");
        ShirtLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        NameLostPeople.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        NameLostPeople.setForeground(new java.awt.Color(128, 128, 131));
        NameLostPeople.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NameLostPeople.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));
        NameLostPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameLostPeopleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NameAndShirtPanelLayout = new javax.swing.GroupLayout(NameAndShirtPanel);
        NameAndShirtPanel.setLayout(NameAndShirtPanelLayout);
        NameAndShirtPanelLayout.setHorizontalGroup(
            NameAndShirtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NameAndShirtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ShirtLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShirtcolorLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        NameAndShirtPanelLayout.setVerticalGroup(
            NameAndShirtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NameAndShirtPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(NameAndShirtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShirtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ShirtcolorLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SsnAndHairPanel.setBackground(new java.awt.Color(255, 255, 255));

        SsnLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        SsnLabel.setForeground(new java.awt.Color(175, 75, 75));
        SsnLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SsnLabel.setText("Ssn : ");

        HaircolorLostPeople.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        HaircolorLostPeople.setForeground(new java.awt.Color(128, 128, 131));
        HaircolorLostPeople.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        HaircolorLostPeople.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        HairLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        HairLabel.setForeground(new java.awt.Color(175, 75, 75));
        HairLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        HairLabel.setText(" Hair Color : ");
        HairLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        SsnLostPeople.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SsnLostPeople.setForeground(new java.awt.Color(128, 128, 131));
        SsnLostPeople.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SsnLostPeople.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));
        SsnLostPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SsnLostPeopleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SsnAndHairPanelLayout = new javax.swing.GroupLayout(SsnAndHairPanel);
        SsnAndHairPanel.setLayout(SsnAndHairPanelLayout);
        SsnAndHairPanelLayout.setHorizontalGroup(
            SsnAndHairPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SsnAndHairPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SsnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SsnLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HairLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HaircolorLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        SsnAndHairPanelLayout.setVerticalGroup(
            SsnAndHairPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SsnAndHairPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(SsnAndHairPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SsnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SsnLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HairLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HaircolorLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        GenderAndSkinPanel.setBackground(new java.awt.Color(255, 255, 255));

        GenderLabelN_S.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        GenderLabelN_S.setForeground(new java.awt.Color(175, 75, 75));
        GenderLabelN_S.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GenderLabelN_S.setText("Gender : ");

        SkincolorLostPeople.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SkincolorLostPeople.setForeground(new java.awt.Color(128, 128, 131));
        SkincolorLostPeople.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        SkincolorLostPeople.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        SkinLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        SkinLabel.setForeground(new java.awt.Color(175, 75, 75));
        SkinLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SkinLabel.setText("Skin Color : ");
        SkinLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        GenderLostPeopleN_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        GenderLostPeopleN_S.setForeground(new java.awt.Color(128, 128, 131));
        GenderLostPeopleN_S.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        GenderLostPeopleN_S.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));
        GenderLostPeopleN_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderLostPeopleN_SActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GenderAndSkinPanelLayout = new javax.swing.GroupLayout(GenderAndSkinPanel);
        GenderAndSkinPanel.setLayout(GenderAndSkinPanelLayout);
        GenderAndSkinPanelLayout.setHorizontalGroup(
            GenderAndSkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenderAndSkinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GenderLabelN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenderLostPeopleN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SkinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SkincolorLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        GenderAndSkinPanelLayout.setVerticalGroup(
            GenderAndSkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenderAndSkinPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(GenderAndSkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenderLabelN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenderLostPeopleN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SkinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SkincolorLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CaseAndHeightPanel.setBackground(new java.awt.Color(255, 255, 255));

        CaseLabelN_S.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        CaseLabelN_S.setForeground(new java.awt.Color(175, 75, 75));
        CaseLabelN_S.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CaseLabelN_S.setText("Status : ");

        HeightLostPeople.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HeightLostPeople.setForeground(new java.awt.Color(128, 128, 131));
        HeightLostPeople.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        HeightLostPeople.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        HeightLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        HeightLabel.setForeground(new java.awt.Color(175, 75, 75));
        HeightLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        HeightLabel.setText(" Height : ");
        HeightLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        CaseLostPeopleN_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CaseLostPeopleN_S.setForeground(new java.awt.Color(128, 128, 131));
        CaseLostPeopleN_S.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        CaseLostPeopleN_S.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));
        CaseLostPeopleN_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseLostPeopleN_SActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CaseAndHeightPanelLayout = new javax.swing.GroupLayout(CaseAndHeightPanel);
        CaseAndHeightPanel.setLayout(CaseAndHeightPanelLayout);
        CaseAndHeightPanelLayout.setHorizontalGroup(
            CaseAndHeightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CaseAndHeightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CaseLabelN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CaseLostPeopleN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HeightLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HeightLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        CaseAndHeightPanelLayout.setVerticalGroup(
            CaseAndHeightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CaseAndHeightPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(CaseAndHeightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CaseLabelN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CaseLostPeopleN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HeightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HeightLostPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ReasonAndGendertPanel.setBackground(new java.awt.Color(255, 255, 255));

        ReasonLabelN_S.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ReasonLabelN_S.setForeground(new java.awt.Color(175, 75, 75));
        ReasonLabelN_S.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ReasonLabelN_S.setText("Reason : ");

        GenderLostPeople_Description.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        GenderLostPeople_Description.setForeground(new java.awt.Color(128, 128, 131));
        GenderLostPeople_Description.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        GenderLostPeople_Description.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        GenderLabel_Description.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        GenderLabel_Description.setForeground(new java.awt.Color(175, 75, 75));
        GenderLabel_Description.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        GenderLabel_Description.setText(" Gender : ");
        GenderLabel_Description.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        ReasonLostPeopleN_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        ReasonLostPeopleN_S.setForeground(new java.awt.Color(128, 128, 131));
        ReasonLostPeopleN_S.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ReasonLostPeopleN_S.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));
        ReasonLostPeopleN_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReasonLostPeopleN_SActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReasonAndGendertPanelLayout = new javax.swing.GroupLayout(ReasonAndGendertPanel);
        ReasonAndGendertPanel.setLayout(ReasonAndGendertPanelLayout);
        ReasonAndGendertPanelLayout.setHorizontalGroup(
            ReasonAndGendertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReasonAndGendertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReasonLabelN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReasonLostPeopleN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GenderLabel_Description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GenderLostPeople_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        ReasonAndGendertPanelLayout.setVerticalGroup(
            ReasonAndGendertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReasonAndGendertPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ReasonAndGendertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReasonLabelN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReasonLostPeopleN_S, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenderLabel_Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GenderLostPeople_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CaseDescriptionPanel.setBackground(new java.awt.Color(255, 255, 255));

        CaseLostPeople_Description.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CaseLostPeople_Description.setForeground(new java.awt.Color(128, 128, 131));
        CaseLostPeople_Description.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CaseLostPeople_Description.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        CaseLabel_Description.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        CaseLabel_Description.setForeground(new java.awt.Color(175, 75, 75));
        CaseLabel_Description.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CaseLabel_Description.setText(" Status : ");
        CaseLabel_Description.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout CaseDescriptionPanelLayout = new javax.swing.GroupLayout(CaseDescriptionPanel);
        CaseDescriptionPanel.setLayout(CaseDescriptionPanelLayout);
        CaseDescriptionPanelLayout.setHorizontalGroup(
            CaseDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CaseDescriptionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CaseLabel_Description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CaseLostPeople_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        CaseDescriptionPanelLayout.setVerticalGroup(
            CaseDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CaseDescriptionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(CaseDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CaseLabel_Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CaseLostPeople_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ReasonDescriptionPanel.setBackground(new java.awt.Color(255, 255, 255));

        ReasonLostPeople_Description.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        ReasonLostPeople_Description.setForeground(new java.awt.Color(128, 128, 131));
        ReasonLostPeople_Description.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ReasonLostPeople_Description.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        ReasonLabel_Description.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ReasonLabel_Description.setForeground(new java.awt.Color(175, 75, 75));
        ReasonLabel_Description.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ReasonLabel_Description.setText(" Reason : ");
        ReasonLabel_Description.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout ReasonDescriptionPanelLayout = new javax.swing.GroupLayout(ReasonDescriptionPanel);
        ReasonDescriptionPanel.setLayout(ReasonDescriptionPanelLayout);
        ReasonDescriptionPanelLayout.setHorizontalGroup(
            ReasonDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReasonDescriptionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReasonLabel_Description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReasonLostPeople_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        ReasonDescriptionPanelLayout.setVerticalGroup(
            ReasonDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReasonDescriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ReasonLabel_Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReasonLostPeople_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 131));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ssn/Name");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Description");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(175, 75, 75));
        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(55, 5));

        SaveLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        SaveLabel.setForeground(new java.awt.Color(128, 128, 131));
        SaveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaveLabel.setText("Save");
        SaveLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SaveLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addGap(116, 116, 116)
                        .addComponent(SaveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(119, 119, 119))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SaveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        detailsLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        detailsLabel.setForeground(new java.awt.Color(175, 75, 75));
        detailsLabel.setText("Details :");

        LostPeople_Details.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LostPeople_Details.setForeground(new java.awt.Color(128, 128, 131));
        LostPeople_Details.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        LostPeople_Details.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(175, 75, 75)));

        UnseccussfulInput.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        UnseccussfulInput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UnseccussfulInput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
            .addComponent(NameAndShirtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SsnAndHairPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ReasonAndGendertPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(GenderAndSkinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CaseAndHeightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CaseDescriptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ReasonDescriptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(UnseccussfulInput, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(detailsLabel)
                .addGap(18, 18, 18)
                .addComponent(LostPeople_Details, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameAndShirtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SsnAndHairPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenderAndSkinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CaseAndHeightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReasonAndGendertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CaseDescriptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReasonDescriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(detailsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UnseccussfulInput, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(LostPeople_Details)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents
    void ClearTextFromNameSsn(){
        NameLostPeople.setText("");
        SsnLostPeople.setText("");
        GenderLostPeopleN_S.setText("");
        CaseLostPeopleN_S.setText("");
        ReasonLostPeopleN_S.setText("");
    }
    void ClearTextFromDescription(){
        ShirtcolorLostPeople.setText("");
        HaircolorLostPeople.setText("");
        SkincolorLostPeople.setText("");
        HeightLostPeople.setText("");
        GenderLostPeople_Description.setText("");
        CaseLostPeople_Description.setText("");
        ReasonLostPeople_Description.setText("");
        
    }
    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        ClearTextFromNameSsn();
        HideLostPeopleBySsnAndNamePanels();
        ShowLostPeopleByDescriptionPanels();
        HideLostPeopleBySsnAndName();
        ShowLostPeopoleByDescription();
        SaveLabel.setVisible(true);
        UnseccussfulInput.setText("");

    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        jLabel3.setForeground(new Color(128,128,131));

    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        jLabel3.setForeground(new Color(175,75,75));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        ClearTextFromDescription();
        HideLostPeopleByDescriptionPanels();
        ShowLostPeopleBySsnAndNamePanels();
        HideLostPeopleByDescription();
        ShowLostPeopoleBySsnAndName();
        SaveLabel.setVisible(true);
        UnseccussfulInput.setText("");

    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jLabel2.setForeground(new Color(128,128,131));

    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setForeground(new Color(175,75,75));

    }//GEN-LAST:event_jLabel2MouseEntered

    private void GenderLostPeopleN_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderLostPeopleN_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderLostPeopleN_SActionPerformed

    private void ReasonLostPeopleN_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReasonLostPeopleN_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReasonLostPeopleN_SActionPerformed

    private void SsnLostPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SsnLostPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SsnLostPeopleActionPerformed

    private void CaseLostPeopleN_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseLostPeopleN_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaseLostPeopleN_SActionPerformed

    private void NameLostPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameLostPeopleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameLostPeopleActionPerformed

    private void SaveLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveLabelMouseEntered
        // TODO add your handling code here:
        SaveLabel.setForeground(new Color(0,173,0));
    }//GEN-LAST:event_SaveLabelMouseEntered

    private void SaveLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveLabelMouseExited
        // TODO add your handling code here:
        SaveLabel.setForeground(new Color(128,128,131));
    }//GEN-LAST:event_SaveLabelMouseExited

    private void SaveLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveLabelMousePressed
        // TODO add your handling code here:
        UnseccussfulInput.setText("");
        if(!NameLostPeople.getText().isEmpty()&&!SsnLostPeople.getText().isEmpty())
        {
            try {
                SetPersonWithID(hospital_Id);
            } catch (IOException ex) {
                Logger.getLogger(LostPeoplePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(!GenderLostPeople_Description.getText().isEmpty()&&!CaseLostPeople_Description.getText().isEmpty()||
                !ReasonLostPeople_Description.getText().isEmpty())
        {
            try {
               
                SetPersonByDescriptions(hospital_Id);
            } catch (IOException ex) {
                Logger.getLogger(LostPeoplePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else UnseccussfulInput.setText("Please Fill The Information ");
    }//GEN-LAST:event_SaveLabelMousePressed
    boolean ValidName(String Name)
    {
        for(int i=0;i<Name.length();i++)
        {
            if(!Character.isAlphabetic(Name.charAt(i))&&Name.charAt(i)!=' ')return false;
        }
        return true;
    }
    boolean ValidSsn(String ssn)
    {
        for(int i=0;i<ssn.length();i++)
        {
            if(!Character.isDigit(ssn.charAt(i)))return false;
        }
        return true;
    }
    boolean ValidGender(String gender){
        return (gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female"));
    }
    boolean AllEmpty()
    {
        if(NameLostPeople.getText().isEmpty()&&SsnLostPeople.getText().isEmpty()&&ShirtcolorLostPeople.getText().isEmpty())
        {
            return false;
        }
        return true;
    }
    public void SetPersonWithID(int id) throws IOException{
      
       
        if(!ValidName(NameLostPeople.getText()))
        {
            UnseccussfulInput.setText("Please Enter a Vaild Name");
            return;
        }
        if(!ValidSsn(SsnLostPeople.getText()))
        {
            UnseccussfulInput.setText("Please Enter a Valid Ssn");
            return;
        }
        if(GenderLostPeopleN_S.getText().isEmpty())
        {
            UnseccussfulInput.setText("Gender Can't be Empty");
            return;
        }
        if(!ValidGender(GenderLostPeopleN_S.getText()))
        {
            UnseccussfulInput.setText("Please Enter a Valid Gender");
            return;
        }
         if(CaseLostPeopleN_S.getText().isEmpty())
        {
            UnseccussfulInput.setText("Status Can't be Empty");
            return;
        }
          if(ReasonLostPeopleN_S.getText().isEmpty())
        {
            UnseccussfulInput.setText("Reason Can't be Empty");
            return;
        }
        LostPerson person =new  LostPerson();
        person.setName(NameLostPeople.getText());
        person.setSsn(SsnLostPeople.getText());
        person.setGender(GenderLostPeopleN_S.getText());
        person.setCase(CaseLostPeopleN_S.getText());
        person.setReason(ReasonLostPeopleN_S.getText());
        person.setHospitalId(id);
        HttpURLConnection connection =(HttpURLConnection)new URL("https://glacial-everglades-74360.herokuapp.com/findbyid/").openConnection();
        connection.setRequestProperty("Content-Type","application/json");  
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        String data="{\n";
        data+="\t\"name\": "+"\""+person.getName()+"\",\n";
        data+="\t\"national_id\": "+"\""+person.getSsn()+"\",\n";
        data+="\t\"gender\": "+"\""+person.getGender()+"\",\n";
        data+="\t\"status\": "+"\""+person.getCase()+"\",\n";
        data+="\t\"reason\": "+"\""+person.getReason()+"\",\n";
        data+="\t\"hospital\": "+person.getHospitalId();
        data+="\n";
        data+="}";
        System.out.println(data);
        OutputStream we = connection.getOutputStream();
        we.write(data.getBytes());
        int respondeCode=connection.getResponseCode();
        System.out.println("The POST Request Response Code :  " + respondeCode);  
        System.out.println("The POST Request Response Message : " + connection.getResponseMessage());
        connection.disconnect();
         we.close();
        if(respondeCode==HttpURLConnection.HTTP_CREATED){
            System.out.println("succusful");
           
            UnseccussfulInput.setText("Successfully Added");
            
        }
        else{
                 System.out.println("Fail");
        } 
    }
    public void SetPersonByDescriptions(int id)throws IOException {
       if(!ValidGender(GenderLostPeople_Description.getText()))
       {
           UnseccussfulInput.setText("Please Enter Valid Gender");
           return;
       }
       if(GenderLostPeople_Description.getText().isEmpty())
       {
         UnseccussfulInput.setText("Gender Can't be Empty");
         return ;
       }
       if(!ValidSsn(HeightLostPeople.getText())&&HeightLostPeople.getText().length()>3)
       {
           UnseccussfulInput.setText("Please Enter Valid Height");
           return;
       }
        if(CaseLostPeople_Description.getText().isEmpty())
        {
            UnseccussfulInput.setText("Status Can't be Empty");
            return;
        }
          if(ReasonLostPeople_Description.getText().isEmpty())
        {
            UnseccussfulInput.setText("Reason Can't be Empty");
            return;
        }
        LostPerson person =new  LostPerson();
        person.setShirtColor(ShirtcolorLostPeople.getText());
        person.setHairColor(HaircolorLostPeople.getText());
        person.setSkinColor(SkincolorLostPeople.getText());
        if(!HeightLostPeople.getText().isEmpty())person.setHeight(Integer.parseInt(HeightLostPeople.getText()));
        person.setReason(ReasonLostPeople_Description.getText());
        person.setHospitalId(id);
        person.setDetails(LostPeople_Details.getText());
        person.setGender(GenderLostPeople_Description.getText());
        person.setCase(CaseLostPeople_Description.getText());
        HttpURLConnection connection =(HttpURLConnection)new URL("https://glacial-everglades-74360.herokuapp.com/findbycl/").openConnection();
        connection.setRequestProperty("Content-Type","application/json");  
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        String data="{\n";
        data+="\t \"shirt_color\": \""+person.getShirtColor()+"\",\n";
        data+="\t \"hair_color\": \""+person.getHairColor()+"\",\n";
        data+="\t \"skin_color\": \""+person.getSkinColor()+"\",\n";
        data+="\t \"height\": "+person.getHeight()+",\n";
        data+="\t \"gender\": \""+person.getGender()+"\",\n";
        data+="\t \"status\": \""+person.getCase()+"\",\n";
        data+="\t \"details\": \""+person.getDetails()+"\",\n";
        data+="\t \"reason\": \""+person.getReason()+"\",\n";
        data+="\t \"hospital\": "+person.getHospitalId()+"\n";
        data+="}\n";
        System.out.println(data);
         OutputStream we = connection.getOutputStream();
        we.write(data.getBytes());
        int respondeCode=connection.getResponseCode();
        System.out.println("The POST Request Response Code :  " + respondeCode);  
        System.out.println("The POST Request Response Message : " + connection.getResponseMessage());
        connection.disconnect();
        we.close();
        if(respondeCode==HttpURLConnection.HTTP_CREATED){
            UnseccussfulInput.setText("Successfully Added");
            System.out.println("succusful");
        }
        else{
                 System.out.println("Fail");
        } 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CaseAndHeightPanel;
    private javax.swing.JPanel CaseDescriptionPanel;
    private javax.swing.JLabel CaseLabelN_S;
    private javax.swing.JLabel CaseLabel_Description;
    private javax.swing.JTextField CaseLostPeopleN_S;
    private javax.swing.JTextField CaseLostPeople_Description;
    private javax.swing.JPanel GenderAndSkinPanel;
    private javax.swing.JLabel GenderLabelN_S;
    private javax.swing.JLabel GenderLabel_Description;
    private javax.swing.JTextField GenderLostPeopleN_S;
    private javax.swing.JTextField GenderLostPeople_Description;
    private javax.swing.JLabel HairLabel;
    private javax.swing.JTextField HaircolorLostPeople;
    private javax.swing.JLabel HeightLabel;
    private javax.swing.JTextField HeightLostPeople;
    private javax.swing.JTextField LostPeople_Details;
    private javax.swing.JPanel NameAndShirtPanel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameLostPeople;
    private javax.swing.JPanel ReasonAndGendertPanel;
    private javax.swing.JPanel ReasonDescriptionPanel;
    private javax.swing.JLabel ReasonLabelN_S;
    private javax.swing.JLabel ReasonLabel_Description;
    private javax.swing.JTextField ReasonLostPeopleN_S;
    private javax.swing.JTextField ReasonLostPeople_Description;
    private javax.swing.JLabel SaveLabel;
    private javax.swing.JLabel ShirtLabel;
    private javax.swing.JTextField ShirtcolorLostPeople;
    private javax.swing.JLabel SkinLabel;
    private javax.swing.JTextField SkincolorLostPeople;
    private javax.swing.JPanel SsnAndHairPanel;
    private javax.swing.JLabel SsnLabel;
    private javax.swing.JTextField SsnLostPeople;
    private javax.swing.JLabel UnseccussfulInput;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
