package aaa;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFToImage {

/*

	 * *

	 * 实现pdf文件转换为png

	 * 参数是第一个是要转的转换的是pdffile

	 * 第二个参数是是要存储的png图片的路径

	 */

	public static void pdfFileToImage(File pdffile,String targetPath){
        try {
        	OutputStream os = null;
        	
            FileInputStream instream = new FileInputStream(pdffile);
            try {
                PDDocument doc = PDDocument.load(instream);
                PDFRenderer renderer = new PDFRenderer(doc);
                int pageCount = doc.getNumberOfPages();
                List<BufferedImage> list = new ArrayList<BufferedImage>();
                for(int i=0;i<pageCount;i++) {
                	BufferedImage image = renderer.renderImage(i, 2.0f);
                	list.add(image);
                }
                appendPic(list,targetPath);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

	

    public static byte[] readInputStream(InputStream inStream) throws Exception {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];

        int len = 0;

        while ((len = inStream.read(buffer)) != -1) {

            outStream.write(buffer, 0, len);

        }

        inStream.close();

        return outStream.toByteArray();

    }


	public static void main(String[] args) {

		File file =new File("C:\\Users\\DELL\\Documents\\资金核实表.pdf");

		//上传的是png格式的图片结尾

		String targetfile="F:\\test.png";

		pdfFileToImage(file,targetfile);

	}
	
	/**
	 * 将宽度相同的图片，竖向追加在一起 ##注意：宽度必须相同
	 * @param piclist
	 *            文件流数组
	 * @param outPath
	 *            输出路径
	 */
	public static void appendPic(List<BufferedImage> piclist, String outPath) {
		if (piclist == null || piclist.size() <= 0) {
			return;
		}
		try {
			int height = 0, // 总高度
			width = 0, // 总宽度
			_height = 0, // 临时的高度 , 或保存偏移高度
			_height_ = 0, // 临时的高度，主要保存每个高度
			picNum = piclist.size();// 图片的数量
			File fileImg = null; // 保存读取出的图片
			int[] heightArray = new int[picNum]; // 保存每个文件的高度
			BufferedImage buffer = null; // 保存图片流
			List<int[]> imgRGB = new ArrayList<int[]>(); // 保存所有的图片的RGB
			int[] _imgRGB; // 保存一张图片中的RGB数据
			for (int i = 0; i < picNum; i++) {
				buffer = piclist.get(i);
				heightArray[i] = _height = buffer.getHeight();// 图片高度
				if (i == 0) {
					width = buffer.getWidth();// 图片宽度
				}
				height += _height; // 获取总高度
				_imgRGB = new int[width * _height];// 从图片中读取RGB
				_imgRGB = buffer.getRGB(0, 0, width, _height, _imgRGB, 0, width);
				imgRGB.add(_imgRGB);
			}
			_height = 0; // 设置偏移高度为0
			// 生成新图片
			BufferedImage imageResult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < picNum; i++) {
				_height_ = heightArray[i];
				if (i != 0) _height += _height_; // 计算偏移高度
				imageResult.setRGB(0, _height, width, _height_, imgRGB.get(i), 0, width); // 写入流中
			}
			File outFile = new File(outPath);
			ImageIO.write(imageResult, "jpg", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
