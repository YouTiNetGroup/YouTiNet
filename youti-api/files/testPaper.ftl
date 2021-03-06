<#setting classic_compatible=true>
<!DOCTYPE html [<!ENTITY nbsp " ">]>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>试卷导出</title>
    <style type="text/css">
	@page {
	  size:210mm 297mm;
	}

	.subject-des li {
		list-style-type: upper-alpha;
		list-style-position: inside;
		margin: 10px 0;
		word-break: break-all;
		word-wrap: break-word;
	}
    </style>
	 <style type="text/css">
    html,body,div,span,p,code,ul,li {
      margin: 0;
      padding: 0;
      border: 0;
    }
    body {
      width: 680px;
      margin: auto;
    }
    .test_paper_container {
      font-size: 16px;
      padding-top: 24px; 
    }
    .test_paper_container .head {
      width: 100%;
    }
    .test_paper_container .head .title {
      text-align: center;
      font-size: 24px;
      font-weight: bold;
    }
    .test_paper_container .head .detail {
      width: 89%;
      margin: 16px auto;
    }
    .head .detail .common_deatil {
      width: 100%;
      margin: auto;
    }
    .head .detail .common_deatil span {
      margin-right: 48px;
      display: inline-block;
    }
    .common_deatil .school_year {
      text-align: left !important;
    }
    .common_deatil .total_score {
      margin-right: 0 !important;
      text-align: right !important;
    }
    .head .detail .student_detail {
      margin-top: 12px;
      width: 100%;
    }
    .student_detail .class {
      margin-right: 50px;
      display: inline-block;
      text-align: left !important;
    }
    .student_detail .student_number {
      margin-right: 50px;
      display: inline-block;
    }
    .student_detail .student_name {
      display: inline-block;
      margin-right: 0 !important;
      text-align: right !important;
    }
    .test_paper_container .body {
      margin: 8px 30px;
    }
    .big_question_container {
      width: 100%;
    }
    .big_question_type {
      margin: 8px 8px 0 8px;
      font-size: 18px;
      font-weight: bold;
    }
    .small_questions_container {
      margin: 8px 0;
      width: 100%;
    }
    .question_container {
      margin: 8px;
      font-size: 16px;
      line-height: 20px;
    }
    .question_detail {
      display: inline-block;
      vertical-align: top;
    }
    .question_detail .no {
      display: inline-block;
      vertical-align: top;
    }
    .question_detail .question {
      display: inline-block;
      max-width: 500px;
      overflow: hidden;
      word-wrap: break-word;
      word-break: break-all;
    }
    .score {
      display: inline-block;
    }
  </style>
