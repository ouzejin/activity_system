package cn.edu.lingnan.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagExample1 extends TagSupport {


	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println("Hello Tag 201906");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;//�ӹ���ǩ��
	}
	

	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;//����ִ������Ķ���
	}
	
		
	
}
