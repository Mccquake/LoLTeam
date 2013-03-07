/*
 * Author : Eclipsion Team
 * Date : March 2013
 */
package uk.co.eclipsion.lolteam;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class UserInterface {

	private JFrame frmLeagueOfLegends;
	private Timer timeBaron, timeDragon, timeBBlue, timeBRed, timePBlue, timePRed, timeBWolf, timeBGolem, timeBWraith, timePWolf, timePGolem, timePWraith;
	private JButton btnBaron, btnDragon, btnBTeamBlue, btnBTeamRed, btnBTeamWolf, btnBTeamGolem, btnBTeamWraith, btnPTeamBlue, btnPTeamRed, btnPTeamWolf, btnPTeamGolem, btnPTeamWraith;
	private long baronTimeRemaining = 420000, dragonTimeRemaining = 360000, BBlueTimeRemaining = 300000, PBlueTimeRemaining = 300000, BRedTimeRemaining = 300000
			, PRedTimeRemaining = 300000, BWolfTimeRemaining = 60000, BWraithTimeRemaining = 50000, BGolemTimeRemaining = 60000, PWolfTimeRemaining = 60000
			, PWraithTimeRemaining = 50000, PGolemTimeRemaining = 60000;
	private DateFormat dFormat = new SimpleDateFormat("mm:ss");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		
		Panel panelTimers = new TimersPanel();
		tabbedPane.addTab("Timers", null, panelTimers);
		GridBagLayout gbl_panelTimers = new GridBagLayout();
		gbl_panelTimers.columnWidths = new int[]{89, 89, 89, 89, 89, 89, 89, 0};
		gbl_panelTimers.rowHeights = new int[]{0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelTimers.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTimers.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTimers.setLayout(gbl_panelTimers);
		
		initTimers();
		
		btnBTeamBlue = new JButton(timeFormat(BBlueTimeRemaining) ,new ImageIcon(imgGolem));
		btnBTeamBlue.setBackground(new Color(51, 102, 255));
		btnBTeamBlue.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBTeamBlue.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBTeamBlue.setMinimumSize(new Dimension(97, 95));
		btnBTeamBlue.setMaximumSize(new Dimension(97, 95));
		btnBTeamBlue.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnBTeamBlue = new GridBagConstraints();
		gbc_btnBTeamBlue.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamBlue.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamBlue.gridx = 1;
		gbc_btnBTeamBlue.gridy = 3;
		panelTimers.add(btnBTeamBlue, gbc_btnBTeamBlue);
		
		btnBTeamRed = new JButton(timeFormat(BRedTimeRemaining) ,new ImageIcon(imgLizard));
		btnBTeamRed.setBackground(new Color(51, 102, 255));
		btnBTeamRed.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBTeamRed.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBTeamRed.setMinimumSize(new Dimension(97, 95));
		btnBTeamRed.setMaximumSize(new Dimension(97, 95));
		btnBTeamRed.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnBTeamRed = new GridBagConstraints();
		gbc_btnBTeamRed.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamRed.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamRed.gridx = 2;
		gbc_btnBTeamRed.gridy = 3;
		panelTimers.add(btnBTeamRed, gbc_btnBTeamRed);
		
		btnPTeamRed = new JButton(timeFormat(PRedTimeRemaining) ,new ImageIcon(imgLizard));
		btnPTeamRed.setBackground(new Color(153, 51, 255));
		btnPTeamRed.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPTeamRed.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPTeamRed.setMinimumSize(new Dimension(97, 95));
		btnPTeamRed.setMaximumSize(new Dimension(97, 95));
		btnPTeamRed.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnPTeamRed = new GridBagConstraints();
		gbc_btnPTeamRed.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamRed.gridx = 4;
		gbc_btnPTeamRed.gridy = 3;
		panelTimers.add(btnPTeamRed, gbc_btnPTeamRed);
		
		btnPTeamBlue = new JButton(timeFormat(PBlueTimeRemaining) ,new ImageIcon(imgGolem));
		btnPTeamBlue.setBackground(new Color(153, 51, 255));
		btnPTeamBlue.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPTeamBlue.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPTeamBlue.setMinimumSize(new Dimension(97, 95));
		btnPTeamBlue.setMaximumSize(new Dimension(97, 95));
		btnPTeamBlue.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnPTeamBlue = new GridBagConstraints();
		gbc_btnPTeamBlue.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamBlue.gridx = 5;
		gbc_btnPTeamBlue.gridy = 3;
		panelTimers.add(btnPTeamBlue, gbc_btnPTeamBlue);
		
		btnDragon = new JButton(timeFormat(dragonTimeRemaining) ,new ImageIcon(imgDragon));
		btnDragon.setBackground(new Color(255, 0, 0));
		btnDragon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDragon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDragon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDragon.setMinimumSize(new Dimension(97, 95));
		btnDragon.setMaximumSize(new Dimension(97, 95));
		GridBagConstraints gbc_btnDragon = new GridBagConstraints();
		gbc_btnDragon.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDragon.insets = new Insets(0, 0, 5, 5);
		gbc_btnDragon.gridx = 3;
		gbc_btnDragon.gridy = 4;
		panelTimers.add(btnDragon, gbc_btnDragon);
		
		btnBTeamWolf = new JButton(timeFormat(BWolfTimeRemaining) ,new ImageIcon(imgWolf));
		btnBTeamWolf.setBackground(new Color(51, 102, 255));
		btnBTeamWolf.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBTeamWolf.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBTeamWolf.setMinimumSize(new Dimension(97, 95));
		btnBTeamWolf.setMaximumSize(new Dimension(97, 95));
		btnBTeamWolf.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnBTeamWolf = new GridBagConstraints();
		gbc_btnBTeamWolf.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamWolf.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamWolf.gridx = 1;
		gbc_btnBTeamWolf.gridy = 5;
		panelTimers.add(btnBTeamWolf, gbc_btnBTeamWolf);
		
		btnPTeamWolf = new JButton(timeFormat(PWolfTimeRemaining) ,new ImageIcon(imgWolf));
		btnPTeamWolf.setBackground(new Color(153, 51, 255));
		btnPTeamWolf.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPTeamWolf.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPTeamWolf.setMinimumSize(new Dimension(97, 95));
		btnPTeamWolf.setMaximumSize(new Dimension(97, 95));
		btnPTeamWolf.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnPTeamWolf = new GridBagConstraints();
		gbc_btnPTeamWolf.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamWolf.gridx = 5;
		gbc_btnPTeamWolf.gridy = 5;
		panelTimers.add(btnPTeamWolf, gbc_btnPTeamWolf);
		
		btnBTeamWraith = new JButton(timeFormat(BWraithTimeRemaining) ,new ImageIcon(imgWraith));
		btnBTeamWraith.setBackground(new Color(51, 102, 255));
		btnBTeamWraith.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBTeamWraith.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBTeamWraith.setMinimumSize(new Dimension(97, 95));
		btnBTeamWraith.setMaximumSize(new Dimension(97, 95));
		btnBTeamWraith.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnBTeamWraith = new GridBagConstraints();
		gbc_btnBTeamWraith.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamWraith.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamWraith.gridx = 1;
		gbc_btnBTeamWraith.gridy = 6;
		panelTimers.add(btnBTeamWraith, gbc_btnBTeamWraith);
		
		btnBaron = new JButton(timeFormat(baronTimeRemaining) ,new ImageIcon(imgBaron));
		btnBaron.setBackground(new Color(255, 0, 0));
		btnBaron.setPreferredSize(new Dimension(97, 100));
		btnBaron.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBaron.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaron.setMinimumSize(new Dimension(97, 95));
		btnBaron.setMaximumSize(new Dimension(97, 95));
		btnBaron.setVerticalAlignment(SwingConstants.TOP);
		btnBaron.setVerticalTextPosition(SwingConstants.BOTTOM);

		GridBagConstraints gbc_btnBaron = new GridBagConstraints();
		gbc_btnBaron.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBaron.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaron.gridx = 3;
		gbc_btnBaron.gridy = 6;
		panelTimers.add(btnBaron, gbc_btnBaron);
		
		btnPTeamWraith = new JButton(timeFormat(PWraithTimeRemaining), new ImageIcon(imgWraith));
		btnPTeamWraith.setBackground(new Color(153, 51, 255));
		btnPTeamWraith.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPTeamWraith.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPTeamWraith.setMinimumSize(new Dimension(97, 95));
		btnPTeamWraith.setMaximumSize(new Dimension(97, 95));
		btnPTeamWraith.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnPTeamWraith = new GridBagConstraints();
		gbc_btnPTeamWraith.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamWraith.gridx = 5;
		gbc_btnPTeamWraith.gridy = 6;
		panelTimers.add(btnPTeamWraith, gbc_btnPTeamWraith);
		
		btnBTeamGolem = new JButton(timeFormat(BGolemTimeRemaining), new ImageIcon(imgGolem));
		btnBTeamGolem.setBackground(new Color(51, 102, 255));
		btnBTeamGolem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBTeamGolem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBTeamGolem.setMinimumSize(new Dimension(97, 95));
		btnBTeamGolem.setMaximumSize(new Dimension(97, 95));
		btnBTeamGolem.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnBTeamGolem = new GridBagConstraints();
		gbc_btnBTeamGolem.insets = new Insets(0, 0, 5, 5);
		gbc_btnBTeamGolem.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBTeamGolem.gridx = 1;
		gbc_btnBTeamGolem.gridy = 7;
		panelTimers.add(btnBTeamGolem, gbc_btnBTeamGolem);
		
		btnPTeamGolem = new JButton(timeFormat(PGolemTimeRemaining), new ImageIcon(imgGolem));
		btnPTeamGolem.setBackground(new Color(153, 51, 255));
		btnPTeamGolem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPTeamGolem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPTeamGolem.setMinimumSize(new Dimension(97, 95));
		btnPTeamGolem.setMaximumSize(new Dimension(97, 95));
		btnPTeamGolem.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnPTeamGolem = new GridBagConstraints();
		gbc_btnPTeamGolem.insets = new Insets(0, 0, 5, 5);
		gbc_btnPTeamGolem.gridx = 5;
		gbc_btnPTeamGolem.gridy = 7;
		panelTimers.add(btnPTeamGolem, gbc_btnPTeamGolem);
		
		initMouse();
		
		Panel panelComp = new TeamCompositionPanel();
		panelComp.setBackground(Color.WHITE);
		tabbedPane.addTab("Team Composition", null, panelComp);
		
		Panel panelItems = new Panel();
		tabbedPane.addTab("Item Builds", null, panelItems);
		
		Panel panelAbout = new AboutPanel();
		tabbedPane.addTab("About", null, panelAbout);
	}
	
	/**
	 * This will take in the time in miliseconds and convert it to a mm:ss format.
	 * @param long of the timer in miliseconds.
	 */
	private String timeFormat(long time) {
		Date dTime = new Date();
		dTime.setTime(time);
		String strTime = dFormat.format(dTime);
		return strTime;
	}
	
	/*
	 * Initialising MouseListeners and Timers
	 */
	
	public void initMouse() {
		btnBaron.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeBaron.start();
				btnBaron.setEnabled(false);
			}
		});
		btnDragon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeDragon.start();
				btnDragon.setEnabled(false);
			}
		});
		btnBTeamBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeBBlue.start();
				btnBTeamBlue.setEnabled(false);
			}
		});
		btnBTeamRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeBRed.start();
				btnBTeamRed.setEnabled(false);
			}
		});
		btnBTeamWolf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeBWolf.start();
				btnBTeamWolf.setEnabled(false);
			}
		});
		btnBTeamWraith.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeBWraith.start();
				btnBTeamWraith.setEnabled(false);
			}
		});
		btnBTeamGolem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeBGolem.start();
				btnBTeamGolem.setEnabled(false);
			}
		});
		btnPTeamBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timePBlue.start();
				btnPTeamBlue.setEnabled(false);
			}
		});
		btnPTeamRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timePRed.start();
				btnPTeamRed.setEnabled(false);
			}
		});
		btnPTeamWolf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timePWolf.start();
				btnPTeamWolf.setEnabled(false);
			}
		});
		btnPTeamWraith.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timePWraith.start();
				btnPTeamWraith.setEnabled(false);
			}
		});
		btnPTeamGolem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timePGolem.start();
				btnPTeamGolem.setEnabled(false);
			}
		});
	}
	
	public void initTimers() {
		timeBaron = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.BARON);
				btnBaron.setText(timeFormat(baronTimeRemaining));
				boolean check = checkTimer(TimerType.BARON);
				if(check) {
					btnBaron.setText(timeFormat(baronTimeRemaining));
					timeBaron.stop();
					btnBaron.setEnabled(true);
				}
			}
		});
		timeDragon = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.DRAGON);
				btnDragon.setText(timeFormat(dragonTimeRemaining));
				boolean check = checkTimer(TimerType.DRAGON);
				if(check) {
					btnDragon.setText(timeFormat(dragonTimeRemaining));
					timeDragon.stop();
					btnDragon.setEnabled(true);
				}
			}
		});
		timeBBlue = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.BBLUE);
				btnBTeamBlue.setText(timeFormat(BBlueTimeRemaining));
				boolean check = checkTimer(TimerType.BBLUE);
				if(check) {
					btnBTeamBlue.setText(timeFormat(BBlueTimeRemaining));
					timeBBlue.stop();
					btnBTeamBlue.setEnabled(true);
				}
			}
		});
		timeBRed = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.BRED);
				btnBTeamRed.setText(timeFormat(BRedTimeRemaining));
				boolean check = checkTimer(TimerType.BRED);
				if(check) {
					btnBTeamRed.setText(timeFormat(BRedTimeRemaining));
					timeBRed.stop();
					btnBTeamRed.setEnabled(true);
				}
			}
		});
		timePBlue = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.PBLUE);
				btnPTeamBlue.setText(timeFormat(PBlueTimeRemaining));
				boolean check = checkTimer(TimerType.PBLUE);
				if(check) {
					btnPTeamBlue.setText(timeFormat(PBlueTimeRemaining));
					timePBlue.stop();
					btnPTeamBlue.setEnabled(true);
				}
			}
		});
		timePRed = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.PRED);
				btnPTeamRed.setText(timeFormat(PRedTimeRemaining));
				boolean check = checkTimer(TimerType.PRED);
				if(check) {
					btnPTeamRed.setText(timeFormat(PRedTimeRemaining));
					timePRed.stop();
					btnPTeamRed.setEnabled(true);
				}
			}
		});
		timeBWolf = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.BWOLF);
				btnBTeamWolf.setText(timeFormat(BWolfTimeRemaining));
				boolean check = checkTimer(TimerType.BWOLF);
				if(check) {
					btnBTeamWolf.setText(timeFormat(BWolfTimeRemaining));
					timeBWolf.stop();
					btnBTeamWolf.setEnabled(true);
				}
			}
		});
		timePWolf = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.PWOLF);
				btnPTeamWolf.setText(timeFormat(PWolfTimeRemaining));
				boolean check = checkTimer(TimerType.PWOLF);
				if(check) {
					btnPTeamWolf.setText(timeFormat(PWolfTimeRemaining));
					timePWolf.stop();
					btnPTeamWolf.setEnabled(true);
				}
			}
		});
		timeBWraith = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.BWRAITH);
				btnBTeamWraith.setText(timeFormat(BWraithTimeRemaining));
				boolean check = checkTimer(TimerType.BWRAITH);
				if(check) {
					btnBTeamWraith.setText(timeFormat(BWraithTimeRemaining));
					timeBWraith.stop();
					btnBTeamWraith.setEnabled(true);
				}
			}
		});
		timePWraith = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.PWRAITH);
				btnPTeamWraith.setText(timeFormat(PWraithTimeRemaining));
				boolean check = checkTimer(TimerType.PWRAITH);
				if(check) {
					btnPTeamWraith.setText(timeFormat(PWraithTimeRemaining));
					timePWraith.stop();
					btnPTeamWraith.setEnabled(true);
				}
			}
		});
		timeBGolem = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.BGOLEM);
				btnBTeamGolem.setText(timeFormat(BGolemTimeRemaining));
				boolean check = checkTimer(TimerType.BGOLEM);
				if(check) {
					btnBTeamGolem.setText(timeFormat(BGolemTimeRemaining));
					timeBGolem.stop();
					btnBTeamGolem.setEnabled(true);
				}
			}
		});
		timePGolem = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decTimer(TimerType.PGOLEM);
				btnPTeamGolem.setText(timeFormat(PGolemTimeRemaining));
				boolean check = checkTimer(TimerType.PGOLEM);
				if(check) {
					btnPTeamGolem.setText(timeFormat(PGolemTimeRemaining));
					timePGolem.stop();
					btnPTeamGolem.setEnabled(true);
				}
			}
		});
	}
	
	/*
	 * Setting up the methods for the timer to decrement and check if the timer is up.
	 */
	
	public void decTimer(TimerType type) {
		switch(type) {
		case BARON:
			baronTimeRemaining -= 1000;
			break;
		case DRAGON:
			dragonTimeRemaining -= 1000;
			break;
		case BBLUE:
			BBlueTimeRemaining -= 1000;
			break;
		case BRED:
			BRedTimeRemaining -= 1000;
			break;
		case BWOLF:
			BWolfTimeRemaining -= 1000;
			break;
		case BWRAITH:
			BWraithTimeRemaining -= 1000;
			break;
		case BGOLEM:
			BGolemTimeRemaining -= 1000;
			break;
		case PBLUE:
			PBlueTimeRemaining -= 1000;
			break;
		case PRED:
			PRedTimeRemaining -= 1000;
			break;
		case PWOLF:
			PWolfTimeRemaining -= 1000;
			break;
		case PWRAITH:
			PWraithTimeRemaining -= 1000;
			break;
		case PGOLEM:
			PGolemTimeRemaining -= 1000;
			break;
		default:
		}
	}

	private boolean checkTimer(TimerType type) {
		switch(type) {
		case BARON:
			if(baronTimeRemaining == 0) {
				baronTimeRemaining = 420000;
				return true;
			} else {
				return false;
			}
		case DRAGON:
			if(dragonTimeRemaining == 0) {
				dragonTimeRemaining = 360000;
				return true;
			} else {
				return false;
			}
		case BBLUE:
			if(BBlueTimeRemaining == 0) {
				BBlueTimeRemaining = 300000;
				return true;
			} else {
				return false;
			}
		case BRED:
			if(BRedTimeRemaining == 0) {
				BRedTimeRemaining = 300000;
				return true;
			} else {
				return false;
			}
		case BWOLF:
			if(BWolfTimeRemaining == 0) {
				BWolfTimeRemaining = 60000;
				return true;
			} else {
				return false;
			}
		case BWRAITH:
			if(BWraithTimeRemaining == 0) {
				BWraithTimeRemaining = 50000;
				return true;
			} else {
				return false;
			}
		case BGOLEM:
			if(BGolemTimeRemaining == 0) {
				BGolemTimeRemaining = 60000;
				return true;
			} else {
				return false;
			}
		case PBLUE:
			if(PBlueTimeRemaining == 0) {
				PBlueTimeRemaining = 300000;
				return true;
			} else {
				return false;
			}
		case PRED:
			if(PRedTimeRemaining == 0) {
				PRedTimeRemaining = 300000;
				return true;
			} else {
				return false;
			}
		case PWOLF:
			if(PWolfTimeRemaining == 0) {
				PWolfTimeRemaining = 60000;
				return true;
			} else {
				return false;
			}
		case PWRAITH:
			if(PWraithTimeRemaining == 0) {
				PWraithTimeRemaining = 50000;
				return true;
			} else {
				return false;
			}
		case PGOLEM:
			if(PGolemTimeRemaining == 0) {
				PGolemTimeRemaining = 60000;
				return true;
			} else {
				return false;
			}
		default:
			return true;
		}
	}
	
}
