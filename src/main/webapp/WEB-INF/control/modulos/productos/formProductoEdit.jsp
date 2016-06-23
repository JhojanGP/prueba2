<%@ include file="/WEB-INF/control/includes.jsp" %>
<html>
<head>
 <title>Edicion</title>

 
 
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
                
                   <div class="inner" align="center"  >
                       
                    <table border="0" style="margin: 4px"   >
                        
                            
                        
                        <td colspan="1" align="left"  >
                            
                            <form:form name="formUpdate"  method="POST"  action="updateProducto.html" >
                                
                                    <table border="0" align="center" width="100%" class="myform">
                                        <tr><th colspan="2"  class="showtitle1"  >.::MODIFICAR PRODUCTO::.</th></tr>
                                        
                                        <c:forEach  items="${producto}" var="acc" >
                                        
                                        
                                        <tr>
                                            <td class="mylabel">Nombre::</td>
                                            <td><input type="text" name="nombre" value="${acc.nombre}" Class="myinput" size="20" maxlength="20"/></td>
                                        </tr>
                                        
                                       <tr>
                                            <td>Categoria:</td>
                                            <td>
                                            
                                            <select name="idCategoria" class="myinputs"  > 
                                                <c:forEach items="${categorias}" var="c">
                                                    <c:if test="${c.idCategoria==acc.idCategoria.idCategoria}">
                                                        <option value="${c.idCategoria}" selected="selected"><c:out  value="${c.nombre}"/></option>
                                                    </c:if>
                                                    <c:if test="${c.idCategoria!=acc.idCategoria.idCategoria}">
                                                    <option value="${c.idCategoria}"><c:out  value="${c.nombre}"/></option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </tr>
                                        
                                        <tr>
                                            <td class="mylabel">Precio (S/.)::</td>
                                            <td><input type="text" name="precio" value="${acc.precio}" Class="myinput" size="20" maxlength="20"/></td>
                                        </tr>
                                        
                                     <tr>
                                                <td colspan="2"  align="center" >    
                                                    <input type="hidden" name="idProducto" value="${acc.idProducto}" />
                                                    <input type="hidden" name="idCategoria" value="${acc.idCategoria}" />
                                                    <input type="submit" value="Guardar" class="button2" />&nbsp;&nbsp;
                                                    <input type="button" value="Cancelar" class="button2" onclick="closeMessage()"/>
                                                </td>
                                     </tr>
                                     </c:forEach>
                                     </table>
                                </form:form> 
                            
                        </td>
                        
                         
                        </table>
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

