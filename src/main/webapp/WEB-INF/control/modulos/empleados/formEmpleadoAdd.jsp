<%@ include file="/WEB-INF/control/includes.jsp" %>

<html>
<head>
 <title>Registro</title>

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
                            <c:url var="saveEmpleadoUrl" value="saveEmpleado.html" />

                                <form:form   modelAttribute="empleadoInsertar" method="POST"  action="${saveEmpleadoUrl}" >    
                                <table  width="100%" class="myform">
                                    <tr><th colspan="2"  class="showtitle1"  >.::REGISTRO DE EMPLEADO::.</th></tr>
              
                                        <tr>
                                        <td class="mylabel">dni: </td>
                                        <td>: 
                                            <form:input  path="dni" maxlength="8" id="dni" cssClass="myinput"  size="8" /> 
                                        </td>
                                        </tr>
                                        <tr>
                                        <td class="mylabel">Nombres: </td>
                                        <td>: 
                                            <form:input path="nombre" maxlength="20" id="nombre" cssClass="myinput"  size="20" /> 
                                        </td>
                                        </tr>
                                        <tr>
                                        <td class="mylabel">Apellido Paterno: </td>
                                        <td>: 
                                            <form:input path="apPaterno" maxlength="20" id="apPaterno" cssClass="myinput"  size="20" /> 
                                        </td>
                                        </tr>
                                        <tr>
                                        <td class="mylabel">Apellido Materno: </td>
                                        <td>: 
                                            <form:input path="apMaterno" maxlength="20" id="apMaterno" cssClass="myinput"  size="20" /> 
                                        </td>
                                        </tr>
                                        
                                         <tr>
                                        <td class="mylabel">Celular: </td>
                                        <td>: 
                                            <form:input path="celular" maxlength="9" id="celular" cssClass="myinput"  size="9" /> 
                                        </td>
                                        </tr>
                                        
                                       <tr>
                                            
                                        <td class="mylabel">Rol: </td>
                                        <td>: 
                                            <form:select path="idRol.idRol" cssClass="myinput"  > 
                                                <c:forEach  items="${roles}" var="r">
                                                    <form:option value="${r.idRol}"><c:out  value="${r.nombreRol}"/></form:option>
                                                                                                          
                                                </c:forEach>
                                            </form:select>
                                              
                                        </td>
                                        
                                       
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Usuario: </td>
                                        <td>: 
                                            <form:input path="usuario" maxlength="20" id="usuario" cssClass="myinput"  size="20" /> 
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Password: </td>
                                        <td>: 
                                            <form:input path="password" maxlength="20" id="password" cssClass="myinput"  size="20" /> 
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td class="mylabel">Estado: </td>
                                        <td>: 
                                            <form:select path="estado" cssClass="myinput"  >                         
                                            <form:option value="1">Activo </form:option>
                                            <form:option value="0">Inactivo</form:option>
                                            
                                            </form:select>

                                        </td>
                                        </tr>
                                        
                                        <tr>
                                            <td align="center" colspan="2">            
                                                <input  type="submit"  class="button2" value="Guardar" >&nbsp;
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

