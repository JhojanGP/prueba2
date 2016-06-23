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
                            
                            <form:form name="formUpdate"  method="POST"  action="updateCliente.html" >
                                
                                    <table border="0" align="center" width="100%" class="myform">
                                        <tr><th colspan="2"  class="showtitle1"  >.::MODIFICAR CLIENTE::.</th></tr>
                                        
                                        <c:forEach  items="${cliente}" var="acc" >
                                        
                                        
                                        <tr>
                                        <td class="mylabel">Nombre::</td>
                                        <td> 
                                            <input type="text" name="nombre" value="${acc.nombre}" Class="myinput" size="30" maxlength="30"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Documento::</td>
                                        <td> 
                                            <input type="text" name="documento" value="${acc.documento}" Class="myinput" size="11" maxlength="11"/>
                                        </td>
                                        </tr> 
                                        
                                        <tr>
                                        <td class="mylabel">Telefono::</td>
                                        <td> 
                                            <input type="text" name="telefono" value="${acc.telefonos}" Class="myinput" size="9" maxlength="9"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Direccion::</td>
                                        <td> 
                                            <input type="text" name="direccion" value="${acc.direccion}" Class="myinput" size="40" maxlength="40"/>
                                        </td>
                                        </tr> 
                                        
                                        
                                        <tr>
                                                <td colspan="2"  align="center" >    
                                                    <input type="hidden" name="idCliente" value="${acc.idCliente}" />
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

