package com.conttroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImple;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	UserService userService = new UserServiceImple();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 设置编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 建立一个list接收数据库返回的数据
		List<User> list = new ArrayList<>();
		list = userService.seleUsers();
		int size = list.size();
		req.setAttribute("list", list);
		PrintWriter outPrintWriter = resp.getWriter();
		outPrintWriter.write("<table>");
		outPrintWriter.write("<tr>");
		outPrintWriter.write("<td>用户id</td>");
		outPrintWriter.write("<td>用户名字</td>:");
		outPrintWriter.write("<td>用户年龄</td>:");
		outPrintWriter.write("<td>用户性别</td>:");
		outPrintWriter.write("</tr>");
		// 循环将查到的数据打印到浏览器
		for (int i = 0; i < size; i++) {
			outPrintWriter.write("<tr>");
			outPrintWriter.write("<td>" + list.get(i).getIdsInteger() + "</td>");
			outPrintWriter.write("<td>" + list.get(i).getNameString() + "</td>");
			outPrintWriter.write("<td>" + list.get(i).getAgeInteger() + "</td>");
			outPrintWriter.write("<td>" + list.get(i).getGenderString() + "</td>");
			outPrintWriter.write("</tr>");

		}
		outPrintWriter.write("</table>");
		outPrintWriter.close();
	}

}
