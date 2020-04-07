package aaa;

import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Created by llh on 2018-04-28
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		insertTable();
	}

	public static void insertTable() throws Exception {

		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		FileOutputStream fos = new FileOutputStream("D:\\111.pdf");
		// 使用PDFWriter进行写文件操作
		PdfWriter.getInstance(document, fos);
		document.open();

		// 中文字体(现在高版本的不支持中文包)
		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font fontChinese = new Font(bfChinese, 10, Font.NORMAL);// 中文、12、正常
		Paragraph title = new Paragraph("备案登记表", new Font(bfChinese, 16f, Font.BOLD));
		title.setLeading(16f);
		title.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell = new PdfPCell(title);
		cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
		cell.setVerticalAlignment(PdfPCell.ALIGN_TOP);
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.addElement(title);

		float[] arr = { 20, 20, 20, 20, 20, 20 };
		PdfPTable table = new PdfPTable(arr);

		table.addCell(cell);

		cell = new PdfPCell();
		cell.setFixedHeight(10);
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// 单位名称
		cell = new PdfPCell(new Paragraph("    单位名称（盖章）：", fontChinese));
		cell.setColspan(3);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
		// 交表时间
		cell = new PdfPCell(new Paragraph("交表时间：        年        月        日        ", fontChinese));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setColspan(3);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
		// 第一行
		cell = new PdfPCell(new Paragraph("项目名称", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setColspan(5);
		table.addCell(cell);
		// 第二行
		cell = new PdfPCell(new Paragraph("名称", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setRowspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setRowspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("联系人", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setRowspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setRowspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("办公电话", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("移动电话", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		table.addCell(cell);
		Paragraph p = new Paragraph("预算金额", fontChinese);
		// 第三行
		cell = new PdfPCell(p);
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		System.out.println(cell.getWidth());
		System.out.println(cell.getHeight());
		System.out.println(cell.getVerticalAlignment());
		System.out.println(cell.getHorizontalAlignment());

		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("中标金额", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("金额", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setFixedHeight(20);
		table.addCell(cell);
		// 第四行
		cell = new PdfPCell(new Paragraph("签订时间", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setColspan(2);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("确认时间", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setColspan(2);
		cell.setFixedHeight(20);
		table.addCell(cell);
		// 第五行
		cell = new PdfPCell(new Paragraph("公告时间", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setColspan(2);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("备案时间", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(20);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", fontChinese));
		cell.setColspan(2);
		cell.setFixedHeight(20);
		table.addCell(cell);
		// 第六行
		cell = new PdfPCell(new Paragraph("\r\n资料清单", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(60);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("1、 ", fontChinese));
		cell.setColspan(5);
		table.addCell(cell);
		// 第七行
		cell = new PdfPCell(new Paragraph("采购单位承诺", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(80);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("\r\n\r\n        本表填报的内容及提交的所有材料的原件或复印件\r\n\r\n"
				+ "                                                                 （盖章）            年            月            日\r\n",
				fontChinese));
		cell.setColspan(5);
		table.addCell(cell);
		// 第八行
		cell = new PdfPCell(new Paragraph("采购代理机构合同确认承诺", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(90);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("\r\n        本合同已于             年             月             日完成确认。\r\n\r\n"
				+ "        经办人（签名）：\r\n\r\n" + "        单位（盖章）：\r\n"
				+ "                                                                          年             月             日\r\n",
				fontChinese));
		cell.setColspan(5);
		table.addCell(cell);
		// 第九行
		cell = new PdfPCell(new Paragraph("区公共资源交易管理委员会办公室审批意见", fontChinese));
		cell.setUseAscender(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setFixedHeight(150);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph(
				"\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n                                                                 （盖章）            年            月            日",
				fontChinese));
		cell.setColspan(5);
		table.addCell(cell);
		document.add(table);
		System.out.println("123:" + table.getTotalHeight());
		table = new PdfPTable(arr);
		// 底部说明文字
		cell = new PdfPCell(new Paragraph("说明：", fontChinese));
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		document.add(table);
		System.out.println(table.getTotalWidth());
		System.out.println(table.getTotalHeight());
		System.out.println(table.getHorizontalAlignment());
		System.out.println(table.getWidthPercentage());
		System.out.println(document.getPageSize().getHeight());
		document.close();
	}
}