<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入教学计划</title>
</head>
<body>
请输入教学计划：
	<form method="post" action="servlet/LoginServlet">
		<table width="740" border="1">
			<tr>
				<td width="80">周次</td>
				<td width="210">时间</td>
				<td width="210">内容</td>
				<td width="210">备注</td>
			</tr>
			<tr>
				<td>1</td>
				<td><input type="text" size="30" name="time1"></td>
				<td><input type="text" size="30" name="content1"></td>
				<td><input type="text" size="30" name="remark1"></td>
			</tr>
			<tr>
				<td>2</td>
				<td><input type="text" size="30" name="time2"></td>
				<td><input type="text" size="30" name="content2"></td>
				<td><input type="text" size="30" name="remark2"></td>
			</tr>
			<tr>
				<td>3</td>
				<td><input type="text" size="30" name="time3"></td>
				<td><input type="text" size="30" name="content3"></td>
				<td><input type="text" size="30" name="remark3"></td>
			</tr>
			<tr>
				<td>4</td>
				<td><input type="text" size="30" name="time4"></td>
				<td><input type="text" size="30" name="content4"></td>
				<td><input type="text" size="30" name="remark4"></td>
			</tr>
			<tr>
				<td>5</td>
				<td><input type="text" size="30" name="time5"></td>
				<td><input type="text" size="30" name="content5"></td>
				<td><input type="text" size="30" name="remark5"></td>
			</tr>
			<tr>
				<td>6</td>
				<td><input type="text" size="30" name="time6"></td>
				<td><input type="text" size="30" name="content6"></td>
				<td><input type="text" size="30" name="remark6"></td>
			</tr>
			<tr>
				<td>7</td>
				<td><input type="text" size="30" name="time7"></td>
				<td><input type="text" size="30" name="content7"></td>
				<td><input type="text" size="30" name="remark7"></td>
			</tr>
			<tr>
				<td>8</td>
				<td><input type="text" size="30" name="time8"></td>
				<td><input type="text" size="30" name="content8"></td>
				<td><input type="text" size="30" name="remark8"></td>
			</tr>
			<tr>
				<td>9</td>
				<td><input type="text" size="30" name="time9"></td>
				<td><input type="text" size="30" name="content9"></td>
				<td><input type="text" size="30" name="remark9"></td>
			</tr>
			<tr>
				<td>10</td>
				<td><input type="text" size="30" name="time10"></td>
				<td><input type="text" size="30" name="content10"></td>
				<td><input type="text" size="30" name="remark10"></td>
			</tr>
			<tr>
				<td>11</td>
				<td><input type="text" size="30" name="time11"></td>
				<td><input type="text" size="30" name="content11"></td>
				<td><input type="text" size="30" name="remark11"></td>
			</tr>
			<tr>
				<td>12</td>
				<td><input type="text" size="30" name="time12"></td>
				<td><input type="text" size="30" name="content12"></td>
				<td><input type="text" size="30" name="remark12"></td>
			</tr>
			<tr>
				<td>13</td>
				<td><input type="text" size="30" name="time13"></td>
				<td><input type="text" size="30" name="content13"></td>
				<td><input type="text" size="30" name="remark13"></td>
			</tr>
			<tr>
				<td>14</td>
				<td><input type="text" size="30" name="time14"></td>
				<td><input type="text" size="30" name="content14"></td>
				<td><input type="text" size="30" name="remark14"></td>
			</tr>
			<tr>
				<td>15</td>
				<td><input type="text" size="30" name="time15"></td>
				<td><input type="text" size="30" name="content15"></td>
				<td><input type="text" size="30" name="remark15"></td>
			</tr>
			<tr>
				<td>16</td>
				<td><input type="text" size="30" name="time16"></td>
				<td><input type="text" size="30" name="content16"></td>
				<td><input type="text" size="30" name="remark16"></td>
			</tr>
			<tr>
				<td>17</td>
				<td><input type="text" size="30" name="time17"></td>
				<td><input type="text" size="30" name="content17"></td>
				<td><input type="text" size="30" name="remark17"></td>
			</tr>
			<tr>
				<td>18</td>
				<td><input type="text" size="30" name="time18"></td>
				<td><input type="text" size="30" name="content18"></td>
				<td><input type="text" size="30" name="remark18"></td>
			</tr>
			<tr>
				<td>19</td>
				<td><input type="text" size="30" name="time19"></td>
				<td><input type="text" size="30" name="content19"></td>
				<td><input type="text" size="30" name="remark19"></td>
			</tr>
			<tr>
				<td>20</td>
				<td><input type="text" size="30" name="time20"></td>
				<td><input type="text" size="30" name="content20"></td>
				<td><input type="text" size="30" name="remark20"></td>
			</tr>
		</table>


		<input type="submit" value="提交">
	</form>



</body>
</html>