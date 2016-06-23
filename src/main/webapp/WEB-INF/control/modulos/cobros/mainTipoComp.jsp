<%@ include file="/WEB-INF/control/includes.jsp" %>
<html>
<head>
 <title>Comprobante</title>


 <script type="text/javascript">
function mostrar(id) {

    if (id == "1") {
        $("#factura").show();
        $("#boleta").hide();
    }

    if (id == "2") {
        $("#factura").hide();
        $("#boleta").show();
    }
    
    if (id == "3") {
        $("#factura").hide();
        $("#boleta").hide();
    }
    
    if (id == "4"){
        $("#efectivo").show();
        $("#tarjeta").hide();
    }
    if (id == "5"){
        $("#efectivo").hide();
        $("#tarjeta").show();
    }
    
    if (id == "6"){
        $("#efectivo").hide();
        $("#tarjeta").hide();
    }

}
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
                            <c:url var="mainComprobanteUrl" value="mainComprobante.html" />

                            <form:form   modelAttribute="cajaRegistroInsertar" target="_blank" method="POST"  action="${mainComprobanteUrl}" >    
                                <table  width="100%" class="myform">
                                    <tr><th colspan="2"  class="showtitle1"  >.::A Pagar::.</th></tr>
                                        <tr>
                                            <td class="mylabel">Tipo de pago: </td>
                                            <td>:
                                                <form:select path="idComprobante" onchange="mostrar(this.value);" cssClass="myinput">
                                                    <form:option value="6" selected="selected">Selecciona.....</form:option>
                                                    <form:option value="4">Efectivo</form:option>
                                                    <form:option value="5">Tarjeta</form:option>
                                                </form:select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div id="efectivo" style="display: none">
                                                    <table width="100%" class="myform">
                                                        <tr>
                                                            <td class="mylabel">Cantidad: </td>
                                                            <td><input class="myinput" type="text" size="5" maxlength="5" name="efectivo" autocomplete="off"></td>
                                                        </tr>   
                                                    </table>
                                                </div>
                                                <div id="tarjeta" style="display: none">
                                                    <table width="100%" class="myform">
                                                        <tr>
                                                            <td class="mylabel">Nro. de tarjeta: </td>
                                                            <td><input class="myinput" type="text" size="4" maxlength="4" name="tarjeta1"></td>
                                                            <td><input class="myinput" type="text" size="4" maxlength="4" name="tarjeta2"></td>
                                                            <td><input class="myinput" type="text" size="4" maxlength="4" name="tarjeta3"></td>
                                                            <td><input class="myinput" type="text" size="4" maxlength="4" name="tarjeta4"></td>
                                                        </tr>   
                                                    </table>
                                                </div>
                                            </td>    
                                        </tr>
                                        <tr>
                                            <td class="mylabel">Tipo de comprobante: </td>
                                            <td>: 
                                                <form:select  path="idComprobante.idComprobante" cssClass="myinput" id="status" name="status" onchange="mostrar(this.value);"   > 
                                                    <form:option value="3" selected="selected"  >Selecciona.....</form:option>
                                                    <c:forEach  items="${comprobantes}" var="com">
                                                        <form:option value="${com.idComprobante}"><c:out  value="${com.tipo}"/></form:option>
                                                            <c:if test="${com.idComprobante==1}">
                                                                <c:set value="${com.igv}" var="igv"></c:set>
                                                                <c:set value="${com.nro}" var="nroC1"></c:set>
                                                                

                                                                
                                                            </c:if>
                                                            <c:if test="${com.idComprobante==2}">
                                                                <c:set value="${com.nro}" var="nroC2"></c:set>
                                                                
       
                                                            </c:if>
                                                            
                                                            
                                                        <c:set value="${com.ruc}" var="ruc"></c:set>
                                                        
                                                    </c:forEach>
                                                </form:select>

                                            </td>

                                        </tr>
                                        
                                        
                                        <tr>
                                            <td colspan="2">
                                                <div id="factura" style="display: none">
                                                
                                                    <table width="100%" class="myform">
                                                        
                                                        <th  class="showtitle1">
                                                            <b><samp> FACTURA </samp></b>
                                                        </th>
                                                        
                                                    </table>
                                                    <table class="myform" width="100%" id="demoTable"  >
                                                        <tr>
                                                            <td class="mylabel">Nombre o razon social: </td>

                                                        <td >
                                                            
                                                            <input type="text" maxlength="20" name="nombreCliente" class="myinput" list="clientes" size="20" autocomplete="off" /> 
                                                            <datalist id="clientes" >

                                                                <c:forEach items="${clientes}" var="cle">
                                                                    
                                                                    <option  value="${cle.nombre}"><c:out value="${cle.nombre}"></c:out></option>
                                                                </c:forEach>
                                  
                                                                    
                                                            </datalist>
                                                                
                                                        </td>  
                                                        </tr>
                                                        <tr>
                                                            <td class="mylabel">R.U.C.: </td>
                                                            <td>
                                                                <input type="text" maxlength="11" name="documento" class="myinput"  size="11" autocomplete="off">
                                                                
                                                            </td>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <td class="mylabel">Direccion: </td>
                                                            <td>
                                                                <input type="text" maxlength="50" name="direccion" class="myinput"  size="20" autocomplete="off">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    

                                                    </div>
                                                <%--
                                                    <div id="boleta" style="display: none;">
                                                
                                                        <table width="100%" class="myform">
                                                        
                                                            <th  class="showtitle1">
                                                                <b><samp> BOLETA </samp></b>
                                                            </th>
                                                        
                                                        </table>
                                                        <table class="myform" width="100%" id="demoTable"  >
                                                            
                                                        </table>
                                                    </div>
                                                --%>
                                            </td>
                                        
                                        </tr>

                                        <tr>
                                            <c:forEach items="${pedido}" var="p">
                                                <c:set value="${p.idPedido}" var="pedido"></c:set>
                                            </c:forEach>
                                            <td align="center" colspan="2"> 
                                                <input type="hidden" name="idPd" value="${pedido}" />
                                                <input type="hidden" name="igv" value="${igv}" />
                                                <input type="hidden" name="ruc" value="${ruc}" />
                                                <input type="hidden" name="nroC1" value="${nroC1}" />
                                                <input type="hidden" name="nroC2" value="${nroC2}" />
                                                <input type="hidden" name="usuario" value="${empleadoId}" />
                                                
                                                <input  type="submit"  class="button2" value="Enviar" >&nbsp;
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