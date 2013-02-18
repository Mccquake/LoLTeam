package uk.co.eclipsion.lolteam;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class UserInterface {

	private JFrame frmLeagueOfLegends;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmLeagueOfLegends.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BufferedImage imgIcon = null, imgBaron = null, imgDragon = null, imgGolem = null, imgLizard = null, imgWolf = null, imgWraith = null;
		try {
			imgIcon = ImageIO.read(this.getClass().getResource("/images/riotlogo.png"));
			imgBaron = ImageIO.read(this.getClass().getResource("/images/BaronNashor.png"));
			imgDragon = ImageIO.read(this.getClass().getResource("/images/Dragon.png"));
			imgGolem = ImageIO.read(this.getClass().getResource("/images/Golem.png"));
			imgLizard = ImageIO.read(this.getClass().getResource("/images/Lizard.png"));
			imgWolf = ImageIO.read(this.getClass().getResource("/images/Wolf.png"));
			imgWraith = ImageIO.read(this.getClass().getResource("/images/Wraith.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		frmLeagueOfLegends = new JFrame();
		frmLeagueOfLegends.setResizable(false);
		frmLeagueOfLegends.setTitle("League of Legends Timers / Team Composition");
		frmLeagueOfLegends.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmLeagueOfLegends.setBounds(100, 100, 670, 600);
		frmLeagueOfLegends.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLeagueOfLegends.setIconImage(imgIcon);
		frmLeagueOfLegends.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		frmLeagueOfLegends.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		Panel panelTimers = new Panel();
		panelTimers.setBackground(Color.WHITE);
		tabbedPane.addTab("Timers", null, panelTimers);
		GridBagLayout gbl_panelTimers = new GridBagLayout();
		gbl_panelTimers.columnWidths = new int[]{80, 89, 89, 89, 89, 89, 89, 0};
		gbl_panelTimers.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelTimers.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTimers.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTimers.setLayout(gbl_panelTimers);
		
		JButton btnBTeamBlue = new JButton(new ImageIcon(imgGolem));
		btnBTeamBlue.setPreferredSize(new Dimension(64, 64));
		btnBTeamBlue.setContentAreaFilled(false);
		GridBagConstraints gbc_btnBTeamBlue = new GridBagConstraints();
		gbc_btnBTeamBlue.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamBlue.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamBlue.gridx = 1;
		gbc_btnBTeamBlue.gridy = 3;
		panelTimers.add(btnBTeamBlue, gbc_btnBTeamBlue);
		
		JButton btnBTeamRed = new JButton(new ImageIcon(imgLizard));
		btnBTeamRed.setPreferredSize(new Dimension(64, 64));
		btnBTeamRed.setContentAreaFilled(false);
		GridBagConstraints gbc_btnBTeamRed = new GridBagConstraints();
		gbc_btnBTeamRed.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamRed.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamRed.gridx = 2;
		gbc_btnBTeamRed.gridy = 3;
		panelTimers.add(btnBTeamRed, gbc_btnBTeamRed);
		
		JButton btnPTeamRed = new JButton(new ImageIcon(imgLizard));
		btnPTeamRed.setPreferredSize(new Dimension(64, 64));
		btnPTeamRed.setContentAreaFilled(false);
		GridBagConstraints gbc_btnPTeamRed = new GridBagConstraints();
		gbc_btnPTeamRed.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamRed.gridx = 4;
		gbc_btnPTeamRed.gridy = 3;
		panelTimers.add(btnPTeamRed, gbc_btnPTeamRed);
		
		JButton btnPTeamBlue = new JButton(new ImageIcon(imgGolem));
		btnPTeamBlue.setPreferredSize(new Dimension(64, 64));
		btnPTeamBlue.setContentAreaFilled(false);
		GridBagConstraints gbc_btnPTeamBlue = new GridBagConstraints();
		gbc_btnPTeamBlue.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamBlue.gridx = 5;
		gbc_btnPTeamBlue.gridy = 3;
		panelTimers.add(btnPTeamBlue, gbc_btnPTeamBlue);
		
		JButton btnDragon = new JButton(new ImageIcon(imgDragon));
		btnDragon.setPreferredSize(new Dimension(64, 64));
		btnDragon.setContentAreaFilled(false);
		GridBagConstraints gbc_btnDragon = new GridBagConstraints();
		gbc_btnDragon.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDragon.insets = new Insets(0, 0, 5, 5);
		gbc_btnDragon.gridx = 3;
		gbc_btnDragon.gridy = 4;
		panelTimers.add(btnDragon, gbc_btnDragon);
		
		JButton btnBTeamWolf = new JButton(new ImageIcon(imgWolf));
		btnBTeamWolf.setPreferredSize(new Dimension(64, 64));
		btnBTeamWolf.setContentAreaFilled(false);
		GridBagConstraints gbc_btnBTeamWolf = new GridBagConstraints();
		gbc_btnBTeamWolf.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamWolf.gridx = 1;
		gbc_btnBTeamWolf.gridy = 5;
		panelTimers.add(btnBTeamWolf, gbc_btnBTeamWolf);
		
		JButton btnPTeamWolf = new JButton(new ImageIcon(imgWolf));
		btnPTeamWolf.setPreferredSize(new Dimension(64, 64));
		btnPTeamWolf.setContentAreaFilled(false);
		GridBagConstraints gbc_btnPTeamWolf = new GridBagConstraints();
		gbc_btnPTeamWolf.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamWolf.gridx = 5;
		gbc_btnPTeamWolf.gridy = 5;
		panelTimers.add(btnPTeamWolf, gbc_btnPTeamWolf);
		
		JButton btnBTeamWraith = new JButton(new ImageIcon(imgWraith));
		btnBTeamWraith.setPreferredSize(new Dimension(64, 64));
		btnBTeamWraith.setContentAreaFilled(false);
		GridBagConstraints gbc_btnBTeamWraith = new GridBagConstraints();
		gbc_btnBTeamWraith.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamWraith.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamWraith.gridx = 1;
		gbc_btnBTeamWraith.gridy = 6;
		panelTimers.add(btnBTeamWraith, gbc_btnBTeamWraith);
		
		JButton btnBaron = new JButton(new ImageIcon(imgBaron));
		btnBaron.setPreferredSize(new Dimension(64, 64));
		btnBaron.setContentAreaFilled(false);
		GridBagConstraints gbc_btnBaron = new GridBagConstraints();
		gbc_btnBaron.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBaron.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaron.gridx = 3;
		gbc_btnBaron.gridy = 6;
		panelTimers.add(btnBaron, gbc_btnBaron);
		
		JButton btnPTeamWraith = new JButton(new ImageIcon(imgWraith));
		btnPTeamWraith.setPreferredSize(new Dimension(64, 64));
		btnBTeamRed.setPreferredSize(new Dimension(64, 64));
		btnBTeamRed.setContentAreaFilled(false);
		GridBagConstraints gbc_btnPTeamWraith = new GridBagConstraints();
		gbc_btnPTeamWraith.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamWraith.gridx = 5;
		gbc_btnPTeamWraith.gridy = 6;
		panelTimers.add(btnPTeamWraith, gbc_btnPTeamWraith);
		
		JButton btnBTeamGolem = new JButton(new ImageIcon(imgGolem));
		btnBTeamGolem.setPreferredSize(new Dimension(64, 64));
		btnBTeamGolem.setContentAreaFilled(false);
		GridBagConstraints gbc_btnBTeamGolem = new GridBagConstraints();
		gbc_btnBTeamGolem.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamGolem.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamGolem.gridx = 1;
		gbc_btnBTeamGolem.gridy = 7;
		panelTimers.add(btnBTeamGolem, gbc_btnBTeamGolem);
		
		JButton btnPTeamGolem = new JButton(new ImageIcon(imgGolem));
		btnPTeamGolem.setPreferredSize(new Dimension(64, 64));
		btnPTeamGolem.setContentAreaFilled(false);
		GridBagConstraints gbc_btnPTeamGolem = new GridBagConstraints();
		gbc_btnPTeamGolem.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamGolem.gridx = 5;
		gbc_btnPTeamGolem.gridy = 7;
		panelTimers.add(btnPTeamGolem, gbc_btnPTeamGolem);
		
		Panel panelComp = new Panel();
		panelComp.setBackground(Color.WHITE);
		tabbedPane.addTab("Team Composition", null, panelComp);
		
		Panel panelItems = new Panel();
		tabbedPane.addTab("Item Builds", null, panelItems);
	}

}
