package cn.shaoxiongdu.web.controller;

import cn.shaoxiongdu.bean.User;
import cn.shaoxiongdu.service.BookService;
import cn.shaoxiongdu.service.UserService;
import cn.shaoxiongdu.service.impl.BookServiceImpl;
import cn.shaoxiongdu.service.impl.UserServiceImpl;
import cn.shaoxiongdu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-15 | 14:42
 */
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    private BookService bookService = new BookServiceImpl();

    public void registration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //属性注入
        User user = WebUtils.param2Bean(new User(), req.getParameterMap());

        //获取会话域中的验证码
        String token = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //删除会话域中的验证码
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        //获取用户输入的验证码
        String verificationCode = req.getParameter("verificationCode");

        if(!token.equalsIgnoreCase(verificationCode)){
            req.setAttribute("message","验证码错误,重试呐!");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

        if (userService.existAccount(user.getAccount())) {
            req.setAttribute("message","用户名已存在!");
            req.setAttribute("account",user.getAccount());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

        int insert = userService.insert(user);

        if(insert > 0){
            req.getSession().setAttribute("loginUser",userService.QueryByAccountAndPassword(new User(0,user.getAccount(),user.getPassword(),null)));
            req.setAttribute("page",bookService.page(1,16));
            req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
        }

    }

    /**
     * 登录方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //请求参数注入对象中
        User user = WebUtils.param2Bean(new User(),req.getParameterMap());

        User loginUser = userService.QueryByAccountAndPassword(user);
        if(loginUser == null){
            //账号密码错误 返回错误页面
            req.setAttribute("message","账号或者密码错误!");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            resp.addCookie(new Cookie("account",loginUser.getAccount()));
            //保存当前登录用户的信息到绘画作用域
            req.getSession().setAttribute("loginUser",loginUser);
            req.setAttribute("page",bookService.page(1,16));
            req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();

        resp.sendRedirect(req.getContextPath());

    }

}
