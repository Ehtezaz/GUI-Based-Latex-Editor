package ehtezazahmed;
import de.nixosoft.jlr.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GeneratePDF {

	public GeneratePDF(){


		        File workingDirectory = new File("C:" + File.separator + "Invoices");
		        System.out.println("WOrking Directory... "+workingDirectory);
		        
		        File template = new File(workingDirectory.getAbsolutePath() + File.separator + "invoiceTemplate.tex");
		        System.out.println("Templete.. "+template);
		        
		        File tempDir = new File(workingDirectory.getAbsolutePath() + File.separator + "temp");
		        System.out.println("TempDir.. "+ tempDir);
		        
		        if (!tempDir.isDirectory()) {
		            tempDir.mkdir();
		            System.out.println("TempDir.mkdir.. "+ tempDir.mkdir());
		        }
		        
		        
		        File invoice1 = new File(tempDir.getAbsolutePath() + File.separator + "invoice1.tex");
		        System.out.println("Check invoice 1.. "+ invoice1);
		        File invoice2 = new File(tempDir.getAbsolutePath() + File.separator + "invoice2.tex");
		        System.out.println("Check invoice 2.. "+ invoice2);


		         try {
		            JLRConverter converter = new JLRConverter(workingDirectory);

		            converter.replace("Number", "1");
		            converter.replace("CustomerName", "Ivan Pfeiffer");
		            converter.replace("CustomerStreet", "Schwarzer Weg 4");
		            converter.replace("CustomerZip", "13505 Berlin");

		            ArrayList<ArrayList<String>> services = new ArrayList<ArrayList<String>>();
				
		            ArrayList<String> subservice1 = new ArrayList<String>();
		            ArrayList<String> subservice2 = new ArrayList<String>();
		            ArrayList<String> subservice3 = new ArrayList<String>();
				
		            subservice1.add("Software");
		            subservice1.add("50");
		            subservice2.add("Hardware1");
		            subservice2.add("500");
		            subservice3.add("Hardware2");
		            subservice3.add("850");
				
		            services.add(subservice1);
		            services.add(subservice2);
		            services.add(subservice3);		
				
		            converter.replace("services", services);
		            		         
		            if (!converter.parse(template, invoice1)) {
		                System.out.println(converter.getErrorMessage());		                
		            }
		            
///////////////////////////////////////////////////////////////////////////////////////////

		            converter.replace("Number", "2");
		            converter.replace("CustomerName", "Mike Mueller");
		            converter.replace("CustomerStreet", "Prenzlauer Berg 12");
		            converter.replace("CustomerZip", "10405 Berlin");
		            
		            services = new ArrayList<ArrayList<String>>();
				
		            subservice1 = new ArrayList<String>();
		            subservice2 = new ArrayList<String>();
		            subservice3 = new ArrayList<String>();
				
		            subservice1.add("Software");
		            subservice1.add("150");
		            subservice2.add("Hardware");
		            subservice2.add("500");
		            subservice3.add("Test");
		            subservice3.add("350");
				
		            services.add(subservice1);
		            services.add(subservice2);
		            services.add(subservice3);
		            
		            converter.replace("services", services);

		            if (!converter.parse(template, invoice2)) {
		                System.out.println(converter.getErrorMessage());
		            }
		            

		            
		            
		            File desktop = new File(System.getProperty("user.home") + File.separator + "Desktop");
		            System.out.println("desktop System.getproperty UserHome.. "+ desktop);
		            
		            JLRGenerator pdfGen = new JLRGenerator();           
		            System.out.println("Check.. 00");
		            if (!pdfGen.generate(invoice1, desktop, workingDirectory)) { 
		            	System.out.println(pdfGen.getErrorMessage());
		            }

		            System.out.println("Check.. 01");
		            
		            JLROpener.open(pdfGen.getPDF());
		            System.out.println("Check.. 02");
		            
		            if (!pdfGen.generate(invoice2, desktop, workingDirectory)) {
		                System.out.println(pdfGen.getErrorMessage());
		            }
		            
		            System.out.println("Check.. 03");
		            JLROpener.open(pdfGen.getPDF());

		        } catch (IOException ex) {
		            System.err.println(ex.getMessage());
		        }
		    }
		
}
