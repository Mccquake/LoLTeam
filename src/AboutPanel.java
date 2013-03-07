package uk.co.eclipsion.lolteam;

import java.awt.Panel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

public class AboutPanel extends Panel{

	public AboutPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblLeagueOfLegends = new JLabel("League of Legends Timers and Team Composition Generator");
		lblLeagueOfLegends.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblLeagueOfLegends = new GridBagConstraints();
		gbc_lblLeagueOfLegends.insets = new Insets(0, 0, 5, 0);
		gbc_lblLeagueOfLegends.gridx = 4;
		gbc_lblLeagueOfLegends.gridy = 2;
		add(lblLeagueOfLegends, gbc_lblLeagueOfLegends);
		
		JLabel lblBuiltBy = new JLabel("Built by : Eclipsion");
		lblBuiltBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblBuiltBy = new GridBagConstraints();
		gbc_lblBuiltBy.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuiltBy.gridx = 4;
		gbc_lblBuiltBy.gridy = 5;
		add(lblBuiltBy, gbc_lblBuiltBy);
		
		JLabel lblCurrentVersion = new JLabel("Current Version : v1.2 - March 2013");
		lblCurrentVersion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurrentVersion = new GridBagConstraints();
		gbc_lblCurrentVersion.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentVersion.gridx = 4;
		gbc_lblCurrentVersion.gridy = 6;
		add(lblCurrentVersion, gbc_lblCurrentVersion);
		
		JLabel lblFanArtUsed = new JLabel("Fan Art used : Ashe Background on Timers Page - Unknown Artist");
		lblFanArtUsed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFanArtUsed = new GridBagConstraints();
		gbc_lblFanArtUsed.insets = new Insets(0, 0, 5, 0);
		gbc_lblFanArtUsed.gridx = 4;
		gbc_lblFanArtUsed.gridy = 9;
		add(lblFanArtUsed, gbc_lblFanArtUsed);
		
		JLabel lblLeagueOfLegends_1 = new JLabel("League of Legends is Copyright of Riot Games, all references and images");
		lblLeagueOfLegends_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblLeagueOfLegends_1 = new GridBagConstraints();
		gbc_lblLeagueOfLegends_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblLeagueOfLegends_1.gridx = 4;
		gbc_lblLeagueOfLegends_1.gridy = 12;
		add(lblLeagueOfLegends_1, gbc_lblLeagueOfLegends_1);
		
		JLabel lblUsedWithinAre = new JLabel("used within are their rightful intellectual property.");
		lblUsedWithinAre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUsedWithinAre = new GridBagConstraints();
		gbc_lblUsedWithinAre.gridx = 4;
		gbc_lblUsedWithinAre.gridy = 13;
		add(lblUsedWithinAre, gbc_lblUsedWithinAre);
	}
	
}
