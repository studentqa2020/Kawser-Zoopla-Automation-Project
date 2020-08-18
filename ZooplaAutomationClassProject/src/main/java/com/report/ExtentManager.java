package com.report;

import java.io.File;

import org.apache.commons.lang3.SystemUtils;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {//setup of extends report
        private static ExtentReports extent;
        private static String reportFileName = "Extents-Report"+".html";//1= report name
        private static String fileSeperator = System.getProperty("file.separator");
        private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "target";
        private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
       
        public static ExtentReports getInstance() {
            if (extent == null)// no report
                createInstance();
            return extent;
        }
   
        //Create an extent report instance
        public static ExtentReports createInstance() {
            String fileName = getReportPath(reportFilepath);                          
          
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
            htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");//2= config file path
            htmlReporter.config().setAutoCreateRelativePathMedia(true);
			
           
            extent = new ExtentReports();
            //dashboad
            extent.attachReporter(new ExtentReporter[]{htmlReporter});
            extent.setSystemInfo("Host Name", SystemUtils.getHostName());
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            
            return extent;
        }
        
        //Create the report path
        private static String getReportPath (String path) {
            File testDirectory = new File(path);
            if (!testDirectory.exists()) {
                if (testDirectory.mkdir()) {
                    System.out.println("Directory: " + path + " is created!" );
                    return reportFileLocation;
                } else {
                    System.out.println("Failed to create directory: " + path);
                    return System.getProperty("user.dir");
                }
            } else {
                System.out.println("Directory already exists: " + path);
            }
            return reportFileLocation;
        }
}

