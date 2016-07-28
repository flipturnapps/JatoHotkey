package com.flipturnapps.jatohotkey.mcbinds2.start;

import java.io.File;
import java.io.IOException;

import com.flipturnapps.kevinLibrary.helper.TextFileHelper;

public class SettingsFinder 
{
	private static final String SETTINGS_FILENAME = "mc-binds-settings.dll";
	
	private File dir;

	private String ip;

	private McBindsGui mcBindsGui;
	public SettingsFinder( McBindsGui gui)
	{
		mcBindsGui = gui;
	}
    public void walk( String path ) 
    {
    	if(dir != null)
    		return;
        File root = new File( path );
        File[] list = root.listFiles();

        if (dir != null || list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
               // System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else
            {
                //System.out.println( "File:" + f.getAbsoluteFile() );
                if(f.getName().equalsIgnoreCase(SETTINGS_FILENAME))
                {
                	try {
						if(TextFileHelper.getFirstTextLine(f).replace(":", "~").split("~").length == 4)
						{
							ip = TextFileHelper.getFirstTextLine(f);
							dir = root;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
    }
    public void walk()
    {
    	//System.out.println();
    	walk(System.getProperty("user.home"));
    	if(dir != null)
    	{
    		//System.out.println("foundit: " + dir.getAbsolutePath());
    		mcBindsGui.setStartIp(ip);
    	}
    }


}
