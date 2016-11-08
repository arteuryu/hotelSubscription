<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.paic.elis.elis_smp_cms.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page import="com.paic.elis.elis_smp_cms.common.util.PropertiesUtils" %>
<%
	String allowHeader  = PropertiesUtils.getPropertyValues("elis.smp.cms.url");
    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	response.addHeader("Access-Control-Allow-Origin", allowHeader);
	response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,X_Requested_With");
	//String rootPath = application.getResource( "/" ).toString().substring(5);
	String rootPath = application.getRealPath( "/" ).toString();
	//out.write(rootPath);
	//String rootPath = application.getRealPath( "/" );
	out.write( new ActionEnter( request, rootPath ).exec() );
%>