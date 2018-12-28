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
 * 生成html
 * */
public class FreemarkerUtil {
	private static final Configuration cfg;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        try {
            // 设置模板路径
            cfg.setDirectoryForTemplateLoading(new File("files/"));
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
     * @Description:生成静态页面
     */
    public static void createHtmlByMode(String modeName, String targetFileName,
    		Map<String, Object> params) throws Exception {
        Writer out = null;
        //找到服务器缓存目录，可以自己指定目录
        //String folder = System.getProperty("java.io.tmpdir");
        String folder = "files/";
        
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
        /*params.put("title", "test");
        params.put("author", "aaa");
        params.put("publishTime", "2018-02-09");
        params.put("seeNum", "888");
        params.put("imgPath", "http://upload-images.jianshu.io/upload_images/10298880-f713c678f63be447.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
*/
        params.put("test", " <div><div>  以下函数查找一个整数数组中第二大的数，请填空。 "
        		+ "</div><div><div id=\"highlighter_880682\">"
        		+ "<div style=\"display:none;\"></div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"
        		+ "<tbody><tr><td><div>1</div><div>2</div><div>3</div><div>4</div><div>5</div>"
        		+ "<div>6</div><div>7</div><div>8</div><div>9</div><div>10</div><div>11</div>"
        		+ "<div class=\"line number12 index11 alt1\">12</div><div class=\"line number13 index12 alt2\">13"
        		+ "</div><div class=\"line number14 index13 alt1\">14</div><div class=\"line number15 index14 alt2\">15"
        		+ "</div><div class=\"line number16 index15 alt1\">16</div><div class=\"line number17 index16 alt2\">17</div><div class=\"line number18 index17 alt1\">18</div><div class=\"line number19 index18 alt2\">19</div><div class=\"line number20 index19 alt1\">20</div><div class=\"line number21 index20 alt2\">21</div></td><td class=\"code\"><div class=\"container\"><div><code class=\"java plain\">#include &lt;stdio.h&gt;</code></div><div><code class=\"java keyword\">const</code> <code class=\"java keyword\">int</code> <code class=\"java plain\">MINNUMBER = -</code><code class=\"java value\">32767</code><code class=\"java plain\">;</code></div><div><code class=\"java keyword\">int</code> <code class=\"java plain\">find_set_max(</code><code class=\"java keyword\">int</code> <code class=\"java plain\">data[], </code><code class=\"java keyword\">int</code> <code class=\"java plain\">count)</code></div><div><code class=\"java plain\">{</code></div><div><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">int</code> <code class=\"java plain\">maxnumber = data[</code><code class=\"java value\">0</code><code class=\"java plain\">];</code></div><div><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">int</code> <code class=\"java plain\">sec_max = MINNUMBER;</code></div><div><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">for</code> <code class=\"java plain\">(</code><code class=\"java keyword\">int</code> <code class=\"java plain\">i = </code><code class=\"java value\">1</code><code class=\"java plain\">; i &lt; count; i ++ )</code></div><div><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">{</code></div><div><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">if</code> <code class=\"java plain\">(maxnumber &lt; data[i])</code></div><div><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">{&nbsp;&nbsp;</code></div><div><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">();</code></div><div class=\"line number12 index11 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">();</code></div><div class=\"line number13 index12 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number14 index13 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">else</code></div><div class=\"line number15 index14 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">{</code></div><div class=\"line number16 index15 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">if</code> <code class=\"java plain\">(data[i] &nbsp;&gt; sec_max)</code></div><div class=\"line number17 index16 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">()</code></div><div class=\"line number18 index17 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number19 index18 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number20 index19 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">return</code> <code class=\"java plain\">sec_max;</code></div><div class=\"line number21 index20 alt2\"><code class=\"java plain\">}</code></div></div></td></tr></tbody></table></div></div><br/></div>");
        params.put("test2", "2");
        FreemarkerUtil.createHtmlByMode("test.ftl", "test.html", params);
        System.out.println("ok");
    }


}
