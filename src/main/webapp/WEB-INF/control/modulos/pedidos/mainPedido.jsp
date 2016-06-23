<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 

<%String strRootPath = request.getContextPath();%>


<body class="body" style="background:#ffffff "  > 
    
    

    
<%=f_table_head_modules(100)%>

<div  id="datagrid"   align="center">
    

    <table >
        <c:if  test="${empty pedidoX}">
        <tr >
            <td>
                Mesa 
            </td>
            <td>
                <H1 style="" >#<c:out value="${numeroMesa}"></c:out></H1>
            </td>
        </tr>
        </c:if>
        <c:if  test="${!empty pedidoX}">
            <c:forEach items="${pedidoX}" var="pX">
        <tr >
            <td>
                
                Mesa 
            </td>
            <td>
                <H1 >#<c:out value="${pX.idPedido.idMesa.numero}"></c:out></H1>
            </td>
        </tr>
        
        </c:forEach>
        </c:if>
    </table>
   
    
    <div id="idFormulario" align="center">
       
        <table align="center" width="40%" class="myform">
            <tr > <th class="showtitle1" >CATEGORIAS</th></tr>
        </table>
   
        <table align="center" width="70%" class="myform">
       

            &nbsp;&nbsp;
                <c:if  test="${empty pedidoX}">
        
                    <c:forEach items="${pedido}" var="pe">
        
                        <c:set value="${pe.idPedido}" var="p"></c:set>
                        <c:set value="${pe.idMesa.idMesa}" var="m"></c:set>
                        <c:set value="${empleadoId}" var="u"></c:set>
                        <c:set value="${pe.idMesa.numero}" var="n"></c:set>
                        
                        
        
                    </c:forEach>
                    
                    
                  <c:set value="0" var="c"></c:set>
                    
                        <c:forEach items="${nroCol}" var="col">
                            
                            <tr>

                            <c:forEach items="${categorias}" var="cat">
                            
                            
                                <c:if test="${cat.idCategoria<=col&&cat.idCategoria>c}">
                                <td>
                    
                                    <a href="#" onclick='displayMessage("formMenu.html?idCategoria=${cat.idCategoria}&idpedido2=${p}&idmes=${m}&user=${u}","boxmessage");return false' >
                                    <c:out value="${cat.nombre}"></c:out>
                                    </a>
                    
                                </td>
                            </c:if>
                                
                            
                            </c:forEach>
                            </tr>
                            <c:set var="c" value="${col}"></c:set>
                            
                        </c:forEach> 

                                
                                <tr>
                                    <td align="center" colspan="4">            
                            
                                        <a href="mainMesa.html?idMes=${m}&idPed=${p}"><input  type="button"  class="button2" value="Anular" /></a>
                                    </td>
                                </tr>


                    

                
                </c:if>
                <c:if  test="${!empty pedidoX}">
         
                    <c:forEach items="${pedidoX}" var="pX">
                        
                             <c:set value="0" var="c"></c:set>
                    
                        <c:forEach items="${nroCol}" var="col">
                            
                            <tr>

                            <c:forEach items="${categorias}" var="cat">
                            
                            
                                <c:if test="${cat.idCategoria<=col&&cat.idCategoria>c}">
                                <td>
                    
                                    <a href="#" onclick='displayMessage("formMenu.html?idCategoria=${cat.idCategoria}&idpedido2=${pX.idPedido.idPedido}&idmes=${pX.idPedido.idMesa.idMesa}&user=${pX.idPedido.idEmpleado.idEmpleado}","boxmessage");return false' >
                                    <c:out value="${cat.nombre}"></c:out>
                                    </a>
                    
                                </td>
                            </c:if>
                                
                            
                            </c:forEach>
                            </tr>
                            <c:set var="c" value="${col}"></c:set>
                        </c:forEach> 
                
                   
                    </c:forEach>

            </tr>

        </table>
   
    </div>
                    <c:if test="${!empty alerta}">
                    <div>
                        <table>
                            
                            <tr>
                                <td>
                                    <script type="text/javascript">
                                        alert('<c:out value="${alerta}"></c:out>');
                                    </script>
                                </td>
                            </tr>
                            
                        </table>
                    </div>
