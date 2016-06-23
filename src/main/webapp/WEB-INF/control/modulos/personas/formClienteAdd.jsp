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
                       
                    <table border="0" style="margin: 4px"   >
                        
                        <tr>
                        <td colspan="1" align="left"  >
                            <c:url var="saveClienteUrl" value="saveCliente.html" />

                                <form:form   modelAttribute="clienteInsertar" method="POST"  action="${saveClienteUrl}" >    
                                <table  width="100%" class="myform">
                                    <tr><th colspan="2"  class="showtitle1"  >.::REGISTRO DE CLIENTE::.</th></tr>
                                        
                                        <tr>
                                        <td class="mylabel">Nombre o razon social: </td>
                                        <td>: 
                                            <form:input path="nombre" maxlength="30" id="nombre" cssClass="myinput"  size="30" /> 
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Documento: </td>
                                        <td>: 
                                            <form:input path="documento" maxlength="11" id="documento" cssClass="myinput"  size="11" /> 
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Telefono: </td>
                                        <td>: 
                                            <form:input path="telefonos" maxlength="9" id="telefonos" cssClass="myinput"  size="9" /> 
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Direccion: </td>
                                        <td>: 
                                            <form:input path="direccion" maxlength="40" id="direccion" cssClass="myinput"  size="40" /> 
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                            <td align="center" colspan="2">            
                                                <input  type="submit"  class="button2" value="Guardar"  >&nbsp;
                                                <input type="button" value="Cancelar" class="button2" onclick="closeMessage()"/> 
                                            </td>
                                        </tr>
                                </table>
                                </form:form> 
    
    
                               
    
                        </td>
                        </tr>
                         
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

