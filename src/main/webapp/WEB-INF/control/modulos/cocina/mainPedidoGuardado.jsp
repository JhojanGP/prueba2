<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 


<%String strRootPath = request.getContextPath();%>
<body class="body" style="background:#ffffff "  >

    
<%=f_table_head_modules(100)%>

<div  id="datagrid"   align="center">


    <div  id="divReporte"  align="center">
        <form  id="formBuscar" action="saveOrden.html"  name="formBuscar"  method="POST" >
        <table class="myform" width="98%" id="demoTable" >
            <tr>

                <td width="70%" colspan="2">
                    
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
                                    
                                </tr> 
                                <c:set value="${dp.idPedido.estado}" var="est"></c:set>
                                <c:set value="${dp.idPedido.idPedido}" var="idPed"></c:set>
                                <c:set value="${dp.idPedido.idEmpleado.idEmpleado}" var="idEmpl"></c:set>
                                <c:set value="${dp.idPedido.idMesa.idMesa}" var="idMesa"></c:set>
                            <c:set var="i" value="${i+1}"/>              
    
                            </c:forEach>    
                                
                                
                                
                        </tbody>
                        
                        
                    </table>
                </td>
        
            </tr>
           
                
            <tr>
                <td>
                    <c:if test="${est==0}">
                        <input type="radio" name="estado" checked="checked" value="0" onChange="this.form.submit()">Recibido
                        <input type="radio" name="estado" value="1" onChange="this.form.submit()"> En preparacion
                        <input type="radio" name="estado" value="2" onChange="this.form.submit()"> Terminado
                    
                       <td><img title="RECIBIDO" src="<%=strRootPath%>/resources/imagen/icons/Led_círculo_rojo.png"></td>
                    </c:if>
                    <c:if test="${est==1}">
                        <input type="radio" name="estado" value="0" onChange="this.form.submit()">Recibido
                        <input type="radio" name="estado" value="1" checked="checked"  onChange="this.form.submit()"> En preparacion
                        <input type="radio" name="estado" value="2" onChange="this.form.submit()"> Terminado
                    
                       <td><img title="EN PREPARACION" src="<%=strRootPath%>/resources/imagen/icons/Led_círculo_amarillo.png"></td>
                    </c:if>
                    <c:if test="${est==2}">
                        <input type="radio" name="estado" value="0" onChange="this.form.submit()">Recibido
                        <input type="radio" name="estado" value="1" onChange="this.form.submit()"> En preparacion
                        <input type="radio" name="estado" value="2" checked="checked" onChange="this.form.submit()"> Terminado
                    
                       <td><img title="LISTO" src="<%=strRootPath%>/resources/imagen/icons/Led_círculo_verde.png"></td>
                    </c:if>
                </td>
                
                    <input type="hidden" name="idPed" value="${idPed}" />
                    <input type="hidden" name="idEmpl" value="${idEmpl}" />
                    <input type="hidden" name="idMesa" value="${idMesa}" />
             
               
            </tr>
            

        </table>
       </form>
    </div>
  
     
    
</div>
       
<%=f_table_foot_modules()%>

</body>

<script type="text/javascript">
messageObj = new DHTML_modalMessage();	// We only create one object of this class
messageObj.setShadowOffset(5);	// Large shadow

function displayMessage(url){
	messageObj.setSource(url);
	messageObj.setCssClassMessageBox(false);
	messageObj.setSize(300,250);
	messageObj.setShadowDivVisible(false);	// Enable shadow for these boxes
	messageObj.display();

}

function closeMessage(){messageObj.close();  }


</script>

