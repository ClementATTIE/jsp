<%-- 
    Document   : mainjsp
    Created on : 6 nov. 2019, 14:06:55
    Author     : pedago
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    			<style>
				.table
				{
					display:table;
					border-collapse:separate;
					border-spacing:2px;
				}
				.thead
				{
					display:table-header-group;
					color:white;
					font-weight:bold;
					background-color:grey;
				}
				.tbody
				{
					display:table-row-group;
				}
				.tr
				{
					display:table-row;
				}
				.td
				{
					display:table-cell;
					border:1px solid black;
					padding:1px;
				}			
		</style>		
	</head>
	<body>
		<!-- On montre le formulaire de saisie -->
		<h1>Edition des taux de remise</h1>
		<form method='GET'>
			Code : <input name="code" size="1" maxlength="1" pattern="[A-Z]{1}+" title="Une lettre en MAJUSCULES"><br/>
			Taux : <input name="taux" type="number" step="0.01" min="0.0" max="99.99" size="5"><br/>
			<input type="hidden" name="action" value="ADD">
			<input type="submit" value="Ajouter">
		</form>
		
		
		
		<div class="table">
			<div class="thead"><div class="td">Code</div><div class="td">Taux</div><div class="td">Action</div></div>
			
                                
                        
                        
                             <c:forEach var="DISCOUNT_CODE" items="${CODE}" >
                                
                                <form class="tr" method="get">
					<div class="td"><input type="text" name="code" value=${DISCOUNT_CODE.code} readonly/></div>
					<div class="td"><input name="taux" type="number" value=${DISCOUNT_CODE.taux} step="0.01" min="0.0" max="99.99" size="5" /></div>
					<div class="td"><input type="submit" name="action" value="DELETE"/></div>
				</form>	  
                                        
                               </c:forEach>
                                        

			
 		    
			
 		    
			  
			</div>
		</div>
	</body>        

</html>
