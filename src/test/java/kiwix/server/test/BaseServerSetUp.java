package kiwix.server.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.springer.omelet.common.Utils;

public class BaseServerSetUp {
	
	Process proc;
	@BeforeSuite
	public void setUpServe(){
		String path = System.getProperty("user.dir")+"/src/main/resources".replace("/", File.separator);
		String kiwixPath = path+"/kiwix-serve".replace("/", File.separator);
		String port = "8000";
		String zimFilePath = Utils.getResources(this, "wikipedia_en_ray_charles_03_2013.zim");
		ProcessBuilder pb  = new ProcessBuilder(kiwixPath,"--port="+port,zimFilePath);
		try {
			 proc = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterSuite
	public void tearDown(){
		proc.destroy();
		/*
		List<String> tearDownCommandBuilder = new ArrayList<String>();
		tearDownCommandBuilder.add("pkill");
		tearDownCommandBuilder.add("-f");
		tearDownCommandBuilder.add("kiwix-serve");
		ProcessBuilder pb  = new ProcessBuilder(tearDownCommandBuilder);
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}

}
