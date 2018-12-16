<template>
	<div class="add_question">
    <div class="question_type">
      <div class="question_info_container">
        <div class="question_info_item">
          <div class="text">科目</div>
          <el-select class="select" v-model="subject_id" placeholder="科目" size="mini" @change="subjectChange">
            <el-option
              v-for="subject_id in subjectIdOptions"
              :key="subject_id.value"
              :label="subject_id.value"
              :value="subject_id.index">
            </el-option>
          </el-select>
        </div>
        <div class="question_info_item">
          <div class="text">知识点</div>
          <el-select class="select" v-model="knowledge_point_id" placeholder="知识点" size="mini">
            <el-option
              v-for="knowledge_point_id in knowledgePointIdOptions"
              :key="knowledge_point_id.value"
              :label="knowledge_point_id.value"
              :value="knowledge_point_id.index">
            </el-option>
          </el-select>
        </div>
        <div class="question_info_item">
          <div class="text">难度</div>
          <el-select class="select" v-model="difficulty_degree" placeholder="难度" size="mini">
            <el-option
              v-for="difficulty_degree in difficultyDegreeOptions"
              :key="difficulty_degree.value"
              :label="difficulty_degree.value"
              :value="difficulty_degree.index">
            </el-option>
          </el-select>
        </div>
      </div>
      <div class="choose_question_type">选择题型</div>
      <div class="question_type_container">
        <el-radio-group v-model="questionType" @change="radioChange">
          <el-radio :label="1">单选题</el-radio>
          <el-radio :label="2">多选题</el-radio>
          <el-radio :label="3">填空题</el-radio>
          <el-radio :label="4">解答题</el-radio>
        </el-radio-group>
      </div>
    </div>
    <div v-if="questionType == 1" class="single_choice">
      <el-form class="form" ref="form" :model="form" :rules="rules" label-width="0">
        <div class="question_content_container">
          <div class="text">题目</div>
          <el-form-item label="" prop="content">
            <el-input class="content" type="textarea" v-model="form.content" autosize></el-input>
          </el-form-item>
        </div>
        <div class="question_option_container">
          <div class="text">选项</div>
          <div class="option_container">
            <el-form-item label="A、" prop="optionA">
              <el-input class="option" type="textarea" v-model="form.optionA" autosize></el-input>
            </el-form-item>
            <el-form-item label="B、" prop="optionB">
              <el-input class="option" type="textarea" v-model="form.optionB" autosize></el-input>
            </el-form-item>
            <el-form-item label="C、" prop="optionC">
              <el-input class="option" type="textarea" v-model="form.optionC" autosize></el-input>
            </el-form-item>
            <el-form-item label="D、" prop="optionD">
              <el-input class="option" type="textarea" v-model="form.optionD" autosize></el-input>
            </el-form-item>
          </div>
        </div>
        <div class="question_answer_container">
          <div class="text">答案</div>
          <el-form-item label="" prop="answer">
            <el-input class="answer" type="textarea" v-model="form.answer" autosize></el-input>
          </el-form-item>
        </div>
        <div class="preview" v-if="isPreview">
          <div class="text">预览</div>
          <div class="question">
            <div class="text">题目</div>
            <div v-html="question_content" class="question_content"></div>
            <div class="text">答案</div>
            <div v-html="question_answer" class="question_answer"></div>
          </div>
        </div>
      </el-form>
    </div>
    <div v-if="questionType == 2" class="multiple_choice">
      <el-form class="form" ref="form" :model="form" :rules="rules" label-width="0">
        <div class="question_content_container">
          <div class="text">题目</div>
          <el-form-item label="" prop="content">
            <el-input class="content" type="textarea" v-model="form.content" autosize></el-input>
          </el-form-item>
        </div>
        <div class="question_option_container">
          <div class="text">选项</div>
          <div class="option_container">
            <el-form-item label="A、" prop="optionA">
              <el-input class="option" type="textarea" v-model="form.optionA" autosize></el-input>
            </el-form-item>
            <el-form-item label="B、" prop="optionB">
              <el-input class="option" type="textarea" v-model="form.optionB" autosize></el-input>
            </el-form-item>
            <el-form-item label="C、" prop="optionC">
              <el-input class="option" type="textarea" v-model="form.optionC" autosize></el-input>
            </el-form-item>
            <el-form-item label="D、" prop="optionD">
              <el-input class="option" type="textarea" v-model="form.optionD" autosize></el-input>
            </el-form-item>
          </div>
        </div>
        <div class="question_answer_container">
          <div class="text">答案</div>
          <el-form-item label="" prop="answer">
            <el-input class="answer" type="textarea" v-model="form.answer" autosize></el-input>
          </el-form-item>
        </div>
        <div class="preview" v-if="isPreview">
          <div class="text">预览</div>
          <div class="question">
            <div class="text">题目</div>
            <div v-html="question_content" class="question_content"></div>
            <div class="text">答案</div>
            <div v-html="question_answer" class="question_answer"></div>
          </div>
        </div>
      </el-form>
    </div>
    <div v-if="questionType == 3" class="fill_in_blank">
      <el-form class="form" ref="form" :model="form" :rules="rules" label-width="0">
        <div class="question_content_container">
          <div class="text">题目</div>
          <el-form-item label="" prop="content">
            <el-input class="content" type="textarea" v-model="form.content" autosize></el-input>
          </el-form-item>
        </div>
        <div class="question_answer_container">
          <div class="text">答案</div>
          <el-form-item label="" prop="answer">
            <el-input class="answer" type="textarea" v-model="form.answer" autosize></el-input>
          </el-form-item>
        </div>
        <div class="preview" v-if="isPreview">
          <div class="text">预览</div>
          <div class="question">
            <div class="text">题目</div>
            <div v-html="question_content" class="question_content"></div>
            <div class="text">答案</div>
            <div v-html="question_answer" class="question_answer"></div>
          </div>
        </div>
      </el-form>
    </div>
    <div v-if="questionType == 4" class="essay_question">
      <el-form class="form" ref="form" :model="form" :rules="rules" label-width="0">
        <div class="question_content_container">
          <div class="text">题目</div>
          <el-form-item label="" prop="content">
            <el-input class="content" type="textarea" v-model="form.content" autosize></el-input>
          </el-form-item>
        </div>
        <div class="question_answer_container">
          <div class="text">答案</div>
          <el-form-item label="" prop="answer">
            <el-input class="answer" type="textarea" v-model="form.answer" autosize></el-input>
          </el-form-item>
        </div>
        <div class="preview" v-if="isPreview">
          <div class="text">预览</div>
          <div class="question">
            <div class="text">题目</div>
            <div v-html="question_content" class="question_content"></div>
            <div class="text">答案</div>
            <div v-html="question_answer" class="question_answer"></div>
          </div>
        </div>
      </el-form>
    </div>
    <div v-if="questionType !== 0" class="operation">
      <div class="button">
        <div class="preview" @click="preview('form')">预览</div>
        <div class="confirm" @click="addNewQuestion('form')">确定</div>
        <div class="cancle" @click="cancle">取消</div>
      </div>
    </div>
	</div>
