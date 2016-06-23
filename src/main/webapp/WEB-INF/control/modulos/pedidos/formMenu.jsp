<%@ include file="/WEB-INF/control/includes.jsp" %>
<html>
<head>
 <title>Registro</title>

<script type="text/javascript"  >
    function setFocus(objPositCur){ $("#"+objPositCur).focus();}
</script>
</head>



<body onload="setFocus('username')" >
            <div class="box" >
            <div class="border-right">
            <div class="border-bot">
            <div class="border-left">
            <div class="left-top-corner">
            <div class="right-top-corner">
            <div class="right-bot-corner">
            <div class="left-bot-corner">
                
                   <div class="inner" align="center" >
                       
                    <table border="0" style="margin: 4px" width="98%"  >
     
                                            
                                        <c:forEach items="${ped}" var="pe">
                                            <c:set value="${pe}" var="pd"></c:set>
                                                
                                            </c:forEach>
                                    
                                        <c:forEach items="${m}" var="m1">
                                            <c:set value="${m1}" var="m2"></c:set>
                                                
                                            </c:forEach>
                                        <c:forEach items="${u}" var="u1">
                                            <c:set value="${u1}" var="u2"></c:set>
                                                
                                        </c:forEach>
                                        <c:set value="0" var="var"></c:set>
                                        <c:forEach items="${productos}" var="p">
                                            
                                            <c:if test="${var==0}">
                                                <tr>
                                                    <td colspan="2">
                                                        <table width="98%" class="myform" align="center">
                                                            <tr> <th class="showtitle1" ><c:out value="${p.idCategoria.nombre}"></c:out></th></tr>
                                                        </table>
                                                    </td>
                                                </tr>
                                                
                                            </c:if>
                                                <tr>
                                                    <td >
                                                        <table class="myform" width="98%" id="demoTable" border="0" >
                                                            
                                                                <tr>
                                                                <c:if test="${var==0}">
                                                                    
                                                                    <td>producto</td>
                                                                    <td>precio</td>
                                                                    
                                                                </c:if>
                                                                </tr>    

                                                                <tr>
                                                                    <td width="70%">
                                                                        <a href="savePedido.html?idProducto=${p.idProducto}&idpd=${pd}&idMesa=${m2}&usuario=${u2}"> <c:out value="${p.nombre}"></c:out></a>
                                                                    </td>
                                                                    <td with="30%">
                                                                        S/. <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                                                          value="${p.precio}">
                                                                            </fmt:formatNumber>
                                                                    </td>
                                                                </tr>
                                                        </table>
                                                        
                                                    
                                                    </td >
                                                    
                                                
                                                </tr>
                                            <c:set value="${var+1}" var="var"></c:set>
                                        </c:forEach>
                                            
                                        <tr>
                                            <td align="center" colspan="2">            
                                                <input type="button" value="Cancelar" class="button2" onclick="closeMessage()"/> 
                                            </td>
                                        </tr>
                                            
                                            
                                </table>
   
    
    
                               
    
                        </td>
                        </tr>
                         

                        </div>
                </div>
            </div>
            </div>


            </div>
            </div>
            </div>
            </div>
            </div>

</body>

</html>

