<%@ include file="/WEB-INF/control/includes.jsp" %>
<util:session validate="true" name="Session"/>
<html>
<head>
<title>Cyber Restaurant</title>
</head>

<frameset  cols='300,*'>
        
    <frame class="frame" name='menu_usuario' src='menu_Usuario.html' noresize="0" marginwidth="0"  marginheight=0 frameborder="0" scrolling="no"/>
    <frame class="frame" name='main' src='mainMesa.html' marginwidth="0"  marginheight=0 scrolling="auto"  frameborder='0'/>
    
    </frameset>

</html>
