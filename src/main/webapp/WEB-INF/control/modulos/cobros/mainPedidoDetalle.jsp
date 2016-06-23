<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 


<%String strRootPath = request.getContextPath();%>
<body class="body" style="background:#ffffff "  >

    
<%=f_table_head_modules(100)%>

<div  id="datagrid"   align="center">


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
                    
                            <a href="#" onclick='displayMessage("mainTipoComp.html?idPed=${idPedido}","boxmessage");return false' ><input  type="button"  class="button2" value="Cobrar" /></a>&nbsp;
                            <a href="mainMesaPedido.html"><input  type="button"  class="button2" value="Regresar" /></a>
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
                                    
                                    
                                    
                                </tr>   
            
                            <c:set var="i" value="${i+1}"/>              
    
                            </c:forEach>    
                                
                        </tbody>
                        
                        
                    </table>
                </td>
        
            </tr>
           
                <c:set value="${idPedido}" var="idp"></c:set>
            
            
           
        </table>
       
    </div>
  
     
    
</div>
       
<%=f_table_foot_modules()%>

<script type="text/javascript">
messageObj = new DHTML_modalMessage();	// We only create one object of this class
messageObj.setShadowOffset(5);	// Large shadow

function displayMessage(url){
	messageObj.setSource(url);
	messageObj.setCssClassMessageBox(false);
	messageObj.setSize(400,250);
	messageObj.setShadowDivVisible(false);	// Enable shadow for these boxes
	messageObj.display();

}

function closeMessage(){messageObj.close();  }


</script>
</body>