</template>

<script type="text/javascript">
import { QuestionService } from "src/service/question.js";

export default {
  data() {
    return {
      questionType: 0,
      isPreview: false,
      question_content: null,
      question_answer: null,
      subject_id: null,
      knowledge_point_id: null,
      difficulty_degree: null,
      form: {},
      subjectIdOptions: [
        { value: "算法", index: 1, item: [
          { value: "查找", index: 1 }, { value: "排序", index: 2 }, { value: "递归", index: 3 }, { value: "贪心", index: 4 }, { value: "复杂度", index: 5 }
        ] }, 
        { value: "编程语言", index: 2, item: [
          { value: "C/C++", index: 6 }, { value: "Java", index: 7 }, { value: "JavaScript", index: 8 }, { value: "C#", index: 9 }, { value: "Python", index: 10 }, { value: "HTML/CSS", index: 11 }
        ] }, 
        { value: "数据结构", index: 3, item: [
          { value: "数组", index: 12 }, { value: "字符串", index: 13 }, { value: "链表", index: 14 }, { value: "栈", index: 15 }, { value: "队列", index: 16 }, { value: "树", index: 17 }, { value: "图", index: 18 }
        ] }, 
        { value: "计算机基础", index: 4, item: [
          { value: "网络基础", index: 19 }, { value: "正则表达式", index: 20 }, { value: "数据库", index: 21 }, { value: "操作系统", index: 22 }, { value: "编译和体系结构", index: 23 }
        ] }, 
        { value: "数学和逻辑", index: 5, item: [
          { value: "组合数学", index: 24 }, { value: "概率统计", index: 25 }, { value: "数量关系", index: 26 }, { value: "判断推理", index: 27 }, { value: "常识判断", index: 28 }
        ] }, 
        { value: "软件开发", index: 6, item: [
          { value: "软件工程", index: 29 }, { value: "软件测试", index: 30 }, { value: "面向对象", index: 31 }
        ] }, 
      ],
      knowledgePointIdOptions: [],
      difficultyDegreeOptions: [
        { value: "一星", index: "1" }, { value: "二星", index: "2" }, { value: "三星", index: "3" }, { value: "四星", index: "4" }, { value: "五星", index: "5" }
      ],
      rules: {
        content: [
          { required: true, message: '请输入题目', trigger: 'change' },
        ],
        optionA: [
          { required: true, message: '请输入选项A', trigger: 'change' }
        ],
        optionB: [
          { required: true, message: '请输入选项B', trigger: 'change' }
        ],
        optionC: [
          { required: true, message: '请输入选项C', trigger: 'change' }
        ],
        optionD: [
          { required: true, message: '请输入选项D', trigger: 'change' }
        ],
        answer: [
          { required: true, message: '请输入答案', trigger: 'change' }
        ]
      }
    };
  },

  methods: {
    subjectChange(value) {
      this.knowledge_point_id = null;
      this.subjectIdOptions.forEach(subject => {
        if(subject.index === value) {
          this.knowledgePointIdOptions = subject.item;
        }
      });
    },

    radioChange() {
      this.isPreview = false;
      this.question_content = null;
      this.question_answer = null;
      this.form = {};
    },

    preview(form) {
      this.$refs[form].validate(async (valid) => {
        if (valid) {
          if(!this.subject_id) {
            this.$toast.text("请选择科目");
            return;
          }
          if(!this.knowledge_point_id) {
            this.$toast.text("请选择知识点");
            return;
          }
          if(!this.difficulty_degree) {
            this.$toast.text("请选择难度");
            return;
          }
          this.isPreview = true;
          let content = this.form.content.replace(/</g, "&lt;");
          content = content.replace(/>/g, "&gt;");
          let answer = this.form.answer.replace(/</g, "&lt;");
          answer = answer.replace(/>/g, "&gt;");
          if(this.questionType == 1 || this.questionType == 2) {
            let optionA = this.form.optionA.replace(/</g, "&lt;");
            let optionB = this.form.optionB.replace(/</g, "&lt;");
            let optionC = this.form.optionC.replace(/</g, "&lt;");
            let optionD = this.form.optionD.replace(/</g, "&lt;");
            optionA = optionA.replace(/>/g, "&gt;");
            optionB = optionB.replace(/>/g, "&gt;");
            optionC = optionC.replace(/>/g, "&gt;");
            optionD = optionD.replace(/>/g, "&gt;");
            this.question_content = "<div>" + content + "<ul><li>" + optionA + "</li><li>" + optionB + "</li><li>" + optionC + "</li><li>" + optionD + "</li></ul></div>";
            this.question_content = this.question_content.replace(/\n/g, "<br/>");
            this.question_content = this.question_content.replace(/\s/g, "&nbsp;");
          } else {
            this.question_content = "<div>" + content + "</div>";
            this.question_content = this.question_content.replace(/\n/g, "<br/>");
          }
          this.question_answer = "<div>" + answer + "</div>";
          this.question_answer = this.question_answer.replace(/\n/g, "<br/>");
          this.question_answer = this.question_answer.replace(/\s/g, "&nbsp;");
        } else {
          return false;
        }
      });
    },

    addNewQuestion(form) {
      this.$refs[form].validate(async (valid) => {
        if (valid) {
          if(!this.subject_id) {
            this.$toast.text("请选择科目");
            return;
          }
          if(!this.knowledge_point_id) {
            this.$toast.text("请选择知识点");
            return;
          }
          if(!this.difficulty_degree) {
            this.$toast.text("请选择难度");
            return;
          }
          let content = this.form.content.replace(/</g, "&lt;");
          content = content.replace(/>/g, "&gt;");
          let answer = this.form.answer.replace(/</g, "&lt;");
          answer = answer.replace(/>/g, "&gt;");
          if(this.questionType == 1 || this.questionType == 2) {
            let optionA = this.form.optionA.replace(/</g, "&lt;");
            let optionB = this.form.optionB.replace(/</g, "&lt;");
            let optionC = this.form.optionC.replace(/</g, "&lt;");
            let optionD = this.form.optionD.replace(/</g, "&lt;");
            optionA = optionA.replace(/>/g, "&gt;");
            optionB = optionB.replace(/>/g, "&gt;");
            optionC = optionC.replace(/>/g, "&gt;");
            optionD = optionD.replace(/>/g, "&gt;");
            this.question_content = "<div>" + content + "<ul><li>" + optionA + "</li><li>" + optionB + "</li><li>" + optionC + "</li><li>" + optionD + "</li></ul></div>";
            this.question_content = this.question_content.replace(/\n/g, "<br/>");
            this.question_content = this.question_content.replace(/\s/g, "&nbsp;");
          } else {
            this.question_content = "<div>" + content + "</div>";
            this.question_content = this.question_content.replace(/\n/g, "<br/>");
          }
          this.question_answer = "<div>" + answer + "</div>";
          this.question_answer = this.question_answer.replace(/\n/g, "<br/>");
          this.question_answer = this.question_answer.replace(/\s/g, "&nbsp;");
          let newQuestion = {};
          newQuestion.type_id = this.questionType;
          newQuestion.content = this.question_content;
          newQuestion.answer = this.question_answer;
          newQuestion.score = this.getScoreByType(this.questionType);
          newQuestion.difficulty_degree = this.difficulty_degree;
          newQuestion.subject_id = this.subject_id;
          newQuestion.knowledge_point_id = this.knowledge_point_id;
          let response = await QuestionService.addNewQuestion(newQuestion);
          if(response && response.isSuccess) {
            let that = this;
            var time = 3;
            var interval = setInterval(function() {
              that.$toast.text("题目添加成功，" + time + "秒后将跳转到“题库管理”页面");
              time -= 1;
              if(time === 0){
                clearInterval(interval);
                setTimeout(() => {
                  that.$router.push("/backstage/question");
                }, 1000);
              }
            }, 1010);
          } else {
            this.$toast.text(response.message);
          }
        } else {
          return false;
        }
      });
    },

    getScoreByType(type) {
      switch(type) {
        case 1: return 2;
        case 2: return 4;
        case 3: return 4;
        case 4: return 10;
        default: return 0;
      }
    },

    cancle() {
      this.$confirm('确定取消添加题目？').then(() => {
        this.$router.push("/backstage/question");
      }).catch(() => {
        return;
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.add_question {
  width: 9rem;
  margin: auto;
  display: flex;
  flex-direction: column;
  .question_type {
    margin-top: 0.5rem;
    .question_info_container {
      margin: 0.2rem 0;
      display: flex;
      justify-content: space-between;
      align-items: center;
      .question_info_item {
        margin: 0 0.05rem;
        font-size: 0.2rem;
        width: 2.5rem;
        display: flex;
        align-items: center;
        .text {
          flex: 0 0 auto;
          margin-right: 0.05rem;
        }
      }
    }
    .choose_question_type {
      margin-top: 0.4rem;
      font-size: 0.3rem;
      font-weight: bold;
    }
    .question_type_container {
      margin-top: -0.3rem;
    }
  }

  .single_choice {
    margin-bottom: 0.5rem;
    display: flex;
    flex-direction: column;
    .text {
      font-size: 0.25rem;
      font-weight: bold;
    }
    .question_content_container {
      display: flex;
      flex-direction: column;
      .content {
        margin: 0.2rem 0;
      }
    }
    .question_option_container {
      display: flex;
      flex-direction: column;
      .option_container {
        margin: 0.2rem 0;
        font-size: 0.2rem;
        display: flex;
        flex-direction: column;
      }
    }
    .question_answer_container {
      display: flex;
      flex-direction: column;
      .answer {
        margin: 0.2rem 0;
      }
    }

    .preview {
      display: flex;
      flex-direction: column;
      .question {
        margin: 0.1rem 0;
        padding: 0.1rem;
        border: 1px solid #cccccc;
        border-radius: 0.05rem;
        display: flex;
        flex-direction: column;
        .text {
          font-size: 0.23rem;
          color: #0493d3;
          margin: 0.1rem 0;
        }
        .question_content {
          background: #eeeeee;
          margin-bottom: 0.2rem;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
          /deep/ li {
            list-style-type: upper-alpha;
            list-style-position: inside;
            margin: 10px 0;
          }
        }
        .question_answer {
          background: #eeeeee;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
        }
      }
    }
  }
  .multiple_choice {
    margin-bottom: 0.5rem;
    display: flex;
    flex-direction: column;
    .text {
      font-size: 0.25rem;
      font-weight: bold;
    }
    .question_content_container {
      display: flex;
      flex-direction: column;
      .content {
        margin: 0.2rem 0;
      }
    }
    .question_option_container {
      display: flex;
      flex-direction: column;
      .option_container {
        margin: 0.2rem 0;
        font-size: 0.2rem;
        display: flex;
        flex-direction: column;
      }
    }
    .question_answer_container {
      display: flex;
      flex-direction: column;
      .answer {
        margin: 0.2rem 0;
      }
    }

    .preview {
      display: flex;
      flex-direction: column;
      .question {
        margin: 0.1rem 0;
        padding: 0.1rem;
        border: 1px solid #cccccc;
        border-radius: 0.05rem;
        display: flex;
        flex-direction: column;
        .text {
          font-size: 0.23rem;
          color: #0493d3;
          margin: 0.1rem 0;
        }
        .question_content {
          background: #eeeeee;
          margin-bottom: 0.2rem;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
          /deep/ li {
            list-style-type: upper-alpha;
            list-style-position: inside;
            margin: 10px 0;
          }
        }
        .question_answer {
          background: #eeeeee;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
        }
      }
    }
  }
  .fill_in_blank {
    margin-bottom: 0.5rem;
    display: flex;
    flex-direction: column;
    .text {
      font-size: 0.25rem;
      font-weight: bold;
    }
    .question_content_container {
      display: flex;
      flex-direction: column;
      .content {
        margin: 0.2rem 0;
      }
    }
    .question_answer_container {
      display: flex;
      flex-direction: column;
      .answer {
        margin: 0.2rem 0;
      }
    }

    .preview {
      display: flex;
      flex-direction: column;
      .question {
        margin: 0.1rem 0;
        padding: 0.1rem;
        border: 1px solid #cccccc;
        border-radius: 0.05rem;
        display: flex;
        flex-direction: column;
        .text {
          font-size: 0.23rem;
          color: #0493d3;
          margin: 0.1rem 0;
        }
        .question_content {
          background: #eeeeee;
          margin-bottom: 0.2rem;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
        }
        .question_answer {
          background: #eeeeee;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
        }
      }
    }
  }
  .essay_question {
    margin-bottom: 0.5rem;
    display: flex;
    flex-direction: column;
    .text {
      font-size: 0.25rem;
      font-weight: bold;
    }
    .question_content_container {
      display: flex;
      flex-direction: column;
      .content {
        margin: 0.2rem 0;
      }
    }
    .question_answer_container {
      display: flex;
      flex-direction: column;
      .answer {
        margin: 0.2rem 0;
      }
    }

    .preview {
      display: flex;
      flex-direction: column;
      .question {
        margin: 0.1rem 0;
        padding: 0.1rem;
        border: 1px solid #cccccc;
        border-radius: 0.05rem;
        display: flex;
        flex-direction: column;
        .text {
          font-size: 0.23rem;
          color: #0493d3;
          margin: 0.1rem 0;
        }
        .question_content {
          background: #eeeeee;
          margin-bottom: 0.2rem;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
        }
        .question_answer {
          background: #eeeeee;
          width: 100%;
          font-size: 0.2rem;
          word-break: break-all;
        }
      }
    }
  }
  .operation {
    margin-bottom: 0.5rem;
    display: flex;
    justify-content: center;
    .button {
      margin: 0 0.2rem;
      display: flex;
      align-items: center;
      div {
        width: 1rem;
        height: 0.5rem;
        border-radius: 0.04rem;
        font-size: 0.26rem;
        background: #0493d3;
        color: #ffffff;
        display: flex;
        justify-content: center;
        align-items: center;
        cursor: pointer;
      }
      .preview {
        margin-right: 0.2rem;
      }
      .confirm {
        margin-right: 0.2rem;
      }
    }
  }
}
</style>
