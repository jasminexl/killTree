# killTree

# 10.30
任务1:九宫格——用html+css制作一个网页
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







