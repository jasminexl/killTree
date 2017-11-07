# killTree

# 10.30
Mission1：九宫格——用html+css制作一个网页
环境搭建：
Sublime&Chrome
知识学习：
1.<!DOCTYPE>标签
<!DOCTYPE>声明必须是HTML文档的第一行，位于<html>标签之前。
<!DOCTYPE>声明不是HTML标签；它是指示web浏览器关于页面使用哪个HTML版本进行编写的指令。
2.web标准
结构标准：相当于人的身体。html就是用来制作网页的。
表现标准：相当于人的衣服。css就是对网页进行美化的。
行为标准：相当于人的动作。JS就是让网页动起来，具有生命力的。
3.CSS盒子模型
有：外边距（margin）、边框（border）、内边距（padding）、内容（content）四个属性。
俯视这个盒子，它有上下左右四条边，所以每个属性除了内容（content），都包括四个部分：上下左右；这四部分可同时设置，也可分别设置；内边距可以理解为盒子里装的东西和边框的距离，而边框有厚薄和颜色之分，内容就是盒子中间装的东西，外边距就是边框外面自动留出的一段空白。
4.float
浮动元素会脱离文档流并向左/向右浮动，直到碰到父元素或者另一个浮动元素。
--会脱离文档流（有覆盖普通元素的风险）
--可以内联排列
--会导致父元素高度坍塌（浮动元素脱离了文档流，并不占据文档流的位置，自然父元素也就不能被撑开，所以没了高度）
*如何清除浮动（解决父元素高度坍塌问题）：
(1)添加新的元素,应用clear：both
(2)父元素应用overflow:hidden
(3)clearfix 利用after伪元素应用clear:both
(4)改进版clearfix
//全浏览器通用的clearfix方案
// 引入了zoom以支持IE6/7
// 同时加入:before以解决现代浏览器上边距折叠的问题
.clearfix:before,
.clearfix:after {
    display: table;
    content: " ";
}
.clearfix:after {
    clear: both;
}
.clearfix{
    *zoom: 1;
}
5.在第18步骤（编码实战）进一步修改样式，使九宫格大小可以随屏幕宽度改变，初步体验自适应过程中遇到的迷惑的问题：九宫格中每一个的高度如何自适应与宽度相同？
以下是W3C的规范：
--Note that in a horizontal flow, percentages on ‘margin-top’ and ‘margin-bottom’ are relative to the width of the containing block, not the height (and in vertical flow, ‘margin-left’ and ‘margin-right’ are relative to the height, not the width).
--Note that percentages on ‘padding-top’ and ‘padding-bottom’ are relative to the width of the containing block, not the height (at least in a horizontal flow; in a vertical flow they are relative to the height).
圈重点就是：margin和padding的top/bottom是与父元素的width相关的！
而width的自适应是根据viewport的width来调整的，但height指定百分比后，会根据viewport的height来调整，没法和width扯上关系。
以下博客有详解：纯Css实现Div高度根据自适应宽度（百分比）调整 - Heyach - 博客园
http://www.cnblogs.com/heyach/p/6494872.html?utm_source=itdadao&utm_medium=referral
6.viewport
指的是用户网页的可视区域。
<meta name="viewport" content="width=device-width,initial-scale="1.0">
7.nginx
感谢师兄师姐在知乎上的回答！
https://www.zhihu.com/question/41430703

#11.3
mission2：认识开发必备工具
github&git&svn
常用git命令：
1.git init(把这个目录变成Git可以管理的仓库)
2.git add <file>
3.git commit -m "本次提交的说明"
4.git status(显示仓库当前的状态)
5.git diff(查看仓库具体变化)
6.git log(显示从最近到最远的提交日志)
7.git reset --hard commit_id(回到commit_id版本)
8.git reflog（查看命令历史，以便确定要回到未来的哪个版本）
9.git checkout -- file(用版本库里的版本替换工作区的版本)
10.git rm <file>(删除文件)
*工作区->add->暂存区->commit->版本库

mission3:魔镜介绍页——一个最简单的移动端页面
1.margin&padding
http://www.cnblogs.com/linjiqin/p/3556497.html(里面讲的很形象)
2.px&em&rem
px-像素Pixel,相对长度单位,是相对于显示器屏幕分辨率而言的.
em-相对长度单位,相对于当前对象内文本的字体尺寸.如当前对行内文本的字体尺寸未被人为设置,则相对于浏览器的默认尺寸.(会继承父级元素的字体大小)
rem-CSS3新增的一个相对单位,相对的只是HTML根元素.
3.居中
水平居中：
-text-align: center;//在块级父容器中让行内元素居中
-width:100px;margin-left:auto;margin-right:auto;//有宽度的容器居中
-flex布局
垂直居中：
-等值的padding-top和padding-bottom
-等值的height和line-height(文本不会换行)
-flex布局
*详细水平垂直居中方法介绍及实例(http://www.w3cplus.com/css/centering-css-complete-guide.html)
4.flex布局
阮一峰的网络日志(http://www.ruanyifeng.com/blog/2015/07/flex-grammar.html)

mission4:登录页——一个最常见的移动端页面
1.position
-static(默认)
-relative(元素会根据top,left,bottom,right进行偏移,关键点是它原本的空间仍然保留)
-absolute(元素会脱离文档流,并且不占有原本的空间,而且不论元素是行内元素还是块级元素,都会生成一个块级框)
-fixed(表现方式类似于absolute,但是相比于absolute相对于不确定的父元素进行偏移,fixed就是相对于浏览器窗口进行偏移)
*非根元素的包含块,如果该元素的position是relative或static，它的包含块是最近的块级框;如果该元素的position是absolute,则包含块为最近的position不是static的祖先元素.
2.input表单

3.css选择器优先级
!important > 行内样式 > ID选择器 > 类选择器 > 标签 > 通配符 > 继承 > 浏览器默认属性



