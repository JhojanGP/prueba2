<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%String strRootPath = request.getContextPath();%>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	
	<title>Editable Invoice</title>
	<link rel='stylesheet' type='text/css' href='<%=strRootPath%>/resources/css/style_1.css' />
	<link rel='stylesheet' type='text/css' href='<%=strRootPath%>/resources/css/print.css' media="print" />
	<script type='text/javascript' src='<%=strRootPath%>/resources/js/jquery-1.3.2.min.js'></script>
	<script type='text/javascript' src='<%=strRootPath%>/resources/js/example.js'></script>

</head>

<body>
        
    <c:if test="${!empty Factura}">
	<div id="page-wrap">


		<div id="customer" >
                    <table >
                        <td  width="70%">
                            <table >
                                <tr>
                                    <td align="center" rowspan="2">logo</td>
                                    <td align="center">
                                    <h2>COMIDA MARINA CRIOLLA</h2>
                                    </td>
                                </tr>
                                
                                <tr>

                                    <td align="center">
                                    <h4>ATENCION A COMPROMISOS <br> SOCIALES Y EVENTOS ESPECIALES</h4>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Deliveri: 777000</td>
                                    
                                </tr>
                                
                                <tr>
                                    
                                    <td colspan="2">
                                    <h5>JR. CAJAMARCA NRO. 448 BARRIO CENTRAL PUNO - PUNO - PUNO</h5>
                                    </td>
                                </tr>

                            </table>
                        </td>
                        <td width="30%">

                            <table id="meta" border="1" >
                                <c:set value="${ruc}" var="r"></c:set>
                                <c:set value="${nroC}" var="n"></c:set>
                                <tr>
                                    <td class="meta-head">RUC.</td>
                                    <td ><h3 align="left"><c:out value="${r}"></c:out></h3></td>
                                </tr>
                                <tr>
                                    <td class="meta-head" colspan="2">
                                        <H1 align="center">FACTURA</H1>
                                </td>
                                </tr>
                                <tr>

                                    <td class="meta-head">001-</td>
                                    <td><h3 align="left">Nº <c:out value="${n}"></c:out></h3></td>
                                </tr>
                    

                            </table>
                        </td>
                    </table>
		</div>
                
            <table id="items" >
            
                <tr class="item-row">
                      <td>Señor(es):</td>
                      
                      <td class="description" colspan="3"><textarea><c:out value="${nom}"></c:out></textarea></td>
                      
                      <td >R.U.C.</td>
		      <td class="description" colspan="2"><textarea><c:out value="${doc}"></c:out></textarea></td>
		  </tr>
		  
		  <tr class="item-row">
                      
                      <td>Direccion:</td>
                      
                      <td class="description" colspan="3"><textarea><c:if test="${dir!='Vacio'}"><c:out value="${dir}"></c:out></c:if></textarea></td>

                      <td align="right">N°</td>
                      <td width="16%"> Guia de Remitente:</td>
                      <td class="description" colspan="4"><textarea ></textarea></td>

		  </tr>
                
                    <tr class="item-row">
                        
                        <td align="right">Nº</td>
                        <td width="38%"> de otro documento relacionado a la operacion </td>
                        <td class="description"><textarea></textarea></td>
                        <td colspan="2" align="right">Puno </td>
                        <td class="description" colspan="2">
                            <table border="0">
                                <tr class="item-row" align="center">
                                    <td class="description">
                                        <c:out value="${dia}"></c:out>
                                    </td>
                                    <td class="description">
                                        de
                                    </td>
                                    <td class="description">
                                        <c:out value="${mes}"></c:out>
                                    </td>
                                    <td class="description">
                                        del
                                    </td>
                                    <td class="description">
                                        <c:out value="${año}"></c:out>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        

                        


                    </tr>
            </table>
		
            <table id="items" border="1" >
		
		  <tr >
		      <th>CANT.</th>
		      
                      <th colspan="2">DESCRIPCION</th>

		      <th>P.UNITARIO</th>
		      <th>TOTAL</th>
		  </tr>
                  <c:set var="precioTotal" value="0"></c:set>
                    <c:forEach items="${Factura}" var="fac">
                        
                    
                        <tr class="item-row" >

                            <td align="center"><c:out value="${fac.cantidadProducto}"></c:out></td>
                            
                            <td colspan="2"><c:out value="${fac.idProducto.idCategoria.nombre}-${fac.idProducto.nombre}"></c:out></td>
                            
                            <td align="center">S/. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
                                              value="${fac.idProducto.precio}">
                                                   </fmt:formatNumber></td>
                            <td align="center">S/. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" 
                                              value="${fac.idProducto.precio*fac.cantidadProducto}">
                                                   </fmt:formatNumber>
                            </td>
                        </tr>
                            <c:set value="${fac.idProducto.precio*fac.cantidadProducto+precioTotal}" var="precioTotal"></c:set>
                    </c:forEach>
                  <c:set value="${precioTotal/1.18}" var="subTotal"></c:set>
		  <tr>
                      <td align="center">SON:</td>
                      <td class="description" colspan="2"><c:out value="${fn:toUpperCase(soles)}"></c:out> SOLES
                      <c:if test="${!empty centimos}">
                          CON <c:out value="${fn:toUpperCase(centimos)}"></c:out> CENTIMOS</td>
                      </c:if>
                                                           
                      
		      <td class="total-line balance">Valor de Venta</td>
		      <td class="total-value"><div id="due">S/. 
                          <fmt:formatNumber type="number" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" value="${subTotal}"></fmt:formatNumber>
                                             </div></td>
		  </tr>
		  <tr>

		      <td colspan="3" class="blank" align="center">COPIA SIN DERECHO A CREDITO FISCAL </td>
                      <td class="total-line balance">IGV (%)</td>      <c:set value="${igv}" var="igv"></c:set>
                  
                      <td class="total-value">
                          <div id="due">S/.
                          <fmt:formatNumber type="number" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" value="${igv*subTotal}"></fmt:formatNumber>
                                              </div></td>
		  </tr>
		  <tr>
                      <td colspan="3" class="blank" align="center">........................................</td>
		      <td  class="total-line balance">Precio de venta</td>

                      <td class="total-value"><div id="due">S/. 
                          <fmt:formatNumber type="number" groupingUsed="false"  maxFractionDigits="1" minFractionDigits="1" value="${precioTotal}"></fmt:formatNumber>0
                      </div></td>
		  </tr>
                  
  

		</table>

	
	</div>
    </c:if>
    <c:if test="${!empty Boleta}">
    <div id="page-wrap">
        <table style="width: 250px">
            <c:set value="${ruc}" var="r"></c:set>
            <c:set value="${nroC}" var="n"></c:set>
            <c:set value="${fecha}" var="f"></c:set>
            <tr>
                <td align="center" colspan="3">
                    <h6>MAREAS CEVICHE & MAS S.C.R.L.
                        <br>
                            JR. CAJAMARCA NRO. 448 BARRIO CENTRAL PUNO - PUNO -PUNO
                        <br>
                            RUC: <c:out value="${ruc}"></c:out>
                        <br>
                            Tel. : 777000
                        </br>
                    </h6>
                </td>
            </tr>
                                
            <tr>
                <td colspan="3"  >
                    <h6>
                        FECHA: <c:out value="${f}"></c:out>
                    </h6>
                </td>
            </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
            <tr>
                <td align="center" colspan="3">
                    <h6>
                        BOLETA DE VENTA<br>
                        TICKET Nro. 001-<c:out value="${n}"></c:out>    
                    </h6>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <h6 >
                        DESCRIPCION
                    </h6>                   
                </td>
                <td align="center">
                    <h6 >
                        IMPORTE
                    </h6>                   
                </td>
            </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
            <c:set var="precioTotal" value="0"></c:set>
            <c:forEach items="${Boleta}" var="b">
                
                <tr>
                    <td align="center">
                        <h6>
                            <c:out value="${b.cantidadProducto}"></c:out>
                        </h6>
                    </td>
                    <td >
                        <h6>
                            <c:out value="${b.idProducto.idCategoria.nombre}-${b.idProducto.nombre}"></c:out>
                        </h6>
                    </td>
                        <td align="center">
                        <h6>
                            <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${b.idProducto.precio*b.cantidadProducto}"></fmt:formatNumber>
                        </h6>
                    </td>
                </tr>
                        
                
                
                <c:set value="${b.idProducto.precio*b.cantidadProducto+precioTotal}" var="precioTotal"></c:set>
            </c:forEach>
                
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
                <tr>
                    <td colspan="2" align="right">
                        <h6 >
                            TOTAL:<br>
                            REDONDEO:<br>    
                            EFECTIVO:<br>
                            VUELTO:
                        </h6>                       
                    </td>
                    <td align="center" >
                        <h6 >
                            <fmt:formatNumber type="number" groupingUsed="false" minFractionDigits="2" maxFractionDigits="2" 
                                              value="${precioTotal}" >
                            </fmt:formatNumber>
                            <br>
                                <c:out value="${redondeo}"></c:out>
                            <br>
                            <fmt:formatNumber type="number" groupingUsed="false" minFractionDigits="2" maxFractionDigits="2"
                                              value="${efectivo}"></fmt:formatNumber>
                            <br>
                            <fmt:formatNumber type="number" groupingUsed="false" minFractionDigits="1" maxFractionDigits="1"
                                              value="${efectivo-(precioTotal+redondeo)}"></fmt:formatNumber>0
                        </h6>                       
                    </td>
                
                </tr>
                <tr>
                    <td colspan="3">
                        <h6>
                            SON: <c:out value="${fn:toUpperCase(soles)}"></c:out> SOLES
                                <c:if test="${!empty centimos}">
                            CON <c:out value="${fn:toUpperCase(centimos)}"></c:out> CENTIMOS</td>
                                </c:if>
                        </h6>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                    <c:forEach items="${empleado}" var="emp">
                        <h6>
                            LE ATENDIO: <c:out value="${emp.nombre}"></c:out>
                        </h6>
                    </c:forEach>
                    </td>
                </tr>
                        
                <tr>
                    <td align="center" colspan="3">
                        <h6>
                            MAREAS CEVICHE & MAS<br>
                            GRACIAS POR SU PREFERENCIA    
                        </h6>
                    </td>
                </tr>
            
            

        </table>
    </div>
    </c:if>
    <c:if test="${!empty Ticket}">
    <div id="page-wrap">
        <table style="width: 250px">
            <c:set value="${ruc}" var="r"></c:set>

            <c:set value="${fecha}" var="f"></c:set>
            <tr>
                <td align="center" colspan="3">
                    <h6>MAREAS CEVICHE & MAS S.C.R.L.
                        <br>
                            JR. CAJAMARCA NRO. 448 BARRIO CENTRAL PUNO - PUNO -PUNO
                        <br>
                            RUC: <c:out value="${ruc}"></c:out>
                        <br>
                            Tel. : 777000
                        </br>
                    </h6>
                </td>
            </tr>
                                
            <tr>
                <td colspan="3"  >
                    <h6>
                        FECHA: <c:out value="${f}"></c:out>
                    </h6>
                </td>
            </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
            <tr>
                <td align="center" colspan="3">
                    <h6>
                        TICKET
  
                    </h6>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <h6 >
                        DESCRIPCION
                    </h6>                   
                </td>
                <td align="center">
                    <h6 >
                        IMPORTE
                    </h6>                   
                </td>
            </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
            <c:set var="precioTotal" value="0"></c:set>
            <c:forEach items="${Ticket}" var="b">
                
                <tr>
                    <td align="center">
                        <h6>
                            <c:out value="${b.cantidadProducto}"></c:out>
                        </h6>
                    </td>
                    <td >
                        <h6>
                            <c:out value="${b.idProducto.idCategoria.nombre}-${b.idProducto.nombre}"></c:out>
                        </h6>
                    </td>
                        <td align="center">
                        <h6>
                            <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${b.idProducto.precio*b.cantidadProducto}"></fmt:formatNumber>
                        </h6>
                    </td>
                </tr>
                        
                
                
                <c:set value="${b.idProducto.precio*b.cantidadProducto+precioTotal}" var="precioTotal"></c:set>
            </c:forEach>
                
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
                    <tr>
                        <td  colspan="3" style="background: url(<%=strRootPath%>/resources/imagen/icons/guion.png) repeat-x" >
                            
                        </td>
                    </tr>
                <tr>
                    <td colspan="2" align="right">
                        <h6 >
                            TOTAL:<br>
                            REDONDEO:<br>    
                            EFECTIVO:<br>
                            VUELTO:
                        </h6>                       
                    </td>
                    <td align="center" >
                        <h6 >
                            <fmt:formatNumber type="number" groupingUsed="false" minFractionDigits="2" maxFractionDigits="2" 
                                              value="${precioTotal}" >
                            </fmt:formatNumber>
                            <br>
                                <c:out value="${redondeo}"></c:out>
                            <br>
                            <fmt:formatNumber type="number" groupingUsed="false" minFractionDigits="2" maxFractionDigits="2"
                                              value="${efectivo}"></fmt:formatNumber>
                            <br>
                            <fmt:formatNumber type="number" groupingUsed="false" minFractionDigits="1" maxFractionDigits="1"
                                              value="${efectivo-(precioTotal+redondeo)}"></fmt:formatNumber>0
                        </h6>                       
                    </td>
                
                </tr>
                <tr>
                    <td colspan="3">
                        <h6>
                            SON: <c:out value="${fn:toUpperCase(soles)}"></c:out> SOLES
                                <c:if test="${!empty centimos}">
                            CON <c:out value="${fn:toUpperCase(centimos)}"></c:out> CENTIMOS</td>
                                </c:if>
                        </h6>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                    <c:forEach items="${empleado}" var="emp">
                        <h6>
                            LE ATENDIO: <c:out value="${emp.nombre}"></c:out>
                        </h6>
                    </c:forEach>
                    </td>
                </tr>
                        
                <tr>
                    <td align="center" colspan="3">
                        <h6>
                            MAREAS CEVICHE & MAS<br>
                            GRACIAS POR SU PREFERENCIA    
                        </h6>
                    </td>
                </tr>
            
            

        </table>
    </div>
    </c:if>
	
</body>


</html>