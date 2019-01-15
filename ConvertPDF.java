package Util;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/** 
 * ���ļ�ת��PDF��ʽ,�����ˮӡ
 *  
 * ��������������Ҫ��װOpenOffice
 * itext-2.1.7.jar
 * itestasian-2.1.7.jar
 * jodconverter-2.2.2.jar
 * jodconverter-cli-2.2.2.jar
 * commons-cli-1.2.jar  commons-io-1.4.jar
 * juh-3.0.1.jar jurt-3.0.1.jar  ridl-3.0.1.jar
 * slf4j-api-1.5.6.jar  slf4j-jdk14-1.5.6.jar
 * unoil-3.0.1.jar
 * xstream-1.3.1.jar
 *  
 */  
public class ConvertPDF {  

	/** 
	 * ��ڷ���-ͨ���˷���ת���ļ���PDF��ʽ 
	 * @param filePath  �ϴ��ļ������ļ��еľ���·�� 
	 * @param fileName  �ļ����� 
	 * @return          ����PDF�ļ��� 
	 * @throws FileNotFoundException 
	 * @throws DocumentException 
	 */  
	public String beginConvert(String filePath, String fileName) throws FileNotFoundException,IOException, DocumentException {  
		
		final String TXT = ".txt";
		final String DOC = ".doc";  
		final String DOCX = ".docx";  
		final String XLS = ".xls";  
		final String XLSX = ".xlsx";  
		final String PPT = ".ppt";
		final String PPTX = ".pptx";
		final String PDF = ".pdf";
		String outFile = "";  
		String fileNameOnly = "";  
		String fileExt = "";  
		if (null != fileName && fileName.lastIndexOf(".") > 0) {  
			int index = fileName.lastIndexOf(".");  
			fileNameOnly = fileName.substring(0, index);  
			fileExt = fileName.substring(index).toLowerCase();  
		}  
		String inputFile = filePath + "/" + fileName;  
		String outputFile = "";  
	
		//��һ���������office�ĵ�����תΪpdf�ļ�  
		if (fileExt.equals(DOC) || fileExt.equals(DOCX) || fileExt.equals(XLS)  
				|| fileExt.equals(XLSX)||fileExt.equals(PPT)||fileExt.equals(PPTX)||fileExt.equals(TXT)) {  
			outputFile = filePath + "/" + fileNameOnly + PDF;  
			office2PDF(inputFile, outputFile);  
			inputFile = outputFile;  
			fileExt = PDF;  
		}  
		
		//�ڶ������ѵ�һ�����ɵ�PDF����Զ���ˮӡ
		// ����ˮӡ���ļ�  
        PdfReader reader = new PdfReader("file:/"+inputFile);  
        // ����ˮӡ���ļ�  
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(inputFile));  
        // ��ȡ��ҳ��
        int total = reader.getNumberOfPages() + 1;    
        PdfContentByte content;  
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);  
        PdfGState gs = new PdfGState();  
        for (int i = 1; i < total; i++) {  
            content = stamper.getOverContent(i);// �������Ϸ���ˮӡ  
            //content = stamper.getUnderContent(i);//�������·���ˮӡ  
            gs.setFillOpacity(0.2f);  
            // content.setGState(gs);  
            content.beginText();  
            content.setColorFill(Color.LIGHT_GRAY);  
            content.setFontAndSize(base, 50);  
            content.setTextMatrix(70, 200);  
            content.showTextAligned(Element.ALIGN_CENTER, "��˾�ڲ��ļ�����ע�Ᵽ�ܣ�", 300,350, 55);    
            content.endText();  
        }  
       //�ر���
       stamper.close();  
       //����Ϊֻ�����ļ����֣�����ӦPDFJS���
       	outputFile=fileNameOnly+PDF;
		outFile = outputFile;  
		return outFile;  
	}  
	

	/** 
	 * office�ĵ�תpdf�ļ� 
	 * @param sourceFile    office�ĵ�����·�� 
	 * @param destFile      pdf�ļ�����·�� 
	 * @return 
	 */  
	private int office2PDF(String sourceFile, String destFile) {  
		ResourceBundle rb = ResourceBundle.getBundle("OpenOfficeService");  
		String OpenOffice_HOME = rb.getString("OO_HOME");  
		String host_Str = rb.getString("oo_host");  
		String port_Str = rb.getString("oo_port");  
		try {  
			File inputFile = new File(sourceFile);  
			if (!inputFile.exists()) {  
				return -1; // �Ҳ���Դ�ļ�   
			}  
			// ���Ŀ��·��������, ���½���·��    
			File outputFile = new File(destFile);  
			if (!outputFile.getParentFile().exists()) {  
				outputFile.getParentFile().mkdirs();  
			}  
			// ������ļ��ж�ȡ��URL��ַ���һ���ַ����� '\'�������'\'  
            if (OpenOffice_HOME.charAt(OpenOffice_HOME.length() - 1) != '\\') {  
                OpenOffice_HOME += "\\";  
            }  
			// ����OpenOffice�ķ���    
			String command = OpenOffice_HOME  
					+ "program\\soffice.exe -headless -accept=\"socket,host="  
					+ host_Str + ",port=" + port_Str + ";urp;\"";  
			System.out.println("###\n" + command);  
			Process pro = Runtime.getRuntime().exec(command);  
			// ����openoffice����  
			OpenOfficeConnection connection = new SocketOpenOfficeConnection(host_Str, Integer.parseInt(port_Str));  
			connection.connect();  
			// ת��   
			DocumentConverter converter = new OpenOfficeDocumentConverter(  connection);  
			
			//����ϴ��ĵ��������ǿյģ��ڲ��������쳣 conversion failed: could not save output document;
			converter.convert(inputFile, outputFile);  

			// �ر����Ӻͷ���  
			connection.disconnect();  
			pro.destroy();  

			return 0;  
		} catch (FileNotFoundException e) {  
			System.out.println("�ļ�δ�ҵ���");  
			e.printStackTrace();  
			return -1;  
		} catch (Exception e) {  
			System.out.println("OpenOffice��������쳣��");  
			e.printStackTrace();  
		}  
		return 1;  
	}  
	
	static String loadStream(BufferedInputStream in) throws IOException{  
		int ptr = 0;  
		in = new BufferedInputStream(in);  
		StringBuffer buffer = new StringBuffer();  

		while ((ptr=in.read())!= -1){  
			buffer.append((char)ptr);  
		}  
		return buffer.toString();  
	}  
	
	/**
	 * ���ˮӡ
	 * @param inputFile ·��
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws IOException
	 */
	
	public void addWater(String dirPath,String diskFileName,String waterFile) throws FileNotFoundException,DocumentException,IOException{
		//����·��
		String dirFileUrl=dirPath+"/"+diskFileName;
		// ����ˮӡ���ļ�  
        PdfReader reader = new PdfReader("file:/"+dirFileUrl);  
        // ����ˮӡ���ļ�   Constants.getTempPath() + File.separator + showFileName;
       
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(waterFile));  
        // ��ȡ��ҳ��
        int total = reader.getNumberOfPages() + 1;    
        PdfContentByte content;  
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);  
        PdfGState gs = new PdfGState();  
        for (int i = 1; i < total; i++) {  
        	content = stamper.getOverContent(i);// �������Ϸ���ˮӡ  
	      //content = stamper.getUnderContent(i);//�������·���ˮӡ  
        	gs.setFillOpacity(0.2f);
            content.beginText();
            content.setColorFill(Color.LIGHT_GRAY);  
            content.setFontAndSize(base, 32);  
            content.setTextMatrix(70, 200);  
            content.showTextAligned(Element.ALIGN_CENTER, "�ڲ��ļ�    ��ע�Ᵽ��", 300,200, 35);  			             
            content.showTextAligned(Element.ALIGN_CENTER, "�ڲ��ļ�    ��ע�Ᵽ��", 300,400, 35);  			             
            content.showTextAligned(Element.ALIGN_CENTER, "�ڲ��ļ�    ��ע�Ᵽ��", 300,600, 35);  			             
            content.endText();  
        }  
       //�ر���
        stamper.close();  
	}

}  