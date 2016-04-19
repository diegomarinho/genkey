package br.com.mv.genkey;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;

/**
 * Using Keytool to Import SSL Certificates into Sun JDK.
 * 
 * @author diego.almeida
 * @since 22/08/2015
 *
 */
public class GenKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmDesktop;
	private JTextField txtOutputPath;
	private JButton BtnOutputPath;
	private JFileChooser chooser5;
	private JFileChooser chooser6;
	private JFileChooser chooser7;
	private JFileChooser chooser8;
	private JLabel lblLogo;
	private JLabel lblKeyPasswPath;
	private JTextField txtKeyPassw;
	private JTextField txtKeystoreFilePath;
	private JButton btnKeystoreFilePath;
	private JLabel lblKeystorePath;
	private JLabel lblAliasName;
	private JLabel lblStep;
	private JLabel lblStep_1;
	private JTextField txtPfxFilePath;
	private JButton btnPfxFilePath;
	private JLabel lblPfxFile;
	private JButton btnProcess;
	private JLabel lblKeystoreToCacerts;
	private JLabel lblBuild;
	private JTextField txtAliasName;
	private JTextField txtCerFilePath;
	private JLabel lblCerPath;
	private JButton btnCerFilePath;
	private JButton btnBuild;
	private JLabel lblStorepass;
	private JTextField textStorepass;
	private JLabel lblMvSistemas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenKey window = new GenKey();
					window.frmDesktop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GenKey() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDesktop = new JFrame();
		frmDesktop.setResizable(false);
		frmDesktop.setTitle("..: GenKey - MV Sistemas :..");
		frmDesktop.setBounds(100, 100, 650, 430);
		frmDesktop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDesktop.getContentPane().setLayout(new MigLayout("", "[86.00px][204.00px,grow][45px]", "[66.00px][][][][][][][][][][][][]"));
		
		lblLogo = new JLabel();
		URL imageURL = this.getClass().getClassLoader().getResource(".\\images\\logo.png"); 
		ImageIcon iChing= new ImageIcon(".\\images\\logo.png");
		lblLogo.setIcon(iChing); System.out.println(imageURL);
		frmDesktop.getContentPane().add(lblLogo, "cell 0 0");
		
		lblMvSistemas = new JLabel("..: MV Sistemas :..");
		lblMvSistemas.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmDesktop.getContentPane().add(lblMvSistemas, "cell 1 0,alignx center,aligny center");
		
		lblStep = new JLabel("STEP 1:");
		lblStep.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmDesktop.getContentPane().add(lblStep, "cell 0 1,alignx right");
		
		lblKeystoreToCacerts = new JLabel("Exporting the SSL certificate (on Windows)");
		lblKeystoreToCacerts.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmDesktop.getContentPane().add(lblKeystoreToCacerts, "cell 1 1");
		
		lblPfxFile = new JLabel("PFX File:");
		frmDesktop.getContentPane().add(lblPfxFile, "cell 0 2,alignx trailing");
		
		txtPfxFilePath = new JTextField();
		txtPfxFilePath.setText("C:\\cert\\PFX_FILE.pfx");
		txtPfxFilePath.setColumns(10);
		frmDesktop.getContentPane().add(txtPfxFilePath, "cell 1 2,grow");
		
		btnPfxFilePath = new JButton("...");
		btnPfxFilePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser5 = new JFileChooser();
				chooser5.setCurrentDirectory(new java.io.File("."));
				chooser5.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				// disable the "All files" option.
				chooser5.setAcceptAllFileFilterUsed(false);

				if (chooser5.showOpenDialog(frmDesktop) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser5.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser5.getSelectedFile());
					txtPfxFilePath.setText(chooser5.getSelectedFile().toString());
				} else {
					System.out.println("No Selection.");
				}
			}
		});
		frmDesktop.getContentPane().add(btnPfxFilePath, "cell 2 2,growy");
		
		lblKeyPasswPath = new JLabel("Keystore Password:");
		frmDesktop.getContentPane().add(lblKeyPasswPath, "cell 0 3,alignx trailing");
		
		txtKeyPassw = new JTextField();
		txtKeyPassw.setText("123456");
		txtKeyPassw.setColumns(10);
		frmDesktop.getContentPane().add(txtKeyPassw, "cell 1 3,grow");
		
		JLabel lblOutputPath = new JLabel("Data File:");
		frmDesktop.getContentPane().add(lblOutputPath, "cell 0 4,alignx right,growy");
		
		txtOutputPath = new JTextField();
		txtOutputPath.setText("C:\\cert\\temp_dados_cert.txt");
		txtOutputPath.setColumns(10);
		frmDesktop.getContentPane().add(txtOutputPath, "cell 1 4,grow");
		
		BtnOutputPath = new JButton("...");
		BtnOutputPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser8 = new JFileChooser();
				chooser8.setCurrentDirectory(new java.io.File("."));
				chooser8.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				// disable the "All files" option.
				chooser8.setAcceptAllFileFilterUsed(false);

				if (chooser8.showOpenDialog(frmDesktop) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser8.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser8.getSelectedFile());
					txtOutputPath.setText(chooser8.getSelectedFile().toString());
				} else {
					System.out.println("No Selection.");
				}
			}
		});
		frmDesktop.getContentPane().add(BtnOutputPath, "cell 2 4,alignx left,growy");
		
		btnProcess = new JButton("Export");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();
				@SuppressWarnings("unused")
				Process processo = null;
				
				try {
					// Adiciona o keystore no Cacerts
					processo = runtime.exec("cmd /c start Export.bat " + txtPfxFilePath.getText() + " " + txtKeyPassw.getText() + " " + txtOutputPath.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frmDesktop.getContentPane().add(btnProcess, "cell 1 5,alignx right");
		
		lblStep_1 = new JLabel("STEP 2:");
		lblStep_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmDesktop.getContentPane().add(lblStep_1, "cell 0 7,alignx right");
		
		lblBuild = new JLabel("Import a certificate");
		lblBuild.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmDesktop.getContentPane().add(lblBuild, "cell 1 7");
		
		lblKeystorePath = new JLabel("Keystore Path:");
		frmDesktop.getContentPane().add(lblKeystorePath, "cell 0 8,alignx right");
		
		txtKeystoreFilePath = new JTextField();
		txtKeystoreFilePath.setText("C:\\cert\\key.keystore");
		txtKeystoreFilePath.setColumns(10);
		frmDesktop.getContentPane().add(txtKeystoreFilePath, "cell 1 8,grow");
		
		btnKeystoreFilePath = new JButton("...");
		btnKeystoreFilePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser6 = new JFileChooser();
				chooser6.setCurrentDirectory(new java.io.File("."));
				chooser6.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				// disable the "All files" option.
				chooser6.setAcceptAllFileFilterUsed(false);

				if (chooser6.showOpenDialog(frmDesktop) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser6.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser6.getSelectedFile());
					txtKeystoreFilePath.setText(chooser6.getSelectedFile().toString());
				} else {
					System.out.println("No Selection.");
				}
			}
		});
		frmDesktop.getContentPane().add(btnKeystoreFilePath, "cell 2 8,growy");
		
		lblAliasName = new JLabel("Alias Name:");
		frmDesktop.getContentPane().add(lblAliasName, "cell 0 9,alignx trailing");
		
		txtAliasName = new JTextField();
		txtAliasName.setText("nfse");
		txtAliasName.setColumns(10);
		frmDesktop.getContentPane().add(txtAliasName, "cell 1 9,growx");
		
		lblCerPath = new JLabel("Cer Path:");
		frmDesktop.getContentPane().add(lblCerPath, "cell 0 10,alignx trailing");
		
		txtCerFilePath = new JTextField();
		txtCerFilePath.setText("C:\\cert\\cert.cer");
		txtCerFilePath.setColumns(10);
		frmDesktop.getContentPane().add(txtCerFilePath, "cell 1 10,growx");
		
		btnCerFilePath = new JButton("...");
		btnCerFilePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser7 = new JFileChooser();
				chooser7.setCurrentDirectory(new java.io.File("."));
				chooser7.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				// disable the "All files" option.
				chooser7.setAcceptAllFileFilterUsed(false);

				if (chooser7.showOpenDialog(frmDesktop) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser7.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser7.getSelectedFile());
					txtCerFilePath.setText(chooser7.getSelectedFile().toString());
				} else {
					System.out.println("No Selection.");
				}
			}
		});
		frmDesktop.getContentPane().add(btnCerFilePath, "cell 2 10");
		
		lblStorepass = new JLabel("Storepass:");
		frmDesktop.getContentPane().add(lblStorepass, "cell 0 11,alignx trailing");
		
		textStorepass = new JTextField();
		textStorepass.setText("123456");
		textStorepass.setColumns(10);
		frmDesktop.getContentPane().add(textStorepass, "cell 1 11,growx");
		
		btnBuild = new JButton("Import");
		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();
				Process processo = null;
				
				try {
					// Adiciona o keystore no Cacerts
					processo = runtime.exec("cmd /c start Import.bat " + txtAliasName.getText() + " " + txtKeystoreFilePath.getText() + " " + textStorepass.getText() + " " + txtCerFilePath.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frmDesktop.getContentPane().add(btnBuild, "cell 1 12,alignx right,aligny center");
		frmDesktop.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmDesktop.getContentPane()}));
	}

}
