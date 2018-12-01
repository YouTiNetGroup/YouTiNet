package com.youti.api.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 生成html demo
 * */
public class FreemarkerUtil {
	private static final Configuration cfg;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        try {
            // 设置模板路径
            cfg.setDirectoryForTemplateLoading(new File("D:\\"));
            // 设置默认编码
            cfg.setDefaultEncoding("utf-8");
            //若发生错误，HTML_DEBUG_HANDLER会生成错误信息到生成页面;RETHROW_HANDLER错误信息会输出到控制台
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param modeName       模板名称
     * @param targetFileName 生成后的HTML名称
     * @param params         传入模板的参数
     * @Author: IT实战联盟Tony
     * @Date: 15:57 2018/2/9
     * @Description:生成静态页面
     */
    public static void createHtmlByMode(String modeName, String targetFileName,
    		Map<String, Object> params) throws Exception {
        Writer out = null;
        //找到服务器缓存目录，可以自己指定目录
        //String folder = System.getProperty("java.io.tmpdir");
        String folder = "D:\\";
        
        //通过匹配路径格式拼接完整生成路径
        String outFile = folder + File.separator + targetFileName;
        try {
            File file = new File(outFile);
            //生成空HTML文件
            if (!file.exists()) {
                file.createNewFile();
            }

            // 创建模版对象
            Template template = cfg.getTemplate(modeName);

            // 设置输出流
            out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");// 设置编码 UTF-8

            // 模版数据插入参数，通过输出流插入到HTML中
            template.process(params, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
    
    public static void main(String[] args) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        /*params.put("title", "IT实战联盟");
        params.put("author", "tony");
        params.put("publishTime", "2018-02-09");
        params.put("seeNum", "888");
        params.put("seeNum", "888");
        params.put("imgPath", "http://upload-images.jianshu.io/upload_images/10298880-f713c678f63be447.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        params.put("content", "扫码关注IT实战联盟，IT实战联盟是集产品、UI设计、前后端、架构、大数据和AI人工智能等为一体的实战交流服务平台！联盟嘉宾都为各互联网公司项目的核心成员，联盟主旨是“让实战更简单”，欢迎来撩~~~");
*/
        params.put("test", "<div class=\"subject-des\"><p><span>下面关于散列查找的说法正确的是</span><span>（ </span><span>）"
        		+ "</span><span>。</span></p><ul class=\"subject-des-list\"><li>散列函数构造得越复杂越好，因为这样随机性好，冲突小</li>"
        		+ "<li>除留余数法是所有散列函数中最好的</li><li>不存在特别好与坏的散列函数，要视情况而定</li>"
        		+ "<li>若需在散列表中删去一个元素，不管用何种方法解决冲突都只要简单地将该元素删去即可</li></ul></div>");
        
        FreemarkerUtil.createHtmlByMode("test.ftl", "test.html", params);
    }


}
