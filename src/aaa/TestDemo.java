package aaa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class TestDemo {
	
	@Test
	public void run() throws Exception {
		addPdfImgMark("D:\\备案表.pdf", "D:\\格.pdf","C:\\Users\\DELL\\Desktop\\ju.png",250,243);
	}
	
	/**
	 * @param InPdfFile 要加水印的原pdf文件路径
	 * @param outPdfFile 加了水印后要输出的路径
	 * @param markImagePath 水印图片路径
	 * @param imgWidth 图片横坐标
	 * @param imgHeight 图片纵坐标
	 * @throws Exception
	 * @see void
	 */
	public static void addPdfImgMark(String InPdfFile, String outPdfFile, String markImagePath,int imgWidth, int imgHeight) throws Exception {  
		PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());  
		PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(new File(outPdfFile)));  
		PdfContentByte under;
		PdfGState gs1 = new PdfGState();  
		gs1.setFillOpacity(1f);// 透明度设置
		Image img = Image.getInstance(markImagePath);// 插入图片水印	
		img.setAbsolutePosition(imgWidth, imgHeight); // 坐标
		img.setRotation(-20);// 旋转 弧度
		img.setRotationDegrees(45);// 旋转 角度
		img.scaleAbsolute(100,100);//自定义大小
		// img.scalePercent(50);//依照比例缩放		
		int pageSize = reader.getNumberOfPages();// 原pdf文件的总页数
		for(int i = 1; i <= pageSize; i++) {  
			under = stamp.getUnderContent(i);// 水印在之前文本下
			// under = stamp.getOverContent(i);//水印在之前文本上
			under.setGState(gs1);// 图片水印 透明度
			under.addImage(img);// 图片水印
		}  		
		stamp.close();// 关闭
		// // 删除不带水印文件
//		File tempfile = new File(InPdfFile);  		
//		if(tempfile.exists()) {  		
//			tempfile.delete();  
//		}  		
	}
	
	@Test
	public void run1() throws Exception {
		File file = new File("E:\\filetest");
		if(!file.exists()) {
			file.mkdir();
		}
	}
	
	@Test
	public void run2() {
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(()->System.out.println("Thred-----------------!"));
	}
	
	@Test
	public void run3() {
		List list = new ArrayList<>();
		System.out.println(list=null);
//		System.out.println(null=list);
	}
	
	@Test
	public void run4() {
		Double d = new Double(1230067000);
		System.out.println(d);
	}
	
	private static final String AA = "12345678";
	@Test
	public void run5() {
		AA.replace("78","9");
		System.out.println(AA);
	}
	
	@Test
	public void run6() {
		List<String> list = new ArrayList<String>();
		list.add(null);
		System.out.println(list.size());
	}
	
}
