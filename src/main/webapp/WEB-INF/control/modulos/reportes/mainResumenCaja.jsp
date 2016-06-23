<%@include file="/WEB-INF/control/includes.jsp"%>
<%@include file="/WEB-INF/control/util/utils.jsp" %> 

<body class="body" style="background:#ffffff "  >

    
<%=f_table_head_modules(100)%>

<div  id="datagrid"   align="center">


    <div  id="divReporte"  align="center">
        <table class="myform" width="98%" id="demoTable" >
            <tr>
                <td width="30%">      
                    <table align="center" width="98%" class="myform">
                        <tr > <th class="showtitle1" >INGRESOS</th></tr>
                        
                    </table>
                    
                    <table align="center" width="98%" class="myform">
                        <tr>
                            <th>Concepto</th>
                            <th>Total</th>
                        </tr>
                        <c:set  var="totalI" value="0"></c:set>
                        <c:forEach items="${movimientos}" var="mov">
                            <c:if test="${mov.idTipoMovimiento.idTipoMovimiento==1}">
                                <tr>
                                    <td>
                                        <c:out value="${mov.concepto}"></c:out>
                                    </td>
                                    <td>
                                        <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2"
                                                      value="${mov.monto}">
                                        </fmt:formatNumber>
                                    </td>
                                </tr>
                                <c:set value="${totalI+mov.monto}" var="totalI"></c:set>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <th >     

                                Total ingresos:    
                            </th>
                            <th>
                                S/. <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                  value="${totalI}">
                                    </fmt:formatNumber>
                            </th>
                        </tr>
                    </table>
       
                </td>

                <td width="70%">
                    
                    <table width="98%" class="myform" style="margin-top:10px;"  >
                        <th  class="showtitle1">
                            <b><samp> VENTAS </samp></b>
                        </th>
                 
                    </table>
    
                    <table  class="myform" width="98%" id="demoTable"   >
        
                        <thead>
                            <tr>
                                <th >#</th>
                                <th >Fecha </th>
                                <th >TipoDoc </th>
                                <th >Mesa </th>
                                <th >Mesero</th>
                                <th >Cliente</th>
                                <th >Total</th>
                
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="i" value="1" />   
                            <c:set var="totalV" value="0"></c:set>
                            <c:forEach items="${registrosCaja}" var="rc">        
                                <tr>
                                    <td><c:out  value="${i}"/></td>
                                    
                                    <td><c:out value="${rc.idCierreCaja.fecha}"/></td>
                                    <td><c:out value="${rc.idComprobante.tipo}"/></td>
                                    <td><c:out value="${rc.idPedido.idMesa.numero}"/></td>
                                    <td><c:out value="${rc.idPedido.idEmpleado.nombre}"></c:out></td>
                                    <td><c:out value="${rc.idCliente.nombre}"></c:out></td>
                                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                      value="${rc.total}">
                                            </fmt:formatNumber></td>
                                    
                                </tr>   
                                <c:set value="${totalV+rc.total}" var="totalV"></c:set>
                            <c:set var="i" value="${i+1}"/>              
    
                            </c:forEach>    
                                
                        </tbody>
                        
                        
                    </table>
                </td>
        
            </tr>
            <tr>
                <td width="30%">      
                    <table align="center" width="98%" class="myform">
                        <tr > <th class="showtitle1" >EGRESOS</th></tr>
                        
                    </table>
                    
                    <table align="center" width="98%" class="myform">
                        <tr>
                            <th>Concepto</th>
                            <th>Total</th>
                        </tr>
                        <c:set  var="totalE" value="0"></c:set>
                        <c:forEach items="${movimientos}" var="mov">
                            <c:if test="${mov.idTipoMovimiento.idTipoMovimiento==2}">
                                <tr>
                                    <td>
                                        <c:out value="${mov.concepto}"></c:out>
                                    </td>
                                    <td>
                                        <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2"
                                                      value="${mov.monto}">
                                        </fmt:formatNumber>
                                    </td>
                                </tr>
                                <c:set value="${totalI+mov.monto}" var="totalE"></c:set>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <th >     

                                Total egresos:    
                            </th>
                            <th>
                                S/. <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                  value="${totalE}">
                                    </fmt:formatNumber>
                            </th>
                        </tr>
                    </table>
       
                </td>
                <td width="70%">
                    
                    <table width="98%" class="myform">
                        
                        <tr>
                            <td align="right" >
                                Total Ventas
                            </td>
                            <td >
                                S/. <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                          value="${totalV}">
                                    </fmt:formatNumber>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                Total Ingresos
                            </td>
                            <td >
                                S/. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
                                          value="${totalI}">
                                    </fmt:formatNumber>
                            </td>
                            <td align="right">
                                Total en Caja
                            </td>
                            <td >
                                S/. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
                                              value="${totalV+totalI-totalE}">
                                    </fmt:formatNumber>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                Total Egresos
                            </td>
                            <td >
                                S/. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
                                          value="${totalE}">
                                    </fmt:formatNumber>
                            </td>
                        </tr>
                 
                    </table>
                </td>
            </tr>

        </table>
       
    </div>
  
     
    
</div>
       
<%=f_table_foot_modules()%>

</body>



