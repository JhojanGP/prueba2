<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 


<%String strRootPath = request.getContextPath();%>
<style type="text/css">
    #Etiqueta{float:left;position:relative;}
    #Etiqueta .Etiquetax {width:150px;position:absolute;top:10px;left:10px;}
</style>
<body class="body" style="background:#ffffff "  >

    
<%=f_table_head_modules(100)%>

<div  id="datagrid"   align="center">
    
    

   
    <div  id="divReporte"  >
        
    <table   border ="0" width="100%"    >
        
    <tbody>
        
       <c:set var="i" value="0" /> 
   
        <c:forEach items="${Nmesa}" var="M">
           
        <tr>
              
            
            <c:forEach items="${resultadoBPedido}" var="resP">  
                <c:if test="${resP.idPedido.idMesa.numero>i&&resP.idPedido.idMesa.numero<=i+4}">
                    
                    
      
                    <td  >
                            <a href="mainPedidoGuardado.html?idPedido=${resP.idPedido.idPedido}" >
                                <div id="Etiqueta" align="center">
                                    <c:if test="${resP.idPedido.estado==0}">
                                    <img src="<%=strRootPath%>/resources/imagen/img/mesaO.png" />
                                    </c:if>
                                    <c:if test="${resP.idPedido.estado==1}">
                                    <img src="<%=strRootPath%>/resources/imagen/img/preparando.png" />
                                    </c:if>
                                    <c:if test="${resP.idPedido.estado==2}">
                                    <img src="<%=strRootPath%>/resources/imagen/img/mesaL.png" />
                                    </c:if>
                                    
                                    
                                        <div class="Etiquetax" style="color:#ffffff;">
                                            <p>Mesa <c:out value="${resP.idPedido.idMesa.numero}"></c:out></p>
                                        </div>
                                </div>
                            </a>
                        
                    </td>
 
                </c:if>
            
            
            </c:forEach>
           
        </tr>
        
         <c:set var="i" value="${i+4}"/> 
        </c:forEach>


    </tbody>

    </table>
    </div>
    
     
    
</div>
<%=f_table_foot_modules()%>



</body>



