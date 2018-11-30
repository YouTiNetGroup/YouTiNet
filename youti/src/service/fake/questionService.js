export const FakeQuestionService = {
  getAllQuestions: () => {
    return Promise.resolve({
      isSuccess: true,
      message: "成功",
      data: 
      [
        {
          question_id: 1000001,
          type_id: 1,
          content: "<div class=\"subject-des\"><p><span>下面关于散列查找的说法正确的是</span><span>（ </span><span>）</span><span>。</span></p><ul class=\"subject-des-list\"><li>散列函数构造得越复杂越好，因为这样随机性好，冲突小</li><li>除留余数法是所有散列函数中最好的</li><li>不存在特别好与坏的散列函数，要视情况而定</li><li>若需在散列表中删去一个元素，不管用何种方法解决冲突都只要简单地将该元素删去即可</li><ul></ul></ul></div>",
          answer: "<div>C</div>",
          score: 2,
          difficulty_degree: "1",
          subject_id: 1,
          knowledge_point_id: 1
        },
        {
          question_id: 1000002,
          type_id: 1,
          content: "<div class=\"subject-des\">下列哪个查找方法的平均查找长度与查找表中数据元素个数无关？<ul class=\"subject-des-list\"><li>哈希（散列）查找</li><li>顺序查找</li><li>折半查找</li><li>B+树查找</li><ul></ul></ul></div>",
          answer: "<div>A</div>",
          score: 2,
          difficulty_degree: "2",
          subject_id: 1,
          knowledge_point_id: 1
        },
        {
          question_id: 1000003,
          type_id: 1,
          content: "<div class=\"subject-des\"><span>若一组记录的排序码为（46,&nbsp;79,&nbsp;56,&nbsp;38,&nbsp;40,&nbsp;84），则利用快速排序，以第一个记录为基准得到的一次划分结果是 （） </span><ul class=\"subject-des-list\"><li>38, 40, 46, 56, 79, 84</li><li>40，38, 46 ,79, 56, 84</li><li>40, 38，46, 56, 79, 84</li><li>40, 38，46，84, 56, 79</li><ul></ul></ul></div>",
          answer: "<div>C</div>",
          score: 2,
          difficulty_degree: "3",
          subject_id: 1,
          knowledge_point_id: 2
        },
        {
          question_id: 1000004,
          type_id: 1,
          content: "<div class=\"subject-des\">下面有关java object默认的基本方法，说法错误的是？<ul class=\"subject-des-list\"><li>equals(Object obj) 指示某个其他对象是否与此对象“相等”</li><li>copy() 创建并返回此对象的一个副本</li><li>wait() 导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法</li><li>toString() 返回该对象的字符串表示</li><ul></ul></ul></div>",
          answer: "<div>B</div>",
          score: 2,
          difficulty_degree: "4",
          subject_id: 2,
          knowledge_point_id: 7
        },
        {
          question_id: 1000005,
          type_id: 1,
          content: "<div class=\"subject-des\">下面选项中合法的字符常量是？<ul class=\"subject-des-list\"><li>\"X\"</li><li>'X'</li><li>'abc'</li><li>'\\'</li><ul></ul></ul></div>",
          answer: "<div>B</div>",
          score: 2,
          difficulty_degree: "2",
          subject_id: 3,
          knowledge_point_id: 13
        },
        {
          question_id: 1000006,
          type_id: 2,
          content: "<div class=\"subject-des\">下面使用贪心算法的是？<ul class=\"subject-des-list\"><li>单元最短路径 Dijkstra 算法</li><li>最小生成树 Prim 算法</li><li>最小生成树 Kruskal 算法</li><li>计算每对顶点最短路径的 Floyd-Warshall 算法</li><ul></ul></ul></div>",
          answer: "<div>A B C</div>",
          score: 4,
          difficulty_degree: "3",
          subject_id: 1,
          knowledge_point_id: 4
        },
        {
          question_id: 1000007,
          type_id: 2,
          content: "<div class=\"subject-des\">以下哪些算法可用于遍历网络图？<ul class=\"subject-des-list\"><li>广度优先搜索</li><li>深度优先搜索</li><li>线性规划策略</li><li>决策树</li><ul></ul></ul></div>",
          answer: "<div>A B</div>",
          score: 4,
          difficulty_degree: "2",
          subject_id: 1,
          knowledge_point_id: 5
        },
        {
          question_id: 1000008,
          type_id: 2,
          content: "<div class=\"subject-des\">struct 和 class 的区别?<ul class=\"subject-des-list\"><li>struct 的成员默认是公有的</li><li>struct 的成员默认是私有的</li><li>类的成员默认是私有的</li><li>类的成员默认是公有的</li><ul></ul></ul></div>",
          answer: "<div>A C</div>",
          score: 4,
          difficulty_degree: "1",
          subject_id: 2,
          knowledge_point_id: 6
        },
        {
          question_id: 1000009,
          type_id: 2,
          content: "<div class=\"subject-des\">下列函数哪些是JavaScript的全局函数？<ul class=\"subject-des-list\"><li>encodeURI</li><li>parseFloat</li><li>setTimeout</li><li>eval</li><ul></ul></ul></div>",
          answer: "<div>A B D</div>",
          score: 4,
          difficulty_degree: "3",
          subject_id: 2,
          knowledge_point_id: 8
        },
        {
          question_id: 1000010,
          type_id: 2,
          content: "<div class=\"subject-des\">String str = new String(“abc”)，“abc”在内存中是怎么分配的？<ul class=\"subject-des-list\"><li>堆</li><li>栈</li><li>字符串常量区</li><li>寄存器</li><ul></ul></ul></div>",
          answer: "<div>A C</div>",
          score: 4,
          difficulty_degree: "3",
          subject_id: 3,
          knowledge_point_id: 13
        },
        {
          question_id: 1000011,
          type_id: 3,
          content: "<div class=\"subject-des\">N个顶点的连通图中边的条数至少为<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>个？</div>",
          answer: "<div>N-1</div>",
          score: 4,
          difficulty_degree: "1",
          subject_id: 3,
          knowledge_point_id: 18
        },
        {
          question_id: 1000012,
          type_id: 3,
          content: "<div class=\"subject-des\"><p><span>非严格模式下写出下面表达式结果</span></p><p><span> parseInt(“123a”)=<u>&nbsp;&nbsp;&nbsp;&nbsp;</u></span></p></div>",
          answer: "<div>123</div>",
          score: 4,
          difficulty_degree: "2",
          subject_id: 2,
          knowledge_point_id: 8
        },
        {
          question_id: 1000013,
          type_id: 3,
          content: "<div class=\"subject-des\">http,telnet,ftp的端口是<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>,<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>,<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>?(FTP写最常用的那一个端口就好)</div>",
          answer: "<div>80 23 21</div>",
          score: 4,
          difficulty_degree: "3",
          subject_id: 4,
          knowledge_point_id: 19
        },
        {
          question_id: 1000014,
          type_id: 3,
          content: "<div class=\"subject-des\">SQL中，基本表结构的修改用<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>关键字。",
          answer: "<div>ALTER</div>",
          score: 4,
          difficulty_degree: "2",
          subject_id: 4,
          knowledge_point_id: 21
        },
        {
          question_id: 1000015,
          type_id: 3,
          content: "<div class=\"subject-des\"><p style=\"margin-left: 0.0cm;text-indent: 0.0cm;\">  <span>基础测试的工作开展更多站在</span><u>&nbsp;&nbsp;&nbsp;&nbsp;</u><span>的角度上；系统测试站在</span><u>&nbsp;&nbsp;&nbsp;&nbsp;</u><span>的角度上。</span>  </p>",
          answer: "<div>测试人员 用户</div>",
          score: 4,
          difficulty_degree: "1",
          subject_id: 6,
          knowledge_point_id: 30
        },
        {
          question_id: 1000016,
          type_id: 4,
          content: "<div class=\"subject-des\">任意2n个整数，从其中选出n个整数，使得选出的n个整数和同剩下的n个整数之和的差最小。</div>",
          answer: "<div><div id=\"highlighter_941786\" class=\"syntaxhighlighter  java\"><div class=\"toolbar\" style=\"display:none;\"></div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"gutter\"><div class=\"line number1 index0 alt2\">1</div><div class=\"line number2 index1 alt1\">2</div><div class=\"line number3 index2 alt2\">3</div><div class=\"line number4 index3 alt1\">4</div><div class=\"line number5 index4 alt2\">5</div><div class=\"line number6 index5 alt1\">6</div><div class=\"line number7 index6 alt2\">7</div><div class=\"line number8 index7 alt1\">8</div><div class=\"line number9 index8 alt2\">9</div><div class=\"line number10 index9 alt1\">10</div><div class=\"line number11 index10 alt2\">11</div><div class=\"line number12 index11 alt1\">12</div><div class=\"line number13 index12 alt2\">13</div><div class=\"line number14 index13 alt1\">14</div><div class=\"line number15 index14 alt2\">15</div><div class=\"line number16 index15 alt1\">16</div><div class=\"line number17 index16 alt2\">17</div></td><td class=\"code\"><div class=\"container\"><div class=\"line number1 index0 alt2\"><code class=\"java keyword\">int</code>&nbsp; <code class=\"java plain\">solve() </code></div><div class=\"line number2 index1 alt1\"><code class=\"java plain\">{ </code></div><div class=\"line number3 index2 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">int</code>&nbsp; <code class=\"java plain\">i&nbsp;,&nbsp;j&nbsp;,&nbsp;s; </code></div><div class=\"line number4 index3 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">int</code>&nbsp; <code class=\"java plain\">dp[N+</code><code class=\"java value\">1</code><code class=\"java plain\">][SUM/</code><code class=\"java value\">2</code><code class=\"java plain\">+</code><code class=\"java value\">2</code><code class=\"java plain\">]; </code></div><div class=\"line number5 index4 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">memset(dp,</code><code class=\"java value\">0</code><code class=\"java plain\">,sizeof (dp)); </code></div><div class=\"line number6 index5 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">for</code> <code class=\"java plain\">(i&nbsp;=&nbsp;</code><code class=\"java value\">1</code>&nbsp;<code class=\"java plain\">;&nbsp;i&nbsp;&lt;=&nbsp;</code><code class=\"java value\">2</code><code class=\"java plain\">*N&nbsp;;&nbsp;++i) </code></div><div class=\"line number7 index6 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">{ </code></div><div class=\"line number8 index7 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">for</code> <code class=\"java plain\">(j&nbsp;=&nbsp;</code><code class=\"java value\">1</code>&nbsp;<code class=\"java plain\">;&nbsp;j&nbsp;&lt;=&nbsp;min(i,N)&nbsp;;&nbsp;++j) </code></div><div class=\"line number9 index8 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">{ </code></div><div class=\"line number10 index9 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">for</code> <code class=\"java plain\">(s&nbsp;=&nbsp;SUM/</code><code class=\"java value\">2</code><code class=\"java plain\">+</code><code class=\"java value\">1</code>&nbsp;<code class=\"java plain\">;&nbsp;s&nbsp;&gt;=&nbsp;arr[i]&nbsp;;&nbsp;--s) </code></div><div class=\"line number11 index10 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">{ </code></div><div class=\"line number12 index11 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">dp[j][s]&nbsp;=&nbsp;max(dp[j-</code><code class=\"java value\">1</code><code class=\"java plain\">][s-arr[i]]+arr[i]&nbsp;,&nbsp;dp[j][s]); </code></div><div class=\"line number13 index12 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">} </code></div><div class=\"line number14 index13 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">} </code></div><div class=\"line number15 index14 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">} </code></div><div class=\"line number16 index15 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">return</code>&nbsp; <code class=\"java plain\">dp[N][SUM/</code><code class=\"java value\">2</code><code class=\"java plain\">+</code><code class=\"java value\">1</code><code class=\"java plain\">]; </code></div><div class=\"line number17 index16 alt2\"><code class=\"java plain\">}</code></div></div></td></tr></tbody></table></div></div>",
          score: 10,
          difficulty_degree: "4",
          subject_id: 1,
          knowledge_point_id: 4
        },
        {
          question_id: 1000017,
          type_id: 4,
          content: "<div class=\"subject-des\">请列举7种以上常用的HTML标签，说明其语义。</div>",
          answer: "<div class=\"answer-brief nc-post-content\"><div>  1.div标签，是一个块元素，就像一个大盒子，可以放各式各样的东西，如：图片.... </div><div>  2.p标签，也是一个块元素，它通常是用来放一段话的.... </div><div>  3. h1,h2....h6标签，也是一个块元素，常用来放标题 </div><div>  4.span标签，是一个行内元素，常用来处理一段话中的某几个字符 </div><div>  5.img标签，用来加载图片的标签 </div><div>  6.table标签，用来创建表格的标签 </div><div>  7.br标签，用来换行的标签 </div><div>  8.hr标签，用来画线的标签 </div><div>  9.a一个点击跳转的超链接标签 </div><div>  10.ul一个用来做列表的标签 </div></div>",
          score: 10,
          difficulty_degree: "2",
          subject_id: 2,
          knowledge_point_id: 11
        },
        {
          question_id: 1000018,
          type_id: 4,
          content: "<div class=\"subject-des\"><div>  以下函数查找一个整数数组中第二大的数，请填空。 </div><div><div id=\"highlighter_259905\" class=\"syntaxhighlighter  java\"><div class=\"toolbar\" style=\"display:none;\"></div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"gutter\"><div class=\"line number1 index0 alt2\">1</div><div class=\"line number2 index1 alt1\">2</div><div class=\"line number3 index2 alt2\">3</div><div class=\"line number4 index3 alt1\">4</div><div class=\"line number5 index4 alt2\">5</div><div class=\"line number6 index5 alt1\">6</div><div class=\"line number7 index6 alt2\">7</div><div class=\"line number8 index7 alt1\">8</div><div class=\"line number9 index8 alt2\">9</div><div class=\"line number10 index9 alt1\">10</div><div class=\"line number11 index10 alt2\">11</div><div class=\"line number12 index11 alt1\">12</div><div class=\"line number13 index12 alt2\">13</div><div class=\"line number14 index13 alt1\">14</div><div class=\"line number15 index14 alt2\">15</div><div class=\"line number16 index15 alt1\">16</div><div class=\"line number17 index16 alt2\">17</div><div class=\"line number18 index17 alt1\">18</div><div class=\"line number19 index18 alt2\">19</div><div class=\"line number20 index19 alt1\">20</div><div class=\"line number21 index20 alt2\">21</div></td><td class=\"code\"><div class=\"container\"><div class=\"line number1 index0 alt2\"><code class=\"java plain\">#include &lt;stdio.h&gt;</code></div><div class=\"line number2 index1 alt1\"><code class=\"java keyword\">const</code> <code class=\"java keyword\">int</code> <code class=\"java plain\">MINNUMBER = -</code><code class=\"java value\">32767</code><code class=\"java plain\">;</code></div><div class=\"line number3 index2 alt2\"><code class=\"java keyword\">int</code> <code class=\"java plain\">find_set_max(</code><code class=\"java keyword\">int</code> <code class=\"java plain\">data[], </code><code class=\"java keyword\">int</code> <code class=\"java plain\">count)</code></div><div class=\"line number4 index3 alt1\"><code class=\"java plain\">{</code></div><div class=\"line number5 index4 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">int</code> <code class=\"java plain\">maxnumber = data[</code><code class=\"java value\">0</code><code class=\"java plain\">];</code></div><div class=\"line number6 index5 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">int</code> <code class=\"java plain\">sec_max = MINNUMBER;</code></div><div class=\"line number7 index6 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">for</code> <code class=\"java plain\">(</code><code class=\"java keyword\">int</code> <code class=\"java plain\">i = </code><code class=\"java value\">1</code><code class=\"java plain\">; i &lt; count; i ++ )</code></div><div class=\"line number8 index7 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">{</code></div><div class=\"line number9 index8 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">if</code> <code class=\"java plain\">(maxnumber &lt; data[i])</code></div><div class=\"line number10 index9 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">{&nbsp;&nbsp;</code></div><div class=\"line number11 index10 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">();</code></div><div class=\"line number12 index11 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">();</code></div><div class=\"line number13 index12 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number14 index13 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">else</code></div><div class=\"line number15 index14 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">{</code></div><div class=\"line number16 index15 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">if</code> <code class=\"java plain\">(data[i] &nbsp;&gt; sec_max)</code></div><div class=\"line number17 index16 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">()</code></div><div class=\"line number18 index17 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number19 index18 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number20 index19 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">return</code> <code class=\"java plain\">sec_max;</code></div><div class=\"line number21 index20 alt2\"><code class=\"java plain\">}</code></div></div></td></tr></tbody></table></div></div><br></div>",
          answer: "<div class=\"answer-brief nc-post-content\"><div>  sec_max = maxnumber;<br> maxnumber = data[i];<br> sec_max = data[i];<br></div></div>",
          score: 10,
          difficulty_degree: "2",
          subject_id: 3,
          knowledge_point_id: 12
        },
        {
          question_id: 1000019,
          type_id: 4,
          content: "<div class=\"subject-des\">使用字符串的正则判断是否全部由数字组成。</div>",
          answer: "<div><div id=\"highlighter_555855\" class=\"syntaxhighlighter  java\"><div class=\"toolbar\" style=\"display:none;\"></div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"gutter\"><div class=\"line number1 index0 alt2\">1</div><div class=\"line number2 index1 alt1\">2</div><div class=\"line number3 index2 alt2\">3</div><div class=\"line number4 index3 alt1\">4</div></td><td class=\"code\"><div class=\"container\"><div class=\"line number1 index0 alt2\"><code class=\"java plain\">function validNumber(val) {</code></div><div class=\"line number2 index1 alt1\"><code class=\"java spaces\">&nbsp;</code><code class=\"java plain\">var regex = /^[</code><code class=\"java value\">0</code><code class=\"java plain\">-</code><code class=\"java value\">9</code><code class=\"java plain\">]+$/;</code></div><div class=\"line number3 index2 alt2\"><code class=\"java spaces\">&nbsp;</code><code class=\"java keyword\">return</code> <code class=\"java plain\">regex.test(val);</code></div><div class=\"line number4 index3 alt1\"><code class=\"java plain\">}</code></div></div></td></tr></tbody></table></div></div>",
          score: 10,
          difficulty_degree: "3",
          subject_id: 4,
          knowledge_point_id: 20
        },
        {
          question_id: 1000020,
          type_id: 4,
          content: "<div class=\"subject-des\">假设我们有三个箱子，分别是红色，蓝色和绿色。在红色箱子中有3个苹果，4个橘子，3个柠檬。在蓝色箱子中有1个苹果，1个橘子和0个柠檬，在绿色箱子中有3个苹果，3 个橘子和4 个柠檬。如果我们选择箱子的概率是红色0.2，蓝色0.2，绿色0.6，并且选择一个箱子后，以均匀的概率随机移除一个水果。那么移除苹果的概率是多少？请给出步骤。<br>如果我们发现移除的水果是橘子，那么这个橘子来自绿色箱子的概率是多少？请给出步骤。<br><br></div>",
          answer: "<div class=\"answer-brief nc-post-content\"><div>事件（选择箱子和在选择了的箱子中移除水果）的概率是独立的，所以：</div><div>1.移除苹果的概率 P = P(选择红箱子 &amp; 移除苹果)+<span>&nbsp;P(选择蓝箱子 &amp; 移除苹果)+</span> <span>&nbsp;P(选择绿箱子 &amp; 移除苹果)</span> =&nbsp;<span>P(选择红箱子)*P(红箱子移除苹果) +<span>P(选择蓝箱子)*P(蓝箱子移除苹果)+<span>P(选择绿箱子)*P(绿箱子移除苹果)</span> </span> = 0.2*3/(3+4+3)+0.2*1/(1+1+0)+0.6*3/(3+3+4)=0.34</span> </div><div><span> <br></span> </div><div><span>2.来自绿色箱子的概率 P = P(橘子来自绿色箱子 | 移除的是橘子) = P(移除的绿箱子里面的橘子)/P(移除的是橘子)&nbsp;</span> </div><div><span> <span>&nbsp;P(移除的绿箱子里面的橘子) = P(选中绿色箱子)*P(在绿箱子里移除橘子) = 0.6*3/(3+3+4) = 0.18</span> </span> </div><div><span> <span>P(移除的是橘子) &nbsp;=&nbsp;</span> <span>P(选中红色箱子)*P(在红箱子里移除橘子) +<span>P(选中蓝色箱子)*P(在蓝箱子里移除橘子) +<span>P(选中绿色箱子)*P(在绿箱子里移除橘子)&nbsp;</span> </span> </span> = 0.2*4/(3+4+3) + 0.2*1/(1+1+0)+0.6*3/(3+3+4) = 0.08+0.1+0.18 = 0.36<br></span> </div><div><span>故 P = 0.18/0.36 = 0.5</span> </div></div>",
          score: 10,
          difficulty_degree: "3",
          subject_id: 5,
          knowledge_point_id: 25
        },
        {
          question_id: 1000021,
          type_id: 4,
          content: "<div class=\\\"subject-des\\\">有1分,2分,5分,10分四种硬币，每种硬币数量无限，给定n分钱，求有多少种组合可以组合成n分钱?</div>",
          answer: "<div class=\\\"answer-brief nc-post-content\\\">①，四层循环 <br> ②，使用回溯法在空间中搜索<br> 代码为思路： 定义控制台应用程序的入口点。<br><div><div id=\\\"highlighter_205807\\\" class=\\\"syntaxhighlighter  cpp\\\"><div class=\\\"toolbar\\\" style=\\\"display:none;\\\"></div><table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\"><tbody><tr><td class=\\\"gutter\\\"><div class=\\\"line number1 index0 alt2\\\">1</div><div class=\\\"line number2 index1 alt1\\\">2</div><div class=\\\"line number3 index2 alt2\\\">3</div><div class=\\\"line number4 index3 alt1\\\">4</div><div class=\\\"line number5 index4 alt2\\\">5</div><div class=\\\"line number6 index5 alt1\\\">6</div><div class=\\\"line number7 index6 alt2\\\">7</div><div class=\\\"line number8 index7 alt1\\\">8</div><div class=\\\"line number9 index8 alt2\\\">9</div><div class=\\\"line number10 index9 alt1\\\">10</div><div class=\\\"line number11 index10 alt2\\\">11</div><div class=\\\"line number12 index11 alt1\\\">12</div><div class=\\\"line number13 index12 alt2\\\">13</div><div class=\\\"line number14 index13 alt1\\\">14</div><div class=\\\"line number15 index14 alt2\\\">15</div><div class=\\\"line number16 index15 alt1\\\">16</div><div class=\\\"line number17 index16 alt2\\\">17</div><div class=\\\"line number18 index17 alt1\\\">18</div><div class=\\\"line number19 index18 alt2\\\">19</div><div class=\\\"line number20 index19 alt1\\\">20</div><div class=\\\"line number21 index20 alt2\\\">21</div><div class=\\\"line number22 index21 alt1\\\">22</div><div class=\\\"line number23 index22 alt2\\\">23</div><div class=\\\"line number24 index23 alt1\\\">24</div><div class=\\\"line number25 index24 alt2\\\">25</div><div class=\\\"line number26 index25 alt1\\\">26</div><div class=\\\"line number27 index26 alt2\\\">27</div><div class=\\\"line number28 index27 alt1\\\">28</div><div class=\\\"line number29 index28 alt2\\\">29</div><div class=\\\"line number30 index29 alt1\\\">30</div><div class=\\\"line number31 index30 alt2\\\">31</div><div class=\\\"line number32 index31 alt1\\\">32</div><div class=\\\"line number33 index32 alt2\\\">33</div><div class=\\\"line number34 index33 alt1\\\">34</div><div class=\\\"line number35 index34 alt2\\\">35</div><div class=\\\"line number36 index35 alt1\\\">36</div><div class=\\\"line number37 index36 alt2\\\">37</div><div class=\\\"line number38 index37 alt1\\\">38</div><div class=\\\"line number39 index38 alt2\\\">39</div><div class=\\\"line number40 index39 alt1\\\">40</div><div class=\\\"line number41 index40 alt2\\\">41</div><div class=\\\"line number42 index41 alt1\\\">42</div><div class=\\\"line number43 index42 alt2\\\">43</div></td><td class=\\\"code\\\"><div class=\\\"container\\\"><div class=\\\"line number1 index0 alt2\\\"><code class=\\\"cpp preprocessor\\\">#include \\\"stdafx.h\\\"</code></div><div class=\\\"line number2 index1 alt1\\\">&nbsp;</div><div class=\\\"line number3 index2 alt2\\\"><code class=\\\"cpp keyword bold\\\">using</code> <code class=\\\"cpp keyword bold\\\">namespace</code> <code class=\\\"cpp plain\\\">std;</code></div><div class=\\\"line number4 index3 alt1\\\"><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">count = 0;</code></div><div class=\\\"line number5 index4 alt2\\\"><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">Target = 0;</code></div><div class=\\\"line number6 index5 alt1\\\"><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">coin[4] = {1, 2, 5, 10};</code></div><div class=\\\"line number7 index6 alt2\\\"><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">total = 0;</code></div><div class=\\\"line number8 index7 alt1\\\"><code class=\\\"cpp plain\\\">vector solution;</code></div><div class=\\\"line number9 index8 alt2\\\"><code class=\\\"cpp keyword bold\\\">void</code> <code class=\\\"cpp plain\\\">dfs(</code><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">index)</code></div><div class=\\\"line number10 index9 alt1\\\"><code class=\\\"cpp plain\\\">{</code></div><div class=\\\"line number11 index10 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">if</code> <code class=\\\"cpp plain\\\">( total == Target )</code></div><div class=\\\"line number12 index11 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">{</code></div><div class=\\\"line number13 index12 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">count++;</code></div><div class=\\\"line number14 index13 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">cout &lt;&lt; count &lt;&lt; </code><code class=\\\"cpp string\\\">\\\":\\\"</code> <code class=\\\"cpp plain\\\">;</code></div><div class=\\\"line number15 index14 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">for</code> <code class=\\\"cpp plain\\\">( </code><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">i = 0; i &lt; (</code><code class=\\\"cpp color1 bold\\\">int</code><code class=\\\"cpp plain\\\">)solution.size(); i++)</code></div><div class=\\\"line number16 index15 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">{</code></div><div class=\\\"line number17 index16 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">cout &lt;&lt; solution[i] &lt;&lt; </code><code class=\\\"cpp string\\\">\\\" \\\"</code><code class=\\\"cpp plain\\\">;</code></div><div class=\\\"line number18 index17 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">}</code></div><div class=\\\"line number19 index18 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">cout &lt;&lt; endl;</code></div><div class=\\\"line number20 index19 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">return</code><code class=\\\"cpp plain\\\">;</code></div><div class=\\\"line number21 index20 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">}</code></div><div class=\\\"line number22 index21 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">if</code> <code class=\\\"cpp plain\\\">( total &gt; Target )</code></div><div class=\\\"line number23 index22 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">return</code><code class=\\\"cpp plain\\\">;</code></div><div class=\\\"line number24 index23 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">for</code> <code class=\\\"cpp plain\\\">( </code><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">i = index; i &lt; 4; i++)</code></div><div class=\\\"line number25 index24 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">{</code></div><div class=\\\"line number26 index25 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">total += coin[i];</code></div><div class=\\\"line number27 index26 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">solution.push_back( coin[i] );</code></div><div class=\\\"line number28 index27 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">dfs(i);</code></div><div class=\\\"line number29 index28 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">solution.pop_back();</code></div><div class=\\\"line number30 index29 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">total -= coin[i];</code></div><div class=\\\"line number31 index30 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">}</code></div><div class=\\\"line number32 index31 alt1\\\"><code class=\\\"cpp plain\\\">}</code></div><div class=\\\"line number33 index32 alt2\\\"><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">_tmain(</code><code class=\\\"cpp color1 bold\\\">int</code> <code class=\\\"cpp plain\\\">argc, _TCHAR *argv[])</code></div><div class=\\\"line number34 index33 alt1\\\"><code class=\\\"cpp plain\\\">{</code></div><div class=\\\"line number35 index34 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">while</code> <code class=\\\"cpp plain\\\">(1)</code></div><div class=\\\"line number36 index35 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">{</code></div><div class=\\\"line number37 index36 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">count = 0;</code></div><div class=\\\"line number38 index37 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">cin &gt;&gt; Target;</code></div><div class=\\\"line number39 index38 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">dfs(0);</code></div><div class=\\\"line number40 index39 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">cout &lt;&lt; count &lt;&lt; endl;</code></div><div class=\\\"line number41 index40 alt2\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp plain\\\">}</code></div><div class=\\\"line number42 index41 alt1\\\"><code class=\\\"cpp spaces\\\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\\\"cpp keyword bold\\\">return</code> <code class=\\\"cpp plain\\\">0;</code></div><div class=\\\"line number43 index42 alt2\\\"><code class=\\\"cpp plain\\\">}</code></div></div></td></tr></tbody></table></div></div></div>",
          score: 10,
          difficulty_degree: "4",
          subject_id: 3,
          knowledge_point_id: 18
        },
      ]
    });
  },

  getQuestionByTestPaperId: (test_paper_id) => {
    return Promise.resolve({
      isSuccess: true,
      message: "",
      data: 
        [
          {
            question_id: 1000001,
            type_id: 1,
            content: "<div class=\"subject-des\"><p><span>下面关于散列查找的说法正确的是</span><span>（ </span><span>）</span><span>。</span></p><ul class=\"subject-des-list\"><li>散列函数构造得越复杂越好，因为这样随机性好，冲突小</li><li>除留余数法是所有散列函数中最好的</li><li>不存在特别好与坏的散列函数，要视情况而定</li><li>若需在散列表中删去一个元素，不管用何种方法解决冲突都只要简单地将该元素删去即可</li><ul></ul></ul></div>",
            answer: "<div>C</div>",
            score: 2,
            difficulty_degree: "1",
            subject_id: 1,
            knowledge_point_id: 1
          },
          {
            question_id: 1000002,
            type_id: 1,
            content: "<div class=\"subject-des\">下列哪个查找方法的平均查找长度与查找表中数据元素个数无关？<ul class=\"subject-des-list\"><li>哈希（散列）查找</li><li>顺序查找</li><li>折半查找</li><li>B+树查找</li><ul></ul></ul></div>",
            answer: "<div>A</div>",
            score: 2,
            difficulty_degree: "2",
            subject_id: 1,
            knowledge_point_id: 1
          },
          {
            question_id: 1000003,
            type_id: 1,
            content: "<div class=\"subject-des\"><span>若一组记录的排序码为（46,&nbsp;79,&nbsp;56,&nbsp;38,&nbsp;40,&nbsp;84），则利用快速排序，以第一个记录为基准得到的一次划分结果是 （） </span><ul class=\"subject-des-list\"><li>38, 40, 46, 56, 79, 84</li><li>40，38, 46 ,79, 56, 84</li><li>40, 38，46, 56, 79, 84</li><li>40, 38，46，84, 56, 79</li><ul></ul></ul></div>",
            answer: "<div>C</div>",
            score: 2,
            difficulty_degree: "3",
            subject_id: 1,
            knowledge_point_id: 2
          },
          {
            question_id: 1000004,
            type_id: 1,
            content: "<div class=\"subject-des\">下面有关java object默认的基本方法，说法错误的是？<ul class=\"subject-des-list\"><li>equals(Object obj) 指示某个其他对象是否与此对象“相等”</li><li>copy() 创建并返回此对象的一个副本</li><li>wait() 导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法</li><li>toString() 返回该对象的字符串表示</li><ul></ul></ul></div>",
            answer: "<div>B</div>",
            score: 2,
            difficulty_degree: "4",
            subject_id: 2,
            knowledge_point_id: 7
          },
          {
            question_id: 1000005,
            type_id: 1,
            content: "<div class=\"subject-des\">下面选项中合法的字符常量是？<ul class=\"subject-des-list\"><li>\"X\"</li><li>'X'</li><li>'abc'</li><li>'\\'</li><ul></ul></ul></div>",
            answer: "<div>B</div>",
            score: 2,
            difficulty_degree: "2",
            subject_id: 3,
            knowledge_point_id: 13
          },
          {
            question_id: 1000006,
            type_id: 2,
            content: "<div class=\"subject-des\">下面使用贪心算法的是？<ul class=\"subject-des-list\"><li>单元最短路径 Dijkstra 算法</li><li>最小生成树 Prim 算法</li><li>最小生成树 Kruskal 算法</li><li>计算每对顶点最短路径的 Floyd-Warshall 算法</li><ul></ul></ul></div>",
            answer: "<div>A B C</div>",
            score: 4,
            difficulty_degree: "3",
            subject_id: 1,
            knowledge_point_id: 4
          },
          {
            question_id: 1000007,
            type_id: 2,
            content: "<div class=\"subject-des\">以下哪些算法可用于遍历网络图？<ul class=\"subject-des-list\"><li>广度优先搜索</li><li>深度优先搜索</li><li>线性规划策略</li><li>决策树</li><ul></ul></ul></div>",
            answer: "<div>A B</div>",
            score: 4,
            difficulty_degree: "2",
            subject_id: 1,
            knowledge_point_id: 5
          },
          {
            question_id: 1000008,
            type_id: 2,
            content: "<div class=\"subject-des\">struct 和 class 的区别?<ul class=\"subject-des-list\"><li>struct 的成员默认是公有的</li><li>struct 的成员默认是私有的</li><li>类的成员默认是私有的</li><li>类的成员默认是公有的</li><ul></ul></ul></div>",
            answer: "<div>A C</div>",
            score: 4,
            difficulty_degree: "1",
            subject_id: 2,
            knowledge_point_id: 6
          },
          {
            question_id: 1000009,
            type_id: 2,
            content: "<div class=\"subject-des\">下列函数哪些是JavaScript的全局函数？<ul class=\"subject-des-list\"><li>encodeURI</li><li>parseFloat</li><li>setTimeout</li><li>eval</li><ul></ul></ul></div>",
            answer: "<div>A B D</div>",
            score: 4,
            difficulty_degree: "3",
            subject_id: 2,
            knowledge_point_id: 8
          },
          {
            question_id: 1000010,
            type_id: 2,
            content: "<div class=\"subject-des\">String str = new String(“abc”)，“abc”在内存中是怎么分配的？<ul class=\"subject-des-list\"><li>堆</li><li>栈</li><li>字符串常量区</li><li>寄存器</li><ul></ul></ul></div>",
            answer: "<div>A C</div>",
            score: 4,
            difficulty_degree: "3",
            subject_id: 3,
            knowledge_point_id: 13
          },
          {
            question_id: 1000011,
            type_id: 3,
            content: "<div class=\"subject-des\">N个顶点的连通图中边的条数至少为<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>个？</div>",
            answer: "<div>N-1</div>",
            score: 4,
            difficulty_degree: "1",
            subject_id: 3,
            knowledge_point_id: 18
          },
          {
            question_id: 1000012,
            type_id: 3,
            content: "<div class=\"subject-des\"><p><span>非严格模式下写出下面表达式结果</span></p><p><span> parseInt(“123a”)=<u>&nbsp;&nbsp;&nbsp;&nbsp;</u></span></p></div>",
            answer: "<div>123</div>",
            score: 4,
            difficulty_degree: "2",
            subject_id: 2,
            knowledge_point_id: 8
          },
          {
            question_id: 1000013,
            type_id: 3,
            content: "<div class=\"subject-des\">http,telnet,ftp的端口是<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>,<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>,<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>?(FTP写最常用的那一个端口就好)</div>",
            answer: "<div>80 23 21</div>",
            score: 4,
            difficulty_degree: "3",
            subject_id: 4,
            knowledge_point_id: 19
          },
          {
            question_id: 1000014,
            type_id: 3,
            content: "<div class=\"subject-des\">SQL中，基本表结构的修改用<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>关键字。",
            answer: "<div>ALTER</div>",
            score: 4,
            difficulty_degree: "2",
            subject_id: 4,
            knowledge_point_id: 21
          },
          {
            question_id: 1000015,
            type_id: 3,
            content: "<div class=\"subject-des\"><p style=\"margin-left: 0.0cm;text-indent: 0.0cm;\">  <span>基础测试的工作开展更多站在</span><u>&nbsp;&nbsp;&nbsp;&nbsp;</u><span>的角度上；系统测试站在</span><u>&nbsp;&nbsp;&nbsp;&nbsp;</u><span>的角度上。</span>  </p>",
            answer: "<div>测试人员 用户</div>",
            score: 4,
            difficulty_degree: "1",
            subject_id: 6,
            knowledge_point_id: 30
          },
          {
            question_id: 1000016,
            type_id: 4,
            content: "<div class=\"subject-des\">任意2n个整数，从其中选出n个整数，使得选出的n个整数和同剩下的n个整数之和的差最小。</div>",
            answer: "<div><div id=\"highlighter_941786\" class=\"syntaxhighlighter  java\"><div class=\"toolbar\" style=\"display:none;\"></div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"gutter\"><div class=\"line number1 index0 alt2\">1</div><div class=\"line number2 index1 alt1\">2</div><div class=\"line number3 index2 alt2\">3</div><div class=\"line number4 index3 alt1\">4</div><div class=\"line number5 index4 alt2\">5</div><div class=\"line number6 index5 alt1\">6</div><div class=\"line number7 index6 alt2\">7</div><div class=\"line number8 index7 alt1\">8</div><div class=\"line number9 index8 alt2\">9</div><div class=\"line number10 index9 alt1\">10</div><div class=\"line number11 index10 alt2\">11</div><div class=\"line number12 index11 alt1\">12</div><div class=\"line number13 index12 alt2\">13</div><div class=\"line number14 index13 alt1\">14</div><div class=\"line number15 index14 alt2\">15</div><div class=\"line number16 index15 alt1\">16</div><div class=\"line number17 index16 alt2\">17</div></td><td class=\"code\"><div class=\"container\"><div class=\"line number1 index0 alt2\"><code class=\"java keyword\">int</code>&nbsp; <code class=\"java plain\">solve() </code></div><div class=\"line number2 index1 alt1\"><code class=\"java plain\">{ </code></div><div class=\"line number3 index2 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">int</code>&nbsp; <code class=\"java plain\">i&nbsp;,&nbsp;j&nbsp;,&nbsp;s; </code></div><div class=\"line number4 index3 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">int</code>&nbsp; <code class=\"java plain\">dp[N+</code><code class=\"java value\">1</code><code class=\"java plain\">][SUM/</code><code class=\"java value\">2</code><code class=\"java plain\">+</code><code class=\"java value\">2</code><code class=\"java plain\">]; </code></div><div class=\"line number5 index4 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">memset(dp,</code><code class=\"java value\">0</code><code class=\"java plain\">,sizeof (dp)); </code></div><div class=\"line number6 index5 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">for</code> <code class=\"java plain\">(i&nbsp;=&nbsp;</code><code class=\"java value\">1</code>&nbsp;<code class=\"java plain\">;&nbsp;i&nbsp;&lt;=&nbsp;</code><code class=\"java value\">2</code><code class=\"java plain\">*N&nbsp;;&nbsp;++i) </code></div><div class=\"line number7 index6 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">{ </code></div><div class=\"line number8 index7 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">for</code> <code class=\"java plain\">(j&nbsp;=&nbsp;</code><code class=\"java value\">1</code>&nbsp;<code class=\"java plain\">;&nbsp;j&nbsp;&lt;=&nbsp;min(i,N)&nbsp;;&nbsp;++j) </code></div><div class=\"line number9 index8 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">{ </code></div><div class=\"line number10 index9 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">for</code> <code class=\"java plain\">(s&nbsp;=&nbsp;SUM/</code><code class=\"java value\">2</code><code class=\"java plain\">+</code><code class=\"java value\">1</code>&nbsp;<code class=\"java plain\">;&nbsp;s&nbsp;&gt;=&nbsp;arr[i]&nbsp;;&nbsp;--s) </code></div><div class=\"line number11 index10 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">{ </code></div><div class=\"line number12 index11 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">dp[j][s]&nbsp;=&nbsp;max(dp[j-</code><code class=\"java value\">1</code><code class=\"java plain\">][s-arr[i]]+arr[i]&nbsp;,&nbsp;dp[j][s]); </code></div><div class=\"line number13 index12 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">} </code></div><div class=\"line number14 index13 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">} </code></div><div class=\"line number15 index14 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java plain\">} </code></div><div class=\"line number16 index15 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp;&nbsp;</code><code class=\"java keyword\">return</code>&nbsp; <code class=\"java plain\">dp[N][SUM/</code><code class=\"java value\">2</code><code class=\"java plain\">+</code><code class=\"java value\">1</code><code class=\"java plain\">]; </code></div><div class=\"line number17 index16 alt2\"><code class=\"java plain\">}</code></div></div></td></tr></tbody></table></div></div>",
            score: 10,
            difficulty_degree: "4",
            subject_id: 1,
            knowledge_point_id: 4
          },
          {
            question_id: 1000017,
            type_id: 4,
            content: "<div class=\"subject-des\">请列举7种以上常用的HTML标签，说明其语义。</div>",
            answer: "<div class=\"answer-brief nc-post-content\"><div>  1.div标签，是一个块元素，就像一个大盒子，可以放各式各样的东西，如：图片.... </div><div>  2.p标签，也是一个块元素，它通常是用来放一段话的.... </div><div>  3. h1,h2....h6标签，也是一个块元素，常用来放标题 </div><div>  4.span标签，是一个行内元素，常用来处理一段话中的某几个字符 </div><div>  5.img标签，用来加载图片的标签 </div><div>  6.table标签，用来创建表格的标签 </div><div>  7.br标签，用来换行的标签 </div><div>  8.hr标签，用来画线的标签 </div><div>  9.a一个点击跳转的超链接标签 </div><div>  10.ul一个用来做列表的标签 </div></div>",
            score: 10,
            difficulty_degree: "2",
            subject_id: 2,
            knowledge_point_id: 11
          },
          {
            question_id: 1000018,
            type_id: 4,
            content: "<div class=\"subject-des\"><div>  以下函数查找一个整数数组中第二大的数，请填空。 </div><div><div id=\"highlighter_259905\" class=\"syntaxhighlighter  java\"><div class=\"toolbar\" style=\"display:none;\"></div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"gutter\"><div class=\"line number1 index0 alt2\">1</div><div class=\"line number2 index1 alt1\">2</div><div class=\"line number3 index2 alt2\">3</div><div class=\"line number4 index3 alt1\">4</div><div class=\"line number5 index4 alt2\">5</div><div class=\"line number6 index5 alt1\">6</div><div class=\"line number7 index6 alt2\">7</div><div class=\"line number8 index7 alt1\">8</div><div class=\"line number9 index8 alt2\">9</div><div class=\"line number10 index9 alt1\">10</div><div class=\"line number11 index10 alt2\">11</div><div class=\"line number12 index11 alt1\">12</div><div class=\"line number13 index12 alt2\">13</div><div class=\"line number14 index13 alt1\">14</div><div class=\"line number15 index14 alt2\">15</div><div class=\"line number16 index15 alt1\">16</div><div class=\"line number17 index16 alt2\">17</div><div class=\"line number18 index17 alt1\">18</div><div class=\"line number19 index18 alt2\">19</div><div class=\"line number20 index19 alt1\">20</div><div class=\"line number21 index20 alt2\">21</div></td><td class=\"code\"><div class=\"container\"><div class=\"line number1 index0 alt2\"><code class=\"java plain\">#include &lt;stdio.h&gt;</code></div><div class=\"line number2 index1 alt1\"><code class=\"java keyword\">const</code> <code class=\"java keyword\">int</code> <code class=\"java plain\">MINNUMBER = -</code><code class=\"java value\">32767</code><code class=\"java plain\">;</code></div><div class=\"line number3 index2 alt2\"><code class=\"java keyword\">int</code> <code class=\"java plain\">find_set_max(</code><code class=\"java keyword\">int</code> <code class=\"java plain\">data[], </code><code class=\"java keyword\">int</code> <code class=\"java plain\">count)</code></div><div class=\"line number4 index3 alt1\"><code class=\"java plain\">{</code></div><div class=\"line number5 index4 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">int</code> <code class=\"java plain\">maxnumber = data[</code><code class=\"java value\">0</code><code class=\"java plain\">];</code></div><div class=\"line number6 index5 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">int</code> <code class=\"java plain\">sec_max = MINNUMBER;</code></div><div class=\"line number7 index6 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">for</code> <code class=\"java plain\">(</code><code class=\"java keyword\">int</code> <code class=\"java plain\">i = </code><code class=\"java value\">1</code><code class=\"java plain\">; i &lt; count; i ++ )</code></div><div class=\"line number8 index7 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">{</code></div><div class=\"line number9 index8 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">if</code> <code class=\"java plain\">(maxnumber &lt; data[i])</code></div><div class=\"line number10 index9 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">{&nbsp;&nbsp;</code></div><div class=\"line number11 index10 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">();</code></div><div class=\"line number12 index11 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">();</code></div><div class=\"line number13 index12 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number14 index13 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">else</code></div><div class=\"line number15 index14 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">{</code></div><div class=\"line number16 index15 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java keyword\">if</code> <code class=\"java plain\">(data[i] &nbsp;&gt; sec_max)</code></div><div class=\"line number17 index16 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">()</code></div><div class=\"line number18 index17 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number19 index18 alt2\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java plain\">}</code></div><div class=\"line number20 index19 alt1\"><code class=\"java spaces\">&nbsp;&nbsp;&nbsp; </code><code class=\"java keyword\">return</code> <code class=\"java plain\">sec_max;</code></div><div class=\"line number21 index20 alt2\"><code class=\"java plain\">}</code></div></div></td></tr></tbody></table></div></div><br></div>",
            answer: "<div class=\"answer-brief nc-post-content\"><div>  sec_max = maxnumber;<br> maxnumber = data[i];<br> sec_max = data[i];<br></div></div>",
            score: 10,
            difficulty_degree: "2",
            subject_id: 3,
            knowledge_point_id: 12
          },
          {
            question_id: 1000019,
            type_id: 4,
            content: "<div class=\"subject-des\">使用字符串的正则判断是否全部由数字组成。</div>",
            answer: "<div><div id=\"highlighter_555855\" class=\"syntaxhighlighter  java\"><div class=\"toolbar\" style=\"display:none;\"></div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td class=\"gutter\"><div class=\"line number1 index0 alt2\">1</div><div class=\"line number2 index1 alt1\">2</div><div class=\"line number3 index2 alt2\">3</div><div class=\"line number4 index3 alt1\">4</div></td><td class=\"code\"><div class=\"container\"><div class=\"line number1 index0 alt2\"><code class=\"java plain\">function validNumber(val) {</code></div><div class=\"line number2 index1 alt1\"><code class=\"java spaces\">&nbsp;</code><code class=\"java plain\">var regex = /^[</code><code class=\"java value\">0</code><code class=\"java plain\">-</code><code class=\"java value\">9</code><code class=\"java plain\">]+$/;</code></div><div class=\"line number3 index2 alt2\"><code class=\"java spaces\">&nbsp;</code><code class=\"java keyword\">return</code> <code class=\"java plain\">regex.test(val);</code></div><div class=\"line number4 index3 alt1\"><code class=\"java plain\">}</code></div></div></td></tr></tbody></table></div></div>",
            score: 10,
            difficulty_degree: "3",
            subject_id: 4,
            knowledge_point_id: 20
          },
          {
            question_id: 1000020,
            type_id: 4,
            content: "<div class=\"subject-des\">假设我们有三个箱子，分别是红色，蓝色和绿色。在红色箱子中有3个苹果，4个橘子，3个柠檬。在蓝色箱子中有1个苹果，1个橘子和0个柠檬，在绿色箱子中有3个苹果，3 个橘子和4 个柠檬。如果我们选择箱子的概率是红色0.2，蓝色0.2，绿色0.6，并且选择一个箱子后，以均匀的概率随机移除一个水果。那么移除苹果的概率是多少？请给出步骤。<br>如果我们发现移除的水果是橘子，那么这个橘子来自绿色箱子的概率是多少？请给出步骤。<br><br></div>",
            answer: "<div class=\"answer-brief nc-post-content\"><div>事件（选择箱子和在选择了的箱子中移除水果）的概率是独立的，所以：</div><div>1.移除苹果的概率 P = P(选择红箱子 &amp; 移除苹果)+<span>&nbsp;P(选择蓝箱子 &amp; 移除苹果)+</span> <span>&nbsp;P(选择绿箱子 &amp; 移除苹果)</span> =&nbsp;<span>P(选择红箱子)*P(红箱子移除苹果) +<span>P(选择蓝箱子)*P(蓝箱子移除苹果)+<span>P(选择绿箱子)*P(绿箱子移除苹果)</span> </span> = 0.2*3/(3+4+3)+0.2*1/(1+1+0)+0.6*3/(3+3+4)=0.34</span> </div><div><span> <br></span> </div><div><span>2.来自绿色箱子的概率 P = P(橘子来自绿色箱子 | 移除的是橘子) = P(移除的绿箱子里面的橘子)/P(移除的是橘子)&nbsp;</span> </div><div><span> <span>&nbsp;P(移除的绿箱子里面的橘子) = P(选中绿色箱子)*P(在绿箱子里移除橘子) = 0.6*3/(3+3+4) = 0.18</span> </span> </div><div><span> <span>P(移除的是橘子) &nbsp;=&nbsp;</span> <span>P(选中红色箱子)*P(在红箱子里移除橘子) +<span>P(选中蓝色箱子)*P(在蓝箱子里移除橘子) +<span>P(选中绿色箱子)*P(在绿箱子里移除橘子)&nbsp;</span> </span> </span> = 0.2*4/(3+4+3) + 0.2*1/(1+1+0)+0.6*3/(3+3+4) = 0.08+0.1+0.18 = 0.36<br></span> </div><div><span>故 P = 0.18/0.36 = 0.5</span> </div></div>",
            score: 10,
            difficulty_degree: "3",
            subject_id: 5,
            knowledge_point_id: 25
          },
        ]
    });
  },
}