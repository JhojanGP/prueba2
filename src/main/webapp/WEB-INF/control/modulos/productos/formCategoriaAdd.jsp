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
                            <c:url var="saveCategoriaUrl" value="saveCategoria.html" />

                                <form:form   modelAttribute="categoriaInsertar" method="POST"  action="${saveCategoriaUrl}" >    
                                <table  width="100%" class="myform">
                                    <tr><th colspan="2"  class="showtitle1"  >.::REGISTRO DE CATEGORIAS::.</th></tr>
                                        
                                        <tr>
                                        <td class="mylabel">Nombre: </td>
                                        <td class="Freeze">: 
                                            <form:input path="nombre" maxlength="20" id="nombre" cssClass="myinput"  size="20" /> 
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

