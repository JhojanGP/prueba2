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
    
    

   
    <div  id="divReporte" align >
        
    <table   border ="0" width="100%"    >
        
        <tbody>
        
        <c:set var="i" value="0" /> 
   
        <c:forEach items="${Nmesa}" var="M">
           
        <tr>
            
            <c:forEach items="${resultadoBMesa}" var="resP">        
                <c:if test="${resP.numero>i&&resP.numero<=i+4}">
                    <c:if test="${resP.estado==1}">
                        <td >
                            
                        </td>    
                        <td  >
                            <a  href="mainPedido.html?idMesa=${resP.idMesa}&usuario=${empleadoId}&numero=${resP.numero}" >
                                <div id="Etiqueta" align="center">
                                    <img src="<%=strRootPath%>/resources/imagen/img/mesaL.png" />
                                    
                                        <div class="Etiquetax" style="color:#ffffff;">
                                            <p>Mesa <c:out value="${resP.numero}"></c:out></p>
                                        </div>
                                </div>
                            </a>
                        
                        </td>

                    </c:if>

                    <c:if test="${resP.estado==0}">
                        <td >
                            
                            <a href="mainMesa.html?idMesaU=${resP.idMesa}&numero=${resP.numero}" ><img title="Liberar" src="<%=strRootPath%>/resources/imagen/img/liberarM_1.png"></a>
                        </td>
                        <td >
                                <div id="Etiqueta" align="center">
                                    
                                    <img src="<%=strRootPath%>/resources/imagen/img/mesaO.png" />
                                    
                                        <div class="Etiquetax" style="color:#ffffff;">
                                            <p>Mesa <c:out value="${resP.numero}"></c:out></p>
                                            
                                        </div>
                                            
                                </div>
                            
                            
                        </td>
                        
                    
                    </c:if>
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



