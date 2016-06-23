<html>
<head>
	<title>Logout</title>
	<script src="../resources/js/js.js" type="text/javascript"></script>
</head>

<body onLoad="selfp()">
<meta http-equiv="Refresh" content="1; URL=../index.html">
<h3>Cerrando sesión</h3>

<% HttpSession hs = request.getSession(false);	
hs.invalidate();
%>
</body>
</html>

<HTML>

</BODY>
</HTML>
<script language="JavaScript">
	caducarPagina(true);
	function caducarPagina(on){
    	window.onbeforeunload = (on) ? cargarPagina : null;
	}
	function cargarPagina(){
  		window.location.href="../../";
		//navigator.ClearHistory;
  		caducarPagina(false);
	}
	function click(){
		if (event.button==2){
			window.close() ; 
		}
	}
	document.onmousedown=click
</script>
<%--
<script>if( window!=window.top) top.location.href=location.href;</script>--%>

<script>
function selfp() 
{

 if (self.parent.frames.length != 0) self.parent.location=document.location.href; 
}
function click(){
	if (event.button==2){
		window.close() ; 
	}
}

</script>