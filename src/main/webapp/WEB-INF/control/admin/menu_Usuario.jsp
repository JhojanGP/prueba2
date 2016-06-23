<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 


<%String strRootPath = request.getContextPath();%>
<body class="body" style="background:#ffffff "  >

    
<%=f_table_head_modules(100)%>

<div  id="datagrid"   align="center">
    
    

   
    <div  id="divReporte"  >
        
    <table border="0"  width="100%"    >
        
        <thead>
            
            <tr>
               <td><img border="0" src="<%=strRootPath%>/resources/imagen/img/logo_cev_f.png" width="250" height="150"></td>
            </tr>
            
        </thead>
    <tbody>
        <tr>
               <td><img border="0" src="<%=strRootPath%>/resources/imagen/photos/ceviche.jpg" width="250" height="150"></td>
        </tr>
    </tbody>
    
    <tfoot>
        <tr>
            
            <td align="center">
                <a href="logout.html" ><img  src="<%=strRootPath%>/resources/imagen/buttons/salir.jpg"></a>
            </td>
        </tr>
    </tfoot>

    </table>
    </div>
    
     
    
</div>
<%=f_table_foot_modules()%>



</body>



