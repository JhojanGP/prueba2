<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 


<%String strRootPath = request.getContextPath();%>
<body class="body" style="background:#ffffff "  >

    
<%=f_table_head_modules(100)%>

<div style="color: red" id="datagrid"   align="center">
    <div id="idFormulario" align="center">
    <form  id="formBuscar" action="mainEmpleado.html"  name="formBuscar" >
    <table align="center" width="70%" class="myform">
    <tr> <th class="showtitle1" >REPORTE - ADMINISTRACI&Oacute;N DE TRABAJADORES</th></tr>
    <tr align="center">
    &nbsp;&nbsp;
    <td  style="color:black">
    &nbsp;&nbsp;Apellido del Empleado: <input type="text" class="myinput" id="empleadoApellido" size="40" name="empleadoApellido" value="">
    <input type="hidden" value="L" name="opc" id="opc">
    <input  type="submit"  class="button2" value="Buscar" >&nbsp;
    </td>
    </tr>

    </table>
    </form>
    </div>
    
   
    <table>
        <tr>
            <th>
                
                <div>
                    <a href="#" onclick='displayMessage("formEmpleadoAdd.html","boxmessage");return false' ><img title="Nuevo" src="<%=strRootPath%>/resources/imagen/icons/i.gif"></a>
                  
                
                </div>
            </th>
        </tr>
     
    </table>
         


     <c:if  test="${!empty resultadoBEmpleado}">
    <div  id="divReporte"  align="center">
    <table width="98%" class="myform" style="margin-top:10px;"  >
		 <th  class="showtitle1">
			 <b><samp> LISTA DE EMPLEADOS</samp></b>
		 </th>
    </table>
    <table  class="myform" width="98%" id="demoTable"   >
    <thead>
         <tr>
                <th >#</th>
                
                <th >DNI</th>
                <th >Nombres</th>
                <th >Apellido Paterno</th>
                <th >Apellido Materno</th>
                <th >Celular</th>
                <th >Rol</th>
                <th >Estado</th>
                <th >Usuario</th>
                <th >Password</th>
                <th >Accion</th>

          </tr>
    </thead>
    <tbody>

        <c:set var="i" value="1" />   
    
    <c:forEach items="${resultadoBEmpleado}" var="resP">        
        <c:if test="${i%2==1}"> <tr bgcolor="#DAEFFE"></c:if>
        <c:if test="${i%2!=1}"> <tr></c:if>
            
            <td><c:out  value="${i}"/></td>
            <td><c:out value="${resP.dni}"/></td>
            <td><c:out value="${resP.nombre}"/></td>
            <td><c:out value="${resP.apPaterno}"/></td>
            <td><c:out value="${resP.apMaterno}"/></td>
            <td><c:out value="${resP.celular}"/></td>
            <td><c:out value="${resP.idRol.nombreRol}"/></td>

            
            <td><c:choose>
                <c:when test="${resP.estado==1}">Activo</c:when>
                <c:when test="${resP.estado==0}">Inactivo</c:when>
                </c:choose>
            </td>
            
            <td><c:out value="${resP.usuario}"/></td>
            <td><c:out value="${resP.password}"/></td>

            
           
            <td align="center">
                <a href="deleteEmpleado.html?idEmpleado=${resP.idEmpleado}" onclick="return confirm('�Esta seguro de eliminar este empleado?')"><img title="Delete" src="<%=strRootPath%>/resources/imagen/icons/delete.gif"> </a>
                <a href="#" onclick='displayMessage("formEmpleadoEdit.html?idEmpleado=${resP.idEmpleado}","boxmessage");return false' ><img title="Edit" src="<%=strRootPath%>/resources/imagen/icons/editare.gif"></a></td>
                 
            </tr>   
    <c:set var="i" value="${i+1}"/>              
    </c:forEach>    
    
    </tbody>

    <tfoot>
           <tr>
                <td colspan="5">
                <div class="pagination"></div>
                <div class="paginationTitle">P&aacute;gina</div>
                <div class="selectPerPage"></div>
                <div class="status"></div></td>
            </tr>
    </tfoot>

    <script type="text/javascript">
            $('#demoTable').jTPS( {perPages:[20,40,50,60,'Todos'],
                scrollStep:1,scrollDelay:30,
                perPageText:'',
                perPageShowing: 'Listando'
            } );
        </script>
    </table>
    </div>
    </c:if> 
     
    
</div>
<%=f_table_foot_modules()%>
</body>

<script type="text/javascript">
messageObj = new DHTML_modalMessage();	// We only create one object of this class
messageObj.setShadowOffset(5);	// Large shadow

function displayMessage(url){
	messageObj.setSource(url);
	messageObj.setCssClassMessageBox(false);
	messageObj.setSize(350,270);
	messageObj.setShadowDivVisible(false);	// Enable shadow for these boxes
	messageObj.display();

}

function closeMessage(){messageObj.close();  }


</script>

