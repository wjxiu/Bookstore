package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.Webutils;
import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xiu
 * @create 2021-10-26 20:00
 */
@WebServlet("/userservlet")
public class UserServlet extends BaseServlet {
    UserServiceImpl userService = new UserServiceImpl();
    /**
     * 登录业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password, null);
        User login = userService.login(user);
        if (login==null){
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user",login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
    /**
     * 注册业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User o =  Webutils.copyParameterToBean(req.getParameterMap(), new User());
        String googlecode =(String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (code!=""&googlecode.equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.existUser(username)) {
//                回传输入框的内容
                req.setAttribute("code", code);
                req.setAttribute("username", username);
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                req.setAttribute("email", email);
                req.setAttribute("mes", "用户名已经存在");
                System.out.println("用户名[" + username + "]已存在!");
//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {

                //      可用
//                调用Sservice保存到数据库
                userService.regisetUser(o);
//        跳到注册成功页面 regist_success.jsp
                HttpSession session = req.getSession();
                session.setAttribute("user", o);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("code", code);
            req.setAttribute("username", username);
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            req.setAttribute("mes", "验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
    protected void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
