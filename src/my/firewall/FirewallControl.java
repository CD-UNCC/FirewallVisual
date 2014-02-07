package my.firewall;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class FirewallControl extends javax.swing.JFrame 
{
    static boolean range_1;
    static boolean range_2;//These ranges control the port blocking on the GUI
    static boolean range_3;
    private static boolean goTime = false;
    static Map<Integer, Boolean> badHashes = new HashMap<>();//reads from the dictionary ans store malicious hashes on a HashMap
    static List<Job> jobsList = new ArrayList<>();//stores all incoming and custom jobs that attempt to penetrate the firewall filters
    static File jobFile = new File("Jobs.txt");//file reader
    static File hashFile = new File("Bad_Hashes.txt");//file readers later passed to functions
    static Map<Integer, Boolean> ports = new HashMap<>();//hash map that will map all ports on a Unix system to passable or no
    public FirewallControl() 
    {
        initComponents();//build all swing and awt interfaces
    }
    @SuppressWarnings("unchecked")//I hate warnings
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jobLabel = new javax.swing.JLabel();
        fireLable = new javax.swing.JLabel();
        systemLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        hashField = new javax.swing.JTextField();
        jobList = new java.awt.List();
        fireList = new java.awt.List();
        sysList = new java.awt.List();
        addJob = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        openPortField = new javax.swing.JTextField();
        openPortButton = new javax.swing.JButton();
        portCloseButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        blockHashButton = new javax.swing.JButton();
        allowHashButton = new javax.swing.JButton();
        openHashField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        range1 = new javax.swing.JCheckBox();
        range2 = new javax.swing.JCheckBox();
        range3 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        startButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Firewall Simulation");
        setBackground(new java.awt.Color(0, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setForeground(new java.awt.Color(0, 102, 102));
        setResizable(false);

        jobLabel.setText("INCOMING JOBS");

        fireLable.setText("FIREWALL");

        systemLabel.setText("SYSTEM");

        idLabel.setText("ID");

        jLabel1.setText("PORT");

        jLabel2.setText("HASH");

        addJob.setText("ADD JOB");
        addJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJobActionPerformed(evt);
            }
        });

        jLabel3.setText("PORT");

        openPortButton.setText("OPEN");
        openPortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPortButtonActionPerformed(evt);
            }
        });

        portCloseButton.setText("CLOSE");
        portCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portCloseButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("HASH");

        blockHashButton.setText("Block");
        blockHashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockHashButtonActionPerformed(evt);
            }
        });

        allowHashButton.setText("Allow");
        allowHashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allowHashButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("PORT RANGES");

        jLabel6.setText("0-1023");

        jLabel7.setText("1024-49151");

        jLabel8.setText("49152–65535");
        jLabel8.setToolTipText("");

        range1.setToolTipText("");
        range1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                range1ActionPerformed(evt);
            }
        });

        range2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                range2ActionPerformed(evt);
            }
        });

        range3.setSelected(true);
        range3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                range3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Block?");

        startButton.setText("STOPPED");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(systemLabel)
                    .addComponent(sysList, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fireList, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fireLable)
                                    .addGap(65, 65, 65))
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(range1)
                                .addComponent(jLabel9)
                                .addComponent(range3)
                                .addComponent(range2))
                            .addGap(56, 56, 56)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(openPortField, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(openHashField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(openPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(allowHashButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(blockHashButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(portCloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addJob)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jobLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(idLabel)
                                    .addGap(46, 46, 46)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hashField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addComponent(jobList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobLabel)
                    .addComponent(fireLable)
                    .addComponent(systemLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fireList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(sysList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jobList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(range1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idLabel)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(range2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(range3)
                            .addComponent(jLabel8))
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hashField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(openPortButton)
                        .addComponent(portCloseButton)
                        .addComponent(openPortField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addJob)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(allowHashButton)
                            .addComponent(blockHashButton)
                            .addComponent(openHashField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //this is for the user of the simulation to add their own
    //jobs to the array list with custom ID PORT and HASH
    private void addJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJobActionPerformed
        jobList.add(idField.getText()+" "+portField.getText()+" "+hashField.getText());
        jobsList.add(new Job(Integer.parseInt(idField.getText()),
                Integer.parseInt(portField.getText()),Integer.parseInt(hashField.getText())) );
    }//GEN-LAST:event_addJobActionPerformed

    //this is a blanket function to cover a wide range of ports commonly 
    //blocked or unblocked on unix systems
    private void range2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_range2ActionPerformed
        if(range2.isSelected()==true)//check the gui check box
        {
            range_2 = true;
            for (int i = 1024; i < 49152; i++)//set all the ports in the range to blocked
		ports.put(i, false);
        }
        else
        {
            range_2 = false;
            for (int i = 1024; i < 49152; i++)//unblock all ports in the range if the check bo is toggled
		ports.put(i, true);
        }
        log(range_2);//Log is a functions I make and use for debugging because it is broader and simpler than
                        // system.out.println();
            
    }//GEN-LAST:event_range2ActionPerformed

    private void range1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_range1ActionPerformed
        if(range1.isSelected()==true){//check the gui checkbox for this range
            range_1 = true;
            for (int i = 0; i < 1024; i++){//blanket the first range to closed
		ports.put(i, false);
            }
        }
        else
        {
            for (int i = 0; i < 1024; i++){//if toggled we reopen all ports in the range
		ports.put(i, true);
            }
            range_1 = false;
        }
        log(range_1);
    }//GEN-LAST:event_range1ActionPerformed

    private void range3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_range3ActionPerformed
        if(range3.isSelected()==true){
            range_3 = true;
            for (int i = 49152; i < 65536; i++){
		ports.put(i, false);
            }
        }
        else    //Like the rest, we either allow or disallow the last range
        {
            range_3 = false;
            for (int i = 49152; i < 65536; i++){
		ports.put(i, true);
            }
        }
        log(range_3);
    }//GEN-LAST:event_range3ActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        //this button is what starts the entire show. After you add/block hashes/ports/jobs
        //this button is what starts the jobs moving to the firewall and beyond. if you choose to 
        //allow a blocked job through during runtime, you must click the button to stop, then resume again.
        if(startButton.isSelected()==true)
        {
            goTime = true;//this variable is useless, but it is infact go time
            startButton.setText("RUNNING");
            processJobs(badHashes,jobsList,ports);//jobs processed by the firewall during runtime
            
        }
        else
        {
            goTime = false;
            startButton.setText("STOPPED");//lets you know the state of the machine
        }
        log(goTime);
        log(startButton.getText());
    }//GEN-LAST:event_startButtonActionPerformed

    private void allowHashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowHashButtonActionPerformed
        int hash = Integer.parseInt(openHashField.getText());
        badHashes.put(hash, true);
        badHashes.remove(hash);
        log(badHashes.get(hash));//this is for allowing a hash that has been blocked to get through the firewall
    }//GEN-LAST:event_allowHashButtonActionPerformed

    private void blockHashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockHashButtonActionPerformed
        int hash = Integer.parseInt(openHashField.getText());
        badHashes.put(hash, false);
        log(badHashes.get(hash));//this will allow you to specify a hash to block from the system
    }//GEN-LAST:event_blockHashButtonActionPerformed

    private void openPortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openPortButtonActionPerformed
        int port = Integer.parseInt(openPortField.getText());
        ports.put(port, true);
        log(ports.get(port));//this allows you to specify a port as open, even if the range is blocked
    }//GEN-LAST:event_openPortButtonActionPerformed

    private void portCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portCloseButtonActionPerformed
        int port = Integer.parseInt(openPortField.getText());
        ports.put(port, false);
        log(ports.get(port));//this allows you to specify a port as blocked, even if the range is open
    }//GEN-LAST:event_portCloseButtonActionPerformed
    public static void log(Object a)//the famous log method for printing
    {
           System.out.println(String.valueOf(a));
    }
    public static void main(String args[]) 
    {       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new FirewallControl().setVisible(true);//create an instane of the initiated gui and make it viewable

                try 
                { 
                    loadJobs(jobFile, jobsList);//load jobs to arraylist
                    loadList(jobsList);//load incoming jobs to waiting queue
                    fillBadHashes(badHashes, hashFile); //load all malicious hashes into a hashmap in memory
                    processPorts(ports);//map all ports to the default mapping
                } 
                catch (IOException ex) 
                {
                    log(ex);//what happened?!
                }
            }
       });
    }
    public static void loadList(List<Job> jobsList)throws IOException
    {
        for(int i = 0; i < jobsList.size(); i++)
        {
            jobList.add(jobsList.get(i).toString(),i);//uses to string method of job to load it into the waiting queue
            log(jobsList.get(i));
        }
    }
    public static void loadJobs(File file, List<Job> jobs)throws IOException//load jobs from file reader to arrayList<>
    {
        try
	    {
	    	Scanner fileReader = new Scanner(file);
	    	int num;
	       	int port;
	        int hash;
                String fin;
	        
	        while(fileReader.hasNextLine())
	        {
	        	String parts[] = fileReader.nextLine().split(" ");
	        	num = Integer.parseInt(parts[0]);
	        	port = Integer.parseInt(parts[1]);//Split text into three parts, ID PORT and HASH
	        	hash = Integer.parseInt(parts[2]);
                        //log(hash);
	        	jobs.add(new Job(num, port, hash));//add new job to arraylist
	        }                                                
	        fileReader.close();
	    } catch(FileNotFoundException e){
	    	e.printStackTrace();
	    }   
	}
    public static void fillBadHashes(Map<Integer, Boolean> map, File f)throws IOException{
        Scanner in = new Scanner(f);	
        while(in.hasNext())
            map.put(Integer.parseInt(in.nextLine()), false);
    }
    public static void processPorts(Map<Integer,Boolean> map)//default settings for ports
    {
        for (int i = 0; i < 49151; i++)
        {
            map.put(i, true);
	}
        for (int i = 49152; i < 65535; i++)
        {
            map.put(i, false);
	}
    }
    public static void processJobs(Map<Integer,Boolean> map, List<Job> jobs, Map<Integer,Boolean> pMap)
    {//main algorithm for processing jobs through the system.
        int p;
        for(int i = 0; i < jobsList.size(); i++)
        {
            try//off the bat all jobs are taken off the list queue and sent to the firewall to manage
            {
             jobList.remove(jobsList.get(i).toString());
             Thread.sleep(25);
             fireList.add(jobsList.get(i).toString());
            }catch(Exception e){};
        }
        for(int i = 0; i < jobsList.size(); i++)
        {
            p = jobsList.get(i).getPort();
            log(p);
            log(pMap.get(p));
            if(!map.containsKey(jobsList.get(i).getHash()))//if the hash is even in the dict, its BAD
            {
                if(pMap.get(p) == true)//check if its mapping of ports is allowed by the user of firewall defaults
                {
                    try//move the jobs into the system
                    {
                    fireList.remove(jobsList.get(i).toString());
                    Thread.sleep(25);
                    sysList.add(jobsList.get(i).toString());
                    }catch(Exception e){};
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJob;
    private javax.swing.JButton allowHashButton;
    private javax.swing.JButton blockHashButton;
    private javax.swing.JLabel fireLable;
    private static java.awt.List fireList;
    private javax.swing.JTextField hashField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jobLabel;
    private static java.awt.List jobList;
    private javax.swing.JTextField openHashField;
    private javax.swing.JButton openPortButton;
    private javax.swing.JTextField openPortField;
    private javax.swing.JButton portCloseButton;
    private javax.swing.JTextField portField;
    private javax.swing.JCheckBox range1;
    private javax.swing.JCheckBox range2;
    private javax.swing.JCheckBox range3;
    private javax.swing.JToggleButton startButton;
    private static java.awt.List sysList;
    private javax.swing.JLabel systemLabel;
    // End of variables declaration//GEN-END:variables
}
