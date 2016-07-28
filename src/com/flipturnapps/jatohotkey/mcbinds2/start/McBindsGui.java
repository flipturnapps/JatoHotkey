package com.flipturnapps.jatohotkey.mcbinds2.start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.flipturnapps.kevinLibrary.helper.FileHelper;
import com.flipturnapps.kevinLibrary.helper.TextFileHelper;

public class McBindsGui extends JFrame implements Runnable, ActionListener
{
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					McBindsGui frame = new McBindsGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel contentPane;
	private JTextField textField_ip;
	private JTextField textField_password;
	private JButton btnNewButton;


	public McBindsGui() 
	{
		setTitle("Kevlar Mc Server Key Binder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_settings = new JPanel();
		contentPane.add(panel_settings, BorderLayout.CENTER);
		panel_settings.setLayout(new BoxLayout(panel_settings, BoxLayout.Y_AXIS));

		JPanel panel_ipconfig = new JPanel();
		FlowLayout fl_panel_ipconfig = (FlowLayout) panel_ipconfig.getLayout();
		fl_panel_ipconfig.setAlignment(FlowLayout.LEFT);
		panel_settings.add(panel_ipconfig);

		JLabel lblNewLabel = new JLabel("Server IP:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 19));
		panel_ipconfig.add(lblNewLabel);

		textField_ip = new JTextField();
		textField_ip.setFont(new Font("Calibri", Font.PLAIN, 17));
		panel_ipconfig.add(textField_ip);
		textField_ip.setColumns(15);
		

		JPanel panel_password = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_password.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		panel_settings.add(panel_password);

		JLabel lblPassword = new JLabel("Mc Username:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 19));
		panel_password.add(lblPassword);

		textField_password = new JTextField();
		textField_password.setFont(new Font("Calibri", Font.PLAIN, 17));
		textField_password.setColumns(15);
		panel_password.add(textField_password);

		JPanel panel_go = new JPanel();
		contentPane.add(panel_go, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel("Bind My Keys: ");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 19));
		panel_go.add(lblNewLabel_1);

		btnNewButton = new JButton("Go");
		btnNewButton.addActionListener(this);
		panel_go.add(btnNewButton);
	}


	public void setStartIp(String ip) 
	{
		this.textField_ip.setText(ip);
	}


	@Override
	public void run()
	{
		File dir = new File(FileHelper.getAppDataDir("flipturnapps", "jatohotkey-mcbinds"));
		dir.mkdirs();
		File file = new File(FileHelper.fileInDir(dir,"startupsettings"));
		if(!file.exists())
			new SettingsFinder(this).walk();
		else
		{
			String[] data = null;
			try {
				data = TextFileHelper.getTextByLine(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
			textField_ip.setText(data[0]);
			textField_password.setText(data[1]);
			}
			catch (Exception ex)
			{
				
			}
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
