/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.16
 * Generated at: 2019-10-01 07:37:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pc.parts.dto.NotiDTO;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.pc.parts.dto.NotiDTO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Nanum+Gothic|Roboto&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("\tfont-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("\tfont-family: 'Roboto', sans-serif;\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".noti-area{\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\twidth:360px;\r\n");
      out.write("\theight: 70px;\r\n");
      out.write("\tbackground-color: rgba(0,0,0,0.2);\r\n");
      out.write("\tborder-radius: 15px;\r\n");
      out.write("\tpadding:50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li {\r\n");
      out.write("\theight: 50px;\r\n");
      out.write("\tline-height: 50px;\r\n");
      out.write("\twidth: 210px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tline-height: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li:hover {\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tbackground-color: #eeeeee;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".frame{\r\n");
      out.write("  width: 110px;\r\n");
      out.write("  margin: 0 auto;\r\n");
      out.write("  margin-right:10px;\r\n");
      out.write("  display:inline-block;\r\n");
      out.write("  position: relative;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  float:left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".frame:hover .hex-inner{\r\n");
      out.write("  height: 100px;\r\n");
      out.write("  top: 90px !important;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".frame:hover .label{\r\n");
      out.write("  transform: scale(.95);\r\n");
      out.write("  -webkit-transform: scale(.95);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".hex-outer{\r\n");
      out.write("  background: #ABF8FF;\r\n");
      out.write("  width: 110px;\r\n");
      out.write("  height: 64px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".h1{\r\n");
      out.write("  position: absolute;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".h2{\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  transform: rotate(60deg);\r\n");
      out.write("  -webkit-transform: rotate(60deg);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".h3{\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  transform: rotate(-60deg);\r\n");
      out.write("  -webkit-transform: rotate(-60deg);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".label{\r\n");
      out.write("  position: relative;\r\n");
      out.write("  color: #000000;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  text-align:center;\r\n");
      out.write("  left: 0px;\r\n");
      out.write("    transition: all .1s;\r\n");
      out.write("  -webkit-transition: all .1s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".frame:hover .noti-cnt{\r\n");
      out.write("  text-decoration: underline!important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".frame:hover .noti-cnt{\r\n");
      out.write("   text-decoration: underline!important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".noti-cnt{\r\n");
      out.write("\tfont-size:24px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".noti-area{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>관리하자</title>\r\n");
      out.write("</head>\r\n");

	int noti_cnt = 0;
	List<NotiDTO> noti_list = null;
	if (request.getAttribute("noti_list") != null) {
		noti_list = (List<NotiDTO>) request.getAttribute("noti_list");
	}

      out.write("\r\n");
      out.write("<body style=\"margin: 0; padding: 0;\">\r\n");
      out.write("\t<div style=\"height: 100px; line-height: 100px; width: 100%;padding:0 10px 0 10px; background-color:rgba(230,230,230,0.4);box-sizing: border-box;\">\r\n");
      out.write("\t\t<span>관리하자</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"container\" style=\"display: inline-block;width:100%;\">\r\n");
      out.write("\t\t<div style=\"float: left; height: 100%; display: inline-block;\">\r\n");
      out.write("\t\t\t<ul style=\"list-style: none; padding: 0px; margin: 0px;; height: 1200px;\">\r\n");
      out.write("\t\t\t\t<li>메뉴</li>\r\n");
      out.write("\t\t\t\t<li>메뉴</li>\r\n");
      out.write("\t\t\t\t<li>메뉴</li>\r\n");
      out.write("\t\t\t\t<li>메뉴</li>\r\n");
      out.write("\t\t\t\t<li>메뉴</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"noti-area\">\r\n");
      out.write("\t\t\t<div class=\"frame\">\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h1\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h2\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h3\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"label\"><span style=\"font-size:24px;\">요청<br><a class=\"noti-cnt\" style=\"text-decoration: none;color:orangered;\" href=\"javascript:;\">");
      out.print(noti_list.size() );
      out.write("</a></span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"frame\">\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h1\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h2\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h3\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"label\"><span style=\"font-size:24px;\">요청<br><a class=\"noti-cnt\" style=\"text-decoration: none;color:orangered;\" href=\"javascript:;\">");
      out.print(noti_list.size() );
      out.write("</a></span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"frame\">\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h1\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h2\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"hex-outer h3\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"label\"><span style=\"font-size:24px;\">요청<br><a class=\"noti-cnt\" style=\"text-decoration: none;color:orangered;\" href=\"javascript:;\">");
      out.print(noti_list.size() );
      out.write("</a></span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