</c:if>
    <div  id="divReporte"  align="center">
        <table class="myform" width="98%" id="demoTable" >
            <tr>
                <td width="30%">      
                    <table align="center" width="98%" class="myform">
                        <tr > <th class="showtitle1" >A PAGAR</th></tr>
                        
                    </table>

                    <table align="center" width="98%" class="myform">
                    <tr>
                        <td>
                            <c:forEach items="${pedidoX}" var="total">
                                S/. <fmt:formatNumber type="number" minFractionDigits="1" maxFractionDigits="1"
                                                  value="${total.total}">
                                    </fmt:formatNumber>0
                            <c:set var="idPedido" value="${total.idPedido.idPedido}"></c:set>
                            <c:set var="idMesa" value="${total.idPedido.idMesa.idMesa}"></c:set>
                            </c:forEach>
                        </td>
                    </tr>
                    
                    <tr>
                        <td align="center" colspan="2">            
                            <a href="mainMesa.html?idPed" onclick="return confirm('Pedido Guardado')"><input  type="button"  class="button2" value="Guardar" /></a>&nbsp;
                            <a href="mainMesa.html?idMes=${idMesa}&idPed=${idPedido}"><input  type="button"  class="button2" value="Anular" /></a>
                        </td>
                    </tr>
                    </table>
       
                </td>
                <td width="70%">
                    
                    <table width="98%" class="myform" style="margin-top:10px;"  >
                        <th  class="showtitle1">
                            <b><samp> DETALLE DEL PEDIDO </samp></b>
                        </th>
                 
                    </table>
    
                    <table  class="myform" width="98%" id="demoTable"   >
        
                        <thead>
                            <tr>
                                <th >#</th>
                                <th >Tipo </th>
                                <th >Producto </th>
                                <th >Cantidad </th>
                                <th >Precio x unidad</th>
                                <th >Importe</th>
                                <th >Accion</th>
                
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="i" value="1" />   
    
                            <c:forEach items="${pedido_detalle}" var="dp">        
                                <tr>
                                    <td><c:out  value="${i}"/></td>
                                    
                                    <td><c:out value="${dp.idProducto.idCategoria.nombre}"/></td>
                                    <td><c:out value="${dp.idProducto.nombre}"/></td>
                                    <td><c:out value="${dp.cantidadProducto}"/></td>
                                    <td>S/. <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                      value="${dp.idProducto.precio}">
                                            </fmt:formatNumber></td>
                                    <td>S/. <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                      value="${dp.cantidadProducto*dp.idProducto.precio}">
                                            </fmt:formatNumber></td>
                                    
                                    <td>
                                        <a href="addEdit.html?idPedidoDetalle=${dp.idPedidoDetalle}" ><img title="+1" src="<%=strRootPath%>/resources/imagen/icons/add2.gif"></a>
                                    <c:if test="${dp.cantidadProducto>1}">
                                        <a href="substractEdit.html?idPedidoDetalle=${dp.idPedidoDetalle}"><img title="-1" src="<%=strRootPath%>/resources/imagen/icons/desactivo.gif"></a>
                                    </c:if>    
                                        <a href="deletePD.html?idPedidoDetalle=${dp.idPedidoDetalle}" ><img title="Borrar" src="<%=strRootPath%>/resources/imagen/icons/detele.gif"> </a>
                                    </td>
                                    
                                </tr>   
            
                            <c:set var="i" value="${i+1}"/>              
    
                            </c:forEach>    
    
                        </tbody>

                    </table>
                </td>
        
            </tr>
        </table>
       
    </div>
  
     
    
</div>
       
<%=f_table_foot_modules()%>
</c:if>
</body>

<script type="text/javascript">
messageObj = new DHTML_modalMessage();	// We only create one object of this class
messageObj.setShadowOffset(5);	// Large shadow

function displayMessage(url){
	messageObj.setSource(url);
	messageObj.setCssClassMessageBox(false);
	messageObj.setSize(500,350);
	messageObj.setShadowDivVisible(false);	// Enable shadow for these boxes
	messageObj.display();

}

function closeMessage(){messageObj.close();  }


</script>

