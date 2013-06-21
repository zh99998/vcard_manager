package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jspx extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005farguments_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005farguments_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005fnobody.release();
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005farguments_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<div version=\"2.0\">");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_spring_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("<style type=\"text/css\">");
      out.write("\n");
      out.write("body {\n");
      out.write("\tpadding-top: 60px;\n");
      out.write("\tpadding-bottom: 40px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sidebar-nav {\n");
      out.write("\tpadding: 9px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@media ( max-width : 980px) { /* Enable use of floated navbar text */\n");
      out.write("\t.navbar-text.pull-right {\n");
      out.write("\t\tfloat: none;\n");
      out.write("\t\tpadding-left: 5px;\n");
      out.write("\t\tpadding-right: 5px;\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("</style>");
      out.write("<div class=\"container-fluid\">");
      out.write("<div class=\"row-fluid\">");
      out.write("<div class=\"span3\">");
      out.write("<div class=\"well sidebar-nav\">");
      out.write("<ul class=\"nav nav-list\">");
      out.write("<li class=\"active\">");
      out.write("<a href=\"#\">");
      out.write('通');
      out.write('讯');
      out.write('录');
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\">");
      out.write('群');
      out.write('组');
      out.write('1');
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\">");
      out.write('群');
      out.write('组');
      out.write('2');
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a style=\"width:80px\" data-toggle=\"modal\" class=\"btn\" role=\"button\" href=\"#new_circle\">");
      out.write("新建群组");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a style=\"width:80px\" data-toggle=\"modal\" class=\"btn\" role=\"button\" href=\"#myModal\">");
      out.write("导入名片");
      out.write("</a>");
      out.write("</li>");
      out.write("<div aria-hidden=\"true\" aria-labelledby=\"myModalLabel\" role=\"dialog\" tabindex=\"-1\" class=\"modal hide fade\" id=\"new_circle\">");
      out.write("<div class=\"modal-header\">");
      out.write("<button aria-hidden=\"true\" data-dismiss=\"modal\" class=\"close\" type=\"button\">");
      out.write('×');
      out.write("</button>");
      out.write("<h3 id=\"myModalLabel\">");
      out.write("Modal header");
      out.write("</h3>");
      out.write("</div>");
      out.write("<div class=\"modal-body\">");
      out.write("<p>");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t输入组名 ");
      out.write("<input name=\"fname\" type=\"text\"/>");
      out.write("</p>");
      out.write("</div>");
      out.write("<div class=\"modal-footer\">");
      out.write("<button aria-hidden=\"true\" data-dismiss=\"modal\" class=\"btn\">");
      out.write('关');
      out.write('闭');
      out.write("</button>");
      out.write("<button class=\"btn btn-primary\">");
      out.write('保');
      out.write('存');
      out.write("</button>");
      out.write("</div>");
      out.write("</div>");
      out.write("</ul>");
      out.write("</div>");
      out.write("</div>");
      out.write("<div class=\"span9\">");
      out.write("<div class=\"btn-group\">");
      out.write("<a style=\"width:65px;\" href=\"#\" data-toggle=\"dropdown\" class=\"btn dropdown-toggle\">");
      out.write("<input style=\"margin:3px 10px;\" type=\"checkbox\"/>");
      out.write("<span class=\"caret\"/>");
      out.write("</a>");
      out.write("<ul class=\"dropdown-menu\">");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write('全');
      out.write('选');
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write('全');
      out.write('不');
      out.write('选');
      out.write("</a>");
      out.write("</li>");
      out.write("<li class=\"divider\"/>");
      out.write("</ul>");
      out.write("</div>");
      out.write("<div class=\"btn-group\">");
      out.write("<a data-toggle=\"modal\" style=\"width:65px;\" class=\"btn dropdown-toggle\" href=\"#new_card\">");
      out.write("<i class=\"icon-user\">");
      out.write("</i>");
      out.write("<i class=\"icon-plus\">");
      out.write("</i>");
      out.write("<span style=\"margin:3px 10px;\"/>");
      out.write("<span class=\"caret\"/>");
      out.write("</a>");
      out.write("<div aria-hidden=\"true\" aria-labelledby=\"myModalLabel\" role=\"dialog\" tabindex=\"-1\" class=\"modal hide fade\" id=\"new_card\">");
      out.write("<div class=\"modal-header\">");
      out.write("<button aria-hidden=\"true\" data-dismiss=\"modal\" class=\"close\" type=\"button\">");
      out.write('×');
      out.write("</button>");
      out.write("<h3 id=\"myModalLabel\">");
      out.write("Modal header");
      out.write("</h3>");
      out.write("</div>");
      out.write("<div class=\"modal-body\">");
      out.write("<input style=\"width:525px;height:55px;\" type=\"text\"/>");
      out.write("</div>");
      out.write("<div class=\"modal-footer\">");
      out.write("<button aria-hidden=\"true\" data-dismiss=\"modal\" class=\"btn\">");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t关闭");
      out.write("</button>");
      out.write("<button class=\"btn btn-primary\">");
      out.write('保');
      out.write('存');
      out.write("</button>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("<div class=\"btn-group\">");
      out.write("<a style=\"width:65px;\" href=\"#\" data-toggle=\"dropdown\" class=\"btn dropdown-toggle\">");
      out.write("<span style=\"margin:3px 10px;\">");
      out.write('更');
      out.write('多');
      out.write("</span>");
      out.write("<span class=\"caret\"/>");
      out.write("</a>");
      out.write("<ul class=\"dropdown-menu\">");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write("删除联系人");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write("合并联系人");
      out.write("</a>");
      out.write("</li>");
      out.write("<li class=\"divider\"/>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write("导入...");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write("导出...");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write("查找并合并重复项");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write("还原通讯录");
      out.write("</a>");
      out.write("</li>");
      out.write("<li class=\"divider\"/>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write('名');
      out.write('字');
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a href=\"#\" tabindex=\"-1\">");
      out.write('姓');
      out.write('氏');
      out.write("</a>");
      out.write("</li>");
      out.write("</ul>");
      out.write("</div>");
      out.write("<div style=\"float:right;\" class=\"btn-group\">");
      out.write("<a style=\"width:20px;height:20px;\" href=\"#\" data-toggle=\"dropdown\" class=\"btn dropdown-toggle\">");
      out.write("<i class=\"icon-chevron-left\">");
      out.write("</i>");
      out.write("</a>");
      out.write("<a style=\"width:25px;height:20px;\" href=\"#\" data-toggle=\"dropdown\" class=\"btn dropdown-toggle\">");
      out.write("<i class=\"icon-chevron-right\">");
      out.write("</i>");
      out.write("</a>");
      out.write("</div>");
      out.write("<div style=\"float:right;\" class=\"btn-group\">");
      out.write("<div>");
      out.write("<b>");
      out.write("zhang");
      out.write("</b>");
      out.write(" \"-\" ");
      out.write("<b>");
      out.write("test");
      out.write("</b>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_005fmessage_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f0.setParent(null);
    // /WEB-INF/views/index.jspx(7,24) name = htmlEscape type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setHtmlEscape("false");
    // /WEB-INF/views/index.jspx(7,24) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setCode("application_name");
    // /WEB-INF/views/index.jspx(7,24) name = var type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setVar("app_name");
    int[] _jspx_push_body_count_spring_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f0 = _jspx_th_spring_005fmessage_005f0.doStartTag();
      if (_jspx_th_spring_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f1 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005farguments_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f1.setParent(null);
    // /WEB-INF/views/index.jspx(9,48) name = htmlEscape type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setHtmlEscape("false");
    // /WEB-INF/views/index.jspx(9,48) name = arguments type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setArguments((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${app_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/views/index.jspx(9,48) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setCode("welcome_titlepane");
    // /WEB-INF/views/index.jspx(9,48) name = var type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setVar("title");
    int[] _jspx_push_body_count_spring_005fmessage_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f1 = _jspx_th_spring_005fmessage_005f1.doStartTag();
      if (_jspx_th_spring_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f1.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fvar_005fhtmlEscape_005fcode_005farguments_005fnobody.reuse(_jspx_th_spring_005fmessage_005f1);
    }
    return false;
  }
}
