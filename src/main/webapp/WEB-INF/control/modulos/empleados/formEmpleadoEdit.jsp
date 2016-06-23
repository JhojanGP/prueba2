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
                            
                            <form:form name="formUpdate"  method="POST"  action="updateEmpleado.html" >
                                
                                    <table border="0" align="center" width="100%" class="myform">
                                        <tr><th colspan="2"  class="showtitle1"  >.::MODIFICAR EMPLEADO::.</th></tr>
                                        
                                        <c:forEach  items="${empleado}" var="acc" >
                                        
                                        
                                        <tr>
                                        <td class="mylabel">dni::</td>
                                        <td> 
                                            <input type="text" name="dni" value="${acc.dni}" Class="myinput" size="8" maxlength="8"/>
                                        </td>
                                        </tr>    
                                            
                                        <tr>
                                            <td class="mylabel">Nombres::</td>
                                            <td><input type="text" name="nombre" value="${acc.nombre}" Class="myinput" size="20" maxlength="20"/></td>
                                        </tr>
                                        
                                        <tr>
                                            <td class="mylabel">Apellido Paterno::</td>
                                            <td><input type="text" name="apPaterno" value="${acc.apPaterno}" Class="myinput" size="20" maxlength="20"/></td>
                                        </tr>
                                        
                                        <tr>
                                            <td class="mylabel">Apellido Materno::</td>
                                            <td><input type="text" name="apMaterno" value="${acc.apMaterno}" Class="myinput" size="20" maxlength="20"/></td>
                                        </tr>
                                        
                                        <tr>
                                            <td class="mylabel">Celular::</td>
                                            <td><input type="text" name="celular" value="${acc.celular}" Class="myinput" size="9" maxlength="9"/></td>
                                        </tr>
                                        
                                        <tr>
                                            <td class="mylabel">Usuario::</td>
                                            <td><input type="text" name="usuario" value="${acc.usuario}" Class="myinput" size="20" maxlength="20"/></td>
                                        </tr>
                                        
                                        <tr>
                                            <td class="mylabel">Password::</td>
                                            <td><input type="password" name="password" value="${pass}" Class="myinput" size="20" maxlength="20"/></td>
                                        </tr>
                                        
                                        
                                        
                                        <tr>
                                            <td class="mylabel">Estado:</td>
                                            <td>
                                            
                                            <select name="estado"> 
                                                <c:forEach items="${estado}" var="e">
                                                    <c:if test="${e==acc.estado}">
                                                        <option value="${e}" selected="selected" >
                                                            <c:if test="${e==1}">
                                                                Activo
                                                            </c:if>
                                                            <c:if test="${e==0}">
                                                                Inactivo
                                                            </c:if></option>
                                                    </c:if>
                                                    <c:if test="${e!=acc.estado}">
                                                        <option value="${e}"  class="myinputs">
                                                            <c:if test="${e==1}">
                                                                Activo
                                                            </c:if>
                                                                <c:if test="${e==0}">
                                                                Inactivo
                                                            </c:if></option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </tr>
                                        <tr>
                                            <td class="mylabel">Rol:</td>
                                            <td>
                                            
                                            <select name="idRol"> 
                                                <c:forEach items="${rol}" var="n">
                                                    <c:if test="${n.idRol==acc.idRol.idRol}">
                                                        <option value="${n.idRol}" selected="selected" >
                                                            <c:if test="${n.idRol==1}">
                                                                Admin
                                                            </c:if>
                                                            <c:if test="${n.idRol==2}">
                                                                Cajero
                                                            </c:if>
                                                                 <c:if test="${n.idRol==3}">
                                                                Mesero
                                                            </c:if>
                                                                 <c:if test="${n.idRol==4}">
                                                                Cocinero
                                                            </c:if>
                                                        </option>
                                                    </c:if>
                                                    <c:if test="${n.idRol!=acc.idRol.idRol}">
                                                        <option value="${n.idRol}"  class="myinputs">
                                                            <c:if test="${n.idRol==1}">
                                                                Admin
                                                            </c:if>
                                                                <c:if test="${n.idRol==2}">
                                                                Cajero
                                                            </c:if>
                                                                 <c:if test="${n.idRol==3}">
                                                                Mesero
                                                            </c:if>
                                                                 <c:if test="${n.idRol==4}">
                                                                Cocinero
                                                            </c:if>
                                                        </option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </tr>
                                        
                                      
                                        
                                     
                                                  
                                     <tr>
                                                <td colspan="2"  align="center" >    
                                                    <input type="hidden" name="idEmpleado" value="${acc.idEmpleado}" />
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