</head>
<body style = "font-family: SimSun;">

  <div class="test_paper_container">
    <div class="head">
      <div class="title">${title}</div>
      <div class="detail">
        <div class="common_deatil">
          <span class="school_year">${school_year}</span>
          <span class="semester">${semester}</span>
          <span class="subject_name">${subject}</span>
          <span class="total_score">${total_score}</span>
        </div>
        <div class="student_detail">
          <span class="class">班级：<span>______________</span></span>
          <span class="student_number">学号：<span>______________</span></span>
          <span class="student_name">姓名：<span>______________</span></span>
        </div>
      </div>
    </div>
    <div class="body">
      <div class="big_question_container">
	  
	    <!--  1  -->
        <div class="big_question_type">${question_type_1}</div>
		
        <div class="small_questions_container">
		<!--  1.1  -->
          <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_1}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_1}</div>
              </div>
            </div>
            <div class="score">${question_score_1_1}</div>
          </div>
		  <!--  1.2  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_2}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_2}</div>
              </div>
            </div>
            <div class="score">${question_score_1_2}</div>
          </div>
		  <!--  1.3  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_3}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_3}</div>
              </div>
            </div>
            <div class="score">${question_score_1_3}</div>
          </div>
		  <!--  1.4  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_4}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_4}</div>
              </div>
            </div>
            <div class="score">${question_score_1_4}</div>
          </div>
		  <!--  1.5  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_5}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_5}</div>
              </div>
            </div>
            <div class="score">${question_score_1_5}</div>
          </div>
		  <!--  1.6  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_6}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_6}</div>
              </div>
            </div>
            <div class="score">${question_score_1_6}</div>
          </div>
		  <!--  1.7  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_7}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_7}</div>
              </div>
            </div>
            <div class="score">${question_score_1_7}</div>
          </div>
		  <!--  1.8  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_8}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_8}</div>
              </div>
            </div>
            <div class="score">${question_score_1_8}</div>
          </div>
		  <!--  1.9  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_9}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_9}</div>
              </div>
            </div>
            <div class="score">${question_score_1_9}</div>
          </div>
		  <!--  1.10  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_1_10}</div>
              <div class="question">
                <div class="subject-des">${question_content_1_10}</div>
              </div>
            </div>
            <div class="score">${question_score_1_10}</div>
          </div>
		</div>
		
		<!--  2  -->
        <div class="big_question_type">${question_type_2}</div>
		
        <div class="small_questions_container">
		<!--  2.1  -->
          <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_1}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_1}</div>
              </div>
            </div>
            <div class="score">${question_score_2_1}</div>
          </div>
		  <!--  2.2  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_2}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_2}</div>
              </div>
            </div>
            <div class="score">${question_score_2_2}</div>
          </div>
		  <!--  2.3  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_3}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_3}</div>
              </div>
            </div>
            <div class="score">${question_score_2_3}</div>
          </div>
		  <!--  2.4  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_4}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_4}</div>
              </div>
            </div>
            <div class="score">${question_score_2_4}</div>
          </div>
		  <!--  2.5  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_5}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_5}</div>
              </div>
            </div>
            <div class="score">${question_score_2_5}</div>
          </div>
		  <!--  2.6  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_6}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_6}</div>
              </div>
            </div>
            <div class="score">${question_score_2_6}</div>
          </div>
		  <!--  2.7  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_7}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_7}</div>
              </div>
            </div>
            <div class="score">${question_score_2_7}</div>
          </div>
		  <!--  2.8  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_8}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_8}</div>
              </div>
            </div>
            <div class="score">${question_score_2_8}</div>
          </div>
		  <!--  2.9  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_9}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_9}</div>
              </div>
            </div>
            <div class="score">${question_score_2_9}</div>
          </div>
		  <!--  2.10  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_2_10}</div>
              <div class="question">
                <div class="subject-des">${question_content_2_10}</div>
              </div>
            </div>
            <div class="score">${question_score_2_10}</div>
          </div>
		</div>
		
		<!--  3  -->
        <div class="big_question_type">${question_type_3}</div>
		
        <div class="small_questions_container">
		<!--  3.1  -->
          <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_1}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_1}</div>
              </div>
            </div>
            <div class="score">${question_score_3_1}</div>
          </div>
		  <!--  3.2  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_2}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_2}</div>
              </div>
            </div>
            <div class="score">${question_score_3_2}</div>
          </div>
		  <!--  3.3  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_3}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_3}</div>
              </div>
            </div>
            <div class="score">${question_score_3_3}</div>
          </div>
		  <!--  3.4  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_4}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_4}</div>
              </div>
            </div>
            <div class="score">${question_score_3_4}</div>
          </div>
		  <!--  3.5  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_5}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_5}</div>
              </div>
            </div>
            <div class="score">${question_score_3_5}</div>
          </div>
		  <!--  3.6  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_6}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_6}</div>
              </div>
            </div>
            <div class="score">${question_score_3_6}</div>
          </div>
		  <!--  3.7  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_7}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_7}</div>
              </div>
            </div>
            <div class="score">${question_score_3_7}</div>
          </div>
		  <!--  3.8  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_8}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_8}</div>
              </div>
            </div>
            <div class="score">${question_score_3_8}</div>
          </div>
		  <!--  3.9  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_9}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_9}</div>
              </div>
            </div>
            <div class="score">${question_score_3_9}</div>
          </div>
		  <!--  3.10  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_3_10}</div>
              <div class="question">
                <div class="subject-des">${question_content_3_10}</div>
              </div>
            </div>
            <div class="score">${question_score_3_10}</div>
          </div>
		</div>
		  
		  <!--  4  -->
        <div class="big_question_type">${question_type_4}</div>
		
        <div class="small_questions_container">
		<!--  4.1  -->
          <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_1}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_1}</div>
              </div>
            </div>
            <div class="score">${question_score_4_1}</div>
          </div>
		  <!--  4.2  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_2}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_2}</div>
              </div>
            </div>
            <div class="score">${question_score_4_2}</div>
          </div>
		  <!--  4.3  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_3}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_3}</div>
              </div>
            </div>
            <div class="score">${question_score_4_3}</div>
          </div>
		  <!--  4.4  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_4}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_4}</div>
              </div>
            </div>
            <div class="score">${question_score_4_4}</div>
          </div>
		  <!--  4.5  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_5}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_5}</div>
              </div>
            </div>
            <div class="score">${question_score_4_5}</div>
          </div>
		  <!--  4.6  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_6}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_6}</div>
              </div>
            </div>
            <div class="score">${question_score_4_6}</div>
          </div>
		  <!--  4.7  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_7}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_7}</div>
              </div>
            </div>
            <div class="score">${question_score_4_7}</div>
          </div>
		  <!--  4.8  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_8}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_8}</div>
              </div>
            </div>
            <div class="score">${question_score_4_8}</div>
          </div>
		  <!--  4.9  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_9}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_9}</div>
              </div>
            </div>
            <div class="score">${question_score_4_9}</div>
          </div>
		  <!--  4.10  -->
		  <div class="question_container">
            <div class="question_detail">
              <div class="no">${question_number2_4_10}</div>
              <div class="question">
                <div class="subject-des">${question_content_4_10}</div>
              </div>
            </div>
            <div class="score">${question_score_4_10}</div>
          </div>				
      </div>
	  
	  ${others}
    </div>
  </div>
  </div>

</body>
</html>