package poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ExportWordTest {
	public static void main(String[] args) throws Exception, IOException {       
        Map<String, Object> map=new HashMap<String, Object>();
        String sum = "额尔古纳河在1689年的《中俄尼布楚条约》中成为中国和俄罗斯的界河，额尔古纳河上游称海拉尔河，源于大兴安岭西侧，西流至阿该巴图山脚， 折而北行始称额尔古纳河。额尔古纳河在黑龙江省漠河县以西的内蒙古自治区额尔古纳右旗的恩和哈达附近与流经俄罗斯境内的石勒喀河汇合后始称黑龙江。沿额尔古纳河沿岸地区土地肥沃，森林茂密，水草丰美， 鱼类品种很多，动植物资源丰富，宜农宜木，是人类理想的天堂。";
        map.put("basin", "额尔古纳河流域");
        map.put("sum", sum);
        map.put("jnhl", "1");
        map.put("jwhl", "1");
        map.put("jnhp", "1");
        map.put("jwhp", "1");
        map.put("jnsk", "1");
        map.put("jwsk", "1");
        map.put("hj", "6");
        //注意biyezheng_moban.doc文档位置,此例中为应用根目录
        XWPFDocument doc=new ExportWordTest().replaceDoc("D:\\word_temp.docx", map);
        try {
        	OutputStream os = new FileOutputStream("D:\\tttt.doc");
        	doc.write(os);
            os.close();
            System.out.println("输出成功！");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }        
    }  
    /**
     * 读取word模板并替换变量
     * @param srcPath
     * @param map
     * @return
     */
    public XWPFDocument replaceDoc(String srcPath, Map<String, Object> param) {
        try {
            // 读取word模板
            InputStream fis = new FileInputStream(srcPath);
            XWPFDocument doc = new XWPFDocument(fis);
            //处理段落  
            List<XWPFParagraph> paragraphList = doc.getParagraphs();  
            processParagraph(paragraphList,doc,param);
            //处理表格
            Iterator<XWPFTable> it = doc.getTablesIterator();  
            while (it.hasNext()) {  
                XWPFTable table = it.next();  
                List<XWPFTableRow> rows = table.getRows();  
                for (XWPFTableRow row : rows) {  
                    List<XWPFTableCell> cells = row.getTableCells();  
                    for (XWPFTableCell cell : cells) {  
                        List<XWPFParagraph> paragraphListTable =  cell.getParagraphs();  
                        processParagraph(paragraphListTable, doc, param);  
                    }  
                }  
            }  
            return doc;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void processParagraph(List<XWPFParagraph> paragraphList,
    		XWPFDocument doc,Map<String, Object> param){
    	if(paragraphList != null && paragraphList.size() > 0){  
       	 for(XWPFParagraph paragraph:paragraphList){  
       		 List<XWPFRun> runs = paragraph.getRuns();  
       		 for (XWPFRun run : runs) {  
       			 String text = run.getText(0);  
                    if(text != null){  
                   	 boolean isSetText = false;  
                        for (Entry<String, Object> entry : param.entrySet()) {  
                            String key = entry.getKey();  
                            if(text.indexOf(key) != -1){  
                                isSetText = true;  
                                Object value = entry.getValue();  
                                if (value instanceof String) {//文本替换  
                                    text = text.replace(key, value.toString());  
                                    System.out.println(text);
                                } 
                                else{
                                    text = text.replace(key, "");  
                                }  
                            }  
                        }  
                        if(isSetText){  
                            run.setText(text,0);  
                        }  
                    }
       		 }
       	 }
       }
    } 
}