<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 


<%String strRootPath = request.getContextPath();%>



<body class="body" style="background:#ffffff "  >

<%=f_table_head_modules(100)%>



<div style="color: red" id="datagrid"   align="center">
    <div id="idFormulario" align="center">
    
        
        
        
    <table align="center" width="70%" class="myform">

        <tr> <th class="showtitle1" colspan="2">REPORTE - ADMINISTRACI&Oacute;N DE PRODUCTOS</th></tr>
    <tr align="center">
    &nbsp;&nbsp;
    <td style="color:black">
        <form  id="formBuscar" action="mainProducto.html"  name="formBuscar" >
        <table>
            Categoria:
        <select id="status" name="categoria" onChange="this.form.submit()">

                <option value=""  selected="selected">Selecciona</option>
                
                <c:forEach items="${categorias}" var="cat">
                    
                    <option value="${cat.idCategoria}" ><c:out value="${cat.nombre}"></c:out></option>
                    
                </c:forEach>
                    
        </select>
        </table>
            </form>
        
    </td>
    <td  style="color:black">
        <form  id="formBuscar" action="mainProducto.html"  name="formBuscar" >
    <table>
    &nbsp;&nbsp;Nombre de la Producto: 
    <input type="text" class="myinput" id="productoNombre" size="40" name="productoNombre" value="">
    <c:set value="0" var="contador"></c:set>
    <c:if test="${!empty productosXcategoria}">
        <c:forEach items="${productosXcategoria}" var="pxc">
            <c:set value="${pxc.idCategoria.idCategoria}" var="catB"></c:set>
            <c:set value="${contador+1}" var="contador"></c:set>
        </c:forEach>
    <input type="hidden" value="${catB}" name="opc" >
    </c:if>
    <input  type="submit"  class="button2" value="Buscar" >&nbsp;
    </table>
        </form>
    </td>
    </tr>

    </table>
    
    </div>
    
    <table>
        <tr>
            <th>
                
                <div>
                    <a href="#" onclick='displayMessage("formProductoAdd.html","boxmessage");return false' ><img title="Nuevo" src="<%=strRootPath%>/resources/imagen/icons/i.gif"></a>
                  
                
                </div>
            </th>
        </tr>
     
    </table>
    <c:if  test="${!empty productosXcategoria}">
    <div  id="estudiante"  align="center">
    <table width="98%" class="myform" style="margin-top:10px;"  >
		 <th  class="showtitle1">
                     <b><samp>  LISTA DE PRODUCTOS </samp></b>
		 </th>
    </table>
    <table  class="myform" width="98%" id="demoTable"   >
    <thead>
         <tr>
                <th >#</th>
                <th >Categoria</th>
                <th >Producto</th>
                <th >Precio x unidad</th>
                <th >Accion</th>
                

          </tr>
    </thead>
    <tbody>

        <c:set var="i" value="1" />  
        <c:set var="i2" value="1" />
      
    <c:forEach items="${productosXcategoria}" var="resP">        
        <c:if test="${i%2==1}"> <tr bgcolor="#DAEFFE"></c:if>
        <c:if test="${i%2!=1}"> <tr></c:if>
            
            <td><c:out  value="${i}"/></td>
            
            <c:if test="${i2==1}"><td rowspan="${contador}"><c:out value="${resP.idCategoria.nombre}"/></td></c:if>
            <td><c:out value="${resP.nombre}"/></td>
            <td>S/. <c:out value="${resP.precio}"/></td>
            
            <td align="center">
                <a href="deleteProducto.html?idProducto=${resP.idProducto}" onclick="return confirm('¿Esta seguro de eliminar este producto?')"><img title="Delete" src="<%=strRootPath%>/resources/imagen/icons/delete.gif"> </a>
                <a href="#" onclick='displayMessage("formProductoEdit.html?idProducto=${resP.idProducto}","boxmessage");return false' ><img title="Edit" src="<%=strRootPath%>/resources/imagen/icons/editare.gif"></a></td>
                 
            </tr>   
    <c:set var="i" value="${i+1}"/>     
    <c:set var="i2" value="${i+1}"/>  
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

    <c:if  test="${!empty resultadoBProducto && empty productosXcategoria}">
    <div  id="estudiante"  align="center">
    <table width="98%" class="myform" style="margin-top:10px;"  >
		 <th  class="showtitle1">
			 <b><samp> LISTA DE PRODUCTOS</samp></b>
		 </th>
    </table>
    <table  class="myform" width="98%" id="demoTable"   >
    <thead>
         <tr>
                <th >#</th>
                <th >Categoria </th>
                <th >Producto </th>
                <th >Precio x unidad</th>
                <th >Accion</th>
                

          </tr>
    </thead>
    <tbody>

        <c:set var="i" value="1" />   
      
    <c:forEach items="${resultadoBProducto}" var="resP">        
        <c:if test="${i%2==1}"> <tr bgcolor="#DAEFFE"></c:if>
        <c:if test="${i%2!=1}"> <tr></c:if>
            
            <td><c:out  value="${i}"/></td>
            
            <td><c:out value="${resP.idCategoria.nombre}"/></td>
            <td><c:out value="${resP.nombre}"/></td>
            <td>S/. <c:out value="${resP.precio}"/></td>
            
            <td align="center">
                <a href="deleteProducto.html?idProducto=${resP.idProducto}" onclick="return confirm('¿Esta seguro de eliminar este producto?')"><img title="Delete" src="<%=strRootPath%>/resources/imagen/icons/delete.gif"> </a>
                <a href="#" onclick='displayMessage("formProductoEdit.html?idProducto=${resP.idProducto}","boxmessage");return false' ><img title="Edit" src="<%=strRootPath%>/resources/imagen/icons/editare.gif"></a></td>
                 
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
	messageObj.setSize(450,200);
	messageObj.setShadowDivVisible(false);	// Enable shadow for these boxes
	messageObj.display();

}

function closeMessage(){messageObj.close();  }


</script>

