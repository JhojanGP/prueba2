<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 


<%String strRootPath = request.getContextPath();%>
<body class="body" style="background:#ffffff "  >

    
<%=f_table_head_modules(100)%>

<div style="color: red" id="datagrid"   align="center">
    <div id="idFormulario" align="center">
        <form  id="formBuscar" action="mainCliente.html"  name="formBuscar" >
            
            <table align="center" width="70%" class="myform">
                <tr> <th class="showtitle1" >REPORTE - ADMINISTRACI&Oacute;N DE CATEGORIAS</th></tr>
                
                <tr align="center">
                &nbsp;&nbsp;
                    <td style="color:black">
                        <select id="status" name="variable" >

                            <option value="1" >Nombre o Razon Social</option>
                            <option value="2" >Documento</option>

                        </select>
                            <input type="text" class="myinput" size="40" name="dato" >
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
                    <a href="#" onclick='displayMessage("formClienteAdd.html","boxmessage");return false' ><img title="Nuevo" src="<%=strRootPath%>/resources/imagen/icons/i.gif"></a>
                </div>
            </th>
        </tr>
     
    </table>
         


     <c:if  test="${!empty clientes}">
    <div  id="divReporte"  align="center">
    <table width="98%" class="myform" style="margin-top:10px;"  >
		 <th  class="showtitle1">
			 <b><samp> LISTA DE CLIENTES</samp></b>
		 </th>
    </table>
    <table  class="myform" width="98%" id="demoTable"   >
    <thead>
         <tr>
                <th >#</th>
                
                <th >Documento</th>
                <th >Nombre o Razon Social</th>
                <th >Telefono</th>
                <th >Direccion</th>
                <th >Accion</th>

          </tr>
    </thead>
    <tbody>

        <c:set var="i" value="1" />   
    
    <c:forEach items="${clientes}" var="cle">        
        <c:if test="${i%2==1}"> <tr bgcolor="#DAEFFE"></c:if>
        <c:if test="${i%2!=1}"> <tr></c:if>
            
            <td><c:out  value="${i}"/></td>
            <td><c:out value="${cle.documento}"/></td>
            <td><c:out value="${cle.nombre}"/></td>
            <td><c:out value="${cle.telefonos}"/></td>
            <td><c:out value="${cle.direccion}"/></td>


            <td align="center" width="10%">
                <a href="deleteCliente.html?idCliente=${cle.idCliente}" onclick="return confirm('¿Esta seguro de eliminar esta cliente?')"><img title="Delete" src="<%=strRootPath%>/resources/imagen/icons/delete.gif"> </a>
                <a href="#" onclick='displayMessage("formClienteEdit.html?idCliente=${cle.idCliente}","boxmessage");return false' ><img title="Edit" src="<%=strRootPath%>/resources/imagen/icons/editare.gif"></a></td>
            
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
	messageObj.setSize(550,220);
	messageObj.setShadowDivVisible(false);	// Enable shadow for these boxes
	messageObj.display();

}

function closeMessage(){messageObj.close();  }


</script>

