# YouTiNet

SpringBoot + Vue 前后端分离的网站

一、运行前准备工作
1、安装：
Node.js、
VS Code、
Spring Tool Suite（STS）、
apache-maven、
JDK8、
Git

二、运行方法
1、在本地的文件夹中右击鼠标，弹出的选项中选择Git Bash Here，打开Git窗口，输入下面的命令将代码clone到本地：
git clone https://github.com/zxm3811/YouTiNet.git

完成后，解压文件，文件夹里包含两个项目，一个“youti”，是网站的前端项目，采用的是Vue框架；另一个是“youti-api”，是网站的后端项目，采用的是SpringBoot框架。


2、在STS中导入“youti-api”项目，打开STS，点击File->Import->Maven->Existing Maven Projects->Browser,选择“youti-api”文件夹，点击Finish，等待完成导入，第一次导入会比较久。

导入完成后，可能pom.xml会报错，这时候在项目名称上右击鼠标，点击Maven->Update Project，在弹出的窗口中选中Force Update of Snapshots/Releases，然后点击OK，等待完成Update。

更新完成后，项目没有报错了。然后打开项目下的src/main/java -> com.youti.api -> YoutiApiApplication.java，右击这个文件，选择Run As->Spring Boot App，然后项目就运行起来了，默认运行在8082端口。如果出现端口号被占用的错误，只需打开src/main/resources -> application.yml文件，修改一下端口号port为其他端口号即可。

3、在VS Code中打开文件夹“youti”，点击“文件”->“打开文件夹”，然后选择“youti”文件夹即可。打开后，可以调出终端，点击“查看”->“终端”，即可打开终端。

首先，在终端输入下面的命令安装npm淘宝镜像：
npm install -g cnpm --registry=https://registry.npm.taobao.org

然后，执行下面的命令，安装导入模块：
cnpm install

最后，输入下面的命令运行项目，默认运行在8080端口，如果端口被占用，在index.js中更改port端口号即可：
npm run dev

项目运行起来后，会自动打开浏览器，然后即可运行。点击上传文件，上传成功后即可在“youti-api”下的files文件夹里看到刚才上传的文件。

三、Git工作流程
1、首先，master分支上不允许直接进行开发，即不能从master上checkout新分支，也不能把master分支merge到其他分支。
2、dev分支是用来进行开发的主分支，也不能直接在dev上进行开发。
3、每个人在进行一个新的任务之前，先在dev分支上，使用 git checkout -b 分支名 来创建一个新分支，然后 git checkout 分支名 切换到新分支，用于开发。开发完成后，直接在工程目录下使用以下命令：
git add .    //添加整个工程目录
git commit -m '备注'    //将修改提交到本地仓库
git push origin 当前分支名   //将本地仓库的修改push到远端的Github
在使用push的时候，可能会遇到提示需要git pull的情况，这是因为远端的代码比本地的代码要新，所以需要使用git pull origin 分支名 来将远端的代码pull到本地，然后才能进行push。
同样，在pull的时候，可能会遇到提示Automerge failed的提示，因为远端的代码和本地产生了冲突，需要解决冲突之后，再重新执行git add .、git commit -m '备注'、git push origin 分支名 等操作才行。
注意：日常开发时创建新分支之前记得先在dev上执行git pull，拉取最新的代码再进行后续操作，减少发生冲突。
